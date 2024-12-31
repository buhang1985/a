package wxpay.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.conn.HttpHostConnectException;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.utils.PmpWxPayLogUtils;
import test.wxpay.sdk.WXPayConfigImpl;
import xap.mw.core.data.BizException;

public class WXPmpPaySdk implements IPmpSdk {
	private WXPay wxpay;
	private WXPayConfigImpl config;

	public WXPmpPaySdk() {
		try {
			config = WXPayConfigImpl.getInstance();
//			wxpay = new WXPay(config,"http://hit.viphk.ngrok.org/pmp/WXPayNotifyHandle",true,true);
			String notifyurl = WXProConfig.getProperty("notify_url");
			if (notifyurl != null && notifyurl.trim().length() != 0) {
				wxpay = new WXPay(config, notifyurl, true);
			} else {
				wxpay = new WXPay(config);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Map<String, String> convert2Str(Map<String, Object> map) {
		Map<String, String> data = new HashMap<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			Object o = entry.getValue();
			data.put(entry.getKey(), o == null ? null : o.toString());
		}
		return data;
	}

	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		Map<String, String> r = null;
		try {
			r = wxpay.microPay(convert2Str(map));

		} catch (HttpHostConnectException e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException("网络异常，请稍后再试");
		} catch (Exception e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API付款报错");
			throw new BizException(e);
		}
		return r;
	}

	@Override
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		Map<String, String> r = null;
		try {
			r = wxpay.orderQuery(convert2Str(map));
		} catch (HttpHostConnectException e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException("网络异常，请稍后再试");
		} catch (Exception e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException(e);
		}
		return r;
	}

	@Override
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		Map<String, String> r = null;
		try {
			r = wxpay.refund(convert2Str(map));
		} catch (HttpHostConnectException e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException("网络异常，请稍后再试");
		} catch (Exception e) {
			throw new BizException(e.getMessage(), e);
		}
		return r;
	}

	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		Map<String, String> r = null;
		try {
			r = wxpay.refundQuery(convert2Str(map));
		} catch (HttpHostConnectException e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException("网络异常，请稍后再试");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		}
		return r;
	}

	@Override
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> downloadfile(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> r = null;
		try {
			r = wxpay.downloadBill(convert2Str(map));
		} catch (HttpHostConnectException e) {
			PmpWxPayLogUtils.logExAndTitle(e, "微信API查询报错");
			throw new BizException("网络异常，请稍后再试");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		}
		return r;
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> rst = downloadfile(map);
		if (rst != null && rst.get("return_code").equals("SUCCESS")) {
			String msg = rst.get("data");
			String[] rnt = msg.split("\\n");
			String[] rest = new String[rnt.length - 3];
			for (int j = 1; j < rnt.length - 2; j++) {
				rest[j - 1] = rnt[j];
			}
			return rest;
		}
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		Map<String, String> r = null;
		try {
			r = wxpay.unifiedOrder(convert2Str(map));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		}
		return r;
	}

}
