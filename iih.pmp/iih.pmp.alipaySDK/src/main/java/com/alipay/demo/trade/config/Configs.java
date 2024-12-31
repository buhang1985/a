package com.alipay.demo.trade.config;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.merchantinformation.d.MerchantInformationDO;
import iih.pmp.pay.merchantinformation.i.IMerchantinformationCudService;
import iih.pmp.pay.merchantinformation.i.IMerchantinformationRService;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * Created by liuyangkly on 15/6/27.
 */
public class Configs {
	private static Log log = LogFactory.getLog(Configs.class);
	private static Configuration configs;
	private static IMerchantinformationRService _imerchantinformationRService = ServiceFinder
			.find(IMerchantinformationRService.class);
	private static MerchantInformationDO[] _merchantInformation;

	private static String openApiDomain; // 支付宝openapi域名
	private static String mcloudApiDomain; // 支付宝mcloudmonitor域名
	private static String pid; // 商户partner id
	private static String appid; // 商户应用id

	private static String privateKey; // RSA私钥，用于对商户请求报文加签
	private static String publicKey; // RSA公钥，仅用于验证开发者网关
	private static String alipayPublicKey; // 支付宝RSA公钥，用于验签支付宝应答
	private static String signType; // 签名类型

	private static int maxQueryRetry; // 最大查询次数
	private static long queryDuration; // 查询间隔（毫秒）

	private static int maxCancelRetry; // 最大撤销次数
	private static long cancelDuration; // 撤销间隔（毫秒）

	private static long heartbeatDelay; // 交易保障线程第一次调度延迟（秒）
	private static long heartbeatDuration; // 交易保障线程调度间隔（秒）

	private static String proxyIp; // 代理IP地址
	private static String proxyPort; // 代理端口号

	private static String NotifyUrl; // 扫码付回调地址

	private static PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();// 工具类

	private Configs() {
		// No Constructor
	}

	// 根据文件名读取配置文件，文件后缀名必须为.properties
	public synchronized static void init(String filePath) {

		try {
			_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
					FBoolean.FALSE);
		} catch (BizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (_merchantInformation == null && _merchantInformation.length < 1) {
			throw new IllegalStateException("未找到启用的商家配置!");
		}

		openApiDomain = "https://openapi.alipay.com/gateway.do";
		mcloudApiDomain = "http://mcloudmonitor.com/gateway.do";

		pid = _merchantInformation[0].getPid();
		appid = _merchantInformation[0].getId_app();

		// RSA
		privateKey = new String(_merchantInformation[0].getPrivate_key().toString());
		publicKey = new String(_merchantInformation[0].getPublic_key());
		alipayPublicKey = new String(_merchantInformation[0].getPublic_key());
		// signType= configs.getString("sign_type");
		if (_merchantInformation[0].getSigntype().equals("1")) {
			signType = "RSA";
		} else {
			signType = "RSA2";
		}

		// 查询参数
		maxQueryRetry = 5;
		queryDuration = 5000;
		maxCancelRetry = 3;
		cancelDuration = 2000;

		// 交易保障调度线程
		heartbeatDelay = 5;
		heartbeatDuration = 900;

		 proxyIp = configs.getString("proxyIp");
		 proxyPort = configs.getString("proxyPort");

		NotifyUrl = _merchantInformation[0].getNotify_url();

		log.info("配置文件名: " + filePath);
		log.info(description());
	}

	public static String description() {
		StringBuilder sb = new StringBuilder("Configs{");
		sb.append("支付宝openapi网关: ").append(openApiDomain).append("\n");
		if (StringUtils.isNotEmpty(mcloudApiDomain)) {
			sb.append(", 支付宝mcloudapi网关域名: ").append(mcloudApiDomain).append("\n");
		}

		if (StringUtils.isNotEmpty(pid)) {
			sb.append(", pid: ").append(pid).append("\n");
		}
		sb.append(", appid: ").append(appid).append("\n");

		sb.append(", 商户RSA私钥: ").append(getKeyDescription(privateKey)).append("\n");
		sb.append(", 商户RSA公钥: ").append(getKeyDescription(publicKey)).append("\n");
		sb.append(", 支付宝RSA公钥: ").append(getKeyDescription(alipayPublicKey)).append("\n");
		sb.append(", 签名类型: ").append(signType).append("\n");

		sb.append(", 查询重试次数: ").append(maxQueryRetry).append("\n");
		sb.append(", 查询间隔(毫秒): ").append(queryDuration).append("\n");
		sb.append(", 撤销尝试次数: ").append(maxCancelRetry).append("\n");
		sb.append(", 撤销重试间隔(毫秒): ").append(cancelDuration).append("\n");

		sb.append(", 交易保障调度延迟(秒): ").append(heartbeatDelay).append("\n");
		sb.append(", 交易保障调度间隔(秒): ").append(heartbeatDuration).append("\n");

		sb.append(", 代理IP地址: ").append(proxyIp).append("\n");
		sb.append(", 代理端口号: ").append(proxyPort).append("\n");

		sb.append(", 扫码付回调地址: ").append(NotifyUrl).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private static String getKeyDescription(String key) {
		int showLength = 6;
		if (StringUtils.isNotEmpty(key) && key.length() > showLength) {
			return new StringBuilder(key.substring(0, showLength)).append("******")
					.append(key.substring(key.length() - showLength)).toString();
		}
		return null;
	}

	public static Configuration getConfigs() {
		return configs;
	}

	public static String getOpenApiDomain() {
		openApiDomain = "https://openapi.alipay.com/gateway.do";

		return openApiDomain;
	}

	public static String getMcloudApiDomain() {
		mcloudApiDomain = "http://mcloudmonitor.com/gateway.do";

		return mcloudApiDomain;
	}

	public static void setMcloudApiDomain(String mcloudApiDomain) {
		Configs.mcloudApiDomain = mcloudApiDomain;
	}

	public static String getPid() {
		if (_merchantInformation ==null) {
			try {
				_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
						FBoolean.FALSE);
			} catch (BizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (_merchantInformation == null && _merchantInformation.length < 1) {
				throw new IllegalStateException("未找到启用的商家配置!");
			}
			pid = _merchantInformation[0].getPid();
		}

		return pid;
	}

	public static String getAppid() {
		if (_merchantInformation == null) {
			try {
				_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
						FBoolean.FALSE);
			} catch (BizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (_merchantInformation == null && _merchantInformation.length < 1) {
				throw new IllegalStateException("未找到启用的商家配置!");
			}
			appid = _merchantInformation[0].getId_app();
		}

		return appid;
	}

	public static String getPrivateKey() {

		if (_merchantInformation == null) {
			try {
				_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
						FBoolean.FALSE);
			} catch (BizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (_merchantInformation == null && _merchantInformation.length < 1) {
				throw new IllegalStateException("未找到启用的商家配置!");
			}

			privateKey = new String(_merchantInformation[0].getPrivate_key());
			// RSA
		}

		return new String(_merchantInformation[0].getPrivate_key());
	}

	public static String getPublicKey() {
		return null;
	}

	public static String getAlipayPublicKey() {
		if (_merchantInformation == null) {
			try {
				_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
						FBoolean.FALSE);
			} catch (BizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (_merchantInformation == null && _merchantInformation.length < 1) {
				throw new IllegalStateException("未找到启用的商家配置!");
			}
			publicKey = new String(_merchantInformation[0].getPublic_key());
		}

		return new String(_merchantInformation[0].getPublic_key());
	}

	public static String getSignType() {
		try {
			_merchantInformation = _imerchantinformationRService.find("PAYCHANNELS = '2' and FG_ACTIVE = 'Y'", "",
					FBoolean.FALSE);
		} catch (BizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (_merchantInformation == null && _merchantInformation.length < 1) {
			throw new IllegalStateException("未找到启用的商家配置!");
		}
		alipayPublicKey = new String(_merchantInformation[0].getPublic_key());
		// signType= configs.getString("sign_type");
		if (_merchantInformation[0].getSigntype().equals("1")) {
			return  "RSA";
		} else {
			return  "RSA2";
		}

	}

	public static int getMaxQueryRetry() {

		// 查询参数
		maxQueryRetry = 5;

		return maxQueryRetry;
	}

	public static long getQueryDuration() {
		queryDuration = 5000;

		return queryDuration;
	}

	public static int getMaxCancelRetry() {
		maxCancelRetry = 3;

		return maxCancelRetry;
	}

	public static long getCancelDuration() {
		cancelDuration = 2000;

		return cancelDuration;
	}

	public static String getProxyIp() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP);
	}

	public static String getProxyPort() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYPORT);
	}

	public static String getNotifyUrl() {
		return NotifyUrl;
	}

	public static void setConfigs(Configuration configs) {
		Configs.configs = configs;
	}

	public static void setOpenApiDomain(String openApiDomain) {
		Configs.openApiDomain = openApiDomain;
	}

	public static void setPid(String pid) {
		Configs.pid = pid;
	}

	public static void setAppid(String appid) {
		Configs.appid = appid;
	}

	public static void setPrivateKey(String privateKey) {
		Configs.privateKey = privateKey;
	}

	public static void setPublicKey(String publicKey) {
		Configs.publicKey = publicKey;
	}

	public static void setAlipayPublicKey(String alipayPublicKey) {
		Configs.alipayPublicKey = alipayPublicKey;
	}

	public static void setSignType(String signType) {
		Configs.signType = signType;
	}

	public static void setMaxQueryRetry(int maxQueryRetry) {
		Configs.maxQueryRetry = maxQueryRetry;
	}

	public static void setQueryDuration(long queryDuration) {
		Configs.queryDuration = queryDuration;
	}

	public static void setMaxCancelRetry(int maxCancelRetry) {
		Configs.maxCancelRetry = maxCancelRetry;
	}

	public static void setCancelDuration(long cancelDuration) {
		Configs.cancelDuration = cancelDuration;
	}

	public static long getHeartbeatDelay() {

		// 交易保障调度线程
		heartbeatDelay = 5;

		return heartbeatDelay;
	}

	public static void setHeartbeatDelay(long heartbeatDelay) {
		Configs.heartbeatDelay = heartbeatDelay;
	}

	public static long getHeartbeatDuration() {
		heartbeatDuration = 900;

		return heartbeatDuration;
	}

	public static void setHeartbeatDuration(long heartbeatDuration) {
		Configs.heartbeatDuration = heartbeatDuration;
	}

	public static void setProxyIp(String proxyIp) {
		Configs.proxyIp = proxyIp;
	}

	public static void setProxyPort(String proxyPort) {
		Configs.proxyPort = proxyPort;
	}

	public static void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}
}
