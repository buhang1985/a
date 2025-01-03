package iih.ci.mr.s.bp.writetaskconfigurebp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.ICalendar;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class MrOtherWriteTaskBp {

	public void createMrtask(InpatientDO[] inPatients,MrTaskRuleDO[] rkRuleDoArr) throws BizException{
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		InpatientDO inpatientdo=inPatients[0];
		if(inpatientdo==null) return;
		String id_pat=getIdPat(inpatientdo.getId_ent());
		String id_doctor_psn=getIdPsnByIdEnt(inpatientdo.getId_ent());
		String id_doctor_user=getIdUser(id_doctor_psn);
		String id_org=Context.get().getOrgId();
		String id_grp=Context.get().getGroupId();
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			MrTaskDO mrTaskDo=new MrTaskDO();
			mrTaskDo.setStatus(DOStatus.NEW);
			mrTaskDo.setId_org(id_org);
			mrTaskDo.setId_grp(id_grp);
			mrTaskDo.setId_ent(inpatientdo.getId_ent());
			mrTaskDo.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
			mrTaskDo.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
			mrTaskDo.setId_pat(id_pat);
			mrTaskDo.setId_exec_doctor(id_doctor_user);
			mrTaskDo.setId_mrcactm(rkRuleDoArr[i].getId_mrcactm());
			mrTaskDo.setId_mrtp(rkRuleDoArr[i].getId_mrtp());
			mrTaskDo.setId_mrtp_change(rkRuleDoArr[i].getId_mrtp_change());
			mrTaskDo.setId_exec_dept(inpatientdo.getId_dep_phyadm());
			mrTaskDo.setDt_begin(new FDateTime());
			mrTaskDo.setDt_end(new FDateTime(new FDateTime().getMillis() + ICalendar.MILLIS_PER_HOUR * Long.valueOf(rkRuleDoArr[i].getLimittime())));
			mrTaskDo.setMrtask_name(rkRuleDoArr[i].getTiptext());
			mrTaskDo.setSource_name(rkRuleDoArr[i].getMrtp_name());
			mrTaskDo.setId_source(inpatientdo.getId_ent());
			mrTaskDo.setId_mr_task_rule(rkRuleDoArr[i].getPkVal());
			mrTaskDo.setIsreminded(FBoolean.FALSE);
			taskList.add(mrTaskDo);	
		}
		mrtaskservice.save(taskList.toArray(new MrTaskDO[0]));
	}
	
	//根据就诊号 获取 患者id_pat
	private String getIdPat(String id_ent) throws BizException{
		IPativisitRService ipRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO= ipRService.findById(id_ent);
		return patiVisitDO.getId_pat();
	}
	
	//根据id_ent 获取主管医生 id_psn
	private String getIdPsnByIdEnt(String id_ent) throws BizException{
		IEnOutQryService enQryService  = ServiceFinder.find(IEnOutQryService.class);
		EnPsnDO psnDO = enQryService.getEnPsn(id_ent, IEnDictCodeConst.SD_EMPROLE_DOCTOR);
		if(psnDO!=null) {
			return psnDO.getId_emp();
		}else{
			return "";
		}
	}
	
	//根据id_psn 获取 患者id_user
	private String getIdUser(String id_psn) throws BizException{
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO[] userArr=userService.find("a0.id_psn='"+id_psn+"'", "", FBoolean.FALSE);
		if (userArr.length > 0) {
			return userArr[0].getId_user();
		}else{
			return "";
		}
	}
	
	public void cancelMrtask(InpatientDO[] inPatients,MrTaskRuleDO[] rkRuleDoArr) throws BizException{
		IMrtaskRService mrtaskservice =ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice2 =ServiceFinder.find(IMrtaskCudService.class);
		InpatientDO inpatientdo=inPatients[0];
		if(inpatientdo==null) return;
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			MrTaskDO[] taskDOs = mrtaskservice.find("id_mr_task_rule='"+rkRuleDoArr[i].getId_mr_task_rule()+"' and id_ent='"+inpatientdo.getId_ent()+"'","",FBoolean.FALSE);
			mrtaskservice2.logicDelete(taskDOs);
		}
	}
}
