package iih.bl.st.blauditip.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医保、自费项目审核功能-待预审核患者信息查询
 * @author hanjq
 *
 */
public class IpOutAuditPatQry implements ITransQry {

	private String whereStr;
	private Boolean Fg_emgstay;

	public IpOutAuditPatQry(String whereStr) {
		this.whereStr = whereStr;
		this.Fg_emgstay = false;
	}
	
	public void setFg_emgstay(Boolean fg_emgstay)
	{
		this.Fg_emgstay = fg_emgstay;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("  select  distinct pat.code pat_code,");
		sql.append("  ent.id_ent,");
		sql.append("  entip.code_amr_ip ip_no,");
		sql.append("  entip.times_ip ip_num,");
		sql.append("  pat.name pat_name,");
		sql.append("  decode(pat.sd_sex,'1','男','2','女','9','未说明','0','未知') pat_sex,");
		sql.append("  patca.name as pat_ca,");
		sql.append("  ent.dt_acpt as in_date,");
		sql.append("  ent.dt_end as out_date,");
		sql.append("  ent.telno_pat, ");
		sql.append("  auditip.fg_pass_clinic as fg_ip_audit,");
		sql.append("  nvl(preaudit.fg_prepass_hp,'N') fg_hp_audit,");
		sql.append("  preaudit.fg_injury, ");
		sql.append("  preaudit.fg_feeup, ");
		sql.append("  preaudit.fg_feerelief, ");
		sql.append("  preaudit.note, ");
		sql.append("  preaudit.fg_birth, ");
		sql.append("  preaudit.audit_hp_rst as audit_state, ");
		sql.append("  preaudit.code as psndoc_code, ");
		sql.append("  preaudit.name as psndoc_name, ");
		  		 		
		sql.append("  in_dep.name as in_name_dep,");
		sql.append("  in_nur.name as in_name_nur,");
		sql.append("  out_dep.name as out_name_dep,");
		sql.append("  out_nur.name as out_name_nur,");
		sql.append("  entip.name_bed as bed_no,");
		sql.append("  pat.dt_birth as Birth_date,");
		sql.append("  pat.id_code, ");
		sql.append("  region.name as name_hparea, ");
		sql.append("  ent_hp.code_hppatca as name_hppatca, ");
		sql.append("  (case  ");
		sql.append("   when (nvl(auditip.fg_pass_clinic,'N')='N' and nvl(auditip.fg_pass_hp,'N')='N')  ");
		sql.append("  then 0  ");
		sql.append("  when (nvl(auditip.fg_pass_clinic,'N')='Y' and nvl(auditip.fg_pass_hp,'N')='N') ");
		sql.append("  then 1  ");
		sql.append("  when (nvl(auditip.fg_pass_clinic,'N')='N' and nvl(auditip.fg_pass_hp,'N')='Y') ");
		sql.append("  then 2  ");
		sql.append("  when (nvl(auditip.fg_pass_clinic,'N')='Y' and nvl(auditip.fg_pass_hp,'N')='Y') ");
		sql.append("  then 3  ");
		sql.append("  END)  mark  ");
		sql.append("  from en_ent ent ");
		sql.append("  inner join en_ent_ip entip ");
		sql.append("  on ent.id_ent = entip.id_ent ");
		
		//获取统筹区和医疗待遇
		sql.append("  left join en_ent_hp ent_hp ");
		sql.append("  on ent.id_ent = ent_hp.id_ent ");
		sql.append("  left join bd_mhi_region region ");
		sql.append("  on ent_hp.code_hparea = region.code ");	
		
		sql.append("  left join pi_pat pat ");
		sql.append("  on ent.id_pat = pat.id_pat ");
		sql.append("  left join pi_pat_ca patca ");
		sql.append("  on ent.id_patca = patca.id_patca ");
		//只取操作时间最近的记录进行关联
		sql.append("  left outer join ( select id_auditip,fg_pass_clinic,fg_pass_hp,dt_audit_hp,dt_audit_clinic,id_emp_hp,id_ent,"
				+ "ROW_NUMBER()OVER(PARTITION BY bl_audit_ip.id_ent ORDER BY sv desc) AS code_id from bl_audit_ip  where bl_audit_ip.fg_active='Y' ) auditip ");
		sql.append("  on ent.id_ent = auditip.id_ent and auditip.code_id = 1 ");
		
		//医保审核
		sql.append(" left join (select preaudit.id_ent, ");
		sql.append(" preaudit.fg_prepass_hp, ");
		sql.append(" preaudit.id_preemp_hp, ");
		sql.append(" prelog.id_emp_act, ");
		sql.append(" prelog.eu_act, ");
		sql.append(" preaudit.fg_injury, ");
		sql.append(" preaudit.fg_feeup, ");
		sql.append(" preaudit.fg_feerelief,");
		sql.append(" preaudit.note, ");
		sql.append(" preaudit.fg_birth, ");
		sql.append(" preaudit.audit_hp_rst, ");
		sql.append(" psndoc.code, ");
		sql.append(" psndoc.name, ");
		sql.append(" ROW_NUMBER() OVER(PARTITION BY preaudit.id_ent ORDER BY prelog.dt_act desc) AS rowno ");
		sql.append(" from bl_preaudit_ip preaudit ");
		sql.append(" join bl_preaudit_log_ip prelog on prelog.id_preauditip = preaudit.id_preauditip ");
		sql.append(" left join bd_psndoc psndoc on preaudit.id_preemp_hp=psndoc.id_psndoc ");
		sql.append("  ) preaudit on preaudit.id_ent = ent.id_ent and preaudit.rowno = 1 ");
		
		sql.append("  join bd_dep in_dep ");
		sql.append("  on entip.id_dep_phyadm = in_dep.id_dep ");
		sql.append("  join bd_dep in_nur ");
		sql.append("  on entip.id_dep_nuradm = in_nur.id_dep ");
		sql.append("  left join bd_dep out_dep ");
		sql.append("  on entip.id_dep_phydisc = out_dep.id_dep ");
		sql.append("  left join bd_dep out_nur ");
		sql.append("  on entip.id_dep_nurdisc = out_nur.id_dep ");
		sql.append("  where  1=1 ");   // 28出院
		if(this.Fg_emgstay != null && this.Fg_emgstay.equals(true))
		{
			sql.append("  and ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"' "); 
		}
		else
		{
			sql.append("  and ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' "); 
		}
		
		if(StringUtils.isNotBlank(whereStr)){
			sql.append("  and ").append(whereStr); 
		}
		
		sql.append(" order by ent.dt_acpt ");
		return sql.toString();
	}
}
