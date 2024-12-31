package iih.bl.cg.bp.ip.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpCgSumInfoByEntIdQry implements ITransQry {

	String entId;

	public GetIpCgSumInfoByEntIdQry(String entId) {
		this.entId = entId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  "); 
		sql.append("cgip.Id_or ID_OR, ");
		sql.append("cgip.id_srv id_srv, ");
		sql.append(" name_srv Content_or, ");
		sql.append("'已记账' name_su_bl, ");
		sql.append("SUM(cgip.Amt_ratio) amt_ratio  ");
		sql.append(" FROM BL_CG_IP cgip ");
		sql.append("LEFT JOIN	BL_ST_IP stip ON stip.id_stip=cgip.id_stip ");
		sql.append("WHERE cgip.ID_ENT=? ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append("AND cgip.id_or='~' ");
		sql.append("AND NVL(stip.FG_CANC, 'N')='N' ");
		sql.append("AND NVL(STIP.EU_DIRECT, '1')='1' ");
		sql.append("GROUP BY( ");
		sql.append("cgip.Id_or,  ");
		sql.append(" id_srv, name_srv, ");
		sql.append("'已记账' ");
		sql.append(")  ");
		return sql.toString();
	}
}