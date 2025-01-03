package iih.mi.biz.miregop.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.miregop.d.desc.MiRegOpDODesc;
import java.math.BigDecimal;

/**
 * 门诊医保就诊登记信息 DO数据 
 * 
 */
public class MiRegOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊医保计划主键
	public static final String ID_ENTHP= "Id_enthp";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//结算号
	public static final String CODE_ST= "Code_st";
	//医保返回流水号
	public static final String HP_SERIALNO= "Hp_serialno";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//HIS患者分类主键
	public static final String ID_PATCA= "Id_patca";
	//医疗类别
	public static final String SD_HPMEDKIND= "Sd_hpmedkind";
	//医疗待遇类别
	public static final String SD_HPKIND= "Sd_hpkind";
	//医保人员类别
	public static final String SD_HPPATCA= "Sd_hppatca";
	//医保统筹地区
	public static final String CODE_AREA= "Code_area";
	//个人编号
	public static final String PERSONNO= "Personno";
	//社会保障卡卡号
	public static final String NO_HP= "No_hp";
	//社会保障号
	public static final String ID_CODE_HP= "Id_code_hp";
	//公务员标志
	public static final String SD_OFFICIAL= "Sd_official";
	//异地人员标志 
	public static final String SD_ALLO= "Sd_allo";
	//贫困标志
	public static final String SD_POOR= "Sd_poor";
	//民政标志
	public static final String SD_CIVIL= "Sd_civil";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//医保计划名称
	public static final String NAME_HP= "Name_hp";
	//医保计划编码
	public static final String CODE_HP= "Code_hp";
	//患者分类名称
	public static final String NAME_PATCA= "Name_patca";
	//患者分类编码
	public static final String CODE_PATCA= "Code_patca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊医保计划主键
	 * @return String
	 */
	public String getId_enthp() {
		return ((String) getAttrVal("Id_enthp"));
	}	
	/**
	 * 患者就诊医保计划主键
	 * @param Id_enthp
	 */
	public void setId_enthp(String Id_enthp) {
		setAttrVal("Id_enthp", Id_enthp);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}	
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 医保返回流水号
	 * @return String
	 */
	public String getHp_serialno() {
		return ((String) getAttrVal("Hp_serialno"));
	}	
	/**
	 * 医保返回流水号
	 * @param Hp_serialno
	 */
	public void setHp_serialno(String Hp_serialno) {
		setAttrVal("Hp_serialno", Hp_serialno);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * HIS患者分类主键
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * HIS患者分类主键
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getSd_hpmedkind() {
		return ((String) getAttrVal("Sd_hpmedkind"));
	}	
	/**
	 * 医疗类别
	 * @param Sd_hpmedkind
	 */
	public void setSd_hpmedkind(String Sd_hpmedkind) {
		setAttrVal("Sd_hpmedkind", Sd_hpmedkind);
	}
	/**
	 * 医疗待遇类别
	 * @return String
	 */
	public String getSd_hpkind() {
		return ((String) getAttrVal("Sd_hpkind"));
	}	
	/**
	 * 医疗待遇类别
	 * @param Sd_hpkind
	 */
	public void setSd_hpkind(String Sd_hpkind) {
		setAttrVal("Sd_hpkind", Sd_hpkind);
	}
	/**
	 * 医保人员类别
	 * @return String
	 */
	public String getSd_hppatca() {
		return ((String) getAttrVal("Sd_hppatca"));
	}	
	/**
	 * 医保人员类别
	 * @param Sd_hppatca
	 */
	public void setSd_hppatca(String Sd_hppatca) {
		setAttrVal("Sd_hppatca", Sd_hppatca);
	}
	/**
	 * 医保统筹地区
	 * @return String
	 */
	public String getCode_area() {
		return ((String) getAttrVal("Code_area"));
	}	
	/**
	 * 医保统筹地区
	 * @param Code_area
	 */
	public void setCode_area(String Code_area) {
		setAttrVal("Code_area", Code_area);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}	
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 社会保障卡卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 社会保障卡卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 社会保障号
	 * @return String
	 */
	public String getId_code_hp() {
		return ((String) getAttrVal("Id_code_hp"));
	}	
	/**
	 * 社会保障号
	 * @param Id_code_hp
	 */
	public void setId_code_hp(String Id_code_hp) {
		setAttrVal("Id_code_hp", Id_code_hp);
	}
	/**
	 * 公务员标志
	 * @return String
	 */
	public String getSd_official() {
		return ((String) getAttrVal("Sd_official"));
	}	
	/**
	 * 公务员标志
	 * @param Sd_official
	 */
	public void setSd_official(String Sd_official) {
		setAttrVal("Sd_official", Sd_official);
	}
	/**
	 * 异地人员标志 
	 * @return String
	 */
	public String getSd_allo() {
		return ((String) getAttrVal("Sd_allo"));
	}	
	/**
	 * 异地人员标志 
	 * @param Sd_allo
	 */
	public void setSd_allo(String Sd_allo) {
		setAttrVal("Sd_allo", Sd_allo);
	}
	/**
	 * 贫困标志
	 * @return String
	 */
	public String getSd_poor() {
		return ((String) getAttrVal("Sd_poor"));
	}	
	/**
	 * 贫困标志
	 * @param Sd_poor
	 */
	public void setSd_poor(String Sd_poor) {
		setAttrVal("Sd_poor", Sd_poor);
	}
	/**
	 * 民政标志
	 * @return String
	 */
	public String getSd_civil() {
		return ((String) getAttrVal("Sd_civil"));
	}	
	/**
	 * 民政标志
	 * @param Sd_civil
	 */
	public void setSd_civil(String Sd_civil) {
		setAttrVal("Sd_civil", Sd_civil);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
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
		return "Id_enthp";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_reg_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiRegOpDODesc.class);
	}
	
}