package iih.bl.st.blpreauditip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blpreauditip.d.desc.BlPreAuditIpDODesc;
import java.math.BigDecimal;

/**
 * 医保预审核住院 DO数据 
 * 
 */
public class BlPreAuditIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院费用医保预审核主键
	public static final String ID_PREAUDITIP= "Id_preauditip";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//医保费用预审核标识
	public static final String FG_PREPASS_HP= "Fg_prepass_hp";
	//医保费用预审核人员
	public static final String ID_PREEMP_HP= "Id_preemp_hp";
	//医保费用预审核时间
	public static final String DT_PREAUDIT_HP= "Dt_preaudit_hp";
	//医保费用预审核取消人员
	public static final String ID_PREEMP_CANC_HP= "Id_preemp_canc_hp";
	//医保费用预审核取消时间
	public static final String DT_PREAUDIT_CANC_HP= "Dt_preaudit_canc_hp";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//医保预审核结果
	public static final String AUDIT_HP_RST= "Audit_hp_rst";
	//外伤标识
	public static final String FG_INJURY= "Fg_injury";
	//上浮标识
	public static final String FG_FEEUP= "Fg_feeup";
	//减免标识
	public static final String FG_FEERELIEF= "Fg_feerelief";
	//备注
	public static final String NOTE= "Note";
	//生育标识
	public static final String FG_BIRTH= "Fg_birth";
	//审核人
	public static final String NAME_PREMP= "Name_premp";
	//人员编码
	public static final String CODE_PREMP= "Code_premp";
	//审核取消人
	public static final String NAME_PRECANC= "Name_precanc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院费用医保预审核主键
	 * @return String
	 */
	public String getId_preauditip() {
		return ((String) getAttrVal("Id_preauditip"));
	}	
	/**
	 * 住院费用医保预审核主键
	 * @param Id_preauditip
	 */
	public void setId_preauditip(String Id_preauditip) {
		setAttrVal("Id_preauditip", Id_preauditip);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 医保费用预审核标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prepass_hp() {
		return ((FBoolean) getAttrVal("Fg_prepass_hp"));
	}	
	/**
	 * 医保费用预审核标识
	 * @param Fg_prepass_hp
	 */
	public void setFg_prepass_hp(FBoolean Fg_prepass_hp) {
		setAttrVal("Fg_prepass_hp", Fg_prepass_hp);
	}
	/**
	 * 医保费用预审核人员
	 * @return String
	 */
	public String getId_preemp_hp() {
		return ((String) getAttrVal("Id_preemp_hp"));
	}	
	/**
	 * 医保费用预审核人员
	 * @param Id_preemp_hp
	 */
	public void setId_preemp_hp(String Id_preemp_hp) {
		setAttrVal("Id_preemp_hp", Id_preemp_hp);
	}
	/**
	 * 医保费用预审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_preaudit_hp() {
		return ((FDateTime) getAttrVal("Dt_preaudit_hp"));
	}	
	/**
	 * 医保费用预审核时间
	 * @param Dt_preaudit_hp
	 */
	public void setDt_preaudit_hp(FDateTime Dt_preaudit_hp) {
		setAttrVal("Dt_preaudit_hp", Dt_preaudit_hp);
	}
	/**
	 * 医保费用预审核取消人员
	 * @return String
	 */
	public String getId_preemp_canc_hp() {
		return ((String) getAttrVal("Id_preemp_canc_hp"));
	}	
	/**
	 * 医保费用预审核取消人员
	 * @param Id_preemp_canc_hp
	 */
	public void setId_preemp_canc_hp(String Id_preemp_canc_hp) {
		setAttrVal("Id_preemp_canc_hp", Id_preemp_canc_hp);
	}
	/**
	 * 医保费用预审核取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_preaudit_canc_hp() {
		return ((FDateTime) getAttrVal("Dt_preaudit_canc_hp"));
	}	
	/**
	 * 医保费用预审核取消时间
	 * @param Dt_preaudit_canc_hp
	 */
	public void setDt_preaudit_canc_hp(FDateTime Dt_preaudit_canc_hp) {
		setAttrVal("Dt_preaudit_canc_hp", Dt_preaudit_canc_hp);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 医保预审核结果
	 * @return String
	 */
	public String getAudit_hp_rst() {
		return ((String) getAttrVal("Audit_hp_rst"));
	}	
	/**
	 * 医保预审核结果
	 * @param Audit_hp_rst
	 */
	public void setAudit_hp_rst(String Audit_hp_rst) {
		setAttrVal("Audit_hp_rst", Audit_hp_rst);
	}
	/**
	 * 外伤标识
	 * @return FBoolean
	 */
	public FBoolean getFg_injury() {
		return ((FBoolean) getAttrVal("Fg_injury"));
	}	
	/**
	 * 外伤标识
	 * @param Fg_injury
	 */
	public void setFg_injury(FBoolean Fg_injury) {
		setAttrVal("Fg_injury", Fg_injury);
	}
	/**
	 * 上浮标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feeup() {
		return ((FBoolean) getAttrVal("Fg_feeup"));
	}	
	/**
	 * 上浮标识
	 * @param Fg_feeup
	 */
	public void setFg_feeup(FBoolean Fg_feeup) {
		setAttrVal("Fg_feeup", Fg_feeup);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feerelief() {
		return ((FBoolean) getAttrVal("Fg_feerelief"));
	}	
	/**
	 * 减免标识
	 * @param Fg_feerelief
	 */
	public void setFg_feerelief(FBoolean Fg_feerelief) {
		setAttrVal("Fg_feerelief", Fg_feerelief);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 生育标识
	 * @return FBoolean
	 */
	public FBoolean getFg_birth() {
		return ((FBoolean) getAttrVal("Fg_birth"));
	}	
	/**
	 * 生育标识
	 * @param Fg_birth
	 */
	public void setFg_birth(FBoolean Fg_birth) {
		setAttrVal("Fg_birth", Fg_birth);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_premp() {
		return ((String) getAttrVal("Name_premp"));
	}	
	/**
	 * 审核人
	 * @param Name_premp
	 */
	public void setName_premp(String Name_premp) {
		setAttrVal("Name_premp", Name_premp);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_premp() {
		return ((String) getAttrVal("Code_premp"));
	}	
	/**
	 * 人员编码
	 * @param Code_premp
	 */
	public void setCode_premp(String Code_premp) {
		setAttrVal("Code_premp", Code_premp);
	}
	/**
	 * 审核取消人
	 * @return String
	 */
	public String getName_precanc() {
		return ((String) getAttrVal("Name_precanc"));
	}	
	/**
	 * 审核取消人
	 * @param Name_precanc
	 */
	public void setName_precanc(String Name_precanc) {
		setAttrVal("Name_precanc", Name_precanc);
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
		return "Id_preauditip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_preaudit_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPreAuditIpDODesc.class);
	}
	
}