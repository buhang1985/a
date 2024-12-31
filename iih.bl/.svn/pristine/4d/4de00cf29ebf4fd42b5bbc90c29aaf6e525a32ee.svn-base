package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.input.balacc.WsParamThirdPay;
import xap.mw.core.data.BizException;
/**
 * 查询微信支付宝交易信息 验证类
 * @author zhangxin
 * @date 2019年3月26日
 */
public class WsParamThirdPayValidator extends WsParamBaseValidator {
	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamThirdPay param) throws BizException {
		if (param == null) {
			throw new BizException("查询微信支付宝交易信息入参数据为空");
		}
		if (param.getStartDate() == null) {
			throw new BizException("查询微信支付宝交易信息开始时间为空");
		}
		if (param.getEndDate() == null) {
			throw new BizException("查询微信支付宝交易信息结束时间为空");
		}
	}
}
