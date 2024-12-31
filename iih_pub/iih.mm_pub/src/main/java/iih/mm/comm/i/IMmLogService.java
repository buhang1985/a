package iih.mm.comm.i;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;

/**
 * 物品域服务端日志打印
 * @author liuyilin
 *
 */
public interface IMmLogService {
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
	 * 异常日志
	 * 
	 * @param ex
	 *            异常
	 */
	public abstract void logEx(Exception ex);

	/**
	 * 异常日志加消息
	 * 
	 * @param ex
	 *            异常
	 */
	public abstract void logExAndMsg(Exception ex, String msg);

	/**
	 * 开发用debug级别日志
	 * 
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	public abstract void debug(String msg, Class<?> caller, String methodName);
}
