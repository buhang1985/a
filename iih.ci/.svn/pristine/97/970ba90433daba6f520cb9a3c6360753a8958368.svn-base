package iih.ci.ord.s.external.blood.ruimei.s.bp;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryPatientDataSql  implements ITransQry{
	


	private String deptcode;
	private String nurcode;
	private String date_b_in;
	private String date_e_in;
	private String date_b_out;
	private String date_e_out;
	private String ipstatus;
	public QueryPatientDataSql(String deptcode, String nurcode, String date_b_in, String date_e_in, String date_b_out, String date_e_out, String ipstatus) {

		this.deptcode = deptcode;
		this.nurcode = nurcode;
		this.date_b_in = date_b_in;
		this.date_e_in = date_e_in;
		this.date_b_out = date_b_out;
		this.date_e_out = date_e_out;
		this.ipstatus = ipstatus;
	}

	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if(!StringUtil.isEmptyWithTrim(deptcode)){
			param.addParam(deptcode);
		}
		if(!StringUtil.isEmptyWithTrim(nurcode)){
			param.addParam(nurcode);
		}
		if(!StringUtil.isEmptyWithTrim(date_b_in)){
			param.addParam(date_b_in);
		}
		if(!StringUtil.isEmptyWithTrim(date_e_in)){
			param.addParam(date_e_in);
		}
		if(!StringUtil.isEmptyWithTrim(date_b_out)){
			param.addParam(date_b_out);
		}
		if(!StringUtil.isEmptyWithTrim(date_e_out)){
			param.addParam(date_e_out);
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
		sqlStr.append(" where ent.code_entp='10' and ent.fg_ip='Y' 																					 ");
		if(!StringUtil.isEmptyWithTrim(deptcode)){
			sqlStr.append("  and  depphy.code = ?");
		}
		if(!StringUtil.isEmptyWithTrim(nurcode)){
			sqlStr.append("  and  depnur.code = ?");
		}
		if("1".equals(ipstatus)){
			
			if(!StringUtil.isEmptyWithTrim(date_b_in)){
				sqlStr.append("  and  ent.dt_acpt > ?");
			}
			if(!StringUtil.isEmptyWithTrim(date_e_in)){
				sqlStr.append("  and  ent.dt_acpt < ?");
			}
		}else if("2".equals(ipstatus)){
			
			if(!StringUtil.isEmptyWithTrim(date_b_out)){
				sqlStr.append("  and  ent.dt_end > ?");
			}
			if(!StringUtil.isEmptyWithTrim(date_e_out)){
				sqlStr.append("  and  ent.dt_end < ?");
			}
		}else{
			sqlStr.append(" and 1 = 2");
		}
		
		return sqlStr.toString();
	}



}
