package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryReportDepSql implements ITransQry{
	String id_org;
	String id_grp;
	String wherePart;
	
	public QryReportDepSql(String id_org, String id_grp, String wherePart) {
		this.id_org = id_org;
		this.id_grp = id_grp;
		this.wherePart = wherePart;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_org);
		param.addParam(id_grp);
		return param;
	}

	//报告部门
	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" reportdep.name as name,                                                         ");
		sqlStr.append(" count(reportdep.name) as count                                                           ");
		sqlStr.append(" from SFDA_AER_EV aerev                                              ");
		sqlStr.append(" inner join bd_psndoc psndoc on aerev.id_psndoc = psndoc.id_psndoc             ");
		sqlStr.append(" inner join bd_dep reportdep on psndoc.id_dep = reportdep.id_dep            ");
	    sqlStr.append(" where aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" group by reportdep.name                   ");
		return sqlStr.toString();
	}
}
