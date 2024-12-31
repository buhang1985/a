package iih.pmp.yxpaySDK.bp;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class YxPayConfig {
	
	private static  PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();
	/**
	 * 商户号
	 * @return
	 * @throws BizException 
	 */
	
	public static String getMchID() throws BizException
	{
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),PmpPayBaseCost.PMP_YXMCHID);
	}
	/**
	 * ip地址
	 * @return
	 * @throws BizException
	 */
	public static String getDomain() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),"pmp_yxurl");
	}
	public static String getProxyIp() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),PmpPayBaseCost.PMP_PROXYIP);
	}
	
	public static String getBranchId() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),"pmp_yxmchid");
	}
	

	public static Integer getProxyPort() throws BizException {
	String portstr=ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYPORT);
		
		try {
			return Integer.parseInt(portstr);
		}catch(Exception ex) {
			
		}
		return null;
	}

}
