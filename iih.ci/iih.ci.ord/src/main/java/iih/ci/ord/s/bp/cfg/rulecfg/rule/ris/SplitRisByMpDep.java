package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;

/**
 * 按照执行科室是否相同进行检查分组
 * 
 * @author HUMS
 *
 */
public class SplitRisByMpDep extends AbstractRisSplitRuleExecutor {

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {

		return rRisDataMerge.getId_dep_mp();
	}

}
