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
public class FindExportDrugPagingByQCondSql implements ITransQry {

	private String _wherePart;
	private String _idHp;
	private String _miSrvTp;

	public FindExportDrugPagingByQCondSql(String id_hp, String miSrvTp, String wherePart) {
		this._wherePart = wherePart;
		this._idHp = id_hp;
		this._miSrvTp = miSrvTp;
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
		String wherePart = String.format("id_hp = '%s'", this._idHp);
		wherePartBuilder.append(wherePart);

		if (this._miSrvTp.equals(String.valueOf(MiSrvTp.DRUG))) {
			wherePartBuilder.append(" AND ");
			wherePart = String.format("eu_hpsrvtp = '%s'", HpSrvTpEnum.DRUG);
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
		sqlBuilder.append(" SELECT ");
		sqlBuilder.append("   BDMM.CODE, ");
		sqlBuilder.append(" BDMM.CODE AS HIS_CODE, 	");
		sqlBuilder.append(
				"  (CASE WHEN BDSRVORCA.EU_HPSRVTP = 1 THEN 0 WHEN BDSRVORCA.EU_HPSRVTP = 2 THEN 1 END) AS EU_HPSRVTP, ");
		sqlBuilder.append("   BDMM.NAME,");
		sqlBuilder.append("   BDMM.MNECODE AS MM_MNECODE,");
		sqlBuilder.append("   BDMM.SPEC AS MM_SPEC");
		sqlBuilder.append(" FROM BD_HP_SRVORCA BDSRVORCA ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_MM BDMM	      ");
		sqlBuilder.append(" ON BDMM.ID_MM = BDSRVORCA.ID_MM   ");
		return sqlBuilder.toString();
	}

}
