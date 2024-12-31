package iih.ei.std.s.v1.bp.mp.pivas;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.utils.CommDAFacade;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasDrugPlanResultBeanDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasDrugPlanResultBeanListDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.pivas.qry.GetIpDrugPalnsQry;
import xap.mw.core.data.BizException;

public class GetIpDrugPlansBp extends IIHServiceBaseBP<PivasIpOrderParamDTO, PivasDrugPlanResultBeanListDTO> {

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
	protected PivasDrugPlanResultBeanListDTO process(PivasIpOrderParamDTO param) throws BizException {

		// 1.获取药单信息
		return this.getIpDrugPlans(param);
	}

	/**
	 * 获取药单信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private PivasDrugPlanResultBeanListDTO getIpDrugPlans(PivasIpOrderParamDTO param) throws BizException {

		PivasDrugPlanResultBeanListDTO result = new PivasDrugPlanResultBeanListDTO();
		List<PivasDrugPlanResultBeanDTO> orderList = new ArrayList<PivasDrugPlanResultBeanDTO>();
		GetIpDrugPalnsQry qry = new GetIpDrugPalnsQry(param);
		PivasDrugPlanResultBeanDTO[] drugPlans = CommDAFacade.execQuery(qry, PivasDrugPlanResultBeanDTO.class);
		for (PivasDrugPlanResultBeanDTO plan : drugPlans) {
			orderList.add(plan);
		}
		result.setDrugplanitems(ArrayListUtil.ConvertToFArrayList(orderList));
		return result;
	}
}
