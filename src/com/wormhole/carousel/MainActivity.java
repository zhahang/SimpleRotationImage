package com.wormhole.carousel;

import com.wormhole.carousel.utils.Application;
import com.wormhole.carousel.utils.FileLoader;
import com.wormhole.carousel.view.DoubleToast;
import com.wormhole.carousel.view.SliderListener;
import com.wormhole.carousel.view.ViewPager;
import com.wormhole.carousel.view.ViewPagerAdapter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private ViewPager mViewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		getScreenInfo();
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		FileLoader.getInstance().getSdcardFile();
		setContentView(R.layout.activity_viewpager);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// 执行初始化mViewPager
		initmViewPager();
	}
	/**
	 * 初始化mViewPager
	 */
	private void initmViewPager() {
		int imagePosition = getIntent().getIntExtra("image_position", 0);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		DoubleToast doubleToast = (DoubleToast) findViewById(R.id.toast);
		ViewPagerAdapter adapter = new ViewPagerAdapter(this);
		mViewPager.setAdapter(adapter);
		mViewPager.setCurrentItem(imagePosition);
		
		mViewPager.setEnabled(false);
//		// mViewPager的动画效果
//		mViewPager.setPageTransformer(true, new DepthPageTransformer());
		mViewPager.setOnSliderListening(new SliderListener(this, doubleToast));
	}
	
	
	private void getScreenInfo() {
		WindowManager wm = this.getWindowManager();

		Application.SSCREENWIDTH = wm.getDefaultDisplay().getWidth();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
