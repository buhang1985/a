/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.medicaldepqc.sqlbp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;

/**
 * 〈扼要描述〉
 * 获取 医务质控相关查询sql
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MedicalDepMrQcSqlBP {

	/**
	 * 医务质控报表sql
	 * @param sqlwhere
	 * @return
	 */
	public String GetMedicalDepMrQcResultSql(String sqlwhere){
		StringBuilder sql = new StringBuilder();
		sql.append("select en_ent.name_pat      as pat_name,");
		sql.append("       en_ent.dt_acpt       as dt_acpt,"); 
		sql.append("       en_ent.dt_end        as dt_end,"); 
		sql.append("       en_ent.id_emp_phy    as id_emp_phy,"); 
		sql.append("       bd_psndoc.name       as emp_phy_name,"); 
		sql.append("       en_ent_ip.ID_DEP_PHYADM    as ID_DEP_PHYADM,"); 
		sql.append("       bd_dep_in.name      as name_dep_phyadm,"); 
		sql.append("       en_ent_ip.ID_DEP_NURADM    as ID_DEP_NURADM,"); 
		sql.append("       bd_dep_nur_in.name      as name_dep_nuradm,"); 
		sql.append("       en_ent_ip.ID_DEP_PHYDISC    as ID_DEP_PHYDISC,"); 
		sql.append("       bd_dep_out.name      as name_dep_phydisc,"); 
		sql.append("       en_ent_ip.ID_DEP_NURDISC    as ID_DEP_NURDISC,"); 
		sql.append("       bd_dep_nur_out.name      as name_dep_nurdisc,"); 
		sql.append("       en_ent_ip.code_amr_ip    as Hospital_code,"); 
		sql.append("       bd_psndoc_zy.name       as name_emp_zy,"); 
		sql.append("       bd_psndoc_zz.name       as name_emp_zz,"); 
		sql.append("       bd_psndoc_zr.name       as name_emp_zr,"); 	
		sql.append("       ci_qa_divide.drp_des"); 
		sql.append("  from ci_qa_divide ci_qa_divide"); 
		sql.append("  left join en_ent en_ent"); 
		sql.append("    on en_ent.id_ent = ci_qa_divide.id_ent"); 
		sql.append("  left join en_ent_ip en_ent_ip"); 
		sql.append("    on en_ent_ip.id_ent = ci_qa_divide.id_ent"); 
		sql.append("  left join bd_psndoc bd_psndoc"); 
		sql.append("    on bd_psndoc.id_psndoc = en_ent.id_emp_phy"); 
		sql.append("  left join bd_dep bd_dep_in"); 
		sql.append("    on bd_dep_in.id_dep = en_ent_ip.ID_DEP_PHYADM"); 
		sql.append("  left join bd_dep bd_dep_nur_in"); 
		sql.append("    on bd_dep_nur_in.id_dep = en_ent_ip.ID_DEP_NURADM");
		sql.append("  left join bd_dep bd_dep_out"); 
		sql.append("    on bd_dep_out.id_dep = en_ent_ip.ID_DEP_PHYDISC"); 
		sql.append("  left join bd_dep bd_dep_nur_out"); 
		sql.append("    on bd_dep_nur_out.id_dep = en_ent_ip.ID_DEP_NURDISC");
		sql.append("  left join (select * from (select rank() over(partition by id_ent order by dt_b desc) groupsn, ent_emp.* from en_ent_emp ent_emp  where ent_emp.sd_emprole = '"+IEnDictCodeConst.SD_EMPROLE_ZYDOC+"')   where groupsn = '1') en_ent_emp_zy "); 
		sql.append("     on en_ent_emp_zy.id_ent=ci_qa_divide.id_ent"); 
		sql.append("  left join bd_psndoc bd_psndoc_zy"); 
		sql.append("    on bd_psndoc_zy.id_psndoc = en_ent_emp_zy.id_emp "); 
		sql.append("  left join (select * from (select rank() over(partition by id_ent order by dt_b desc) groupsn, ent_emp.* from en_ent_emp ent_emp  where ent_emp.sd_emprole = '"+IEnDictCodeConst.SD_EMPROLE_ZZDOC+"')   where groupsn = '1') en_ent_emp_zz "); 
		sql.append("     on en_ent_emp_zz.id_ent=ci_qa_divide.id_ent"); 
		sql.append("  left join bd_psndoc bd_psndoc_zz"); 
		sql.append("    on bd_psndoc_zz.id_psndoc = en_ent_emp_zz.id_emp ");
		sql.append("  left join (select * from (select rank() over(partition by id_ent order by dt_b desc) groupsn, ent_emp.* from en_ent_emp ent_emp  where ent_emp.sd_emprole = '"+IEnDictCodeConst.SD_EMPROLE_ZRDOC+"')   where groupsn = '1') en_ent_emp_zr  "); 
		sql.append("     on en_ent_emp_zr.id_ent=ci_qa_divide.id_ent"); 
		sql.append("  left join bd_psndoc bd_psndoc_zr"); 
		sql.append("    on bd_psndoc_zr.id_psndoc = en_ent_emp_zr.id_emp ");
		
		
		sql.append("  where "+sqlwhere+" and ci_qa_divide.fg_checkself='N' " );
		sql.append("  order by en_ent.dt_acpt desc,ci_qa_divide.ID_QA_DIVIDE");
 		String sqlStr=sql.toString();
 		return sqlStr;
	}
}
