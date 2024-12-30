package iih.sc.sch.s.bp.qry;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSrvNamesSql implements ITransQry {

	List<String> schIdList ;

	public GetSrvNamesSql(List<String> schIdList ) {
		this.schIdList = schIdList;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();

		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT tick.Id_sch,srv.NAME FROM SC_SRV srv");
		sb.append(" INNER JOIN SC_TICK tick on srv.id_scsrv=tick.id_scsrv");
		sb.append(" WHERE ");
		sb.append(SqlUtils.getInSqlByIds( "tick.id_sch", schIdList.toArray(new String[0])));
		sb.append(" GROUP BY tick.Id_sch,tick.t_b,srv.NAME");
		
		return sb.toString();
	}

}
