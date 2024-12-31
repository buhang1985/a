package iih.mp.dg.opinfu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opinfu.d.desc.OpInfuseDtDODesc;
import java.math.BigDecimal;

/**
 * 门诊输液执行明细 DO数据 
 * 
 */
public class OpInfuseDtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOEPINFUDT= "Id_dgoepinfudt";
	public static final String ID_DGOEPINFU= "Id_dgoepinfu";
	public static final String CODE_BAR= "Code_bar";
	public static final String EXEC_CUR= "Exec_cur";
	public static final String PERS_DAY= "Pers_day";
	public static final String DT_EXEC= "Dt_exec";
	public static final String DT_EXEC_TIME= "Dt_exec_time";
	public static final String ID_EMP_EXEC= "Id_emp_exec";
	public static final String EU_SU_EXEC= "Eu_su_exec";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgoepinfudt() {
		return ((String) getAttrVal("Id_dgoepinfudt"));
	}	
	public void setId_dgoepinfudt(String Id_dgoepinfudt) {
		setAttrVal("Id_dgoepinfudt", Id_dgoepinfudt);
	}
	public String getId_dgoepinfu() {
		return ((String) getAttrVal("Id_dgoepinfu"));
	}	
	public void setId_dgoepinfu(String Id_dgoepinfu) {
		setAttrVal("Id_dgoepinfu", Id_dgoepinfu);
	}
	public String getCode_bar() {
		return ((String) getAttrVal("Code_bar"));
	}	
	public void setCode_bar(String Code_bar) {
		setAttrVal("Code_bar", Code_bar);
	}
	public Integer getExec_cur() {
		return ((Integer) getAttrVal("Exec_cur"));
	}	
	public void setExec_cur(Integer Exec_cur) {
		setAttrVal("Exec_cur", Exec_cur);
	}
	public Integer getPers_day() {
		return ((Integer) getAttrVal("Pers_day"));
	}	
	public void setPers_day(Integer Pers_day) {
		setAttrVal("Pers_day", Pers_day);
	}
	public FDate getDt_exec() {
		return ((FDate) getAttrVal("Dt_exec"));
	}	
	public void setDt_exec(FDate Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
	public FTime getDt_exec_time() {
		return ((FTime) getAttrVal("Dt_exec_time"));
	}	
	public void setDt_exec_time(FTime Dt_exec_time) {
		setAttrVal("Dt_exec_time", Dt_exec_time);
	}
	public String getId_emp_exec() {
		return ((String) getAttrVal("Id_emp_exec"));
	}	
	public void setId_emp_exec(String Id_emp_exec) {
		setAttrVal("Id_emp_exec", Id_emp_exec);
	}
	public Integer getEu_su_exec() {
		return ((Integer) getAttrVal("Eu_su_exec"));
	}	
	public void setEu_su_exec(Integer Eu_su_exec) {
		setAttrVal("Eu_su_exec", Eu_su_exec);
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
		return "Id_dgoepinfudt";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_oep_infu_dt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpInfuseDtDODesc.class);
	}
	
}