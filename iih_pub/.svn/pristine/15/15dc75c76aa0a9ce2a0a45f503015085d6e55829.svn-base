package iih.bd.fc.querule.i;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import xap.mw.core.data.BizException;

/**
 * 规则执行服务
 * @author yankan
 * @since date 2015-11-18
 *
 */
public interface IRuleExecService {
	/**
	 * 计算优先级
	 * @param ruleAggDO 规则AggDO
	 * @param priDTO 计算优先级DTO
	 * @return
	 * @throws BizException
	 */
	int calcPri(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException;
	/**
	 * 获取规则匹配项
	 * @param ruleAggDO 规则agg
	 * @param priDTO 计算优先级DTO
	 * @return 规则项
	 * @throws BizException
	 */
	QueRuleItmDO getMatchRuleItm(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException;
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTO 计算优先级DTO
	 * @throws BizException
	 */
	int calcPriByRuleId(String ruleId,PriorityDTO priDTO) throws BizException;
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTOs 计算优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	PriorityDTO[] calcPriBatch(String ruleId,PriorityDTO[] priDTOs) throws BizException;	
	/**
	 * 计算住院预约优先级
	 * @param priDTOs 计算优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	PriorityDTO[] batchCalcIpAptPri(PriorityDTO[] priDTOs) throws BizException;	
	/**
	 * 是否可进入
	 * 备注：最大可进入原则，只要有一条可允许，则可进入，即使有禁止规则明细
	 * @param ruleAggDO 规则aggDO
	 * @param priDTO 计算优先级DTO
	 * @return
	 * @throws BizException
	 */
	boolean canEnter(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException;
}
