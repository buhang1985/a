package iih.sfda.adsa.yearsstatistics.qry;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEventTypeSql implements ITransQry {
	String startTime;
	String endTime;
	String sd_coll_ref;
	String id_org;
	String id_grp;
	String wherePart;

	public GetEventTypeSql(String startTime, String endTime, String sd_coll_ref, String id_org, String id_grp,
			String wherePart) {
		this.wherePart = wherePart;
		this.id_org = id_org;
		this.id_grp = id_grp;
		this.sd_coll_ref = sd_coll_ref;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public RptSqlParam[] getSqlParams() {
		RptSqlParam[] arr_params = new RptSqlParam[] { new RptSqlParam(startTime, String.class),
				new RptSqlParam(endTime, String.class), new RptSqlParam(id_org, String.class),
				new RptSqlParam(id_grp, String.class)};
		return arr_params;
	}

	// 事件类别
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                    ");
		sqlStr.append(" udiev.name,                                                                           ");
		if (GetConstant.getOccurDate().equals(sd_coll_ref)) {
			sqlStr.append(" aerev.dateTime dateTime                            ");
			sqlStr.append(" from bd_udidoc udiev                                                                          ");
			sqlStr.append(" left join (select udi_aerev.id_udidoc id_udidoc, aerev.dateTime dateTime                                                                ");
			sqlStr.append(" from bd_udidoc udi_aerev                                                                ");
			sqlStr.append(" inner join (select udi_evtp.id_parent id_parent, aerev.dt_occur dateTime                                                              ");
			sqlStr.append(" from SFDA_AER_EV aerev                ");
			sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
			sqlStr.append(" left outer join bd_udidoc udi_evtp on udi_evtp.id_udidoc = aerev.id_ev_ca                                                             ");
			sqlStr.append(" where aerev.dt_occur >=  ?               ");
			sqlStr.append(" and aerev.dt_occur <=   ?              ");
		} else {
			sqlStr.append(" aerev.dateTime dateTime                            ");
			sqlStr.append("  from bd_udidoc udiev                                                                          ");
			sqlStr.append(" left join (select udi_aerev.id_udidoc id_udidoc, aerev.dateTime dateTime                                                                ");
			sqlStr.append(" from bd_udidoc udi_aerev                                                                ");
			sqlStr.append(" inner join (select udi_evtp.id_parent id_parent, aerev.createdtime dateTime                                                              ");
			sqlStr.append(" from SFDA_AER_EV aerev                ");
			sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
			sqlStr.append(" left outer join bd_udidoc udi_evtp on udi_evtp.id_udidoc = aerev.id_ev_ca                                                             ");
			sqlStr.append(" where aerev.createdtime >=  ?               ");
			sqlStr.append(" and aerev.createdtime <=   ?              ");
		}
		sqlStr.append(" and aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(" ) aerev                ");
		sqlStr.append(" on aerev.id_parent = udi_aerev.id_udidoc) aerev               ");
		sqlStr.append(" on aerev.id_udidoc = udiev.id_udidoc              ");
		sqlStr.append(" left outer join (select substr(sd_ev_ca, 0, 2) codeEv, count(*) countEv   ");
		sqlStr.append(" from sfda_aer_ev aerev  group by substr(sd_ev_ca, 0, 2)) ev on ev.codeEv = udiev.code");
		sqlStr.append(" where udiev.id_udidoclist = '@@@@ZZ2000000000014V'  and length(udiev.code) = 2 ");
		sqlStr.append(" order by udiev.code asc  ");
		return sqlStr.toString();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
