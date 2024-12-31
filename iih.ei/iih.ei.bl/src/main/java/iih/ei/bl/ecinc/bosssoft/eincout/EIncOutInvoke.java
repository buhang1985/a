package iih.ei.bl.ecinc.bosssoft.eincout;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSON;

import iih.bd.base.utils.StringCodingUtils;
import iih.bl.inc.dto.eincoutparamdto.d.BlEIncOutParam;
import iih.bl.inc.dto.eincoutresultdto.d.BlEIncOutMessageResult;
import iih.bl.inc.dto.eincoutresultdto.d.BlEIncOutResult;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;

/**
 * 电子票据开具接口
 * 
 * @author shaokx 2019.12.14
 *
 */
public class EIncOutInvoke {

	private String oriData = "";
	
	public BlEIncOutResult exec(BlEIncOutParam param) throws BizException, UnsupportedEncodingException {

		if(param == null){
			throw new BizException("入参为空");
		}
		
		//String url = "http://172.18.150.87:8081/medical-web/api/medical/invoiceEBillOutpatient";//http://<ip>:<port>/<service>/api/medical/接口服务标识,这里ip随便写一个
		// 应用账号
		//String appID = "WZDCSDW7532610";// 调用方应用帐号，由平台提供,这里随便写一个
		// 密钥 签名私钥key
		//String appKey = "b00d5e1a028e9395b9231a23cc";// 由平台提供，这里随便写一个
		
		String[] params = EcIncDataUtil.getEnIncCallParams();
		String url = params[0];
		String appID = params[1];
		String appKey = params[2];
		//if(StringUtil.isEmpty(url)){
		//	throw new BizException("参数调入地址未定义");
		//}
		//if(StringUtil.isEmpty(appID)){
		//	throw new BizException("参数应用账号未定义");
		//}
		//if(StringUtil.isEmpty(appKey)){
		//	throw new BizException("参数密钥 签名私钥未定义");
		//}
		
		url += "/api/medical/invoiceEBillOutpatient";
		// 版本号
		String version = "1.0"; // 固定1.0
		// 唯一值 请求随机标识
		String noise = getUuid();// 每次请求返回一个唯一编号，全局唯一（建议采用UUID）
		// 接口对应原始参数
		String data = JSON.toJSONString(param);//javabean转json,然后再转String类型
		EIThirdLogger.info("电子发票开具接口请求数据:"+data);
		oriData = data;
		
		// 1.Base64加密data串 对接口参数加密
		data = StringCodingUtils.Utf8_Base64_Encode(data);
		
		// 2.拼接请求参数
		StringBuilder str = new StringBuilder();
		str.append("appid=").append(appID);
		str.append("&data=").append(data);
		str.append("&noise=").append(noise);
		str.append("&key=").append(appKey);
		str.append("&version=").append(version);
		// 3.MD5加密 生成sign
		String sign = DigestUtils.md5Hex(str.toString().getBytes(Charset.forName("UTF-8"))).toUpperCase();
		// 4、最终请求串
		Map<String, String> map = new HashMap<>();
		map.put("appid", appID);
		map.put("data", data);
		map.put("noise", noise);
		map.put("sign", sign);
		map.put("version", version);

		EIThirdLogger.info("电子发票开具接口最终请求串:"+map.toString());
		BlEIncOutResult finalResult = httpUrlInvoke(map, url, appID, appKey, version,60);//http调用
		return finalResult;
	}

	/**
	 * http调用
	 * 
	 * @param map
	 * @throws BizException 
	 */
	public BlEIncOutResult httpUrlInvoke(Map<String, String> map, String url, String appID, String appKey, String version,Integer timeout) throws BizException {
		try {
			HttpPost httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout*500).setConnectTimeout(timeout*500).build();//设置请求和传输超时时间
			httpPost.setConfig(requestConfig);
			CloseableHttpClient client = HttpClients.createDefault();
			String respContent = null;
			// 请求参数转JOSN字符串
			StringEntity entity = new StringEntity(new ObjectMapper().writeValueAsString(map), "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			HttpResponse resp = client.execute(httpPost);
			if (resp.getStatusLine().getStatusCode() == 200) {
				String rev = EntityUtils.toString(resp.getEntity());
				EIThirdLogger.info("电子发票开具接口返回数据"+"返回串--》" + rev);
				Map result = new ObjectMapper().readValue(rev, Map.class);
				String rdata = result.get("data").toString();
				String rnoise = result.get("noise").toString();
				// 1、拼接返回验签参数
				StringBuilder str1 = new StringBuilder();
				str1.append("appid=").append(appID);
				str1.append("&data=").append(rdata);
				str1.append("&noise=").append(rnoise);
				str1.append("&key=").append(appKey);
				str1.append("&version=").append(version);
				// 3.MD5加密 生成sign
				String rmd5 = DigestUtils.md5Hex(str1.toString().getBytes(Charset.forName("UTF-8"))).toUpperCase();
				String rsign = result.get("sign").toString();
				EIThirdLogger.info("电子发票开具接口返回数据" + "验签-》" + (StringUtils.equals(rsign, rmd5)));
				// 4.获取返回结果
				String busData = StringCodingUtils.Utf8_Base64_Decode(result.get("data").toString());
				EIThirdLogger.info("电子发票开具接口返回数据" +"返回业务数据--》" + busData);
				Map busDataMap = new ObjectMapper().readValue(busData, Map.class);
				String finalCode =busDataMap.get("result").toString();//返回编码
				String finalMessage = StringCodingUtils.Utf8_Base64_Decode(busDataMap.get("message").toString());//返回内容
				if(finalCode != null && finalCode.equals("S0000")){
					//json转javabean
					EIThirdLogger.info("电子发票开具接口返回数据" +"业务信息解密--》" + finalMessage);
					BlEIncOutMessageResult messageRlt = JSON.parseObject(finalMessage, BlEIncOutMessageResult.class);
					
					BlEIncOutResult finalResult = new BlEIncOutResult();
					finalResult.setResult(finalCode);
					finalResult.setMessage(messageRlt);
					
					finalResult.setInputStr(oriData);
					finalResult.setOutputStr(finalMessage);
					return finalResult;
				}else{
					EIThirdLogger.info(String.format("%s返回失败,失败编码：%s,失败内容：%s", "电子票据开具接口",finalCode,finalMessage));
					BlEIncOutResult finalResult = new BlEIncOutResult();
					finalResult.setResult(finalCode);
					finalResult.setErrorMsg(finalMessage);
					finalResult.setInputStr(oriData);
					finalResult.setOutputStr(finalMessage);
					return finalResult;
					//throw new BizException(String.format("%s返回失败,失败编码：%s,失败内容：%s", "电子票据开具接口",finalCode,finalMessage));
				}

			} else {
				throw new BizException(String.format("开具接口：%s调用异常，错误代码:%s,错误内容:%s", url,resp.getStatusLine().getStatusCode(),resp.getStatusLine().getReasonPhrase()));
			}
		} catch (Exception e) {
			throw new BizException(e);
		}
	}

	/**
	 * 每次请求返回一个唯一编号，全局唯一（建议采用UUID）
	 * 
	 * @return
	 */
	public String getUuid() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
	

}
