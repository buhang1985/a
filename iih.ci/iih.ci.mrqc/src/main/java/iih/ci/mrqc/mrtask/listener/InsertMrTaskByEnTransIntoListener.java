package iih.ci.mrqc.mrtask.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;

import org.apache.commons.lang3.ArrayUtils;

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

public class InsertMrTaskByEnTransIntoListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		if (!PatiVisitDO.class.getName().equals(bdcEvent.getSourceID())) {
			return;
		}
		if (!IEventType.TYPE_UPDATE_AFTER.equals(bdcEvent.getEventType())) {
			return;
		}
		Object[] newobjs = (Object[]) bdcEvent.getNewObjs();
		Object[] oldObjs = (Object[]) bdcEvent.getOldObjs();

		if (ArrayUtils.isEmpty(newobjs)&&ArrayUtils.isEmpty(oldObjs)) {
			return;
		}
		if (!(newobjs[0] instanceof PatiVisitDO)&&!(oldObjs[0] instanceof PatiVisitDO)) {
			return;
		}
		
		PatiVisitDO[] newPatiVisitDos = new PatiVisitDO[newobjs.length];
		PatiVisitDO[] oldPatiVisitDos = new PatiVisitDO[oldObjs.length];
		
		for (int i = 0; i < newobjs.length; i++) {
			newPatiVisitDos[i] = (PatiVisitDO) newobjs[i];
		}
		for (int i = 0; i < oldObjs.length; i++) {
			oldPatiVisitDos[i] = (PatiVisitDO) oldObjs[i];
		}
		InsertMrtaskByEnTransInto(newPatiVisitDos,oldPatiVisitDos);
	
	}
	
	private void InsertMrtaskByEnTransInto(PatiVisitDO[] newPatiVisitDos,PatiVisitDO[] oldPatiVisitDos) throws BizException{
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		
		PatiVisitDO patiVisitDO=newPatiVisitDos[0];
			if(patiVisitDO==null||oldPatiVisitDos[0]==null)
				return;
			//当前就诊科室 Id_dep_phy 或者 当前护理单元 Id_dep_nur ， 有一个字段从非空变成另一个值
			if(!isOneToAnother(oldPatiVisitDos[0].getId_dep_phy(),patiVisitDO.getId_dep_phy())||
					!isOneToAnother(oldPatiVisitDos[0].getId_dep_nur(),patiVisitDO.getId_dep_nur())){
				return;
			}
			String  id_doctor_user = getIdUser(patiVisitDO.getId_emp_phy());
			if(isHaveMrType(patiVisitDO.getId_ent(),ICiMrDictCodeConst.ID_MRTYPE_ZHUANRU)){
				MrTaskDO ZrTaskDO=new MrTaskDO();
				ZrTaskDO.setStatus(DOStatus.NEW);
				ZrTaskDO.setId_org(Context.get().getOrgId());
				ZrTaskDO.setId_grp(Context.get().getGroupId());
				ZrTaskDO.setId_ent(patiVisitDO.getId_ent());
				ZrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_DONE);
				ZrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_DONE);
				ZrTaskDO.setId_pat(patiVisitDO.getId_pat());
				ZrTaskDO.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_BINGCHENG);
				ZrTaskDO.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_ZHUANRU);
				ZrTaskDO.setId_exec_doctor(id_doctor_user);
				ZrTaskDO.setId_exec_dept(patiVisitDO.getId_dep_phy());
				ZrTaskDO.setDt_begin(new FDateTime());
				ZrTaskDO.setDt_end(new FDateTime().getDateTimeAfter(1));
				ZrTaskDO.setMrtask_name("请您书写转入记录");
				ZrTaskDO.setSource_name("转入记录");
				taskList.add(ZrTaskDO);
			}else{
				MrTaskDO ZrTaskDO=new MrTaskDO();
				ZrTaskDO.setStatus(DOStatus.NEW);
				ZrTaskDO.setId_org(Context.get().getOrgId());
				ZrTaskDO.setId_grp(Context.get().getGroupId());
				ZrTaskDO.setId_ent(patiVisitDO.getId_ent());
				ZrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				ZrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				ZrTaskDO.setId_pat(patiVisitDO.getId_pat());
				ZrTaskDO.setId_mrcactm(ICiMrDictCodeConst.ID_MRCACTM_BINGCHENG);
				ZrTaskDO.setId_mrtp(ICiMrDictCodeConst.ID_MRTYPE_ZHUANRU);
				ZrTaskDO.setId_exec_doctor(id_doctor_user);
				ZrTaskDO.setId_exec_dept(patiVisitDO.getId_dep_phy());
				ZrTaskDO.setDt_begin(new FDateTime());
				ZrTaskDO.setDt_end(new FDateTime().getDateTimeAfter(1));
				ZrTaskDO.setMrtask_name("请您书写转入记录");
				ZrTaskDO.setSource_name("转入记录");
				taskList.add(ZrTaskDO);
			}
		mrtaskservice.save(taskList.toArray(new MrTaskDO[0]));

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
	// 判断字段是否由非空变成其他值
	private Boolean isOneToAnother(String oldStr,String newStr){
		//若由非空转为其他值 即满足转入条件  返回true
		if(!oldStr.equals("")&&!newStr.equals("")&&!oldStr.equals(newStr)){
			return true;
		}
		return false;
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
