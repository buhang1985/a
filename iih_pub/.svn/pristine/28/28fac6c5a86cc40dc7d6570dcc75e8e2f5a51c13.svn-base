package iih.pmp.pay.log;

import xap.mw.log.logging.Level;

/**
 * 支付平台基础日志服务接口
 * 
 * @author hao_wu 2020-4-20
 *
 */
public interface IBasePmpLogService {

	/**
	 * 根据日志级别输出日志
	 * 
	 * @param level 日志级别
	 * @param log   日志
	 */
	public void log(Level level, String log);

	/**
	 * 输出异常日志
	 * 
	 * @param throwable 异常
	 */
	public void logEx(Throwable throwable);

	/**
	 * 输出异常日志和标题
	 * 
	 * @param throwable
	 * @param msg
	 */
	public void logExAndMsg(Throwable throwable, String title);

	/**
	 * 开发用debug级别日志
	 * 
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	public void debug(String msg, Class<?> caller, String methodName);
}
