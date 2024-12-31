package com.alipay.demo.trade.service.impl;

import org.apache.commons.lang.StringUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.MonitorHeartbeatSynRequest;
import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayHeartbeatSynRequestBuilder;
import com.alipay.demo.trade.service.AlipayMonitorService;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * Created by liuyangkly on 15/10/22.
 */
public class AlipayMonitorServiceImpl extends AbsAlipayService implements AlipayMonitorService {
	private AlipayClient client;

	public static class ClientBuilder {
		private String gatewayUrl;
		private String appid;
		private String privateKey;
		private String format;
		private String charset;
		private String alipayPublicKey;
		private String signType;

		public AlipayMonitorServiceImpl build() throws NumberFormatException, BizException {
			if (StringUtils.isEmpty(gatewayUrl)) {
				gatewayUrl = Configs.getOpenApiDomain(); // 与mcloudmonitor网关地址不同
			}
			if (StringUtils.isEmpty(appid)) {
				appid = Configs.getAppid();
			}
			if (StringUtils.isEmpty(privateKey)) {
				privateKey = Configs.getPrivateKey();
			}
			if (StringUtils.isEmpty(format)) {
				format = "json";
			}
			if (StringUtils.isEmpty(charset)) {
				charset = "utf-8";
			}
			if (StringUtils.isEmpty(alipayPublicKey)) {
				alipayPublicKey = Configs.getAlipayPublicKey();
			}
			if (StringUtils.isEmpty(signType)) {
				signType = Configs.getSignType();
			}

			return new AlipayMonitorServiceImpl(this);
		}

		public ClientBuilder setAlipayPublicKey(String alipayPublicKey) {
			this.alipayPublicKey = alipayPublicKey;
			return this;
		}

		public ClientBuilder setAppid(String appid) {
			this.appid = appid;
			return this;
		}

		public ClientBuilder setCharset(String charset) {
			this.charset = charset;
			return this;
		}

		public ClientBuilder setFormat(String format) {
			this.format = format;
			return this;
		}

		public ClientBuilder setGatewayUrl(String gatewayUrl) {
			this.gatewayUrl = gatewayUrl;
			return this;
		}

		public ClientBuilder setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
			return this;
		}

		public ClientBuilder setSignType(String signType) {
			this.signType = signType;
			return this;
		}

		public String getAlipayPublicKey() {
			return alipayPublicKey;
		}

		public String getSignType() {
			return signType;
		}

		public String getAppid() {
			return appid;
		}

		public String getCharset() {
			return charset;
		}

		public String getFormat() {
			return format;
		}

		public String getGatewayUrl() {
			return gatewayUrl;
		}

		public String getPrivateKey() {
			return privateKey;
		}
	}

	public AlipayMonitorServiceImpl(ClientBuilder builder) throws NumberFormatException, BizException {
		if (StringUtils.isEmpty(builder.getGatewayUrl())) {
			throw new NullPointerException("gatewayUrl should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getAppid())) {
			throw new NullPointerException("appid should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getPrivateKey())) {
			throw new NullPointerException("privateKey should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getFormat())) {
			throw new NullPointerException("format should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getCharset())) {
			throw new NullPointerException("charset should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getAlipayPublicKey())) {
			throw new NullPointerException("alipayPublicKey should not be NULL!");
		}
		if (StringUtils.isEmpty(builder.getSignType())) {
			throw new NullPointerException("signType should not be NULL!");
		}
		PmpPayAppBaseUtils utils = new PmpPayAppBaseUtils();

		if (ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP) != null
				&& ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),
						PmpPayBaseCost.PMP_PROXYPORT) != null) {
			client = new DefaultAlipayClient(builder.getGatewayUrl(), builder.getAppid(), builder.getPrivateKey(),
					builder.getFormat(), builder.getCharset(), builder.getAlipayPublicKey(), builder.getSignType(),
					ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYIP),
					Integer.valueOf(Integer.parseInt(ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),
							PmpPayBaseCost.PMP_PROXYPORT))));
		} else {
			client = new DefaultAlipayClient(builder.getGatewayUrl(), builder.getAppid(), builder.getPrivateKey(),
					builder.getFormat(), builder.getCharset(), builder.getAlipayPublicKey(), builder.getSignType());
		}

	}

	@Override
	public MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder)
			throws AlipayApiException {
		validateBuilder(builder);

		MonitorHeartbeatSynRequest request = new MonitorHeartbeatSynRequest();
		request.putOtherTextParam("app_auth_token", builder.getAppAuthToken());
		request.setBizContent(builder.toJsonString());
		log.info("heartbeat.sync bizContent:" + request.getBizContent());

		return (MonitorHeartbeatSynResponse) getResponse(client, request);
	}
}
