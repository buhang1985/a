package iih.bl.cg.s.bp.ip.ipoutpatprice.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询服务的实际记账数量
 * @author LIM
 *
 */
public class GetStIpSrvQuanQry implements ITransQry {
	private String id_ent;

	public GetStIpSrvQuanQry(String id_ent) {
		this.id_ent = id_ent;
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
		sb.append("  Select id_srv,name_srv, sum(eu_direct * quan) as quan ");
		sb.append(" from bl_cg_ip");
		sb.append(" where id_ent =?");
		sb.append(" group by id_srv, name_srv");
		return sb.toString();
	}
}
