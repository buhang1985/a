package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;

/**
 * 根据就诊类型生成处方<br>
 * 急诊处方（当前就诊科室与参数模板中配置的急诊科室匹配）
 * 就诊类型 Code_entp_ext 来源于参数模板LL_CIOR0315（是否急诊就诊判断方式） ，LL_CIOR0320（是否急诊就诊科室）
 * 当 LL_CIOR0315 为1 时，按就诊科室判断是否为急诊，LL_CIOR0320 对应急诊科室，如果当前就诊科室与LL_CIOR0320 匹配，本次就诊为急诊
 * @author HUMS
 *
 */
public class PresByCodeEntpExtEt extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {
		
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(orderPresSplit.getCode_entp_ext())) {
			return true;
		}
		return false;
	}

}