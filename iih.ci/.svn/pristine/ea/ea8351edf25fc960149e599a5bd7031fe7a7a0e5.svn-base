package iih.ci.mr.s.listener;

import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mr.s.bp.createmr.AutoCreateMrGetIdEntsBp;
import iih.ci.mr.s.bp.writetaskconfigurebp.MrOtherWriteTaskBp;
import iih.ci.mr.s.bp.writetaskconfigurebp.MrWriteTaskBp;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class MrWriteTaskConfigureListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		String sourceID = "";
		String eventType = "";
		List<String> idEnts=null;
		Object[] newObjs=null;
		boolean flag=event instanceof BusinessEvent;
		boolean flag2=event instanceof BDCommonEvent;
		
		AutoCreateMrGetIdEntsBp entsBp=new AutoCreateMrGetIdEntsBp();
		if(flag){
			BusinessEvent busEvent=(BusinessEvent)event;
			sourceID=busEvent.getSourceID();
			eventType=busEvent.getEventType();
			BusinessUserObj userObject =(BusinessUserObj) event.getUserObject();
			Object userObj = userObject.getUserObj();
		    if(userObj==null)return;  
			idEnts=entsBp.getIdEnts(new Object[] {userObj});		
		}else if(flag2){
		   BDCommonEvent dbevent=(BDCommonEvent)event;	
		   sourceID=dbevent.getSourceID();
		   eventType=dbevent.getEventType();
		   newObjs=dbevent.getNewObjs();
		   if(ArrayUtils.isEmpty(newObjs))return;  
		   idEnts=entsBp.getIdEnts(newObjs);	  
		}
		
		
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		// 产生
		MrTaskRuleDO[] taskRuleDOs = ruleService.find("srccode_evt='"+sourceID+"' and code_evt='"+eventType+"' and fg_active='Y' ", "sv", FBoolean.FALSE);
		// 撤回
		MrTaskRuleDO[] taskCancelRuleDos = ruleService.find("srcode_evt_cancel='"+sourceID+"' and code_evt_cancel='"+eventType+"' and fg_active='Y' ", "sv", FBoolean.FALSE);
		if(taskRuleDOs.length<1 && taskCancelRuleDos.length<1) return;

		// 临床医嘱事件
		boolean isOrder=((sourceID.equals(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID) || sourceID.equals(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID)) &&eventType.equals(IEventType.TYPE_UPDATE_AFTER));
		
		// 临床医嘱签署事件
		if(isOrder && taskRuleDOs.length>0){
			MrWriteTaskBp taskBp=new MrWriteTaskBp();
			// 手术医嘱签署
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_SHOUSHU,true,taskRuleDOs);		
			// 会诊医嘱签署
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_HUIZHEN,true,taskRuleDOs);		
			// 病情医嘱确认
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_BINGWEI,true,taskRuleDOs);		
			// 死亡医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_SIWANG,true,taskRuleDOs);		
			// 出院医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_CHUYUAN,true,taskRuleDOs);		
			// 抢救医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU,true,taskRuleDOs);	
			// 转科医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANCHU,true,taskRuleDOs);	
			// 嘱托医嘱（术后医嘱）
			taskBp.writeTask(newObjs, IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A,true,taskRuleDOs);
		}
		// 临床医嘱撤回事件
		else if(isOrder && taskCancelRuleDos.length>0){
			MrWriteTaskBp taskBp=new MrWriteTaskBp();
			// 手术医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_SHOUSHU,false,taskCancelRuleDos);		
			// 会诊医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_HUIZHEN,false,taskCancelRuleDos);		
			// 病情医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_BINGWEI,false,taskCancelRuleDos);		
			// 死亡医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_SIWANG,false,taskCancelRuleDos);		
			// 出院医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_CHUYUAN,false,taskCancelRuleDos);		
			// 抢救医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU,false,taskCancelRuleDos);	
			// 转科医嘱
			taskBp.writeTask(newObjs, ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANCHU,false,taskCancelRuleDos);	
			// 嘱托医嘱（术后医嘱）
			taskBp.writeTask(newObjs, IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A,false,taskCancelRuleDos);
		}
		// 其他业务事件
		else{
			IInpatientRService iInpatientRService = ServiceFinder.find(IInpatientRService.class);
			for(String id_ent:idEnts){		
				InpatientDO[] inPatients = iInpatientRService.find("id_ent='"+id_ent+"'", "sv",  FBoolean.FALSE);
				MrOtherWriteTaskBp otherWriteTask=new MrOtherWriteTaskBp();
				if(taskRuleDOs.length>0)
					otherWriteTask.createMrtask(inPatients,taskRuleDOs);
				if(taskCancelRuleDos.length>0)
					otherWriteTask.cancelMrtask(inPatients,taskCancelRuleDos);
			}
		}	
	}
}
