/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
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

/**
 * 〈扼要描述〉
 * 监听转入
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrDepInTranceListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// TODO Auto-generated method stub
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		TransDept4EsDTO enterDept4EsDTO = (TransDept4EsDTO) bizUserObj.getUserObj();
		if(enterDept4EsDTO==null) return;

		//String id_user =getIdUser(enterDept4EsDTO.getId_emp_or());
		String id_org=Context.get().getOrgId();
		String id_grp=Context.get().getGroupId();
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		MrTaskRuleDO[] rkRuleDoArr=null;
		if(!enterDept4EsDTO.getOld_sd_dep_phy().equals(enterDept4EsDTO.getSd_dep_phy())){
			rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANRU+"' and fg_active='Y'", "", FBoolean.FALSE);

		}else{
			rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANRUBQ+"' and fg_active='Y'", "", FBoolean.FALSE);
		}
				
		if (rkRuleDoArr==null || rkRuleDoArr.length<=0) {
			return;
		}
		List<MrTaskDO> taskList=new ArrayList<MrTaskDO>();
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			MrTaskDO mrTaskDO=new MrTaskDO();
			mrTaskDO.setStatus(DOStatus.NEW);
			mrTaskDO.setId_org(id_org);
			mrTaskDO.setId_grp(id_grp);
			mrTaskDO.setId_ent(enterDept4EsDTO.getId_ent());
			mrTaskDO.setId_mrtask_sta(ICiMrDictCodeConst.ID_MRTASK_TODO);
			mrTaskDO.setSd_mrtask_sta(ICiMrDictCodeConst.SD_MRTASK_TODO);
			mrTaskDO.setId_pat(enterDept4EsDTO.getId_pat());
			//mrTaskDO.setId_exec_doctor(id_user);
			mrTaskDO.setId_mrcactm(rkRuleDoArr[i].getId_mrcactm());
			mrTaskDO.setId_mrtp(rkRuleDoArr[i].getId_mrtp());
			mrTaskDO.setId_mrtp_change(rkRuleDoArr[i].getId_mrtp_change());
			//mrTaskDO.setId_exec_dept(enterDept4EsDTO.getId_dep_phy());
			mrTaskDO.setDt_begin(new FDateTime());
			mrTaskDO.setDt_end(new FDateTime(new FDateTime().getMillis() + ICalendar.MILLIS_PER_HOUR * rkRuleDoArr[i].getLimittime()));
			mrTaskDO.setMrtask_name(rkRuleDoArr[i].getTiptext());
			mrTaskDO.setId_source(enterDept4EsDTO.getId_or());
			mrTaskDO.setSource_name(rkRuleDoArr[i].getMrtp_name());
			mrTaskDO.setId_mr_task_rule(rkRuleDoArr[i].getPkVal());
			taskList.add(mrTaskDO);	
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
				return "~";
			}
		}

}
