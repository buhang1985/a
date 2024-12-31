package iih.en.doc.endoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.doc.endoc.d.desc.EntDocFlupDODesc;
import java.math.BigDecimal;

/**
 * 随访记录 DO数据 
 * 
 */
public class EntDocFlupDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENDOCFLUP= "Id_endocflup";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTDOC= "Id_entdoc";
	public static final String ID_APT= "Id_apt";
	public static final String DT_FLUP= "Dt_flup";
	public static final String CONTENT= "Content";
	public static final String DT_INSERT= "Dt_insert";
	public static final String ID_EMP_INSERT= "Id_emp_insert";
	public static final String EU_FLUP= "Eu_flup";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_endocflup() {
		return ((String) getAttrVal("Id_endocflup"));
	}	
	public void setId_endocflup(String Id_endocflup) {
		setAttrVal("Id_endocflup", Id_endocflup);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_entdoc() {
		return ((String) getAttrVal("Id_entdoc"));
	}	
	public void setId_entdoc(String Id_entdoc) {
		setAttrVal("Id_entdoc", Id_entdoc);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public FDateTime getDt_flup() {
		return ((FDateTime) getAttrVal("Dt_flup"));
	}	
	public void setDt_flup(FDateTime Dt_flup) {
		setAttrVal("Dt_flup", Dt_flup);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	public String getId_emp_insert() {
		return ((String) getAttrVal("Id_emp_insert"));
	}	
	public void setId_emp_insert(String Id_emp_insert) {
		setAttrVal("Id_emp_insert", Id_emp_insert);
	}
	public Integer getEu_flup() {
		return ((Integer) getAttrVal("Eu_flup"));
	}	
	public void setEu_flup(Integer Eu_flup) {
		setAttrVal("Eu_flup", Eu_flup);
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
		return "Id_endocflup";
	}
	
	@Override
	public String getTableName() {	  
		return "en_doc_flup";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntDocFlupDODesc.class);
	}
	
}