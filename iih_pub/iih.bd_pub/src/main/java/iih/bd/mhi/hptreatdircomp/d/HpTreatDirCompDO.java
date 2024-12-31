package iih.bd.mhi.hptreatdircomp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hptreatdircomp.d.desc.HpTreatDirCompDODesc;
import java.math.BigDecimal;

/**
 * 医保产品_诊疗对照 DO数据 
 * 
 */
public class HpTreatDirCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_COMP_TREAT= "Id_comp_treat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_TREAT= "Id_treat";
	public static final String CODE= "Code";
	public static final String EU_STATUS= "Eu_status";
	public static final String DT_APPROVED= "Dt_approved";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String TREAT_NAME= "Treat_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_comp_treat() {
		return ((String) getAttrVal("Id_comp_treat"));
	}	
	public void setId_comp_treat(String Id_comp_treat) {
		setAttrVal("Id_comp_treat", Id_comp_treat);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_treat() {
		return ((String) getAttrVal("Id_treat"));
	}	
	public void setId_treat(String Id_treat) {
		setAttrVal("Id_treat", Id_treat);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	public FDateTime getDt_approved() {
		return ((FDateTime) getAttrVal("Dt_approved"));
	}	
	public void setDt_approved(FDateTime Dt_approved) {
		setAttrVal("Dt_approved", Dt_approved);
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
	public String getTreat_name() {
		return ((String) getAttrVal("Treat_name"));
	}	
	public void setTreat_name(String Treat_name) {
		setAttrVal("Treat_name", Treat_name);
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
		return "Id_comp_treat";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_COMP_TREAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTreatDirCompDODesc.class);
	}
	
}