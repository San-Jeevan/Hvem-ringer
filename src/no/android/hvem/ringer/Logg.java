package no.android.hvem.ringer;

import android.util.Log;

public class Logg {
	public static final boolean DEBUG = true;
	private static final String LOG_TAG = "HvemRinger";
	
	public static void v(String message){
		if(DEBUG) Log.d(LOG_TAG, message);
	}

    public static void d(String message){
   		if(DEBUG) Log.d(LOG_TAG, message);
   	}

	public static void w(String message){
		Log.w(LOG_TAG, message);
	}
	
	public static void e(String message){
		Log.e(LOG_TAG, message);
	}

	public static void e(String message, Throwable e) {
		Log.e(LOG_TAG, message, e);
	}
}
