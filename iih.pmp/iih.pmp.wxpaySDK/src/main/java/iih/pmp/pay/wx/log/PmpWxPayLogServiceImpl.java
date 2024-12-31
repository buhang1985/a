package iih.pmp.pay.wx.log;

import com.founder.xap.runtime.msys.ModuleContextAware;

import iih.pmp.pay.log.BasePmpLogService;
import iih.pmp.pay.log.IPmpWxPayLogService;

/**
 * 支付平台微信支付日志服务
 * 
 * @author hao_wu 2019-3-7
 *
 */
public class PmpWxPayLogServiceImpl extends BasePmpLogService implements IPmpWxPayLogService, ModuleContextAware {

	@Override
	protected String getLogPath() {
		return "pay.wx.log";
	}

	@Override
	protected String getDebugLogPath() {
		return "pay.wx.debug.log";
	}
}
