package iih.mm.pl.stockplan.i.ds;

import iih.mm.pl.stockplan.d.StockplanAggDO;
import iih.mm.pl.stockplan.i.IStockplanRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
//import xap.wf.af.constant.WfTaskCreateType;
//import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.dftimpl.DefaultProDefExt;
import xap.wf.af.runtime.TaskInstance;

public class PurchaseProDefHanlder extends DefaultProDefExt{

	public String getUrlByTask(TaskInstance task) {
//		String billNo=task.getBillno();
//		String state1="Reject";
//		WfTaskCreateType createType=task.getCreateType();
//		WfTaskFininshType finishType=task.getFinishType();
		String billId = task.getId_frmins();
		IStockplanRService stockPlanService = ServiceFinder.find(IStockplanRService.class);
		StockplanAggDO stockplanAggDO = null;
		try {
			stockplanAggDO = stockPlanService.findById(billId);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		StringBuffer strUrl = new StringBuffer();
		strUrl.append("XAP:navigate?Funccode=451010");
		strUrl.append("&FrmInsPk="+task.getId_frmins());
		strUrl.append("&TaskPk="+task.getId_task());
		if(stockplanAggDO != null) {
			strUrl.append("&Status="+stockplanAggDO.getParentDO().getSd_su_pl());
		}
		return  strUrl.toString();
	}


}
