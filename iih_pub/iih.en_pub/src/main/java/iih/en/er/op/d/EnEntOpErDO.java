package iih.en.er.op.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.er.op.d.desc.EnEntOpErDODesc;
import java.math.BigDecimal;

/**
 * 急诊就诊_门诊急诊 DO数据 
 * 
 */
public class EnEntOpErDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊急诊id
	public static final String ID_ENOPER= "Id_enoper";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//预检id
	public static final String ID_ERPRE= "Id_erpre";
	//床位id
	public static final String ID_BED= "Id_bed";
	//首次就诊id
	public static final String ID_ENT_FST= "Id_ent_fst";
	//检伤分级id
	public static final String ID_SCALE_TRIAGE= "Id_scale_triage";
	//检伤分级编码
	public static final String SD_SCALE_TRIAGE= "Sd_scale_triage";
	//三无人员
	public static final String FG_NONPERSON= "Fg_nonperson";
	//护理等级id
	public static final String ID_LEVEL_NUR= "Id_level_nur";
	//护理等级编码
	public static final String SD_LEVEL_NUR= "Sd_level_nur";
	//急诊转归id
	public static final String ID_GOWHERE_ER= "Id_gowhere_er";
	//急诊转归编码
	public static final String SD_GOWHERE_ER= "Sd_gowhere_er";
	//流水转抢救标志
	public static final String FG_TRANS= "Fg_trans";
	//床位编码
	public static final String CODE_BED= "Code_bed";
	//床位名称
	public static final String NAME_BED= "Name_bed";
	//分级名称
	public static final String NAME_SCALE_TRIAGE= "Name_scale_triage";
	//护理等级名称
	public static final String NAME_LEVEL_NUR= "Name_level_nur";
	//急诊转归
	public static final String NAME_GOWHERE_ER= "Name_gowhere_er";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊急诊id
	 * @return String
	 */
	public String getId_enoper() {
		return ((String) getAttrVal("Id_enoper"));
	}	
	/**
	 * 门诊急诊id
	 * @param Id_enoper
	 */
	public void setId_enoper(String Id_enoper) {
		setAttrVal("Id_enoper", Id_enoper);
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
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}	
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 首次就诊id
	 * @return String
	 */
	public String getId_ent_fst() {
		return ((String) getAttrVal("Id_ent_fst"));
	}	
	/**
	 * 首次就诊id
	 * @param Id_ent_fst
	 */
	public void setId_ent_fst(String Id_ent_fst) {
		setAttrVal("Id_ent_fst", Id_ent_fst);
	}
	/**
	 * 检伤分级id
	 * @return String
	 */
	public String getId_scale_triage() {
		return ((String) getAttrVal("Id_scale_triage"));
	}	
	/**
	 * 检伤分级id
	 * @param Id_scale_triage
	 */
	public void setId_scale_triage(String Id_scale_triage) {
		setAttrVal("Id_scale_triage", Id_scale_triage);
	}
	/**
	 * 检伤分级编码
	 * @return String
	 */
	public String getSd_scale_triage() {
		return ((String) getAttrVal("Sd_scale_triage"));
	}	
	/**
	 * 检伤分级编码
	 * @param Sd_scale_triage
	 */
	public void setSd_scale_triage(String Sd_scale_triage) {
		setAttrVal("Sd_scale_triage", Sd_scale_triage);
	}
	/**
	 * 三无人员
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}	
	/**
	 * 三无人员
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}	
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}	
	/**
	 * 护理等级编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 急诊转归id
	 * @return String
	 */
	public String getId_gowhere_er() {
		return ((String) getAttrVal("Id_gowhere_er"));
	}	
	/**
	 * 急诊转归id
	 * @param Id_gowhere_er
	 */
	public void setId_gowhere_er(String Id_gowhere_er) {
		setAttrVal("Id_gowhere_er", Id_gowhere_er);
	}
	/**
	 * 急诊转归编码
	 * @return String
	 */
	public String getSd_gowhere_er() {
		return ((String) getAttrVal("Sd_gowhere_er"));
	}	
	/**
	 * 急诊转归编码
	 * @param Sd_gowhere_er
	 */
	public void setSd_gowhere_er(String Sd_gowhere_er) {
		setAttrVal("Sd_gowhere_er", Sd_gowhere_er);
	}
	/**
	 * 流水转抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_trans() {
		return ((FBoolean) getAttrVal("Fg_trans"));
	}	
	/**
	 * 流水转抢救标志
	 * @param Fg_trans
	 */
	public void setFg_trans(FBoolean Fg_trans) {
		setAttrVal("Fg_trans", Fg_trans);
	}
	/**
	 * 床位编码
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床位编码
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床位名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 分级名称
	 * @return String
	 */
	public String getName_scale_triage() {
		return ((String) getAttrVal("Name_scale_triage"));
	}	
	/**
	 * 分级名称
	 * @param Name_scale_triage
	 */
	public void setName_scale_triage(String Name_scale_triage) {
		setAttrVal("Name_scale_triage", Name_scale_triage);
	}
	/**
	 * 护理等级名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}	
	/**
	 * 护理等级名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 急诊转归
	 * @return String
	 */
	public String getName_gowhere_er() {
		return ((String) getAttrVal("Name_gowhere_er"));
	}	
	/**
	 * 急诊转归
	 * @param Name_gowhere_er
	 */
	public void setName_gowhere_er(String Name_gowhere_er) {
		setAttrVal("Name_gowhere_er", Name_gowhere_er);
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
		return "Id_enoper";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_OP_ER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnEntOpErDODesc.class);
	}
	
}