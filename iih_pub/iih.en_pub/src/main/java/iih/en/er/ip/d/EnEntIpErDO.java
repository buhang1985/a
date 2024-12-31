package iih.en.er.ip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.er.ip.d.desc.EnEntIpErDODesc;
import java.math.BigDecimal;

/**
 * 急诊就诊_住院急诊 DO数据 
 * 
 */
public class EnEntIpErDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院急诊id
	public static final String ID_ENIPER= "Id_eniper";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//预检id
	public static final String ID_ERPRE= "Id_erpre";
	//首次就诊id
	public static final String ID_ENT_FST= "Id_ent_fst";
	//检伤分级id
	public static final String ID_SCALE_TRIAGE= "Id_scale_triage";
	//检伤分级编码
	public static final String SD_SCALE_TRIAGE= "Sd_scale_triage";
	//三无人员
	public static final String FG_NONPERSON= "Fg_nonperson";
	//出院意识
	public static final String OUT_SENCE= "Out_sence";
	//出院方式
	public static final String EU_OUT_WAY= "Eu_out_way";
	//离院时间
	public static final String DT_LEAVE= "Dt_leave";
	//急诊转归id
	public static final String ID_GOWHERE_ER= "Id_gowhere_er";
	//急诊转归编码
	public static final String SD_GOWHERE_ER= "Sd_gowhere_er";
	//名称
	public static final String NAME_SCALE_TRIAGE= "Name_scale_triage";
	//急诊转归
	public static final String NAME_GOWHERE_ER= "Name_gowhere_er";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院急诊id
	 * @return String
	 */
	public String getId_eniper() {
		return ((String) getAttrVal("Id_eniper"));
	}	
	/**
	 * 住院急诊id
	 * @param Id_eniper
	 */
	public void setId_eniper(String Id_eniper) {
		setAttrVal("Id_eniper", Id_eniper);
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
	 * 出院意识
	 * @return String
	 */
	public String getOut_sence() {
		return ((String) getAttrVal("Out_sence"));
	}	
	/**
	 * 出院意识
	 * @param Out_sence
	 */
	public void setOut_sence(String Out_sence) {
		setAttrVal("Out_sence", Out_sence);
	}
	/**
	 * 出院方式
	 * @return String
	 */
	public String getEu_out_way() {
		return ((String) getAttrVal("Eu_out_way"));
	}	
	/**
	 * 出院方式
	 * @param Eu_out_way
	 */
	public void setEu_out_way(String Eu_out_way) {
		setAttrVal("Eu_out_way", Eu_out_way);
	}
	/**
	 * 离院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_leave() {
		return ((FDateTime) getAttrVal("Dt_leave"));
	}	
	/**
	 * 离院时间
	 * @param Dt_leave
	 */
	public void setDt_leave(FDateTime Dt_leave) {
		setAttrVal("Dt_leave", Dt_leave);
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
	 * 名称
	 * @return String
	 */
	public String getName_scale_triage() {
		return ((String) getAttrVal("Name_scale_triage"));
	}	
	/**
	 * 名称
	 * @param Name_scale_triage
	 */
	public void setName_scale_triage(String Name_scale_triage) {
		setAttrVal("Name_scale_triage", Name_scale_triage);
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
		return "Id_eniper";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_IP_ER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnEntIpErDODesc.class);
	}
	
}