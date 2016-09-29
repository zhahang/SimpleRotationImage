package com.wormhole.carousel.utils;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/**
 * 
 * <p>
 * <p>
 *
 * @author Tiny
 * @date 2014年11月12日
 * @version 1.0
 */
public class Application extends android.app.Application {
	public static int SSCREENWIDTH;

	@Override
	public void onCreate() {
		
		super.onCreate();
		
		// 创建默认的ImageLoader配置参数
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext()).denyCacheImageMultipleSizesInMemory()
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// 加载的线程池数量
				.threadPoolSize(5)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.imageDownloader(
						new BaseImageDownloader(getApplicationContext(),
								5 * 1000, 30 * 1000)) // connectTimeout (5 s),
														// readTimeout (30
														// s)超时时间
				.writeDebugLogs().build();

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}
}
