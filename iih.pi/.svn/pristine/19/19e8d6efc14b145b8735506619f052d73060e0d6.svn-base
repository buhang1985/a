package iih.pi.reg.s.wsstd.bp.validator;

import org.apache.commons.lang.StringUtils;

import iih.pi.common.idcheck.IDChecker;
import iih.pi.reg.wsstd.bean.input.elehealcard.WsParamUpdateEleHealCard;
import iih.pi.reg.wsstd.bean.input.elehealcard.sub.WsParamUpdateEleHealCardInfo;
import iih.pi.reg.wsstd.bean.input.patinfo.WsParamGetPatInfo;
import iih.pi.reg.wsstd.bean.input.patinfo.sub.WsParamPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 更新电子健康卡入参校验
 * @author shaokx
 *
 */
public class WsParamUpdateEleHealCardValidator {

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamUpdateEleHealCard param) throws BizException {
		
		if (param == null || param.getPrepay() == null) {
			throw new BizException("入参数据为空");
		}
		
		WsParamUpdateEleHealCardInfo paramInfo = param.getPrepay();
		
		if (StringUtil.isEmpty(paramInfo.getPatCode()) && StringUtil.isEmpty(paramInfo.getCardCode())
				&& StringUtil.isEmpty(paramInfo.getSdCode()) && StringUtil.isEmpty(paramInfo.getIPCode())) {
			throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号,住院号");
		}
		
		// 校验身份证号是否正确
		if (!StringUtil.isEmpty(paramInfo.getSdCode()) && !IDChecker.checkIDCard(paramInfo.getSdCode())) {
			throw new BizException("身份证号值不正确");
		}
		
		if(StringUtil.isEmpty(paramInfo.getDoType())){
			throw new BizException("入参操作动作为空");
		}
		
		if(StringUtil.isEmpty(paramInfo.geteCode())){
			throw new BizException("入参第三方电子健康卡号为空");
		}
	
	}
}
