package iih.ei.varp.quoteevalrlt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ei.varp.quoteevalrlt.d.desc.EiVarpQuoteEvalRltDODesc;
import java.math.BigDecimal;

/**
 * 报价器评价结果 DO数据 
 * 
 */
public class EiVarpQuoteEvalRltDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EVALRLT= "Id_evalrlt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_STOEP= "Id_stoep";
	public static final String ID_BIZTP= "Id_biztp";
	public static final String SD_BIZTP= "Sd_biztp";
	public static final String ID_APPRAISALTP= "Id_appraisaltp";
	public static final String SD_APPRAISALTP= "Sd_appraisaltp";
	public static final String DT_APPRAISAL= "Dt_appraisal";
	public static final String ID_EMP= "Id_emp";
	public static final String WINDOW_NO= "Window_no";
	public static final String NOTE= "Note";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_evalrlt() {
		return ((String) getAttrVal("Id_evalrlt"));
	}	
	public void setId_evalrlt(String Id_evalrlt) {
		setAttrVal("Id_evalrlt", Id_evalrlt);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	public String getId_biztp() {
		return ((String) getAttrVal("Id_biztp"));
	}	
	public void setId_biztp(String Id_biztp) {
		setAttrVal("Id_biztp", Id_biztp);
	}
	public String getSd_biztp() {
		return ((String) getAttrVal("Sd_biztp"));
	}	
	public void setSd_biztp(String Sd_biztp) {
		setAttrVal("Sd_biztp", Sd_biztp);
	}
	public String getId_appraisaltp() {
		return ((String) getAttrVal("Id_appraisaltp"));
	}	
	public void setId_appraisaltp(String Id_appraisaltp) {
		setAttrVal("Id_appraisaltp", Id_appraisaltp);
	}
	public String getSd_appraisaltp() {
		return ((String) getAttrVal("Sd_appraisaltp"));
	}	
	public void setSd_appraisaltp(String Sd_appraisaltp) {
		setAttrVal("Sd_appraisaltp", Sd_appraisaltp);
	}
	public FDateTime getDt_appraisal() {
		return ((FDateTime) getAttrVal("Dt_appraisal"));
	}	
	public void setDt_appraisal(FDateTime Dt_appraisal) {
		setAttrVal("Dt_appraisal", Dt_appraisal);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getWindow_no() {
		return ((String) getAttrVal("Window_no"));
	}	
	public void setWindow_no(String Window_no) {
		setAttrVal("Window_no", Window_no);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_evalrlt";
	}
	
	@Override
	public String getTableName() {	  
		return "ei_varp_quote_evalrlt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EiVarpQuoteEvalRltDODesc.class);
	}
	
}