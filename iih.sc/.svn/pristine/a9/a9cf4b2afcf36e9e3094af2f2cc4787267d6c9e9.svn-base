package iih.sc.comm;

import iih.en.pv.i.IEnLogService;
import iih.sc.scbd.i.IScLogService;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 打印日志工具类
 * @author lbl
 *
 */
public class ScLogUtil {

	private IScLogService logServ = null;
	private static ScLogUtil instance = null;
	private static Object lock = new Object();
	
	private ScLogUtil(){
		logServ = ServiceFinder.find(IScLogService.class);
	}
	
	/**
	 * 获取实例(单例)
	 * @return
	 */
	public static ScLogUtil getInstance(){
		if(instance == null){
			synchronized (lock) {
				if(instance == null){
					instance = new ScLogUtil();
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
		logServ.debug(msg + " " + DateTimeUtils.getNow(), caller, method);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 */
	public void logError(String msg){
		remedyService();
		logServ.log(msg + " " + DateTimeUtils.getNow(), Level.ERROR);
	}
	
	/**
	 * 警告日志
	 * @param msg
	 */
	public void logWarn(String msg){
		remedyService();
		logServ.log(msg+ " " + DateTimeUtils.getNow(), Level.WARN);
	}
	
	/**
	 * 信息日志
	 * @param msg
	 */
	public void logInfo(String msg){
		remedyService();
		logServ.log(msg+ " " + DateTimeUtils.getNow(), Level.INFO);
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
			logServ = ServiceFinder.find(IScLogService.class);
		}
	}
}
