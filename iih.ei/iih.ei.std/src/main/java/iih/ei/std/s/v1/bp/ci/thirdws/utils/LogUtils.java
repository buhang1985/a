package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import xap.mw.log.logging.internal.Logger;

public class LogUtils {
private static Module module= null;
	
	static {
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	/**
	 * 日志记录
	 * @param info
	 */
	public static void Logger(String info){
		Logger logger = module.getContext().getLogger("iih.ci.ER");
		logger.error(info);
	}
	public static void Logger(String info,Throwable var2){
		Logger logger = module.getContext().getLogger("iih.ci.ER");
		logger.error(info, var2);
	}
}
