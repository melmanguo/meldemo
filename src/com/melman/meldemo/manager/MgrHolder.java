package com.melman.meldemo.manager;


public class MgrHolder
{

	private static DataListenerManager mDataListenerManager;
	private static DBManager mDbManager;

	public static void initialize()
	{
		mDataListenerManager = new DataListenerManager();
		mDbManager = new DBManager();
	}

	public static void clean()
	{

	}

	public static DBManager DBManager()
	{
		return mDbManager;
	}

	public static DataListenerManager DataListenerManager()
	{
		return mDataListenerManager;
	}

}
