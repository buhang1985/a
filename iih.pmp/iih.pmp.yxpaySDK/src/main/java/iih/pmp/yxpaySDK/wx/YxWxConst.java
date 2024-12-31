package iih.pmp.yxpaySDK.wx;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class YxWxConst  {
	private static  PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();
//	public static final String DOMAIN_API="https://testapi-platform.pkuih.edu.cn";
//	public static final String DOMAIN_API=getYxURL();
	
	public static final String UNIFIEDORDER_URL_SUFFIX="/api/wechat/wechatUnifiedorder";
	public static final String QUERY_URL_SUFFIX="/api/wechat/wechatOrderquery";
	public static final String REFUND_URL_SUFFIX="/api/wechat/wechatRefund";
	public static final String REFUND_QUERY_URL_SUFFIX="/api/wechat/wechatRefundquery";
	
	public static String getYxURL() throws BizException {
		String url =ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),PmpPayBaseCost.PMP_YXURL);
		return url;
	}
	
}
