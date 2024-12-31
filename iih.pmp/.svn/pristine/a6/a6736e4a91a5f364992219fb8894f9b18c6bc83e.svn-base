package iih.pmp.pay.cmbc.bill.bp;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public class CmbcBillCheckBP {
       public void exec(FDate dt) throws BizException 
       {
    	   DownLoadCmbcBillBP dbp=new DownLoadCmbcBillBP();
    	   ChannelBillDO cdo=dbp.exec(dt);
    	   GennerateCmbcItemBP gbp=new GennerateCmbcItemBP();
    	   gbp.GenerateBillItem(cdo);
    	   CmbcGenExcDOBP cbp=new CmbcGenExcDOBP();
    	   cbp.billcheck(cdo);
    	   
    	 
       }
}
