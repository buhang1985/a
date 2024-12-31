package iih.en.pv.s.bp;

import iih.pi.reg.i.IPiRegQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 从患者那同步chis 的患者，并返回患者的id
 * @author Sarah
 *
 */
public class GetPatIdForAp {
	/**
	 * 为手机App提供 同步chis患者的功能 并返回对应的患者id
	 * @param codePat
	 * @return
	 * @throws BizException 
	 */
	public String exec (String codePat) throws BizException{
		IPiRegQryService  qService = ServiceFinder.find(IPiRegQryService.class);
		return qService.getPatIdForAp(codePat);
	}
}
