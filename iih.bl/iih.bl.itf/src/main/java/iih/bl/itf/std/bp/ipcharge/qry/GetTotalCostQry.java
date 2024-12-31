package iih.bl.itf.std.bp.ipcharge.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTotalCostQry implements ITransQry {

	String patCode;
	Integer times;
	

	public GetTotalCostQry(String patCode, Integer times) {
		this.patCode = patCode;
		this.times = times;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		String str = Integer.toString(times);
		param.addParam(str);		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  ");
		sql.append("nvl(sum(c.amt_ratio*c.eu_direct),0) as totalAmt ");
		sql.append("FROM en_ent a ");
		sql.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sql.append("inner join bl_cg_ip c on a.id_ent = c.id_ent and a.id_pat= c.id_pat ");
		sql.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sql.append("WHERE  nvl(c.fg_research,'N')='N' and (pat.code = ? )");
		sql.append(" AND (b.times_ip = ? )");
		return sql.toString();
	}

}
