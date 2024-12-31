package iih.pmp.pay.log;

import com.founder.xap.runtime.msys.ModuleContext;

import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

/**
 * 支付平台日志服务基类
 * 
 * @author hao_wu 2019-3-7
 *
 */
public abstract class BasePmpLogService implements IBasePmpLogService {

	private Logger _logger;
	private Logger _debugLogger;

	public void log(Level level, String log) {
		if (Level.INFO.equals(level)) {
			this._logger.info(log);
		} else if (Level.WARN.equals(level)) {
			this._logger.warn(log);
		} else if (Level.ERROR.equals(level)) {
			this._logger.error(log);
		}
	}

	public void logEx(Throwable throwable) {
		this._logger.error(throwable);
	}

	public void logExAndMsg(Throwable throwable, String title) {
		this.log(Level.ERROR, title);
		this.logEx(throwable);
	}

	public void debug(String log, Class<?> caller, String methodName) {
		this._debugLogger.debug(log, caller, methodName);
	}

	public void setModuleContext(ModuleContext moduleContext) {
		String logPath = this.getLogPath();
		this._logger = moduleContext.getLogger(logPath);
		moduleContext.setLogLevel(logPath, Level.INFO);

		String debugLogPath = this.getDebugLogPath();
		this._debugLogger = moduleContext.getLogger(debugLogPath);
		moduleContext.setLogLevel(debugLogPath, Level.DEBUG);
	}

	/**
	 * 获取日志路径
	 * 
	 * @return
	 */
	protected abstract String getLogPath();

	/**
	 * 获取调试日志路径
	 * 
	 * @return
	 */
	protected abstract String getDebugLogPath();
}
