package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 账户查询参数校验
 * 
 * @author wq.li 2018年7月29日
 *
 */
public class WsParamAccountInfoValidator extends WsParamBaseValidator {

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetAccRecord param) throws BizException {

		if (param == null || param.getPatInfo() == null) {
			throw new BizException("账户查询入参数据为空");
		}

		WsParamAccPatInfo paramInfo = param.getPatInfo();

		if (StringUtil.isEmpty(paramInfo.getHospitalCode())) {
			throw new BizException("账户查询入参医院编码为空");
		}

		if (StringUtil.isEmpty(paramInfo.getEntpCode())) {
			throw new BizException("账户查询入参就诊类型为空");
		}

		if (IBlWsConst.ENTP_OP.equals(paramInfo.getEntpCode())) {
			// 门诊校验
			if (StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getCardCode())
					&& StringUtil.isEmpty(paramInfo.getSdCode())) {
				throw new BizException("门诊账号查询入参关键信息全为空:患者编码,就诊卡号,身份证号");

			}
		} else {
			// 住院校验
			if (StringUtil.isEmpty(paramInfo.getIPCode())) {
				throw new BizException("住院账号查询入参关键信息全为空:住院编号");

			}
		}

	}
}
