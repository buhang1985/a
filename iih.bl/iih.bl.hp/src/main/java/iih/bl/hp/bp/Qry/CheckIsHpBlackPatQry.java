package iih.bl.hp.bp.Qry;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CheckIsHpBlackPatQry implements ITransQry {

	String hpId;
	String insurNo;

	public CheckIsHpBlackPatQry(String hpId, String insurNo) {
		this.hpId = hpId;
		this.insurNo = insurNo;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.hpId);
		param.addParam(this.insurNo);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();

		sb.append("	SELECT	* FROM 	BL_HP_PAT_BLACKLIST ");
		sb.append(" WHERE ");
		sb.append("	ID_HP = ?   ");
		sb.append(" AND INSUR_NO = ?         ");
		sb.append(" AND (dt_begin <= TO_CHAR ( SYSDATE, 'yyyy-mm-dd hh24:mi:ss' ) ");
		sb.append("     OR dt_begin IS NULL) ");
		sb.append(" AND (                             ");
		sb.append("	dt_end >= TO_CHAR (              ");
		sb.append("		SYSDATE,                     ");
		sb.append("		'yyyy-mm-dd hh24:mi:ss'      ");
		sb.append("	)                                ");
		sb.append("	OR dt_end IS NULL                ");
		sb.append(")                                 ");
		return sb.toString();
	}

}
