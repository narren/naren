/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samsung.android.emailcommon.utility;

import android.os.Environment;

import com.samsung.android.emailcommon.system.CarrierValues;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class FileLogger {
    private static FileLogger LOGGER = null;

    private static FileWriter sLogWriter = null;

    public static String LOG_FILE_NAME = Environment.getExternalStorageDirectory()
            + "/emaillog.txt";
			
    private static File file = new File(LOG_FILE_NAME);

    private FileLogger() {
        try {
            file = file.getAbsoluteFile();
            sLogWriter = new FileWriter(file.getAbsolutePath(), true);
        } catch (IOException e) {
            // Doesn't matter
        }
    }

    static public synchronized void close() {
        if (sLogWriter != null) {
            try {
                sLogWriter.close();
            } catch (IOException e) {
                // Doesn't matter
            }
            sLogWriter = null;
            LOGGER = null;
        }
    }

    static public synchronized void log(Throwable e) {
        if (sLogWriter != null) {
            log("Exception", "Stack trace follows...");
            PrintWriter pw = new PrintWriter(sLogWriter);
            e.printStackTrace(pw);
            pw.flush();
            // ysh1380 prevent 107686 start
            pw.close();
            // ysh1380 prevent 107686 end
        }
    }

    @SuppressWarnings("deprecation")
    static public synchronized void log(String prefix, String str) {
        try {
            if (LOGGER == null || (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) 
                && !file.exists())) {
                LOGGER = new FileLogger();
                if (sLogWriter != null) {
                    try {
                        sLogWriter.write("Logger \r\n");
                        sLogWriter.write("Logger     -------------- New Log --------------\r\n");
                        sLogWriter.write("Logger     Model      :" + CarrierValues.PRODUCT_MODEL + "\r\n");
                        sLogWriter.write("Logger     Build      :" + CarrierValues.BUILD_PDA + "\r\n");
                        sLogWriter.write("Logger     ChangeList :" + CarrierValues.BUILD_CHANGELIST + "\r\n");
                        sLogWriter.write("Logger     -------------------------------------\r\n");
                        sLogWriter.flush();
                    } catch (IOException e) {
                        // Something might have happened to the sdcard
                        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                            // If the card is mounted and we can create the writer,
                            // retry
                            LOGGER = new FileLogger();
                        }
                    }
                }
            }
            Calendar c = Calendar.getInstance();
            int date   = c.get(Calendar.DATE);
            int month  = c.get(Calendar.MONTH) + 1; // Calendar returns month number from range 0-11
            int year   = c.get(Calendar.YEAR);
            int hr = c.get(Calendar.HOUR_OF_DAY);
            int min    = c.get(Calendar.MINUTE);
            int sec    = c.get(Calendar.SECOND);
            int mSec   = c.get(Calendar.MILLISECOND);
            
            // I don't use DateFormat here because (in my experience), it's much
            // slower
            StringBuffer sb = new StringBuffer(256);

            sb.append(year);
            sb.append('-');
            
            if (month < 10) {
            	sb.append('0');
            }
            
            sb.append(month);
            sb.append('-');
            
            if (date < 10) {
            	sb.append('0');
            }
            
            sb.append(date);
            sb.append(" ");

            sb.append(hr);
            
            sb.append(':');
            
            if (min < 10) {
                sb.append('0');
            }
            
            sb.append(min);
            sb.append(':');
            
            if (sec < 10) {
                sb.append('0');
            }
            sb.append(sec);
            sb.append(':');
            
            if (mSec < 10) {
                sb.append("00");
            }
            else if (mSec <100) {
                sb.append('0');
            }
            
            sb.append(mSec);

            sb.append(" ");
            sb.append (android.os.Process.myPid());
            sb.append (" ");
            sb.append (android.os.Process.myTid());
            sb.append (" [");
            sb.append (Thread.currentThread().getName());
            sb.append ("] ");
            
            if (prefix != null) {
                sb.append(prefix);
                sb.append("| ");
            }
            sb.append(str);
            sb.append("\r\n");
            String s = sb.toString();

            if (sLogWriter != null) {
                try {
                    sLogWriter.write(s);
                    sLogWriter.flush();
                } catch (IOException e) {
                    // Something might have happened to the sdcard
                    if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                        // If the card is mounted and we can create the writer,
                        // retry
                        LOGGER = new FileLogger();
                    }
                }
            }
    	} catch (Exception e2) {
        	// Nothing to do at this point
    		// If the sdcard is not ready to be read or any other file access error
        }
    }
}
