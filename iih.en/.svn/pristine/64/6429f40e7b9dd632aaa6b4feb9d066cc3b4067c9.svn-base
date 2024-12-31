package iih.en.pv.s.bp.op.st;

import iih.bl.cg.i.IBlOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消记账
 * @author Anninglbj
 *
 */
public class CancPricingBP {
	/**
	 * 取消记账
	 * @param entId
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException{
		IBlOutCmdService serv = ServiceFinder.find(IBlOutCmdService.class);
		serv.refundForOpRegister(entId);
	}
}
