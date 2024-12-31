package iih.en.pv.s.bp.ip;

import iih.bl.cg.i.IBlOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 入院登记自动记账Bp
 * 
 * @author jizb
 * 
 */
public class ChargeForIpRegisterBP {
	/**
	 * 入院登记自动记账
	 * @param entId 就诊id
	 * @param fgFirst 是否首次入院
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	public FBoolean exec(String entId, FBoolean fgFirst) throws BizException {
		IBlOutCmdService service = ServiceFinder.find(IBlOutCmdService.class);
		return service.chargeForIpRegister(entId, fgFirst);
	}
}
