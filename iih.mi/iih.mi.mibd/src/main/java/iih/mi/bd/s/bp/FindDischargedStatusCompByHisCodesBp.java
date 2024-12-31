package iih.mi.bd.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.s.bp.sql.FindDischargedStatusCompByHisCodesSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS出院状态编码集合查询出院状态对照集合业务逻辑
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class FindDischargedStatusCompByHisCodesBp {

	public DischargedStatusCompDTO[] exec(String hpId, String[] dischargedStatusCodes) throws BizException {
		// 参数检验
		if (StringUtil.isEmptyWithTrim(hpId) || ArrayUtil.isEmpty(dischargedStatusCodes))
			return null;
		String wherePart = getWherePart(dischargedStatusCodes);
		FindDischargedStatusCompByHisCodesSql qry = new FindDischargedStatusCompByHisCodesSql(hpId, wherePart);
		DischargedStatusCompDTO[] result = (DischargedStatusCompDTO[]) AppFwUtil.getDORstWithDao(qry,
				DischargedStatusCompDTO.class);
		if (ArrayUtil.isEmpty(result))
			return null;

		return result;
	}

	/**
	 * 生成条件
	 * 
	 * @param regionCodes
	 * @return
	 */
	private String getWherePart(String[] dischargedStatusCodes) {
		StringBuilder wherepartBuilder = new StringBuilder("1 = 1 ");
		String wherePart = SqlUtils.getInSqlByIds("LEVELDISE.CODE", dischargedStatusCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherepartBuilder.append(" AND ");
			wherepartBuilder.append(wherePart);
		}
		return wherepartBuilder.toString();
	}
}
