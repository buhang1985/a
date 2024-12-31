package iih.bl.hp.hpentcode.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hpentcode.d.desc.HpEntCodeDODesc;
import java.math.BigDecimal;

/**
 * 住院医保登记信息 DO数据 
 * 
 */
public class HpEntCodeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保登记就诊主键
	public static final String ID_HPENTCODE= "Id_hpentcode";
	//患者信息
	public static final String ID_PAT= "Id_pat";
	//就诊主键
	public static final String ID_ENT= "Id_ent";
	//就诊编码
	public static final String CODE_ENT= "Code_ent";
	//就诊流水号（医保用）
	public static final String HP_ENT_SERIAL_NO= "Hp_ent_serial_no";
	//医保返回登记流水号
	public static final String HP_SERIALNO= "Hp_serialno";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//医保交易流水号
	public static final String CODE_HIS= "Code_his";
	//交易锁定
	public static final String FG_LOCK= "Fg_lock";
	//登记日期
	public static final String DT_REG= "Dt_reg";
	//个人编号
	public static final String NO_HP= "No_hp";
	//结算发送方交易流水号
	public static final String SETTLE_HISCODE= "Settle_hiscode";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医保产品主键
	public static final String ID_HP= "Id_hp";
	//用于处理异常问题
	public static final String EU_EXSTATUS= "Eu_exstatus";
	//审批编号
	public static final String APPROVNO= "Approvno";
	//入院诊断
	public static final String DICODE_REG= "Dicode_reg";
	//入院诊断编码
	public static final String DINAME_REG= "Diname_reg";
	//读卡信息串
	public static final String READ_CARD_INFO= "Read_card_info";
	//医保登记信息串
	public static final String REGIST_INFO= "Regist_info";
	//患者分类id
	public static final String ID_PATCA= "Id_patca";
	//病案数据上传标识
	public static final String FG_MEDUPLOAD= "Fg_medupload";
	//客开登记信息
	public static final String CUSTOM_INFO= "Custom_info";
	//活动操作人员
	public static final String ID_EMP_ACT= "Id_emp_act";
	//操作发生时间
	public static final String DT_ACT= "Dt_act";
	//电子医保标识
	public static final String FG_ELEHP= "Fg_elehp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保登记就诊主键
	 * @return String
	 */
	public String getId_hpentcode() {
		return ((String) getAttrVal("Id_hpentcode"));
	}	
	/**
	 * 医保登记就诊主键
	 * @param Id_hpentcode
	 */
	public void setId_hpentcode(String Id_hpentcode) {
		setAttrVal("Id_hpentcode", Id_hpentcode);
	}
	/**
	 * 患者信息
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者信息
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊流水号（医保用）
	 * @return String
	 */
	public String getHp_ent_serial_no() {
		return ((String) getAttrVal("Hp_ent_serial_no"));
	}	
	/**
	 * 就诊流水号（医保用）
	 * @param Hp_ent_serial_no
	 */
	public void setHp_ent_serial_no(String Hp_ent_serial_no) {
		setAttrVal("Hp_ent_serial_no", Hp_ent_serial_no);
	}
	/**
	 * 医保返回登记流水号
	 * @return String
	 */
	public String getHp_serialno() {
		return ((String) getAttrVal("Hp_serialno"));
	}	
	/**
	 * 医保返回登记流水号
	 * @param Hp_serialno
	 */
	public void setHp_serialno(String Hp_serialno) {
		setAttrVal("Hp_serialno", Hp_serialno);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}	
	/**
	 * 医保交易流水号
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * 交易锁定
	 * @return FBoolean
	 */
	public FBoolean getFg_lock() {
		return ((FBoolean) getAttrVal("Fg_lock"));
	}	
	/**
	 * 交易锁定
	 * @param Fg_lock
	 */
	public void setFg_lock(FBoolean Fg_lock) {
		setAttrVal("Fg_lock", Fg_lock);
	}
	/**
	 * 登记日期
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记日期
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 个人编号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 结算发送方交易流水号
	 * @return String
	 */
	public String getSettle_hiscode() {
		return ((String) getAttrVal("Settle_hiscode"));
	}	
	/**
	 * 结算发送方交易流水号
	 * @param Settle_hiscode
	 */
	public void setSettle_hiscode(String Settle_hiscode) {
		setAttrVal("Settle_hiscode", Settle_hiscode);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 医保产品主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 用于处理异常问题
	 * @return String
	 */
	public String getEu_exstatus() {
		return ((String) getAttrVal("Eu_exstatus"));
	}	
	/**
	 * 用于处理异常问题
	 * @param Eu_exstatus
	 */
	public void setEu_exstatus(String Eu_exstatus) {
		setAttrVal("Eu_exstatus", Eu_exstatus);
	}
	/**
	 * 审批编号
	 * @return String
	 */
	public String getApprovno() {
		return ((String) getAttrVal("Approvno"));
	}	
	/**
	 * 审批编号
	 * @param Approvno
	 */
	public void setApprovno(String Approvno) {
		setAttrVal("Approvno", Approvno);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getDicode_reg() {
		return ((String) getAttrVal("Dicode_reg"));
	}	
	/**
	 * 入院诊断
	 * @param Dicode_reg
	 */
	public void setDicode_reg(String Dicode_reg) {
		setAttrVal("Dicode_reg", Dicode_reg);
	}
	/**
	 * 入院诊断编码
	 * @return String
	 */
	public String getDiname_reg() {
		return ((String) getAttrVal("Diname_reg"));
	}	
	/**
	 * 入院诊断编码
	 * @param Diname_reg
	 */
	public void setDiname_reg(String Diname_reg) {
		setAttrVal("Diname_reg", Diname_reg);
	}
	/**
	 * 读卡信息串
	 * @return String
	 */
	public String getRead_card_info() {
		return ((String) getAttrVal("Read_card_info"));
	}	
	/**
	 * 读卡信息串
	 * @param Read_card_info
	 */
	public void setRead_card_info(String Read_card_info) {
		setAttrVal("Read_card_info", Read_card_info);
	}
	/**
	 * 医保登记信息串
	 * @return String
	 */
	public String getRegist_info() {
		return ((String) getAttrVal("Regist_info"));
	}	
	/**
	 * 医保登记信息串
	 * @param Regist_info
	 */
	public void setRegist_info(String Regist_info) {
		setAttrVal("Regist_info", Regist_info);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 病案数据上传标识
	 * @return FBoolean
	 */
	public FBoolean getFg_medupload() {
		return ((FBoolean) getAttrVal("Fg_medupload"));
	}	
	/**
	 * 病案数据上传标识
	 * @param Fg_medupload
	 */
	public void setFg_medupload(FBoolean Fg_medupload) {
		setAttrVal("Fg_medupload", Fg_medupload);
	}
	/**
	 * 客开登记信息
	 * @return String
	 */
	public String getCustom_info() {
		return ((String) getAttrVal("Custom_info"));
	}	
	/**
	 * 客开登记信息
	 * @param Custom_info
	 */
	public void setCustom_info(String Custom_info) {
		setAttrVal("Custom_info", Custom_info);
	}
	/**
	 * 活动操作人员
	 * @return String
	 */
	public String getId_emp_act() {
		return ((String) getAttrVal("Id_emp_act"));
	}	
	/**
	 * 活动操作人员
	 * @param Id_emp_act
	 */
	public void setId_emp_act(String Id_emp_act) {
		setAttrVal("Id_emp_act", Id_emp_act);
	}
	/**
	 * 操作发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	/**
	 * 操作发生时间
	 * @param Dt_act
	 */
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	/**
	 * 电子医保标识
	 * @return FBoolean
	 */
	public FBoolean getFg_elehp() {
		return ((FBoolean) getAttrVal("Fg_elehp"));
	}	
	/**
	 * 电子医保标识
	 * @param Fg_elehp
	 */
	public void setFg_elehp(FBoolean Fg_elehp) {
		setAttrVal("Fg_elehp", Fg_elehp);
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
		return "Id_hpentcode";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_entcode";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpEntCodeDODesc.class);
	}
	
}