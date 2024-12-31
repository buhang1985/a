package iih.pmp.wxpay.cmbc;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import xap.mw.core.data.BizException;

public class CmbcClient_new {
	
	public String doPost(String url, StringEntity params) throws BizException {
		String result = null;
		CloseableHttpClient httpclient=HttpClients.createDefault();
		//创建httppost实例 
		HttpPost httpPost=new HttpPost(url);
		//从轻量级获取参数
		String proxyIp=Config.getProxyIp();
		int proxyPort=Config.getProxyPort();	
		RequestConfig requestConfig=null;
		if(proxyIp!=null&&proxyIp.trim().length()>0) {
			HttpHost proxy=new HttpHost(proxyIp,proxyPort);
		    requestConfig=RequestConfig.custom().setProxy(proxy).setConnectTimeout(20000).setSocketTimeout(20000).setConnectionRequestTimeout(20000).build();
		}else {
			requestConfig=RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(20000).setConnectionRequestTimeout(20000).build();
		}
//		RequestConfig requestConfig=RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(20000).setConnectionRequestTimeout(20000).build();
		httpPost.setConfig(requestConfig);		
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("User-Agent", "cmbc sdk java v1.0 " + "1503847221");// TODO: 很重要，用来�?�? sdk 的使用情况，要不要加上商户信息？
		httpPost.setEntity(params);
		try {
			CloseableHttpResponse response=httpclient.execute(httpPost);
			if(response!=null) {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(response.getEntity(), "UTF-8");
					}
				}
				EntityUtils.consume(response.getEntity());
				response.close();
				return result;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new BizException(e.getMessage());
			}
		}
     return result;
	}

}
