package iih.bd.srv.srvpricetable.s.bp.d_bd_mm_pripat_cross.qry;

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
public class InsertBdMmPriPatCrossQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdMmPriPatCrossQuery(String condType, String[] condValues) {
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
		return baseSql.toString();
	}

	private StringBuilder getbaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO BD_MM_PRIPAT_CROSS ");
		sqlBuilder.append("SELECT PRI.ID_SRV,");
		sqlBuilder.append("PRI.ID_MM,");
		sqlBuilder.append("PRI.PRICE,");
		sqlBuilder.append("PRI.ID_UNIT,");
		sqlBuilder.append("PRIPAT.ID_PRIPAT,");
		sqlBuilder.append("1 RATE ");
		sqlBuilder.append("FROM BD_MM_PRICE_PKG PRI,");
		sqlBuilder.append("BD_PRI_PAT PRIPAT ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PRI.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PRI.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PRIPAT.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" where 1 = 2");
		}

		return sqlBuilder;
	}
}
