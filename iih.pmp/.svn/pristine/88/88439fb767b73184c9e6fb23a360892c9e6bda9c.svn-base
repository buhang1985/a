package iih.pmp.pay.custom.bill.bp;

import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

public class PmpBillCheckBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	 public void exec(BillCheckExceptionDO dto) throws BizException 
     {
		 IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
			IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		 IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
		 ChlBillItemDO[] chbls=_itemrrservice.find(" sd_chl='"+dto.getSd_chl()+"'  and "+pmputils.getTimeSpanSql("Tradetime",dto.getDt_req().getDate())+"", "", FBoolean.FALSE);
		 if(chbls!=null&&chbls.length>0) {
			 new PmpGenExceptDOBP(pay,dataconvert).billcheck(chbls[0]);
		 }
     }
	 
		
}
