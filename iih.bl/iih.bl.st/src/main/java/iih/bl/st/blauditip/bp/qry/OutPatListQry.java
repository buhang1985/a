package iih.bl.st.blauditip.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 普通出院或者急诊出观患者审核信息查询
 * 
 * @author shaokx
 * @since 2018年7月25日
 */
public class OutPatListQry implements ITransQry {

	private String whereStr;
	private Boolean Fg_emgstay;

	public OutPatListQry(String whereStr) {
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
		sql.append("  select  pat.code pat_code,");
		sql.append("  ent.id_ent,");
		sql.append("  entip.code_amr_ip ip_no,");
		sql.append("  entip.times_ip ip_num,");
		sql.append("  pat.name pat_name,");
		sql.append("  decode(pat.sd_sex,'1','男','2','女','9','未说明','0','未知') pat_sex,");
		sql.append("  patca.name pat_ca,");
		sql.append("  ent.dt_acpt in_date,");
		sql.append("  ent.dt_end out_date,");
		sql.append("  ent.telno_pat, ");
		sql.append("  auditip.fg_pass_clinic fg_ip_audit,");
		sql.append("  auditip.fg_pass_hp fg_hp_audit,");
		sql.append("  in_dep.name in_name_dep,");
		sql.append("  in_nur.name in_name_nur,");
		sql.append("  out_dep.name out_name_dep,");
		sql.append("  out_nur.name out_name_nur,");
		sql.append("  entip.name_bed bed_no,");
		sql.append("  pat.dt_birth Birth_date,");
		sql.append("  pat.id_code, ");
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
		sql.append("  left join pi_pat pat ");
		sql.append("  on ent.id_pat = pat.id_pat ");
		sql.append("  left join pi_pat_ca patca ");
		sql.append("  on ent.id_patca = patca.id_patca ");
		//只取操作时间最近的记录进行关联
		sql.append("  left outer join ( select id_auditip,fg_pass_clinic,fg_pass_hp,dt_audit_hp,dt_audit_clinic,id_ent from "
				+ "( select id_auditip,fg_pass_clinic,fg_pass_hp,dt_audit_hp,dt_audit_clinic,id_ent,"
				+ "ROW_NUMBER()OVER(PARTITION BY bl_audit_ip.id_ent ORDER BY sv desc) AS code_id from bl_audit_ip  where bl_audit_ip.fg_active='Y')  where code_id =1 ) auditip ");
		sql.append("  on ent.id_ent = auditip.id_ent ");
		
		sql.append("  left join bd_dep in_dep ");
		sql.append("  on entip.id_dep_phyadm = in_dep.id_dep ");
		sql.append("  left join bd_dep in_nur ");
		sql.append("  on entip.id_dep_nuradm = in_nur.id_dep ");
		sql.append("  left join bd_dep out_dep ");
		sql.append("  on entip.id_dep_phydisc = out_dep.id_dep ");
		sql.append("  left join bd_dep out_nur ");
		sql.append("  on entip.id_dep_nurdisc = out_nur.id_dep ");
		sql.append("  where  entip.sd_status = '28' ");   // 28出院
		if(this.Fg_emgstay != null && this.Fg_emgstay.equals(true))
		{
			sql.append("  and ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"' "); 
		}
		else
		{
			sql.append("  and ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' "); 
		}

		if (!StringUtil.isEmpty(this.whereStr)) {
			if (this.whereStr.contains("auditip.fg_pass_clinic")) {
				String[] str = this.whereStr.split("fg_pass_clinic = '");
				String fg_audit = str[1].substring(0, 1);

				if(!StringUtil.isEmpty(fg_audit)){
					if ("0".equals(fg_audit)) {
						String replacestr = this.whereStr.replace("auditip.fg_pass_clinic = '0'",
								"(auditip.id_auditip is null or (auditip.fg_pass_clinic = 'N' and auditip.fg_pass_hp = 'N'))");
						sql.append(" and " + replacestr);
					} else if ("1".equals(fg_audit)) {
						String replacestr = this.whereStr.replace("auditip.fg_pass_clinic = '1'",
								"(auditip.fg_pass_clinic = 'Y' and auditip.fg_pass_hp = 'N')");
						sql.append(" and " + replacestr);
					} else if ("2".equals(fg_audit)) {
						String replacestr = this.whereStr.replace("auditip.fg_pass_clinic = '2'",
								"(auditip.fg_pass_clinic = 'N' and auditip.fg_pass_hp = 'Y')");
						sql.append(" and " + replacestr);
					}else if("3".equals(fg_audit)){
						String replacestr = this.whereStr.replace("auditip.fg_pass_clinic = '3'",
								"(auditip.fg_pass_clinic = 'Y' and auditip.fg_pass_hp = 'Y')");
						sql.append(" and " + replacestr);
					}
				}
			} else {
				sql.append(" and " + this.whereStr);
			}
		}else{
			sql.append(" and 1=2 ");
		}
		return sql.toString();
	}
}
