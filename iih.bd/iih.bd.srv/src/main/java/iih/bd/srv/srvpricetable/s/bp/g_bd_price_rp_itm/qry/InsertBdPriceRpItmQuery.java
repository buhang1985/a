package iih.bd.srv.srvpricetable.s.bp.g_bd_price_rp_itm.qry;

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
public class InsertBdPriceRpItmQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdPriceRpItmQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_PRICE_RP_ITM ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SRVSET.ID_SRV_ITM ID_SRV_ITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("SRVSET.QUAN_MEDU * PCR.QUAN_ITM QUAN_ITM,");
		sqlBuilder.append("11 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_SRVSET_DEF SRVSET,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '01' ");
		sqlBuilder.append("AND SRV.ID_SRV = SRVSET.ID_SRV ");
		sqlBuilder.append("AND SRVSET.FG_CLINICAL = 'N' ");
		sqlBuilder.append("AND SRVSET.ID_SRV_ITM = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SRVSET.ID_SRV_ITM ID_SRV_ITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("SRVSET.QUAN_MEDU * PCR.QUAN_ITM QUAN_ITM,");
		sqlBuilder.append("12 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_SRVSET_DEF SRVSET,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '01' ");
		sqlBuilder.append("AND SRV.ID_SRV = SRVSET.ID_SRV ");
		sqlBuilder.append("AND SRVSET.FG_CLINICAL = 'Y' ");
		sqlBuilder.append("AND SRVSET.FG_EDIT = 'N' ");
		sqlBuilder.append("AND SRVSET.ID_SRV_ITM = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SRVSET.ID_SRV_ITM ID_SRVITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("SRVSET.QUAN_MEDU * PCR.QUAN_ITM QUAN_ITM,");
		sqlBuilder.append("2 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_SRVSET_DEF SRVSET,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '02' ");
		sqlBuilder.append("AND SRV.ID_SRV = SRVSET.ID_SRV ");
		sqlBuilder.append("AND SRVSET.FG_CLINICAL = 'N' ");
		sqlBuilder.append("AND SRVSET.ID_SRV_ITM = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SETMU.ID_SRVADD ID_SRV_ITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("PCR.QUAN_ITM,");
		sqlBuilder.append("3 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_PRI_SRV_SETMU SETMU,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '02' ");
		sqlBuilder.append("AND SRV.ID_SRV = SETMU.ID_SRVSET ");
		sqlBuilder.append("AND SRV.SETITMCHKNUM >= SETMU.QUAN_MIN ");
		sqlBuilder.append("AND SRV.SETITMCHKNUM <= SETMU.QUAN_MAX ");
		sqlBuilder.append("AND SETMU.ID_SRVADD = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SRVSET.ID_SRV_ITM ID_SRVITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("SRVSET.QUAN_MEDU * PCR.QUAN_ITM QUAN_ITM,");
		sqlBuilder.append("4 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_SRVSET_DEF SRVSET,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '03' ");
		sqlBuilder.append("AND SRV.ID_SRV = SRVSET.ID_SRV ");
		sqlBuilder.append("AND SRVSET.FG_CLINICAL = 'N' ");
		sqlBuilder.append("AND SRVSET.ID_SRV_ITM = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("'~' ID_MM,");
		sqlBuilder.append("'~' ID_UNIT,");
		sqlBuilder.append("SETFIX.ID_SRVADD ID_SRV_ITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("PCR.QUAN_ITM,");
		sqlBuilder.append("5 UNION_MARK ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_PRI_SRV_SETFIX SETFIX,");
		sqlBuilder.append("BD_PRICE_COMP_RATIO_ITM PCR ");
		sqlBuilder.append("WHERE SRV.SD_PRIMD = '03' ");
		sqlBuilder.append("AND SRV.ID_SRV = SETFIX.ID_SRVSET ");
		sqlBuilder.append("AND SRV.SETITMCHKNUM >= SETFIX.QUAN_MIN ");
		sqlBuilder.append("AND SRV.SETITMCHKNUM <= SETFIX.QUAN_MAX ");
		sqlBuilder.append("AND SETFIX.ID_SRVADD = PCR.ID_SRV ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" and 1 = 2 ");
		}

		sqlBuilder.append("UNION ALL ");
		sqlBuilder.append("SELECT PCR.ID_SRV,");
		sqlBuilder.append("PCR.ID_MM,");
		sqlBuilder.append("PCR.ID_UNIT,");
		sqlBuilder.append("PCR.ID_ITM ID_SRV_ITM,");
		sqlBuilder.append("PCR.ID_PRIPAT,");
		sqlBuilder.append("PCR.PRICE_STD_ITM,");
		sqlBuilder.append("PCR.RATE_ITM,");
		sqlBuilder.append("PCR.PRICE_RATIO_ITM,");
		sqlBuilder.append("PCR.QUAN_ITM,");
		sqlBuilder.append("6 UNION_MARK ");
		sqlBuilder.append("FROM BD_PRICE_COMP_RATIO_ITM PCR ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(SqlUtils.getInSqlByIds("PCR.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			sqlBuilder.append(" where 1 = 2 ");
		}
		return sqlBuilder;
	}
}
