package iih.mp.nr.drugpartol.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author fengjj
 *
 */
public class GetPatrolOrderContentSql implements ITransQry {

	private String dt_begin;
	private String dt_end;
	private String eu_long;
	private String[] id_ents;
	private String nameTable;
	private String id_dep_nur;

	public GetPatrolOrderContentSql(String[] id_ents, String dt_begin, String dt_end, String eu_long, String nameTable, String id_dep_nur) {
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.id_ents = id_ents;
		this.eu_long = eu_long;
		this.nameTable = nameTable;
		this.id_dep_nur = id_dep_nur;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.dt_begin);
		sqlParam.addParam(this.dt_end);
		if (!StringUtil.isEmptyWithTrim(this.eu_long))
			sqlParam.addParam(this.eu_long);
		if (!StringUtil.isEmptyWithTrim(this.id_dep_nur))
			sqlParam.addParam(this.id_dep_nur);
		sqlParam.addParam(this.dt_begin);
		sqlParam.addParam(this.dt_end);
		if (!StringUtil.isEmptyWithTrim(this.eu_long))
			sqlParam.addParam(this.eu_long);
		if (!StringUtil.isEmptyWithTrim(this.id_dep_nur))
			sqlParam.addParam(this.id_dep_nur);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("SELECT * FROM (                                                                                                  ");
		sqlStr.append(" select                                                                                                          ");
		sqlStr.append(" ord.id_or,                                                                                                      ");
		sqlStr.append(" orpr.id_or_pr,                                                                                                  ");
		sqlStr.append(" srv.id_orsrv  					as  id_or_srv,                                                                  ");
		sqlStr.append(" enentip.name_bed,														                                        ");
		sqlStr.append(" enent.name_pat,                                    							                                    ");
		sqlStr.append(" udisex.name 					as  gender,                               							            ");
		sqlStr.append(" enentip.code_amr_ip,                                  							                                ");
		sqlStr.append(" enent.dt_birth_pat,                                                                                             ");
		sqlStr.append(" ord.content_or,                                                                                                 ");
		sqlStr.append(" ord.fg_long,                                                                                                    ");
		sqlStr.append(" ord.dt_effe,                                                                                                    ");
		sqlStr.append(" route.name    					as  name_route,                                                                 ");
		sqlStr.append(" ordsta.name    			 		as  ord_state,                                                                  ");
		sqlStr.append(" freq.code       				as  freq_code,                                                                  ");
		sqlStr.append(" emp.name         				as	name_doc,                                                                   ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                                                ");
		sqlStr.append(" srv.name         				as  drug_name,                                                                  ");
		sqlStr.append(" mm.spec,                                                                                                        ");
		sqlStr.append(" srv.quan_medu,                                                                                                  ");
		sqlStr.append(" measdoc.name    			 	as 	name_medu,                                                                  ");
		sqlStr.append(" sta.name_orpltpsta 				as 	name_exec,                                                                  ");
		sqlStr.append(" sta.dt_mp,                                                                                                      ");
		sqlStr.append(" psnoper.name          	 		as 	name_emp_oper,                                                              ");
		sqlStr.append(" dep.name           				as 	name_dep_oper,                                                              ");
		sqlStr.append(" sta.skip_reason,                                                                                                ");
		sqlStr.append(" null              			 	as 	ivgtt,                                                                      ");
		sqlStr.append(" null              			 	as	unit_name,                                                                  ");
		sqlStr.append(" null              			 	as 	num_waste,                                                                  ");
		sqlStr.append(" null               				as 	name_situation,                                                             ");
		sqlStr.append(" 0               				as 	sign                                                             			");
		sqlStr.append(" FROM ci_order ord                                                                                               ");
		sqlStr.append("  inner join mp_or_pr orpr on ord.id_or = orpr.id_or and orpr.id_ent = ord.id_en                                 ");
		sqlStr.append("        and orpr.dt_mp_plan >= ?     and orpr.dt_mp_plan <= ?                                                    ");
		sqlStr.append("  inner join ci_or_srv srv on srv.id_or = ord.id_or                                                              ");
		// 含有用法的过滤                                                                                                               
		sqlStr.append("  inner join " + this.nameTable + " temroute on ord.id_route = temroute.id_route            					    ");
		sqlStr.append("  and nvl(temroute.id_route,'~') <> '~'                                                         				    ");
		sqlStr.append("  left outer join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = srv.id_orsrv                                        ");
		sqlStr.append("  left outer join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                                           ");
		sqlStr.append("  left outer join bd_measdoc measdoc on measdoc.id_measdoc = srv.id_medu                                         ");
		sqlStr.append("  inner join bd_route route on ord.id_route = route.id_route                                                     ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent                                                            ");
		sqlStr.append("  inner join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc                                             ");
		sqlStr.append("  inner join bd_udidoc ordsta on ord.id_su_mp = ordsta.id_udidoc                                                 ");
		sqlStr.append("  inner join en_ent_ip enentip on ord.id_en = enentip.id_ent                                                     ");
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = ord.id_freq                                                          ");
		sqlStr.append("  inner join bd_psndoc emp on ord.id_emp_or = emp.id_psndoc                                                      ");
		sqlStr.append("  left  join mp_or_pr_sta sta  on sta.id_or_pr = orpr.id_or_pr                                                   ");
		sqlStr.append("  left  join bd_psndoc psnoper on psnoper.id_psndoc = sta.id_emp                                                 ");
		sqlStr.append("  left  join bd_dep dep on dep.id_dep = sta.id_dep                                                               ");
		sqlStr.append(" where nvl(ord.sd_orsrcfun, '~') <> '2'                                                                          ");
		sqlStr.append("       and substr(ord.sd_srvtp,0,2) = '01'                                                                       ");
		sqlStr.append("       and ord.code_entp = '10'                                                                                  ");
		String whereStr = MpUtils.getInSqlStr(this.id_ents);                                                                            
		if (!StringUtil.isEmptyWithTrim(whereStr))                                                                                      
			sqlStr.append("   and ord.id_en in (" + whereStr + ")                                                                       ");
		if (!StringUtil.isEmptyWithTrim(this.eu_long))                                                                                  
			sqlStr.append("         and ord.fg_long = ?                                                                                 ");
		if (!StringUtil.isEmptyWithTrim(this.id_dep_nur))                                                                               
			sqlStr.append("   and enent.id_dep_nur = ?                                                                                  ");
		sqlStr.append(" union all                                                                                                       ");
		sqlStr.append(" SELECT                                                                                                          ");
		sqlStr.append("   ord.id_or,                                                                                                    ");
		sqlStr.append("   orpr.id_or_pr,                                                                                                ");
		sqlStr.append("   srv.id_orsrv 					as	id_or_srv,                                                                  ");
		sqlStr.append("   enentip.name_bed,														                                        ");
		sqlStr.append("   enent.name_pat,                                   						                                    ");
		sqlStr.append("   udisex.name 					as  gender,                               						                ");
		sqlStr.append("   enentip.code_amr_ip,                                  						                                ");
		sqlStr.append("   enent.dt_birth_pat,                                                                                           ");
		sqlStr.append("   ord.content_or,                                                                                               ");
		sqlStr.append("   ord.fg_long,                                                                                                  ");
		sqlStr.append("   ord.dt_effe,                                                                                                  ");
		sqlStr.append("   route.name       			    as 	name_route,                                                                 ");
		sqlStr.append("   ordsta.name      				as	ord_state,                                                                  ");
		sqlStr.append("   freq.code        				as	freq_code,                                                                  ");
		sqlStr.append("   emp.name         				as	name_doc,                                                                   ");
		sqlStr.append("   orpr.dt_mp_plan,                                                                                              ");
		sqlStr.append("   srv.name         				as	drug_name,                                                                  ");
		sqlStr.append("   mm.spec,                                                                                                      ");
		sqlStr.append("   srv.quan_medu,                                                                                                ");
		sqlStr.append("   measdoc.name     				as	name_medu,                                                                  ");
		sqlStr.append("   '  '||typ.name        		as	name_exec,                                                                  ");
		sqlStr.append("   pr.dt_oper      				as	dt_mp,                                                                      ");
		sqlStr.append("   psn.name        				as	name_emp_oper,                                                              ");
		sqlStr.append("   dep.name        				as	name_dep_oper,                                                              ");
		sqlStr.append("   null            				as	skip_reason,                                                                ");
		sqlStr.append("   pr.ivgtt,                                                                                                     ");
		sqlStr.append("   unit.name						as	unit_name,                                                                  ");
		sqlStr.append("   pr.num_waste,                                                                                                 ");
		sqlStr.append("   situa.name       				as	name_situation,                                                             ");
		sqlStr.append("	  2               				as 	sign                                                             			");
		sqlStr.append(" FROM ci_order ord                                                                                               ");
		sqlStr.append("  inner join mp_or_pr orpr on ord.id_or = orpr.id_or and orpr.id_ent = ord.id_en                                 ");
		sqlStr.append("        and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?					                                    ");
		sqlStr.append("  inner join ci_or_srv srv on srv.id_or = ord.id_or                                                              ");
		// 含有用法的过滤                                                                                                               
		sqlStr.append("  inner join " + this.nameTable + " temroute on ord.id_route = temroute.id_route                    			    ");
		sqlStr.append("  and nvl(temroute.id_route,'~') <> '~'                                                               		    ");
		sqlStr.append("  left outer join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = srv.id_orsrv                                        ");
		sqlStr.append("  left outer join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                                           ");
		sqlStr.append("  left outer join bd_measdoc measdoc on measdoc.id_measdoc = srv.id_medu                                         ");
		sqlStr.append("  inner join bd_route route on ord.id_route = route.id_route                                                     ");
		sqlStr.append("  inner join en_ent enent on ord.id_en = enent.id_ent                                                            ");
		sqlStr.append("  inner join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc                                             ");
		sqlStr.append("  inner join bd_udidoc ordsta on ord.id_su_mp = ordsta.id_udidoc                                                 ");
		sqlStr.append("  inner join en_ent_ip enentip on ord.id_en = enentip.id_ent                                                     ");
		sqlStr.append("  inner join bd_freq freq on freq.id_freq = ord.id_freq                                                          ");
		sqlStr.append("  inner join bd_psndoc emp on ord.id_emp_or = emp.id_psndoc                                                      ");
		sqlStr.append("  left  join mp_infu_pr pr  on pr.id_or_pr = orpr.id_or_pr                                                       ");
		sqlStr.append("  left  join bd_udidoc typ on pr.id_prtp = typ.id_udidoc                                                         ");
		sqlStr.append("  left  join bd_udidoc unit on pr.id_unit = unit.id_udidoc                                                       ");
		sqlStr.append("  left  join bd_udidoc situa on pr.id_situation = situa.id_udidoc                                                ");
		sqlStr.append("  left  join bd_psndoc psn on pr.id_emp_oper = psn.id_psndoc                                                     ");
		sqlStr.append("  left  join bd_dep dep on dep.id_dep = pr.id_dep_oper                                                           ");
		sqlStr.append("where nvl(ord.sd_orsrcfun, '~') <> '2'                                                                           ");
		sqlStr.append("  and substr(ord.sd_srvtp,0,2) = '01'                                                                            ");
		sqlStr.append("  and ord.code_entp = '10'                                                                                       ");
		sqlStr.append("  and pr.sd_prtp in (3,5) 	                                                                                    ");
		String whereStr2 = MpUtils.getInSqlStr(this.id_ents);                                                                           
		if (!StringUtil.isEmptyWithTrim(whereStr2))                                                                                     
			sqlStr.append(" and ord.id_en in (" + whereStr2 + ")                                                                        ");
		if (!StringUtil.isEmptyWithTrim(this.eu_long))                                                                                  
			sqlStr.append(" and ord.fg_long = ?                                                                                         ");
		if (!StringUtil.isEmptyWithTrim(this.id_dep_nur))                                                                               
			sqlStr.append(" and enent.id_dep_nur = ?                                                                                    ");
		sqlStr.append("      )                                                                                                          ");
		sqlStr.append(" order by dt_effe asc,dt_mp_plan asc,dt_mp asc                                                                   ");
		return sqlStr.toString();                                                                                                       
	}

}
