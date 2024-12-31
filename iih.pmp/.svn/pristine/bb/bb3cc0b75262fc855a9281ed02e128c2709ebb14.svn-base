package iih.pmp.pay.cmbc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.wxpay.cmbc.CmbcPay;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;


public class CmbcFileDownLoadBP {
	
	CmbcPay pay=new CmbcPay();
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public WXBillDTO[] exec(FDate date) throws BizException {
		int num=gettotalNum(date);
		if(num>0) {
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<=num;i++) {
				Map<String, Object> data=convertData( date,i);			
				 Map<String, String>r=pay.downloadfile(data);
				 if (r != null
							&& "S".equals(r
									.get("gateReturnType"))) {
					 if(r.containsKey("segmentContent")) {
						 String sg=r.get("segmentContent");
                         String context=pmputils.Base64Decode(sg);
                         sb.append(context);
					 }
				 }
			}
			String msg=sb.toString();
			return genBillDTO( msg);
		}
		return null;
	}
	
	 private Map<String, Object> convertData(FDate date,int num){
		 Map<String,Object>data=new HashMap<String,Object>();	 
		 String transdate=pmputils.getTransDate(date, "yyyyMMdd");	  
		 data.put("slcTransDate", transdate);
		 data.put("segmentIndex", num+"");
		 data.put("fileType", "WX");
		 data.put("segmentSize", "1");
		 data.put("reserve", "没有备注信息");
		 return data;
	 }
	 private int gettotalNum(FDate date) throws BizException {
		 Map<String, Object> data=convertData( date,0);			
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
			dto.setChanneltradeno(ds[7]);
			dto.setBanktradeno(ds[8]);
			dto.setChalel_name("民生银行微信");
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
