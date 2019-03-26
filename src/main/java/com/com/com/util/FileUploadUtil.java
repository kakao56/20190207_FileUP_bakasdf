package com.com.com.util;

import java.io.File;

public class FileUploadUtil {

	public static String checkSameFileName(String fileName, String path) {
		int period = fileName.lastIndexOf(".");
		String f_name = fileName.substring(0,period);
		String suffix = fileName.substring(period);
		String saveFileName = path +System.getProperty("file.separator")+fileName;
		File f = new File(saveFileName);
		int idx = 1;
		while(f.exists()) {
			StringBuffer sb = new StringBuffer();
			sb.append(f_name);
			sb.append(idx++);
			sb.append(suffix);
			fileName = sb.toString();
			saveFileName = path +System.getProperty("file.separator")+fileName;
			f = new File(saveFileName);
		}	
		return fileName;
	}
}
