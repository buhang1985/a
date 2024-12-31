package iih.ei.std.consis.v1.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药品货位字典
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class FindDrugLocDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDDEP.CODE AS DISPENSARY, ");
		sql.append("BDMM.CODE AS DRUG_CODE, ");
		sql.append("nvl(BDLOCATION.NAME, '') AS LOCATIONINFO, ");
		// 货位库存不正确
		sql.append("nvl(BDMMWH.LOWSTNUM, '') AS QUANTITY ");
		sql.append("FROM BD_MM_WH BDMMWH ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDMMWH.ID_DEP = BDDEP.ID_DEP ");
		sql.append("LEFT JOIN BD_MM BDMM ");
		sql.append("ON BDMM.ID_MM = BDMMWH.ID_MM ");
		sql.append("LEFT JOIN BD_LOCATION BDLOCATION ");
		sql.append("ON BDLOCATION.ID_LOC = BDMMWH.ID_LOC ");
		return sql.toString();
	}

}
