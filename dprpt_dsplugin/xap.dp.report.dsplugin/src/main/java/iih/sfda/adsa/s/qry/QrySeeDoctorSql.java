package iih.sfda.adsa.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QrySeeDoctorSql implements ITransQry{
	String id_org;
	String id_grp;
	String wherePart;
	
	public QrySeeDoctorSql(String id_org, String id_grp, String wherePart) {
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

	//就诊形式
	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		sqlStr.append(" nvl(enttp.ev_count, 0) count                                                        ");
		sqlStr.append(" from bd_entp udi_imprd                                               ");
		sqlStr.append(" left join (select aerimprd.id_enttp, count(aerimprd.id_enttp) ev_count               ");
		sqlStr.append(" from SFDA_AER_IMPRD aerimprd                    ");
		sqlStr.append(" left join SFDA_AER_EV aerev  on aerimprd.id_aer_ev=aerev.id_aer_ev                  ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
	    sqlStr.append(" where aerimprd.id_org= ?     ");
		sqlStr.append(" and aerimprd.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" group by aerimprd.id_enttp) enttp    ");
		sqlStr.append(" on enttp.id_enttp = udi_imprd.id_entp     ");
		sqlStr.append(" order by udi_imprd.Code   ");
		return sqlStr.toString();
	}
}
