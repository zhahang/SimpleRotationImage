package com.wormhole.carousel.view;

import com.wormhole.carousel.R;
import com.wormhole.carousel.utils.Application;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * 实现双屏toast原理是在界面上画一个view并控制其显示
 */
public class DoubleToast extends RelativeLayout {

	private TextView mLeftView = null;
	private TextView mRightView = null;
	private AlphaAnimation mTextFadeAnimation;
	private Animation mAnimation;
	private Context mContext;

	// 设置的一些属性值
	private int mTextColor = Color.WHITE;
	private String mText = "";

	private void init(Context context, AttributeSet attrs, int defStyle) {
		this.mContext = context;
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		LayoutParams params1 = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);

		mLeftView = new TextView(context, attrs);
		mLeftView.setLayoutParams(params);
		mLeftView.setBackgroundResource(R.drawable.text_view_border);
		addView(mLeftView);
		Log.v("", "sscreen: " + Application.SSCREENWIDTH / 2);
		params1.setMargins(Application.SSCREENWIDTH / 2, 0, 0, 0);
		mRightView = new TextView(context, attrs);
		mRightView.setLayoutParams(params1);
		mRightView.setBackgroundResource(R.drawable.text_view_border);
		addView(mRightView);

		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.doubletoast, defStyle, 0);
			this.mTextColor = a.getInt(R.styleable.doubletoast_textColor, 0);
			this.mText = a.getString(R.styleable.doubletoast_text);

			a.recycle();
		}

		setText(mText);
		setColor(mTextColor);
		setTextAlpha(0f);

		mTextFadeAnimation = new AlphaAnimation(1.0f, 0.0f);
		mTextFadeAnimation.setDuration(400);
	}

	public DoubleToast(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	public DoubleToast(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	public void show3DToast(String message) {
		setText(message);
		// 控制提示的动画效果,先加速弹出后淡淡的消失
		setTextAlpha(1f);
		mAnimation = AnimationUtils.loadAnimation(mContext,
				R.anim.toast_translate);
		mLeftView.setAnimation(mAnimation);
		mRightView.setAnimation(mAnimation);

		mTextFadeAnimation.setAnimationListener(new EndAnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				setTextAlpha(0f);
			}
		});
		new Handler().postDelayed(new Runnable() {
			public void run() {
				startAnimation(mTextFadeAnimation);
			}
		}, 1500);
	}

	private void setText(String text) {
		mLeftView.setText(text);
		mRightView.setText(text);
	}

	private void setColor(int color) {
		mLeftView.setTextColor(color);
		mRightView.setTextColor(color);
	}

	private void setTextSize(int size) {
		mLeftView.setTextSize(size);
		mRightView.setTextSize(size);
	}

	private void setTextAlpha(float alpha) {
		mLeftView.setAlpha(alpha);
		mRightView.setAlpha(alpha);
	}

	private abstract class EndAnimationListener implements
			Animation.AnimationListener {
		@Override
		public void onAnimationRepeat(Animation animation) {
		}

		@Override
		public void onAnimationStart(Animation animation) {
		}
	}
}
