package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 按照科研项目ID进行处方分方，一个科研项目分配到一个处方
 * @author HUMS
 *
 */
public class PresByResearchProject extends AbstractPresRuleExecutor{

	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {

		return orderPresSplit.getId_researchproject();
	}

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		return FBoolean.TRUE.equals(orderPresSplit.getFg_research());
	}

}
