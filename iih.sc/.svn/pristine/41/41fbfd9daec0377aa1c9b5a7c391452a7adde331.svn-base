package iih.sc.apt.s.bp;

import iih.en.pv.i.IEnOutCmdService;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预约划价
 * @author yank
 *
 */
public class PricingOpAptBP {
	/**
	 * 划价
	 * @param aptDTO 预约信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	public OpAptDTO exec(OpAptDTO aptDTO,FBoolean fgAcc,FBoolean fgPrint) throws BizException{
		IEnOutCmdService en4AptService = ServiceFinder.find(IEnOutCmdService.class);
		return en4AptService.pricing(aptDTO,fgAcc,fgPrint);
	}
}
