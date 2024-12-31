package iih.ei.std.s.v1.bp.mp.dispdruginfo;

import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPCollocateDrugResult;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPDispDrugParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: GetOPDispDrugInfoBP
* @Description: 获取门诊发药明细
* @author zhy
* @date 2019年10月16日
*
 */
public class GetOPDispDrugInfoBP extends IIHServiceBaseBP<OPDispDrugParamDTO, OPCollocateDrugResult>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(OPDispDrugParamDTO param) throws BizException {
		if (null == param || StringUtil.isEmptyWithTrim(param.getId_pres())) {
			throw new BizException("入参空异常");
		}
		
	}

	@Override
	protected OPCollocateDrugResult process(OPDispDrugParamDTO param) throws BizException {
		QryOPDispDrugInfoBP bp = new QryOPDispDrugInfoBP();
		return bp.exec(param);
	}

}
