package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

/**
 * 就诊队列BP 新增队列、处理队列状态
 * 
 * @author yankan
 *
 */
public class EnQueBP {
	/**
	 * 更新队列状态
	 * 
	 * @param enQueId
	 *            就诊队列id
	 * @param acptStatus
	 *            状态编码
	 * @throws BizException
	 */
	public void updateStatus(String enQueId, String acptStatus) throws BizException {
		if (EnValidator.isEmpty(enQueId)) {
			throw new BizException("参数enQueId为null!");
		}
		EnQueueDO enQueDO = this.getEnQue(enQueId);
		if (enQueDO == null) {
			throw new BizException("就诊队列不存在！");
		}
		enQueDO.setStatus(DOStatus.UPDATED);
		enQueDO.setSd_status_acpt(acptStatus);
		// enQueDo.setId_status_acpt(acptStatus);//TODO 处理状态ID
		this.updateEnQue(enQueDO);
		//发送事件，fanlq-2018-07-10
		String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
		switch(acptStatus){
			case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT://取消处置
		 		this.invoke(enQueDO.getId_que_site(), enQueDO.getId_que(), enQueDO.getId_ent_que(),ticketno, IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT);
		 		break;
		 	case IEnDictCodeConst.SD_STATUS_ACPT_CHECKED://处置
		 		this.invoke(enQueDO.getId_que_site(), enQueDO.getId_que(),enQueDO.getId_ent_que(), ticketno, IEnEventConst.EVENT_EN_ALL_DOC_ACPT);
		 		break;
		 	case  IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED://处置完成
		 		this.invoke(enQueDO.getId_que_site(), enQueDO.getId_que(), enQueDO.getId_ent_que(), ticketno,IEnEventConst.EVENT_EN_ALL_DIAGEND);
		 		break;
		}
	}

	/**
	 * 通用队列管理节点--更新队列状态
	 * 
	 * @param enQueId
	 *            就诊队列id
	 * @param callNum
	 *            最大叫号次数，当叫号次输等于最大叫号次数状态更新为过号，否则状态是叫号
	 * @param isUpdateState
	 *            true:只增加叫号次数 false：增加叫号次数，更新状态
	 * @throws BizException
	 */
	public String updateStatusForAll(String enQueId, String oldEntQue) throws BizException {
		EnQueueDO enQueDOclone = new EnQueueDO();
		//0137687: 通用分诊，两个诊室同时叫号时会出现叫号序号混乱的情况-增加锁机制
		boolean lock = PKLock.getInstance().addDynamicLock(enQueId, 5 * 1000);
		if(!lock){
			throw new BizException("当前数据正在被他人修改，请稍后重新操作！");
		}
		if (!EnValidator.isEmpty(enQueId)) {
			EnQueueDO enQueDO = this.getEnQue(enQueId);
			if (enQueDO == null) {
				throw new BizException("就诊队列不存在！");
			}
//			if (!enQueDO.getSd_status_acpt().equals(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT)) {
//				throw new BizException("患者状态已改变，请刷新后重试！");
//			}
			enQueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			enQueDO.setStatus(DOStatus.UPDATED);
			this.updateEnQue(enQueDO);
			String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
			this.invoke(enQueDO.getId_que_site(), enQueDO.getId_que(),enQueDO.getId_ent_que(),ticketno, IEnEventConst.EVENT_EN_ALL_CALLNUM);
			enQueDOclone = (EnQueueDO)enQueDO.clone();
		}
		// oldEntQue不为空时，更新上一个患者为过号状态
		if (!EnValidator.isEmpty(oldEntQue)) {
			EnQueueDO oldEnQueDO = this.getEnQue(oldEntQue);
			if (oldEnQueDO == null) {
				throw new BizException("就诊队列不存在！");
			}
			if (!oldEnQueDO.getSd_status_acpt().equals(IEnDictCodeConst.SD_STATUS_ACPT_CALL)) {
				throw new BizException("患者状态已改变，请刷新后重试！");
			}
			oldEnQueDO.setStatus(DOStatus.UPDATED);
			oldEnQueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
			this.updateEnQue(oldEnQueDO);
			String ticketno = oldEnQueDO.getTicketno()      == null ? null : oldEnQueDO.getTicketno().toString();
			this.invoke(oldEnQueDO.getId_que_site(), oldEnQueDO.getId_que(),oldEnQueDO.getId_ent_que(),ticketno, IEnEventConst.EVENT_EN_ALL_PASSNUM);
		}
		return enQueDOclone.getTicketno() ==null ? null:enQueDOclone.getTicketno().toString();
	}
	/**
	 * 选择叫号
	 * 
	 * @param enQueId
	 *            就诊队列id
	 * @param callNum
	 *            最大叫号次数，当叫号次输等于最大叫号次数状态更新为过号，否则状态是叫号
	 * @param isUpdateState
	 *            true:只增加叫号次数 false：增加叫号次数，更新状态
	 * @throws BizException
	 */
	public void selectedCallNum(String enQueId) throws BizException {
		if (!EnValidator.isEmpty(enQueId)) {
			EnQueueDO enQueDO = this.getEnQue(enQueId);
			if (enQueDO == null) {
				throw new BizException("就诊队列不存在！");
			}
			if(!EnValidator.isEmpty(enQueDO.getId_que_site())){
				BdSiteEP ep = new BdSiteEP();
				ep.siteError(enQueDO.getId_que_site());
			}
			String ticketno = enQueDO.getTicketno() == null ? null : enQueDO.getTicketno().toString();
			this.invoke(enQueDO.getId_que_site(), enQueDO.getId_que(),enQueDO.getId_ent_que(),ticketno, IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM);
		}
	}
	/**
	 * 删除就诊队列
	 * 
	 * @param enQueId
	 *            就诊队列id
	 * @param realDelete
	 *            是否真删除
	 * @throws BizException
	 */
	public void delete(String enQueId, FBoolean realDelete) throws BizException {
		if (EnValidator.isEmpty(enQueId)) {
			throw new BizException("参数enQueId为null!");
		}
		EnQueueDO enQueDO = this.getEnQue(enQueId);
		if (enQueDO == null) {
			throw new BizException("就诊队列不存在！");
		}
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		if (FBoolean.TRUE.equals(realDelete)) {
			enQueCudService.delete(new EnQueueDO[] { enQueDO });
		} else {
			enQueDO.setStatus(DOStatus.DELETED);// 删除
			enQueCudService.update(new EnQueueDO[] { enQueDO });
		}
	}

	/**
	 * 获取就诊队列DO
	 * 
	 * @param entQueId
	 *            就诊队列id
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO getEnQue(String enQueId) throws BizException {
		IEnqueueRService enQueRService = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO enQueDO = enQueRService.findById(enQueId);
		return enQueDO;
	}

	/**
	 * 更新就诊队列
	 * 
	 * @param enQueDO
	 *            就诊队列DO
	 * @throws BizException
	 */
	public void updateEnQue(EnQueueDO enQueDO) throws BizException {
		IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
		enQueCudService.update(new EnQueueDO[] { enQueDO });
	}

	/****
	 * 发送事件-fanlq-2018-07-10
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String queId,String entqueId,String ticketno,String event) throws BizException{
		AllQueEvent ev = new AllQueEvent();
		ev.exec(quesiteId, queId,entqueId,ticketno,null, event);
	}
}
