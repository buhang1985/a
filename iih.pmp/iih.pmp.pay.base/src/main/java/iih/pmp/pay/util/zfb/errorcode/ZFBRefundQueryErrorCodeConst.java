package iih.pmp.pay.util.zfb.errorcode;

import iih.pmp.pay.trade.d.TradeStatusEnum;

public class ZFBRefundQueryErrorCodeConst {
	
	public final static String SYSTEM_ERROR="ACQ.SYSTEM_ERROR";
	public final static String INVALID_PARAMETER="ACQ.INVALID_PARAMETER";
	public final static String TRADE_NOT_EXIST="TRADE_NOT_EXIST";
	
	public static int getTradeFailStatus(String name){
        switch(name){
        case ZFBRefundQueryErrorCodeConst.SYSTEM_ERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;  
        case ZFBRefundQueryErrorCodeConst.INVALID_PARAMETER:
        	return TradeStatusEnum.TRADE_UNKNOWN; 
        case ZFBRefundQueryErrorCodeConst.TRADE_NOT_EXIST:
        	return TradeStatusEnum.REFUND_FAIL; 
        	
        default:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        }
	}


}
