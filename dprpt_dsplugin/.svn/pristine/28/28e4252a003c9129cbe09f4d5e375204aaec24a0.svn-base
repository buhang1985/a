package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryOccurAdrSql implements ITransQry {
	String id_org;
	String id_grp;
	String wherePart;

	// 事件发生地点的sql查询
	public QryOccurAdrSql(String id_org, String id_grp, String wherePart) {
		this.wherePart = wherePart;
		this.id_org = id_org;
		this.id_grp = id_grp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_org);
		param.addParam(id_grp);
		return param;
	}

	// 事件发生地点
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		sqlStr.append(" count(udi_imprd.name) as count                                                            ");
		sqlStr.append(" from SFDA_AER_EV aerev                                               ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" left join bd_udidoc udi_imprd on aerev.id_occur_adr = udi_imprd.id_udidoc               ");
		sqlStr.append(" where aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" group by udi_imprd.name                  ");
		return sqlStr.toString();
	}
}
