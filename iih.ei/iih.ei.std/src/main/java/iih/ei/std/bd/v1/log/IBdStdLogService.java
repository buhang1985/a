package iih.ei.std.bd.v1.log;

import xap.mw.log.logging.Level;

/**
 * 基础数据_标准接口日志服务接口
 * 
 * @author hao_wu 2019-2-27
 *
 */
public interface IBdStdLogService {

	/**
	 * 根据日志级别输出日志
	 * 
	 * @param level 日志级别
	 * @param log   日志
	 */
	public abstract void log(Level level, String log);

	/**
	 * 输出异常日志
	 * 
	 * @param throwable 异常
	 */
	public abstract void logEx(Throwable throwable);

	/**
	 * 输出异常日志和标题
	 * 
	 * @param throwable
	 * @param msg
	 */
	public abstract void logExAndMsg(Throwable throwable, String title);

	/**
	 * 开发用debug级别日志
	 * 
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	public abstract void debug(String msg, Class<?> caller, String methodName);
}
