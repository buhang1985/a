package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

import xap.mw.coreitf.d.FDate;

public class WXDataConvert {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public  HashMap<String, String> getJSAPIData(TradeDO tra,OrdReqDTO dto){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("body", dto.getSubject());
		data.put("out_trade_no", tra.getTrade_no());
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", pmputils.Yuan2Fen(dto.getAmount()));
		data.put("spbill_create_ip", "123.12.12.123");
		data.put("trade_type", dto.getSd_scene());
		data.put("product_id", "11");	
//		data.put("openid", "oxPjV1SzICbwuj6DrheS8EKx81tE");//测试用openid
		return data;
	}
	
	public  HashMap<String, String> getScanPayData(TradeDO tra,OrdReqDTO dto){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("body", dto.getSubject());
		data.put("out_trade_no", tra.getTrade_no());
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", pmputils.Yuan2Fen(dto.getAmount()));
		data.put("spbill_create_ip", "123.12.12.123");
		data.put("trade_type", dto.getSd_scene());
		data.put("product_id", "11");		
		return data;
	}
	
	public  HashMap<String, String> getMicroPayData(TradeDO tra,OrdReqDTO dto){
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", tra.getTrade_no());
		data.put("body", dto.getSubject());
		data.put("total_fee", pmputils.Yuan2Fen(dto.getAmount()));
		data.put("auth_code", dto.getAuth_code());	
		return data;
	}
	
	public   HashMap<String, String> getReFundData(OrdDO ord,TradeDO tra,OrdReqDTO dto) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", tra.getTrade_no_rel());
		data.put("out_refund_no", tra.getTrade_no());
		data.put("total_fee",
				pmputils.Yuan2Fen(ord.getAmount()));		
		data.put("refund_fee",
				pmputils.Yuan2Fen(dto.getAmount()));		
		data.put("refund_fee_type", "CNY");
		data.put("op_user_id", PmpPayAppUtils.getWXConfig().getMchID());
		data.put("notify_url", "http://59.108.125.241:8083/pmp/WXReFundNotifyHandler");
		
		//测试代码
//		data.put("out_trade_no", "0000000072");
//		data.put("out_refund_no", "05141510");
//		data.put("total_fee",1+"");
//		data.put("refund_fee",1+"");
		return data;
	}
	

	
	public  HashMap<String,String> getBillData(FDate date,String option){
		HashMap<String, String> data = new HashMap<String, String>();
		DateFormat format1 = new SimpleDateFormat("yyyyMMdd"); 
		String d=format1.format(date.toDate());
		data.put("bill_date", d);
		data.put("bill_type", option);
		return data;
	}
	


}
