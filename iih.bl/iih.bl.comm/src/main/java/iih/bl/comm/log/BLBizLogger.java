package iih.bl.comm.log;

import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

/**
 * 费用域业务日志工具类
 * @author ly 2018/05/17
 *
 */
public class BLBizLogger {

	private static Logger logger = null;
	static {
		Module module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.bl");
		logger = module.getContext().getLogger("biz.log");
		module.getContext().setLogLevel("biz.log", Level.INFO);
	}
	
	/**
	 * 普通日志
	 * @param msg
	 */
	public static void info(String msg) {
		logger.info(msg);
	}
	
	/**
	 * 警告日志
	 */
	public static void warn(String msg) {
		logger.warn(msg);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 */
	public static void error(String msg) {
		logger.error(msg);
	}
	
	/**
	 * 错误日志
	 * @param msg
	 * @param throwable
	 */
	public static void error(String msg, Throwable throwable){
		logger.error(msg, throwable);
	}
}