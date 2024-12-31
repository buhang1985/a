package iih.mm.st.stockpriceadjust.i.ds;

import iih.mm.st.stockpriceadjust.d.StockpriceadjustAggDO;
import iih.mm.st.stockpriceadjust.i.IStockpriceadjustRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.dftimpl.DefaultProDefExt;
import xap.wf.af.runtime.TaskInstance;

public class StPriceAdjProDefHanlder extends DefaultProDefExt{
	@Override
	public String getUrlByTask(TaskInstance task) {
		String billId = task.getId_frmins();
		IStockpriceadjustRService iStockpriceadjustRService = ServiceFinder.find(IStockpriceadjustRService.class);
		StockpriceadjustAggDO stPriceAdjAggDO = null;
		try {
			stPriceAdjAggDO = iStockpriceadjustRService.findById(billId);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		StringBuffer strUrl = new StringBuffer();
		strUrl.append("XAP:navigate?Funccode=455010");
		strUrl.append("&FrmInsPk="+task.getId_frmins());
		strUrl.append("&TaskPk="+task.getId_task());
		if(stPriceAdjAggDO != null) {
			strUrl.append("&Status="+stPriceAdjAggDO.getParentDO().getSd_su_stpri());
		}
		return  strUrl.toString();
	}
}
