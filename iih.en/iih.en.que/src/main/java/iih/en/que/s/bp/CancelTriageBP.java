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
import xap.mw.coreitf.d.FBoolean;

/**
 * 取消分诊
 * 
 * @author Administrator
 *
 */
public class CancelTriageBP {

	/**
	 * 取消分诊
	 * 
	 * @param entQueId 就诊队列ID
	 * @param manual 是否是分诊状态
	 * @throws BizException
	 */
	public void exec(String entQueId, FBoolean manual) throws BizException{
		EnValidator.validateParam("entQueId", entQueId);
		EnQueEP bp = new EnQueEP();
		EnQueueDO enQueue = bp.getEnQueueById(entQueId);
		if (enQueue != null) {
			this.volidate(enQueue);
			String siteId = enQueue.getId_que_site();
			enQueue.setId_que_site(null);
			enQueue.setSortno_called(0);
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setId_emp_opreg(null);
			enQueue.setFg_manual(manual);
			bp.save(new EnQueueDO[] { enQueue });
			//触发取消分诊事件
			this.invoke(enQueue.getId_que(), siteId, enQueue.getCode_entp(), enQueue.getId_ent());
		}else{
			throw new BizException(IEnMsgConst.ERROR_CANCEL_TRIAGE_WRONG);
		}
	}	
	/**
	 * 验证
	 * 
	 * @param enQueue
	 * @throws BizException 
	 */
	private void volidate(EnQueueDO enQueue) throws BizException{
		if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(enQueue.getSd_status_acpt())
				&& EnValidator.isEmpty(enQueue.getId_que_site()))
			throw new BizException("该患者已经取消分诊！");
		if(!IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(enQueue.getSd_status_acpt()))
			throw new BizException("该患者就诊状态已经改变，请刷新后重试！");
//		if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enQueue.getSd_status_acpt()))
//			throw new BizException("该患者已经叫号,不能取消分诊！");
//		if(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(enQueue.getSd_status_acpt()))
//			throw new BizException("该患者已经过号,不能取消分诊！");
//		if(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(enQueue.getSd_status_acpt()))
//			throw new BizException("该患者已经接诊,不能取消分诊！");
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
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_CANC_TRIAGE);
	}
}
