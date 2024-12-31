package iih.sfda.adsa.s.qry;

import iih.sfda.adsa.s.ISfdaAdsaConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryEevenTypeSql implements ITransQry {
	String id_org;
	String id_grp;
	String wherePart;

	// 事件类别的sql语句查询
	public QryEevenTypeSql(String id_org, String id_grp, String wherePart) {
		this.wherePart = wherePart;
		this.id_org = id_org;
		this.id_grp = id_grp;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(ISfdaAdsaConst.ID_STATIS_TYPE);
		param.addParam(ISfdaAdsaConst.ID_STATIS_TYPE);
		param.addParam(id_org);
		param.addParam(id_grp);
		param.addParam(ISfdaAdsaConst.ID_STATIS_TYPE);
		return param;
	}
	// 事件类别
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" c.name name_parent,	                                                        ");
		sqlStr.append(" nvl(e.ev_count, 0) count_parent,                                                        ");
		sqlStr.append(" b.name name,                                             ");
		sqlStr.append(" nvl(s.ev_count, 0) count             ");
		sqlStr.append(" from bd_udidoc udi                 ");
		sqlStr.append(" left join (select id_parent, name from bd_udidoc udi where udi.id_udidoclist = ? and length(udi.code) = 4) b                ");
		sqlStr.append(" on b.name = udi.name               ");
		sqlStr.append(" left join bd_udidoc c on c.id_udidoc = b.id_parent                ");
		sqlStr.append(" left join (select name from bd_udidoc udi where udi.id_udidoclist = ? and length(udi.code) = 2) a                 ");
		sqlStr.append(" on a.name = udi.name                ");
		sqlStr.append(" left join (select id_ev_ca, count(id_ev_ca) ev_count from sfda_aer_ev aerev                  ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" where aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" group by id_ev_ca) s  on s.id_ev_ca = udi.id_udidoc                ");
		sqlStr.append(" left join (select udi_evtp.id_parent, count(udi_evtp.id_parent) ev_count from SFDA_AER_EV aerev                ");
		sqlStr.append(" left join bd_udidoc udi_evtp on udi_evtp.id_udidoc = aerev.id_ev_ca    ");
		sqlStr.append(" group by udi_evtp.id_parent) d on d.id_parent = udi.id_udidoc                   ");
		sqlStr.append(" left join (select udi_evtp.id_parent, count(udi_evtp.id_parent) ev_count                  ");
		sqlStr.append(" from SFDA_AER_EV aerev                  ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" left join bd_udidoc udi_evtp on udi_evtp.id_udidoc = aerev.id_ev_ca	                 ");
		if (wherePart != null) {
			sqlStr.append(" where " + wherePart + "                ");
		}
		sqlStr.append(" group by udi_evtp.id_parent) e on e.id_parent = udi.id_parent                  ");
		sqlStr.append(" where udi.id_udidoclist = ?                 ");
		sqlStr.append("  AND LENGTH(udi.code) = 4              ");
		sqlStr.append("  order by udi.code  asc           ");
		
		return sqlStr.toString();
	}
}
