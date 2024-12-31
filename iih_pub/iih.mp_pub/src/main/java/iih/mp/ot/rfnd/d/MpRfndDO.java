package iih.mp.ot.rfnd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.rfnd.d.desc.MpRfndDODesc;
import java.math.BigDecimal;

/**
 * 执行退费 DO数据 
 * 
 */
public class MpRfndDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RFND= "Id_rfnd";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_OR= "Id_or";
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	public static final String FEE_STATUS= "Fee_status";
	public static final String ID_EMP_RFND= "Id_emp_rfnd";
	public static final String ID_EMP_OPER= "Id_emp_oper";
	public static final String ID_DEP_OPER= "Id_dep_oper";
	public static final String DT_OPER= "Dt_oper";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EMP_RFND= "Name_emp_rfnd";
	public static final String NAME_EMP_OPER= "Name_emp_oper";
	public static final String NAME_DEP_OPER= "Name_dep_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rfnd() {
		return ((String) getAttrVal("Id_rfnd"));
	}	
	public void setId_rfnd(String Id_rfnd) {
		setAttrVal("Id_rfnd", Id_rfnd);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	public String getFee_status() {
		return ((String) getAttrVal("Fee_status"));
	}	
	public void setFee_status(String Fee_status) {
		setAttrVal("Fee_status", Fee_status);
	}
	public String getId_emp_rfnd() {
		return ((String) getAttrVal("Id_emp_rfnd"));
	}	
	public void setId_emp_rfnd(String Id_emp_rfnd) {
		setAttrVal("Id_emp_rfnd", Id_emp_rfnd);
	}
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}	
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getName_emp_rfnd() {
		return ((String) getAttrVal("Name_emp_rfnd"));
	}	
	public void setName_emp_rfnd(String Name_emp_rfnd) {
		setAttrVal("Name_emp_rfnd", Name_emp_rfnd);
	}
	public String getName_emp_oper() {
		return ((String) getAttrVal("Name_emp_oper"));
	}	
	public void setName_emp_oper(String Name_emp_oper) {
		setAttrVal("Name_emp_oper", Name_emp_oper);
	}
	public String getName_dep_oper() {
		return ((String) getAttrVal("Name_dep_oper"));
	}	
	public void setName_dep_oper(String Name_dep_oper) {
		setAttrVal("Name_dep_oper", Name_dep_oper);
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
		return "Id_rfnd";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_rfnd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpRfndDODesc.class);
	}
	
}