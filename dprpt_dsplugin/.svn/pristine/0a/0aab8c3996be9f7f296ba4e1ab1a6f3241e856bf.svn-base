package iih.sfda.adsa.yearsstatistics.qry;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatSexSql implements ITransQry {

	String sd_attribute;
	String startTime;
	String endTime;
	String sd_coll_ref;
	String id_org;
	String id_grp;
	String wherePart;

	public GetPatSexSql(String sd_attribute, String startTime, String endTime, String sd_coll_ref, String id_org,
			String id_grp, String wherePart) {
		this.wherePart = wherePart;
		this.sd_attribute = sd_attribute;
		this.id_org = id_org;
		this.id_grp = id_grp;
		this.sd_coll_ref = sd_coll_ref;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public RptSqlParam[] getSqlParams() {
		RptSqlParam[] arr_params = new RptSqlParam[] { new RptSqlParam(startTime, String.class),
				new RptSqlParam(endTime, String.class), new RptSqlParam(id_org, String.class),
				new RptSqlParam(id_grp, String.class), new RptSqlParam(sd_attribute, String.class) };
		return arr_params;
	}

	// 患者性别
	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" udi_imprd.name,                                                         ");
		if (GetConstant.getOccurDate().equals(sd_coll_ref)) {
			sqlStr.append(" sex_pat.dt_occur dateTime                                                      ");
			sqlStr.append(" from bd_udidoc udi_imprd                                               ");
			sqlStr.append(" left join (select aerimprd.id_sex_pat, aerev.dt_occur dt_occur                ");
			sqlStr.append(" from SFDA_AER_IMPRD aerimprd                    ");
			sqlStr.append(" left join SFDA_AER_EV aerev  on aerimprd.id_aer_ev=aerev.id_aer_ev                  ");
			sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
			sqlStr.append(" where aerev.dt_occur >=  ?               ");
			sqlStr.append(" and aerev.dt_occur <=   ?              ");
		} else {
			sqlStr.append(" sex_pat.dateTime dateTime                                                      ");
			sqlStr.append(" from bd_udidoc udi_imprd                                               ");
			sqlStr.append(" left join (select aerimprd.id_sex_pat, aerev.createdtime dateTime                ");
			sqlStr.append(" from SFDA_AER_IMPRD aerimprd                    ");
			sqlStr.append(" left join SFDA_AER_EV aerev  on aerimprd.id_aer_ev=aerev.id_aer_ev                  ");
			sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
			sqlStr.append(" where aerev.createdtime >=  ?               ");
			sqlStr.append(" and aerev.createdtime <=   ?              ");
		}
		sqlStr.append(" and aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		sqlStr.append(") sex_pat    ");
		sqlStr.append(" on sex_pat.id_sex_pat = udi_imprd.id_udidoc     ");
		sqlStr.append(" inner join (select id_udidoclist");
		sqlStr.append(" from bd_udidoclist v");
		sqlStr.append(" where code = ?) udilist");
		sqlStr.append(" on udi_imprd.id_udidoclist = udilist.id_udidoclist");
		sqlStr.append(" order by udi_imprd.Code   ");
		return sqlStr.toString();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
