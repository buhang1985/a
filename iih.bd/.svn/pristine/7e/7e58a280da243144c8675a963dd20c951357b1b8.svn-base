package iih.bd.fc.querule.s;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.s.bp.BatchCalcIpAptPriBP;
import iih.bd.fc.querule.s.bp.BatchCalcPriorityByRuleIdBP;
import iih.bd.fc.querule.s.bp.CalcPriBP;
import iih.bd.fc.querule.s.bp.CalcPriorityByRuleIdBP;
import iih.bd.fc.querule.s.bp.CanEnterQueBP;
import iih.bd.fc.querule.s.bp.GetMatchRuleItmBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 规则执行服务
 * @author yankan
 *
 */
@Service(serviceInterfaces={IRuleExecService.class}, binding=Binding.JSONRPC)
public class RuleExecServiceImpl implements IRuleExecService {	
	public RuleExecServiceImpl(){}
	
	/**
	 * 计算优先级
	 * @param ruleAggDO 规则AggDO
	 * @param priDTO 优先级DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public int calcPri(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException{
		CalcPriBP calcBP = new CalcPriBP();
		return calcBP.exec(ruleAggDO, priDTO);		
	}
	/**
	 * 获取规则匹配项
	 * @param ruleAggDO 规则agg
	 * @param priDTO 优先级DTO
	 * @return 规则项
	 * @throws BizException
	 */
	@Override
	public QueRuleItmDO getMatchRuleItm(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException{
		GetMatchRuleItmBP getBP = new GetMatchRuleItmBP();
		return getBP.exec(ruleAggDO, priDTO);	
	}
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTO 优先级DTO
	 * @throws BizException
	 */
	@Override
	public int calcPriByRuleId(String ruleId,PriorityDTO priDTO) throws BizException{		
		CalcPriorityByRuleIdBP calcBP = new CalcPriorityByRuleIdBP();
		return calcBP.exec(ruleId, priDTO);		
	}
	/**
	 * 计算优先级
	 * @param ruleId 规则id
	 * @param priDTOs 优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	@Override
	public PriorityDTO[] calcPriBatch(String ruleId,PriorityDTO[] priDTOs) throws BizException{
		BatchCalcPriorityByRuleIdBP batchCalcBP = new BatchCalcPriorityByRuleIdBP();
		return batchCalcBP.exec(ruleId,priDTOs);
	}
	/**
	 * 计算住院预约优先级
	 * @param priDTOs 计算优先级DTO
	 * @return 计算完成在DTO中Level_pri获取
	 * @throws BizException
	 */
	@Override
	public PriorityDTO[] batchCalcIpAptPri(PriorityDTO[] priDTOs) throws BizException{
		BatchCalcIpAptPriBP batchCalcBP = new BatchCalcIpAptPriBP();
		return batchCalcBP.exec(priDTOs);
	}
	/**
	 * 是否可进入
	 * 备注：最大可进入原则，只要有一条可允许，则可进入，即使有禁止规则明细
	 * @param ruleAggDO 规则aggDO
	 * @param priDTO 优先级DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean canEnter(QueruleAggDO ruleAggDO,PriorityDTO priDTO) throws BizException{
		CanEnterQueBP checkBP = new CanEnterQueBP();
		return checkBP.exec(ruleAggDO, priDTO);
	}
}
