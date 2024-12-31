package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检查是否已经结算
 * 
 * @author yank
 *
 */
public class CheckHasSettledBP {
	/**
	 * 判定就诊是否已经结算
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);

		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(entId);
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}

		return pvDO.getFg_st();
	}
}
