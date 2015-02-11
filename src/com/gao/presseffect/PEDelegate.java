package com.gao.presseffect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PEDelegate {
	private static final int MASK_COLOR = 0x22000000;
	private static final Paint paint = new Paint();
	{
		paint.setColor(MASK_COLOR);
	}
	private final View v;
	// package-private
	int shape;
	// package-private
	int roundSize;

	public PEDelegate(View v) {
		this.v = v;
	}

	public void read(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PressEffect, defStyleAttr, defStyleRes);
		shape = a.getInt(R.styleable.PressEffect_peShape, shape);
		roundSize = a.getDimensionPixelSize(R.styleable.PressEffect_peRoundSize, 0);
		a.recycle();
	}

	private final RectF rect = new RectF();

	public void draw(Canvas canvas) {
		if (!v.isPressed()) {
			return;
		}
		// rect.left = 0;
		// rect.top = 0;
		rect.right = v.getWidth();
		rect.bottom = v.getHeight();
		switch (shape) {
		case 0: {
			canvas.drawRect(rect, paint);
			break;
		}
		case 1: {
			canvas.drawRoundRect(rect, roundSize, roundSize, paint);
			break;
		}
		case 2: {
			canvas.drawOval(rect, paint);
			break;
		}
		}
	}

	/**
	 * @return the shape
	 */
	public int getShape() {
		return shape;
	}

	/**
	 * @param shape
	 *            the shape to set
	 */
	public void setShape(int shape) {
		this.shape = shape;
	}

	/**
	 * @return the roundSize
	 */
	public int getRoundSize() {
		return roundSize;
	}

	/**
	 * @param roundSize
	 *            the roundSize to set
	 */
	public void setRoundSize(int roundSize) {
		this.roundSize = roundSize;
	}
}
