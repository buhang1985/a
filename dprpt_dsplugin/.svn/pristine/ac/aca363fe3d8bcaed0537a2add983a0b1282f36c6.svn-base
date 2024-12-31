package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryDataTypeSql implements ITransQry {
	String sd_attribute;
	String id_org;
	String id_grp;
	String wherePart;

	public QryDataTypeSql(String sd_attribute, String id_org,
			String id_grp, String wherePart) {
		this.wherePart = wherePart;
		this.sd_attribute = sd_attribute;
		this.id_org = id_org;
		this.id_grp = id_grp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_org);
		param.addParam(id_grp);
		param.addParam(sd_attribute);
		return param;
	}

	//事件发生日期类型
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		sqlStr.append(" nvl(occur_dttp.ev_count, 0) count                                                        ");
		sqlStr.append(" from bd_udidoc udi_imprd                                               ");
		sqlStr.append(" left join (select id_occur_dttp, count(id_occur_dttp) ev_count               ");
		sqlStr.append(" from SFDA_AER_EV aerev                   ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" where         ");
		sqlStr.append(" aerev.id_org= ?   ");
		sqlStr.append(" and aerev.id_grp= ?  ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "               ");
		}
		sqlStr.append(" group by id_occur_dttp) occur_dttp    ");
		sqlStr.append(" on occur_dttp.id_occur_dttp = udi_imprd.id_udidoc     ");
		sqlStr.append(" inner join (select id_udidoclist");
		sqlStr.append(" from bd_udidoclist v");
		sqlStr.append(" where code = ?) udilist");
		sqlStr.append(" on udi_imprd.id_udidoclist = udilist.id_udidoclist");
		sqlStr.append(" order by udi_imprd.Code   ");
		return sqlStr.toString();
	}
}
