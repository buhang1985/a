package iih.bd.pp.log;

import com.founder.xap.runtime.msys.ModuleContextAware;

import iih.bd.base.log.BaseBdLogService;
import iih.bd.log.IBdPpLogService;

/**
 * 基础数据_付款策略日志服务
 * 
 * @author hao_wu 2019-1-25
 *
 */
public class BdPpLogServiceImpl extends BaseBdLogService implements IBdPpLogService, ModuleContextAware {

	@Override
	protected String getLogPath() {
		return "pp.log";
	}

	@Override
	protected String getDebugLogPath() {
		return "pp.debug.log";
	}
}
