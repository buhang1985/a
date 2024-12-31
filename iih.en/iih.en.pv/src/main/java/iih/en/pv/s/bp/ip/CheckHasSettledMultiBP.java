package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 判定就诊是否已经结算(批量)
 * @author ly 2018/02/25
 *
 */
public class CheckHasSettledMultiBP {

	/**
	 * 判定就诊是否已经结算(批量)
	 * 
	 * @param entIds 就诊ID数组
	 * @return 判断结果map
	 * @throws BizException
	 */
	public FMap exec(String[] entIds) throws BizException {

		EnValidator.validateParam("判定就诊是否已经结算", "就诊ID数组", entIds);

		PvEP pvEP = new PvEP();
		PatiVisitDO[] pvDos = pvEP.getPvByIds(entIds);
		if (EnValidator.isEmpty(pvDos)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST + "就诊id:" + entIds[0]);
		}

		FMap map = new FMap();
		for (String entId : entIds) {
			boolean exist = false;
			for (PatiVisitDO pvDo : pvDos) {
				if (entId.equals(pvDo.getId_ent())) {
					map.put(entId, pvDo.getFg_st());
					exist = true;
					break;
				}
			}

			if (!exist) {
				throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST + "就诊id:" + entId);
			}
		}

		return map;
	}
}
