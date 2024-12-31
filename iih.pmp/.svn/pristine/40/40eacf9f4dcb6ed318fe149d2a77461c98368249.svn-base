package iih.pmp.pay.s.bp;

import iih.pmp.pay.bill.bp.BillCheckOperatorBP;
import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.util.WXParamUtils.WXCommonRntParamCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public class WXDownLoadBillBP {
	WXDataConvert convert=new WXDataConvert();
	public WXBillDTO[] wxdownloadBill(FDate date,String option) {

//		try {
//			new BillCheckOperatorBP().exec(95);
//		} catch (BizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		WXPayBP paybp=new WXPayBP();
		HashMap<String,String> data=convert.getBillData(date, option);
		Map<String,String> rst=paybp.downloadBill(data);
		List<WXBillDTO> billlist=new ArrayList<>();
		if (rst!=null&&rst.get(WXCommonRntParamCode.RETURN_CODE).equals(WXCommonRntParamCode.SUCCESS)) {
			String msg=rst.get("data");			
		    String[] rnt=msg.split("\\n");
		    String pattern="\\d{4}[-]\\d{2}[-]\\d{2} \\d{2}:\\d{2}:\\d{2}";
			Pattern r = Pattern.compile(pattern);
		    for(int i=0;i<rnt.length;i++){		    	
				Matcher ss=r.matcher(rnt[i]);
				if(ss.find()){
					String[] mrnt=rnt[i].split(",");
					WXBillDTO b=new WXBillDTO();
					b.setChalel_name("微信");
//					if(option.equals("ALL")||option.equals("SUCCESS"))
//					{
					b.setTradetime(new FDateTime(getBillVal(mrnt[0])));
					b.setChanneltradeno(this.getBillVal(mrnt[5]));
					b.setMch_trade_no(this.getBillVal(mrnt[6]));
					b.setUser_identify(this.getBillVal(mrnt[7]));
					b.setTrade_type(this.getBillVal(mrnt[8]));
					b.setTrade_status(this.getBillVal(mrnt[9]));
					b.setBank(this.getBillVal(mrnt[10]));
					b.setCurrency_type(this.getBillVal(mrnt[11]));
					b.setTotal_fee(this.getBillVal(mrnt[12]));
//					}
					if(option.equals("ALL")){
					b.setChannel_refund_no(this.getBillVal(mrnt[14]));
					b.setMch_refund_no(this.getBillVal(mrnt[15]));
					b.setRefund_fee(this.getBillVal(mrnt[16]));
					b.setRefund_type(this.getBillVal(mrnt[18]));
					b.setRefund_status(this.getBillVal(mrnt[19]));
					b.setProduct_name(this.getBillVal(mrnt[20]));
					}else if(option.equals("REFUND")){
						b.setChannel_refund_no(this.getBillVal(mrnt[16]));
						b.setMch_refund_no(this.getBillVal(mrnt[17]));
						b.setRefund_fee(this.getBillVal(mrnt[18]));
						b.setRefund_type(this.getBillVal(mrnt[20]));
						b.setRefund_status(this.getBillVal(mrnt[21]));
						b.setProduct_name(this.getBillVal(mrnt[22]));
					}
					if(option.equals("SUCCESS")){
						b.setProduct_name(this.getBillVal(mrnt[14]));
					}
					billlist.add(b);
					
				}
		    }
			
//			boolean f=ss.matches();
//			if(ss.find()){
//				int b=ss.groupCount();
//				int c=ss.end();
//				String kk=ss.group();
//				int a=1;
//				
//			}

		
			}
		
		return billlist.toArray(new WXBillDTO[0]);
	}
	
	private String getBillVal(String val){
		return val.substring(1, val.length());
	}
	


}
