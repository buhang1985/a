package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;

/**
 * 按照检查属性中分组标识是否相同进行检查分组
 * @author HUMS
 *
 */
public class SplitRisByObsgroup extends AbstractRisSplitRuleExecutor {

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {

		if(StringUtils.isEmpty(rRisDataMerge.getObsgroup())){
			return rRisDataMerge.getId_or();
		}
		return rRisDataMerge.getObsgroup();
	}
}
