package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 按照科研项目ID进行检查分单，一个科研项目分配到一个检查打印单
 * @author HUMS
 *
 */
public class SplitRisByResearchProject extends AbstractRisSplitRuleExecutor{

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {

		if(FBoolean.TRUE.equals(rRisDataMerge.getFg_research())){
			return rRisDataMerge.getId_researchproject();	
		}
		
		return null;		
	}

}
