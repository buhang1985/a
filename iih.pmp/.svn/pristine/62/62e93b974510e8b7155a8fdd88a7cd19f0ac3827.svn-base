package iih.pmp.pay.util.wxerrorcode;

import iih.pmp.pay.trade.d.TradeStatusEnum;

public class WXReFundErrorCode {
	
	public static final String SYSTEMERROR="SYSTEMERROR";
	public static final String SYSTEMERROR__DES="系统超时等;请不要更换商户退款单号，请使用相同参数再次调用API。";
	
	public static final String BIZERR_NEED_RETRY="BIZERR_NEED_RETRY";
	public static final String BIZERR_NEED_RETRY__DES="并发情况下，业务被拒绝，商户重试即可解决;请不要更换商户退款单号，请使用相同参数再次调用API。";
	public static final String TRADE_OVERDUE="TRADE_OVERDUE";
	public static final String TRADE_OVERDUE__DES="订单已经超过可退款的最大期限(支付后一年内可退款);请选择其他方式自行退款";
	public static final String ERROR="ERROR";
	public static final String ERROR__DES="申请退款业务发生错误;该错误都会返回具体的错误原因，请根据实际返回做相应处理。";
	public static final String USER_ACCOUNT_ABNORMAL="USER_ACCOUNT_ABNORMAL";
	public static final String USER_ACCOUNT_ABNORMAL__DES="用户帐号注销;此状态代表退款申请失败，商户可自行处理退款。";
	public static final String INVALID_REQ_TOO_MUCH="INVALID_REQ_TOO_MUCH";
	public static final String INVALID_REQ_TOO_MUCH__DES="连续错误请求数过多被系统短暂屏蔽;请检查业务是否正常，确认业务正常后请在1分钟后再来重试";
	public static final String NOTENOUGH="NOTENOUGH";
	public static final String NOTENOUGH__DES="商户可用退款余额不足;此状态代表退款申请失败，商户可根据具体的错误提示做相应的处理。";
	public static final String INVALID_TRANSACTIONID="INVALID_TRANSACTIONID";
	public static final String INVALID_TRANSACTIONID__DES="请求参数未按指引进行填写;请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败";
	public static final String PARAM_ERROR="PARAM_ERROR";
	public static final String PARAM_ERROR__DES="请求参数未按指引进行填写;请求参数错误，请重新检查再调用退款申请";
	public static final String APPID_NOT_EXIST="APPID_NOT_EXIST";
	public static final String APPID_NOT_EXIST__DES="参数中缺少APPID;请检查APPID是否正确";
	public static final String MCHID_NOT_EXIST="MCHID_NOT_EXIST";
	public static final String MCHID_NOT_EXIST__DES="参数中缺少MCHID;请检查MCHID是否正确";
	public static final String REQUIRE_POST_METHOD="REQUIRE_POST_METHOD";
	public static final String REQUIRE_POST_METHOD__DES="未使用post传递参数;请检查请求参数是否通过post方法提交";
	public static final String SIGNERROR="SIGNERROR";
	public static final String SIGNERROR__DES="参数签名结果不正确;请检查签名参数和方法是否都符合签名算法要求";
	public static final String XML_FORMAT_ERROR="XML_FORMAT_ERROR";
	public static final String XML_FORMAT_ERROR__DES="XML格式错误;请检查XML参数格式是否正确";
	public static final String FREQUENCY_LIMITED="FREQUENCY_LIMITED";
	public static final String FREQUENCY_LIMITED__DES="2个月之前的订单申请退款有频率限制;该笔退款未受理，请降低频率后重试";
	
	public static String getExtErrorDes(String name){
        switch(name){
        case WXReFundErrorCode.SYSTEMERROR:
        	return WXReFundErrorCode.SYSTEMERROR__DES;  
        case WXReFundErrorCode.BIZERR_NEED_RETRY:
        	return WXReFundErrorCode.BIZERR_NEED_RETRY__DES; 
        case WXReFundErrorCode.TRADE_OVERDUE:
        	return WXReFundErrorCode.TRADE_OVERDUE__DES; 
        case WXReFundErrorCode.ERROR:
        	return WXReFundErrorCode.ERROR__DES; 
        case WXReFundErrorCode.USER_ACCOUNT_ABNORMAL:
        	return WXReFundErrorCode.USER_ACCOUNT_ABNORMAL__DES; 
        case WXReFundErrorCode.INVALID_REQ_TOO_MUCH:
        	return WXReFundErrorCode.INVALID_REQ_TOO_MUCH__DES; 
        case WXReFundErrorCode.NOTENOUGH:
        	return WXReFundErrorCode.NOTENOUGH__DES; 
        case WXReFundErrorCode.INVALID_TRANSACTIONID:
        	return WXReFundErrorCode.INVALID_TRANSACTIONID__DES; 
        case WXReFundErrorCode.PARAM_ERROR:
        	return WXReFundErrorCode.PARAM_ERROR__DES; 
        case WXReFundErrorCode.APPID_NOT_EXIST:
        	return WXReFundErrorCode.APPID_NOT_EXIST__DES; 
        case WXReFundErrorCode.MCHID_NOT_EXIST:
        	return WXReFundErrorCode.MCHID_NOT_EXIST__DES; 
        case WXReFundErrorCode.REQUIRE_POST_METHOD:
        	return WXReFundErrorCode.REQUIRE_POST_METHOD__DES; 
        case WXReFundErrorCode.SIGNERROR:
        	return WXReFundErrorCode.SIGNERROR__DES; 
        case WXReFundErrorCode.XML_FORMAT_ERROR:
        	return WXReFundErrorCode.XML_FORMAT_ERROR__DES; 
        case WXReFundErrorCode.FREQUENCY_LIMITED:
        	return WXReFundErrorCode.FREQUENCY_LIMITED__DES; 

        }
		return null;
	}
	
	public static String getErrorCode(String errorcode,String Errordes)
	{
		String rst=Errordes+";";
		String exdes=WXReFundErrorCode.getExtErrorDes(errorcode);
		if(exdes!=null)
			rst=rst+exdes;
		return rst;
	}
	
	public static int getTradeFailStatus(String name){
        switch(name){
        case WXReFundErrorCode.SYSTEMERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;  
        case WXReFundErrorCode.BIZERR_NEED_RETRY:
        	return TradeStatusEnum.TRADE_UNKNOWN; 
        case WXReFundErrorCode.TRADE_OVERDUE:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.ERROR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.USER_ACCOUNT_ABNORMAL:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.INVALID_REQ_TOO_MUCH:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.NOTENOUGH:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.INVALID_TRANSACTIONID:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.PARAM_ERROR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.APPID_NOT_EXIST:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.MCHID_NOT_EXIST:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.REQUIRE_POST_METHOD:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.SIGNERROR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.XML_FORMAT_ERROR:
        	return TradeStatusEnum.REFUND_FAIL; 
        case WXReFundErrorCode.FREQUENCY_LIMITED:
        	return TradeStatusEnum.REFUND_FAIL;         
        default:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        }
	
	}
}
