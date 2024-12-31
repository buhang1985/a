package iih.bd.srv.srvpricetable.s.bp.b_bd_price_ratio_tmp.qry;

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
public class InsertBdPriceRatioTmpQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdPriceRatioTmpQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_PRICE_RATIO_TMP ");
		sqlBuilder.append("SELECT SRVC.ID_SRV,");
		sqlBuilder.append("SRVC.ID_PRIPAT,");
		sqlBuilder.append("PRI.PRICE PRICE_STD,");
		sqlBuilder.append("SRVC.RATE CARATE,");
		sqlBuilder.append("PPITM.RATE ITMRATE,");
		sqlBuilder.append("PPITM.PRI ITMPRI,");
		sqlBuilder.append("PPITM.EU_PI_PRIRATEMD RATEMD ");
		sqlBuilder.append("FROM BD_SRV_PRIPAT_CROSS SRVC,");
		sqlBuilder.append("BD_PRI_SRV PRI,");
		sqlBuilder.append("BD_PRI_PAT_SRVORCA PPITM ");
		return sqlBuilder;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("SRVC.ID_SRV = PRI.ID_SRV ");
		wherePartBuilder.append("AND SRVC.ID_SRV = PPITM.ID_SRV(+) ");
		wherePartBuilder.append("AND SRVC.ID_PRIPAT = PPITM.ID_PRIPAT(+) ");
		wherePartBuilder.append("AND PPITM.DT_E(+) = '2099-12-31 23:59:59' ");
		wherePartBuilder.append("AND PRI.DT_E = '2099-12-31 23:59:59' ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("SRVC.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("SRVC.ID_PRIPAT", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			wherePartBuilder.append(" and 1 = 2");
		}
		return wherePartBuilder.toString();
	}
}
