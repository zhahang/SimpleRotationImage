package com.wormhole.carousel.view;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.wormhole.carousel.Carousel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


/**
 * 
 * <p>
 * <p>
 *
 * @author Tiny
 * @date 2015年12月8日
 * @version 1.0
 */
public class ViewPagerAdapter extends PagerAdapter{
	
	private Context mContext;
	DisplayImageOptions options;
	private ArrayList<View> mViewList;
	
	public ViewPagerAdapter(Context context) {
		this.mContext = context;
		options = new DisplayImageOptions.Builder()
				.imageScaleType(ImageScaleType.EXACTLY)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.displayer(new FadeInBitmapDisplayer(300)).build();
		loadImageList();
	}

	public static Drawable resizeImage(Bitmap bitmap, int w, int h) {
		Bitmap BitmapOrg = bitmap;
		int width = BitmapOrg.getWidth();
		int height = BitmapOrg.getHeight();
		int newWidth = w;
		int newHeight = h;

		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// if you want to rotate the Bitmap
		// matrix.postRotate(45);
		Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
				height, matrix, true);
		return new BitmapDrawable(resizedBitmap);
	}

	@Override
	public Object instantiateItem(ViewGroup container,int position) {
		
		
//		ViewGroup parent = (ViewGroup) mViewList.get(position).getParent();
//		 if (parent != null) {
//			 parent.removeAllViews();
//		 } 
		container.addView(mViewList.get(position));
		
		return mViewList.get(position);
	}

	@Override
	public int getCount() {
		if (mViewList != null) {
			return mViewList.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) { // 文档上是这么写的，但是不知道是什么意思
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViewList.get(position));
	}
	
	private void loadImageList(){
		mViewList = new ArrayList<View>();
		
		for(int i = 0 ; i < 2 ; i++){
		}
		Carousel mCarousel = new Carousel(mContext);
		mViewList.add(mCarousel);
		
		Carousel.mDirection = "UP";
		Carousel mCarousel1 = new Carousel(mContext);
		mViewList.add(mCarousel1);
	
		Carousel.mDirection = null;
	}
}
