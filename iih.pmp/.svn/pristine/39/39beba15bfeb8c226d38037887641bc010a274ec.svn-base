package iih.pmp.pay.util.zfb.errorcode;

import iih.pmp.pay.trade.d.TradeStatusEnum;

public class ZFBRefundErrorCodeConst {
	
	public final static String SYSTEM_ERROR="ACQ.SYSTEM_ERROR";
	public final static String INVALID_PARAMETER="ACQ.INVALID_PARAMETER";
	public final static String SELLER_BALANCE_NOT_ENOUGH="ACQ.SELLER_BALANCE_NOT_ENOUGH";
	public final static String REFUND_AMT_NOT_EQUAL_TOTAL="ACQ.REFUND_AMT_NOT_EQUAL_TOTAL";
	public final static String REASON_TRADE_BEEN_FREEZEN="ACQ.REASON_TRADE_BEEN_FREEZEN";
	public final static String TRADE_NOT_EXIST="ACQ.TRADE_NOT_EXIST";
	public final static String TRADE_HAS_FINISHED="ACQ.TRADE_HAS_FINISHED";
	public final static String TRADE_STATUS_ERROR="ACQ.TRADE_STATUS_ERROR";
	public final static String DISCORDANT_REPEAT_REQUEST="ACQ.DISCORDANT_REPEAT_REQUEST";
	public final static String REASON_TRADE_REFUND_FEE_ERR="ACQ.REASON_TRADE_REFUND_FEE_ERR";
	public final static String TRADE_NOT_ALLOW_REFUND="ACQ.TRADE_NOT_ALLOW_REFUND";
	public final static String REFUND_FEE_ERROR="ACQ.REFUND_FEE_ERROR";
	
	public static int getTradeFailStatus(String name){
        switch(name){
        case ZFBRefundErrorCodeConst.SYSTEM_ERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;  
        case ZFBRefundErrorCodeConst.INVALID_PARAMETER:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.SELLER_BALANCE_NOT_ENOUGH:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.REFUND_AMT_NOT_EQUAL_TOTAL:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.REASON_TRADE_BEEN_FREEZEN:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.TRADE_NOT_EXIST:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.TRADE_HAS_FINISHED:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.TRADE_STATUS_ERROR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.DISCORDANT_REPEAT_REQUEST:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.REASON_TRADE_REFUND_FEE_ERR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.TRADE_NOT_ALLOW_REFUND:
        	return TradeStatusEnum.REFUND_FAIL; 
        case ZFBRefundErrorCodeConst.REFUND_FEE_ERROR:
        	return TradeStatusEnum.REFUND_FAIL;         
        default:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        }
	
	}


}
