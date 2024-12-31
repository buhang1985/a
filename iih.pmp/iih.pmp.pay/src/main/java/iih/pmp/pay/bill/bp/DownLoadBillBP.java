package iih.pmp.pay.bill.bp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillCudService;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.s.bp.WXDataConvert;
import iih.pmp.pay.s.bp.WXPayBP;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class DownLoadBillBP {
	
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXDataConvert convert=new WXDataConvert();
	public void exec() throws BizException{
		
		FDateTime dt=pmputils.getServerDateTime();
		FDate end=dt.getDate();
		List<ChannelBillDO> channellist=new ArrayList<>();
		for(int i=1;i<2;i++){
			FDate now=end.getDateBefore(i);			
			WXPayBP paybp=new WXPayBP();
			HashMap<String,String> data=convert.getBillData(now, "ALL");
			Map<String,String> rst=paybp.downloadBill(data);
			if (rst!=null&&rst.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
				String msg=rst.get("data");	
				ChannelBillDO chlbill=new ChannelBillDO();
				chlbill.setBill_content(msg);
				chlbill.setId_chl(PmpPayConst.getUdiID(PmpPayConst.WXPAY_CHANNEL_CODE,PmpPayConst.CHANNEL_DOCLIST_ID));
				chlbill.setSd_chl(PmpPayConst.WXPAY_CHANNEL_CODE);
				chlbill.setDt_bill(now);
				chlbill.setBill_type("ALL");
				chlbill.setStatus(DOStatus.NEW);
				chlbill.setDt_createtime(dt);
				String feature="";
				try{
				 feature=BillCheckAppUtils.encodeHmacMD5(msg.getBytes(), BillCheckAppUtils.getKey().getBytes());
				 chlbill.setBill_feature(feature);
				}catch(Exception e){
					e.printStackTrace();
				}
				channellist.add(chlbill);
			    
			}

		}
		
		IChannelbillCudService _service=ServiceFinder.find(IChannelbillCudService.class);
		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
//		_service.delete(_rservice.find(" sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'", "", FBoolean.FALSE));
//		 IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
//		 IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
//		 _itemservice.delete(_itemrrservice.find(" sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'", "", FBoolean.FALSE));
//		_service.save(channellist.toArray(new ChannelBillDO[0]));
	}
	
      public void exec(FDate Begin,FDate end) throws BizException{
		
//		FDateTime dt=pmputils.getServerDateTime();
//		FDate end=BillCheckAppUtils.getEndDate(endtime);
//		FDate Begin=BillCheckAppUtils.getStartDate(starttime, end);
		List<ChannelBillDO> channellist=new ArrayList<>();
		for(int i=1;i<=end.getDaysBetween(Begin, end);i++){
			FDate now=end.getDateBefore(i);			
			WXPayBP paybp=new WXPayBP();
			HashMap<String,String> data=convert.getBillData(now, "ALL");
			Map<String,String> rst=paybp.downloadBill(data);
			if (rst!=null&&rst.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
				String msg=rst.get("data");	
				ChannelBillDO chlbill=new ChannelBillDO();
				chlbill.setBill_content(msg);
				chlbill.setId_chl(PmpPayConst.getUdiID(PmpPayConst.WXPAY_CHANNEL_CODE,PmpPayConst.CHANNEL_DOCLIST_ID));
				chlbill.setSd_chl(PmpPayConst.WXPAY_CHANNEL_CODE);
				chlbill.setDt_bill(now);
				chlbill.setBill_type("ALL");
				chlbill.setStatus(DOStatus.NEW);
				chlbill.setDt_createtime(pmputils.getServerDateTime());
				String feature="";
				try{
				 feature=BillCheckAppUtils.encodeHmacMD5(msg.getBytes(), BillCheckAppUtils.getKey().getBytes());
				 chlbill.setBill_feature(feature);
				}catch(Exception e){
					e.printStackTrace();
				}
				channellist.add(chlbill);
			    
			}

		}
		IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
		 IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
		 _itemservice.delete(_itemrrservice.find(" Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' "+" and "+ BillCheckAppUtils.getTimeSpanSql(Begin, end, ChlBillItemDO.TRADETIME), "", FBoolean.FALSE));
		IChannelbillCudService _service=ServiceFinder.find(IChannelbillCudService.class);
		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		_service.delete(_rservice.find(" Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' " +" and "+BillCheckAppUtils.getTimeSpanSql(Begin, end, ChannelBillDO.DT_BILL), "", FBoolean.FALSE));
		 
		_service.save(channellist.toArray(new ChannelBillDO[0]));
	}
      
      
   
	
	
	

}
