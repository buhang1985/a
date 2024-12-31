package iih.pi.card.card.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.card.card.d.desc.PiCardDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊卡 DO数据 
 * 
 */
public class PiCardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//就诊卡主键
	public static final String ID_CARD= "Id_card";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//就诊卡类型
	public static final String ID_PATCARDTP= "Id_patcardtp";
	//就诊卡编号
	public static final String CODE= "Code";
	//就诊卡物理编码
	public static final String INNERCODE= "Innercode";
	//就诊卡状态
	public static final String EU_CARDSU= "Eu_cardsu";
	//录入人
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	//录入时间
	public static final String DT_ENTRY= "Dt_entry";
	//领出标志
	public static final String FG_GET= "Fg_get";
	//当前领用人
	public static final String ID_EMP_GET= "Id_emp_get";
	//当前领用时间
	public static final String DT_GET= "Dt_get";
	//注销标志
	public static final String FG_CANC= "Fg_canc";
	//注销人
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//注销时间
	public static final String DT_CANC= "Dt_canc";
	//注销原因
	public static final String DES_CANC= "Des_canc";
	//卡密标志
	public static final String FG_PASSWORD= "Fg_password";
	//密码
	public static final String PASSWORD= "Password";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊卡状态名称
	public static final String NAME_CARDSU= "Name_cardsu";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//患者卡id
	public static final String ID_PATCARD= "Id_patcard";
	//患者卡类型名称
	public static final String NAME_PATCARDTP= "Name_patcardtp";
	//患者卡类型编码
	public static final String SD_PATCARDTP= "Sd_patcardtp";
	//姓名
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 就诊卡主键
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 就诊卡主键
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 就诊卡类型
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}	
	/**
	 * 就诊卡类型
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 就诊卡编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 就诊卡编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 就诊卡物理编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 就诊卡物理编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 就诊卡状态
	 * @return Integer
	 */
	public Integer getEu_cardsu() {
		return ((Integer) getAttrVal("Eu_cardsu"));
	}	
	/**
	 * 就诊卡状态
	 * @param Eu_cardsu
	 */
	public void setEu_cardsu(Integer Eu_cardsu) {
		setAttrVal("Eu_cardsu", Eu_cardsu);
	}
	/**
	 * 录入人
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	/**
	 * 录入人
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 录入时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 领出标志
	 * @return FBoolean
	 */
	public FBoolean getFg_get() {
		return ((FBoolean) getAttrVal("Fg_get"));
	}	
	/**
	 * 领出标志
	 * @param Fg_get
	 */
	public void setFg_get(FBoolean Fg_get) {
		setAttrVal("Fg_get", Fg_get);
	}
	/**
	 * 当前领用人
	 * @return String
	 */
	public String getId_emp_get() {
		return ((String) getAttrVal("Id_emp_get"));
	}	
	/**
	 * 当前领用人
	 * @param Id_emp_get
	 */
	public void setId_emp_get(String Id_emp_get) {
		setAttrVal("Id_emp_get", Id_emp_get);
	}
	/**
	 * 当前领用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_get() {
		return ((FDateTime) getAttrVal("Dt_get"));
	}	
	/**
	 * 当前领用时间
	 * @param Dt_get
	 */
	public void setDt_get(FDateTime Dt_get) {
		setAttrVal("Dt_get", Dt_get);
	}
	/**
	 * 注销标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 注销标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 注销人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 注销人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 注销时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 注销时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 注销原因
	 * @return String
	 */
	public String getDes_canc() {
		return ((String) getAttrVal("Des_canc"));
	}	
	/**
	 * 注销原因
	 * @param Des_canc
	 */
	public void setDes_canc(String Des_canc) {
		setAttrVal("Des_canc", Des_canc);
	}
	/**
	 * 卡密标志
	 * @return FBoolean
	 */
	public FBoolean getFg_password() {
		return ((FBoolean) getAttrVal("Fg_password"));
	}	
	/**
	 * 卡密标志
	 * @param Fg_password
	 */
	public void setFg_password(FBoolean Fg_password) {
		setAttrVal("Fg_password", Fg_password);
	}
	/**
	 * 密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}	
	/**
	 * 密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 就诊卡状态名称
	 * @return String
	 */
	public String getName_cardsu() {
		return ((String) getAttrVal("Name_cardsu"));
	}	
	/**
	 * 就诊卡状态名称
	 * @param Name_cardsu
	 */
	public void setName_cardsu(String Name_cardsu) {
		setAttrVal("Name_cardsu", Name_cardsu);
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
	 * 患者卡id
	 * @return String
	 */
	public String getId_patcard() {
		return ((String) getAttrVal("Id_patcard"));
	}	
	/**
	 * 患者卡id
	 * @param Id_patcard
	 */
	public void setId_patcard(String Id_patcard) {
		setAttrVal("Id_patcard", Id_patcard);
	}
	/**
	 * 患者卡类型名称
	 * @return String
	 */
	public String getName_patcardtp() {
		return ((String) getAttrVal("Name_patcardtp"));
	}	
	/**
	 * 患者卡类型名称
	 * @param Name_patcardtp
	 */
	public void setName_patcardtp(String Name_patcardtp) {
		setAttrVal("Name_patcardtp", Name_patcardtp);
	}
	/**
	 * 患者卡类型编码
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}	
	/**
	 * 患者卡类型编码
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
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
		return "Id_card";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_card";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiCardDODesc.class);
	}
	
}