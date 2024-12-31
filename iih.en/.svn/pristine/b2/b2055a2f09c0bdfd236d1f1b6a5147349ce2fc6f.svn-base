package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
/***
 * 取消分诊
 * @author fanlq
 * @date: 2020年3月19日 下午5:47:58
 */
public class CancTriageBP {
	/***
	 * @Description:取消分诊
	 * @param id_ent_que
	 * @throws BizException
	 */
	public void exec(String id_ent_que) throws BizException{
		if(EnValidator.isEmpty(id_ent_que)) return;
		EnQueEP ep = new EnQueEP();
		EnQueueDO enQueueDO = ep.getEnQueueById(id_ent_que);
		if(EnValidator.isEmpty(enQueueDO)){
			throw new BizException("未找到该就诊队列id对应的队列信息！");
		}
		enQueueDO.setStatus(DOStatus.UPDATED);
		enQueueDO.setId_que_site(null);
		enQueueDO.setDt_acpt(null);
		enQueueDO.setId_emp_acpt(null);
		enQueueDO.setSortno(null);
		ep.save(new EnQueueDO[]{enQueueDO});
		if(enQueueDO.getSortno() != null){
			this.invoke(enQueueDO.getId_que_site(), enQueueDO.getId_que(),enQueueDO.getId_ent_que(),enQueueDO.getSortno().toString(),enQueueDO.getId_queben(),IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE);
			this.invoke(enQueueDO.getId_que_site(), enQueueDO.getId_que(),enQueueDO.getId_ent_que(),enQueueDO.getSortno().toString(),enQueueDO.getId_queben(),IEnEventConst.EVENT_EN_ALL_SIGNIN);
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
