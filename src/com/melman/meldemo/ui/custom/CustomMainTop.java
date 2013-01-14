package com.melman.meldemo.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melman.meldemo.R;
import com.melman.meldemo.util.MelUtil;

public class CustomMainTop extends RelativeLayout
{
	private static final int TEXT_MAX_LENGTH = 8;
	Button leftBtn;
	Button rightBtn;
	TextView centerType;

	public CustomMainTop(Context context)
	{
		super(context);
		init(context);
	}

	public CustomMainTop(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context);
	}

	private void init(Context context)
	{
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mInflater.inflate(R.layout.custom_main_top, this);
		findView();
	}

	private void findView()
	{
		leftBtn = (Button) findViewById(R.id.custom_main_top_left_btn);
		centerType = (TextView) findViewById(R.id.custom_main_top_center_textview);
		rightBtn = (Button) findViewById(R.id.custom_mail_top_right_btn);
	}

	public void setCenterText(int resid)
	{
		centerType.setText(MelUtil.subString(getContext().getResources().getText(resid), TEXT_MAX_LENGTH));
	}

	public void setLeftBtnText(int resId)
	{
		leftBtn.setText(resId);
	}

	public void setRightBtnText(int resId)
	{
		rightBtn.setText(resId);
	}

	public void setLeftBtnVisiable(int visiable)
	{
		leftBtn.setVisibility(visiable);
	}

	public void setRightBtnVisiable(int visiable)
	{
		rightBtn.setVisibility(visiable);
	}
}
