package iih.ei.bl.ecinc.bosssoft.v2.s.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import iih.bd.base.utils.StringCodingUtils;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 博思平台http调用类
 * @author ly
 *
 */
public class BossSoftHttpClient {

	private String methodName = "";
	private String method;
	
	public BossSoftHttpClient(String method, String methodName){
		this.method = method;
		this.methodName = methodName;
	}
	
	/**
	 * http调用
	 * @param method 方法名
	 * @param data json数据
	 * @return
	 * @throws BizException
	 */
	public ReturnParam invoke(String data) throws BizException{
		
		String[] params = EcIncDataUtil.getEnIncCallParams();
		String url = params[0];//平台url
		String appId = params[1];//应用账号
		String appKey = params[2];//秘钥
		String wholeUrl = String.format("%s/api/medical/%s", url, this.method);//完整url
		String noise = EcIncDataUtil.getUuid();
		
		EIThirdLogger.info(String.format("电子发票%s请求数据:", this.methodName) + data);
		
		//数据加密
		String base64Data = StringCodingUtils.Utf8_Base64_Encode(data);
		//获取签名
		String sign = this.getSign(appId, appKey, noise, base64Data);
		
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("appid", appId);
		dataMap.put("data", base64Data);
		dataMap.put("noise", noise);
		dataMap.put("sign", sign);
		dataMap.put("version", IEcIncBossSoftConst.VERSION);

		EIThirdLogger.info(String.format("电子发票%s最终请求数据:", this.methodName) + dataMap.toString());
		
		ReturnParam rtnParam = new ReturnParam();
		String rlt = "";
		
		long begintime = System.currentTimeMillis();
		try {
			EIThirdLogger.info(String.format("电子发票%s请求开始:", this.methodName));
			rlt = this.httpInvoke(wholeUrl, dataMap);
			long cost = System.currentTimeMillis() - begintime;
			EIThirdLogger.info(String.format("电子发票%s请求结束:", this.methodName) + " 耗时-->" + cost);
			if(StringUtil.isEmpty(rlt)){
				rtnParam.setFgSuccess(false);
				rtnParam.setErrorMsg("未知错误无返回值");
				rtnParam.setInputStr(data);
				rtnParam.setOutputStr("未知错误无返回值");
				return rtnParam;
			}
			@SuppressWarnings("rawtypes")
			Map rltMap = new ObjectMapper().readValue(rlt, Map.class);
			String rltCode = rltMap.get("result").toString();
			String message = rltMap.get("message").toString();
			message = StringCodingUtils.Utf8_Base64_Decode(message);
			
			EIThirdLogger.info(String.format("电子发票%s返回解析数据:", this.methodName) 
					+ String.format("代码:%s,数据%s", rltCode, message));
			if(IEcIncBossSoftConst.SUCCESS_CODE.equals(rltCode)){
				rtnParam.setFgSuccess(true);
				rtnParam.setData(message);
				rtnParam.setInputStr(data);
				rtnParam.setOutputStr(message);
			}else{
				rtnParam.setFgSuccess(false);
				rtnParam.setErrorMsg(message);
				rtnParam.setInputStr(data);
				rtnParam.setOutputStr(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtnParam.setFgSuccess(false);
			rtnParam.setErrorMsg(e.getMessage());
			rtnParam.setInputStr(data);
			rtnParam.setOutputStr(e.getMessage());
			
			long cost = System.currentTimeMillis() - begintime;
			EIThirdLogger.info(String.format("电子发票%s请求结束:", this.methodName) + " 耗时-->" + cost);
		}
		
		return rtnParam;
	}
	
	/**
	 * 获取签名
	 * @param appId
	 * @param appKey
	 * @param noise
	 * @param base64Data
	 * @return
	 */
	private String getSign(String appId,String appKey,String noise,String base64Data){
		StringBuilder str = new StringBuilder();
		str.append("appid=").append(appId);
		str.append("&data=").append(base64Data);
		str.append("&noise=").append(noise);
		str.append("&key=").append(appKey);
		str.append("&version=").append(IEcIncBossSoftConst.VERSION);
		
		String sign = DigestUtils.md5Hex(str.toString().getBytes(Charset.forName("UTF-8"))).toUpperCase();
		return sign;
	}

	/**
	 * http调用
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@SuppressWarnings("rawtypes")
	private String httpInvoke(String url, Map<String, String> map) throws Exception{
		
		HttpPost httpPost = new HttpPost(url);
		// 超时时间30秒
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30*1000).setConnectTimeout(30*1000).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpClient client = HttpClients.createDefault();
		StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(map), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		HttpResponse resp = client.execute(httpPost);
		if (resp.getStatusLine().getStatusCode() == 200) {
			
			String rev = EntityUtils.toString(resp.getEntity());
			EIThirdLogger.info(String.format("电子发票%s返回数据:", this.methodName) + rev);
			Map result = new ObjectMapper().readValue(rev, Map.class);
			String rdata = result.get("data").toString();
			String busData = StringCodingUtils.Utf8_Base64_Decode(rdata);
			return busData;
		}
		throw new Exception("远程调用异常:" + resp.getStatusLine().getStatusCode());
	}
}
