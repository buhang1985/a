package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillCudService;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.wxpay.cmbc.CmbcPay;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class DownloadCmbcBillBP2 {
	
CmbcPay pay=new CmbcPay();
PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public ChannelBillDO exec(BillCheckExceptionDO dto) throws BizException {
		if(dto.getSd_chl()==null||dto.getDt_req()==null||dto.getBill_type()==null)throw new BizException("没有渠道、日期或对账类型！！！！！");
		FDateTime dt=pmputils.getServerDateTime();
		int num=gettotalNum(dto);
		if(num>0) {
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<=num;i++) {
				Map<String, Object> data=convertData( dto,i);			
				 Map<String, String>r=pay.downloadfile(data);
				 if (r != null
							&& "S".equals(r
									.get("gateReturnType"))) {
					 if(r.containsKey("segmentContent")) {
						 String sg=r.get("segmentContent");
						 String ss=sg.trim();
						 if(sg.trim().equals(""))continue;
                         String context=pmputils.Base64Decode(sg);
                         sb.append(context);
					 }else {
						 throw new BizException("对账单下载失败！！！！");
					 }
					 
				 }
			}
			if(sb.length()==0)return null;
			String msg=sb.toString();
			ChannelBillDO chlbill=new ChannelBillDO();
			chlbill.setId_chl(PmpPayConst.getUdiID(PmpPayConst.CMBC_CHANNEL_CODE,PmpPayConst.CHANNEL_DOCLIST_ID));
			chlbill.setSd_chl(PmpPayConst.CMBC_CHANNEL_CODE);
			chlbill.setDt_bill(dto.getDt_req().getDate());
			chlbill.setBill_type(dto.getBill_type());
			chlbill.setStatus(DOStatus.NEW);
			chlbill.setDt_createtime(dt);
			String content=BillCheckAppUtils.compress(msg.getBytes());
			chlbill.setBill_content(content);
			String feature="";
			try{
			 feature=BillCheckAppUtils.encodeHmacMD5(msg.getBytes(), BillCheckAppUtils.getKey().getBytes());
			 chlbill.setBill_feature(feature);
			}catch(Exception e){
				e.printStackTrace();
			}
			String dst=pmputils.getTransDate(dto.getDt_req().getDate(), "yyyy-MM-dd");	 
			IChannelbillCudService _service=ServiceFinder.find(IChannelbillCudService.class);
			IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
			ChannelBillDO[] chbls=_rservice.find(" sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and  bill_type='"+dto.getBill_type()+"' and dt_bill='"+dst+"'", "", FBoolean.FALSE);
			 IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
			 IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
			if(chbls!=null) {
				for (ChannelBillDO channelBillDO : chbls) {
					ChlBillItemDO[] items=_itemrrservice.find(" sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and id_channel_bill='"+channelBillDO.getId_channel_bill()+"'", "", FBoolean.FALSE);
					_itemservice.delete(items);
				}
				_service.delete(chbls);
			}
			ChannelBillDO[]rnt=_service.save(new ChannelBillDO[] {chlbill});
			if(rnt!=null&&rnt.length>0)
				return rnt[0];
//			return genBillDTO( msg);
		}
		return null;
	}
	
	 private Map<String, Object> convertData(BillCheckExceptionDO dto,int num){
		 Map<String,Object>data=new HashMap<String,Object>();	 
		 String transdate=pmputils.getTransDate(dto.getDt_req().getDate(), "yyyyMMdd");	  
		 data.put("slcTransDate", transdate);
		 data.put("segmentIndex", num+"");
		 data.put("fileType", dto.getBill_type());
		 data.put("segmentSize", "4");
		 data.put("reserve", "没有备注信息");
		 return data;
	 }
	 private int gettotalNum(BillCheckExceptionDO dto) throws BizException {
		 Map<String, Object> data=convertData( dto,0);			
		 Map<String, String>r=pay.downloadfile(data);
		 if (r != null
					&& "S".equals(r
							.get("gateReturnType"))) {
			 if(r.containsKey("segmentCount")) {
				 int num=Integer.parseInt(r.get("segmentCount").toString());
				 return num;
			 }
			 
		 }
		 return 0;
	 }
	 
	 private WXBillDTO[] genBillDTO(String msg) {
		 List<WXBillDTO> billlist=new ArrayList<>();
		 String[] rnt=msg.split("\\n");
		 for (String s : rnt) {
			String[] ds=s.split("\\|");
			WXBillDTO dto=new WXBillDTO();
			dto.setPlatformid(ds[0]);
			dto.setAppid(ds[1]);
			dto.setMch_trade_no(ds[5]);
			dto.setChanneltradeno(ds[8]);
			dto.setChalel_name("民生银行");
			String amount=ds[14];
			if(amount.trim().startsWith("-")) {
				dto.setRefund_fee(amount);
			}else {
				dto.setTotal_fee(amount);
			}
			billlist.add(dto);
		}
		 
		 return billlist.toArray(new WXBillDTO[0]); 
	 }

}
