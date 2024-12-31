package iih.bl.comm.log;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import iih.bl.params.BlParams;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;

/**
 * 费用域性能日志
 * @author ly 2018/05/17
 *
 */
public class BLTimeLogger {
	
	private static Logger logger = null;
	private static FBoolean fgSwtich = null;
	private long begintime = 0;
	
	static {
		Module module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.bl");
		logger = module.getContext().getLogger("time.log");
		module.getContext().setLogLevel("time.log", Level.INFO);
		fgSwtich = BlParams.BLSWICH1001();
	}
	
	/**
	 * 业务开始
	 * @param msg
	 */
	public void begin(String bizName) {
		
		if(FBoolean.FALSE.equals(fgSwtich))
			return;
		
		begintime = System.currentTimeMillis();
		logger.info(String.format("------%s开始------", bizName));
	}
	
	/**
	 * 业务结束
	 * @param msg
	 */
	public void end(String bizName) {
		
		if(FBoolean.FALSE.equals(fgSwtich))
			return;
		
		long cost = System.currentTimeMillis() - begintime;
		logger.info(String.format("------%s结束,耗时:%sms------", bizName, cost));
	}
}
