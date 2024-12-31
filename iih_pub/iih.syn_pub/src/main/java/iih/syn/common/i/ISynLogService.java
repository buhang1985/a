package iih.syn.common.i;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;

/**
 * @Description:数据同步日志类
 * @author: xu_xing@founder.com.cn
 * @version：2018年3月28日 下午3:30:46 创建
 */
public interface ISynLogService {

	/**
	 * 简易日志(输出信息，警告，错误三个级别日志)
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	public abstract void log(String log, Level level);
}
