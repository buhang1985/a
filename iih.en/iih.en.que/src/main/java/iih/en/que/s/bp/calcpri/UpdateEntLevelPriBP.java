package iih.en.que.s.bp.calcpri;

import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.ICalcPriService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新患者的队列优先级
 * 
 * @author liubin
 */
public class UpdateEntLevelPriBP {
	/**
	 * 更新患者的队列优先级
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException {
		EnValidator.validateParam("entId", entId);
		EnQueEP bp = new EnQueEP();
		EnQueueDO[] enQueueDOs =  bp.getEnQueueByEntId(entId);
		EnValidator.validateParam("enQueueDOs", enQueueDOs);
		EnQueueDO enQueue = enQueueDOs[0];
		ICalcPriService priService = ServiceFinder.find(ICalcPriService.class);
		QueRuleItmDO queRuleItm = priService.getRuleItmByEntIdAndQueId(enQueue.getId_ent(), enQueue.getId_que());
		if(queRuleItm!=null){
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setLevel_pri(queRuleItm.getLevel_pri());
			enQueue.setLevel_pri_rsn(queRuleItm.getName());
			bp.save(new EnQueueDO[]{enQueue});
		}
	}
}
