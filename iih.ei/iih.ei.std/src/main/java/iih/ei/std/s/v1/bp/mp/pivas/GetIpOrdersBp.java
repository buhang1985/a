package iih.ei.std.s.v1.bp.mp.pivas;

import org.apache.commons.lang3.StringUtils;

import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasOrderListDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;

public class GetIpOrdersBp extends IIHServiceBaseBP<PivasIpOrderParamDTO, PivasOrderListDTO> {

	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(PivasIpOrderParamDTO param) throws BizException {
		if (param == null)
			throw new BizException("查询参数【科室编码和查询时间】不允许为空。");
		if(param != null){
			if(StringUtils.isEmpty(param.getDt_b_search())||StringUtils.isEmpty(param.getDt_e_search())){
				throw new BizException("查询时间不允许为空。");
			}
			InitContextBp bp = new InitContextBp();
			bp.exec(param.getCode_wh());
		}
	}

	/**
	 * 核心业务
	 */
	@Override
	protected PivasOrderListDTO process(PivasIpOrderParamDTO param) throws BizException {
		QueryPivasOrPrBp bp = new QueryPivasOrPrBp();
		return bp.exec(param);
	}

}