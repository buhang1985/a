package iih.ci.ord.s.bp.ems.save.ip.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiIpTimeQry implements ITransQry {
	private String id_en;
	
	public CiIpTimeQry(String id_en){
		this.id_en = id_en;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(this.id_en);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
	
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 String sql=getCiIpTimeValidate();
		 return sql;
	 }	

		private String getCiIpTimeValidate(){
			StringBuilder sb = new StringBuilder();
			sb.append(" select greatest (nvl(time1,'1900-01-01 00:00:00'),nvl(time2,'1900-01-01 00:00:00')) max");
			sb.append("   from (select max(c.dt_last_mp) time1,max(case when c.fg_long='Y' and c.fg_stop='N' then c.dt_effe else c.dt_end end) time2 from ci_order c");
			sb.append(" where c.id_en = ?");
			sb.append(" and c.fg_sign='Y'");
			sb.append(" and c.fg_canc='N'");
			sb.append(" and c.fg_pres_outp='N'");
			sb.append(" and c.sd_orsrcfun<>2");
			sb.append(" and c.ds='0' ) ");
			return sb.toString();
		}
}
