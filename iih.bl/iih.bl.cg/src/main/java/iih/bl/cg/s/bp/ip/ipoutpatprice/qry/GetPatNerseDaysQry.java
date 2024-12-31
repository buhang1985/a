package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者的护理费用天数
 * @author LIM
 *
 */
public class GetPatNerseDaysQry implements ITransQry{

	private String id_ent;
	private String id_srv;

	public GetPatNerseDaysQry(String id_ent,String id_srv) {
		this.id_ent = id_ent;
		this.id_srv=id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
 		StringBuilder sb = new StringBuilder();
		sb.append("  select nvl(sum(cg.eu_direct*cg.quan),0) as quan ");
		sb.append(" from bl_cg_ip cg ");
		sb.append(" where cg.id_ent = ?");
		sb.append(SqlUtils.getInSqlByIds(" and cg.id_srv", this.id_srv.split(",")));
		return sb.toString();
	}
}
