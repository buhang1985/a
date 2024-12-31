package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/***
 * 修改站点状态
 * @author fanlq
 * @date: 2020年3月18日 上午10:07:15
 */
public class UpdateSiteStatusBP {

	/***
	 * @Description:修改站点状态
	 * @param id_que_site
	 * @param status
	 * @throws BizException 
	 */
	public void exec(String id_que_site,String status) throws BizException{
		if(EnValidator.isEmpty(id_que_site) || EnValidator.isEmpty(status))return;
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO queSiteDO = ep.getSiteById(id_que_site);
		if(EnValidator.isEmpty(queSiteDO)){
			throw new BizException("未找到该站点id对应的站点数据！站点id："+id_que_site);
		}
		queSiteDO.setEu_pause(status);
		queSiteDO.setStatus(DOStatus.UPDATED);
		ep.getSiteCudServ().save(new QueSiteDO[]{queSiteDO});
		//发送事件
		String event = null;
		switch(status){
			case PauseEnum.ONLINE:
				event = IEnEventConst.EVENT_EN_ALL_DOC_ONLINE;
				break;
			case PauseEnum.PAUSE:
				event = IEnEventConst.EVENT_EN_ALL_DOC_PAUSE;
				break;
			case PauseEnum.OFFLINE:
				event = IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE;
				break;
		}
		if(!EnValidator.isEmpty(event)){
			this.invoke(queSiteDO.getId_quesite(), queSiteDO.getId_que(),null,null,queSiteDO.getId_queben(),event);
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
