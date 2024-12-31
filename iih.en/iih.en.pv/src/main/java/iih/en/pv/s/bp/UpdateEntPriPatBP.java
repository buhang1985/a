package iih.en.pv.s.bp;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 更新就诊价格分类
 * @author yank
 * @since 2016-07-19
 *
 */
public class UpdateEntPriPatBP {
	/**
	 * 更新就诊价格分类
	 * @param entId 就诊id
	 * @param priPatId 价格分类id
	 * @throws BizException
	 * @author yank
	 */
	public void exec(String entId,String priPatId) throws BizException{
		EnValidator.validateParam("就诊ID", entId);
		EnValidator.validateParam("价格分类ID", priPatId);
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(entId);
		if(pvDO==null){
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		pvDO.setId_pripat(priPatId);
		pvDO.setStatus(DOStatus.UPDATED);
		pvEP.savePv(pvDO);		
	}
}
