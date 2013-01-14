package com.melman.meldemo.ui.mail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.melman.meldemo.R;
import com.melman.meldemo.data.DataListener;
import com.melman.meldemo.data.ListenerId;
import com.melman.meldemo.entity.MailListInfo;
import com.melman.meldemo.manager.MgrHolder;
import com.melman.meldemo.ui.BaseActivity;
import com.melman.meldemo.ui.custom.CustomMainBottom;
import com.melman.meldemo.ui.custom.CustomMainTop;
import com.melman.meldemo.util.MelUtil;

public class MailListActivity extends BaseActivity implements DataListener, OnItemClickListener
{
	private static final String TAG = MailContentActivity.class.getSimpleName();

	public static final int TYPE_INSERT = 0;
	public static final int TYPE_DELETE = 1;
	public static final int TYPE_UPDATE = 2;

	ListView mListView;
	MailListAdapter mAdapter;
	CustomMainTop mTop;
	CustomMainBottom mBottom;
	private static Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maillist);
		findView();
		MgrHolder.DataListenerManager().register(ListenerId.MAIL_LIST_DATA_CHANGE, this);
	}

	private void findView()
	{
		mListView = (ListView) findViewById(R.id.maillist_listview);
		mAdapter = new MailListAdapter(this);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
		mTop = (CustomMainTop) findViewById(R.id.maillist_top);
		mTop.setCenterText(R.string.maillist_top_center_text);
		mTop.setLeftBtnText(R.string.maillist_top_leftbtn_text);
		mTop.setRightBtnText(R.string.maillist_top_rightbtn_text);
		mBottom = (CustomMainBottom) findViewById(R.id.maillist_bottom);
		mBottom.setCenterText(MelUtil.getTimeString(System.currentTimeMillis()));
		mBottom.setRightBtnText(R.string.maillist_bottom_rightbtn_text);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		Log.i(TAG, "item click--position:" + position + "-id:" + id);
		MailListInfo info = mAdapter.get(position);
		Intent it = new Intent();
		it.setClass(this, MailContentActivity.class);
		it.putExtra(MailContentActivity.MAIL_ID, info.getId());
		startActivity(it);
	}

	@Override
	public void onDataChanged(int type, Object obj)
	{
		switch (type)
		{
		case TYPE_INSERT:
			mAdapter.append((MailListInfo) obj);
			break;
		case TYPE_DELETE:
			mAdapter.remove((Integer) obj);
		default:
			break;
		}
		mHandler.post(notifyDataSetChanged);
	}

	private Runnable notifyDataSetChanged = new Runnable()
	{
		@Override
		public void run()
		{
			if (mAdapter != null)
			{
				mAdapter.notifyDataSetChanged();
			}
		}
	};
}
