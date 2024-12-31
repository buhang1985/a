package iih.bd.fc.querule.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;

/**
 * 批量计算住院预约优先级
 * @author yank
 *
 */
public class BatchCalcIpAptPriBP {
	/**
	 * 批量计算住院预约优先级
	 * @param priDTOs 计算优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	public PriorityDTO[] exec(PriorityDTO[] priDTOs) throws BizException{
		if(ArrayUtil.isEmpty(priDTOs)){
			return priDTOs;
		}
		//1、查询规则DO
		GetIpAptRuleBP getRuleBP = new GetIpAptRuleBP();
		QueruleAggDO ruleAggDO = getRuleBP.exec();
		
		//2、计算优先级
		BatchCalcPriorityBP batchCalBP = new BatchCalcPriorityBP();
		batchCalBP.exec(ruleAggDO, priDTOs);
		
		return priDTOs;
	}
}
