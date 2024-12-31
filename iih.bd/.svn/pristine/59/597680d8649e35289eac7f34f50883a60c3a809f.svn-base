package iih.bd.fc.querule.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IQueruleRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据规则ID计算优先级
 * @author yank
 *
 */
public class CalcPriorityByRuleIdBP {
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTO 优先级dto
	 * @throws BizException
	 */
	public int exec(String ruleId,PriorityDTO priDTO) throws BizException{
		IQueruleRService ruleRService = ServiceFinder.find(IQueruleRService.class);
		QueruleAggDO ruleAggDO = ruleRService.findById(ruleId);
		
		CalcPriBP calcBP = new CalcPriBP();
		return calcBP.exec(ruleAggDO, priDTO);
	}
}
