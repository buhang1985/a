package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.s.EnqueueCrudServiceImpl;
import iih.sc.sch.i.IScSchOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class CancMtTriageBP {
	/**
	 * 取消分诊
	 * @param appDTO 医技申请DTO
	 * @throws BizException
	 */
	public void cancelTriage(MedTechAppDTO appDTO) throws BizException {	
		
		EnQueBP enquebp = new EnQueBP();
		EnQueueDO enQueDO = enquebp.getEnQue(appDTO.getId_ent_que());
		
		if(enQueDO==null){
			throw new BizException("就诊队列不存在！");
		}	
		if(enQueDO.getFg_apt().booleanValue()){
			enQueDO.setId_que_site(null);
			enQueDO.setTicketno(0);
			enQueDO.setSortno(0);
			enquebp.updateEnQue(enQueDO);
			return;
		}
		if(EnValidator.isEmpty(appDTO.getId_ent_que())){			
			throw new BizException("未获取到就诊队列ID");
		}
		EnqueueCrudServiceImpl service = new EnqueueCrudServiceImpl();
		EnQueueDO enQueue = service.findById(appDTO.getId_ent_que());
		if(enQueue == null){			
			throw new BizException("未获取到就诊队列ID");
		}
		
		IQueRService queSiteRService = ServiceFinder.find(IQueRService.class);
		QueDO quedo  = queSiteRService.findById(appDTO.getId_que());
		if(quedo ==null)
			throw new BizException("未取到队列");
			
//		IDayslotQryService dayslotQryService = ServiceFinder.find(IDayslotQryService.class);
//		DaysLotDO dayslot = dayslotQryService.getRecentDayslot( IScDictCodeConst.SD_SCTP_MT);
//		IScschMDORService mdoRservice = ServiceFinder.find(IScschMDORService.class);
//		String whereStr = "id_scres ='"+quedo.getId_scres()+"'  and id_dep = '"+quedo.getId_dep()+"' and d_sch= '"+EnAppUtils.getServerDateTime().getDate()+"' and id_dayslot='"+dayslot.getId_dayslot() +"'";
		//String whereStr = "id_ticks = '"+ enQueDO.getId_tick() +"'";
		
//		ScSchDO[] schdo =  mdoRservice.find(whereStr, null, FBoolean.FALSE);
//		if(EnValidator.isEmpty(schdo)){
//			throw new BizException("未取到对应的排班");
//		}
	//	IScSchOutQryService  schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
	//	ScSchTickDO tickDO = schOutQryService (enQueDO.getId_tick() ,enQueue.getTicketno());
		
		IScSchOutCmdService schOutCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		schOutCmdService.revokeTick(enQueDO.getId_tick(), IScDictCodeConst.SC_CANC_RULE_SUPPLY);
		
		// 清空站点
		enQueDO.setId_que_site(null);
		enQueDO.setTicketno(0);
		enQueDO.setSortno(0);
		enquebp.updateEnQue(enQueDO);

	}
}
