package iih.pi.reg.s.wsstd.bp.validator;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.pi.reg.wsstd.bean.input.patinfo.WsParamGetPatInfo;
import iih.pi.reg.wsstd.bean.input.patinfo.sub.WsParamPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 患者信息查询入参校验
 * @author shaokx
 *
 */
public class WsParamGetPatInfoValidator {

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetPatInfo param) throws BizException {
		
		if (param == null || param.getPrepay() == null) {
			throw new BizException("入参数据为空");
		}
		
		WsParamPatInfo paramInfo = param.getPrepay();
		
		if (StringUtil.isEmpty(paramInfo.getHospitalCode())) {
			throw new BizException("入参医院编码为空");
		}
		
		if (StringUtil.isEmpty(paramInfo.getEntpCode())) {
			throw new BizException("入参就诊类型为空");
		}
		
		if (!"01".equals(paramInfo.getEntpCode()) && !"02".equals(paramInfo.getEntpCode())) {
			throw new BizException("入参就诊类型值不正确");
		}
		
		if (IBlWsConst.ENTP_OP.equals(paramInfo.getEntpCode())) {
			// 门诊校验
			if (StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getCardCode())
					&& StringUtil.isEmpty(paramInfo.getSdCode())) {
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");

			}
		} else {
			// 住院校验
			if (StringUtil.isEmpty(paramInfo.getIPCode()) && StringUtil.isEmpty(paramInfo.getCardCode()) && StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getSdCode())) {
				throw new BizException("入参关键信息全为空:住院编号,就诊卡号,患者编码,身份证号");

			}
		}
		
		if(StringUtil.isEmpty(paramInfo.getPatType())){
			throw new BizException("入参患者类型为空");
		}
	}
}
