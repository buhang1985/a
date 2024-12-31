package iih.ei.een.log;

import iih.en.pv.i.IEnLogService;
import xap.mw.core.service.time.TimeService;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 打印日志工具类
 * @author liubin
 *
 */
public class EnEiLogUtil {

	private IEnLogService logServ = null;
	private TimeService ts = null;
	private static EnEiLogUtil instance = null;
	private static Object lock = new Object();
	
	private EnEiLogUtil(){
		logServ = ServiceFinder.find(IEnLogService.class);
		ts = ServiceFinder.find(TimeService.class);
	}
	
	/**
	 * 获取实例(单例)
	 * @return
	 */
	public static EnEiLogUtil getInstance(){
		if(instance == null){
			synchronized (lock) {
				if(instance == null){
					instance = new EnEiLogUtil();
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
		remedyService();
		logServ.debug(msg + " " + ts.getUFDateTime(), caller, method);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 */
	public void logError(String msg){
		remedyService();
		logServ.log(msg + " " + ts.getUFDateTime(), Level.ERROR);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 */
	public void logError(String msg, Throwable t){
		remedyService();
		logServ.logError(msg + " " + ts.getUFDateTime(), t);
	}
	
	/**
	 * 警告日志
	 * @param msg
	 */
	public void logWarn(String msg){
		remedyService();
		logServ.log(msg+ " " + ts.getUFDateTime(), Level.WARN);
	}
	
	/**
	 * 信息日志
	 * @param msg
	 */
	public void logInfo(String msg){
		remedyService();
		logServ.log(msg+ " " + ts.getUFDateTime(), Level.INFO);
	}
	/**
	 * 信息日志
	 * @param msg
	 */
	public void displayInfo(String msg){
		remedyService();
		logServ.displayLog(msg+ " " + ts.getUFDateTime());
	}
	
	/**
	 * 异常信息日志
	 * @param ex
	 */
	public void logEx(Exception ex){
		remedyService();
		logServ.logEx(ex);
	}
	
	/**
	 * 服务未找到时重新找
	 */
	private void remedyService(){
		if(logServ == null){
			logServ = ServiceFinder.find(IEnLogService.class);
		}
	}
}
