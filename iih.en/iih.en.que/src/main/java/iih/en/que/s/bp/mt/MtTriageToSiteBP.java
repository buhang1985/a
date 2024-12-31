package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
/***
 * 分诊
 * @author fanlq
 * @date: 2020年3月20日 下午2:56:55
 */
public class MtTriageToSiteBP {

	/**
	 * 分诊
	 * 
	 * @param triageQueSite
	 * 		目标工作站点DTO 
	 * @param entQueId
	 * @param isAutoTriage 是否是自动分诊
	 * 		就诊队列ID
	 * @throws BizException
	 */
	public EnQueueDO exec(TriageQueSiteDTO triageQueSite, String entQueId) throws BizException {
		EnValidator.validateParam("TriageQueSiteDTO", triageQueSite);
		EnValidator.validateParam("entQueId", entQueId);
		EnQueEP queBP = new EnQueEP();
		EnQueueDO enQueue = queBP.getEnQueueById(entQueId);
		if(enQueue == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		this.volidate(triageQueSite, enQueue);
		enQueue.setStatus(DOStatus.UPDATED);
		enQueue.setId_que(triageQueSite.getId_que());
		enQueue.setId_que_site(triageQueSite.getId_quesite());
		enQueue.setId_emp_acpt(triageQueSite.getId_emp());
		enQueue.setId_emp_opreg(triageQueSite.getId_emp());
		enQueue.setDt_acpt(EnAppUtils.getServerDateTime());
		enQueue.setFg_manual(FBoolean.FALSE);
		if(triageQueSite.getTicketno() != null){
			enQueue.setSortno(triageQueSite.getTicketno());
			enQueue.setTicketno(triageQueSite.getTicketno());
		}
		queBP.save(new EnQueueDO[] {enQueue});
		//记录分诊事件
		new EnEvtHandle().insertTriageEvt(enQueue.getId_ent(), triageQueSite);
		//发送分诊消息
		if(enQueue.getSortno() != null){
			this.invoke(triageQueSite.getId_quesite(),triageQueSite.getId_que(),entQueId,enQueue.getSortno().toString(),enQueue.getId_queben(), IEnEventConst.EVENT_EN_ALL_TRIAGE);	
		}
		return enQueue;
	}

	/**
	 * 验证
	 * 
	 * @param triageQueSite
	 * @param enQueue
	 * @throws BizException 
	 */
	private void volidate(TriageQueSiteDTO triageQueSite, EnQueueDO enQueue) throws BizException{
		if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(enQueue.getSd_status_acpt()))
			throw new BizException("该患者已经取消到诊！");
	}
	
	/****
	 * 发送事件-fanlq-2018-07-10
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String queId,String entqueId,String ticketno,String id_queben,String event) throws BizException{
		AllQueEvent ev = new AllQueEvent();
		ev.exec(quesiteId, queId,entqueId, ticketno,id_queben,event);
	}
}
