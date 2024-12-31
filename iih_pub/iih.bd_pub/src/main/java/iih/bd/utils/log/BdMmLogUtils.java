package iih.bd.utils.log;

import iih.bd.log.IBdMmLogService;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据_医疗物品s日志工具类
 * 
 * @author hao_wu 2019-1-25
 *
 */
public class BdMmLogUtils {

	private static IBdMmLogService _logService = ServiceFinder.find(IBdMmLogService.class);

	/**
	 * 输出信息类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void info(String logFormat, Object... formatArgs) {
		BdBaseLogUtils.info(_logService, logFormat, formatArgs);
	}

	/**
	 * 输出信息类型日志
	 * 
	 * @param log 日志
	 */
	public static void info(String log) {
		BdBaseLogUtils.info(_logService, log);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void error(String logFormat, Object... formatArgs) {
		BdBaseLogUtils.error(_logService, logFormat, formatArgs);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param log 日志
	 */
	public static void error(String log) {
		BdBaseLogUtils.error(_logService, log);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	public static void warn(String logFormat, Object... formatArgs) {
		BdBaseLogUtils.warn(_logService, logFormat, formatArgs);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param log 日志
	 */
	public static void warn(String log) {
		BdBaseLogUtils.warn(_logService, log);
	}

	/**
	 * 输出异常日志
	 * 
	 * @param throwable 异常
	 */
	public static void logEx(Throwable throwable) {
		BdBaseLogUtils.logEx(_logService, throwable);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable   异常
	 * @param titleFormat 标题格式串
	 * @param formatArgs  格式串参数
	 */
	public static void logExAndTitle(Throwable throwable, String titleFormat, Object... formatArgs) {
		BdBaseLogUtils.logExAndTitle(_logService, throwable, titleFormat, formatArgs);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable 异常
	 * @param title     标题
	 */
	public static void logExAndTitle(Throwable throwable, String title) {
		BdBaseLogUtils.logExAndTitle(_logService, throwable, title);
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
		BdBaseLogUtils.debug(_logService, caller, methodName, logFormat, formatArgs);
	}

	/**
	 * 输出调试类型日志
	 * 
	 * @param caller     调用类
	 * @param methodName 方法名
	 * @param log        日志
	 */
	public static void debug(Class<?> caller, String methodName, String log) {
		BdBaseLogUtils.debug(_logService, caller, methodName, log);
	}
}
