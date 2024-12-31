package iih.mi.bd.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.s.bp.sql.FindDischargedStatusCompByHisIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据HIS出院状态主键集合查询出院状态对照集合业务逻辑
 * 
 * @author hao_wu 2018-6-21
 *
 */
public class FindDischargedStatusCompByHisIdsBp {

	public DischargedStatusCompDTO[] exec(String hpId, String[] dischargedStatusIds) throws BizException {
		// 参数检验
		if (StringUtil.isEmptyWithTrim(hpId) || ArrayUtil.isEmpty(dischargedStatusIds))
			return null;
		String wherePart = getWherePart(dischargedStatusIds);
		FindDischargedStatusCompByHisIdsSql qry = new FindDischargedStatusCompByHisIdsSql(hpId, wherePart);
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
	private String getWherePart(String[] dischargedStatusIds) {
		StringBuilder wherepartBuilder = new StringBuilder("1 = 1 ");
		String wherePart = SqlUtils.getInSqlByIds("COMP.ID_LEVELDISE", dischargedStatusIds);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherepartBuilder.append(" AND ");
			wherepartBuilder.append(wherePart);
		}
		return wherepartBuilder.toString();
	}

}
