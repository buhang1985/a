package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 药局基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPharmacyDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDDEP.ID_DEP CKID, ");
		sql.append("BDDEP.CODE CKBH, ");
		sql.append("BDDEP.NAME CKNAME, ");
		sql.append("BDUDIDOC.NAME CLASS_NO,	");
		sql.append("'是' BEACTIVE, ");
		sql.append("BDDEP.DES NOTE ");
		sql.append("FROM BD_DEP BDDEP ");
		sql.append("LEFT JOIN BD_UDIDOC BDUDIDOC ");
		sql.append("ON BDDEP.ID_DEPTTP = BDUDIDOC.ID_UDIDOC ");
		sql.append("WHERE bddep.SD_DEPTTP LIKE '04%'");
		return sql.toString();
	}

}
