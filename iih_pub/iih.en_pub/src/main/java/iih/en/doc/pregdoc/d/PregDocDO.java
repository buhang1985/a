package iih.en.doc.pregdoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.doc.pregdoc.d.desc.PregDocDODesc;
import java.math.BigDecimal;

/**
 * 产科建档 DO数据 
 * 
 */
public class PregDocDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREGDOC= "Id_pregdoc";
	public static final String ID_ENTDOC= "Id_entdoc";
	public static final String ID_ADMDIV_HUSB= "Id_admdiv_husb";
	public static final String SD_ADMDIV_HUSB= "Sd_admdiv_husb";
	public static final String FG_BORN_HERE= "Fg_born_here";
	public static final String D_LAST_MENST= "D_last_menst";
	public static final String D_EXPECT= "D_expect";
	public static final String DT_APPT= "Dt_appt";
	public static final String ID_EMP_APPT= "Id_emp_appt";
	public static final String DT_DOC= "Dt_doc";
	public static final String ID_EMP_DOC= "Id_emp_doc";
	public static final String EU_STATUS= "Eu_status";
	public static final String DT_END= "Dt_end";
	public static final String DT_CANC= "Dt_canc";
	public static final String ID_EMP_CANC= "Id_emp_canc";
	public static final String PREGDOCSTAT= "Pregdocstat";
	public static final String ID_PATCONT= "Id_patcont";
	public static final String NAME_ENTDOC= "Name_entdoc";
	public static final String NAME_ADMDIV_HUSB= "Name_admdiv_husb";
	public static final String NAME_EMP_APPT= "Name_emp_appt";
	public static final String NAME_EMP_DOC= "Name_emp_doc";
	public static final String NAME_EMP_CANC= "Name_emp_canc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pregdoc() {
		return ((String) getAttrVal("Id_pregdoc"));
	}	
	public void setId_pregdoc(String Id_pregdoc) {
		setAttrVal("Id_pregdoc", Id_pregdoc);
	}
	public String getId_entdoc() {
		return ((String) getAttrVal("Id_entdoc"));
	}	
	public void setId_entdoc(String Id_entdoc) {
		setAttrVal("Id_entdoc", Id_entdoc);
	}
	public String getId_admdiv_husb() {
		return ((String) getAttrVal("Id_admdiv_husb"));
	}	
	public void setId_admdiv_husb(String Id_admdiv_husb) {
		setAttrVal("Id_admdiv_husb", Id_admdiv_husb);
	}
	public String getSd_admdiv_husb() {
		return ((String) getAttrVal("Sd_admdiv_husb"));
	}	
	public void setSd_admdiv_husb(String Sd_admdiv_husb) {
		setAttrVal("Sd_admdiv_husb", Sd_admdiv_husb);
	}
	public FBoolean getFg_born_here() {
		return ((FBoolean) getAttrVal("Fg_born_here"));
	}	
	public void setFg_born_here(FBoolean Fg_born_here) {
		setAttrVal("Fg_born_here", Fg_born_here);
	}
	public FDate getD_last_menst() {
		return ((FDate) getAttrVal("D_last_menst"));
	}	
	public void setD_last_menst(FDate D_last_menst) {
		setAttrVal("D_last_menst", D_last_menst);
	}
	public FDate getD_expect() {
		return ((FDate) getAttrVal("D_expect"));
	}	
	public void setD_expect(FDate D_expect) {
		setAttrVal("D_expect", D_expect);
	}
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}	
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}	
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	public FDateTime getDt_doc() {
		return ((FDateTime) getAttrVal("Dt_doc"));
	}	
	public void setDt_doc(FDateTime Dt_doc) {
		setAttrVal("Dt_doc", Dt_doc);
	}
	public String getId_emp_doc() {
		return ((String) getAttrVal("Id_emp_doc"));
	}	
	public void setId_emp_doc(String Id_emp_doc) {
		setAttrVal("Id_emp_doc", Id_emp_doc);
	}
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	public String getPregdocstat() {
		return ((String) getAttrVal("Pregdocstat"));
	}	
	public void setPregdocstat(String Pregdocstat) {
		setAttrVal("Pregdocstat", Pregdocstat);
	}
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}	
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	public String getName_entdoc() {
		return ((String) getAttrVal("Name_entdoc"));
	}	
	public void setName_entdoc(String Name_entdoc) {
		setAttrVal("Name_entdoc", Name_entdoc);
	}
	public String getName_admdiv_husb() {
		return ((String) getAttrVal("Name_admdiv_husb"));
	}	
	public void setName_admdiv_husb(String Name_admdiv_husb) {
		setAttrVal("Name_admdiv_husb", Name_admdiv_husb);
	}
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}	
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
	}
	public String getName_emp_doc() {
		return ((String) getAttrVal("Name_emp_doc"));
	}	
	public void setName_emp_doc(String Name_emp_doc) {
		setAttrVal("Name_emp_doc", Name_emp_doc);
	}
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}	
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
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
		return "Id_patcont";
	}
	
	@Override
	public String getTableName() {	  
		return "en_doc_preg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PregDocDODesc.class);
	}
	
}