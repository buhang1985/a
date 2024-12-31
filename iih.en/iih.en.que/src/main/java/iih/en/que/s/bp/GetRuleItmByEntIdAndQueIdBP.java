package iih.en.que.s.bp;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.i.IRuleQryService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊在队列符合的规则明细
 * @author yankan
 *
 */
public class GetRuleItmByEntIdAndQueIdBP {
	/**
	 * 获取就诊优先级的规则明细
	 * @param entId 就诊id
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	public QueRuleItmDO exec(String entId, String queId) throws BizException {
		QueRuleItmDO level_pri = null;
		GetEntInfo4CalPriBP getPriority = new GetEntInfo4CalPriBP();
		PriorityDTO entDTO = getPriority.exec(entId);			
		IRuleQryService qryService = ServiceFinder.find(IRuleQryService.class);
		IRuleExecService execService = ServiceFinder.find(IRuleExecService.class);				
		if(!EnValidator.isEmpty(queId)){
			QueruleAggDO agg = qryService.getQueRule(queId);
			if(agg!=null){
				level_pri = execService.getMatchRuleItm(agg, entDTO);
			}
		}
		return level_pri;
	}
}
