package iih.bd.base.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * http url调用类
 * @author ly 2018/11/05
 *
 */
public class HttpUrlInvoker {

	private static final String ENCODING = "UTF-8";
	
	private String url;
	private Integer timeoutSecond = 60;
	private String contentType = "application/x-javascript text/xml; charset=" + ENCODING;
	
	public HttpUrlInvoker(String url){
		this.url = url;
	}
	
	public HttpUrlInvoker(String url, String contentType){
		this.url = url;
		this.contentType = contentType;
	}
	
	public HttpUrlInvoker(String url, Integer second){
		this.url = url;
		if(second != null && second >= 1){
			this.timeoutSecond = second;
		}
	}
	
	/**
	 * get请求 TODO
	 * @return
	 * @throws Exception
	 */
	public String get(String data) throws BizException{
		throw new BizException("not implemented");
	}
	
	/**
	 * post请求
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String post(String data) throws BizException{

		if(StringUtil.isEmpty(data)){
			throw new BizException(String.format("%s请求内容为空", this.url));
		}
		
		String result = null;
		
		URL url = null;
		HttpURLConnection conn = null;
		try {
			byte[] bData = data.getBytes(ENCODING);
			
			url = new URL(this.url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", contentType);
			conn.setRequestProperty("Content-Length", String.valueOf(bData.length));
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setConnectTimeout(this.timeoutSecond * 500);
			conn.setReadTimeout(this.timeoutSecond * 500);
			
			DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
	        outStream.write(bData);
	        outStream.flush();
	        outStream.close();
			
	        int resultCode = conn.getResponseCode();
	        if(resultCode == HttpURLConnection.HTTP_OK){
				StringBuilder sb = new StringBuilder();
				BufferedReader bufReader = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String readLine = null;
				while ((readLine = bufReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				bufReader.close();
				result = sb.toString();
	        }else{
	        	throw new BizException(String.format("%s调用异常，错误代码:%s", this.url,conn.getResponseCode()));
	        }
		} catch (Exception e) {
			throw new BizException(e);
		}finally{
			if(conn != null){
				try {
					 conn.disconnect();
				} catch (Exception e2) {
				}
			}
		}
		
		return result;
	}
}
