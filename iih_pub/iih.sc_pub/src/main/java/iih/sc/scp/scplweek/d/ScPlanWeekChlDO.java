package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekChlDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_计划_周_渠道 DO数据 
 * 
 */
public class ScPlanWeekChlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLWEEKCHL= "Id_scplweekchl";
	public static final String ID_SCPLWEEK= "Id_scplweek";
	public static final String ID_SCCHL= "Id_scchl";
	public static final String SCPOLCN= "Scpolcn";
	public static final String SCNUM= "Scnum";
	public static final String IDS_EMP_SPEC= "Ids_emp_spec";
	public static final String IDS_DEP_SPEC= "Ids_dep_spec";
	public static final String SCTIME= "Sctime";
	public static final String ID_ENTP= "Id_entp";
	public static final String NAME_SCCHL= "Name_scchl";
	public static final String CODE_SCCHL= "Code_scchl";
	public static final String NAMES_EMP_SPEC= "Names_emp_spec";
	public static final String NAMES_DEP_SPEC= "Names_dep_spec";
	public static final String CODE_ENTP= "Code_entp";
	public static final String NAME_ENTP= "Name_entp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scplweekchl() {
		return ((String) getAttrVal("Id_scplweekchl"));
	}	
	public void setId_scplweekchl(String Id_scplweekchl) {
		setAttrVal("Id_scplweekchl", Id_scplweekchl);
	}
	public String getId_scplweek() {
		return ((String) getAttrVal("Id_scplweek"));
	}	
	public void setId_scplweek(String Id_scplweek) {
		setAttrVal("Id_scplweek", Id_scplweek);
	}
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	public Integer getScnum() {
		return ((Integer) getAttrVal("Scnum"));
	}	
	public void setScnum(Integer Scnum) {
		setAttrVal("Scnum", Scnum);
	}
	public String getIds_emp_spec() {
		return ((String) getAttrVal("Ids_emp_spec"));
	}	
	public void setIds_emp_spec(String Ids_emp_spec) {
		setAttrVal("Ids_emp_spec", Ids_emp_spec);
	}
	public String getIds_dep_spec() {
		return ((String) getAttrVal("Ids_dep_spec"));
	}	
	public void setIds_dep_spec(String Ids_dep_spec) {
		setAttrVal("Ids_dep_spec", Ids_dep_spec);
	}
	public FTime getSctime() {
		return ((FTime) getAttrVal("Sctime"));
	}	
	public void setSctime(FTime Sctime) {
		setAttrVal("Sctime", Sctime);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}	
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}	
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	public String getNames_emp_spec() {
		return ((String) getAttrVal("Names_emp_spec"));
	}	
	public void setNames_emp_spec(String Names_emp_spec) {
		setAttrVal("Names_emp_spec", Names_emp_spec);
	}
	public String getNames_dep_spec() {
		return ((String) getAttrVal("Names_dep_spec"));
	}	
	public void setNames_dep_spec(String Names_dep_spec) {
		setAttrVal("Names_dep_spec", Names_dep_spec);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
		return "Id_scplweekchl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_week_chl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanWeekChlDODesc.class);
	}
	
}