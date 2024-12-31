package iih.mi.inst.bizbase.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
@SuppressWarnings("unused")
public class FindZZInExportTreatPagingByQCondSql implements ITransQry{
	
	private String _wherePart;
	private String _miSrvTp;
	private String _id_hp;
	
	public FindZZInExportTreatPagingByQCondSql(String id_hp, String miSrvTp, String wherePart) {
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
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {	
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BDSRV.CODE AS PROCODE,		      ");
		sqlBuilder.append("   BDSRV.CODE      AS HISCODE,		      ");
		sqlBuilder.append("   '1'             AS PROTP ,		      ");
		sqlBuilder.append("   BDSRV.NAME      AS PRONAME ,		      ");
		sqlBuilder.append("   BDSRV.MNECODE   AS MNECODE ,		      ");
		sqlBuilder.append("   HPFEECA.CODE	  AS FEETP			      ");
		sqlBuilder.append(" FROM BD_SRV BDSRV				      ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_INCCA_ITM_REL INCCAITMREL      ");
		sqlBuilder.append(" ON BDSRV.ID_SRV = INCCAITMREL.ID_SRV	      ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_INCCA_ITM INCCAITM	      ");
		sqlBuilder.append(" ON INCCAITM.ID_INCCAITM = INCCAITMREL.ID_INCCAITM ");
		sqlBuilder.append(" LEFT OUTER JOIN BD_HP_FEECA HPFEECA		      ");
		sqlBuilder.append(" ON HPFEECA.ID_INCCA_OEP = INCCAITM.ID_INCCAITM   ");
		return sqlBuilder.toString();
	}

}
