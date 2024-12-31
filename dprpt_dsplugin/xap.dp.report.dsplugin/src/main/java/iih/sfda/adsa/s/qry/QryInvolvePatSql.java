package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryInvolvePatSql implements ITransQry {
	String sd_attribute;
	String id_org;
	String id_grp;
	String wherePart;

	public QryInvolvePatSql(String sd_attribute, String id_org,
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

	// 是否涉及患者
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		sqlStr.append(" nvl(ev.ev_count, 0) count                                                        ");
		sqlStr.append(" from bd_udidoc udi_imprd                                               ");
		sqlStr.append(" left join (select aerimprd.id_sfda_imprd_tp, count(aerimprd.id_sfda_imprd_tp) ev_count               ");
		sqlStr.append(" from SFDA_AER_IMPRD aerimprd                    ");
		sqlStr.append(" left join SFDA_AER_EV aerev  on aerimprd.id_aer_ev=aerev.id_aer_ev                  ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" where         ");
		sqlStr.append(" aerimprd .id_org= ?   ");
		sqlStr.append(" and aerimprd .id_grp= ?  ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "               ");
		}
		sqlStr.append(" group by aerimprd.id_sfda_imprd_tp) ev    ");
		sqlStr.append(" on ev.id_sfda_imprd_tp = udi_imprd.id_udidoc     ");
		sqlStr.append(" inner join (select id_udidoclist");
		sqlStr.append(" from bd_udidoclist v");
		sqlStr.append(" where code = ?) udilist");
		sqlStr.append(" on udi_imprd.id_udidoclist = udilist.id_udidoclist");
		sqlStr.append(" order by udi_imprd.Code   ");
		return sqlStr.toString();
	}
}
