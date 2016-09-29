package com.wormhole.carousel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 
 * <p>
 * 自定义 ImageView
 * <p>
 * 继承自LinerLayout 使用时直接new MyImageView <br>
 * 动态添加到view中container.addView(mImageView)<br>
 * container 是一个布局<br>
 * setImageSource(Bitmap bitmap) 向MyImageView添加一个bitmap
 *
 * @author Tiny
 * @version 1.0
 */
public class MyImageView extends LinearLayout {
	
	private ImageView mImageViewLeft;
	private ImageView mImageViewRight;

	public MyImageView(Context context) {
		super(context);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);

		LayoutParams localLayoutParams = new LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		localLayoutParams.weight = 1;

		this.mImageViewLeft = new ImageView(context, null);
		this.mImageViewLeft.setLayoutParams(localLayoutParams);
		this.mImageViewLeft.setScaleType(ImageView.ScaleType.MATRIX);
		addView(mImageViewLeft);

		this.mImageViewRight = new ImageView(context, null);
		this.mImageViewRight.setLayoutParams(localLayoutParams);
		this.mImageViewRight.setScaleType(ImageView.ScaleType.MATRIX);
		addView(mImageViewRight);
	}

	public void setImageSource(Bitmap bitmap) {
		this.mImageViewLeft.setImageBitmap(bitmap);
		this.mImageViewRight.setImageBitmap(bitmap);
	}

	public void setImageDrawable(Drawable imageSourceId) {
		this.mImageViewLeft.setImageDrawable(imageSourceId);
		this.mImageViewRight.setImageDrawable(imageSourceId);
	}

	public void setImageResource(int imageSourceId) {
		this.mImageViewLeft.setScaleType(ImageView.ScaleType.CENTER_CROP);
		this.mImageViewRight.setScaleType(ImageView.ScaleType.CENTER_CROP);
		this.mImageViewLeft.setImageResource(imageSourceId);
		this.mImageViewRight.setImageResource(imageSourceId);
	}
}
