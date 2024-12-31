package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindHpFeecaByCodesSql implements ITransQry {

	private String _hpId;
	private String _wherePart;

	public FindHpFeecaByCodesSql(String hpId, String wherePart) {
		this._hpId = hpId;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpFeecaDO(), "BD_HP_FEECA");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._hpId)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(" ID_HP = ? ");
		}

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_HP_FEECA.ID_HPFEECA AS ID_FEECA,     ");
		sqlBuilder.append("   BD_HP_FEECA.ID_GRP,			     ");
		sqlBuilder.append("   BD_HP_FEECA.ID_ORG,			     ");
		sqlBuilder.append("   BD_HP_FEECA.CODE AS CODE,		     ");
		sqlBuilder.append("   BD_HP_FEECA.NAME AS NAME,		     ");
		sqlBuilder.append("   BD_HP_FEECA.ID_HP,			     ");
		sqlBuilder.append("   INCCAB.CODE AS IP_NAME		     ");
		sqlBuilder.append(" FROM BD_HP_FEECA		     ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_INCCA_ITM INCCAB	     ");
		sqlBuilder.append(" ON INCCAB.ID_INCCAITM = BD_HP_FEECA.ID_INCCA_IP;");
		return sqlBuilder.toString();
	}

}
