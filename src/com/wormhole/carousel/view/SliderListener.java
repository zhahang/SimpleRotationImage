package com.wormhole.carousel.view;

import com.wormhole.carousel.R;
import com.wormhole.carousel.utils.ConstUtils;

import android.content.Context;
import android.util.Log;
import android.view.View;



/**
 * 
 * <p>
 * <p>
 *
 * @author Tiny
 * @date 2014年12月25日
 * @version 1.0
 */
public class SliderListener implements OnSliderListening {

	private int mTempPostion = 0;
	private DoubleToast toast;
	private Context context;

	public SliderListener(Context context, View v) {
		this.context = context;
		toast = (DoubleToast) v;
		// toast = (DoubleToast) view.findViewById(R.id.toast);
		// toast = new DoubleToast(context, null);
	}

	@Override
	public void onSliderDirection(int postion) {
		if (mTempPostion == postion && postion == 0) {
			toast.show3DToast(context.getString(R.string.first_paper_sign));
		} else if (mTempPostion == postion - 1
				&& postion == (ConstUtils.mPictureName.size())) {
			toast.show3DToast(context.getString(R.string.last_paper_sign));
		}
		Log.v("mTempPostion: ", "mTempPostion: " + mTempPostion);
		Log.v("postion: ", "postion: " + postion);

		// 由于最后一张的时候再向下翻页target的数量还会+，这里判断，最后一页postion的位置不会被temp寄存
		if (!(postion >= ConstUtils.mPictureName.size())) {
			mTempPostion = postion;
		}
	}
}
