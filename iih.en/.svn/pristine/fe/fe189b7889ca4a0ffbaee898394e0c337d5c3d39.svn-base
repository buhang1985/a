package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.DeathOrCheckListener;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
/**
 * 死亡医嘱监听事件
 * @author renying
 *
 */
public class EnDeathOrCheckListener extends DeathOrCheckListener {
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		// 更新就诊状态
		if (EnValidator.isEmpty(ors))
			return;
		for (CiOrderDO cior : ors) {
			IpEP ipep = new IpEP();
			InpatientDO[] inpatientDOs = ipep.getIpDOByEntId(cior.getId_en());
			if (EnValidator.isEmpty(inpatientDOs)) {
				throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
			}
			inpatientDOs[0].setDt_death(EnAppUtils.getServerDateTime());
			inpatientDOs[0].setStatus(DOStatus.UPDATED);
			inpatientDOs[0].setSd_gowhere(IBdFcDictCodeConst.SD_LVHOS_DEAD);
			inpatientDOs[0].setId_gowhere(IBdFcDictCodeConst.ID_LVHOS_DEAD);
			ipep.updateIpDOs(new InpatientDO[] { inpatientDOs[0] });
		}
	}

	/**
	 * 判定是否为特定医嘱
	 */
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		// 是否为化疗医嘱判断
		if (CiOrderTypeEnum.DEATHORDER.equals(CiOrPubUtils.getCiOrderType(or)))
			return true;
		return false;
	}
}
