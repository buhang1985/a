package wxpay.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class WXProConfig {
	private static final String propsPath = "weixin.properties";
	private static Properties props = new Properties();
	private static boolean initFlag = false;
	
	/**
	 * ��ʼ�������ļ�
	 */
	private static synchronized void init() {
	/*	if (!initFlag) {
			InputStream in = null;
			try {
				in = WXProConfig.class.getClassLoader().getResourceAsStream(propsPath);				
				props.load(in);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
			initFlag = true;
		}*/
	}
	
	public static String getProperty(String propName) {
	//	init();
		return null;
	}

}
