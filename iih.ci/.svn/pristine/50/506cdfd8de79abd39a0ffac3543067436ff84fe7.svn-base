package iih.ci.mr.s.bp;
import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;
import xap.mw.log.logging.internal.Logger;
public class FastdfsMrLogger {
	public static final String LUI_LOGGER_NAME = "appwdp";
	private static Logger logger = null;
	static {
		Module module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("cluster");
		logger =module.getContext().getLogger("cimr");
	}
	public static void info(String msg) {
		logger.info(msg);
	}
	public static void debug(String msg) {
		logger.debug(msg);
	}
	public static void error(String msg, Throwable t) {
		// Logger.error(msg, t);
		logger.error(msg);
	}
	public static void error(String msg) {
		logger.error(msg);
	}
	public static void error(Throwable e) {
		logger.error(e);
	}
	public static boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
	public static boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}
	public static void warn(String string) {
		logger.warn(string);
	}
	public static boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}
}
