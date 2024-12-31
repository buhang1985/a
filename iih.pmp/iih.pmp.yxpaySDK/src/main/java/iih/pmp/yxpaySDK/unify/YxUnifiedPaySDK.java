package iih.pmp.yxpaySDK.unify;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.yxpaySDK.bp.YxPayConfig;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import iih.pmp.yxpaySDK.cmbc.YxCmbcConst;
import xap.mw.core.data.BizException;

public class YxUnifiedPaySDK implements IPmpSdk{

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxPayConfig.getDomain()+YxUnifiedPayConst.UNIFIEDORDER_URL_SUFFIX;
		return YxPayUtils.post2(url, map);
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxPayConfig.getDomain()+YxUnifiedPayConst.QUERY_URL_SUFFIX;
		return YxPayUtils.post2(url, map);
	}

	@Override
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxPayConfig.getDomain()+YxUnifiedPayConst.REFUND_URL_SUFFIX;
		return YxPayUtils.post2(url, map);
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxPayConfig.getDomain()+YxUnifiedPayConst.QUERY_URL_SUFFIX;
		return YxPayUtils.post2(url, map);
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
		return "pay.yx.unified.0010";
	}

}
