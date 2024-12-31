package iih.bl.st.blauditip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blauditip.d.desc.BlAuditIpDesc;
import java.math.BigDecimal;

/**
 * 费用审核_住院 DO数据 
 * 
 */
public class BlAuditIp extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院费用审核主键
	public static final String ID_AUDITIP= "Id_auditip";
	//诊疗费用审核通过标志
	public static final String FG_PASS_CLINIC= "Fg_pass_clinic";
	//诊疗费用审核人员
	public static final String ID_EMP_CLINIC= "Id_emp_clinic";
	//诊疗费用审核时间
	public static final String DT_AUDIT_CLINIC= "Dt_audit_clinic";
	//诊疗费用审核取消人员
	public static final String ID_EMP_CANC_CLINIC= "Id_emp_canc_clinic";
	//诊疗费用审核取消时间
	public static final String DT_AUDIT_CANC_CLINIC= "Dt_audit_canc_clinic";
	//医保费用审核标志
	public static final String FG_PASS_HP= "Fg_pass_hp";
	//医保费用审核人员
	public static final String ID_EMP_HP= "Id_emp_hp";
	//医保费用审核时间
	public static final String DT_AUDIT_HP= "Dt_audit_hp";
	//医保费用审核取消人员
	public static final String ID_EMP_CANC_HP= "Id_emp_canc_hp";
	//医保费用审核取消时间
	public static final String DT_AUDIT_CANC_HP= "Dt_audit_canc_hp";
	//结算
	public static final String ID_STIP= "Id_stip";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属就诊
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//结算_门诊
	public static final String ID_STOEP= "Id_stoep";
	//诊疗费用审核结果
	public static final String AUDIT_CLINIC_RST= "Audit_clinic_rst";
	//医保审核结果
	public static final String AUDIT_HP_RST= "Audit_hp_rst";
	//姓名
	public static final String EMP_NAME_CLINIC= "Emp_name_clinic";
	//人员编码
	public static final String CODE_CLINIC= "Code_clinic";
	//人员编码
	public static final String CODE_CANC_CLINIC= "Code_canc_clinic";
	//姓名
	public static final String NAME_CANC_CLINIC= "Name_canc_clinic";
	//人员编码
	public static final String CODE_HP= "Code_hp";
	//姓名
	public static final String NAME_HP= "Name_hp";
	//人员编码
	public static final String CODE_HP_CANCEL= "Code_hp_cancel";
	//姓名
	public static final String NAME_HP_CANCEL= "Name_hp_cancel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院费用审核主键
	 * @return String
	 */
	public String getId_auditip() {
		return ((String) getAttrVal("Id_auditip"));
	}	
	/**
	 * 住院费用审核主键
	 * @param Id_auditip
	 */
	public void setId_auditip(String Id_auditip) {
		setAttrVal("Id_auditip", Id_auditip);
	}
	/**
	 * 诊疗费用审核通过标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pass_clinic() {
		return ((FBoolean) getAttrVal("Fg_pass_clinic"));
	}	
	/**
	 * 诊疗费用审核通过标志
	 * @param Fg_pass_clinic
	 */
	public void setFg_pass_clinic(FBoolean Fg_pass_clinic) {
		setAttrVal("Fg_pass_clinic", Fg_pass_clinic);
	}
	/**
	 * 诊疗费用审核人员
	 * @return String
	 */
	public String getId_emp_clinic() {
		return ((String) getAttrVal("Id_emp_clinic"));
	}	
	/**
	 * 诊疗费用审核人员
	 * @param Id_emp_clinic
	 */
	public void setId_emp_clinic(String Id_emp_clinic) {
		setAttrVal("Id_emp_clinic", Id_emp_clinic);
	}
	/**
	 * 诊疗费用审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit_clinic() {
		return ((FDateTime) getAttrVal("Dt_audit_clinic"));
	}	
	/**
	 * 诊疗费用审核时间
	 * @param Dt_audit_clinic
	 */
	public void setDt_audit_clinic(FDateTime Dt_audit_clinic) {
		setAttrVal("Dt_audit_clinic", Dt_audit_clinic);
	}
	/**
	 * 诊疗费用审核取消人员
	 * @return String
	 */
	public String getId_emp_canc_clinic() {
		return ((String) getAttrVal("Id_emp_canc_clinic"));
	}	
	/**
	 * 诊疗费用审核取消人员
	 * @param Id_emp_canc_clinic
	 */
	public void setId_emp_canc_clinic(String Id_emp_canc_clinic) {
		setAttrVal("Id_emp_canc_clinic", Id_emp_canc_clinic);
	}
	/**
	 * 诊疗费用审核取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit_canc_clinic() {
		return ((FDateTime) getAttrVal("Dt_audit_canc_clinic"));
	}	
	/**
	 * 诊疗费用审核取消时间
	 * @param Dt_audit_canc_clinic
	 */
	public void setDt_audit_canc_clinic(FDateTime Dt_audit_canc_clinic) {
		setAttrVal("Dt_audit_canc_clinic", Dt_audit_canc_clinic);
	}
	/**
	 * 医保费用审核标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pass_hp() {
		return ((FBoolean) getAttrVal("Fg_pass_hp"));
	}	
	/**
	 * 医保费用审核标志
	 * @param Fg_pass_hp
	 */
	public void setFg_pass_hp(FBoolean Fg_pass_hp) {
		setAttrVal("Fg_pass_hp", Fg_pass_hp);
	}
	/**
	 * 医保费用审核人员
	 * @return String
	 */
	public String getId_emp_hp() {
		return ((String) getAttrVal("Id_emp_hp"));
	}	
	/**
	 * 医保费用审核人员
	 * @param Id_emp_hp
	 */
	public void setId_emp_hp(String Id_emp_hp) {
		setAttrVal("Id_emp_hp", Id_emp_hp);
	}
	/**
	 * 医保费用审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit_hp() {
		return ((FDateTime) getAttrVal("Dt_audit_hp"));
	}	
	/**
	 * 医保费用审核时间
	 * @param Dt_audit_hp
	 */
	public void setDt_audit_hp(FDateTime Dt_audit_hp) {
		setAttrVal("Dt_audit_hp", Dt_audit_hp);
	}
	/**
	 * 医保费用审核取消人员
	 * @return String
	 */
	public String getId_emp_canc_hp() {
		return ((String) getAttrVal("Id_emp_canc_hp"));
	}	
	/**
	 * 医保费用审核取消人员
	 * @param Id_emp_canc_hp
	 */
	public void setId_emp_canc_hp(String Id_emp_canc_hp) {
		setAttrVal("Id_emp_canc_hp", Id_emp_canc_hp);
	}
	/**
	 * 医保费用审核取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit_canc_hp() {
		return ((FDateTime) getAttrVal("Dt_audit_canc_hp"));
	}	
	/**
	 * 医保费用审核取消时间
	 * @param Dt_audit_canc_hp
	 */
	public void setDt_audit_canc_hp(FDateTime Dt_audit_canc_hp) {
		setAttrVal("Dt_audit_canc_hp", Dt_audit_canc_hp);
	}
	/**
	 * 结算
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}	
	/**
	 * 结算
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 所属就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 结算_门诊
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	/**
	 * 结算_门诊
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 诊疗费用审核结果
	 * @return String
	 */
	public String getAudit_clinic_rst() {
		return ((String) getAttrVal("Audit_clinic_rst"));
	}	
	/**
	 * 诊疗费用审核结果
	 * @param Audit_clinic_rst
	 */
	public void setAudit_clinic_rst(String Audit_clinic_rst) {
		setAttrVal("Audit_clinic_rst", Audit_clinic_rst);
	}
	/**
	 * 医保审核结果
	 * @return String
	 */
	public String getAudit_hp_rst() {
		return ((String) getAttrVal("Audit_hp_rst"));
	}	
	/**
	 * 医保审核结果
	 * @param Audit_hp_rst
	 */
	public void setAudit_hp_rst(String Audit_hp_rst) {
		setAttrVal("Audit_hp_rst", Audit_hp_rst);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name_clinic() {
		return ((String) getAttrVal("Emp_name_clinic"));
	}	
	/**
	 * 姓名
	 * @param Emp_name_clinic
	 */
	public void setEmp_name_clinic(String Emp_name_clinic) {
		setAttrVal("Emp_name_clinic", Emp_name_clinic);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_clinic() {
		return ((String) getAttrVal("Code_clinic"));
	}	
	/**
	 * 人员编码
	 * @param Code_clinic
	 */
	public void setCode_clinic(String Code_clinic) {
		setAttrVal("Code_clinic", Code_clinic);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_canc_clinic() {
		return ((String) getAttrVal("Code_canc_clinic"));
	}	
	/**
	 * 人员编码
	 * @param Code_canc_clinic
	 */
	public void setCode_canc_clinic(String Code_canc_clinic) {
		setAttrVal("Code_canc_clinic", Code_canc_clinic);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_canc_clinic() {
		return ((String) getAttrVal("Name_canc_clinic"));
	}	
	/**
	 * 姓名
	 * @param Name_canc_clinic
	 */
	public void setName_canc_clinic(String Name_canc_clinic) {
		setAttrVal("Name_canc_clinic", Name_canc_clinic);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 人员编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 姓名
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_hp_cancel() {
		return ((String) getAttrVal("Code_hp_cancel"));
	}	
	/**
	 * 人员编码
	 * @param Code_hp_cancel
	 */
	public void setCode_hp_cancel(String Code_hp_cancel) {
		setAttrVal("Code_hp_cancel", Code_hp_cancel);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_hp_cancel() {
		return ((String) getAttrVal("Name_hp_cancel"));
	}	
	/**
	 * 姓名
	 * @param Name_hp_cancel
	 */
	public void setName_hp_cancel(String Name_hp_cancel) {
		setAttrVal("Name_hp_cancel", Name_hp_cancel);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_auditip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_audit_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlAuditIpDesc.class);
	}
	
}