package iih.ci.event.ord.utils;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;
/**
 * 记录日志
 * @author F
 *
 * @date 2019年8月19日上午10:11:22
 *
 * @classpath iih.ci.event.ord.utils.OrdEventLogger
 */
public class OrdEventLogger {
	
	private static Module module= null;
	
	static {
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	
	private OrdEventLogger(){}
	
	/**
	 * 信息输出到日志
	 * @param obj
	 * @param msg
	 */
	public static void info(String obj,String msg) {
		GetLogger().info(concatString(obj, msg));
	}
	/**
	 * 信息输出到日志
	 * @param obj
	 * @param msg
	 */
	public static void infoNotMeger(String obj,String msg) {
		GetLogNotMeger(obj).info(msg);
	}
	/**
	 * 调试信息输入到日志
	 * @param obj
	 * @param msg
	 */
	public static void debug(String obj,String msg) {
		GetLogger().debug(concatString(obj, msg));
	}
	/**
	 * 调试信息输入到日志
	 * @param obj
	 * @param msg
	 */
	public static void debugNotMeger(String obj,String msg) {
		GetLogNotMeger(obj).debug(msg);
	}
	/**
	 * 错误信息输出到日志
	 * @param obj
	 * @param msg
	 * @param t
	 */
	public static void error(String obj,String msg, Throwable t) {
		GetLogger().error(concatString(obj, msg));
	}
	/**
	 * 错误信息输出到日志
	 * @param obj
	 * @param msg
	 * @param t
	 */
	public static void errorNotMeger(String obj,String msg, Throwable t) {
		GetLogNotMeger(obj).error(msg);
	}
	/**
	 * 错误信息输出到日志
	 * @param obj
	 * @param msg
	 */
	public static void error(String obj,String msg) {
		GetLogger().error(concatString(obj, msg));
	}
	/**
	 * 错误信息输出到日志
	 * @param obj
	 * @param msg
	 */
	public static void errorNotMeger(String obj,String msg) {
		GetLogNotMeger(obj).error(msg);
	}
	/**
	 * 获取日志文件流
	 * @param ctx
	 * @return
	 */
	public static Logger GetLogger(){
		String logfile=String.format("event.【%s】", OrdEventLogger.class.getSimpleName());
		Logger logger = module.getContext().getLogger(logfile);
		module.getContext().setLogLevel(logfile, Level.INFO);
		return logger;
	}
	/**
	 * 获取日志文件流
	 * @param obj
	 * @return
	 */
	public static Logger GetLogNotMeger(String obj){
		String logfile=OrdEventUtil.isEmpty(obj)?"event.ord":String.format("event.ord【%s】", obj);
		Logger logger = module.getContext().getLogger(logfile);
		module.getContext().setLogLevel(logfile, Level.INFO);
		return logger;
	}
	/**
	 * 拼接
	 * @param obj
	 * @param msg
	 * @return
	 */
	public static String concatString(String obj,String msg) {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("【");
		stringBuilder.append(OrdEventUtil.isEmpty(obj) == true?"$":obj);
		stringBuilder.append("】-");
		stringBuilder.append(OrdEventUtil.isEmpty(msg) == true?"$":msg);
		return stringBuilder.toString();
	}
}
