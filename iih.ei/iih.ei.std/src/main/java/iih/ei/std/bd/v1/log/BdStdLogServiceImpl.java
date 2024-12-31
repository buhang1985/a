package iih.ei.std.bd.v1.log;

import com.founder.xap.runtime.msys.ModuleContextAware;

/**
 * 基础数据_标准接口日志服务
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class BdStdLogServiceImpl extends BaseBdLogService implements IBdStdLogService, ModuleContextAware {

	@Override
	protected String getLogPath() {
		return "std.log";
	}

	@Override
	protected String getDebugLogPath() {
		return "std.debug.log";
	}
}
