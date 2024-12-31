package iih.mp.nr.skinrcod.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.skinrcod.d.desc.SkinRcodDODesc;
import java.math.BigDecimal;

/**
 * 皮试结果更新记录 DO数据 
 * 
 */
public class SkinRcodDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SKIN_RCOD= "Id_skin_rcod";
	public static final String ID_SKINTEST= "Id_skintest";
	public static final String EU_RCOD= "Eu_rcod";
	public static final String ID_RST_SKINTEST_ORGL= "Id_rst_skintest_orgl";
	public static final String SD_RST_SKINTEST_ORGL= "Sd_rst_skintest_orgl";
	public static final String ID_EMP_ORGL= "Id_emp_orgl";
	public static final String DT_RST_ORGL= "Dt_rst_orgl";
	public static final String ID_RST_SKINTEST_NEW= "Id_rst_skintest_new";
	public static final String SD_RST_SKINTEST_NEW= "Sd_rst_skintest_new";
	public static final String ID_EMP_NEW= "Id_emp_new";
	public static final String DT_RST_NEW= "Dt_rst_new";
	public static final String DT_OPER= "Dt_oper";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_RST_ORGL= "Name_rst_orgl";
	public static final String NAME_EMP_ORGL= "Name_emp_orgl";
	public static final String NAME_RST_NEW= "Name_rst_new";
	public static final String NAME_EMP_NEW= "Name_emp_new";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_skin_rcod() {
		return ((String) getAttrVal("Id_skin_rcod"));
	}	
	public void setId_skin_rcod(String Id_skin_rcod) {
		setAttrVal("Id_skin_rcod", Id_skin_rcod);
	}
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}	
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	public Integer getEu_rcod() {
		return ((Integer) getAttrVal("Eu_rcod"));
	}	
	public void setEu_rcod(Integer Eu_rcod) {
		setAttrVal("Eu_rcod", Eu_rcod);
	}
	public String getId_rst_skintest_orgl() {
		return ((String) getAttrVal("Id_rst_skintest_orgl"));
	}	
	public void setId_rst_skintest_orgl(String Id_rst_skintest_orgl) {
		setAttrVal("Id_rst_skintest_orgl", Id_rst_skintest_orgl);
	}
	public String getSd_rst_skintest_orgl() {
		return ((String) getAttrVal("Sd_rst_skintest_orgl"));
	}	
	public void setSd_rst_skintest_orgl(String Sd_rst_skintest_orgl) {
		setAttrVal("Sd_rst_skintest_orgl", Sd_rst_skintest_orgl);
	}
	public String getId_emp_orgl() {
		return ((String) getAttrVal("Id_emp_orgl"));
	}	
	public void setId_emp_orgl(String Id_emp_orgl) {
		setAttrVal("Id_emp_orgl", Id_emp_orgl);
	}
	public FDateTime getDt_rst_orgl() {
		return ((FDateTime) getAttrVal("Dt_rst_orgl"));
	}	
	public void setDt_rst_orgl(FDateTime Dt_rst_orgl) {
		setAttrVal("Dt_rst_orgl", Dt_rst_orgl);
	}
	public String getId_rst_skintest_new() {
		return ((String) getAttrVal("Id_rst_skintest_new"));
	}	
	public void setId_rst_skintest_new(String Id_rst_skintest_new) {
		setAttrVal("Id_rst_skintest_new", Id_rst_skintest_new);
	}
	public String getSd_rst_skintest_new() {
		return ((String) getAttrVal("Sd_rst_skintest_new"));
	}	
	public void setSd_rst_skintest_new(String Sd_rst_skintest_new) {
		setAttrVal("Sd_rst_skintest_new", Sd_rst_skintest_new);
	}
	public String getId_emp_new() {
		return ((String) getAttrVal("Id_emp_new"));
	}	
	public void setId_emp_new(String Id_emp_new) {
		setAttrVal("Id_emp_new", Id_emp_new);
	}
	public FDateTime getDt_rst_new() {
		return ((FDateTime) getAttrVal("Dt_rst_new"));
	}	
	public void setDt_rst_new(FDateTime Dt_rst_new) {
		setAttrVal("Dt_rst_new", Dt_rst_new);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	public String getName_rst_orgl() {
		return ((String) getAttrVal("Name_rst_orgl"));
	}	
	public void setName_rst_orgl(String Name_rst_orgl) {
		setAttrVal("Name_rst_orgl", Name_rst_orgl);
	}
	public String getName_emp_orgl() {
		return ((String) getAttrVal("Name_emp_orgl"));
	}	
	public void setName_emp_orgl(String Name_emp_orgl) {
		setAttrVal("Name_emp_orgl", Name_emp_orgl);
	}
	public String getName_rst_new() {
		return ((String) getAttrVal("Name_rst_new"));
	}	
	public void setName_rst_new(String Name_rst_new) {
		setAttrVal("Name_rst_new", Name_rst_new);
	}
	public String getName_emp_new() {
		return ((String) getAttrVal("Name_emp_new"));
	}	
	public void setName_emp_new(String Name_emp_new) {
		setAttrVal("Name_emp_new", Name_emp_new);
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
		return "Id_skin_rcod";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skin_rcod";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SkinRcodDODesc.class);
	}
	
}