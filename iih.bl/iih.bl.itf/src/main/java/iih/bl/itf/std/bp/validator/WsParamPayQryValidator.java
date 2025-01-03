package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助机待缴已缴费用查询入参校验
 * @author shaokx 2019/01/14
 *
 */
public class WsParamPayQryValidator extends WsParamBaseValidator{
	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetCostBill param) throws BizException {
		if (param == null || param.getPatInfo() == null) {
			throw new BizException("入参数据为空");
		}
		
		WsParamBillPatInfo paramInfo = param.getPatInfo();
		
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
		} else if(IBlWsConst.ENTP_PE.equals(paramInfo.getEntpCode())){
			
			if(StringUtil.isEmpty(paramInfo.getPeCode())){
				throw new BizException("体检时，体检流水号为空");
			}
			
			if(StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getSdCode()) && StringUtil.isEmpty(paramInfo.getCardCode())){
				throw new BizException("体检入参关键信息全为空:患者编码,身份证号,就诊卡号");
			}
			
		}else {
			// 住院校验
			if (StringUtil.isEmpty(paramInfo.getIPCode()) && StringUtil.isEmpty(paramInfo.getEnCode())) {
				throw new BizException("入参关键信息全为空:住院编号,住院登记流水号");
			}
		}
	}
}
