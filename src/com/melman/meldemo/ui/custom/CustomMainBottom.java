package com.melman.meldemo.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melman.meldemo.R;
import com.melman.meldemo.util.MelUtil;

public class CustomMainBottom extends RelativeLayout
{
	private static final int TEXT_MAX_LENGTH = 8;
	Button rightBtn;
	TextView centerType;

	public CustomMainBottom(Context context)
	{
		super(context);
		init(context);
	}

	public CustomMainBottom(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context);
	}

	private void init(Context context)
	{
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.custom_main_bottom, this);
		findView();
	}

	private void findView()
	{
		centerType = (TextView) findViewById(R.id.custom_main_bottom_center_textview);
		rightBtn = (Button) findViewById(R.id.custom_mail_bottom_right_btn);
	}

	public void setCenterText(int resid)
	{
		centerType.setText(MelUtil.subString(getContext().getResources().getText(resid), TEXT_MAX_LENGTH));
	}

	public void setCenterText(String str)
	{
		centerType.setText(str);
	}

	public void setRightBtnText(int resId)
	{
		rightBtn.setText(resId);
	}

	public void setRightBtnVisiable(int visiable)
	{
		rightBtn.setVisibility(visiable);
	}
}
