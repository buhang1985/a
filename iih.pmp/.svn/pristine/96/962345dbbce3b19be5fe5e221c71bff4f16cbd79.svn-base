package wxpay.sdk;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;

import wxpay.sdk.httpclient.HttpClientHelper;
import wxpay.sdk.httpclient.HttpClientWithCAHelp;
import xap.mw.core.data.BizException;

/**
 * 微信请求
 * 
 * @author li_cheng
 *
 */
public class WXPayRequest {
	private WXPayConfig config;

	public WXPayRequest(WXPayConfig config) throws Exception {
		this.config = config;
	}

	/**
	 * 请求，只请求一次，不做重试
	 * 
	 * @param domain
	 * @param urlSuffix
	 * @param uuid
	 * @param data
	 * @param connectTimeoutMs
	 * @param readTimeoutMs
	 * @param useCert          是否使用证书，针对退款、撤销等操作
	 * @return
	 * @throws Exception
	 */
	private String requestOnce(final String domain, String urlSuffix, String uuid, String data, int connectTimeoutMs,
			int readTimeoutMs, boolean useCert) throws Exception {
		String url = "https://" + domain + urlSuffix;
		StringEntity postEntity = new StringEntity(data, "UTF-8");
		if (useCert) {

			return this.withCARequest(url, postEntity);
		} else {
			return this.withoutCARequest(url, postEntity);
		}

	}

	private String withCARequest(String url, StringEntity postEntity) throws BizException, Exception {

		return HttpClientWithCAHelp.getInstance().doPost(url, postEntity);
	}

	private String withoutCARequest(String url, StringEntity postEntity) throws BizException, Exception {

		return HttpClientHelper.getInstance().doPost(url, postEntity);
	}

	private String request(String urlSuffix, String uuid, String data, int connectTimeoutMs, int readTimeoutMs,
			boolean useCert, boolean autoReport) throws Exception {
		Exception exception = null;
		long elapsedTimeMillis = 0;
		long startTimestampMs = WXPayUtil.getCurrentTimestampMs();
		boolean firstHasDnsErr = false;
		boolean firstHasConnectTimeout = false;
		boolean firstHasReadTimeout = false;
		IWXPayDomain.DomainInfo domainInfo = config.getWXPayDomain().getDomain(config);
		if (domainInfo == null) {
			throw new Exception("WXPayConfig.getWXPayDomain().getDomain() is empty or null");
		}
		try {
			// 退款报文
			String result = requestOnce(domainInfo.domain, urlSuffix, uuid, data, connectTimeoutMs, readTimeoutMs,
					useCert);
			elapsedTimeMillis = WXPayUtil.getCurrentTimestampMs() - startTimestampMs;
			config.getWXPayDomain().report(domainInfo.domain, elapsedTimeMillis, null);
			WXPayReport.getInstance(config).report(uuid, elapsedTimeMillis, domainInfo.domain, domainInfo.primaryDomain,
					connectTimeoutMs, readTimeoutMs, firstHasDnsErr, firstHasConnectTimeout, firstHasReadTimeout);
			return result;
		} catch (UnknownHostException ex) {
			exception = ex;
			firstHasDnsErr = true;
			elapsedTimeMillis = WXPayUtil.getCurrentTimestampMs() - startTimestampMs;
//             WXPayUtil.getLogger().warn("UnknownHostException for domainInfo {}", domainInfo);
			WXPayReport.getInstance(config).report(uuid, elapsedTimeMillis, domainInfo.domain, domainInfo.primaryDomain,
					connectTimeoutMs, readTimeoutMs, firstHasDnsErr, firstHasConnectTimeout, firstHasReadTimeout);
			throw exception;
		} catch (ConnectTimeoutException ex) {
			exception = ex;
			firstHasConnectTimeout = true;
			elapsedTimeMillis = WXPayUtil.getCurrentTimestampMs() - startTimestampMs;
//             WXPayUtil.getLogger().warn("connect timeout happened for domainInfo {}", domainInfo);
			WXPayReport.getInstance(config).report(uuid, elapsedTimeMillis, domainInfo.domain, domainInfo.primaryDomain,
					connectTimeoutMs, readTimeoutMs, firstHasDnsErr, firstHasConnectTimeout, firstHasReadTimeout);
			throw exception;
		} catch (SocketTimeoutException ex) {
			exception = ex;
			firstHasReadTimeout = true;
			elapsedTimeMillis = WXPayUtil.getCurrentTimestampMs() - startTimestampMs;
//             WXPayUtil.getLogger().warn("timeout happened for domainInfo {}", domainInfo);
			WXPayReport.getInstance(config).report(uuid, elapsedTimeMillis, domainInfo.domain, domainInfo.primaryDomain,
					connectTimeoutMs, readTimeoutMs, firstHasDnsErr, firstHasConnectTimeout, firstHasReadTimeout);
			throw exception;
		} catch (Exception ex) {
			exception = ex;
			elapsedTimeMillis = WXPayUtil.getCurrentTimestampMs() - startTimestampMs;
			WXPayReport.getInstance(config).report(uuid, elapsedTimeMillis, domainInfo.domain, domainInfo.primaryDomain,
					connectTimeoutMs, readTimeoutMs, firstHasDnsErr, firstHasConnectTimeout, firstHasReadTimeout);
			throw exception;
		}
//		config.getWXPayDomain().report(domainInfo.domain, elapsedTimeMillis, exception);
//		throw exception;

	}

	/**
	 * 可重试的，非双向认证的请求
	 * 
	 * @param urlSuffix
	 * @param uuid
	 * @param data
	 * @param autoReport
	 * @return
	 * @throws Exception
	 */
	public String requestWithoutCert(String urlSuffix, String uuid, String data, boolean autoReport) throws Exception {
		return this.request(urlSuffix, uuid, data, config.getHttpConnectTimeoutMs(), config.getHttpReadTimeoutMs(),
				false, autoReport);
	}

	public String requestWithoutCert(String urlSuffix, String uuid, String data, int connectTimeoutMs,
			int readTimeoutMs, boolean autoReport) throws Exception {
		return this.request(urlSuffix, uuid, data, connectTimeoutMs, readTimeoutMs, false, autoReport);

		/*
		 * String result; Exception exception; boolean shouldRetry = false;
		 * 
		 * boolean useCert = true; try { result = requestOnce(domain, urlSuffix, uuid,
		 * data, connectTimeoutMs, readTimeoutMs, useCert); return result; } catch
		 * (ConnectTimeoutException ex) { exception = ex;
		 * WXPayUtil.getLogger().warn(String.
		 * format("connect timeout happened for domain {}, try to use {}", domain,
		 * this.primaryDomain)); shouldRetry = true; } catch (SocketTimeoutException ex)
		 * { exception = ex; shouldRetry = false; } catch (Exception ex) { exception =
		 * ex; shouldRetry = false; }
		 * 
		 * if (shouldRetry && this.primaryDomain != null) { result =
		 * requestOnce(this.primaryDomain, urlSuffix, uuid, data, connectTimeoutMs,
		 * readTimeoutMs, useCert, autoReport); return result; } else { throw exception;
		 * }
		 */
	}

	/**
	 * 可重试的，双向认证的请求
	 * 
	 * @param urlSuffix
	 * @param uuid
	 * @param data
	 * @param autoReport
	 * @return
	 * @throws Exception
	 */
	public String requestWithCert(String urlSuffix, String uuid, String data, boolean autoReport) throws Exception {
		return this.request(urlSuffix, uuid, data, config.getHttpConnectTimeoutMs(), config.getHttpReadTimeoutMs(),
				true, autoReport);
	}

	public String requestWithCert(String urlSuffix, String uuid, String data, int connectTimeoutMs, int readTimeoutMs,
			boolean autoReport) throws Exception {
		return this.request(urlSuffix, uuid, data, connectTimeoutMs, readTimeoutMs, true, autoReport);
		/*
		 * String result; Exception exception; boolean shouldRetry = false;
		 * 
		 * boolean useCert = true; try { result = requestOnce(domain, urlSuffix, uuid,
		 * data, connectTimeoutMs, readTimeoutMs, useCert); return result; } catch
		 * (ConnectTimeoutException ex) { exception = ex;
		 * WXPayUtil.getLogger().warn(String.
		 * format("connect timeout happened for domain {}, try to use {}", domain,
		 * this.primaryDomain)); shouldRetry = true; } catch (SocketTimeoutException ex)
		 * { exception = ex; shouldRetry = false; } catch (Exception ex) { exception =
		 * ex; shouldRetry = false; }
		 * 
		 * if (shouldRetry && this.primaryDomain != null) { result =
		 * requestOnce(this.primaryDomain, urlSuffix, uuid, data, connectTimeoutMs,
		 * readTimeoutMs, useCert, autoReport); return result; } else { throw exception;
		 * }
		 */

	}
}
