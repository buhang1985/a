package iih.pi.reg.s;

import iih.pi.reg.i.IPiPatLogService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

/**
 * 患者域日志
 * @author ly 2017/12/26
 *
 */
@Service(serviceInterfaces={IPiPatLogService.class}, binding=Binding.JSONRPC)
public class PiPatLogServiceImpl implements IPiPatLogService , ModuleContextAware {

	private Logger logger;
	private Logger debugLogger;
	
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
	 * 异常日志
	 * @param ex 业务异常
	 */
	@Override
	public void logEx(Exception ex){
		this.logger.error(ex);
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
		this.logger = moduleContext.getLogger("PiLog");
		moduleContext.setLogLevel("PiLog", Level.INFO);
		
		this.debugLogger = moduleContext.getLogger("PiLog_debug");
		moduleContext.setLogLevel("PiLog_debug", Level.DEBUG);
	}
}
