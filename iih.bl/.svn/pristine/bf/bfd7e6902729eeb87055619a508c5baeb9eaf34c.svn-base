package iih.bl.itf.std.bp.validator;

import iih.bl.itf.std.bean.input.inc.WsParamGetIncItm;
import iih.bl.itf.std.bean.input.inc.sub.WsParamGetIncItmInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 门诊自助发票明细查询入参校验
 * 
 * @author shaokx 2019年2月25日
 *
 */
public class WsParamIncItmInfoValidator extends WsParamBaseValidator {

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamGetIncItm param) throws BizException {

		if (param.getPrepay() == null) {
			throw new BizException("门诊自助发票明细查询入参数据为空");
		}

		WsParamGetIncItmInfo prepayInfo = param.getPrepay();

		if (StringUtil.isEmpty(prepayInfo.getStNO())) {
			throw new BizException("门诊自助发票明细查询入参结算号为空");
		}
		
		if(StringUtil.isEmpty(prepayInfo.getOperaCode())){
			throw new BizException("门诊自助发票明细查询入参操作员编码为空");
		}
	}
}
