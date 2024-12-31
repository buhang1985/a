package iih.ci.rcm.reportcardremind.bp;

import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtpl.i.IReportcardtplRService;
import iih.bd.srv.reportcardtplstream.d.Reportcardtplstream;
import iih.bd.srv.reportcardtplstream.i.IReportcardtplstreamRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 根据报卡类型主键查找模板（启用并且有对应流数据），选择顺序为：默认模板>最近修改的模板，如果没有返回null
 */
public class FindDefQryBp {

	//查找默认模板，如果没有取最新修改
	public ReportCardTplDo findDefQry(String id_bd_rcm_tp) throws BizException {
		IReportcardtplRService tplService=ServiceFinder.find(IReportcardtplRService.class);
		ReportCardTplDo [] tplDos=tplService.find("id_bd_rcm_tp='" + id_bd_rcm_tp + "' and fg_active='Y' ", "sv desc", FBoolean.FALSE);
		if(tplDos!=null && tplDos.length>0){
			IReportcardtplstreamRService sService=ServiceFinder.find(IReportcardtplstreamRService.class);
			for (ReportCardTplDo tpl : tplDos) {
				if(FBoolean.TRUE==tpl.getFg_def()){
					Reportcardtplstream [] stream=sService.findByAttrValString("Id_bd_rcm_tpl", tpl.getId_bd_rcm_tpl());
					if(null!=stream && stream.length>0){
						return tpl;
					}
				}
			}
			for (ReportCardTplDo tpl : tplDos) {
					Reportcardtplstream [] stream=sService.findByAttrValString("Id_bd_rcm_tpl", tpl.getId_bd_rcm_tpl());
					if(null!=stream && stream.length>0){
						return tpl;
					}
			}

		}
		return null;
	}
}
