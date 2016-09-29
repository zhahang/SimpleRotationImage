package com.wormhole.carousel.view;

/**
 * 
 * <p>
 * 针对于paperView的翻页监听
 * <p>
 * 返回当时的也是，每滑动一次都会返回一次页数，及时到最后或者<br>
 * 是第一张也会返回张数，但要注意的是图片到达最后一张的时候<br>
 * 再向后返页数也会加1，但是照片不会改变
 * 
 * @author Tiny
 * @date 2014年12月23日
 * @version 1.0
 */
public interface OnSliderListening {
	public void onSliderDirection(int driection);
}
