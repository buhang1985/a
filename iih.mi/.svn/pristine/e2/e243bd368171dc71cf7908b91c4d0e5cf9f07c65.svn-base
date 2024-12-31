package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.mis.d.MisDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据HIS剂型主键集合查询剂型基础信息集合sql语句
 * 
 * @author hexx
 *
 */
public class FindDosagesByHisDosageIdsSql implements ITransQry {

	private String _wherePart;

	public FindDosagesByHisDosageIdsSql(String misId, String wherePart) {
		this._wherePart = wherePart;

	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		return null;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new MisDO(), "MI_BD_MIS");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}

		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select id_midosage,");
		sqlBuilder.append(" id_grp,	       ");
		sqlBuilder.append(" id_org,	       ");
		sqlBuilder.append(" code,	       ");
		sqlBuilder.append(" name,	       ");
		sqlBuilder.append(" id_dosage,	       ");
		sqlBuilder.append(" id_mis 	       ");
		sqlBuilder.append(" from MI_BD_DOSAGE ");
		sqlBuilder.append(" WHERE ID_MIS = ?  ");
		return sqlBuilder.toString();
	}
}
