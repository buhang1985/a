package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.List;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class GennerateCmbcItemBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void GenerateBillItem(ChannelBillDO chl) throws BizException{
		if(chl==null)return;
		String content=chl.getBill_content();
		byte[] data=BillCheckAppUtils.upcompress(content);
		String msg=new String(data);
		 
	      String start=pmputils.getTransDate(chl.getDt_bill(), "yyyy-MM-dd");
	      String end=pmputils.getTransDate(chl.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
		 IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
		 IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
		 ChlBillItemDO[] rnt=_itemrrservice.find(" Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and ((tradetime>='"+start+"' and tradetime<'"+end+"') or tradetime is null) and (bill_type='"+chl.getBill_type()+"' or bill_type is null)", "", FBoolean.FALSE);
		 _itemservice.delete(rnt);
		 _itemservice.save(genBillDTO( msg,chl));
	}
	
	 private ChlBillItemDO[] genBillDTO(String msg,ChannelBillDO chl) {
		 List<ChlBillItemDO> billlist=new ArrayList<>();
		 String[] rnt=msg.split("\\n");
		 for (String s : rnt) {
			String[] ds=s.split("\\|");
			ChlBillItemDO dto=new ChlBillItemDO();
//			dto.setPlatformid(ds[0]);
			dto.setAppid(ds[1]);
			dto.setMch_trade_no(ds[5]);			
			dto.setBanktradeno(ds[8]);
			dto.setChanneltradeno(ds[7]);
			dto.setChalel_name("民生银行");
			dto.setStatus(DOStatus.NEW);
			dto.setId_channel_bill(chl.getId_channel_bill());
			dto.setId_chl(chl.getId_chl());
			dto.setSd_chl(chl.getSd_chl());
			FDate dt=chl.getDt_bill();
			FDateTime f=new FDateTime(dt.toDate());
			dto.setTradetime(f);
			String amount=ds[14];
			if(amount.trim().startsWith("-")) {
				Double d=Double.parseDouble(amount);
				dto.setRefund_fee(new FDouble(d));
				dto.setTrade_status("REFUND");
			}else {
				Double d=Double.parseDouble(amount);
				dto.setTotal_fee(new FDouble(d));
				dto.setTrade_status("SUCCESS");
			}
			dto.setBill_type(chl.getBill_type());
			billlist.add(dto);
		}
		 
		 return billlist.toArray(new ChlBillItemDO[0]); 
	 }

}
