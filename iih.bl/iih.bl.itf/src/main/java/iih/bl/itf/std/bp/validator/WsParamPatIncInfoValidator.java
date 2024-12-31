package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.inc.WsParamGetPatInc;
import iih.bl.itf.std.bean.input.inc.sub.WsParamGetPatIncInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助发票查询入参校验
 * 
 * @author shaokx 2019年2月25日
 *
 */
public class WsParamPatIncInfoValidator extends WsParamBaseValidator {

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetPatInc param) throws BizException {
		if (param.getPrepay() == null) {
			throw new BizException("门诊自助发票查询入参数据为空");
		}

		WsParamGetPatIncInfo prepayInfo = param.getPrepay();

		if (StringUtil.isEmpty(prepayInfo.getEntpCode())) {
			throw new BizException("门诊自助发票查询入参就诊类型为空");
		}

		if (!super.checkEntp(prepayInfo.getEntpCode())) {
			throw new BizException("门诊自助发票查询入参就诊类型值不正确");
		}

		if (IBlWsConst.ENTP_OP.equals(prepayInfo.getEntpCode())) {
			if (StringUtil.isEmpty(prepayInfo.getPatCode()) && StringUtil.isEmpty(prepayInfo.getCardCode())
					&& StringUtil.isEmpty(prepayInfo.getSdCode())) {
				throw new BizException("门诊自助发票查询入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		} else {
			if (StringUtil.isEmpty(prepayInfo.getPatCode()) && StringUtil.isEmpty(prepayInfo.getEnTimes())
					&& StringUtil.isEmpty(prepayInfo.getIPCode())) {
				throw new BizException("门诊自助发票查询入参关键信息全为空:患者编码,就诊次数,住院登记流水号");
			}
		}

		if (StringUtil.isEmpty(prepayInfo.getOperaCode())) {
			throw new BizException("门诊自助发票查询入参操作员编码为空");
		}

		if (StringUtil.isEmpty(prepayInfo.getTerminalType())) {
			throw new BizException("门诊自助发票查询入参终端类型为空");
		}

		if (!super.checkTerminalType(prepayInfo.getTerminalType())) {
			throw new BizException("门诊自助发票查询入参终端类型值不正确");
		}
	}
}
