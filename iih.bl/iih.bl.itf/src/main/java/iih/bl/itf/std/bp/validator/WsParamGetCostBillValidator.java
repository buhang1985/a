package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 费用查询入参校验
 * @author wq.li
 *
 */
public class WsParamGetCostBillValidator extends WsParamBaseValidator{
	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetCostBill param) throws BizException {

		if (param == null || param.getPatInfo() == null) {
			throw new BizException("费用查询入参数据为空");
		}

		WsParamBillPatInfo paramInfo = param.getPatInfo();

		if (StringUtil.isEmpty(paramInfo.getHospitalCode())) {
			throw new BizException("费用查询入参医院编码为空");
		}

		if (StringUtil.isEmpty(paramInfo.getEntpCode())) {
			throw new BizException("费用查询入参就诊类型为空");
		}

//		if(StringUtil.isEmpty(paramInfo.getEnTimes())){
//			throw new BizException("费用查询入参就诊次数为空");
//		}
		
		if (IBlWsConst.ENTP_OP.equals(paramInfo.getEntpCode())) {
			// 门诊校验
			if (StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getCardCode())
					&& StringUtil.isEmpty(paramInfo.getSdCode())) {
				throw new BizException("门诊费用查询入参关键信息全为空:患者编码,就诊卡号,身份证号");

			}
		} else {
			// 住院校验
			if (StringUtil.isEmpty(paramInfo.getIPCode())) {
				throw new BizException("住院费用查询入参关键信息全为空:住院编号");

			}
		}

	}
}

