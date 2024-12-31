package iih.pmp.pay.web.pay.bp;

import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import test.wxpay.sdk.WXPayConfigImpl;
import wxpay.sdk.WXPayConfig;
import wxpay.sdk.WXPayUtil;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class WXPayNotifyAppUtils {
	final static BASE64Decoder decoder = new BASE64Decoder();
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
	public static String Base64Decode(String encodeText){
		String result=null;
		try {

			result= new String(decoder.decodeBuffer(encodeText));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static String getMd5Encode() {		
		try {
			return WXPayUtil.MD5( WXPayConfigImpl.getInstance().getKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * 解密
     * @param content
     *            待解密内容
     * @return
     */
    public static byte[] decrypt(byte[] data,String KEY,Cipher cipher ) throws Exception { 	
   
        Key k = toKey(KEY.toLowerCase().getBytes());                             
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    private static Key toKey(byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }
    
    private WXPayConfig getConfig() throws Exception{
    	return  WXPayConfigImpl.getInstance(); 
    }
    
    /**
	 * 交易查询服务
	 * @return
	 */
	public static ITradeRService getTradeRService(){
		return ServiceFinder.find(ITradeRService.class);
	}
	/**
	 * 交易增删改服务
	 * @return
	 */
	public static ITradeCudService getTradeCUDService(){
		return ServiceFinder.find(ITradeCudService.class);
	}
	/**
	 * 订单查询服务
	 * @return
	 */
	public static IOrdRService getOrdRService(){
		return ServiceFinder.find(IOrdRService.class);
	}
	/**
	 * 订单增删改服务
	 * @return
	 */
	public static IOrdCudService getOrdCudService(){
		return ServiceFinder.find(IOrdCudService.class);
	}
	/**
	 * 将分转换成元
	 * @param total_fee
	 * @return
	 */
	public static FDouble fenToYuan(String total_fee){
		Double d=Double.parseDouble(total_fee);
		Double val=d/100;
		return new FDouble(val);
	}
	/**
	 * 判断FDouble的值是否相等
	 * @param val1
	 * @param val2
	 * @return
	 */
	public static boolean isFDoubleEq(FDouble val1,FDouble val2){
		if(Double.doubleToLongBits(val1.getDouble())==Double.doubleToLongBits(val2.getDouble())){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取服务器时间
	 * @return
	 */
	public static FDateTime getServerDateTime() {
		TimeService ts = (TimeService) ServiceFinder.find(TimeService.class
				.getName());
		return ts.getUFDateTime();
	}

}
