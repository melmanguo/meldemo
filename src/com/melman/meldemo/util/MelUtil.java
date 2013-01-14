package com.melman.meldemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

public class MelUtil
{
	public static final String ELLIPSES = "...";

	public static final String subString(CharSequence originString, int lengthWanted)
	{
		// if (lengthWanted > originString.length())
		// {
		// return originString.toString().substring(0, lengthWanted) + ELLIPSES;
		// }
		return originString.toString();
	}

	@SuppressLint("SimpleDateFormat")
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final String getTimeString(long time)
	{
		return dateFormat.format(new Date(time));
	}
}
