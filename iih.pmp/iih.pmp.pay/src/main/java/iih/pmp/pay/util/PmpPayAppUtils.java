package iih.pmp.pay.util;

import java.util.Random;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.desc.OrdDODesc;
import iih.pmp.pay.thirdpartyconfig.d.ThirdPartyConfigDO;
import iih.pmp.pay.thirdpartyconfig.i.IThirdpartyconfigRService;
import iih.pmp.pay.trade.d.desc.TradeDODesc;
import test.wxpay.sdk.WXPayConfigImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class PmpPayAppUtils {
	private static PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();

	private static IThirdpartyconfigRService _thirdpartyconfigRService = ServiceFinder.find(IThirdpartyconfigRService.class);
	private static ThirdPartyConfigDO[] thirdPartyConfigDO;
	/**
	 * 获得编码字段生成管理器
	 * 
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManager() {
		return (IBillcodeManage) ServiceFinder.find(IBillcodeManage.class);
	}

	/**
	 * 获取交易号(流水号+时间戳)
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String getTradeCode() throws BizException {
		String code = getIBillcodeManager().getPreBillCode_RequiresNew(TradeDODesc.CLASS_FULLNAME);
		FDateTime dt = utils.getServerDateTime();
		String transdate = utils.getTransDate(dt, "yyyyMMddHHmmss");
		String random=getRandomInt()+"";
		return transdate +"" + random+ code;
	}

	public static String getOrderCode() throws BizException {
		String code = getIBillcodeManager().getPreBillCode_RequiresNew(OrdDODesc.CLASS_FULLNAME);
		FDateTime dt = utils.getServerDateTime();
		String transdate = utils.getTransDate(dt, "yyyyMMddHHmmss");
		String random=getRandomInt()+"";
		return transdate +""+ random +code ;
	}
	
	private static int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10);
	}

	/**
	 * 生成宽和高都是256的二维码字节流
	 * 
	 * @param contents
	 * @return
	 */
	public static byte[] getQRCodeImge(String contents) {
		return QrCodeUtil.getQRCodeImge(contents, 256, 256);
	}



	public static WXPayConfigImpl getWXConfig() {
		try {
			return WXPayConfigImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
    /**
     * 获取支付的sdk
     * @return
     * @throws BizException 
     */
	public static IPmpSdk getPmpSdk(String sd_chl) throws BizException {
		thirdPartyConfigDO = _thirdpartyconfigRService.find("fg_active = 'Y' and sd_paychannels = '"+sd_chl+"'", "", FBoolean.FALSE);
		if(thirdPartyConfigDO.length<1){
			throw new BizException("未找到启用的配置文件！");
		}
		String val = thirdPartyConfigDO[0].getName_sdk();
		if(val==null||val.trim().equals("")) {
			throw new BizException("获取第三方支付sdk异常！");
		}
		try {
			//反射SDK
			Class _class = Class.forName(val.trim());
			IPmpSdk ipay=(IPmpSdk) _class.newInstance();
			if(!ipay.getChlCode().equals(sd_chl))
				throw new  BizException("获取第三方支付sdk关联的渠道编码错误！"+ipay.getChlCode());
			return ipay;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付sdk异常！ClassNotFoundException");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付sdk异常！InstantiationException");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付sdk异常！IllegalAccessException");
		}
	}
    /**
     * 数据转换接口
     * @return
     * @throws BizException 
     */
	public static IPmpDataconvert getDataconvert(String sd_chl) throws BizException {
		thirdPartyConfigDO = _thirdpartyconfigRService.find("fg_active = 'Y' and sd_paychannels = '"+sd_chl+"'", "", FBoolean.FALSE);
		if(thirdPartyConfigDO.length<1){
			throw new BizException("未找到启用的配置文件！");
		}
		String val = thirdPartyConfigDO[0].getName_dataconvert();
		if(val==null||val.trim().equals("")) {
			throw new BizException("获取第三方支付数据转换异常，请查看轻量级配置是否正确！");
		}
		try {
			Class _class = Class.forName(val.trim());
			IPmpDataconvert iconvert=(IPmpDataconvert) _class.newInstance();
			if(!iconvert.getChlCode().equals(sd_chl))
				throw new  BizException("获取第三方支付数据转换关联的渠道编码错误！"+iconvert.getChlCode());
			return iconvert;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付数据转换异常！ClassNotFoundException");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付数据转换异常！InstantiationException");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new BizException("获取第三方支付数据转换异常！IllegalAccessException");
		}

	}
	
	/**
	 * 获取当前渠道号
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static String getCurrentChl() throws BizException {
		if(thirdPartyConfigDO==null||thirdPartyConfigDO.length<1){
			thirdPartyConfigDO = _thirdpartyconfigRService.find("fg_active = 'Y'", "", FBoolean.FALSE);
		}
		if(thirdPartyConfigDO.length<1){
			throw new BizException("未找到启用的配置文件！");
		}
		String val = thirdPartyConfigDO[0].getSd_paychannels();
		return val.trim();
	}

	
}
