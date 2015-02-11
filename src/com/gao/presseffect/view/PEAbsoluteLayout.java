package com.gao.presseffect.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;

@SuppressLint("NewApi")
public class PEAbsoluteLayout extends AbsoluteLayout {
	private Paint paint;
	{
		paint = new Paint();
		paint.setColor(0x22000000);
		setWillNotDraw(false);
	}

	public PEAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public PEAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public PEAbsoluteLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PEAbsoluteLayout(Context context) {
		super(context);
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		if (isPressed()) {
			RectF mRectF = new RectF(0, 0, getWidth(), getHeight());
			canvas.drawRect(mRectF, paint);
		}
	}

	@Override
	public void setPressed(boolean pressed) {
		super.setPressed(pressed);
		invalidate();
	}
}
