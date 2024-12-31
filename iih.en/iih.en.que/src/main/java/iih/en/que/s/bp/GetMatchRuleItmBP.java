package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.i.IRuleQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.s.EnqueueCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 得到门急诊就诊优先级的规则明细
 * @author yank
 *
 */
public class GetMatchRuleItmBP {
	/**
	 * 得到门急诊就诊优先级的规则明细
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public QueRuleItmDO exec(String entId) throws BizException {
		QueRuleItmDO level_pri = null;
		GetEntInfo4CalPriBP getEntInfoBP = new GetEntInfo4CalPriBP();
		PriorityDTO entDTO = getEntInfoBP.exec(entId);		
		EnqueueCrudServiceImpl service = new EnqueueCrudServiceImpl();		
		IRuleQryService qryService = ServiceFinder.find(IRuleQryService.class);
		IRuleExecService execService = ServiceFinder.find(IRuleExecService.class);		
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.SD_ENTQUE_TP = '%s' ", EnQueueDODesc.TABLE_ALIAS_NAME,entId,EnQueueDODesc.TABLE_ALIAS_NAME,IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] enQueDOs = service.find(whereStr, null, FBoolean.FALSE);		
		if(!EnValidator.isEmpty(enQueDOs)&&entDTO!=null){
			if(!EnValidator.isEmpty(enQueDOs[0].getId_que())){
				QueruleAggDO agg = qryService.getQueRule(enQueDOs[0].getId_que());
				if(agg!=null){
					level_pri = execService.getMatchRuleItm(agg, entDTO);
				}
			}
		}else{
			throw new BizException("数据出错，未找到就诊优先级！");
		}
		return level_pri;
	}
}
