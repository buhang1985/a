package iih.pmp.pay.util.wxerrorcode2;

import iih.pmp.pay.trade.d.TradeStatusEnum;

/**
 * 刷卡支付错误代码  描述信息中加上错误原因和解决方案
 * @author li_cheng
 *
 */
public class WXMicropayErrorCodeConst2 {
	
	public final static String SYSTEMERROR="SYSTEMERROR";
	public final static String SYSTEMERROR__DES="系统超时;请立即调用被扫订单结果查询API，查询当前订单状态，并根据订单的状态决定下一步的操作。";
	public final static String PARAM_ERROR="PARAM_ERROR";
	public final static String PARAM_ERROR__DES="请求参数未按指引进行填写;请根据接口返回的详细信息检查您的程序";
	public final static String ORDERPAID="ORDERPAID";
	public final static String ORDERPAID__DES="订单号重复;请确认该订单号是否重复支付，如果是新单，请使用新订单号提交";
	public final static String NOAUTH="NOAUTH";
	public final static String NOAUTH__DES="商户没有开通被扫支付权限;请开通商户号权限。请联系产品或商务申请";
	public final static String AUTHCODEEXPIRE="AUTHCODEEXPIRE";
	public final static String AUTHCODEEXPIRE__DES="用户的条码已经过期;请收银员提示用户，请用户在微信上刷新条码，然后请收银员重新扫码。 直接将错误展示给收银员";
	public final static String NOTENOUGH="NOTENOUGH";
//	public final static String NOTENOUGH__DES="余额不足;用户的零钱余额不足;请收银员提示用户更换当前支付的卡，然后请收银员重新扫码。建议：商户系统返回给收银台的提示为“用户余额不足.提示用户换卡支付”";
	public final static String NOTENOUGH__DES="用户余额不足.提示用户换卡支付";
	public final static String NOTSUPORTCARD="NOTSUPORTCARD";
//	public final static String NOTSUPORTCARD__DES="不支持卡类型;用户使用卡种不支持当前支付形式;请用户重新选择卡种 建议：商户系统返回给收银台的提示为“该卡不支持当前支付，提示用户换卡支付或绑新卡支付”";
	public final static String NOTSUPORTCARD__DES="该卡不支持当前支付，提示用户换卡支付或绑新卡支付";
	public final static String ORDERCLOSED="ORDERCLOSED";
	public final static String ORDERCLOSED__DES="该订单已关;商户订单号异常，请重新下单支付";
	public final static String ORDERREVERSED="ORDERREVERSED";
	public final static String ORDERREVERSED__DES="当前订单已经被撤销;当前订单状态为“订单已撤销”，请提示用户重新支付";
	public final static String BANKERROR="BANKERROR";
	public final static String BANKERROR__DES="银行端超时;请立即调用被扫订单结果查询API，查询当前订单的不同状态，决定下一步的操作。";
	public final static String USERPAYING="USERPAYING";
	public final static String USERPAYING__DES="该笔交易因为业务规则要求，需要用户输入支付密码。;等待5秒，然后调用被扫订单结果查询API，查询当前订单的不同状态，决定下一步的操作。";
	public final static String AUTH_CODE_ERROR="AUTH_CODE_ERROR";
	public final static String AUTH_CODE_ERROR__DES="请求参数未按指引进行填写;每个二维码仅限使用一次，请刷新再试";
	public final static String AUTH_CODE_INVALID="AUTH_CODE_INVALID";
	public final static String AUTH_CODE_INVALID__DES="收银员扫描的不是微信支付的条码;请扫描微信支付被扫条码/二维码";
	public final static String XML_FORMAT_ERROR="XML_FORMAT_ERROR";
	public final static String XML_FORMAT_ERROR__DES="XML格式错误;请检查XML参数格式是否正确";
	public final static String REQUIRE_POST_METHOD="REQUIRE_POST_METHOD";
	public final static String REQUIRE_POST_METHOD__DES="未使用post传递参数;请检查请求参数是否通过post方法提交";
	public final static String SIGNERROR="SIGNERROR";
	public final static String SIGNERROR__DES="参数签名结果不正确;请检查签名参数和方法是否都符合签名算法要求";
	public final static String LACK_PARAMS="LACK_PARAMS";
	public final static String LACK_PARAMS__DES="缺少必要的请求参数;请检查参数是否齐全";
	public final static String NOT_UTF8	="NOT_UTF8";
	public final static String NOT_UTF8__DES="未使用指定编码格式;请使用UTF-8编码格式";
	public final static String BUYER_MISMATCH="BUYER_MISMATCH";
	public final static String BUYER_MISMATCH__DES="暂不支持同一笔订单更换支付方;请确认支付方是否相同";	
	public final static String APPID_NOT_EXIST="APPID_NOT_EXIST";
	public final static String APPID_NOT_EXIST__DES="参数中缺少APPID;请检查APPID是否正确";
	public final static String MCHID_NOT_EXIST="MCHID_NOT_EXIST";
	public final static String MCHID_NOT_EXIST__DES="参数中缺少MCHID;请检查MCHID是否正确";
	public final static String OUT_TRADE_NO_USED="OUT_TRADE_NO_USED";
	public final static String OUT_TRADE_NO_USED__DES="同一笔交易不能多次提交;请核实商户订单号是否重复提交";
	public final static String APPID_MCHID_NOT_MATCH="APPID_MCHID_NOT_MATCH";
	public final static String APPID_MCHID_NOT_MATCH__DES="appid和mch_id不匹配;请确认appid和mch_id是否匹配";
	public final static String INVALID_REQUEST="INVALID_REQUEST";
	public final static String INVALID_REQUEST__DES="商户系统异常导致，商户权限异常、重复请求支付、证书错误、频率限制等;请确认商户系统是否正常，是否具有相应支付权限，确认证书是否正确，控制频率";
	public final static String TRADE_ERROR="TRADE_ERROR";
	public final static String TRADE_ERROR__DES="业务错误导致交易失败、用户账号异常、风控、规则限制等;请确认帐号是否存在异常";
	
	public static String getExtErrorDes(String name){
        switch(name){
        case WXMicropayErrorCodeConst2.NOAUTH:
        	return WXMicropayErrorCodeConst2.NOAUTH__DES;
        case WXMicropayErrorCodeConst2.NOTENOUGH:
        	return WXMicropayErrorCodeConst2.NOTENOUGH__DES;
        case WXMicropayErrorCodeConst2.ORDERPAID:
        	return WXMicropayErrorCodeConst2.ORDERPAID__DES;
        case WXMicropayErrorCodeConst2.ORDERCLOSED:
        	return WXMicropayErrorCodeConst2.ORDERCLOSED__DES;
        case WXMicropayErrorCodeConst2.SYSTEMERROR:
        	return WXMicropayErrorCodeConst2.SYSTEMERROR__DES;
        case WXMicropayErrorCodeConst2.APPID_NOT_EXIST:
        	return WXMicropayErrorCodeConst2.APPID_NOT_EXIST__DES;
        case WXMicropayErrorCodeConst2.MCHID_NOT_EXIST:
        	return WXMicropayErrorCodeConst2.MCHID_NOT_EXIST__DES;
        case WXMicropayErrorCodeConst2.APPID_MCHID_NOT_MATCH:
        	return WXMicropayErrorCodeConst2.APPID_MCHID_NOT_MATCH__DES;
        case WXMicropayErrorCodeConst2.LACK_PARAMS:
        	return WXMicropayErrorCodeConst2.LACK_PARAMS__DES;
        case WXMicropayErrorCodeConst2.OUT_TRADE_NO_USED:
        	return WXMicropayErrorCodeConst2.OUT_TRADE_NO_USED__DES;
        case WXMicropayErrorCodeConst2.SIGNERROR:
        	return WXMicropayErrorCodeConst2.SIGNERROR__DES;
        case WXMicropayErrorCodeConst2.XML_FORMAT_ERROR:
        	return WXMicropayErrorCodeConst2.XML_FORMAT_ERROR__DES;
        case WXMicropayErrorCodeConst2.REQUIRE_POST_METHOD:
        	return WXMicropayErrorCodeConst2.REQUIRE_POST_METHOD__DES;
        case WXMicropayErrorCodeConst2.NOT_UTF8:
        	return WXMicropayErrorCodeConst2.NOT_UTF8__DES;
        case WXMicropayErrorCodeConst2.PARAM_ERROR:
        	return WXMicropayErrorCodeConst2.PARAM_ERROR__DES;
        case WXMicropayErrorCodeConst2.AUTHCODEEXPIRE:
        	return WXMicropayErrorCodeConst2.AUTHCODEEXPIRE__DES;
        case WXMicropayErrorCodeConst2.NOTSUPORTCARD:
        	return WXMicropayErrorCodeConst2.NOTSUPORTCARD__DES;
        case WXMicropayErrorCodeConst2.ORDERREVERSED:
        	return WXMicropayErrorCodeConst2.ORDERREVERSED__DES;
        case WXMicropayErrorCodeConst2.BANKERROR:
        	return WXMicropayErrorCodeConst2.BANKERROR__DES;
        case WXMicropayErrorCodeConst2.USERPAYING:
        	return WXMicropayErrorCodeConst2.USERPAYING__DES;
        case WXMicropayErrorCodeConst2.AUTH_CODE_ERROR:
        	return WXMicropayErrorCodeConst2.AUTH_CODE_ERROR__DES;
        case WXMicropayErrorCodeConst2.AUTH_CODE_INVALID:
        	return WXMicropayErrorCodeConst2.AUTH_CODE_INVALID__DES;
        case WXMicropayErrorCodeConst2.BUYER_MISMATCH:
        	return WXMicropayErrorCodeConst2.BUYER_MISMATCH__DES;
        case WXMicropayErrorCodeConst2.INVALID_REQUEST:
        	return WXMicropayErrorCodeConst2.INVALID_REQUEST__DES;
        case WXMicropayErrorCodeConst2.TRADE_ERROR:
        	return WXMicropayErrorCodeConst2.TRADE_ERROR__DES;
        }
		return null;
	}
	
	public static String getErrorCode(String errorcode,String Errordes)
	{
		String rst=Errordes+";";
		String exdes=WXMicropayErrorCodeConst2.getExtErrorDes(errorcode);
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
        case WXMicropayErrorCodeConst2.NOAUTH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.NOTENOUGH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.ORDERPAID:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.ORDERCLOSED:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.SYSTEMERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        case WXMicropayErrorCodeConst2.APPID_NOT_EXIST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.MCHID_NOT_EXIST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.APPID_MCHID_NOT_MATCH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.LACK_PARAMS:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.OUT_TRADE_NO_USED:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        case WXMicropayErrorCodeConst2.SIGNERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.XML_FORMAT_ERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.REQUIRE_POST_METHOD:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.NOT_UTF8:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.PARAM_ERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.AUTHCODEEXPIRE:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.NOTSUPORTCARD:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.ORDERREVERSED:
        	return TradeStatusEnum.REVOKED;
        case WXMicropayErrorCodeConst2.BANKERROR:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        case WXMicropayErrorCodeConst2.USERPAYING:
        	return TradeStatusEnum.PAY_WAIT;
        case WXMicropayErrorCodeConst2.AUTH_CODE_ERROR:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.AUTH_CODE_INVALID:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.BUYER_MISMATCH:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.INVALID_REQUEST:
        	return TradeStatusEnum.PAY_FAIL;
        case WXMicropayErrorCodeConst2.TRADE_ERROR:
        	return TradeStatusEnum.PAY_FAIL;
        default:
        	return TradeStatusEnum.TRADE_UNKNOWN;
        }
	
	}

}
