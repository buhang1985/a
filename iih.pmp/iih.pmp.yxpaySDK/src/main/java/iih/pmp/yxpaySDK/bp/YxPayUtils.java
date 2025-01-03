package iih.pmp.yxpaySDK.bp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayToolUtils;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.pay.utils.PmpWxPayLogUtils;
import xap.mw.core.data.BizException;

public class YxPayUtils {
	static PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String m2json(Map<String,Object>map) {
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		Gson gson = builder.create();
		String info = gson.toJson(map); 
		return info;
	}
	/**
	 * map转json
	 * @param map
	 * @return
	 */
	public static String m2json2(Map<String,String>map) {
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		Gson gson = builder.create();
		String info = gson.toJson(map); 
		return info;
	}
	/**
	 * json转map
	 * @param json
	 * @return
	 */
	public static Map<String, Object> json2Map(String json){
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, Object> paraMap = gson.fromJson(json, Map.class);
		return paraMap;
	}
	/**
	 * post请求
	 * @param url
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public static  Map<String,String> post(String url,Map<String,Object> map) throws BizException{
		String info=m2json(map);
		PmpPayLogUtils.info("[1]PMP_YxPayUtils,POST请求入参: "+info);
		StringEntity postEntity=new StringEntity(info,"UTF-8");
		 //http请求
		PmpWxPayLogUtils.info("调用request：%s",info);
		YxPayHttpClient hcli=new YxPayHttpClient();
		String ss=hcli.doPost(url, postEntity);
		PmpPayLogUtils.info("[2]PMP_YxPayUtils,POST请求结果: "+ss);
		if(ss!=null) {
			Map<String,Object> o=null;
			try {
			 o=json2Map(ss);
			}catch(Exception ex) {
				
			}
			if(o!=null) {
			int status=(int)Double.parseDouble(o.get("status")+"");
			if(200==status) {
				Object d=o.get("data");
				Map<String,Object> result=(Map<String,Object> )d;
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_SUCCESS);
				result.put(PmpPayConst.PMP_ERR_CODE, o.get("code"));
				result.put(PmpPayConst.PMP_ERR_MSG, o.get("msg"));
				PmpWxPayLogUtils.info("返回值：%s", result);
				
				return obj2Str(result);
			}else {
				Map<String,Object>result=new HashMap<>();
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
				result.put(PmpPayConst.PMP_ERR_CODE, o.get("code"));
				result.put(PmpPayConst.PMP_ERR_MSG, o.get("msg"));
				result.put("status", status);
				PmpWxPayLogUtils.info("返回值：%s", result);
				return obj2Str(result);
			}
			}else {
				Map<String,Object>result=new HashMap<>();
				result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
				result.put(PmpPayConst.PMP_ERR_CODE, "unknow");
				result.put(PmpPayConst.PMP_ERR_MSG, ss);
				PmpWxPayLogUtils.info("返回值：%s", result);
				return obj2Str(result);
			}
			
		}else {
			Map<String,Object>result=new HashMap<>();
			result.put(PmpPayConst.PMP_RESULT, PmpPayConst.PMP_ERROR);
			result.put(PmpPayConst.PMP_ERR_CODE, "unknow");
			result.put(PmpPayConst.PMP_ERR_MSG, "unknow");
			PmpWxPayLogUtils.info("返回值：%s", result);
			return obj2Str(result);
		}
	}
	
	/**
	 * post请求
	 * @param url
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public static  Map<String,String> post2(String url,Map<String,Object> map) throws BizException{
		Map<String,String> paraminfo=obj2Str(map);
		String info=PmpPayToolUtils.mapToXml(paraminfo,"req");
		StringEntity postEntity=new StringEntity(info,"UTF-8");
		 //http请求
		PmpWxPayLogUtils.info("调用request：%s",info);
		YxPayHttpClient2 hcli=new YxPayHttpClient2();
		String ss=hcli.doPost(url, postEntity);
		PmpWxPayLogUtils.info("调用res：%s",ss);
		return processResponseXml(ss);
	}
	
	 private  static  Map<String,String> obj2Str(Map<String,Object>map){
		 Map<String,String>data=new HashMap<>();
		   Iterator<String> it= map.keySet().iterator();
			while(it.hasNext()) {
				String key=it.next();
				String val=map.get(key)==null?null:map.get(key)+"";
				data.put(key, val);
			}
			return data;
	   }
	 
	 /**
		 * 处理HTTP API返回数据，转换成Map对象。
		 * @param xmlStr API返回的XML格式数据
		 * @return Map类型数据
		 * @throws Exception
		 */
		public static Map<String,String> processResponseXml(String xmlStr)throws BizException
		{
			if(pmputils.isStrEmpty(xmlStr))return null;
			Map<String,String> result=PmpPayToolUtils.xmlToMap(xmlStr);
			
			return result;
			
		}
		
		public static String handleerrcode(String errcode) {
			if(pmputils.isStrEmpty(errcode))return null;
			if(errcode.length()>30)return errcode.substring(0, 30);
			return errcode;
		}

}
