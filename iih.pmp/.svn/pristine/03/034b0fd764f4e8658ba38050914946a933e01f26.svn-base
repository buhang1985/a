package iih.pmp.pay.util.wxerrorcode2;

import iih.pmp.pay.trade.d.TradeStatusEnum;

public class WXQueryErrorcode2 {
	
	public final static String ORDERNOTEXIST="ORDERNOTEXIST";
	public final static String ORDERNOTEXIST__DES="查询系统中不存在此交易订单号;该API只能查提交支付交易返回成功的订单，请商户检查需要查询的订单号是否正确";
	public final static String SYSTEMERROR="SYSTEMERROR";
	public final static String SYSTEMERROR__DES="后台系统返回错误;系统异常，请再调用发起查询";
	
	public static String getExtErrorDes(String name){
        switch(name){
        case WXQueryErrorcode2.ORDERNOTEXIST:
        	return WXQueryErrorcode2.ORDERNOTEXIST__DES;
        case WXQueryErrorcode2.SYSTEMERROR:
        	return WXQueryErrorcode2.SYSTEMERROR__DES;        
        }
		return null;
	}
	
	public static String getErrorCode(String errorcode,String Errordes)
	{
		String rst=Errordes+";";
		String exdes=WXQueryErrorcode2.getExtErrorDes(errorcode);
		if(exdes!=null)
			rst=rst+exdes;
		return rst;
	}
	
	public static int getTradeFailStatus(String name){
        switch(name){
        case  WXQueryErrorcode2.ORDERNOTEXIST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXQueryErrorcode2.SYSTEMERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        
        default:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        }
	
	}

}
