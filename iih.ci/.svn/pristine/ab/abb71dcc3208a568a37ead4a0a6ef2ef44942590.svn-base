/**
 * 
 */
/**
 * @author zou_haiqiang
 *
 */
package iih.ci.mrqc.mrtask.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnRService;
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
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class InsertMrTaskByEnInDeptListener implements IBusinessListener {

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
		Object[] oldobjs = (Object[]) bdcEvent.getOldObjs();
		if (ArrayUtils.isEmpty(objs)||ArrayUtils.isEmpty(oldobjs)) {
			return;
		}
		if (!(objs[0] instanceof InpatientDO)||!(oldobjs[0] instanceof InpatientDO)) {
			return;
		}
		InpatientDO[] inPatients = new InpatientDO[objs.length];
		InpatientDO[] oldinPatients = new InpatientDO[oldobjs.length];
		for (int i = 0; i < objs.length; i++) {
			inPatients[i] = (InpatientDO) objs[i];
		}
		for (int i = 0; i < oldobjs.length; i++) {
			oldinPatients[i] = (InpatientDO) oldobjs[i];
		}
		InsertMrtaskByEnInDept(inPatients,oldinPatients);
		
	}
	
	private void InsertMrtaskByEnInDept(InpatientDO[] inPatients,InpatientDO[] oldinPatients) throws BizException{
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		
		InpatientDO inpatientdo=inPatients[0];
		InpatientDO oldinpatientdo=oldinPatients[0];
			if(inpatientdo==null||oldinpatientdo==null)
				return;
			//判断是不是入科  Sd_status为25是 入科
			if(inpatientdo.getSd_status().equals("25")&&
					(!oldinpatientdo.getSd_status().equals("25")))
			{
				String id_pat=getIdPat(inpatientdo.getId_ent());
				String id_doctor_psn=getIdPsnByIdEnt(inpatientdo.getId_ent());
				String id_doctor_user=getIdUser(id_doctor_psn);
				String id_doctor_zhuzhi=getIdEnPsn(inpatientdo.getId_ent());
	//新增入院的任务			
				MrTaskDO RyMrTaskDO=new MrTaskDO();
				RyMrTaskDO.setStatus(DOStatus.NEW);
				RyMrTaskDO.setId_org(Context.get().getOrgId());
				RyMrTaskDO.setId_grp(Context.get().getGroupId());
				RyMrTaskDO.setId_ent(inpatientdo.getId_ent());
				RyMrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				RyMrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				RyMrTaskDO.setId_pat(id_pat);
				RyMrTaskDO.setId_exec_doctor(id_doctor_user);
				RyMrTaskDO.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_RUYUAN);
				RyMrTaskDO.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_RUYUAN);
				RyMrTaskDO.setId_exec_dept(inpatientdo.getId_dep_phyadm());
				RyMrTaskDO.setDt_begin(new FDateTime());
				RyMrTaskDO.setDt_end(new FDateTime().getDateTimeAfter(1));
				RyMrTaskDO.setMrtask_name("请您书写初次入院记录");
				RyMrTaskDO.setSource_name("初次入院记录");
				taskList.add(RyMrTaskDO);			
	//新增病程的任务
				MrTaskDO BcMrTaskDo=new MrTaskDO();
				BcMrTaskDo.setStatus(DOStatus.NEW);
				BcMrTaskDo.setId_org(Context.get().getOrgId());
				BcMrTaskDo.setId_grp(Context.get().getGroupId());
				BcMrTaskDo.setId_ent(inpatientdo.getId_ent());
				BcMrTaskDo.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				BcMrTaskDo.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				BcMrTaskDo.setId_pat(id_pat);
				BcMrTaskDo.setId_exec_doctor(id_doctor_user);
				BcMrTaskDo.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_BINGCHENG);
				BcMrTaskDo.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_BINGCHENG);
				BcMrTaskDo.setId_exec_dept(inpatientdo.getId_dep_phyadm());
				BcMrTaskDo.setDt_begin(new FDateTime());
				BcMrTaskDo.setDt_end(new FDateTime(new FDateTime().getMillis() + ICalendar.MILLIS_PER_HOUR * 8));
				BcMrTaskDo.setMrtask_name("请您书写首次病程记录");
				BcMrTaskDo.setSource_name("首次病程记录");
				taskList.add(BcMrTaskDo);
//新增上级医生首次查房的任务
				MrTaskDO CfMrTaskDo=new MrTaskDO();
				CfMrTaskDo.setStatus(DOStatus.NEW);
				CfMrTaskDo.setId_org(Context.get().getOrgId());
				CfMrTaskDo.setId_grp(Context.get().getGroupId());
				CfMrTaskDo.setId_ent(inpatientdo.getId_ent());
				CfMrTaskDo.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				CfMrTaskDo.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				CfMrTaskDo.setId_pat(id_pat);
				CfMrTaskDo.setId_exec_doctor(id_doctor_zhuzhi);
				CfMrTaskDo.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_BINGCHENG);
				CfMrTaskDo.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_SHOUCICHAFANG);
				CfMrTaskDo.setId_exec_dept(inpatientdo.getId_dep_phyadm());
				CfMrTaskDo.setDt_begin(new FDateTime());
				CfMrTaskDo.setDt_end(new FDateTime().getDateTimeAfter(2));
				CfMrTaskDo.setMrtask_name("请您书写上级医生首次查房记录");
				CfMrTaskDo.setSource_name("上级医生首次查房记录");
				taskList.add(CfMrTaskDo);
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
	private String getIdEnPsn(String id_ent) throws BizException{
		IEnpsnRService eenpsnService = ServiceFinder.find(IEnpsnRService.class);
		EnPsnDO[] enpsnArr=eenpsnService.find("a0.id_ent='"+id_ent+"' and a0.sd_emprole='"+IEnDictCodeConst.SD_EMPROLE_ZZDOC+"'", "", FBoolean.FALSE);
		if (enpsnArr.length > 0) {
			return enpsnArr[0].getId_emp();
		}else{
			return "";
		}
	}
}