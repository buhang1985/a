package iih.en.que.s.bp.pharm;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.s.event.DrugQueEvent;
import iih.en.que.s.event.bp.WrapObj2DrugQue4EsBP;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 队列配药发药
 * @author yank
 *
 */
public class DispenseByQueBP {
	/**
	 * 队列配药发药
	 * @param entId 就诊id
	 * @param presIdList 处方id集合
	 * @param quesiteId 窗口id
	 * @param operTp 操作类型   21-配药   22-叫号   23-叫号未到   24-发药
	 * @throws BizException
	 */
	public void exec(String entId,FArrayList presIdList,String queSiteId,String operTp) throws BizException{
		IEnqueueRService enqueRService = ServiceFinder.find(IEnqueueRService.class);
		StringBuilder whereBuilder = new StringBuilder();
		//whereBuilder.append(String.format("ID_ENT='%s'",entId));
		//whereBuilder.append(String.format(" AND ID_QUE_SITE ='%s'",queSiteId));
		if(presIdList!=null && presIdList.size()>0){
			whereBuilder.append(" ID_PRES IN (");
			boolean first = true;
			for(Object orid : presIdList){
				if(orid==null ||orid.toString().length()<=0){
					continue;
				}
				if(!first){
					whereBuilder.append(",");
				}else{first = false;}
				
				whereBuilder.append(String.format("'%s'",orid));
			}			
			whereBuilder.append(")");
		}
		
		EnQueueDO[] queDOArray = enqueRService.find(whereBuilder.toString(), null, FBoolean.FALSE);
		if(queDOArray!=null && queDOArray.length>0){
			for(EnQueueDO enQue : queDOArray){
				enQue.setSd_status_acpt(operTp);
				enQue.setStatus(DOStatus.UPDATED);
			}
			IEnqueueCudService enQueCudService = ServiceFinder.find(IEnqueueCudService.class);
			enQueCudService.save(queDOArray);
			for(EnQueueDO enQue : queDOArray){
				//触发叫号，fanlq-2018-07-22
				String event = null;
				String presids = presIdList.toString();;
				switch(operTp){
					case IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE:
					event = IEnEventConst.EVENT_DRUG_DOSAGE;// 配药
					this.invoke(queSiteId,enQue.getId_ent_que() ,presids,event);
					break;
					case IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL:
						event = IEnEventConst.EVENT_DRUG_CALLNUM;// 叫号
						this.invoke(queSiteId, enQue.getId_ent_que() ,presids,event);
						break;
					case IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME:
						event = IEnEventConst.EVENT_DRUG_CALLNOARRIVAL;// 叫号未到
						this.invoke(queSiteId, enQue.getId_ent_que() ,presids,event);
						break;
					case IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_DISPENSE:
						event = IEnEventConst.EVENT_DRUG_DISPENSING;// 发药
						this.invoke(queSiteId, enQue.getId_ent_que() ,presids,event);
						break;
				}	
			}
		}else{
			if(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_DISPENSE.equals(operTp)){
				if(FBoolean.TRUE.equals(this.isHaveDrug(entId))){
					this.invokeByIdent(queSiteId,entId,IEnEventConst.EVENT_DRUG_DISPENSING);
				}
			}
		}
	}
	/***
	 * 
	 * @param presIdList 处方id集合
	 * 
	 * @return
	 */
	private String getPresids(FArrayList presIdList){
		if(presIdList!=null && presIdList.size()>0){
			String presids = "";
			boolean first = true;
			for(Object orid : presIdList){
				if(orid==null ||orid.toString().length()<=0){
					continue;
				}
				if(!first){
					presids = presids +",";
				}else{
					first = false;
					}
				return presids;
			}
		}
		return null;
	}
	/***
	 * 触发事件
	 * @param quesiteId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String entqueId,String presids,String event) throws BizException{
		DrugQueEvent e = new DrugQueEvent();
		e.exec(quesiteId,entqueId,presids, event);
	}
	
	/***
	 * 查询门诊药品是否发放完毕
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private FBoolean isHaveDrug(String id_ent) throws BizException{
		IMpDgOutService service = ServiceFinder.find(IMpDgOutService.class);
		return service.whetherAllDrugDispense(id_ent);
	}
	
	/**
	 * 触发药房队列事件
	 * 
	 * @param opQue4EsDTO 门诊队列事件源DTO
	 * @throws BizException
	 */
	public void invokeByIdent(String quesiteId,String id_ent,String event) throws BizException {
		AllQue4EsDTO allQue4EsDTO = this.getAllQue4EsDTO(quesiteId,id_ent);
		BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_ALL_QUE, event,allQue4EsDTO);
		Logger.info("发送药房窗口队列事件: "+event+";发送数据：" + allQue4EsDTO);
		EventDispatcher.fireEvent(opRegEvent);
	}
	/***
	 * 获取
	 * 
	 * @param quesiteId
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private AllQue4EsDTO getAllQue4EsDTO(String quesiteId,String id_ent) throws BizException{
		// 1.设置站点信息
		QueSiteDO site = new BdSiteEP().getSiteById(quesiteId);
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO queDO = queRService.findById(site.getId_que());
		AllQue4EsDTO allQue4EsDTO =new WrapObj2DrugQue4EsBP().setDrugBrdInfo(site,queDO);
		PatiVisitDO entdo = new PvEP().getPvById(id_ent);
		if(entdo != null && !EnValidator.isEmpty(entdo.getId_pat())){
			PatDO patdo = new PatEP().getPatById(entdo.getId_pat());
			if(patdo != null && allQue4EsDTO != null && !EnValidator.isEmpty(patdo.getCode())){
				allQue4EsDTO.setCode_pat(patdo.getCode());
				allQue4EsDTO.setName_pat(patdo.getName());
				allQue4EsDTO.setId_ent(id_ent);
			}
		}
		return allQue4EsDTO;
	}
}
