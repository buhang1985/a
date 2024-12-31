package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
/***
 * 修改就诊队列状态
 * @author fanlq
 * @date: 2020年3月18日 上午10:29:29
 */
public class UpdateEntQueStatusBP {
	/***
	 * @Description:修改就诊队列状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException 
	 */
	public void exec(String id_ent_que,String status) throws BizException{
		if(EnValidator.isEmpty(id_ent_que) || EnValidator.isEmpty(status))return;
		EnQueEP ep = new EnQueEP();
		EnQueueDO enQueueDO = ep.getEnQueueById(id_ent_que);
		if(EnValidator.isEmpty(enQueueDO)){
			throw new BizException("未找到该就诊队列id对应的就诊队列！就诊队列id："+id_ent_que);
		}
		enQueueDO.setSd_status_acpt(status);
		enQueueDO.setStatus(DOStatus.UPDATED);
		ep.save(new EnQueueDO[]{enQueueDO});
		//发送事件
		String event = null;
		switch(status){
			case IEnDictCodeConst.SD_STATUS_ACPT_CHECKED:
				event = IEnEventConst.EVENT_EN_ALL_DOC_ACPT;
				break;
			case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT:
				event = IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT;
				break;
			case IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED:
				event = IEnEventConst.EVENT_EN_ALL_DIAGEND;
				break;
		}
		if(!EnValidator.isEmpty(event) && enQueueDO.getSortno() != null){
			this.invoke(enQueueDO.getId_que_site(), enQueueDO.getId_que(),enQueueDO.getId_ent_que(),enQueueDO.getSortno().toString(),enQueueDO.getId_queben(),event);
		}
	}
	/****
	 * 发送事件
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
