package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据就诊类型生成处方<br>
 * 急诊处方（就诊类型为急诊）
 * 
 * @author HUMS
 *
 */
public class PresByCodeEntpEt extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		
		if (orderPresSplit.getCode_entp().startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) {
			return true;
		}
		return false;
	}

}
