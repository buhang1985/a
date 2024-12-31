package iih.bd.fc.querule.s;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IQueruleRService;
import iih.bd.fc.querule.i.IRuleQryService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 规则查询服务
 * @author yankan
 *
 */
@Service(serviceInterfaces={IRuleQryService.class}, binding=Binding.JSONRPC)
public class RuleQryServiceImpl implements IRuleQryService {
	/**
	 * 查询分诊台的规则
	 * @param benId 分诊台id
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueruleAggDO getBenRule(String benId) throws BizException{
		IQuebenRService benRService = ServiceFinder.find(IQuebenRService.class);
		QueBenDO benDO = benRService.findById(benId);
		if(benDO!=null){
			String ruleId = benDO.getId_querule();
			if(!StringUtil.isEmpty(ruleId)){
				IQueruleRService ruleRService = new QueruleCrudServiceImpl();
				return ruleRService.findById(ruleId);
			}
		}
		return null;
	}
	/**
	 * 查询队列规则
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueruleAggDO getQueRule(String queId) throws BizException {
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO queDO = queRService.findById(queId);
		QueruleAggDO ruleAggDO = null;
		if (queDO != null) {
			String ruleId = queDO.getId_querule();
			if (!StringUtil.isEmpty(ruleId)) {
				IQueruleRService ruleRService = new QueruleCrudServiceImpl();
				ruleAggDO = ruleRService.findById(ruleId);
			}
			if (ruleAggDO == null) {
				// 如果队列规则为null，则取分诊台规则
				ruleAggDO = this.getBenRule(queDO.getId_queben());
			}
		}
		return ruleAggDO;
	}
	/**
	 * 查询工作点规则
	 * @param siteId 工作点id
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueruleAggDO getSiteRule(String siteId) throws BizException{
		IQuesiteRService queRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO siteDO = queRService.findById(siteId);
		
		QueruleAggDO ruleAggDO = null;
		if(siteDO!=null){
			String ruleId = siteDO.getId_querule();
			if(!StringUtil.isEmpty(ruleId)){
				IQueruleRService ruleRService = new QueruleCrudServiceImpl();
				ruleAggDO = ruleRService.findById(ruleId);		
			}		
			if(ruleAggDO==null){				
				ruleAggDO = this.getQueRule(siteDO.getId_que());//如果队列规则为null，则取队列规则
			}	
		}
		return ruleAggDO;
	}
}
