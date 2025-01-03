package iih.ei.std.bd.v1.utils;

import iih.ei.std.bd.v1.log.IBdStdLogService;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据_标准接口日志工具类
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class BdStdLogUtils {

	private static IBdStdLogService _logService = ServiceFinder.find(IBdStdLogService.class);

	/**
	 * 输出信息类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void info(String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		info(log);
	}

	/**
	 * 输出信息类型日志
	 * 
	 * @param log 日志
	 */
	public static void info(String log) {
		_logService.log(Level.INFO, log);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void error(String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		error(log);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param log 日志
	 */
	public static void error(String log) {
		_logService.log(Level.ERROR, log);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void warn(String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		warn(log);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param log 日志
	 */
	public static void warn(String log) {
		_logService.log(Level.WARN, log);
	}

	/**
	 * 输出异常日志
	 * 
	 * @param throwable 异常
	 */
	public static void logEx(Throwable throwable) {
		_logService.logEx(throwable);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable   异常
	 * @param titleFormat 标题格式串
	 * @param formatArgs  格式串参数
	 */
	public static void logExAndTitle(Throwable throwable, String titleFormat, Object... formatArgs) {
		String log = String.format(titleFormat, formatArgs);
		logExAndTitle(throwable, log);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable 异常
	 * @param title     标题
	 */
	public static void logExAndTitle(Throwable throwable, String title) {
		_logService.logExAndMsg(throwable, title);
	}

	/**
	 * 输出调试类型日志
	 * 
	 * @param caller     调用类
	 * @param methodName 方法名
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void debug(Class<?> caller, String methodName, String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		debug(caller, methodName, log);
	}

	/**
	 * 输出调试类型日志
	 * 
	 * @param caller     调用类
	 * @param methodName 方法名
	 * @param log        日志
	 */
	public static void debug(Class<?> caller, String methodName, String log) {
		_logService.debug(log, caller, methodName);
	}
}
