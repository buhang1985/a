package iih.mi.inst.bizbase.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindPagingByQCondSql implements ITransQry {

	private String _wherePart;
	private String _HpId;
	private String _IdRef;

	public FindPagingByQCondSql(String IdRef, String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._HpId = hpId;
		this._IdRef = IdRef;
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
		String wherePart;
		if (this._IdRef == null) {
			wherePart = String.format("id_hp = '%s'", this._HpId);
		} else {
			wherePart = String.format("id_hp = '%s'", this._IdRef);
		}
		wherePartBuilder.append(wherePart);

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT SRVORCA.EU_STATUS,		       ");
		sqlBuilder.append("   SRV.NAME AS SRV_NAME,		       ");
		sqlBuilder.append("   MM.NAME AS MM_NAME,		       ");
		sqlBuilder.append("   SRVORCA.CODE,			       ");
		sqlBuilder.append("   SRVORCA.NAME,			       ");
		sqlBuilder.append("   SRVORCA.CODE_DOSAGE,		       ");
		sqlBuilder.append("   MM.PRICE,				       ");
		sqlBuilder.append("   SRVTP.NAME AS HPSRVTP_NAME,	       ");
		sqlBuilder.append("   SRVORCA.CODE_CA,			       ");
		sqlBuilder.append("   SRVORCA.DES			       ");
		sqlBuilder.append(" FROM BD_HP_SRVORCA SRVORCA		       ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_SRV SRV		       ");
		sqlBuilder.append(" ON SRVORCA.ID_SRV = SRV.ID_SRV	       ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_MM MM		       ");
		sqlBuilder.append(" ON SRVORCA.ID_MM = MM.ID_MM		       ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_UDIDOC SRVTP	       ");
		sqlBuilder.append(" ON SRVORCA.ID_HPSRVTP = SRVTP.ID_UDIDOC;");
		return sqlBuilder.toString();
	}

}
