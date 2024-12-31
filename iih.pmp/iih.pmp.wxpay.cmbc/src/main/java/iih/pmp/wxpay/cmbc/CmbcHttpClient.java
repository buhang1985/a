package iih.pmp.wxpay.cmbc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;

public class CmbcHttpClient {
		private  final Logger log = LoggerFactory.getLogger(CmbcHttpClient.class);
		private  PoolingHttpClientConnectionManager poolConnManager = null;
		private int maxTotalPool = 200;
		private int maxConPerRoute = 20;
		private int socketTimeout = 10000;
		private int connectionRequestTimeout = 2000;
		private int connectTimeout = 10000;
		private  PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();

		// 代理信息
//		public  String proxyIp = "172.18.98.191";
//		public  int proxyPort = 3128;

		private   CmbcHttpClient httpClientHelper = null;

		public CmbcHttpClient() {
			init();
		}

		private   synchronized void syncInit() {
			if (httpClientHelper == null) {
				httpClientHelper = new CmbcHttpClient();
			}
		}

		public   CmbcHttpClient getInstance() {
			if (httpClientHelper == null) {
				syncInit();
			}
			return httpClientHelper;
		}

//		public PoolingHttpClientConnectionManager getConnManager() {
//			PoolingHttpClientConnectionManager cm = null;
//			try {
//				SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
//				HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
//				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
//				Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
//						.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
//				cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//				// 将最大连接数增加�?200
//				cm.setMaxTotal(maxTotalPool);
//				// 将每个路由基�?的连接增加到20
//				cm.setDefaultMaxPerRoute(maxConPerRoute);
//			} catch (Exception e) {
//				log.error("InterfacePhpUtilManager init Exception" + e.toString());
//			}
//			return cm;
//		}

		public void init() {
			try {
				SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
				HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
				Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
						.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslsf).build();
				poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
				// Increase max total connection to 200
				poolConnManager.setMaxTotal(maxTotalPool);
				// Increase default max connection per route to 20
				poolConnManager.setDefaultMaxPerRoute(maxConPerRoute);
				SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(socketTimeout).build();
				poolConnManager.setDefaultSocketConfig(socketConfig);
			} catch (Exception e) {
				log.error("InterfacePhpUtilManager init Exception" + e.toString());
			}
		}

		public CloseableHttpClient getConnection() throws BizException {
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
					.setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
			HttpClientBuilder httpClientBuilder = HttpClients.custom();
			httpClientBuilder.setConnectionManager(poolConnManager).setDefaultRequestConfig(requestConfig);// set

			//从轻量级获取参数
			String proxyIp=Config.getProxyIp();
			int proxyPort=Config.getProxyPort();
			
			// proxy
			if (!utils.isStrEmpty(proxyIp)) {
				org.apache.http.HttpHost proxy = new org.apache.http.HttpHost(proxyIp, Integer.valueOf(proxyPort));
				DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
				httpClientBuilder.setRoutePlanner(routePlanner);
			}

			CloseableHttpClient httpClient = httpClientBuilder.build();
			if (poolConnManager != null && poolConnManager.getTotalStats() != null) {
				log.info("now client pool " + poolConnManager.getTotalStats().toString());
			}
			return httpClient;
		}

		/**
		 * 发�?? GET 请求（HTTP），不带输入数据
		 * 
		 * @param url
		 * @return
		 * @throws BizException 
		 */
		public String doGet(String url) throws BizException {
			return doGet(url, new HashMap<String, String>());
		}

		/**
		 * 发�?? GET 请求（HTTP），K-V形式
		 * 
		 * @param url
		 * @param params
		 * @return
		 * @throws BizException 
		 */
		public String doGet(String url, Map<String, String> params) throws BizException {
			String apiUrl = url;
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : params.keySet()) {
				if (i == 0) {
					param.append("?");
				} else {
					param.append("&");
				}
				param.append(key).append("=").append(params.get(key));
				i++;
			}
			apiUrl += param;
			log.info(apiUrl);
			String result = null;
			CloseableHttpClient httpClient = getConnection();
			CloseableHttpResponse response = null;
			HttpGet httpPost = null;
			try {
				httpPost = new HttpGet(apiUrl);
				response = httpClient.execute(httpPost);
				int status = response.getStatusLine().getStatusCode();
				log.info("http request url : " + url + " status : " + status);

				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(response.getEntity(), "UTF-8");
						log.info("Request result : " + result);
					}
				}
				EntityUtils.consume(response.getEntity());
				response.close();
				return result;

			} catch (IOException e) {
				log.error(e.getMessage(), e);
			} finally {
				httpPost.releaseConnection();
				if (response != null) {
					try {
						EntityUtils.consume(response.getEntity());
						response.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
			return result;
		}

//		public String doPost(String url) {
//			return doPost(url, new HashMap<String, String>());
//		}

		/**
		 * 发�?? POST 请求（HTTP），K-V形式
		 * 
		 * @param url
		 *            接口URL
		 * @param params
		 *            参数map
		 * @return
		 * @throws BizException 
		 */
		public String doPost(String url, StringEntity params) throws BizException {
			String result = null;
			HttpPost httpPost = new HttpPost(url);
			CloseableHttpClient httpClient = getConnection();
			CloseableHttpResponse response = null;
			try {
//				List<NameValuePair> pairList = new ArrayList<>(params.size());
//				for (Map.Entry<String, String> entry : params.entrySet()) {
//					NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
//					pairList.add(pair);
//				}
				 httpPost.addHeader("Content-Type", "application/json");
//				 httpPost.addHeader("Connection", "Keep-Alive");
//				 httpPost.addHeader("Content-Length", "" + params.getContentLength());
		    	 httpPost.addHeader("User-Agent", "cmbc sdk java v1.0 " + "1503847221");// TODO: 很重要，用来�?�? sdk 的使用情况，要不要加上商户信息？
				httpPost.setEntity(params);
				response = httpClient.execute(httpPost);
				int status = response.getStatusLine().getStatusCode();
				log.info("http request url : " + url + " status : " + status);
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(response.getEntity(), "UTF-8");
						log.info("Request result : " + result);
					}
				}
				EntityUtils.consume(response.getEntity());
				response.close();
//				poolConnManager.close();
				return result;

			} catch (IOException e) {
				System.out.println("异常信息"+e.getMessage());
				log.error(e.getMessage(), e);
			} finally {
				httpPost.releaseConnection();
				if (response != null) {
					try {
						EntityUtils.consume(response.getEntity());
						response.close();
						
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
				if(poolConnManager!=null) {
					poolConnManager.close();
				}
			}
			return result;
		}
		
		public  void main(String args[]){
//			HttpClientHelper.getInstance().doPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
		}
	
}
