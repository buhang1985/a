package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import iih.bd.srv.mrcompleterule.d.MrCompleteRuleDO;
import iih.bd.srv.mrcompleterule.i.IMrcompleteruleRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IsCompleteRulebp {

	public static String isCompleteRule(String id_ent)  throws BizException{
		ICiemrRService emrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] cimrDoArr = emrRService.find(" a0.id_ent = '" + id_ent + "' ", null, FBoolean.FALSE);
		// 查询病历书写完成规则
		IMrcompleteruleRService completeService = ServiceFinder.find(IMrcompleteruleRService.class);
		MrCompleteRuleDO[] ruleArr = completeService.find(" fg_active='Y'", "", FBoolean.FALSE);
		StringBuilder sb=new StringBuilder();
		if (ruleArr.length <= 0) {
			return sb.toString();
		}

		for (int i = 0; i < ruleArr.length; i++) {
			if (ruleArr[i].getFg_change() == FBoolean.TRUE) {
				String qry = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp() + "'";
				cimrDoArr = emrRService.find(qry, "", FBoolean.FALSE);

				if (cimrDoArr.length <= 0) {
					String mrtpsStr = "'" + ruleArr[i].getId_change_mrtps().replace(",", "','") + "'";
					String sqlwhere = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp in (" + mrtpsStr + ")";
					CiMrDO[] cimrDoChangeArr = emrRService.find(sqlwhere, "", FBoolean.FALSE);

					if ((null == cimrDoArr || cimrDoArr.length == 0) && null == cimrDoChangeArr
							|| cimrDoChangeArr.length == 0) {
//						sb.append("未创建文书：\n");
						sb.append("   "+ruleArr[i].getMrtp_name()+"\n");
					}
				}

			} else {
				String qryby = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp() + "'";
				cimrDoArr = emrRService.find(qryby, "", FBoolean.FALSE);
				if (null == cimrDoArr || cimrDoArr.length == 0) {
//					sb.append("未创建文书：\n");
					sb.append("   "+ruleArr[i].getMrtp_name()+"\n");
				}
			}
		}
		return sb.toString();
	}
}
