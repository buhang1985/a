package iih.bd.srv.srvpricetable.s.bp.a_bd_srv_pripat_cross.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.srvpricetable.i.IBdSrvPriceTableUpdateService;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 
 * @author hao_wu
 * @date 2020年4月23日
 *
 */
public class InsertBdSrvPriPatCrossQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdSrvPriPatCrossQuery(String condType, String[] condValues) {
		this.condType = condType;
		this.condValues = condValues;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder baseSql = getbaseSql();

		String wherePart = getWherePart();
		baseSql.append(" where ");
		baseSql.append(wherePart);
		return baseSql.toString();
	}

	private StringBuilder getbaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO BD_SRV_PRIPAT_CROSS ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("PRIPAT.ID_PRIPAT,");
		sqlBuilder.append("PRIPAT.RATE ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_PRI_PAT PRIPAT ");
		return sqlBuilder;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("SRV.FG_BL = 'Y' AND SRV.FG_MM = 'N'");
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("srv.id_srv", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("PRIPAT.id_pripat", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			wherePartBuilder.append(" and 1 = 2");
		}
		return wherePartBuilder.toString();
	}
}
