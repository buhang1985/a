package iih.ei.std.consis.v1.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药房药师字典
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class FindPharmacyPsnDicQry implements ITransQry {

	/**
	 * 药房主键
	 */
	private String _pharmacyId;

	public FindPharmacyPsnDicQry(String pharmacyId) {
		this._pharmacyId = pharmacyId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._pharmacyId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("BDPSNDOC.CODE STAFFERID, ");
		sql.append("BDDEP.CODE DEPTCODE, ");
		sql.append("BDPSNDOC.NAME STAFFERNAME ");
		sql.append("FROM BD_PSNDOC BDPSNDOC	");
		sql.append("INNER JOIN BD_DEP BDDEP ");
		sql.append("ON BDPSNDOC.ID_DEP = BDDEP.ID_DEP ");
		sql.append("WHERE BDPSNDOC.SD_EMPWKTP = '04' ");
		sql.append("AND BDPSNDOC.CODE IS NOT NULL ");
		sql.append("AND BDPSNDOC.NAME IS NOT NULL ");
		sql.append("AND BDDEP.ID_DEP = ? ");

		return sql.toString();
	}

}
