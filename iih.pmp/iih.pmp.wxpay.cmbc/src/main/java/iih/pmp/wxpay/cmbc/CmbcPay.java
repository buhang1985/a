package iih.pmp.wxpay.cmbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;

public class CmbcPay  implements IPmpSdk{
	
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	
	private String Domain_api;
	public CmbcPay() {
		if("Y".equals(Config.getProperty("isSandy"))) {
			Domain_api=CmbcConst.DOMAIN_API_SANDYBOX;
		}else {
			Domain_api=CmbcConst.DOMAIN_API;
		}
	}
	
	@Override
	public Map<String, String> doScanPay(Map<String, Object> map) throws BizException{
		// TODO Auto-generated method stub
		String url=Domain_api+CmbcConst.UNIFIEDORDER_URL_SUFFIX;
		map.put("notifyUrl", Config.getProperty("notifyUrl"));
        String context=CmbcUtils.genContext(map);
        Map<String,String>data=doPostAPI( context, url);

		return data;
	}
	@Override
	public Map<String, String> reverse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, String> refund(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=Domain_api+CmbcConst.REFUND_URL_SUFFIX;
		String context=CmbcUtils.genContext(map);
		Map<String,String>data=doPostAPI( context, url);

		return data;
	}
	@Override
	public Map<String, String> dorefundquery(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		String url=Domain_api+CmbcConst.QUERY_URL_SUFFIX;
		String context=CmbcUtils.genContext(map);
		Map<String,String>data=doPostAPI( context, url);

		return data;
	}
	@Override
	public Map<String, String> GetCheckLedgerInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 查询
	 * @param context
	 * @return
	 * @throws BizException 
	 */
	@Override
	public  Map<String,String> doQuery(Map<String,Object> map) throws BizException {
		String url=Domain_api+CmbcConst.QUERY_URL_SUFFIX;
		String context=CmbcUtils.genContext(map);
		Map<String,String>data=doPostAPI( context, url);

		return data;
	}
	@Override
	public Map<String,String> downloadfile(Map<String,Object> map) throws BizException {
		String url=Domain_api+CmbcConst.FILE_DOWNLOAD_SUFFIX;
		String context=CmbcUtils.genContext2(map);
		Map<String,String>data=doPostAPI( context, url);
		return data;
	}
	
	@Override
	public Map<String, String> doQRCODEPay(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * http请求加签名验证
	 * @param context
	 * @param url
	 * @return
	 * @throws BizException 
	 */
	public  Map<String,String> doPostAPI(String context,String url) throws BizException {
		        //签名
				String sign = CmbcUtils.getSign(context);
				String signContext = CmbcUtils.sign(sign, context);
				//加密消息
				String encryptContext = CmbcUtils.encrypt(signContext);
				//生成报文
				String report=toJson(encryptContext);
				 StringEntity postEntity=new StringEntity(report,"UTF-8");
				 //http请求
				 CmbcClient_new hcli=new CmbcClient_new();
				 String ss=hcli.doPost(url, postEntity);

				Map<String,Object>map=CmbcUtils.json2Map(ss);
				if(!"S".equals(map.get("gateReturnType"))) {
					Map<String,String>data2=new HashMap<String,String>();
					obj2Str(data2,map);
					return data2;
				}
				String businessContext=(String)map.get("businessContext");
				//解密消息体
				String result=CmbcUtils.dncrypt(businessContext);
				
				//签名验证
				boolean isSignOk=CmbcUtils.signCheck(result);
				if(!isSignOk)
					return null;
				Map<String,String>data=getMapRst(map, result);
		        return data;
	}
	
	private Map<String,String> getMapRst(Map<String,Object>map,String result){
		Map<String,String>data=new HashMap<String,String>();
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, Object> paraMap = gson.fromJson(result, Map.class);
		obj2Str(data,map);
		obj2Str(data,paraMap);
		String body = paraMap.get("body").toString();
		@SuppressWarnings("unchecked")
		Map<String, Object> m=gson.fromJson(body, Map.class);
		obj2Str(data,m);
		return data;
	}
	
   private void obj2Str(Map<String,String>data,Map<String,Object>map){
	   Iterator<String> it= map.keySet().iterator();
		while(it.hasNext()) {
			String key=it.next();
			String val=map.get(key)==null?null:map.get(key)+"";
			data.put(key, val);
		}
   }
	
	private  String toJson(String context) {
		GsonBuilder builder = new GsonBuilder();
		builder.disableHtmlEscaping();
		Gson gson = builder.create();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("businessContext", context);
		paramMap.put("merchantNo", "");
		paramMap.put("merchantSeq", "");
		paramMap.put("reserve1", "");
		paramMap.put("reserve2", "");
		paramMap.put("reserve3", "");
		paramMap.put("reserve4", "");
		paramMap.put("reserve5", "");
		paramMap.put("reserveJson", "");
		paramMap.put("securityType", "");
		paramMap.put("sessionId", "");
		paramMap.put("source", "");
		paramMap.put("transCode", "");
		paramMap.put("transDate", "");
		paramMap.put("transTime", "");
		paramMap.put("version", "");
		String signInfo = gson.toJson(paramMap); 
		return signInfo;
	}
	
	public   String SMS(String postData, String postUrl) {
		try {
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");//�޸ķ��ͷ�ʽ
			conn.setRequestProperty("Content-Type",
					"application/json");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
 
			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(
					conn.getOutputStream());
			out.write(postData);
			out.flush();
			out.close();
 
			// ��ȡ��Ӧ״̬
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return "";
			}
			// ��ȡ��Ӧ������
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();
			return result;
		} catch (IOException e) {
		}
		return "";
	}

	 

	@Override
	public String[] getBillContent(Map<String, Object> map) throws BizException {
		// TODO Auto-generated method stub
		 Map<String, String>r1=downloadfile(map);
		 if (r1 != null
					&& "S".equals(r1
							.get("gateReturnType"))) {
			 if(r1.containsKey("segmentCount")) {
				 int num=Integer.parseInt(r1.get("segmentCount").toString());
					StringBuilder sb=new StringBuilder();
					for(int i=1;i<=num;i++) {
						map.put("segmentIndex", ""+i);			
						 Map<String, String>r=downloadfile(map);
						 if (r != null
									&& "S".equals(r
											.get("gateReturnType"))) {
							 if(r.containsKey("segmentContent")) {
								 String sg=r.get("segmentContent");
								 String ss=sg.trim();
								 if(sg.trim().equals(""))continue;
								 String context=pmputils.Base64Decode(sg);
		                         sb.append(context);
							 }else {
								 throw new BizException("对账单下载失败！！！！");
							 }
							 
						 }
					}
					
					 String[] rnt=sb.toString().split("\\n");
					 return rnt;
			 }
			 
		 }
		return null;
	}
	@Override
	public String getChlCode() {
		// TODO Auto-generated method stub
		return PmpPayConst.CMBC_CHANNEL_CODE;
	}




}
