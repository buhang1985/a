package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据是医嘱id进行分方<br>
 * 
 * @author HUMS
 *
 */
public class PresByIdOr extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		return true;
	}

	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {

		return orderPresSplit.getId_or();
	}
}
