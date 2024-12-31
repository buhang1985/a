package iih.en.pv.s.bp;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊患者价格分类
 * @author yank
 *
 */
public class GetEntPriPatBP {
	/**
	 * 获取患者价格分类
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public String exec(String entId) throws BizException{
		EnValidator.validateParam("就诊ID", entId);
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pvDO=pvRService.findById(entId);
		if(pvDO==null){
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		}
		
		return pvDO.getId_pripat();
	}
}
