package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.RescueOrSignListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.ICalendar;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class MrRescueOrSignListener extends RescueOrSignListener{
//抢救医嘱下达后MR监听处理
	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		if (ors==null||ors.length<=0) {
			return;
		}
		for (int j = 0; j < ors.length; j++) {
			CiOrderDO ciorderdo=ors[j];
			String id_user =getIdUser(ciorderdo.getId_emp_or());
			IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
			MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU+"' and fg_active='Y' and id_mrcactm in (select id_mrcactm from bd_mrca_ctm where code_entp = '"+ciorderdo.getCode_entp()+"')  ", "", FBoolean.FALSE);
			if (rkRuleDoArr.length<=0) {
				return;
			}
			String id_org=Context.get().getOrgId();
			String id_grp=Context.get().getGroupId();
			IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
			List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
			for (int i = 0; i < rkRuleDoArr.length; i++) {
				MrTaskDO mrTaskDO=new MrTaskDO();
				mrTaskDO.setStatus(DOStatus.NEW);
				mrTaskDO.setId_org(id_org);
				mrTaskDO.setId_grp(id_grp);
				mrTaskDO.setId_ent(ciorderdo.getId_en());
				mrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
				mrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
				mrTaskDO.setId_pat(ciorderdo.getId_pat());
				mrTaskDO.setId_exec_doctor(id_user);
				mrTaskDO.setId_exec_dept(ciorderdo.getId_dep_or());
				mrTaskDO.setId_mrcactm(rkRuleDoArr[i].getId_mrcactm());
				mrTaskDO.setId_mrtp(rkRuleDoArr[i].getId_mrtp());
				mrTaskDO.setId_mrtp_change(rkRuleDoArr[i].getId_mrtp_change());
				mrTaskDO.setDt_begin(ciorderdo.getDt_effe());
				mrTaskDO.setDt_end(new FDateTime(ciorderdo.getDt_effe().getMillis() + ICalendar.MILLIS_PER_HOUR * rkRuleDoArr[i].getLimittime()));
				mrTaskDO.setMrtask_name(rkRuleDoArr[i].getTiptext()+"_"+ciorderdo.getName_or());
				mrTaskDO.setSource_name(ciorderdo.getName_or());
				mrTaskDO.setId_source(ciorderdo.getId_or());
				mrTaskDO.setId_mr_task_rule(rkRuleDoArr[i].getPkVal());
				taskList.add(mrTaskDO);
			}
			mrtaskservice.save(taskList.toArray(new MrTaskDO[0]));
		}
	}
	//根据id_psn 获取 患者id_user
	private String getIdUser(String id_psn) throws BizException{
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO[] userArr=userService.find("a0.id_psn='"+id_psn+"'", "", FBoolean.FALSE);
		if (userArr.length > 0) {
			return userArr[0].getId_user();
		}else{
			return "~";
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
