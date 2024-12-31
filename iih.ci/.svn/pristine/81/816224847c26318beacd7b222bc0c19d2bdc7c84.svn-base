package iih.ci.ord.s.bp.cfg.rulecfg.rule.ris;

import iih.ci.ord.cfg.dto.ris.d.RisDataMergeDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 按照是否为医保进行检查分组
 * 
 * @author HUMS
 *
 */
public class SplitRisByFgOrHp extends AbstractRisSplitRuleExecutor {

	@Override
	protected String getIdentification(RisDataMergeDTO rRisDataMerge) {

		// 医嘱项目分：临床费用项目和执行操作费用项目。该标识为true时标识该医嘱中临床费用项目中至少有一条fg_selfpay=false的。
		// 特别说明fg_selfpay=true是保外（自费）、fg_selfpay=false是保内
		if (FBoolean.TRUE.equals(rRisDataMerge.getFg_orhp())) {
			return FBoolean.TRUE.toString();
		}
		
		return FBoolean.FALSE.toString();
	}
}
