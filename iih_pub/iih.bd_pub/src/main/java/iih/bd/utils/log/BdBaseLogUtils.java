package iih.bd.utils.log;

import iih.bd.log.IBdAdstractLogService;
import xap.mw.log.logging.Level;

/**
 * 基础数据_基础日志工具类
 * 
 * @author hao_wu 2019-1-25
 *
 */
class BdBaseLogUtils {

	/**
	 * 输出信息类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	static void info(IBdAdstractLogService logService, String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		info(logService, log);
	}

	/**
	 * 输出信息类型日志
	 * 
	 * @param log 日志
	 */
	static void info(IBdAdstractLogService logService, String log) {
		logService.log(Level.INFO, log);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	static void error(IBdAdstractLogService logService, String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		error(logService, log);
	}

	/**
	 * 输出错误类型日志
	 * 
	 * @param log 日志
	 */
	static void error(IBdAdstractLogService logService, String log) {
		logService.log(Level.ERROR, log);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	static void warn(IBdAdstractLogService logService, String logFormat, Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		warn(logService, log);
	}

	/**
	 * 输出警告类型日志
	 * 
	 * @param log 日志
	 */
	static void warn(IBdAdstractLogService logService, String log) {
		logService.log(Level.WARN, log);
	}

	/**
	 * 输出异常日志
	 * 
	 * @param throwable 异常
	 */
	static void logEx(IBdAdstractLogService logService, Throwable throwable) {
		logService.logEx(throwable);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable   异常
	 * @param titleFormat 标题格式串
	 * @param formatArgs  格式串参数
	 */
	static void logExAndTitle(IBdAdstractLogService logService, Throwable throwable, String titleFormat,
			Object... formatArgs) {
		String log = String.format(titleFormat, formatArgs);
		logExAndTitle(logService, throwable, log);
	}

	/**
	 * 输出异常日志和异常标题
	 * 
	 * @param throwable 异常
	 * @param title     标题
	 */
	static void logExAndTitle(IBdAdstractLogService logService, Throwable throwable, String title) {
		logService.logExAndMsg(throwable, title);
	}

	/**
	 * 输出调试类型日志
	 * 
	 * @param caller     调用类
	 * @param methodName 方法名
	 * @param logFormat  日志格式串
	 * @param formatArgs 格式串参数
	 */
	static void debug(IBdAdstractLogService logService, Class<?> caller, String methodName, String logFormat,
			Object... formatArgs) {
		String log = String.format(logFormat, formatArgs);
		debug(logService, caller, methodName, log);
	}

	/**
	 * 输出调试类型日志
	 * 
	 * @param caller     调用类
	 * @param methodName 方法名
	 * @param log        日志
	 */
	static void debug(IBdAdstractLogService logService, Class<?> caller, String methodName, String log) {
		logService.debug(log, caller, methodName);
	}
}
