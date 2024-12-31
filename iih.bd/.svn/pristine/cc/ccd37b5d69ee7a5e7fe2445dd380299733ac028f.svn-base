package iih.bd.res.bed.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据床位主键集合查询床位费
 * 
 * @author hao_wu
 *
 */
public class FindBedPriByBedIdsSql implements ITransQry {

	private String[] _bedIds;

	public FindBedPriByBedIdsSql(String[] bedIds) {
		this._bedIds = bedIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new Bdbed(), "BED");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (_bedIds != null && _bedIds.length > 0) {
			wherePart = SqlUtils.getInSqlByIds(Bdbed.ID_BED, this._bedIds);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BED.ID_BED,					       ");
		sqlBuilder.append("   PRITPL.PRICE					       ");
		sqlBuilder.append(" FROM BD_BED BED					       ");
		sqlBuilder.append(" LEFT JOIN						       ");
		sqlBuilder.append("   (SELECT BLTPL.ID_BLTPL,				       ");
		sqlBuilder.append("     SUM(BLTPLITM.QUAN_MEDU * NVL(VPRICE.PRICE_STD,0)) PRICE");
		sqlBuilder.append("   FROM BD_BLTPL BLTPL				       ");
		sqlBuilder.append("   INNER JOIN BD_BLTPL_ITM BLTPLITM			       ");
		sqlBuilder.append("   ON BLTPL.ID_BLTPL = BLTPLITM.ID_BLTPL		       ");
		sqlBuilder.append("   LEFT JOIN						       ");
		sqlBuilder.append("     (SELECT ID_SRV,PRICE_RATIO AS PRICE_STD FROM VIEW_PRICE_RP  where ID_PRIPAT = '@@@@Z8100000002YL8PO'  ");
		sqlBuilder.append("     ) VPRICE					       ");
		sqlBuilder.append("   ON BLTPLITM.ID_SRV = VPRICE.ID_SRV		       ");
		sqlBuilder.append("   WHERE 1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new BdBlTplDO(), "BLTPL");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new BdBltplItmDO(), "BLTPLITM");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append("   GROUP BY BLTPL.ID_BLTPL				       ");
		sqlBuilder.append("   ) PRITPL ON BED.ID_BLTPL = PRITPL.ID_BLTPL	       ");
		return sqlBuilder.toString();
	}

}
