package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 科室基本信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDeptDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDDEP.CODE DEPARTMENT_NO, ");
		sql.append("BDDEP.NAME DEPARTMENTNAME, ");
		sql.append("BDUDIDOC.NAME CLASS_NO ");
		sql.append("FROM BD_DEP BDDEP ");
		sql.append("LEFT JOIN BD_UDIDOC BDUDIDOC ");
		sql.append("ON BDDEP.ID_DEPTTP = BDUDIDOC.ID_UDIDOC");
		return sql.toString();
	}

}
