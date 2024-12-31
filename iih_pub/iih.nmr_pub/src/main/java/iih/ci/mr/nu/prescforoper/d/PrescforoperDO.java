package iih.ci.mr.nu.prescforoper.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.prescforoper.d.desc.PrescforoperDODesc;
import java.math.BigDecimal;

/**
 * 手术室患者压疮危险因素评分表 DO数据 
 * 
 */
public class PrescforoperDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRESCFOROPER= "Id_prescforoper";
	public static final String ID_PRESCFOR= "Id_prescfor";
	public static final String ID_EVAL_PRO= "Id_eval_pro";
	public static final String SD_EVAL_PRO= "Sd_eval_pro";
	public static final String ID_PRO_CHECK= "Id_pro_check";
	public static final String NAME_PRO_CHECK= "Name_pro_check";
	public static final String SC_PRO= "Sc_pro";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EVAL_PRO= "Name_eval_pro";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prescforoper() {
		return ((String) getAttrVal("Id_prescforoper"));
	}	
	public void setId_prescforoper(String Id_prescforoper) {
		setAttrVal("Id_prescforoper", Id_prescforoper);
	}
	public String getId_prescfor() {
		return ((String) getAttrVal("Id_prescfor"));
	}	
	public void setId_prescfor(String Id_prescfor) {
		setAttrVal("Id_prescfor", Id_prescfor);
	}
	public String getId_eval_pro() {
		return ((String) getAttrVal("Id_eval_pro"));
	}	
	public void setId_eval_pro(String Id_eval_pro) {
		setAttrVal("Id_eval_pro", Id_eval_pro);
	}
	public String getSd_eval_pro() {
		return ((String) getAttrVal("Sd_eval_pro"));
	}	
	public void setSd_eval_pro(String Sd_eval_pro) {
		setAttrVal("Sd_eval_pro", Sd_eval_pro);
	}
	public String getId_pro_check() {
		return ((String) getAttrVal("Id_pro_check"));
	}	
	public void setId_pro_check(String Id_pro_check) {
		setAttrVal("Id_pro_check", Id_pro_check);
	}
	public String getName_pro_check() {
		return ((String) getAttrVal("Name_pro_check"));
	}	
	public void setName_pro_check(String Name_pro_check) {
		setAttrVal("Name_pro_check", Name_pro_check);
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
	public String getName_eval_pro() {
		return ((String) getAttrVal("Name_eval_pro"));
	}	
	public void setName_eval_pro(String Name_eval_pro) {
		setAttrVal("Name_eval_pro", Name_eval_pro);
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
		return "Id_prescforoper";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_prescforoper";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PrescforoperDODesc.class);
	}
	
}