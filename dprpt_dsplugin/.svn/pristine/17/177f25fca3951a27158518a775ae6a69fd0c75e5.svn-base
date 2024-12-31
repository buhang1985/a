package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取发生部门
 * @author 于德义
 *
 */
public class QryOccurDepSql implements ITransQry{
	String id_org;
	String id_grp;
	String wherePart;
	
	public QryOccurDepSql(String id_org, String id_grp, String wherePart) {
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

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" occurdep.name as name ,                                                         ");
		sqlStr.append(" count(occurdep.name) as count                                                            ");
		sqlStr.append(" from SFDA_AER_EV aerev                                              ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" inner join bd_dep occurdep on aerev.id_dep_occur =occurdep.id_dep              ");
	    sqlStr.append(" where aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" group by occurdep.name                   ");
		return sqlStr.toString();
	}
}
