package iih.pmp.yxpaySDK.wx;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.utils.PmpWxPayLogUtils;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import xap.mw.core.data.BizException;

public class YxWxPaySDK   implements IPmpSdk{

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxWxConst.getYxURL()+YxWxConst.UNIFIEDORDER_URL_SUFFIX;
		return YxPayUtils.post(url, map);
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxWxConst.getYxURL()+YxWxConst.QUERY_URL_SUFFIX;
		return YxPayUtils.post(url, map);
	}

	@Override
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxWxConst.getYxURL()+YxWxConst.REFUND_URL_SUFFIX;
		return YxPayUtils.post(url, map);
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxWxConst.getYxURL()+YxWxConst.REFUND_QUERY_URL_SUFFIX;
		return YxPayUtils.post(url, map);
	}

	@Override
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> downloadfile(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return "pay.yx.wx.0008";
	}

}
