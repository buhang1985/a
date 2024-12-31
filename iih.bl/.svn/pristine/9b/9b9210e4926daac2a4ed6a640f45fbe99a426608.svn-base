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

/**
 * 批量获取门诊挂号結算信息
 * 
 * @author yanglu
 *
 */
public class BatchGetOpRegStInfoBP {
	/**
	 * 批量获取门诊挂号結算信息
	 * 
	 * @param cgIds
	 *            记账id集合
	 * @return DTO集合
	 * @throws BizException
	 * @author yankan
	 * @author yanglu
	 */
	public OpRegStDTO[] exec(String[] cgIds) throws BizException {
		// 1、查询结算信息
		OpRegStDTO[] stDTO = GetRegStDTO(cgIds);
		// 2、查询支付明细信息
		OpPayItmDTO[] payItms = GetPayItems(cgIds);

		for (OpPayItmDTO itm : payItms) {
			for (OpRegStDTO st : stDTO) {
				if (itm.getId_pay().equals(st.getId_pay())) {
					if (st.getPayitm_list() == null) {
						st.setPayitm_list(new FArrayList());
					}
					st.getPayitm_list().add(itm);
					break;
				}
			}
		}
		return stDTO;
	}

	/**
	 * 查询结算信息
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	private OpRegStDTO[] GetRegStDTO(String[] cgIds) throws BizException {
		OpRegStDTO[] dTOs = (OpRegStDTO[]) AppFwUtil.getDORstWithDao(new GetRegStDTOQry(cgIds), OpRegStDTO.class);

		return dTOs;
	}

	/**
	 * 获取收付款明细集合
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	public OpPayItmDTO[] GetPayItems(String[] cgIds) throws BizException {
		OpPayItmDTO[] dTOs = (OpPayItmDTO[]) AppFwUtil.getDORstWithDao(new GetPayItmListByCgIdQry(cgIds), OpPayItmDTO.class);
		return dTOs;
	}
}
