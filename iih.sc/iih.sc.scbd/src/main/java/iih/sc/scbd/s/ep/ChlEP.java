package iih.sc.scbd.s.ep;

import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 渠道EP
 * @author yank
 *
 */
public class ChlEP {
	/**
	 * 获取排班渠道
	 * @param chlId 排班渠道id
	 * @return
	 * @throws BizException
	 */
	public SchedulechlDO getChlById(String chlId) throws BizException{
		ISchedulechlMDORService chlService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlService.findById(chlId);
		return chlDO;
	}	
}
