package iih.bd.srv.srvpricetable.s.bp.e_bd_price_ratio.qry;

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
public class InsertBdPriceRatioQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdPriceRatioQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_PRICE_RATIO ");
		sqlBuilder.append("SELECT PRIRATE.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("PRIRATE.ID_PRIPAT,");
		sqlBuilder.append("PRIRATE.PRICE_STD PRICE_STD,");
		sqlBuilder.append("CASE ");
		sqlBuilder.append("WHEN PRIRATE.RATEMD IS NULL ");
		sqlBuilder.append("THEN PRIRATE.CARATE ");
		sqlBuilder.append("WHEN PRIRATE.RATEMD = 1 ");
		sqlBuilder.append("AND PRIRATE.PRICE_STD <> 0 ");
		sqlBuilder.append("THEN PRIRATE.ITMPRI / PRIRATE.PRICE_STD ");
		sqlBuilder.append("WHEN PRIRATE.RATEMD = 1 ");
		sqlBuilder.append("AND PRIRATE.PRICE_STD = 0 ");
		sqlBuilder.append("THEN -1 ");
		sqlBuilder.append("ELSE PRIRATE.ITMRATE ");
		sqlBuilder.append("END RATE,");
		sqlBuilder.append("CASE ");
		sqlBuilder.append("WHEN PRIRATE.RATEMD IS NULL ");
		sqlBuilder.append("THEN ROUND(PRIRATE.PRICE_STD * PRIRATE.CARATE,4) ");
		sqlBuilder.append("WHEN PRIRATE.RATEMD = 1 ");
		sqlBuilder.append("THEN PRIRATE.ITMPRI ");
		sqlBuilder.append("ELSE ROUND(PRIRATE.PRICE_STD * PRIRATE.ITMRATE,4) ");
		sqlBuilder.append("END PRICE_RATIO,");
		sqlBuilder.append("1 UNION_MARK ");
		sqlBuilder.append("FROM BD_PRICE_RATIO_TMP PRIRATE ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PRIRATE.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PRIRATE.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" where 1 = 2");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT MM.ID_SRV,");
		sqlBuilder.append("MM.ID_MM,");
		sqlBuilder.append("MM.ID_UNIT,");
		sqlBuilder.append("MM.ID_PRIPAT,");
		sqlBuilder.append("MM.PRICE,");
		sqlBuilder.append("MM.RATE,");
		sqlBuilder.append("MM.PRICE PRICE_RATIO,");
		sqlBuilder.append("2 UNION_MARK ");
		sqlBuilder.append("FROM BD_MM_PRIPAT_CROSS MM ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("MM.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("MM.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("MM.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" where 1 = 2");
		}

		return sqlBuilder;
	}
}
