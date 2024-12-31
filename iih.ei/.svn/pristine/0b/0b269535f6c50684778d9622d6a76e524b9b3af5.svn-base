package iih.ei.std.consis.v1.s.bp;

import org.apache.commons.lang.exception.ExceptionUtils;

import iih.bd.utils.FileUtils;
import iih.mp.dg.i.IMpDgLogService;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 调用WebService基础业务逻辑
 * 
 * @author hao_wu 2018-11-22
 *
 */
public abstract class BaseCallWsBp {

	/**
	 * 调用Web服务
	 * 
	 * @param paramStr
	 * @return
	 */
	protected abstract String callWebService(String paramStr) throws BizException;

	/**
	 * 写异常日志
	 * 
	 * @param e
	 */
	protected void writeLog(Exception e) {
		String log = String.format("%s%s%s", e.getMessage(), FileUtils.NewLine, ExceptionUtils.getStackFrames(e));
		writeLog(log);
	}

	/**
	 * 写消息日志
	 * 
	 * @param e
	 */
	protected void writeLog(String msg) {
		IMpDgLogService mpDgLogService = ServiceFinder.find(IMpDgLogService.class);
		mpDgLogService.log(msg, Level.ERROR);
	}
}
