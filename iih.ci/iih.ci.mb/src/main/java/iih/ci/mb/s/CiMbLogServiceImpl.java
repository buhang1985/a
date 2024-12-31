package iih.ci.mb.s;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

import iih.ci.mb.i.ICiMbLogService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

/**
 * 医生站日志服务
 * @author yankan
 * @since 2018-03-12
 *
 */
@Service(serviceInterfaces = { ICiMbLogService.class }, binding = Binding.JSONRPC)
public class CiMbLogServiceImpl implements ICiMbLogService,ModuleContextAware {

	/**
	 * 日志
	 */
	private Logger logger;
	
	/**
	 * 记录日志
	 * @param log 日志内容
	 * @param level 日志级别
	 */
	@Override
	public void log(String log, Level level) {
		if (Level.INFO.equals(level))
			this.logger.info(log);
		else if (Level.WARN.equals(level))
			this.logger.warn(log);
		else if (Level.ERROR.equals(level))
			this.logger.error(log);
	}
	/**
	 * 设置上下文
	 */
	@Override
	public void setModuleContext(ModuleContext moduleContext) {
		this.logger = moduleContext.getLogger("mb.log");
		moduleContext.setLogLevel("mb.log", Level.INFO);
	}
}
