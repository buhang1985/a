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
public class DeleteBdPriceRpQuery implements ITransQry {

	private String condType;
	private String[] condValues;

	public DeleteBdPriceRpQuery(String condType, String[] condValues) {
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
		return new StringBuilder("DELETE BD_PRICE_RP");
	}

	private String getWherePart() {
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Srv.equals(this.condType)) {
			return SqlUtils.getInSqlByIds("ID_SRV", this.condValues);
		}
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_Mm.equals(this.condType)) {
			return SqlUtils.getInSqlByIds("ID_MM", this.condValues);
		}
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_PriPat.equals(this.condType)) {
			return SqlUtils.getInSqlByIds("ID_PRIPAT", this.condValues);
		}
		if (IBdSrvPriceTableUpdateService.SrvPriceUpdateCondType_ReBuild.equals(this.condType)) {
			return "1 = 1";
		}
		return "1 = 2";
	}

}
