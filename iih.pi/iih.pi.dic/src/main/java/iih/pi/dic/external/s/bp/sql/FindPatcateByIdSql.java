package iih.pi.dic.external.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindPatcateByIdSql implements ITransQry {

	private String _patId;

	public FindPatcateByIdSql(String patId) {
		this._patId = patId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._patId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getBaseSql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PIPATCA.CODE,			       ");
		sql.append("  PIPATCA.NAME,				       ");
		sql.append("  PATHPCA.ID_HP,				       ");
		sql.append("  BDHP.NAME AS NAME_HP,			       ");
		sql.append("  BDHP.CODE AS CODE_HP,			       ");
		sql.append("  HPPATSOURCE.NAME AS NAME_HPPATSOURCE,	       ");
		sql.append("  HPPATSOURCE.CODE AS CODE_HPPATSOURCE,	       ");
		sql.append("  PIPATCA.ID_PATPRITP,			       ");
		sql.append("  BDPRIPAT.NAME AS NAME_PATPRITP,		       ");
		sql.append("  BDPRIPAT.CODE AS CODE_PATPRITP		       ");
		sql.append(" FROM PI_PAT_CA PIPATCA			       ");
		sql.append(" LEFT JOIN PI_PAT_CA_HP PATHPCA ON PIPATCA.ID_PATCA=PATHPCA.ID_PATCA");
		sql.append(" LEFT OUTER JOIN BD_HP BDHP			       ");
		sql.append(" ON BDHP.ID_HP = PATHPCA.ID_HP		       ");
		sql.append(" LEFT OUTER JOIN BD_UDIDOC HPPATSOURCE	       ");
		sql.append(" ON HPPATSOURCE.ID_UDIDOC = PATHPCA.ID_HPPATSOURCE ");
		sql.append(" LEFT OUTER JOIN BD_PRI_PAT BDPRIPAT	       ");
		sql.append(" ON PIPATCA.ID_PATPRITP = BDPRIPAT.ID_PRIPAT     ");
		return sql.toString();
	}

	private String getWherePart() {
		StringBuilder sql = new StringBuilder(" 1 = 1 ");
		if(StringUtils.isNotEmpty(this._patId)) {
			sql.append(" AND ");
			sql.append(" PIPATCA.ID_PATCA = ? ");
		}
		return sql.toString();
	}

}
