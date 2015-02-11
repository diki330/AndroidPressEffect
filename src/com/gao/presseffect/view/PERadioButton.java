package com.gao.presseffect.view;

import com.gao.presseffect.PEDelegate;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RadioButton;

@SuppressLint("NewApi")
public class PERadioButton extends RadioButton {
	private final PEDelegate peDelegate = new PEDelegate(this);

	public PEDelegate getDelegate() {
		return peDelegate;
	}

	public PERadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		peDelegate.read(context, attrs, defStyleAttr, defStyleRes);
	}

	public PERadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		peDelegate.read(context, attrs, defStyleAttr, 0);
	}

	public PERadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		peDelegate.read(context, attrs, 0, 0);
	}

	public PERadioButton(Context context) {
		super(context);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		peDelegate.draw(canvas);
	}
}
