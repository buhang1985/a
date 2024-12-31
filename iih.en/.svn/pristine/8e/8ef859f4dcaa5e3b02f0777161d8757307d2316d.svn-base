package iih.en.que.s.bp.pharm;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.i.IRuleQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查站点是否符合BP
 * @author yank
 *
 */
public class CheckSiteMatchBP {
	/**
	 * 是否符合规则
	 * @param queSiteId 站点id
	 * @param priDTO 优先级DTO
	 * @return
	 * @throws BizException
	 */
	public boolean isMeet(String queSiteId,PriorityDTO priDTO) throws BizException{
		IRuleQryService ruleQryService = ServiceFinder.find(IRuleQryService.class);
		IRuleExecService ruleExecService = ServiceFinder.find(IRuleExecService.class);
		QueruleAggDO queRule = ruleQryService.getSiteRule(queSiteId);
		if(queRule!=null){
			return ruleExecService.canEnter(queRule, priDTO);
		}
		
		return true;
	} 
}
