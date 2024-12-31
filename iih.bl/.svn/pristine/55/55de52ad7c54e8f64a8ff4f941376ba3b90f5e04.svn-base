package iih.bl.cg.ip.s.ep;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class InccaCommonEp {
	
	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * @param code_enttp  就诊类型代码
	 * @param id_srv 服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	public IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv) throws BizException {
		IBdInccaQueService iBdInccaQueService = ServiceFinder.find(IBdInccaQueService.class);
		return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
	} 
}
