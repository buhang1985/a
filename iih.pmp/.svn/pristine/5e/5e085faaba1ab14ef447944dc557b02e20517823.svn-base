package iih.pmp.pay.cmbc.bill.bp;

import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import xap.mw.core.data.BizException;

public class CmbcBillCheckBP2 {
	
	 public void exec(BillCheckExceptionDO dto) throws BizException 
     {
		 DownloadCmbcBillBP2 dbp=new DownloadCmbcBillBP2();
  	   ChannelBillDO cdo=dbp.exec(dto);
  	   GennerateCmbcItemBP gbp=new GennerateCmbcItemBP();
  	   gbp.GenerateBillItem(cdo);
  	   CmbcGenExcDOBP cbp=new CmbcGenExcDOBP();
  	   cbp.billcheck(cdo);
  	   //没有渠道账单时,计算交易表单边账
  	  if(cdo==null) {
		   CmbcCheckWithoutBillBP cwithoutbp=new CmbcCheckWithoutBillBP();
		   cwithoutbp.exec(dto);
	   }
     }

}
