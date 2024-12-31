package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBillNew;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfoNew;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助机待缴已缴费用查询入参校验新
 * @author shaokx 2019/07/19
 *
 */
public class WsParamPayQryValidatorNew extends WsParamBaseValidator{

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetCostBillNew param) throws BizException {
		if (param == null || param.getPatInfo() == null) {
			throw new BizException("入参数据为空");
		}
		
		WsParamBillPatInfoNew paramInfo = param.getPatInfo();
		
		if (StringUtil.isEmpty(paramInfo.getHospitalCode())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(paramInfo.getEntpCode())) {
			throw new BizException("入参就诊类型为空");
		}
		
		if (IBlWsConst.ENTP_OP.equals(paramInfo.getEntpCode())) {
			// 门诊校验
			if (StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getCardCode())
					&& StringUtil.isEmpty(paramInfo.getSdCode())) {
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号");
			}
		} else {
			// 住院校验
			if (StringUtil.isEmpty(paramInfo.getIPCode()) && StringUtil.isEmpty(paramInfo.getEnCode())) {
				throw new BizException("入参关键信息全为空:住院编号,住院登记流水号");
			}
		}
	}
	
}
