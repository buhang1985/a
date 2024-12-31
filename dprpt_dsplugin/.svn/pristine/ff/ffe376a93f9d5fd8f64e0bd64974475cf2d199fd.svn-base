package iih.nm.nhr.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取指定科室和日期下排班数据
 * 
 * @author lijm
 *
 */
public class GetSchedDataByDepAndDtSql implements ITransQry {

	private String id_dep_nur;
	private String dt_begin;
	private String dt_end;

	public GetSchedDataByDepAndDtSql(String id_dep_nur, String dt_begin, String dt_end) {
		this.id_dep_nur = id_dep_nur;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dep_nur);
		param.addParam(dt_begin);
		param.addParam(dt_end);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("	select id_nur, 					      ");
		sb.append("		dt_sched_date,                    ");
		sb.append("		name_nhr_si                       ");
		sb.append("	from nm_nhr_sched sched               ");
		sb.append("	where sched.id_dep_nur = ?            ");
		sb.append("		and sched.dt_sched_date >= ?      ");
		sb.append("		and sched.dt_sched_date <= ?      ");
		sb.append("	 order by sched.dt_sched_date ,sched.sortno_day asc    ");
		return sb.toString();
	}

}
