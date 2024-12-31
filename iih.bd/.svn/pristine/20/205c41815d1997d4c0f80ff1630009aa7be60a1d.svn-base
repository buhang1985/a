package iih.bd.fc.querule.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IQueruleRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量计算优先级
 * @author yank
 *
 */
public class BatchCalcPriorityByRuleIdBP {
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTOs 优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	public PriorityDTO[] exec(String ruleId, PriorityDTO[] priDTOs) throws BizException {
		if (ArrayUtil.isEmpty(priDTOs)) {
			return null;
		}
		//1、获取规则
		IQueruleRService ruleRService = ServiceFinder.find(IQueruleRService.class);
		QueruleAggDO ruleAggDO = ruleRService.findById(ruleId);
		
		//2、计算优先级
		BatchCalcPriorityBP batchCalBP = new BatchCalcPriorityBP();
		batchCalBP.exec(ruleAggDO, priDTOs);
		
		return priDTOs;
	}
}
