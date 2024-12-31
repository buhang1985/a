package iih.ci.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author wangqingzhu
 *
 * @date 2019年11月12日下午2:00:21
 *
 * @classpath iih.ci.sdk.utils.ThrowableUtils
 *
 * 写明类文件描述
 * 
 */
public class ThrowableUtils {

	/**
	 * 异常堆栈转化为字符串
	 * @param t
	 * @return
	 */
	public static String ToString(Throwable t) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try{
	        t.printStackTrace(new PrintStream(baos));
	    }finally{
	        try {
				baos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    return baos.toString();
	}
}
