package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 药局(房)库存基本信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindPharmStockDicQry implements ITransQry{

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDMM.CODE SPID, ");
		sql.append("BDDEP.CODE CKID, ");
		sql.append("BDSUP.NAME SHENGCCJ, ");
		sql.append("'是' IS_HEGE, ");
		sql.append("MAXSTNUM KCSX, ");
		sql.append("LOWSTNUM KCXX ");
		sql.append("FROM BD_MM_WH BDMMWH  ");
		sql.append("LEFT JOIN BD_MM BDMM ");
		sql.append("ON BDMMWH.ID_MM = BDMM.ID_MM ");
		sql.append("LEFT JOIN BD_WH BDWH ");
		sql.append("ON BDWH.ID_WH = BDMMWH.ID_WH ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON BDDEP.ID_DEP = BDWH.ID_DEP_BELONG ");
		sql.append("LEFT JOIN BD_SUP BDSUP ");
		sql.append("ON BDMM.ID_SUP = BDSUP.ID_SUP ");
		sql.append("WHERE BDDEP.ID_DEP = '0001Z8100000000007NJ' ");
		return sql.toString();
	}

}
