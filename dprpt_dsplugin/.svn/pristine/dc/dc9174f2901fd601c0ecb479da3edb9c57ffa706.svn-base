package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryPatSexSql implements ITransQry {
	String sd_attribute;
	String id_org;
	String id_grp;
	String wherePart;

	// 患者性别的sql语句查询
	public QryPatSexSql(String sd_attribute, String id_org, String id_grp, String wherePart) {
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

	// 患者性别
	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		sqlStr.append(" nvl(sex_pat.ev_count, 0) count                                                        ");
		sqlStr.append(" from bd_udidoc udi_imprd                                               ");
		sqlStr.append(" left join (select aerimprd.id_sex_pat, count(aerimprd.id_sex_pat) ev_count               ");
		sqlStr.append(" from SFDA_AER_IMPRD aerimprd                    ");
		sqlStr.append(" left join SFDA_AER_EV aerev  on aerimprd.id_aer_ev=aerev.id_aer_ev                  ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" where         ");
		sqlStr.append(" aerimprd .id_org= ?  ");
		sqlStr.append(" and aerimprd .id_grp= ? ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "               ");
		}
		sqlStr.append(" group by aerimprd.id_sex_pat) sex_pat    ");
		sqlStr.append(" on sex_pat.id_sex_pat = udi_imprd.id_udidoc     ");
		sqlStr.append(" inner join (select id_udidoclist");
		sqlStr.append(" from bd_udidoclist v");
		sqlStr.append(" where code = ?) udilist");
		sqlStr.append(" on udi_imprd.id_udidoclist = udilist.id_udidoclist");
		sqlStr.append(" order by udi_imprd.Code   ");
		return sqlStr.toString();
	}
}
