package iih.ci.ord.s.external.provide.sql;

import org.apache.commons.lang.StringUtils;

public class SurInfo4IpSql {

	/**
	 * 住院手术申请查询数据信息SQL串
	 *
	 */
	
	public static String IpSugInfoSql(String id_pat,String id_ent, String dt_b, String dt_e, String id_dep_mp, String code_entp,
			 String fg_aptapp1, String fg_confirm){
	
		StringBuilder sqlSB = new StringBuilder();
		
		sqlSB.append(" select Q.Id_Apop as id_ieoporen,c.id_pat as patient_id,c.name_pat as Name,c.id_sex_pat as Sexid,c.sd_sex_pat as sexcode,");
		sqlSB.append(" b.dt_birth as birthdaydate,c.id_ent,c.code_entp, h.code_amr_ip,h.id_bed,bed.name as name_bed,a.id_or,a.id_srv , ");
		sqlSB.append(" SRV.code AS code_srv,a.name_or,a.code_or,a.content_or,a.des_or,a.sd_su_or,a.dt_entry,a.id_emp_sign, ");
		sqlSB.append(" a.dt_effe,a.fg_urgent,a.id_dep_mp,a.id_dep_sign,q.no_applyform,q.name_diag,q.fg_new_sug,q.id_lvlsug,");
		sqlSB.append(" q.sd_lvlsug,q.id_anestp,q.sd_anestp,q.fg_allergy,q.fg_patho,q.id_su_op,q.sd_su_op,q.quan_bt_paln, ");
		sqlSB.append(" q.id_emp_operate,q.id_emp_helper,q.id_sugbody,q.sd_sugbody,q.specialreq,q.specialinstrument,q.specialdes,");
		sqlSB.append(" q.fg_xq_sug,q.fg_er_sug,q.fg_daysug,fg_zq_sug,o.name as apply_dept_name,m.name as exec_dept_name");
		sqlSB.append(" from ci_ap_sug Q left outer join ci_order A on Q.Id_Or=A.Id_Or " );
		sqlSB.append(" left outer join pi_pat B ON A.Id_Pat=B.Id_Pat ");
		sqlSB.append(" left outer join bd_srv srv on srv.id_srv=a.id_srv");
		sqlSB.append(" left outer join en_ent C ON A.Id_En=C.Id_Ent ");
		sqlSB.append(" left outer join en_ent_ip H ON C.Id_Ent=H.Id_Ent  ");
		sqlSB.append(" left outer join bd_bed bed on bed.id_bed=h.id_bed");
		sqlSB.append(" left outer join bd_dep M ON M.Id_Dep=A.Id_Dep_Mp");
		sqlSB.append(" left outer join bd_dep O ON O.Id_Dep=A.Id_Dep_Or");
		sqlSB.append(" where a.sd_srvtp like '04%' and a.fg_sign = 'Y' and a.fg_canc = 'N'  " ); 
		if (id_pat != null) {
			sqlSB.append(" and b.id_pat = ?");
		}
		if (id_ent != null) {
			sqlSB.append(" and a.id_en = ?");
		}
		if (dt_b != null) {
			sqlSB.append(" and a.dt_effe >= ?");
		}
		if (dt_e != null) {
			sqlSB.append(" and a.dt_end <= ?");
		}
		if (id_dep_mp != null) {
			sqlSB.append(" and a.id_dep_mp = ?");
		}
		if (code_entp != null) {
			sqlSB.append(" and a.code_entp = ?");
		}
		if (fg_aptapp1 != null && fg_aptapp1 == "Y") {
			sqlSB.append(" and Q.sd_su_op > '10'");
		}
		if (fg_aptapp1 != null && fg_aptapp1 == "N") {
			sqlSB.append(" and Q.sd_su_op < '10'");
		}
		if (fg_confirm != null && fg_confirm == "Y") {
			sqlSB.append(" and Q.sd_su_op > '10'");
		}
		if (fg_confirm != null && fg_confirm == "N") {
			sqlSB.append(" and Q.sd_su_op < '10'");
		}
		return sqlSB.toString();
		
	}
	
	
	/**
	 * 附加手术集合
	 */
	public static String IpAddSugInfoSql(String id_or) {
	
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select d.id_srv as add_sug_srvid,d.code_srv as add_sug_code,d.name as add_sug_name ");
		sqlSB.append(" from ci_or_srv D left outer join ci_order A ON d.id_or = a.id_or   " );
		sqlSB.append(" where d.fg_or = 'Y' and d.fg_bl = 'N' and d.id_srv <> A.id_srv and A.Id_Or ");
		sqlSB.append(id_or);
		return sqlSB.toString();
		
	}
	
	/**
	 * 手术人员集合
	 */
	public static String IpSugEmpInfoSql(String id_or) {
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select e.sortno,e.id_role,e.sd_role, e.id_emp ");
		sqlSB.append(" from ci_ap_sug_emp E left outer join ci_ap_sug Q on E.Id_Apop = Q.id_apop " );
		sqlSB.append(" left outer join ci_order A on Q.Id_Or=A.Id_Or " );
		sqlSB.append(" where A.Id_Or ");
		sqlSB.append(id_or);
		return sqlSB.toString();
		
	}
	
	/**
	 * 手术卫材集合
	 */
	public static String IpSugMmInfoSql(String id_or) {
	
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select g.sd_mmtp,g.id_mm,g.spec,g.id_sup,g.quan_cur,g.id_unit_pkgsp ");
		sqlSB.append(" from ci_ap_sug_mm G left outer join ci_ap_sug Q on G.ID_APOP = q.id_apop " );
		sqlSB.append(" left outer join ci_order A on Q.Id_Or=A.Id_Or " );
		sqlSB.append(" where A.Id_Or ");
		sqlSB.append(id_or);
		
		return sqlSB.toString();
		
	}
	
	/**
	 * 动态指标集合
	 */
	public static String IpSugViewItemInfoSql(String id_or) {
		
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select f.id_srv,f.name_srv,f.val_rstrptla,f.id_unit, f.name_unit,f.sd_restrptlabtp,f.val_restrptlab ");
		sqlSB.append(" from ci_ap_sug_viewitm F left outer join ci_order A on F.ID_SRV = a.id_srv " );
		sqlSB.append(" where A.Id_Or ");
		sqlSB.append(id_or);
		
		return sqlSB.toString();
		
	}
}


