package iih.en.pv.i;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;

/**
 * 执行就诊域服务日志
 * @author libaoliang
 *
 */
public interface IEnLogService {

	/**
	 * 简易日志(输出信息，警告，错误三个级别日志)
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	public abstract void log(String log, Level level);
	
	/**
	 * 简易日志
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	public void displayLog(String log);
	
	/**
	 * 异常日志
	 * @param ex 异常
	 */
	public abstract void logEx(Exception ex);
	/**
	 * 异常日志
	 * 
	 * @param msg
	 * @param ex
	 */
	public abstract void logError(String msg,  Throwable ex);
	/**
	 * 开发用debug级别日志
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	public abstract void debug(String msg, Class<?> caller, String methodName);
}
