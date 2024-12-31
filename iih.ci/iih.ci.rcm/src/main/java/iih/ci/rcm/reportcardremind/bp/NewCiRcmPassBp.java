package iih.ci.rcm.reportcardremind.bp;

import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建既往已报数据
 */
public class NewCiRcmPassBp {
	
	public Boolean newCiRcmPass(String id_ent, String id_bd_rcm_tp,String id_di) throws BizException {
		// 构建do并赋值,某些字段不为空赋值0
		ReportCardDocDo reportDO = new ReportCardDocDo();
		reportDO.setId_ent(id_ent);
		reportDO.setId_grp(Context.get().getGroupId());
		reportDO.setId_org(Context.get().getOrgId());
		reportDO.setName("既往已报");
		reportDO.setId_state("0");
		reportDO.setSd_state("0");
		reportDO.setName_state("0");
		reportDO.setId_bd_rcm_tp(id_bd_rcm_tp);
		reportDO.setId_bd_rcm_tpl("0");
		reportDO.setId_mred("0");
		reportDO.setSd_tplstmd("0");
		reportDO.setId_tplstmd("0");
		reportDO.setCreatedby(Context.get().getUserId());
		reportDO.setCreatedtime((new FDateTime()).toString());
		reportDO.setFg_reported_history(FBoolean.TRUE);
		reportDO.setId_di(id_di);
		// 保存数据
		IReportcarddocCudService service = ServiceFinder.find(IReportcarddocCudService.class);
		ReportCardDocDo []reportDOS = {reportDO};
		ReportCardDocDo[] results = service.insert(reportDOS);
		// 判断返回
		if (results != null && results.length > 0) {
			return true;
		} else {
			return false;
		}
	}

}
