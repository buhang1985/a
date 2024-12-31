package iih.bl.inc.blcpnin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blcpnin.d.desc.BlCpnInDODesc;
import java.math.BigDecimal;

/**
 * 优惠券_入库单 DO数据 
 * 
 */
public class BlCpnInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CPNIN= "Id_cpnin";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CPNCA= "Id_cpnca";
	public static final String CODE= "Code";
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NUM_B= "Num_b";
	public static final String NUM_E= "Num_e";
	public static final String CODE_CPN_B= "Code_cpn_b";
	public static final String CODE_CPN_E= "Code_cpn_e";
	public static final String CODERULE_CPN= "Coderule_cpn";
	public static final String CODE_CPN_ALL= "Code_cpn_all";
	public static final String CODE_CPNCA= "Code_cpnca";
	public static final String NAME_CPNCA= "Name_cpnca";
	public static final String EU_CPNTP= "Eu_cpntp";
	public static final String CODE_EMP_ENTRY= "Code_emp_entry";
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cpnin() {
		return ((String) getAttrVal("Id_cpnin"));
	}	
	public void setId_cpnin(String Id_cpnin) {
		setAttrVal("Id_cpnin", Id_cpnin);
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
	public String getId_cpnca() {
		return ((String) getAttrVal("Id_cpnca"));
	}	
	public void setId_cpnca(String Id_cpnca) {
		setAttrVal("Id_cpnca", Id_cpnca);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public Integer getNum_b() {
		return ((Integer) getAttrVal("Num_b"));
	}	
	public void setNum_b(Integer Num_b) {
		setAttrVal("Num_b", Num_b);
	}
	public Integer getNum_e() {
		return ((Integer) getAttrVal("Num_e"));
	}	
	public void setNum_e(Integer Num_e) {
		setAttrVal("Num_e", Num_e);
	}
	public String getCode_cpn_b() {
		return ((String) getAttrVal("Code_cpn_b"));
	}	
	public void setCode_cpn_b(String Code_cpn_b) {
		setAttrVal("Code_cpn_b", Code_cpn_b);
	}
	public String getCode_cpn_e() {
		return ((String) getAttrVal("Code_cpn_e"));
	}	
	public void setCode_cpn_e(String Code_cpn_e) {
		setAttrVal("Code_cpn_e", Code_cpn_e);
	}
	public String getCoderule_cpn() {
		return ((String) getAttrVal("Coderule_cpn"));
	}	
	public void setCoderule_cpn(String Coderule_cpn) {
		setAttrVal("Coderule_cpn", Coderule_cpn);
	}
	public String getCode_cpn_all() {
		return ((String) getAttrVal("Code_cpn_all"));
	}	
	public void setCode_cpn_all(String Code_cpn_all) {
		setAttrVal("Code_cpn_all", Code_cpn_all);
	}
	public String getCode_cpnca() {
		return ((String) getAttrVal("Code_cpnca"));
	}	
	public void setCode_cpnca(String Code_cpnca) {
		setAttrVal("Code_cpnca", Code_cpnca);
	}
	public String getName_cpnca() {
		return ((String) getAttrVal("Name_cpnca"));
	}	
	public void setName_cpnca(String Name_cpnca) {
		setAttrVal("Name_cpnca", Name_cpnca);
	}
	public Integer getEu_cpntp() {
		return ((Integer) getAttrVal("Eu_cpntp"));
	}	
	public void setEu_cpntp(Integer Eu_cpntp) {
		setAttrVal("Eu_cpntp", Eu_cpntp);
	}
	public String getCode_emp_entry() {
		return ((String) getAttrVal("Code_emp_entry"));
	}	
	public void setCode_emp_entry(String Code_emp_entry) {
		setAttrVal("Code_emp_entry", Code_emp_entry);
	}
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
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
		return "Id_cpnin";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cpn_in";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCpnInDODesc.class);
	}
	
}