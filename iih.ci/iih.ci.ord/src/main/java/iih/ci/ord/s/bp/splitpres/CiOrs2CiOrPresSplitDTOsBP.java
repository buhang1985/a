package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetOrderDrugsSplitDateNewQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 分方医嘱格式化为分方数据DTO操作BP
 */
public class CiOrs2CiOrPresSplitDTOsBP {
	/**
	 * 分方医嘱格式化为分方数据DTO
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public OrderPresSplitDTO[] exec(CiOrderDO[] ciors)throws BizException{
		//获得医嘱集合对应的ID_or主键标识sql串片段
		String id_ors = getIdOrsSqlStr(ciors);
		if (CiOrdUtils.isEmpty(id_ors))
			return null;

		//获得查询结果并返回
		GetOrderDrugsSplitDateNewQry qry = new GetOrderDrugsSplitDateNewQry(ciors[0].getId_en(), id_ors,
				ciors[0].getCode_entp());
		OrderPresSplitDTO[] rtn = (OrderPresSplitDTO[]) AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);
		return rtn;
	}
	
	/**
	 * 获得医嘱集合对应的ID_or主键标识sql串片段
	 * @param ciors
	 * @return
	 */
	protected String getIdOrsSqlStr(CiOrderDO[] ciors){
		if (ciors == null || ciors.length == 0)
			return null;
		StringBuilder builder = new StringBuilder();
		Boolean first = true;
		for (CiOrderDO ci : ciors) {
			if (first) {
				first = false;
			} else {
				builder.append(',');
			}
			builder.append(String.format("'%s'", ci.getId_or()));
		}

		return builder.toString();
	}
	

	
}
