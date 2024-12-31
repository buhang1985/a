package iih.hr.hsc.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDepSchedByDateSql implements ITransQry {

	private String id_dep;
	private String dt_begin;
	private String dt_end;

	public GetDepSchedByDateSql(String id_dep, String dt_begin, String dt_end) {
		this.id_dep = id_dep;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_dep);
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("   select sched.id_psndoc,									");
		sb.append("          sched.dt_sched_date,                               ");
		sb.append("          sched.name_hsc_si,                                 ");
		sb.append("          nvl(psn.name, sched.ctrl2) name                    ");
		sb.append("   from hr_hsc_sched sched                                   ");
		sb.append("   left join bd_psndoc psn on psn.id_psndoc=sched.id_psndoc  ");
		sb.append("   where sched.id_dep=?                                      ");
		sb.append("   and sched.dt_sched_date >= ? and  sched.dt_sched_date <= ?");
		return sb.toString();
	}
}
