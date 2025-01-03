package iih.ci.mr.s.bp.writetaskconfigurebp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;

public class MrWriteTaskBp {

	public void writeTask(Object[] newObjs, String orderType, boolean flag, MrTaskRuleDO[] taskRuleDOs) throws BizException {
		GetSignatureOrdersInfo info=new GetSignatureOrdersInfo();
		CiOrderDO[] orders=info.getOrdInfo8Status(newObjs, orderType);
		if(orders!=null&& orders.length>0){
			List<MrTaskRuleDO> list=new ArrayList<MrTaskRuleDO>();
			for(MrTaskRuleDO taskRuleDO:taskRuleDOs){
				if(orderType.equals(taskRuleDO.getEvt_type())){
					list.add(taskRuleDO);			
				}
			}
			switch(orderType){
			 case ICiMrDictCodeConst.SD_MR_TASK_EVENT_SHOUSHU:
			      MrSurgicalTaskBp surgicalSignatureBp=new MrSurgicalTaskBp();
				  surgicalSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break;
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_HUIZHEN:
				  MrConsultationTaskBp consultationSignatureBp=new MrConsultationTaskBp();
				  consultationSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break;
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_BINGWEI:
				  MrIllnessTaskBp illnessSignatureBp=new MrIllnessTaskBp();
				  illnessSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break;  
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_SIWANG:
				  MrDeathTaskBp deathSignatureBp=new MrDeathTaskBp();
				  deathSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break; 
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_CHUYUAN:
				  MrOutHosTaskBp outHosSignatureBp=new MrOutHosTaskBp();
				  outHosSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break; 
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU:
				  MrRescueTaskBp rescueSignatureBp=new MrRescueTaskBp();
				  rescueSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break; 
			  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANCHU:
				  MrTransDepTaskBp transDepSignatureBp=new MrTransDepTaskBp();
				  transDepSignatureBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break;   
			  case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A:
				  MrSurgicalAfterTaskBp surgicalAfterBp=new MrSurgicalAfterTaskBp();
				  surgicalAfterBp.writeTask(orders,(MrTaskRuleDO[])list.toArray(new MrTaskRuleDO[list.size()]),flag);
				  break; 
			}			
		}
	}
}
