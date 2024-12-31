package iih.ei.std.s.v1.bp.mp.dispdruginfo;

import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPCollocateDrugResult;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPDispDrugParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
/**
 * 
* @ClassName: GetIPDispDrugInfoBP
* @Description: 住院发药明细
* @author zhy
* @date 2019年10月16日
*
 */
public class GetIPDispDrugInfoBP extends IIHServiceBaseBP<IPDispDrugParamDTO, IPCollocateDrugResult>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(IPDispDrugParamDTO param) throws BizException {
		if (null == param || null == param.getDispdrug()) {
			throw new BizException("入参空异常");
		}
		
	}
	
	/**
	 * 核心业务
	 */
	@Override
	protected IPCollocateDrugResult process(IPDispDrugParamDTO param) throws BizException {
		QryIPDispDrugInfoBP bp = new QryIPDispDrugInfoBP();
		return bp.exec(param);
	}

}
