package com.wormhole.carousel.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * 文件的加载类
 * <p>
 * 用于程序加载sd卡的文件
 *
 * @author Tiny
 * @date 2014年8月12日
 * @version 1.0
 */
public class FileLoader {

	private static FileLoader outInstance = new FileLoader();

	public static FileLoader getInstance() {
		return outInstance;
	}

	public void getSdcardFile() {
		Map<Integer, String> imagePath = new HashMap<Integer, String>();

		File f = new File(ConstUtils.IMAGEPATH);
		if (f.exists()) {
			File[] files = f.listFiles();
			if (files != null) {
				int count = files.length;
				for (int i = 0; i < count; i++) {
					File file = files[i];
					if (judgeEndIsJpg(file)) {
						imagePath.put(i, file.getName());
					}
				}
			}
		}
		ConstUtils.mPictureName = imagePath;
	}

	private boolean judgeEndIsJpg(File file) {
		boolean flag = false;
		if (getExtensionName(file.getName()).equals("jpg")
				|| getExtensionName(file.getName()).equals("png")
				|| getExtensionName(file.getName()).equals("bmp")
				|| getExtensionName(file.getName()).equals("jpeg")) {
			flag = true;
		}

		return flag;
	}

	private String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
}
