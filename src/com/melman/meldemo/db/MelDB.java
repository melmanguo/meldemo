package com.melman.meldemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.melman.meldemo.constant.DBConstant;

public class MelDB extends SQLiteOpenHelper
{
	private SQLiteDatabase _mdb;
	private String _dbName;
	private String[] _createTableSqls;

	public MelDB(Context context, String name, String[] createTableSqls)
	{
		super(context, name, null, DBConstant.DB_VERSION);
		_dbName = name;
		_createTableSqls = createTableSqls;
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		_mdb = db;
		createTables();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		_mdb = db;
		if (newVersion > oldVersion)
		{
			updateDBVersion();
		}
		else
		{
			createTables();
		}
	}

	public void create(String sql)
	{
		getWritableDatabase().execSQL(sql);
	}

	public void drop(String tableName)
	{
		String sql = DBConstant.DROPTABLE + tableName;
		getWritableDatabase().execSQL(sql);
	}

	public void close()
	{
		if (_mdb != null)
		{
			_mdb.close();
		}
		this.close();
	}

	private void createTables()
	{
		for (String sql : _createTableSqls)
			_mdb.execSQL(sql);
	}

	private void updateDBVersion()
	{
		System.out.println(_dbName);
	}

	public Cursor query(String sql)
	{
		return this.getWritableDatabase().rawQuery(sql, null);
	}
}
