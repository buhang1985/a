package iih.ci.ord.s;

import iih.ci.ord.i.ICiOrdLogService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

@Service(serviceInterfaces = { ICiOrdLogService.class }, binding = Binding.JSONRPC)
public class ICiOrdLogServiceImpl implements ICiOrdLogService, ModuleContextAware {

	private Logger logger;
	private Logger debugLogger;

	@Override
	public void log(String log, Level level) {

		if (Level.INFO.equals(level)) {
			this.logger.info(log);

		} else if (Level.WARN.equals(level)) {
			this.logger.warn(log);

		} else if (Level.ERROR.equals(level)) {
			this.logger.error(log);
		}

	}

	@Override
	public void debug(String msg, Class<?> caller, String methodName) {

		this.debugLogger.debug(msg, caller, methodName);

	}

	@Override
	public void setModuleContext(ModuleContext moduleContext) {

		this.logger = moduleContext.getLogger("del.log");
		moduleContext.setLogLevel("del.log", Level.INFO);

		this.debugLogger = moduleContext.getLogger("del.debug");
		moduleContext.setLogLevel("del.debug", Level.DEBUG);

	}

}
