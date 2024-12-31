package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消到诊
 * 
 * @author Liu Bin
 *
 */
public class CancelSignInBP {

	/**
	 * 取消到诊
	 * 
	 * @param entQueId
	 * @throws BizException
	 */
	public void exec(String entQueId) throws BizException{
		EnValidator.validateParam("entQueId", entQueId);
		
		EnQueueDO enQueue = ServiceFinder.find(IEnqueueRService.class).findById(entQueId);
		if (enQueue != null) {
			this.volidate(enQueue);
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
			ServiceFinder.find(IEnqueueCudService.class).save(new EnQueueDO[] { enQueue });
			//触发事件
			this.invoke(enQueue.getId_que(), enQueue.getId_que_site(), enQueue.getCode_entp(), enQueue.getId_ent());
		}else{
			throw new BizException(IEnMsgConst.ERROR_CANCEL_SIGNIN_WRONG);
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
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_CANC_SIGNIN);
	}
	/**
	 * 验证
	 * 
	 * @param enQueue
	 * @throws BizException 
	 */
	private void volidate(EnQueueDO enQueue) throws BizException{
		if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(enQueue.getSd_status_acpt()))
			throw new BizException("该患者已经取消到诊！");
		if(!IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(enQueue.getSd_status_acpt()))
			throw new BizException("该患者就诊状态已经改变，请刷新后重试！");
		if(!EnValidator.isEmpty(enQueue.getId_que_site()))
			throw new BizException("该患者已经分诊,不能取消到诊！");
	}
}
