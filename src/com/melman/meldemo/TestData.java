package com.melman.meldemo;

import java.util.concurrent.atomic.AtomicInteger;

import android.os.Handler;
import android.os.Looper;

import com.melman.meldemo.dao.MailInfoDAO;
import com.melman.meldemo.data.ListenerId;
import com.melman.meldemo.entity.MailListInfo;
import com.melman.meldemo.manager.MgrHolder;
import com.melman.meldemo.ui.mail.MailListActivity;

public class TestData
{
	private static TestData _instance;

	public static void initialize()
	{
		_instance = new TestData();
	}

	public static TestData instance()
	{
		return _instance;
	}

	Handler mHandler;

	public TestData()
	{
		mHandler = new Handler(Looper.getMainLooper());
	}

	static AtomicInteger ati = new AtomicInteger();
	Runnable newMail = new Runnable()
	{
		@Override
		public void run()
		{
			MailListInfo info = new MailListInfo(true, "melman", System.currentTimeMillis(), "来自Melman的邮件" + ati.getAndIncrement(), "未下载");
			MailInfoDAO.insert(info);
			MgrHolder.DataListenerManager().dataChanged(ListenerId.MAIL_LIST_DATA_CHANGE, MailListActivity.TYPE_INSERT, info);
		}
	};

	public void newMailComing(int times)
	{
		mHandler.postDelayed(newMail, times);
	}
}
