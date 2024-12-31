package test.wxpay.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import iih.pmp.pay.merchantinformation.d.MerchantInformationDO;
import iih.pmp.pay.merchantinformation.i.IMerchantinformationRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import wxpay.sdk.IWXPayDomain;
import wxpay.sdk.WXPayConfig;
import wxpay.sdk.WXProConfig;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class WXPayConfigImpl extends WXPayConfig {

	private  IMerchantinformationRService _imerchantinformationRService = ServiceFinder.find(IMerchantinformationRService.class);
	private  MerchantInformationDO[] _merchantInformation;
	private byte[] certData;
	private static WXPayConfigImpl INSTANCE;
	private PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();

	private WXPayConfigImpl() throws Exception {
		
		_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '1' and FG_ACTIVE = 'Y'", "", FBoolean.FALSE);

	/*	String certPath = "cert/apiclient_cert.p12";

		// File file = new File(certPath);
		InputStream certStream = WXPayConfigImpl.class.getClassLoader().getResourceAsStream(certPath);
		// InputStream certStream = new FileInputStream(file);
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = certStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		this.certData = swapStream.toByteArray();
		// this.certData = new byte[(int) certStream.];
		certStream.read(this.certData);
		certStream.close();*/
	}

	public static WXPayConfigImpl getInstance() throws Exception {
		if (INSTANCE == null) {
			synchronized (WXPayConfigImpl.class) {
				if (INSTANCE == null) {
					INSTANCE = new WXPayConfigImpl();
				}
			}
		}
		return INSTANCE;
	}

	public String getAppID()  {
		if (_merchantInformation != null && _merchantInformation.length > 0) {
			return _merchantInformation[0].getId_app();
		} else {
			return null;
		}
	}

	public String getMchID()  {
		if (_merchantInformation != null && _merchantInformation.length > 0) {
			return _merchantInformation[0].getId_mch();
		} else {
			return null;
		}
	}

	public String getKey() {
		if (_merchantInformation != null && _merchantInformation.length > 0) {
			return _merchantInformation[0].getKey();
		} else {
			return null;
		}
	}

	public InputStream getCertStream(){
		if (_merchantInformation != null && _merchantInformation.length > 0) {
			ByteArrayInputStream certBis;
			certBis = new ByteArrayInputStream(_merchantInformation[0].getCert());
			return certBis;
		} else {
			return null;
		}
	}

	public int getHttpConnectTimeoutMs() {
		return 2000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}

	public IWXPayDomain getWXPayDomain() {
		return WXPayDomainSimpleImpl.instance();
	}

	public String getPrimaryDomain() {
		return "api.mch.weixin.qq.com";
	}

	public String getAlternateDomain() {
		return "api2.mch.weixin.qq.com";
	}

	@Override
	public int getReportWorkerNum() {
		return 1;
	}

	public int getReportBatchSize() {
		return 2;
	}

	public String getProxyIp() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP);
	}

	public Integer getProxyPort() throws BizException {
		String portstr = ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYPORT);
		return portstr == null ? null : Integer.parseInt(portstr);
	}

}
