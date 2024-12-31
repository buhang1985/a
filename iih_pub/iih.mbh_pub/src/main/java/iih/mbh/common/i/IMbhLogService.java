package iih.mbh.common.i;

import xap.mw.log.logging.Level;

public interface IMbhLogService {

	/**
	 * 简易日志(输出信息，警告，错误三个级别日志)
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	public abstract void log(String log, Level level);
}