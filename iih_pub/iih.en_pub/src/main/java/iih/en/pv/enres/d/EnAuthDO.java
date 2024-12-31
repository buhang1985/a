package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnAuthDODesc;
import java.math.BigDecimal;

/**
 * 患者授权 DO数据 
 * 
 */
public class EnAuthDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTAUTH= "Id_entauth";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DEP_FROM= "Id_dep_from";
	public static final String ID_EMP_FROM= "Id_emp_from";
	public static final String ID_DEP_TO= "Id_dep_to";
	public static final String ID_EMP_TO= "Id_emp_to";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String REASON= "Reason";
	public static final String ID_EMP_END= "Id_emp_end";
	public static final String FG_OVERDUE= "Fg_overdue";
	public static final String CODE_DEP_FROM= "Code_dep_from";
	public static final String NAME_DEP_FROM= "Name_dep_from";
	public static final String CODE_EMP_FROM= "Code_emp_from";
	public static final String NAME_EMP_FROM= "Name_emp_from";
	public static final String CODE_DEP_TP= "Code_dep_tp";
	public static final String NAME_DEP_TO= "Name_dep_to";
	public static final String CODE_EMP_TO= "Code_emp_to";
	public static final String NAME_EMP_TO= "Name_emp_to";
	public static final String CODE_EMP_END= "Code_emp_end";
	public static final String NAME_EMP_END= "Name_emp_end";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entauth() {
		return ((String) getAttrVal("Id_entauth"));
	}	
	public void setId_entauth(String Id_entauth) {
		setAttrVal("Id_entauth", Id_entauth);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}	
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	public String getId_emp_from() {
		return ((String) getAttrVal("Id_emp_from"));
	}	
	public void setId_emp_from(String Id_emp_from) {
		setAttrVal("Id_emp_from", Id_emp_from);
	}
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}	
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	public String getId_emp_to() {
		return ((String) getAttrVal("Id_emp_to"));
	}	
	public void setId_emp_to(String Id_emp_to) {
		setAttrVal("Id_emp_to", Id_emp_to);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	public String getId_emp_end() {
		return ((String) getAttrVal("Id_emp_end"));
	}	
	public void setId_emp_end(String Id_emp_end) {
		setAttrVal("Id_emp_end", Id_emp_end);
	}
	public FBoolean getFg_overdue() {
		return ((FBoolean) getAttrVal("Fg_overdue"));
	}	
	public void setFg_overdue(FBoolean Fg_overdue) {
		setAttrVal("Fg_overdue", Fg_overdue);
	}
	public String getCode_dep_from() {
		return ((String) getAttrVal("Code_dep_from"));
	}	
	public void setCode_dep_from(String Code_dep_from) {
		setAttrVal("Code_dep_from", Code_dep_from);
	}
	public String getName_dep_from() {
		return ((String) getAttrVal("Name_dep_from"));
	}	
	public void setName_dep_from(String Name_dep_from) {
		setAttrVal("Name_dep_from", Name_dep_from);
	}
	public String getCode_emp_from() {
		return ((String) getAttrVal("Code_emp_from"));
	}	
	public void setCode_emp_from(String Code_emp_from) {
		setAttrVal("Code_emp_from", Code_emp_from);
	}
	public String getName_emp_from() {
		return ((String) getAttrVal("Name_emp_from"));
	}	
	public void setName_emp_from(String Name_emp_from) {
		setAttrVal("Name_emp_from", Name_emp_from);
	}
	public String getCode_dep_tp() {
		return ((String) getAttrVal("Code_dep_tp"));
	}	
	public void setCode_dep_tp(String Code_dep_tp) {
		setAttrVal("Code_dep_tp", Code_dep_tp);
	}
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}	
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	public String getCode_emp_to() {
		return ((String) getAttrVal("Code_emp_to"));
	}	
	public void setCode_emp_to(String Code_emp_to) {
		setAttrVal("Code_emp_to", Code_emp_to);
	}
	public String getName_emp_to() {
		return ((String) getAttrVal("Name_emp_to"));
	}	
	public void setName_emp_to(String Name_emp_to) {
		setAttrVal("Name_emp_to", Name_emp_to);
	}
	public String getCode_emp_end() {
		return ((String) getAttrVal("Code_emp_end"));
	}	
	public void setCode_emp_end(String Code_emp_end) {
		setAttrVal("Code_emp_end", Code_emp_end);
	}
	public String getName_emp_end() {
		return ((String) getAttrVal("Name_emp_end"));
	}	
	public void setName_emp_end(String Name_emp_end) {
		setAttrVal("Name_emp_end", Name_emp_end);
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
		return "Id_entauth";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_AUTH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnAuthDODesc.class);
	}
	
}