package iih.ci.rcm.reportcardmissqry.bp;

import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtpl.i.IReportcardtplRService;
import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.reportcarddoc.d.ReportCardDocDo;
import iih.ci.rcm.reportcarddoc.i.IReportcarddocRService;
import iih.ci.rcm.reportcarddocfs.d.ReportCardDocFsDo;
import iih.ci.rcm.reportcarddocfs.i.IReportcarddocfsRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;


/**
* 报卡信息（文书，模板，流）
*/
public class GetDataBp {

	
	@SuppressWarnings("unchecked")
	public FArrayList2 GetData(EntDto enDto) throws BizException {
		FArrayList2 fArrayList2 = new FArrayList2();
		ReportCardDocDo doc = new ReportCardDocDo();
		// 报卡文书DO
		IReportcarddocRService service = ServiceFinder.find(IReportcarddocRService.class);
		doc = service.findById(enDto.getId_ci_rcm_rd());
		if (doc != null) {
			fArrayList2.add(doc);
			// 报卡模板
			IReportcardtplRService service1 = ServiceFinder.find(IReportcardtplRService.class);
			ReportCardTplDo tplDo = service1.findById(doc.getId_bd_rcm_tpl());
			if (tplDo != null) {
				fArrayList2.add(tplDo);
			}
			// 报卡流
			IReportcarddocfsRService service2 = ServiceFinder.find(IReportcarddocfsRService.class);
			ReportCardDocFsDo[] fsDos = service2.findByAttrValString("Id_ci_rcm_rd", doc.getId_ci_rcm_rd());
			if (fsDos != null && fsDos.length > 0) {
				fArrayList2.add(fsDos[0]);
			}
		} 

		return fArrayList2;
	}
}
