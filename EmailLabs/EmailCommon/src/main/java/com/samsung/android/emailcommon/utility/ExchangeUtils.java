/* * Copyright (C) 2010 The Android Open Source Project * * Licensed under the Apache License, Version 2.0 (the "License"); * you may not use this file except in compliance with the License. * You may obtain a copy of the License at * *      http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable law or agreed to in writing, software * distributed under the License is distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. * See the License for the specific language governing permissions and * limitations under the License. */package com.samsung.android.emailcommon.utility;import com.samsung.android.emailcommon.EmailPackage;import com.samsung.android.emailcommon.IntentConst;import com.samsung.android.emailcommon.service.EmailServiceProxy;import com.samsung.android.emailcommon.service.IEmailService;import com.samsung.android.emailcommon.utility.EmailLog;import android.content.ComponentName;import android.content.Context;import android.content.Intent;/** * Utility functions for Exchange support. */public class ExchangeUtils {        public static String TAG = "ExchangeUtils";            /**     * Starts the service for Exchange, if supported.     */    public static void startExchangeService(Context context) {        // EXCHANGE-REMOVE-SECTION-START        // WTL_EDM_START        try {            context.startService(new Intent(IntentConst.EXCHANGE_INTENT)            .setComponent(new ComponentName(EmailPackage.PKG_PROVIDER,                    EmailPackage.EasService)));        } catch (Exception e) {            e.printStackTrace();        }        // WTL_EDM_END        // EXCHANGE-REMOVE-SECTION-END    }    public static void stopExchangeService(Context context) {        // EXCHANGE-REMOVE-SECTION-START        try {            context.stopService(new Intent(IntentConst.EXCHANGE_INTENT)            .setComponent(new ComponentName(EmailPackage.PKG_PROVIDER,                    EmailPackage.EasService)));        } catch (Exception e) {            EmailLog.e(TAG, "Exception when trying to stop exchange service" +                    " exception = " +e.getMessage());            e.printStackTrace();        }        // EXCHANGE-REMOVE-SECTION-END    }    /**     * Returns an {@link IEmailService} for the Exchange service, if supported.     * Otherwise it'll return an empty {@link IEmailService} implementation.     *     * @param context     * @param callback Object to get callback, or can be null     *///    public static IEmailService getExchangeService(Context context, IEmailServiceCallback callback) {//        IEmailService ret = null;//        // EXCHANGE-REMOVE-SECTION-START////        ret = new EmailServiceProxy(context, IntentConst.EXCHANGE_INTENT, callback);////        // EXCHANGE-REMOVE-SECTION-END////        return ret;//    }//    public static boolean isExchangeAvailable(Context context) {        return EmailServiceProxy.getEasProxy(context, null).test();    }    /**     * Enable calendar sync for all the existing exchange accounts, and post a     * notification if any.     *///    public static void enableEasCalendarSync(Context context) {////        // EXCHANGE-REMOVE-SECTION-START////////        // new CalendarSyncEnabler(context).enableEasCalendarSync();////        // EXCHANGE-REMOVE-SECTION-END////    }}