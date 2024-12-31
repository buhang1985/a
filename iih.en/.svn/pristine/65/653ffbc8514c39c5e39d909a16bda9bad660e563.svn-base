package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.s.bp.EnQueBP;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;

public class MtCallNextNumBP {
	/**
	 * 叫号,叫下一个
	 * @param quesiteId
	 * @param id_que
	 * @param id_dayslot
	 * @throws BizException
	 */
	public String exec(String quesiteId,String id_dayslot) throws BizException
	{
		//校验
		this.validator(quesiteId);
		GetPatInfoByQueSiteIdBP mtTriageBP = new GetPatInfoByQueSiteIdBP();
		// 设置站点信息
		QueSiteDO site = this.setSiteInfo(quesiteId);
		if(EnValidator.isEmpty(site)){
			throw new BizException("找不到：" + quesiteId + "对应的站点！");
		}
		TriagePatInfoDTO[] medTechappDTOArray = mtTriageBP.exec(quesiteId,site.getId_que(),IEnDictCodeConst.SD_STATUS_ACPT_CALL,id_dayslot);
		if (medTechappDTOArray != null && medTechappDTOArray.length > 0) {
			TriagePatInfoDTO meddto = medTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);//过号
			//1.2发送过号事件
			if(meddto.getSortno() != null){
				this.invoke(quesiteId, meddto.getId_que(),meddto.getId_ent_que(),meddto.getSortno().toString(),meddto.getId_ben(),IEnEventConst.EVENT_EN_ALL_PASSNUM );
			}
		}
		
		TriagePatInfoDTO[] newMedTechappDTOArray = mtTriageBP.exec(quesiteId,site.getId_que(),IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT,id_dayslot);
		if (newMedTechappDTOArray != null && newMedTechappDTOArray.length > 0) {
			TriagePatInfoDTO meddto = newMedTechappDTOArray[0];			
			EnQueBP enQueBP = new EnQueBP();
			enQueBP.updateStatus(meddto.getId_ent_que(), IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);//叫号
			//发送叫号事件
			if(meddto.getSortno() != null){
				this.invoke(quesiteId, meddto.getId_que(),meddto.getId_ent_que(),meddto.getSortno().toString(),meddto.getId_ben(),IEnEventConst.EVENT_EN_ALL_CALLNUM);
			}
			return meddto.getId_ent_que();
		}
		return null;
	}
	/**
	 * 设置站点信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueSiteDO setSiteInfo(String quesiteId) throws BizException {
		if (EnValidator.isEmpty(quesiteId))
			return null;
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO site = ep.getSiteById(quesiteId);
		if (site == null)
			return null;
		return (QueSiteDO) site.clone();
	}
	/***
	 * @Description:校验
	 * @param id_quesite
	 * @throws BizException
	 */
	private void validator(String id_quesite) throws BizException{
		EnValidator.validateParam("siteId", id_quesite);
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(id_quesite);
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
