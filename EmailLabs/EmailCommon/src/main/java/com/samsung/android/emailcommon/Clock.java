package com.samsung.android.emailcommon;


public class Clock {
	public static final Clock INSTANCE = new Clock();

    protected Clock() {
    }

    public long getTime() {
        return System.currentTimeMillis();
    }
}
