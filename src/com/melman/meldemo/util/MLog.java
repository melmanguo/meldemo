package com.melman.meldemo.util;

import android.util.Log;

public class MLog
{
	public static final int LOG_LEVEL = 0;
	public static final int LEVEL_ERROR = 40;

	public static void e(String tag, String msg)
	{
		if (LOG_LEVEL < LEVEL_ERROR)
			Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable tr)
	{
		if (LOG_LEVEL < LEVEL_ERROR)
			Log.e(tag, msg, tr);
	}

	public static void i(String tag, String msg)
	{
		if (LOG_LEVEL < LEVEL_ERROR)
			Log.i(tag, msg);
	}

	public static void i(String tag, String msg, Throwable tr)
	{
		if (LOG_LEVEL < LEVEL_ERROR)
			Log.e(tag, msg, tr);
	}
}
