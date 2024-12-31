package iih.mi.inst.bizbase.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.mi.biz.dto.d.MiSrvTp;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindExportTreatPagingByQCondSql implements ITransQry {

	private String _wherePart;
	private String _miSrvTp;
	private String _id_hp;

	public FindExportTreatPagingByQCondSql(String id_hp, String miSrvTp, String wherePart) {
		this._wherePart = wherePart;
		this._miSrvTp = miSrvTp;
		this._id_hp = id_hp;
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

		wherePartBuilder.append(" AND ");
		String wherePart = String.format("id_hp = '%s'", this._id_hp);
		wherePartBuilder.append(wherePart);

		if (this._miSrvTp.equals(String.valueOf(MiSrvTp.TREAT))) {
			wherePartBuilder.append(" AND ");
			wherePart = String.format("eu_hpsrvtp = '%s'", HpSrvTpEnum.ZL);
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}

		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BDSRV.CODE,	");
		sqlBuilder.append(" BDSRV.CODE AS HIS_CODE, 	");
		sqlBuilder.append("   (					");
		sqlBuilder.append("   CASE				");
		sqlBuilder.append("     WHEN BDSRVORCA.EU_HPSRVTP = 1	");
		sqlBuilder.append("     THEN 0				");
		sqlBuilder.append("     WHEN BDSRVORCA.EU_HPSRVTP = 2	");
		sqlBuilder.append("     THEN 1				");
		sqlBuilder.append("   END) AS EU_HPSRVTP ,		");
		sqlBuilder.append("   BDSRV.NAME,		");
		sqlBuilder.append("   BDSRV.MNECODE AS MM_MNECODE");
		sqlBuilder.append(" FROM BD_HP_SRVORCA BDSRVORCA	");
		sqlBuilder.append(" LEFT OUTER JOIN BD_SRV BDSRV	");
		sqlBuilder.append(" ON BDSRV.ID_SRV = BDSRVORCA.ID_SRV	");
		return sqlBuilder.toString();
	}

}
