package iih.ci.rcm.reportcardremind.bp;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断当次就诊当前诊断是否弹报卡弹框提示,如果需要true，不需要false
 */
public class HasCiRcmPassBp {

	public Boolean hasCiRcmPass(String id_ent, String id_bd_rcm_tp, String id_di) throws BizException {
		IReportcarddocRService service = ServiceFinder.find(IReportcarddocRService.class);
		ReportCardDocDo[] docs = service.find(
				"id_bd_rcm_tp='" + id_bd_rcm_tp + "' and id_ent='" + id_ent + "' and id_di='" + id_di + "'", "",
				FBoolean.FALSE);
		if (null != docs && docs.length > 0) {
			for (ReportCardDocDo doc : docs) {
				if (!(doc.getSd_state().equals(ICiMrDictCodeConst.SD_SU_MR_NEW)
						|| doc.getSd_state().equals(ICiMrDictCodeConst.SD_SU_MR_RETRIEVE)
						|| doc.getSd_state().equals(ICiMrDictCodeConst.SD_SU_MR_REJECT))) {
					return false;
				}
			}
		}

		return true;
	}
}
