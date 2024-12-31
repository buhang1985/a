package iih.bd.fc.querule.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.d.RuleCtrlTp;
import xap.mw.core.data.BizException;

/**
 * 获取匹配规则明细BP
 * @author yank
 *
 */
public class GetMatchRuleItmBP {	
	private static final int DEFAULT_LEVEL = 0;//默认等级
	/**
	 * 获取规则匹配项
	 * @param ruleAggDO 规则agg
	 * @param priorityDTO 就诊信息
	 * @return 规则项
	 * @throws BizException
	 */
	public QueRuleItmDO exec(QueruleAggDO ruleAggDO,PriorityDTO priorityDTO) {
		int priLevel = DEFAULT_LEVEL;//优先级默认为0
		int maxLevel = DEFAULT_LEVEL;//最大默认0
		QueRuleItmDO matchItm = null;
		if (ruleAggDO != null) {
			QueRuleItmDO[] items = ruleAggDO.getQueRuleItmDO();
			boolean firstMeet = true;
			if (items != null && items.length > 0) {
				RuleMatchBP ruleMatchBP = new RuleMatchBP();
				for (QueRuleItmDO item : items) {
					if(!ruleMatchBP.isMatchRule(ruleAggDO.getParentDO().getSd_quebentp(),item, priorityDTO)){
						continue;//不匹配，则过滤
					}
					if (!RuleCtrlTp.LEVELCTRL.equals(item.getEu_ctrltp())){
						continue;
					}
					priLevel = item.getLevel_pri();
					if(firstMeet){
						maxLevel = priLevel;
						matchItm = item;
						firstMeet = false;
					}else{
						if(maxLevel<= priLevel){
							maxLevel = priLevel;
							matchItm = item;
						}
					}
				}
			}
		}
		return matchItm;
	}
	
	
	

}
