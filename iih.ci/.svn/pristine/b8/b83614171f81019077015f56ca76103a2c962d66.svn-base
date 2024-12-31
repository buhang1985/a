package iih.ci.ord.s.external.blood.ruimei.s.bp;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryPatientData8IpCodeSql  implements ITransQry{
	


	private String ipcode;
	private int timesip;

	public QueryPatientData8IpCodeSql(String ipcode, String timesip) {
		this.ipcode = ipcode;
		this.timesip =Integer.parseInt(timesip);
	}

	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if(!StringUtil.isEmptyWithTrim(ipcode)){
			param.addParam(ipcode);
		}
		if(timesip>0){
			param.addParam(timesip);
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select  ent.code ,pat.code as patcode,ip.code_amr_ip,ip.times_ip,                                                            ");
		sqlStr.append(" (select trunc(sysdate ,'dd')-trunc(to_date(ent.dt_entry,'yyyy-MM-dd hh24:mi:ss')) from dual)+1 as totaldays,                 ");
		sqlStr.append(" ent.name_pat,'' flag_black,sexudi.name as sex,pat.dt_birth dt_birth_date,pat.mob,                                            ");
		sqlStr.append(" ca.code sd_patca,ca.name name_patca,pri.code sd_pripat,pri.name name_pripat,                                                 ");
		sqlStr.append(" '' as code_hp,'' as name_hp,'' as no_hp,                                                                                     ");
		sqlStr.append(" ip.name_bed as bedcode,                                                                                                      ");
		sqlStr.append(" depphy.code as depcode,                                                                                                     ");
		sqlStr.append(" depphy.name as depname,                                                                                                     ");
		sqlStr.append(" depnur.code as depcode_nur,                                                                                                  ");
		sqlStr.append(" depnur.name as depname_nur,                                                                                                  ");
		sqlStr.append(" ent.dt_entry,ent.dt_acpt,ent.dt_end,                                                                                         ");
		sqlStr.append(" ip.sd_level_nur,ent.addr_pat,                                                                                                ");
		sqlStr.append(" phy.name doctorname,phy.code doctorcode,                                                                                                ");
		sqlStr.append(" pat.sd_idtp as id_type,pat.id_code as code_id,ip.sd_status as ip_status                                                            ");
		sqlStr.append(" from en_ent ent                                                                                                              ");
		sqlStr.append(" inner join en_ent_ip ip on ip.id_ent = ent.id_ent                   														 ");
		sqlStr.append(" inner join bd_dep dep on dep.id_dep = ent.id_dep_phy                                                      					 ");
		sqlStr.append(" left join pi_pat pat on ent.id_pat = pat.id_pat                                                                              ");
		sqlStr.append(" left join bd_udidoc sexudi on pat.id_sex = sexudi.id_udidoc                                                                  ");
		sqlStr.append(" left join pi_pat_ca ca on pat.id_paticate = ca.id_patca                                                                 	 ");
		sqlStr.append(" left join bd_pri_pat pri on pat.id_patpritp=pri.id_pripat                                                                    "); 
		sqlStr.append(" left join bd_dep depphy on ent.id_dep_phy = depphy.id_dep                                                                    ");
		sqlStr.append(" left join bd_dep depnur on depnur.id_dep = ent.id_dep_nur                                                                    ");
		sqlStr.append(" left join bd_psndoc phy on phy.id_psndoc = ent.id_emp_phy                                                                    ");
		sqlStr.append(" where ent.code_entp='10' and ent.fg_ip='Y' 																					 ");
		if(!StringUtil.isEmptyWithTrim(ipcode)){
			sqlStr.append("  and  ip.code_amr_ip = ?");
		}
		if(timesip>0){
			sqlStr.append("  and  ip.times_ip = ?");
		}

		sqlStr.append(" order by ip.times_ip desc ");
		return sqlStr.toString();
	}



}
