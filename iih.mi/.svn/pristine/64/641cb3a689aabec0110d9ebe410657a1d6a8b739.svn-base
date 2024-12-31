package iih.mi.inst.bizbase.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
@SuppressWarnings("unused")
public class FindZZInExportDrugPagingByQCondSql implements ITransQry {

	private String _wherePart;
	private String _miSrvTp;
	private String _hpId;

	public FindZZInExportDrugPagingByQCondSql(String hpId, String miSrvTp, String wherePart) {
		this._wherePart = wherePart;
		this._miSrvTp = miSrvTp;
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BDMM.CODE AS PROCODE,		 ");
		sqlBuilder.append("   BDMM.CODE AS HISCODE,	 ");
		sqlBuilder.append("   '0'       AS PROTP ,	 ");
		sqlBuilder.append("   BDMM.NAME AS PRONAME,		 ");
		sqlBuilder.append("   BDMM.MNECODE AS MNECODE ");
		sqlBuilder.append(" FROM BD_MM BDMM; 		 ");
		return sqlBuilder.toString();
	}

}
