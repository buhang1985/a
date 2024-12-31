package iih.pmp.yxpaySDK.zfb;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import iih.pmp.yxpaySDK.cmbc.YxCmbcConst;
import xap.mw.core.data.BizException;

public class YxZfbPaySDK   implements IPmpSdk{

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxZfbConst.getYxURL()+YxZfbConst.BARCODE_URL_SUFFIX;
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
		String url=YxZfbConst.getYxURL()+YxZfbConst.QUERY_URL_SUFFIX;
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
		String url=YxZfbConst.getYxURL()+YxZfbConst.REFUND_URL_SUFFIX;
		Map<String, String> rnt=YxPayUtils.post(url, map);
		if(rnt!=null)
		rnt.put(PmpPayConst.PMP_TRADE_NO, map.get("merchantRefundTradeNo")+"");
		return rnt;
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=YxZfbConst.getYxURL()+YxZfbConst.REFUND_QUERY_URL_SUFFIX;
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
		return "pay.yx.ali.0007";
	}

}
