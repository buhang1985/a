package iih.pmp.utils;

import iih.pmp.param.IPmpPayParamCodeConst;
import iih.pmp.param.ParamUtils;
import xap.mw.core.data.BizException;

/**
 * 
 * 支付平台参数工具类
 * 
 * @author hao_wu
 * @date 2020年4月20日
 *
 */
public class PmpPayParamUtils {

	/**
	 * 获取对账后台任务渠道编码
	 * 
	 * @return 对账后台任务渠道编码
	 * @throws BizException
	 */
	public static String getBillCheckTaskChannelCode() throws BizException {
		String paramValue = ParamUtils.getOrgParamStringValue(IPmpPayParamCodeConst.PMP_PAY_CHANNELCODE);
		return paramValue;
	}
}
