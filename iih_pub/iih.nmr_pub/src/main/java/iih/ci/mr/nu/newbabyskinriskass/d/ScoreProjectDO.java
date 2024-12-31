package iih.ci.mr.nu.newbabyskinriskass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.newbabyskinriskass.d.desc.ScoreProjectDODesc;
import java.math.BigDecimal;

/**
 * 新生儿皮肤风险评估评分项目 DO数据 
 * 
 */
public class ScoreProjectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPRO= "Id_scpro";
	public static final String ID_BABYSKINASS= "Id_babyskinass";
	public static final String ID_PRO_SCORE= "Id_pro_score";
	public static final String SD_PRO_SCORE= "Sd_pro_score";
	public static final String ID_PRO_CHECK= "Id_pro_check";
	public static final String NAME_CHECK= "Name_check";
	public static final String SC_PRO= "Sc_pro";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PRO_SCORE= "Name_pro_score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scpro() {
		return ((String) getAttrVal("Id_scpro"));
	}	
	public void setId_scpro(String Id_scpro) {
		setAttrVal("Id_scpro", Id_scpro);
	}
	public String getId_babyskinass() {
		return ((String) getAttrVal("Id_babyskinass"));
	}	
	public void setId_babyskinass(String Id_babyskinass) {
		setAttrVal("Id_babyskinass", Id_babyskinass);
	}
	public String getId_pro_score() {
		return ((String) getAttrVal("Id_pro_score"));
	}	
	public void setId_pro_score(String Id_pro_score) {
		setAttrVal("Id_pro_score", Id_pro_score);
	}
	public String getSd_pro_score() {
		return ((String) getAttrVal("Sd_pro_score"));
	}	
	public void setSd_pro_score(String Sd_pro_score) {
		setAttrVal("Sd_pro_score", Sd_pro_score);
	}
	public String getId_pro_check() {
		return ((String) getAttrVal("Id_pro_check"));
	}	
	public void setId_pro_check(String Id_pro_check) {
		setAttrVal("Id_pro_check", Id_pro_check);
	}
	public String getName_check() {
		return ((String) getAttrVal("Name_check"));
	}	
	public void setName_check(String Name_check) {
		setAttrVal("Name_check", Name_check);
	}
	public Integer getSc_pro() {
		return ((Integer) getAttrVal("Sc_pro"));
	}	
	public void setSc_pro(Integer Sc_pro) {
		setAttrVal("Sc_pro", Sc_pro);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_pro_score() {
		return ((String) getAttrVal("Name_pro_score"));
	}	
	public void setName_pro_score(String Name_pro_score) {
		setAttrVal("Name_pro_score", Name_pro_score);
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
		return "Id_scpro";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_BYSKINASS_SCPRO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScoreProjectDODesc.class);
	}
	
}