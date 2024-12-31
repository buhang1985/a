package iih.pmp.yilutong;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.yilutong.i.IWindowPayWebServiceV2;
import iih.pmp.yilutong.util.YiLuTongParam;
import iih.pmp.yilutong.util.YiLuTongWXPayUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

public class YilutongPayBP implements IPmpSdk {
	IWindowPayWebServiceV2 service = ServiceFinder.find(IWindowPayWebServiceV2.class);

	/**
	 * 反扫支付
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * 
	 */
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException {
		// 组装xml
		String xml = this.doApi(map);
		if (this.service == null) {
			throw new BizException("未获取到第三方接口");
		}
		// 调用接口获取返回值
		String microPay = this.service.microPay(xml);
		if (StringUtil.isEmptyWithTrim(microPay)) {
			throw new BizException("第三方接口未返回值");
		}
		// xml 转化 map
		Map<String, String> rtnMap = YiLuTongWXPayUtil.xmlToMap2(microPay);
		return rtnMap;

	}

	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * @throws Exception
	 */
	public Map<String, String> doQuery(Map<String, Object> map) throws BizException {
		String xml = this.doApi(map);
		// 调用接口获取返回值
		if (this.service == null) {
			throw new BizException("未获取到第三方接口");
		}
		String microPay = this.service.qryPayStatus(xml);
		if (StringUtil.isEmptyWithTrim(microPay)) {
			throw new BizException("第三方接口未返回值");
		}
		// xml 转化 map
		Map<String, String> rtnMap = YiLuTongWXPayUtil.xmlToMap2(microPay);
		return rtnMap;
	}

	/**
	 * 订单撤销
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * @throws Exception
	 */
	public Map<String, String> reverse(Map<String, Object> map) throws BizException {
		String xml = this.doApi(map);
		// 调用接口获取返回值
		if (this.service == null) {
			throw new BizException("未获取到第三方接口");
		}
		String microPay = this.service.reverseOrder(xml);
		// xml 转化 map
		if (StringUtil.isEmptyWithTrim(microPay)) {
			throw new BizException("第三方接口未返回值");
		}
		Map<String, String> rtnMap = YiLuTongWXPayUtil.xmlToMap2(microPay);
		return rtnMap;

	}

	/**
	 * 退款
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * @throws Exception
	 */
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		String xml = this.doApi(map);
		// 调用接口获取返回值
		if (this.service == null) {
			throw new BizException("未获取到第三方接口");
		}
		String microPay = this.service.scanRefund(xml);
		// xml 转化 map
		if (StringUtil.isEmptyWithTrim(microPay)) {
			throw new BizException("第三方接口未返回值");
		}
		Map<String, String> rtnMap = YiLuTongWXPayUtil.xmlToMap2(microPay);
		return rtnMap;
	}

	/**
	 * 退款查询
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * @throws Exception
	 */
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		String xml = this.doApi(map);
		// 调用接口获取返回值
		String microPay = this.service.qryRefund(xml);
		// xml 转化 map
		if (StringUtil.isEmptyWithTrim(microPay)) {
			throw new BizException("第三方接口未返回值");
		}
		Map<String, String> rtnMap = YiLuTongWXPayUtil.xmlToMap2(microPay);
		return rtnMap;
	}

	/**
	 * 日终业务总账对账
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) {
		return null;
	}

	@Override
	public Map<String, String> downloadfile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * map转换xml
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 * @throws Exception
	 */
	private String doApi(Map<String, Object> map) throws BizException {
		try {
			// 转化成 Map<String, String>
			Map<String, String> mapString = YiLuTongWXPayUtil.toMapString(map);
			// 生成带签名的 xml
			String xml = YiLuTongWXPayUtil.generateSignedXml(mapString, YiLuTongParam.MD5_KEY);
			return xml;
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return PmpPayConst.YLT_CHANNEL_CODE;
	}

	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
}
