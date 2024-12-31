package iih.ci.ord.s.ems.op.bloodbadreaction.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBloodBadReactionCountDOQry implements ITransQry{
	private String beginDate;
	private String endDate;
	private String codeEntp;
	private String orderStr;
	private String condition;
	public GetBloodBadReactionCountDOQry(String beginDate,String endDate,String codeEntp,String orderStr,String condition) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.codeEntp = codeEntp;
		this.orderStr = orderStr;
		this.condition = condition;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
 		sql.append(" select rownum,blood.id_ar as blood_id_ar,blood.use_id_or,de.name as Name_en_ward,blood.pre_id_or,p.name as name_pat,c.name_or ,")
		.append(" (case when c.code_entp = '00' then '门诊'when c.code_entp = '10' then '住院' else '' end) as name_entp,")
		.append(" c.code_entp,bu.no_applyform as use_apply_no,bt.no_applyform as pre_apply_no,p.code as code_pat,")
		.append(" (case when F.Times_Ip is null then 0 else F.Times_Ip end) + (case when J.Times_Op is null then 0 else J.Times_Op end) as en_times,")
		.append(" u1.name as sex,p.dt_birth as age,dep.name as name_en_dept,")
		.append(" blood.fg_tran_blood_bad_reaction as bad_reaction")
		
		.append(" from ci_blood_adverse_reaction blood")
		.append(" left outer join ci_order c on blood.use_id_or = c.id_or")
		.append(" left outer join ci_ap_bu bu on blood.use_id_or = bu.id_or")
		.append(" left outer join en_ent_ip entip on entip.id_ent = c.id_en")
		.append(" left outer join bd_dep de on de.id_dep = entip.id_dep_nuradm")
		.append(" left outer join pi_pat p on c.id_pat = p.id_pat")
		.append(" left outer join bd_udidoc u1 on p.id_sex = u1.id_udidoc")
		.append(" left outer join ci_ap_bt bt on bt.id_or = c.id_or_rel")
		.append(" left outer join bd_dep dep on c.id_dep_or = dep.id_dep")
		.append(" left outer join en_ent_ip F ON C.Id_En = F.Id_Ent")
		.append(" left outer join en_ent_op J ON C.Id_En = J.Id_Ent");
		if("0".equals(this.codeEntp)){
			sql.append(" where  c.fg_canc ='N' and blood.report_time >= '"+this.beginDate+"' and blood.report_time <= '"+this.endDate+"' and " + getBDModeWherePart() + this.condition + this.orderStr);
		}else{
			
			sql.append(" where c.fg_canc ='N' and c.code_entp='"+this.codeEntp+"'  and blood.report_time >= '"+this.beginDate+"' and blood.report_time <= '"+this.endDate+"' and " + getBDModeWherePart() + this.condition + this.orderStr);
		}
		return sql.toString();
	}

	
	/**
	 * 	获取基础数据管控条件语句
	 * @return
	 */
	private String getBDModeWherePart() {
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new CiBloodAdverseReactionDO(), "blood");
		return bdModeWherePart;
	}
}
