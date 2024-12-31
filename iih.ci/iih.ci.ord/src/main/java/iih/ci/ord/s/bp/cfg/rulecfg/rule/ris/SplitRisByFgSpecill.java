package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;

/**
 * 按照是否为特殊病
 * @author HUMS
 *
 */
public class SplitRisByFgSpecill extends AbstractRisSplitRuleExecutor{

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {
		
		return rRisDataMerge.getFg_specill().toString();
	}

}
