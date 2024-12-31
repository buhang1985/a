package com.alipay.demo.trade.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alipay.demo.trade.config.Configs;

public class AlipayConfigInitUtil {
	
	public static boolean LoadConfig() {
		
	/*	InputStream inputStream = AlipayConfigInitUtil.class.getClassLoader().getResourceAsStream("zfbinfo.properties");
		
		File f = null;
		OutputStream outputStream = null;
		boolean errorflag = false, sucflag = false;
		
		try {			
			f = File.createTempFile("temp", ".properties");
			
			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(f);

			int read = 0;
			byte[] bytes = new byte[4096];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			errorflag = true;
		}
		finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		
		if (f != null) {
			if (!errorflag) {
				Configs.init(f.getAbsolutePath());
				sucflag = true;
			}
			
			f.delete();
		}*/
		
		return true;
		
	}
}
