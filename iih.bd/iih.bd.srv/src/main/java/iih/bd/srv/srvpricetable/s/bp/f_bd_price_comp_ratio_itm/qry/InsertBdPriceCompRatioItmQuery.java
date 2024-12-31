package iih.bd.srv.srvpricetable.s.bp.f_bd_price_comp_ratio_itm.qry;

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
public class InsertBdPriceCompRatioItmQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdPriceCompRatioItmQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_PRICE_COMP_RATIO_ITM ");
		sqlBuilder.append("SELECT ID_SRV,");
		sqlBuilder.append("ID_MM,");
		sqlBuilder.append("ID_UNIT,");
		sqlBuilder.append("ID_PRIPAT,");
		sqlBuilder.append("ID_SRV ID_ITM,");
		sqlBuilder.append("PRICE_STD PRICE_STD_ITM,");
		sqlBuilder.append("RATE RATE_ITM,");
		sqlBuilder.append("PRICE_RATIO PRICE_RATIO_ITM,");
		sqlBuilder.append("1 QUAN_ITM,");
		sqlBuilder.append("1 UNION_MARK ");
		sqlBuilder.append("FROM BD_PRICE_RATIO PR ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PR.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PR.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" where 1 = 2");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("PR.ID_PRIPAT,");
		sqlBuilder.append("COMP.ID_SRV_BL ID_ITM,");
		sqlBuilder.append("PR.PRICE_STD PRICE_STD_ITM,");
		sqlBuilder.append("PR.RATE RATE_ITM,");
		sqlBuilder.append("ROUND(PR.PRICE_RATIO * NVL(COMP.RATIO,1),4) PRICE_RATIO_ITM,");
		sqlBuilder.append("COMP.QUAN QUAN_ITM,");
		sqlBuilder.append("2 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_PRI_SRV_COMP COMP,");
		sqlBuilder.append("BD_PRICE_RATIO PR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '05' ");
		sqlBuilder.append("AND SRV.ID_SRV = COMP.ID_SRV ");
		sqlBuilder.append("AND COMP.ID_SRV_BL = PR.ID_SRV ");
		sqlBuilder.append("AND COMP.ID_MM = PR.ID_MM ");
		sqlBuilder.append("AND COMP.ID_UNIT = PR.ID_UNIT ");
		sqlBuilder.append("AND COMP.DS = 0 ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2");
		}

		return sqlBuilder;
	}
}
