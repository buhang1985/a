package iih.bl.cg.bp.ippre;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCheckUnIpPreToOepFeeQry implements ITransQry{
	private String id_ent;

	public GetCheckUnIpPreToOepFeeQry(String id_ent) {
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
		sb.append(" and code_enttp = '11' ");
		sb.append(" group by id_srv, name_srv");
		sb.append(" having  sum(eu_direct * quan) <> 0");
		return sb.toString();
	}
}
