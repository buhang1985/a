package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.sie.common.utils.StringUtils;

/**
 * 按病种进行分方
 * @author HUMS
 *
 */
public class PresByIdDsdef extends AbstractSinglePresRuleExecutor{

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		if(StringUtils.isNotEmpty(orderPresSplit.getId_dsdef())){
			return true;
		}
		return false;
	}
	
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {

		return orderPresSplit.getId_dsdef();
	}

}
