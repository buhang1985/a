package iih.mp.mpbd.i;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;

public interface IMpBdLogService {
	/**
	 * 简易日志(输出信息，警告，错误三个级别日志)
	 * 
	 * @param log
	 *            日志内容
	 * @param level
	 *            ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	public abstract void log(String log, Level level);

	/**
	 * 开发用debug级别日志
	 * 
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	public abstract void debug(String msg, Class<?> caller, String methodName);
}
