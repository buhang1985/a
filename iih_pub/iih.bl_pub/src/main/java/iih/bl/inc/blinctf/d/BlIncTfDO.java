package iih.bl.inc.blinctf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blinctf.d.desc.BlIncTfDODesc;
import java.math.BigDecimal;

/**
 * 票据转移记录 DO数据 
 * 
 */
public class BlIncTfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INCTF= "Id_inctf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_INCCA= "Id_incca";
	public static final String ID_INC_ISS= "Id_inc_iss";
	public static final String CODE_INCPKG= "Code_incpkg";
	public static final String ID_EMP_ISS= "Id_emp_iss";
	public static final String ID_PC= "Id_pc";
	public static final String DT_ISS= "Dt_iss";
	public static final String NUM_B= "Num_b";
	public static final String NUM_E= "Num_e";
	public static final String INCNO_CUR= "Incno_cur";
	public static final String ID_INC_ISS_TF= "Id_inc_iss_tf";
	public static final String CODE_INCPKG_TF= "Code_incpkg_tf";
	public static final String ID_EMP_ISS_TF= "Id_emp_iss_tf";
	public static final String ID_PC_TF= "Id_pc_tf";
	public static final String DT_ISS_TF= "Dt_iss_tf";
	public static final String NUM_B_TF= "Num_b_tf";
	public static final String NUM_E_TF= "Num_e_tf";
	public static final String ID_EMP_OPER= "Id_emp_oper";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_inctf() {
		return ((String) getAttrVal("Id_inctf"));
	}	
	public void setId_inctf(String Id_inctf) {
		setAttrVal("Id_inctf", Id_inctf);
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
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	public String getId_inc_iss() {
		return ((String) getAttrVal("Id_inc_iss"));
	}	
	public void setId_inc_iss(String Id_inc_iss) {
		setAttrVal("Id_inc_iss", Id_inc_iss);
	}
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	public String getId_emp_iss() {
		return ((String) getAttrVal("Id_emp_iss"));
	}	
	public void setId_emp_iss(String Id_emp_iss) {
		setAttrVal("Id_emp_iss", Id_emp_iss);
	}
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	public FDateTime getDt_iss() {
		return ((FDateTime) getAttrVal("Dt_iss"));
	}	
	public void setDt_iss(FDateTime Dt_iss) {
		setAttrVal("Dt_iss", Dt_iss);
	}
	public String getNum_b() {
		return ((String) getAttrVal("Num_b"));
	}	
	public void setNum_b(String Num_b) {
		setAttrVal("Num_b", Num_b);
	}
	public String getNum_e() {
		return ((String) getAttrVal("Num_e"));
	}	
	public void setNum_e(String Num_e) {
		setAttrVal("Num_e", Num_e);
	}
	public String getIncno_cur() {
		return ((String) getAttrVal("Incno_cur"));
	}	
	public void setIncno_cur(String Incno_cur) {
		setAttrVal("Incno_cur", Incno_cur);
	}
	public String getId_inc_iss_tf() {
		return ((String) getAttrVal("Id_inc_iss_tf"));
	}	
	public void setId_inc_iss_tf(String Id_inc_iss_tf) {
		setAttrVal("Id_inc_iss_tf", Id_inc_iss_tf);
	}
	public String getCode_incpkg_tf() {
		return ((String) getAttrVal("Code_incpkg_tf"));
	}	
	public void setCode_incpkg_tf(String Code_incpkg_tf) {
		setAttrVal("Code_incpkg_tf", Code_incpkg_tf);
	}
	public String getId_emp_iss_tf() {
		return ((String) getAttrVal("Id_emp_iss_tf"));
	}	
	public void setId_emp_iss_tf(String Id_emp_iss_tf) {
		setAttrVal("Id_emp_iss_tf", Id_emp_iss_tf);
	}
	public String getId_pc_tf() {
		return ((String) getAttrVal("Id_pc_tf"));
	}	
	public void setId_pc_tf(String Id_pc_tf) {
		setAttrVal("Id_pc_tf", Id_pc_tf);
	}
	public FDateTime getDt_iss_tf() {
		return ((FDateTime) getAttrVal("Dt_iss_tf"));
	}	
	public void setDt_iss_tf(FDateTime Dt_iss_tf) {
		setAttrVal("Dt_iss_tf", Dt_iss_tf);
	}
	public String getNum_b_tf() {
		return ((String) getAttrVal("Num_b_tf"));
	}	
	public void setNum_b_tf(String Num_b_tf) {
		setAttrVal("Num_b_tf", Num_b_tf);
	}
	public String getNum_e_tf() {
		return ((String) getAttrVal("Num_e_tf"));
	}	
	public void setNum_e_tf(String Num_e_tf) {
		setAttrVal("Num_e_tf", Num_e_tf);
	}
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
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
		return "Id_inctf";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_tf";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncTfDODesc.class);
	}
	
}