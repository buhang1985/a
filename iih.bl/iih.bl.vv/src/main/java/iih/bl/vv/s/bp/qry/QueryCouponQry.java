package iih.bl.vv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryCouponQry implements ITransQry {

	String idPat;

	public QueryCouponQry(String idPat) {
		this.idPat = idPat;
	}
	/***
	 * 查询患者拥有的优惠券记录
	 * @param idPat
	 * @author houll  2018.3.6
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.idPat);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("  select cpn.id_cpn id_blcpnout, cpnca.name,DECODE(cpnca.Eu_cpntp, 1,'现金券',2,'折扣券',3,'特价券',4,'体验券',5,'换购券', '') Eu_cpntp,cpn.code from bl_cpn cpn");
		sqlSb.append("  left join bd_cpnca cpnca on cpnca.id_cpnca=cpn.id_cpnca");
		sqlSb.append("  where cpn.id_pat_own=? ");
		return sqlSb.toString();
	}

}
