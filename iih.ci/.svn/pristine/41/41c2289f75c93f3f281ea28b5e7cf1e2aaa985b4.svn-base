package iih.ci.mrqc.mrtask.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
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
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class InsertMrTaskByEnOutDeptListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		if (!InpatientDO.class.getName().equals(bdcEvent.getSourceID())) {
			return;
		}
		if (!IEventType.TYPE_UPDATE_AFTER.equals(bdcEvent.getEventType())) {
			return;
		}
		Object[] objs = (Object[]) bdcEvent.getNewObjs();
		
		if (ArrayUtils.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof InpatientDO)) {
			return;
		}
		InpatientDO[] inPatients = new InpatientDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			inPatients[i] = (InpatientDO) objs[i];
		}
		InsertMrtaskByEnOutDept(inPatients);
	}
	
	private void InsertMrtaskByEnOutDept(InpatientDO[] inPatients) throws BizException{
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		
		InpatientDO inpatientdo=inPatients[0];
			if(inpatientdo==null)
				return;
			//判断是不是出院  Sd_status为28是出院
			if(!inpatientdo.getSd_status().equals("28"))
				return;
			String id_pat=getIdPat(inpatientdo.getId_ent());
			String id_doctor_psn=getIdPsnByIdEnt(inpatientdo.getId_ent());
			String id_doctor_user=getIdUser(id_doctor_psn);
//新增出院的任务	
			if(isHaveMrType(inpatientdo.getId_ent(),ICiMrDictCodeConst.ID_MRTYPE_CHUYUAN)){
				MrTaskDO CyMrTaskDO=new MrTaskDO();
				CyMrTaskDO.setStatus(DOStatus.NEW);
				CyMrTaskDO.setId_org(Context.get().getOrgId());
				CyMrTaskDO.setId_grp(Context.get().getGroupId());
				CyMrTaskDO.setId_ent(inpatientdo.getId_ent());
				CyMrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_DONE);
				CyMrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_DONE);
				CyMrTaskDO.setId_pat(id_pat);
				CyMrTaskDO.setId_exec_doctor(id_doctor_user);
				CyMrTaskDO.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_CHUYUAN);
				CyMrTaskDO.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_CHUYUAN);
				CyMrTaskDO.setId_exec_dept(inpatientdo.getId_dep_phyadm());
				CyMrTaskDO.setDt_begin(new FDateTime());
				CyMrTaskDO.setDt_end(new FDateTime().getDateTimeAfter(1));
				CyMrTaskDO.setMrtask_name("请您书写出院记录");
				CyMrTaskDO.setSource_name("出院记录");
				taskList.add(CyMrTaskDO);
			}else{
				MrTaskDO CyMrTaskDO=new MrTaskDO();
				CyMrTaskDO.setStatus(DOStatus.NEW);
				CyMrTaskDO.setId_org(Context.get().getOrgId());
				CyMrTaskDO.setId_grp(Context.get().getGroupId());
				CyMrTaskDO.setId_ent(inpatientdo.getId_ent());
				CyMrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				CyMrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				CyMrTaskDO.setId_pat(id_pat);
				CyMrTaskDO.setId_exec_doctor(id_doctor_user);
				CyMrTaskDO.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_CHUYUAN);
				CyMrTaskDO.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_CHUYUAN);
				CyMrTaskDO.setId_exec_dept(inpatientdo.getId_dep_phyadm());
				CyMrTaskDO.setDt_begin(new FDateTime());
				CyMrTaskDO.setDt_end(new FDateTime().getDateTimeAfter(1));
				CyMrTaskDO.setMrtask_name("请您书写出院记录");
				CyMrTaskDO.setSource_name("出院记录");
				taskList.add(CyMrTaskDO);
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
	private Boolean isHaveMrType(String id_ent,String id_mrtp) throws BizException{
		ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] doArr=mrService.find("a0.id_ent='"+id_ent+"'", "", FBoolean.FALSE);
		List<String> mrtplist=new ArrayList<>();
		for (CiMrDO ciMrDO : doArr) {
			mrtplist.add(ciMrDO.getId_mrtp());
		}
		if(mrtplist.contains(id_mrtp)){
			return true;
		}else {
			return false;
		}
	}
}
