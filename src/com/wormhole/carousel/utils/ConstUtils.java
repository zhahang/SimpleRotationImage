package com.wormhole.carousel.utils;

import android.os.Environment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * 程序中所存有的缓存变量
 * <p>
 *
 * @author Tiny
 * @date 2014年8月12日
 * @version 1.0
 */
public class ConstUtils {
	public static Map<Integer, String> mPictureName = new HashMap<Integer, String>();

	// public static final String IMAGEPATH = Environment
	// .getExternalStorageDirectory().getAbsolutePath()
	// + File.separator
	// + "Pic" ;

	public static final String IMAGEPATH = Environment
			.getExternalStorageDirectory().getAbsolutePath()
			+ File.separator
			+ "Pic";

	public static final String IMAGEPATH4IMAGELOADER = "file:///mnt/sdcard/Pic/";

}
