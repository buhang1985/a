package iih.pmp.pay.bill.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class GenerateBillItemBP {
	
	public void exec() throws BizException{
		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls=_rservice.find(" Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and bill_type='ALL'", "", FBoolean.FALSE);
		this.GenerateBillItem(chls);
	}
	
	public void exec(FDate begin,FDate end) throws BizException{
		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls=_rservice.find(" Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and bill_type='ALL' "+" and "+BillCheckAppUtils.getTimeSpanSql(begin, end, ChannelBillDO.DT_BILL), "", FBoolean.FALSE);
		this.GenerateBillItem(chls);
	}
	
	private void GenerateBillItem(ChannelBillDO[] chls) throws BizException{
		
		for(int i=0;i<chls.length;i++){
			ChannelBillDO bill=chls[i];
			String msg=bill.getBill_content();
			 String[] rnt=msg.split("\\n");
			 List<ChlBillItemDO>itemlist=new ArrayList<>();
			 if(bill.IS_CHECKED.equals("Y"))continue;
			 for(int j=1;j<rnt.length-2;j++){
				 String[] mrnt=rnt[j].split(",");
				 ChlBillItemDO b=new ChlBillItemDO();
					b.setTradetime(new FDateTime(getBillVal(mrnt[0])));
					b.setChanneltradeno(this.getBillVal(mrnt[5]));
					b.setMch_trade_no(this.getBillVal(mrnt[6]));
					b.setUser_identify(this.getBillVal(mrnt[7]));
					b.setTrade_type(this.getBillVal(mrnt[8]));
					b.setTrade_status(this.getBillVal(mrnt[9]));
					b.setBank(this.getBillVal(mrnt[10]));
					b.setCurrency_type(this.getBillVal(mrnt[11]));
					Double d=Double.parseDouble(this.getBillVal(mrnt[12]));
					b.setTotal_fee(new FDouble(d));
					b.setChannel_refund_no(this.getBillVal(mrnt[14]));
					b.setMch_refund_no(this.getBillVal(mrnt[15]));
					d=Double.parseDouble(this.getBillVal(mrnt[16]));
					b.setRefund_fee(new FDouble(d));
					b.setRefund_type(this.getBillVal(mrnt[18]));
					b.setRefund_status(this.getBillVal(mrnt[19]));
					b.setProduct_name(this.getBillVal(mrnt[20]));
					b.setStatus(DOStatus.NEW);
					b.setId_chl(bill.getId_chl());
					b.setSd_chl(bill.getSd_chl());
					b.setId_channel_bill(bill.getId_channel_bill());
					itemlist.add(b);
			 }
			 
			 IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
			 IChannelbillitemRService _itemrservice=ServiceFinder.find(IChannelbillitemRService.class);
			 _itemservice.delete(_itemrservice.find(" Id_channel_bill= '"+bill.getId_channel_bill()+"'", "", FBoolean.FALSE));
			 _itemservice.save(itemlist.toArray(new ChlBillItemDO[0]));
		}
	}
	
	private String getBillVal(String val){
		return val.substring(1, val.length());
	}

}
