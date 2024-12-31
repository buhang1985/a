package iih.ci.mb.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.JSONObject;

import iih.ci.mb.i.ICiMbLogService;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 日志帮助类
 * @author yankan
 * @since 2018-03-12
 *
 */
public class LogUtils {
	/**
	 * 记录
	 * @param msg
	 */
	public static void info(String msg){
		ICiMbLogService logService = ServiceFinder.find(ICiMbLogService.class);
		logService.log(msg, Level.INFO);
	}
	/**
	 * 错误
	 * @param msg
	 */
	public static void error(String msg){
		ICiMbLogService logService = ServiceFinder.find(ICiMbLogService.class);
		logService.log(msg, Level.ERROR);
	}
	/**
	 * 堆栈日志
	 * 
	 * @param t 异常对象
	 * @param obj 对象
	 */
	public static void logStack(Throwable t, Object obj) {
		try {
			ICiMbLogService logService = ServiceFinder.find(ICiMbLogService.class);;
			JSONObject json = new JSONObject(obj);
			logService.log(json.toString(), Level.ERROR);
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw, true));
			logService.log(sw.getBuffer().toString(), Level.ERROR);
		} catch (Exception e) {
		}
	}
}
