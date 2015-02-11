package com.gao.presseffect.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.gao.presseffect.PEDelegate;

@SuppressLint("NewApi")
public class PELinearLayout extends LinearLayout {
	private final PEDelegate peDelegate = new PEDelegate(this);
	{
		setWillNotDraw(false);
	}

	public PEDelegate getDelegate() {
		return peDelegate;
	}

	public PELinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		peDelegate.read(context, attrs, defStyleAttr, defStyleRes);
	}

	public PELinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		peDelegate.read(context, attrs, defStyleAttr, 0);
	}

	public PELinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		peDelegate.read(context, attrs, 0, 0);
	}

	public PELinearLayout(Context context) {
		super(context);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		peDelegate.draw(canvas);
	}
}
