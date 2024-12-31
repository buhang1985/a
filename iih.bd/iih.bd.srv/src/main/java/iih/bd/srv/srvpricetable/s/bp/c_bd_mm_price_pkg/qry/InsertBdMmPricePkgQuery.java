package iih.bd.srv.srvpricetable.s.bp.c_bd_mm_price_pkg.qry;

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
public class InsertBdMmPricePkgQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public InsertBdMmPricePkgQuery(String condType, String[] condValues) {
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
		sqlBuilder.append("INSERT INTO BD_MM_PRICE_PKG ");
		sqlBuilder.append("SELECT SRV.ID_SRV,");
		sqlBuilder.append("MM.ID_MM,");
		sqlBuilder.append("PKG.ID_UNIT_PKG ID_UNIT,");
		sqlBuilder.append("ROUND(MM.PRICE * PKG.FACTOR / MM.FACTOR_SB,8) PRICE ");
		sqlBuilder.append("FROM BD_SRV SRV,");
		sqlBuilder.append("BD_MM MM,");
		sqlBuilder.append("BD_MM_PKGU PKG,");
		sqlBuilder.append("BD_MEASDOC UNIT ");
		return sqlBuilder;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("SRV.ID_SRV = MM.ID_SRV ");
		wherePartBuilder.append("AND MM.ID_MM = PKG.ID_MM ");
		wherePartBuilder.append("AND NOT (MM.ID_UNIT_PKGSP = PKG.ID_UNIT_PKG ");
		wherePartBuilder.append("AND PKG.ID_MMPKGUTP = '@@@@Z7100000000F4MXA') ");
		wherePartBuilder.append("AND PKG.DS = 0 ");
		wherePartBuilder.append("AND PKG.ID_UNIT_PKG = UNIT.ID_MEASDOC ");
		wherePartBuilder.append("AND MM.FG_ACTIVE = 'Y' ");

		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("SRV.ID_SRV", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(SqlUtils.getInSqlByIds("MM.ID_MM", this.condValues));
		} else if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {

		} else {
			wherePartBuilder.append(" and 1 = 2");
		}
		return wherePartBuilder.toString();
	}
}
