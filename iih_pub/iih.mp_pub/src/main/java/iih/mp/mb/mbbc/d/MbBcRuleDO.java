package iih.mp.mb.mbbc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mb.mbbc.d.desc.MbBcRuleDODesc;
import java.math.BigDecimal;

/**
 * 条码对照规则 DO数据 
 * 
 */
public class MbBcRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MB_BC_RULE= "Id_mb_bc_rule";
	public static final String ID_MB_BC= "Id_mb_bc";
	public static final String SORTNO= "Sortno";
	public static final String EU_ELETP= "Eu_eletp";
	public static final String VAL= "Val";
	public static final String ID_BIZVAL= "Id_bizval";
	public static final String SD_BIZVAL= "Sd_bizval";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_BIZVAL= "Name_bizval";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mb_bc_rule() {
		return ((String) getAttrVal("Id_mb_bc_rule"));
	}	
	public void setId_mb_bc_rule(String Id_mb_bc_rule) {
		setAttrVal("Id_mb_bc_rule", Id_mb_bc_rule);
	}
	public String getId_mb_bc() {
		return ((String) getAttrVal("Id_mb_bc"));
	}	
	public void setId_mb_bc(String Id_mb_bc) {
		setAttrVal("Id_mb_bc", Id_mb_bc);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public Integer getEu_eletp() {
		return ((Integer) getAttrVal("Eu_eletp"));
	}	
	public void setEu_eletp(Integer Eu_eletp) {
		setAttrVal("Eu_eletp", Eu_eletp);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public String getId_bizval() {
		return ((String) getAttrVal("Id_bizval"));
	}	
	public void setId_bizval(String Id_bizval) {
		setAttrVal("Id_bizval", Id_bizval);
	}
	public String getSd_bizval() {
		return ((String) getAttrVal("Sd_bizval"));
	}	
	public void setSd_bizval(String Sd_bizval) {
		setAttrVal("Sd_bizval", Sd_bizval);
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
	public String getName_bizval() {
		return ((String) getAttrVal("Name_bizval"));
	}	
	public void setName_bizval(String Name_bizval) {
		setAttrVal("Name_bizval", Name_bizval);
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
		return "Id_mb_bc_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_MB_BC_RULE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MbBcRuleDODesc.class);
	}
	
}