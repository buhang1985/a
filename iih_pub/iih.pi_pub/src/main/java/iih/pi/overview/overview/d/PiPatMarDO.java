package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatMarDODesc;
import java.math.BigDecimal;

/**
 * 患者婚姻史 DO数据 
 * 
 */
public class PiPatMarDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATMAR= "Id_patmar";
	public static final String ID_PAT= "Id_pat";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String AGE_MAR= "Age_mar";
	public static final String DES_SPO= "Des_spo";
	public static final String FG_CON= "Fg_con";
	public static final String SD_BLOOD_REL= "Sd_blood_rel";
	public static final String ID_BLOOD_REL= "Id_blood_rel";
	public static final String DES_SEX= "Des_sex";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String DT_ACT= "Dt_act";
	public static final String BLOODREL_NAME= "Bloodrel_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patmar() {
		return ((String) getAttrVal("Id_patmar"));
	}	
	public void setId_patmar(String Id_patmar) {
		setAttrVal("Id_patmar", Id_patmar);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public Integer getAge_mar() {
		return ((Integer) getAttrVal("Age_mar"));
	}	
	public void setAge_mar(Integer Age_mar) {
		setAttrVal("Age_mar", Age_mar);
	}
	public String getDes_spo() {
		return ((String) getAttrVal("Des_spo"));
	}	
	public void setDes_spo(String Des_spo) {
		setAttrVal("Des_spo", Des_spo);
	}
	public FBoolean getFg_con() {
		return ((FBoolean) getAttrVal("Fg_con"));
	}	
	public void setFg_con(FBoolean Fg_con) {
		setAttrVal("Fg_con", Fg_con);
	}
	public String getSd_blood_rel() {
		return ((String) getAttrVal("Sd_blood_rel"));
	}	
	public void setSd_blood_rel(String Sd_blood_rel) {
		setAttrVal("Sd_blood_rel", Sd_blood_rel);
	}
	public String getId_blood_rel() {
		return ((String) getAttrVal("Id_blood_rel"));
	}	
	public void setId_blood_rel(String Id_blood_rel) {
		setAttrVal("Id_blood_rel", Id_blood_rel);
	}
	public String getDes_sex() {
		return ((String) getAttrVal("Des_sex"));
	}	
	public void setDes_sex(String Des_sex) {
		setAttrVal("Des_sex", Des_sex);
	}
	public Integer getId_ymd_act() {
		return ((Integer) getAttrVal("Id_ymd_act"));
	}	
	public void setId_ymd_act(Integer Id_ymd_act) {
		setAttrVal("Id_ymd_act", Id_ymd_act);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getBloodrel_name() {
		return ((String) getAttrVal("Bloodrel_name"));
	}	
	public void setBloodrel_name(String Bloodrel_name) {
		setAttrVal("Bloodrel_name", Bloodrel_name);
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
		return "Id_patmar";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_MAR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatMarDODesc.class);
	}
	
}