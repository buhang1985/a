package iih.bd.fc.querule.s.bp;

import iih.bd.fc.pub.IBdFcConst;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import xap.mw.core.data.BizException;

/**
 * 计算优先级BP
 * @author yank
 *
 */
public class CalcPriBP {
	
	/**
	 * 计算优先级
	 * 取匹配规则的最大优先级,优先级可为负数
	 * @param ruleAggDO 规则AggDO
	 * @param priDTO 就诊DTO
	 * @return 优先级
	 * @throws BizException
	 */
	public int exec(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException{
		int priLevel = IBdFcConst.DEFAULT_PRIORITY_LEVEL;
		GetMatchRuleItmBP getRuleItmBP = new GetMatchRuleItmBP();
		QueRuleItmDO matchItm = getRuleItmBP.exec(ruleAggDO, priDTO);
		if(matchItm!=null){
			priLevel = matchItm.getLevel_pri();
		}
		return priLevel;
	}
}
