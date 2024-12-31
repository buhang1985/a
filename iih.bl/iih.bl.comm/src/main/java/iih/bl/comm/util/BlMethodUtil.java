package iih.bl.comm.util;

import org.apache.commons.lang.exception.ExceptionUtils;

import xap.mw.core.utils.StringUtil;

/**
 * 费用域方法工具类
 * @author ly
 *
 */
public class BlMethodUtil {

	private static final String BLMODULE = "iih.bl";
	
	/**
	 * 获取方法的第一个其他域调用类
	 * @param 本类所在域名 比如iih.bl
	 * @return
	 */
	public static String findFirstCallPoint(String module){
	
		if(StringUtil.isEmpty(module)){
			module = BLMODULE;
		}
		
		Throwable ex = new Throwable();
		StackTraceElement[] stackElements = ex.getStackTrace();
		
		String className = "";
		for (int i = stackElements.length - 1; i <= 0; i--) {
			
			if(!stackElements[i].getClassName().toLowerCase().startsWith(BLMODULE)){
				className = stackElements[i].getClassName();
				break;
			}	
		}
		
		return className;
	}
	
	/**
	 * 获取堆栈信息
	 * @param ex
	 * @return
	 */
	public static String getStackInfo(Throwable ex){
	
		if(ex == null){
			ex = new Throwable();
		}
		return ExceptionUtils.getFullStackTrace(ex);
	}
}
