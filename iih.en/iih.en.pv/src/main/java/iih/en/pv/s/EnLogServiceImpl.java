package iih.en.pv.s;

import iih.en.pv.i.IEnLogService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

/**
 * 执行就诊域服务日志
 * @author libaoliang
 *
 */
@Service(serviceInterfaces={IEnLogService.class}, binding=Binding.JSONRPC)
public class EnLogServiceImpl implements IEnLogService, ModuleContextAware {

	private Logger logger;
	private Logger debugLogger;
	private Logger displayLogger;
	
	/**
	 * 简易日志
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	@Override
	public void log(String log,Level level){
		
		if(Level.INFO.equals(level)){
			this.logger.info(log);
			
		}else if(Level.WARN.equals(level)){
			this.logger.warn(log);
			
		}else if(Level.ERROR.equals(level)){
			this.logger.error(log);
		}
	}
	
	
	/**
	 * 简易日志
	 * @param log 日志内容
	 * @param level ： INFO,WARN,ERROR
	 * @throws BizException
	 */
	@Override
	public void displayLog(String log){		
			this.displayLogger.info(log);		
	}
	
	/**
	 * 异常日志
	 * @param ex 业务异常
	 */
	@Override
	public void logEx(Exception ex){
		this.logger.error(ex);
	}
	
	/**
	 * 异常日志
	 * @param ex 业务异常
	 */
	@Override
	public void logError(String msg, Throwable ex) {
		this.logger.error(msg, ex);
	}
	
	/**
	 * 开发用debug级别日志
	 * @param msg
	 * @param caller
	 * @param methodName
	 */
	@Override
	public void debug(String msg, Class<?> caller, String methodName){
		
		this.debugLogger.debug(msg, caller, methodName);
	}

	/**
	 * 设置日志级别路径
	 */
	@Override
	public void setModuleContext(ModuleContext moduleContext) {
		this.logger = moduleContext.getLogger("enlog");
		moduleContext.setLogLevel("enlog", Level.INFO);
		
		this.debugLogger = moduleContext.getLogger("enlog_debug");
		moduleContext.setLogLevel("enlog_debug", Level.DEBUG);
		
		this.displayLogger = moduleContext.getLogger("enlog_displayLogger");
		moduleContext.setLogLevel("enlog_displayLogger", Level.INFO);
	}
}
