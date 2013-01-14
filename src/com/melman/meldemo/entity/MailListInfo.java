package com.melman.meldemo.entity;

public class MailListInfo
{

	private int id;
	private String key;
	private String from;
	private long time;
	private String subject;
	private String preview;
	private boolean isNew;

	public MailListInfo()
	{

	}

	public MailListInfo(boolean isNew, String from, long time, String subject, String preview)
	{
		this.isNew = isNew;
		this.from = from;
		this.time = time;
		this.subject = subject;
		this.preview = preview;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getPreview()
	{
		return preview;
	}

	public void setPreview(String preview)
	{
		this.preview = preview;
	}

	public boolean isNew()
	{
		return isNew;
	}

	public void setNew(boolean isNew)
	{
		this.isNew = isNew;
	}

}
