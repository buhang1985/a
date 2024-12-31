package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 过号
 * 
 * @author liubin
 *
 */
public class PassNumBP {
	private EnQueEP eqBp;
	
	public PassNumBP(){
		this.eqBp = new EnQueEP();
	}
	
	/**
	 * 过号
	 * 
	 * @param entQueId
	 * 		就诊队列ID
	 * @throws BizException
	 * @author liubin
	 */
	public void exec(String entQueId) throws BizException {
		EnValidator.validateParam("entQueId", entQueId);
		EnQueueDO enQueue = this.eqBp.getEnQueueById(entQueId);
		if (enQueue == null
				|| !IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enQueue.getSd_status_acpt())) {
			throw new BizException(IEnMsgConst.ERROR_PASS_NUM);
		}
		this.passNum(new EnQueueDO[]{enQueue});
	}
	
	/**
	 * 过号
	 * 
	 * @param entQueIds
	 * @throws BizException
	 */
	public void exec(String[] entQueIds) throws BizException{
		EnValidator.validateParam("entQueIds", entQueIds);
		EnQueueDO[] enQueues = this.eqBp.getEnQueueByIds(entQueIds);
		this.passNum(enQueues);
	}
	
	/**
	 * 过号
	 * 
	 * @param entQueIds
	 * @throws BizException
	 */
	public void exec(EnQueueDO[] enQueues) throws BizException{
		EnValidator.validateParam("enQueues", enQueues);
		this.passNum(enQueues);
	}
	
	/**
	 * 过号
	 * 
	 * @param enQueues
	 * @throws BizException
	 */
	private void passNum(EnQueueDO[] enQueues) throws BizException{
		EnValidator.validateParam("enQueues", enQueues);
		for (EnQueueDO enQueue : enQueues) {
			if (enQueue == null
					|| !IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enQueue.getSd_status_acpt())) {
				throw new BizException(IEnMsgConst.ERROR_PASS_NUM);
			}
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		}
		this.eqBp.save(enQueues);
		for (EnQueueDO enQueue : enQueues) {
			this.invoke(enQueue.getId_que(), enQueue.getId_que_site(), enQueue.getCode_entp(), enQueue.getId_ent());
		}
	}
	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_PASSNUM);
	}
}
