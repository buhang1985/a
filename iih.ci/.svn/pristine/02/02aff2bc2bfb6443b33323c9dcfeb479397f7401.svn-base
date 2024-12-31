package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据超量开单原因分方
 * 
 * @author HUMS
 *
 */
public class PresByExcessiveReason extends AbstractSinglePresRuleExecutor {

	/**
	 * 按开单原因进行分组
	 */
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {

		return orderPresSplit.getSd_excessive_reason();
	}

	/**
	 * 如果超量开单原因不为空，按超量开单原因进行分组
	 */
	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		String excessive_reason = orderPresSplit.getSd_excessive_reason();
		if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(excessive_reason)
				|| ICiDictCodeConst.SD_EXCESSIVE_REASON_EXCEPTIONAL.equals(excessive_reason)
				|| ICiDictCodeConst.SD_EXCESSIVE_REASON_INCONVENIENCE.equals(excessive_reason)
				|| ICiDictCodeConst.SD_EXCESSIVE_REASON_SENILE.equals(excessive_reason)) {
			return true;
		}
		return false;
	}

}
