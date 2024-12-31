package iih.mm.common.util;

import iih.mm.comm.i.IMmLogService;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

public class MmLogUtil {
	
	private IMmLogService logServ = null;
	private static MmLogUtil instance = null;
	private static Object lock = new Object();
	
	private MmLogUtil(){
		logServ = ServiceFinder.find(IMmLogService.class);
	}
	
	/**
	 * 获取实例(单例)
	 * @return
	 */
	public static MmLogUtil getInstance(){
		if(instance == null){
			synchronized (lock) {
				if(instance == null){
					instance = new MmLogUtil();
				}
			}
		}
		return instance;
	}
	
	/**
	 * debug日志
	 * @param msg
	 * @param caller
	 * @param method
	 */
	public void logDebug(String msg, Class<?> caller, String method) {
		logServ.debug(msg + " " + MmDateUtil.getNow(), caller, method);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 */
	public void logError(String msg){
		logServ.log(msg + " " + MmDateUtil.getNow(), Level.ERROR);
	}
	
	/**
	 * 警告日志
	 * @param msg
	 */
	public void logWarn(String msg){
		logServ.log(msg+ " " + MmDateUtil.getNow(), Level.WARN);
	}
	
	/**
	 * 信息日志
	 * @param msg
	 */
	public void logInfo(String msg){
		logServ.log(msg+ " " + MmDateUtil.getNow(), Level.INFO);
	}
	
	/**
	 * 异常信息日志
	 * @param ex
	 */
	public void logEx(Exception ex){
		logServ.logEx(ex);
	}
}
