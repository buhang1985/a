/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */

package iih.ci.mr.s.listener;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleRService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [作者]
 * @version   [版本号, YYYY-MM-DD]
 */

public class MrTaskDeleteListener extends AbstractOrCancelCheckListener{

	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		if (ors==null||ors.length<=0) {
			return;
		}
		for (int j = 0; j < ors.length; j++) {
			CiOrderDO ciorderdo=ors[j];
			if(IBdSrvDictCodeConst.SD_SRVTP_OP.equals(ciorderdo.getSd_srvtp())||IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI.equals(ciorderdo.getSd_srvtp())||IBdSrvDictCodeConst.SD_SRVTP_OP_BESIDEDEB.equals(ciorderdo.getSd_srvtp()))
			{
				deleteOP(ciorderdo);
			}
			if (CiOrderTypeEnum.OUTHOSPORDER.equals(CiOrPubUtils.getCiOrderType(ciorderdo)))
			{
				deleteOutHos(ciorderdo);
			}
			if(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT.equals(ciorderdo.getSd_srvtp()))
			{
				deleteTransDept(ciorderdo);
			}
			if(IBdSrvDictCodeConst.SD_SRVTP_TREAT_RESCUE.equals(ciorderdo.getSd_srvtp()))
			{
				deleteRescue(ciorderdo);
			}
			if(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_ILLSTATE.equals(ciorderdo.getSd_srvtp()))
			{
				deleteIllState(ciorderdo);
			}
			if(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH.equals(ciorderdo.getSd_srvtp()))
			{
				deleteDeath(ciorderdo);
			}
			if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS.equals(ciorderdo.getSd_srvtp()))
			{
				deleteConsult(ciorderdo);
			}
		}
	}
	
	/**
	 * 删除手术任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteOP(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_SHOUSHU+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}

	/**
	 * 删除出院任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteOutHos(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_CHUYUAN+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}
	
	/**
	 * 删除转科任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteTransDept(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANCHU+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}
	
	/**
	 * 删除抢救任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteRescue(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}
	
	/**
	 * 删除病危任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteIllState(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_BINGWEI+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}
	
	/**
	 * 删除死亡任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteDeath(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskruleMDORService ruleService=ServiceFinder.find(IMrtaskruleMDORService.class);
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		MrTaskRuleDO[] rkRuleDoArr=ruleService.find(" code_udidoc='"+ICiMrDictCodeConst.SD_MR_TASK_EVENT_SIWANG+"' and fg_active='Y' and fg_return='Y'", "", FBoolean.FALSE);
		if (rkRuleDoArr.length<=0) {
			return;
		}
		
		for (int i = 0; i < rkRuleDoArr.length; i++) {
			String sqlWhereStr="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+rkRuleDoArr[i].getId_mrcactm()+"' and a0.Id_mrtp='"+rkRuleDoArr[i].getId_mrtp()+"' and a0.id_Source='"+ciorderdo.getId_or()+"'";
			MrTaskDO[] taskArr=mrRservice.find(sqlWhereStr, "", FBoolean.FALSE);
			if (taskArr.length>0) {
				mrtaskservice.delete(taskArr);
			}
		}
	}
	
	/**
	 * 删除会诊任务
	 * @param ciorderdo
	 * @throws BizException
	 */
	private void deleteConsult(CiOrderDO ciorderdo) throws BizException
	{
		IMrtaskRService mrRservice=ServiceFinder.find(IMrtaskRService.class);
		IMrtaskCudService mrtaskservice =ServiceFinder.find(IMrtaskCudService.class);
		
		String taskFindStrToShoushu="a0.Id_ent='"+ciorderdo.getId_en()+"' and a0.Id_mrcactm='"+ICiMrDictCodeConst.ID_MRCACTM_HUIZHEN+"' and a0.Id_mrtp='"+ICiMrDictCodeConst.ID_MRTYPE_HUIZHEN+"'";
		MrTaskDO[] taskArr=mrRservice.find(taskFindStrToShoushu, "", FBoolean.FALSE);
		if (taskArr.length>0) {
			mrtaskservice.delete(taskArr);
		}
	}
	
	
}
