package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;

/**
 * 按照医嘱id进行检查分单<br>
 * 一条检查医嘱一个申请单
 * 
 * @author HUMS
 *
 */
public class SplitRisByIdOr extends AbstractRisSplitRuleExecutor {

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {
		return rRisDataMerge.getId_or();
	}

}
