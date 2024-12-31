package iih.ei.std.common;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

/**
 * IIH标准接口日志工具
 * @author ly 2019/07/29
 *
 */
public class EiWsLogger {

	private static Logger logger = null;
	static {
		Module module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ei");
		logger = module.getContext().getLogger("ws.log");
		module.getContext().setLogLevel("ws.log", Level.INFO);
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
