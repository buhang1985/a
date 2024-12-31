package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 在院病人床位基本信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPatBedDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PIPAT.CODE PATIENT_ID, ");
		sql.append("1 VISIT_ID, ");
		sql.append("BDDEP.CODE DEPARTMENT_NO, ");
		sql.append("BDBED.CODE BED, ");
		sql.append("BDBED.NAME BEDNAME ");
		sql.append("FROM PI_PAT PIPAT ");
		sql.append("JOIN EN_ENT ENENT ");
		sql.append("ON ENENT.ID_PAT = PIPAT.ID_PAT ");
		sql.append("JOIN EN_ENT_IP ENENTIP ");
		sql.append("ON ENENTIP.ID_ENT = ENENT.ID_ENT ");
		sql.append("LEFT JOIN BD_BED BDBED ");
		sql.append("ON ENENTIP.ID_BED = BDBED.ID_BED ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDDEP.ID_DEP = ENENT.ID_DEP_NUR ");
		sql.append("WHERE PIPAT.FG_INVD  = 'N' AND ENENT.FG_IP  = 'Y'");
		return sql.toString();
	}

}
