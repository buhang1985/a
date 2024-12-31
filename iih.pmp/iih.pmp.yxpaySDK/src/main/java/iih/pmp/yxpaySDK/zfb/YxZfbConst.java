package iih.pmp.yxpaySDK.zfb;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class YxZfbConst {
	private static  PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();
	//public static final String DOMAIN_API="https://testapi-platform.pkuih.edu.cn";
	public static final String DOMAIN_API="http://pay.rjhwuxi.com:4000";

	public static final String BARCODE_URL_SUFFIX="/api/alipay/alipayTradeFaceToFace";
	public static final String QUERY_URL_SUFFIX="/api/alipay/alipayTradeQuery";
	public static final String REFUND_QUERY_URL_SUFFIX="/api/alipay/alipayTradeFastpayRefundQuery";
	public static final String REFUND_URL_SUFFIX="/api/alipay/alipayTradeRefund";

	public static String getYxURL() throws BizException {
		String url =ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),PmpPayBaseCost.PMP_YXURL);
		return url;
	}
}
