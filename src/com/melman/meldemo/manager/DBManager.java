package com.melman.meldemo.manager;

import com.melman.meldemo.MelApp;
import com.melman.meldemo.constant.DBConstant;
import com.melman.meldemo.dao.MailInfoDAO;
import com.melman.meldemo.db.MelDB;

public class DBManager
{
	private MelDB _maindb;

	public DBManager()
	{
		init();
	}

	private void init()
	{
		String[] createTableSqls = new String[]{
				MailInfoDAO.createSQL()
		};
		_maindb = new MelDB(MelApp.instance().getApplicationContext(), DBConstant.DB_NAME, createTableSqls);
	}

	public MelDB getMelDB()
	{
		return _maindb;
	}
}
