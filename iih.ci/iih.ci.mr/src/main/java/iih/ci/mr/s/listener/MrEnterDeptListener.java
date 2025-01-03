package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.ICalendar;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class MrEnterDeptListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		EnterDept4EsDTO enterDept4EsDTO = (EnterDept4EsDTO) bizUserObj.getUserObj();
		if(enterDept4EsDTO==null)
		{
			return;
		}
		IInpatientRService iInpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inPatients = iInpatientRService.findByAttrValString("Id_ent", enterDept4EsDTO.getId_ent());
		InsertMrtaskByEnInDept(inPatients);
	}
	
	private void InsertMrtaskByEnInDept(InpatientDO[] inPatients) throws BizException{
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		InpatientDO inpatientdo=inPatients[0];
		if(inpatientdo==null)
			return;
		String id_pat=getIdPat(inpatientdo.getId_ent());
		String id_doctor_psn=getIdPsnByIdEnt(inpatientdo.getId_ent());
		String id_doctor_user=getIdUser(id_doctor_psn);
		//String id_doctor_zhuzhi=getIdEnPsn(inpatientdo.getId_ent());
		String id_org=Context.get().getOrgId();
		String id_grp=Context.get().getGroupId();
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_RUKE+"' and fg_active='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			MrTaskDO RyMrTaskDO=new MrTaskDO();
			RyMrTaskDO.setStatus(DOStatus.NEW);
			RyMrTaskDO.setId_org(id_org);
			RyMrTaskDO.setId_grp(id_grp);
			RyMrTaskDO.setId_ent(inpatientdo.getId_ent());
			RyMrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
			RyMrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
			RyMrTaskDO.setId_pat(id_pat);
			RyMrTaskDO.setId_exec_doctor(id_doctor_user);
			RyMrTaskDO.setId_mrcactm(rkRuleDoArr[i].getId_mrcactm());
			RyMrTaskDO.setId_mrtp(rkRuleDoArr[i].getId_mrtp());
			RyMrTaskDO.setId_mrtp_change(rkRuleDoArr[i].getId_mrtp_change());
			RyMrTaskDO.setId_exec_dept(inpatientdo.getId_dep_phyadm());
			RyMrTaskDO.setDt_begin(new FDateTime());
			RyMrTaskDO.setDt_end(new FDateTime(new FDateTime().getMillis() + ICalendar.MILLIS_PER_HOUR * rkRuleDoArr[i].getLimittime()));
			RyMrTaskDO.setMrtask_name(rkRuleDoArr[i].getTiptext());
			RyMrTaskDO.setSource_name(rkRuleDoArr[i].getMrtp_name());
			RyMrTaskDO.setId_source(inpatientdo.getId_ent());
			RyMrTaskDO.setId_mr_task_rule(rkRuleDoArr[i].getPkVal());
			taskList.add(RyMrTaskDO);	
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
	//根据id_psn 获取 患者id_user
//	private String getIdEnPsn(String id_ent) throws BizException{
//		IEnpsnRService eenpsnService = ServiceFinder.find(IEnpsnRService.class);
//		EnPsnDO[] enpsnArr=eenpsnService.find("a0.id_ent='"+id_ent+"' and a0.sd_emprole='"+IEnDictCodeConst.SD_EMPROLE_ZZDOC+"'", "", FBoolean.FALSE);
//		if (enpsnArr.length > 0) {
//			return enpsnArr[0].getId_emp();
//		}else{
//			return "";
//		}
//	}
}
