package iih.pmp.pay.util.wxerrorcode2;

import iih.pmp.pay.trade.d.TradeStatusEnum;

/**
 * 统一下单错误代码   描述信息中加上错误原因和解决方案
 * @author li_cheng
 *
 */
public class WXUnifiedErrorCodeConst2 {
	
	public final static String NOAUTH="NOAUTH";
	public final static String NOAUTH__DES="商户未开通此接口权限;请商户前往申请此接口权限";
	public final static String NOTENOUGH="NOTENOUGH";
	public final static String NOTENOUGH__DES="用户帐号余额不足;用户帐号余额不足，请用户充值或更换支付卡后再支付";
	public final static String ORDERPAID="ORDERPAID";
	public final static String ORDERPAID__DES="商户订单已支付，无需重复操作;商户订单已支付，无需更多操作";
	public final static String ORDERCLOSED="ORDERCLOSED";
	public final static String ORDERCLOSED__DES="当前订单已关闭，无法支付;当前订单已关闭，请重新下单";
	public final static String SYSTEMERROR="SYSTEMERROR";
	public final static String SYSTEMERROR__DES="系统超时;系统异常，请用相同参数重新调用";
	public final static String APPID_NOT_EXIST="APPID_NOT_EXIST";
	public final static String APPID_NOT_EXIST__DES="参数中缺少APPID;请检查APPID是否正确";
	public final static String MCHID_NOT_EXIST="MCHID_NOT_EXIST";
	public final static String MCHID_NOT_EXIST__DES="参数中缺少MCHID;请检查MCHID是否正确";
	public final static String APPID_MCHID_NOT_MATCH="APPID_MCHID_NOT_MATCH";
	public final static String APPID_MCHID_NOT_MATCH__DES="appid和mch_id不匹配;请确认appid和mch_id是否匹配";
	public final static String LACK_PARAMS="LACK_PARAMS";
	public final static String LACK_PARAMS__DES="缺少必要的请求参数;请检查参数是否齐全";
	public final static String OUT_TRADE_NO_USED="OUT_TRADE_NO_USED";
	public final static String OUT_TRADE_NO_USED__DES="同一笔交易不能多次提交;请核实商户订单号是否重复提交";
	public final static String SIGNERROR="SIGNERROR";
	public final static String SIGNERROR__DES="参数签名结果不正确;请检查签名参数和方法是否都符合签名算法要求";
	public final static String XML_FORMAT_ERROR="XML_FORMAT_ERROR";
	public final static String XML_FORMAT_ERROR__DES="XML格式错误;请检查XML参数格式是否正确";
	public final static String REQUIRE_POST_METHOD="REQUIRE_POST_METHOD";
	public final static String REQUIRE_POST_METHOD__DES="未使用post传递参数;请检查请求参数是否通过post方法提交";
	public final static String POST_DATA_EMPTY="POST_DATA_EMPTY";
	public final static String POST_DATA_EMPTY__DES="post数据不能为空;请检查post数据是否为空";
	public final static String NOT_UTF8	="NOT_UTF8	";
	public final static String NOT_UTF8__DES="未使用指定编码格式;请使用UTF-8编码格式";
	
	public static String getExtErrorDes(String name){
        switch(name){
        case WXUnifiedErrorCodeConst2.NOAUTH:
        	return WXUnifiedErrorCodeConst2.NOAUTH__DES;
        case WXUnifiedErrorCodeConst2.NOTENOUGH:
        	return WXUnifiedErrorCodeConst2.NOTENOUGH__DES;
        case WXUnifiedErrorCodeConst2.ORDERPAID:
        	return WXUnifiedErrorCodeConst2.ORDERPAID__DES;
        case WXUnifiedErrorCodeConst2.ORDERCLOSED:
        	return WXUnifiedErrorCodeConst2.ORDERCLOSED__DES;
        case WXUnifiedErrorCodeConst2.SYSTEMERROR:
        	return WXUnifiedErrorCodeConst2.SYSTEMERROR__DES;
        case WXUnifiedErrorCodeConst2.APPID_NOT_EXIST:
        	return WXUnifiedErrorCodeConst2.APPID_NOT_EXIST__DES;
        case WXUnifiedErrorCodeConst2.MCHID_NOT_EXIST:
        	return WXUnifiedErrorCodeConst2.MCHID_NOT_EXIST__DES;
        case WXUnifiedErrorCodeConst2.APPID_MCHID_NOT_MATCH:
        	return WXUnifiedErrorCodeConst2.APPID_MCHID_NOT_MATCH__DES;
        case WXUnifiedErrorCodeConst2.LACK_PARAMS:
        	return WXUnifiedErrorCodeConst2.LACK_PARAMS__DES;
        case WXUnifiedErrorCodeConst2.OUT_TRADE_NO_USED:
        	return WXUnifiedErrorCodeConst2.OUT_TRADE_NO_USED__DES;
        case WXUnifiedErrorCodeConst2.SIGNERROR:
        	return WXUnifiedErrorCodeConst2.SIGNERROR__DES;
        case WXUnifiedErrorCodeConst2.XML_FORMAT_ERROR:
        	return WXUnifiedErrorCodeConst2.XML_FORMAT_ERROR__DES;
        case WXUnifiedErrorCodeConst2.REQUIRE_POST_METHOD:
        	return WXUnifiedErrorCodeConst2.REQUIRE_POST_METHOD__DES;
        case WXUnifiedErrorCodeConst2.POST_DATA_EMPTY:
        	return WXUnifiedErrorCodeConst2.POST_DATA_EMPTY__DES;
        case WXUnifiedErrorCodeConst2.NOT_UTF8:
        	return WXUnifiedErrorCodeConst2.NOT_UTF8__DES;
        }
		return null;
	}
	
	public static String getErrorCode(String errorcode,String Errordes)
	{
		String rst=Errordes+";";
		String exdes=WXUnifiedErrorCodeConst2.getExtErrorDes(errorcode);
		if(exdes!=null)
			rst=rst+exdes;
		return rst;
	}
	/**
	 * 处理错误代码对应的交易状态
	 * @param name
	 * @return
	 */
	public static int getTradeFailStatus(String name){
        switch(name){
        case WXUnifiedErrorCodeConst2.NOAUTH:
        	 return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.NOTENOUGH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.ORDERPAID:
        	return TradeStatusEnum.PAY_SUCCESS;
        case WXUnifiedErrorCodeConst2.ORDERCLOSED:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.SYSTEMERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        case WXUnifiedErrorCodeConst2.APPID_NOT_EXIST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.MCHID_NOT_EXIST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.APPID_MCHID_NOT_MATCH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.LACK_PARAMS:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.OUT_TRADE_NO_USED:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        case WXUnifiedErrorCodeConst2.SIGNERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.XML_FORMAT_ERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.REQUIRE_POST_METHOD:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.POST_DATA_EMPTY:
        	return TradeStatusEnum.PAY_FAIL;
        case WXUnifiedErrorCodeConst2.NOT_UTF8:
        	return TradeStatusEnum.PAY_FAIL;
        default:
        	return  TradeStatusEnum.TRADE_UNKNOWN;
        }

	}
}
