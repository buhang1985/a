package iih.bl.cg.bp.oep;

import iih.bd.base.utils.CollectionUtils;
import iih.bl.cg.bp.GetPayItmListByCgIdBP;
import iih.bl.cg.bp.qry.GetPayItmListByCgIdQry;
import iih.bl.cg.bp.qry.GetRegStDTOQry;
import iih.bl.cg.dto.d.OpPayItmDTO;
import iih.bl.cg.dto.d.OpRegStDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetOpRegStInfoBP {
	/**
	 * 获取门诊挂号結算信息
	 * 
	 * @param cgId
	 *            记账id
	 * @return DTO集合
	 * @throws BizException
	 */
	public OpRegStDTO exec(String cgId) throws BizException {
		// 1、查询结算信息
		OpRegStDTO stDTO = GetRegStDTO(cgId);
		// 2、查询支付明细信息
		GetPayItmListByCgIdBP getPayItmBP = new GetPayItmListByCgIdBP();
		OpPayItmDTO[] payItms = getPayItmBP.exec(cgId);
		FArrayList Payitm_list = CollectionUtils.toFArrayList(payItms);
		stDTO.setPayitm_list(Payitm_list);
		return stDTO;
	}

	/**
	 * 查询结算信息
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	private OpRegStDTO GetRegStDTO(String cgId) throws BizException {
		OpRegStDTO[] dTOs = (OpRegStDTO[]) AppFwUtil.getDORstWithDao(new GetRegStDTOQry(cgId), OpRegStDTO.class);
		if (dTOs != null && dTOs.length == 1) {
			dTOs[0].setId_cg(cgId);
		}
		return dTOs[0];
	}
}
