package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;

/**
 * 根据超量开单原因慢病进行分方
 * 
 * @author HUMS
 *
 */
public class PresByExcessiveReason2 extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		String excessive_reason = orderPresSplit.getSd_excessive_reason();
		if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(excessive_reason)) {
			return true;
		}
		return false;
	}

	@Override
	protected void setPresWord(CiOrPresSplitList ciOrPres) {
		ciOrPres.setId_prestpword(IBdSrvDictCodeConst.ID_PRESCRIPTION_FLAG_MXB);
		ciOrPres.setSd_prestpword(IBdSrvDictCodeConst.SD_PRESCRIPTION_FLAG_MXB);
	}
	
}
