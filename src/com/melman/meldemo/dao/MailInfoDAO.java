package com.melman.meldemo.dao;

import java.util.ArrayList;

import android.database.Cursor;

import com.melman.meldemo.constant.DBConstant;
import com.melman.meldemo.entity.MailListInfo;
import com.melman.meldemo.manager.MgrHolder;

public class MailInfoDAO
{
	public static final String TABLE_NAME = "mailinfo";
	public static final String ID = "id";
	public static final String KEY = "key";
	public static final String FROM = "f";
	public static final String SUBJECT = "subject";
	public static final String TIME = "receivetime";
	public static final String PREVIEW = "preview";

	private static final String INSERT_NEW_MAIL_BASE = "INSERT INTO mailinfo('key','f','subject','receivetime','preview') values('";

	private static final String SELECT_MAIL_LIST = "SELECT id,key,f,subject,receivetime,preview FROM mailinfo ORDER BY receivetime DESC";

	public static String createSQL()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(DBConstant.CREATE).append(TABLE_NAME).append(DBConstant.BRACKET_LEFT);
		sb.append(ID).append(DBConstant.INTEGER).append(DBConstant.PRIMARY_KEY).append(DBConstant.AUTOINCREMENT).append(DBConstant.Comma);
		sb.append(KEY).append(DBConstant.TEXT).append(DBConstant.Comma);
		sb.append(FROM).append(DBConstant.TEXT).append(DBConstant.Comma);
		sb.append(SUBJECT).append(DBConstant.TEXT).append(DBConstant.Comma);
		sb.append(TIME).append(DBConstant.INT64).append(DBConstant.Comma);
		sb.append(PREVIEW).append(DBConstant.TEXT).append(DBConstant.BRACKET_RIGHT).append(DBConstant.SEMICOLON);
		return sb.toString();
	}

	public static MailListInfo getMailInfo(Cursor cursor)
	{
		MailListInfo info = new MailListInfo();
		info.setId(cursor.getInt(cursor.getColumnIndex(ID)));
		info.setKey(cursor.getString(cursor.getColumnIndex(KEY)));
		info.setFrom(cursor.getString(cursor.getColumnIndex(FROM)));
		info.setSubject(cursor.getString(cursor.getColumnIndex(SUBJECT)));
		info.setTime(cursor.getLong(cursor.getColumnIndex(TIME)));
		info.setPreview(cursor.getString(cursor.getColumnIndex(PREVIEW)));
		return info;
	}

	public static void insert(MailListInfo info)
	{
		String sql = new StringBuilder().append(INSERT_NEW_MAIL_BASE).append(info.getKey()).append(DBConstant.INSERT_INNER).append(info.getFrom()).append(DBConstant.INSERT_INNER).append(info.getSubject()).append(DBConstant.INSERT_INNER).append(info.getTime()).append(DBConstant.INSERT_INNER).append(info.getPreview()).append(DBConstant.INSERT_END).toString();
		MgrHolder.DBManager().getMelDB().getWritableDatabase().execSQL(sql);
	}

	public static ArrayList<MailListInfo> get()
	{
		ArrayList<MailListInfo> infos = new ArrayList<MailListInfo>();
		Cursor cursor = MgrHolder.DBManager().getMelDB().query(SELECT_MAIL_LIST);
		try
		{
			while (cursor.moveToNext())
			{
				infos.add(getMailInfo(cursor));
			}
		}
		finally
		{
			cursor.close();
		}
		return infos;
	}

}
