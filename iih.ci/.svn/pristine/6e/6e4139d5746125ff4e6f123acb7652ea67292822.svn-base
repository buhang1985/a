package iih.ci.mr.s.listener;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.bd.srv.mrtaskrule.i.IMrtaskruleMDORService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskCudService;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.AbstractOrSignCancelListener;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MrAllOpOrCancelListener extends AbstractOrSignCancelListener{
//手术医嘱撤回监听
	@Override
	protected void doYourActionAfterOrSignCancel(CiOrderDO[] ors)
			throws BizException {
		// TODO Auto-generated method stub
		if (ors==null||ors.length<=0) {
			return;
		}
		for (int j = 0; j < ors.length; j++) {
			CiOrderDO ciorderdo=ors[j];
			if(!(ciorderdo!=null&&(IBdSrvDictCodeConst.SD_SRVTP_OP.equals(ciorderdo.getSd_srvtp())||IBdSrvDictCodeConst.SD_SRVTP_OP_TAICI.equals(ciorderdo.getSd_srvtp()))||IBdSrvDictCodeConst.SD_SRVTP_OP_BESIDEDEB.equals(ciorderdo.getSd_srvtp())))
				return;
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
		
	}

	
}
