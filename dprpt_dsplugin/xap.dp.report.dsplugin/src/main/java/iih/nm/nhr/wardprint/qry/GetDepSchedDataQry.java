package iih.nm.nhr.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室周排班数据
 * @author 王鹏
 *
 */
public class GetDepSchedDataQry implements ITransQry{

	private String id_dep;
	private String dt_begin;
	private String dt_end;
	
	public GetDepSchedDataQry(String id_dep,String dt_begin,String dt_end) {
		this.id_dep = id_dep;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dep);
		param.addParam(dt_begin);
		param.addParam(dt_end);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select id_nur,");
		sb.append("dt_sched_date,");
		sb.append("dur_chk_ca as dur_chk_ca,");
		sb.append("listagg(sched.name_nhr_si, '|') within group(order by sched.sortno_day) as name_nhr_si ");
		sb.append("from nm_nhr_sched sched ");
		sb.append("where sched.id_dep_nur = ? ");
		sb.append("and sched.dt_sched_date >= ? ");
		sb.append("and sched.dt_sched_date <= ? ");
		sb.append("group by sched.dt_sched_date,sched.id_nur,sched.dur_chk_ca ");
		sb.append("order by sched.dt_sched_date asc ");
		return sb.toString();
	}

}
