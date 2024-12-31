package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekEmpDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_计划_周_人员 DO数据 
 * 
 */
public class ScPlanWeekEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLWEEKEMP= "Id_scplweekemp";
	public static final String ID_SCPLWEEK= "Id_scplweek";
	public static final String ID_EMP= "Id_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scplweekemp() {
		return ((String) getAttrVal("Id_scplweekemp"));
	}	
	public void setId_scplweekemp(String Id_scplweekemp) {
		setAttrVal("Id_scplweekemp", Id_scplweekemp);
	}
	public String getId_scplweek() {
		return ((String) getAttrVal("Id_scplweek"));
	}	
	public void setId_scplweek(String Id_scplweek) {
		setAttrVal("Id_scplweek", Id_scplweek);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
		return "Id_scplweekemp";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_week_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlanWeekEmpDODesc.class);
	}
	
}