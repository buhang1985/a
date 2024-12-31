package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;

/**
 * 按照打印模板是否相同进行检查分组
 * @author HUMS
 *
 */
public class SplitRisByPrnTmpl extends AbstractRisSplitRuleExecutor{

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {

		return rRisDataMerge.getId_emsprntmpl();
	}

}
