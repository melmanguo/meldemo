package com.melman.meldemo;

import android.app.Application;

import com.melman.meldemo.manager.MgrHolder;

public class MelApp extends Application
{
	private static MelApp _instance;

	public static MelApp instance()
	{
		return _instance;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		_instance = this;
		MgrHolder.initialize();

		TestData.initialize();
		for (int i = 0; i < 10; i++)
			TestData.instance().newMailComing(3000);
	};

	@Override
	public void onTerminate()
	{
		super.onTerminate();
		_instance = null;
	}
}
