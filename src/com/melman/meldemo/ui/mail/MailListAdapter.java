package com.melman.meldemo.ui.mail;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.melman.meldemo.R;
import com.melman.meldemo.dao.MailInfoDAO;
import com.melman.meldemo.entity.MailListInfo;
import com.melman.meldemo.util.MelUtil;

public class MailListAdapter extends BaseAdapter
{
	private LayoutInflater mInflater;
	private ArrayList<MailListInfo> _datas;
	private int _length;

	public MailListAdapter(Context context)
	{
		mInflater = LayoutInflater.from(context);
		initData();
	}

	public void initData()
	{
		// _datas = new ArrayList<MailListInfo>();
		// for (int i = 0; i < 20; i++)
		// _datas.add(new MailListInfo(false, "melman" + i,
		// System.currentTimeMillis(), "mail from melman_" + i,
		// "nothing, just miss you!"));

		_datas = MailInfoDAO.get();
		_length = _datas.size();
	}

	@Override
	public int getCount()
	{
		return _length;
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView == null)
		{
			convertView = mInflater.inflate(R.layout.view_mail_list_item, null);
			holder = new ViewHolder();
			holder.newIncome = (ImageView) convertView.findViewById(R.id.view_mail_list_item_new);
			holder.newIncome.setImageResource(R.drawable.ic_new_mail_coming);
			holder.from = (TextView) convertView.findViewById(R.id.view_mail_list_item_from);
			holder.time = (TextView) convertView.findViewById(R.id.view_mail_list_item_time);
			holder.subject = (TextView) convertView.findViewById(R.id.view_mail_list_item_subject);
			holder.preview = (TextView) convertView.findViewById(R.id.view_mail_list_item_preview);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		MailListInfo data = _datas.get(position);
		holder.from.setText(data.getFrom());
		holder.time.setText(MelUtil.getTimeString(data.getTime()));
		holder.subject.setText(data.getSubject());
		holder.preview.setText(data.getPreview());
		if (data.isNew())
		{
			holder.newIncome.setVisibility(View.VISIBLE);
		}
		else
		{
			holder.newIncome.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}

	static class ViewHolder
	{
		ImageView newIncome;
		TextView from;
		TextView time;
		TextView subject;
		TextView preview;
	}

	public void append(MailListInfo info)
	{
		_datas.add(info);
		_length++;
	}

	public void remove(int indexOfArray)
	{
		_datas.remove(indexOfArray);
		_length--;
	}

	public MailListInfo get(int positionOfView)
	{
		return (MailListInfo) _datas.get(positionOfView);
	}
}
