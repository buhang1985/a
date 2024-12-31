package iih.bd.srv.srvpricetable.s.bp.h_bd_price_rp.qry;

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
public class InsertBdPriceRpQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdPriceRpQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_PRICE_RP ");
		sqlBuilder.append("SELECT RPITM.ID_SRV,");
		sqlBuilder.append("RPITM.ID_MM,");
		sqlBuilder.append("RPITM.ID_UNIT,");
		sqlBuilder.append("RPITM.ID_PRIPAT,");
		sqlBuilder.append("SUM(RPITM.PRICE_STD_ITM * RPITM.QUAN_ITM) PRICE_STD,");
		sqlBuilder.append("CASE ");
		sqlBuilder.append("WHEN SUM(RPITM.PRICE_STD_ITM * RPITM.QUAN_ITM) <> 0 ");
		sqlBuilder.append(
				"THEN SUM(RPITM.PRICE_RATIO_ITM * RPITM.QUAN_ITM) / SUM(RPITM.PRICE_STD_ITM * RPITM.QUAN_ITM) ");
		sqlBuilder.append("ELSE 1 ");
		sqlBuilder.append("END RATE,");
		sqlBuilder.append("SUM(RPITM.PRICE_RATIO_ITM * RPITM.QUAN_ITM) PRICE_RATIO ");
		sqlBuilder.append("FROM BD_PRICE_RP_ITM RPITM ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("RPITM.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("RPITM.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("RPITM.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2");
		}

		sqlBuilder.append("GROUP BY RPITM.ID_SRV,");
		sqlBuilder.append("RPITM.ID_MM,");
		sqlBuilder.append("RPITM.ID_UNIT,");
		sqlBuilder.append("RPITM.ID_PRIPAT");

		return sqlBuilder;
	}
}
