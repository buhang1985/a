package iih.bd.mhi.hpfeeca.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.incca.d.IncCaItmDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 费别对照SQL
 * 
 * @author dj.zhang
 *
 */
public class FindFeecaPagingByHpIdSql implements ITransQry {

	private String _hpId;
	private String _wherePart;

	public FindFeecaPagingByHpIdSql(String hpId) {
		this._hpId = hpId;
	}

	public FindFeecaPagingByHpIdSql(String hpId, String wherePart) {
		this._hpId = hpId;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		String org = EnvContextUtil.processEnvContext("", new IncCaItmDO(), "BDINCCAITM");
		if(StringUtils.isNotBlank(org)){
			return String.format("%s WHERE %s and %s", sql, wherePart,org);
		}
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDHPFEECA.ID_HP, ");
		sql.append("BDHPFEECA.CODE CODE_HP, ");
		sql.append("BDHPFEECA.NAME NAME_HP, ");
		sql.append("BDHPFEECA.ID_PAR, ");
		sql.append("BDHPFEECA.ID_HPFEECA, ");
		sql.append("BDHPFEECA.CREATEDBY, ");
		sql.append("BDHPFEECA.CREATEDTIME, ");
		sql.append("BDHPFEECA.MODIFIEDBY, ");
		sql.append("BDHPFEECA.MODIFIEDTIME, ");
		sql.append("BDHPFEECA.SV, ");
		sql.append("BDHPFEECAPAR.NAME NAME_PAR,  ");
		sql.append("BDINCCA.ID_INCCA, ");
		sql.append("BDINCCA.NAME NAME_INCCA, ");
		sql.append("BDINCCAITM.ID_INCCAITM, ");
		sql.append("BDINCCAITM.CODE CODE_INCCAITM, ");
		sql.append("BDINCCAITM.NAME NAME_INCCAITM ");
		sql.append("FROM BD_INCCA_ITM BDINCCAITM ");
		sql.append("JOIN BD_INCCA BDINCCA  ");
		sql.append("ON BDINCCAITM.ID_INCCA = BDINCCA.ID_INCCA ");
		sql.append("LEFT JOIN BD_HP_FEECA BDHPFEECA ");
		sql.append("ON BDHPFEECA.ID_INCCAITM = BDINCCAITM.ID_INCCAITM ");
		sql.append("and BDHPFEECA.ID_HP = ? ");
		sql.append("LEFT JOIN BD_HP_FEECA BDHPFEECAPAR ");
		sql.append("ON BDHPFEECAPAR.ID_HPFEECA = BDHPFEECA.ID_PAR ");
		sql.append("and BDHPFEECA.ID_HP = ? ");
		return sql.toString();
	}

}
