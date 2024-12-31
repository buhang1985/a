package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据超量开单原因特殊病进行分方
 * 
 * @author HUMS
 *
 */
public class PresByExcessiveReason4 extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		String excessive_reason = orderPresSplit.getSd_excessive_reason();
		if (ICiDictCodeConst.SD_EXCESSIVE_REASON_EXCEPTIONAL.equals(excessive_reason)) {
			return true;
		}
		return false;
	}

}
