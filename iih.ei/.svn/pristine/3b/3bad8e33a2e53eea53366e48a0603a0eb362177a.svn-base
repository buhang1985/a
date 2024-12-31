package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医生基本信息
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDoctorDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDPSNDOC.CODE DOCTOR_NO, ");
		sql.append("BDPSNDOC.NAME DOCTOR_NAME, ");
		sql.append("BDDEP.CODE DEPARTMENT_NO, ");
		sql.append("BDDEP.NAME DEPARTMENTNAME, ");
		sql.append("BDPSNDOC.DES BEIZHU ");
		sql.append("FROM BD_PSNDOC BDPSNDOC ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDPSNDOC.ID_DEP = BDDEP.ID_DEP ");
		sql.append("WHERE BDPSNDOC.SD_EMPWKTP = '04'");
		return sql.toString();
	}

}
