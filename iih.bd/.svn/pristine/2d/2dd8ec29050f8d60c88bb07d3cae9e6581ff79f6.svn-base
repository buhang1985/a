package iih.bd.fc.querule.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.d.RuleCtrlTp;
import xap.mw.core.data.BizException;

/**
 * 是否可进入队列BP
 * @author yank
 *
 */
public class CanEnterQueBP {
	/**
	 * 是否可进入
	 * 1、默认不可进入
	 * 2、禁止和允许只能有一种
	 * @param ruleAggDO 规则aggDO
	 * @param priDTO 优先级dto
	 * @return
	 * @throws BizException
	 */
	public boolean exec(QueruleAggDO ruleAggDO, PriorityDTO priDTO) throws BizException {
		boolean allow = false; // 默认不可进
		if (ruleAggDO == null)
			return false;
		QueRuleItmDO[] rueItms = (QueRuleItmDO[]) ruleAggDO.getChildren(QueRuleItmDO.class);
		RuleMatchBP ruleMatchBP = new RuleMatchBP();
		for (QueRuleItmDO ruleItm : rueItms) {
			if (!ruleMatchBP.isMatchRule(ruleAggDO.getParentDO().getSd_quebentp(), ruleItm, priDTO))
				continue;// 不匹配，则过滤
			if (RuleCtrlTp.ALLOWENTRY.equals(ruleItm.getEu_ctrltp())) {
				allow = true;
				break;
			} else if (RuleCtrlTp.FORBIDENTRY.equals(ruleItm.getEu_ctrltp())) {
				allow = false;
				break;
			}
		}

		return allow;
	}
}
