package test.wxpay.sdk;

import java.util.HashMap;
import java.util.Map;

import wxpay.sdk.WXPay;
import wxpay.sdk.WXPayUtil;

public class TestWXPay {
	
	private WXPay wxpay;
	private WXPayConfigImpl config;
	
	private String out_trade_no;
	private String total_fee;
	
	public TestWXPay()throws Exception{
		config=WXPayConfigImpl.getInstance();
		wxpay=new WXPay(config);
		total_fee="1";
	    out_trade_no = "201613091059590000003433-asd002";
	}
	
	public void doUnifiedOrder(){
		HashMap<String,String>data=new HashMap<String,String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
        try{
        	Map<String,String> r=wxpay.unifiedOrder(data);
        	System.out.println(r);
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	public void doOrderClose(){
		HashMap<String,String> data=new HashMap<>();
		data.put("out_trade_no", out_trade_no);
		try{
        	Map<String,String> r=wxpay.closeOrder(data);
        	System.out.println(r);
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public void doOrderQuery(){
		HashMap<String,String>data=new HashMap<String,String>();
		data.put("out_trade_no", out_trade_no);
		try{
        	Map<String,String> r=wxpay.orderQuery(data);
        	System.out.println(r);
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public void doGetSandboxSignKey()throws Exception{
		WXPayConfigImpl config=WXPayConfigImpl.getInstance();
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("mch_id", config.getMchID());
		data.put("nonce_str", WXPayUtil.generateNonceStr());
		String sign=WXPayUtil.generateSignature(data, config.getKey());
		data.put("sign", sign);
		WXPay wxPay=new WXPay(config);
		String result=wxPay.requestWithoutCert("https://api.mch.weixin.qq.com/sandbox/pay/getsignkey",data, 10000, 10000);
	}

}
