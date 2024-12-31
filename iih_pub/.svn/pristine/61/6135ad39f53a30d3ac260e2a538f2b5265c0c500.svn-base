package iih.sc.scbd.scdeptparam.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDsDODesc;
import java.math.BigDecimal;

/**
 * 排班科室参数_时段设置 DO数据 
 * 
 */
public class ScDeptParamDsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEPTPARAMDS= "Id_deptparamds";
	public static final String ID_DEPTPARAM= "Id_deptparam";
	public static final String ID_DAYSLOT= "Id_dayslot";
	public static final String T_BEGIN= "T_begin";
	public static final String T_END= "T_end";
	public static final String T_CANC= "T_canc";
	public static final String QUAN_TOTAL= "Quan_total";
	public static final String QUAN_ADDLIMIT= "Quan_addlimit";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String T_END_REG= "T_end_reg";
	public static final String DAYSLOT_NAME= "Dayslot_name";
	public static final String CODE_DAYSLOT= "Code_dayslot";
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_deptparamds() {
		return ((String) getAttrVal("Id_deptparamds"));
	}	
	public void setId_deptparamds(String Id_deptparamds) {
		setAttrVal("Id_deptparamds", Id_deptparamds);
	}
	public String getId_deptparam() {
		return ((String) getAttrVal("Id_deptparam"));
	}	
	public void setId_deptparam(String Id_deptparam) {
		setAttrVal("Id_deptparam", Id_deptparam);
	}
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	public FTime getT_begin() {
		return ((FTime) getAttrVal("T_begin"));
	}	
	public void setT_begin(FTime T_begin) {
		setAttrVal("T_begin", T_begin);
	}
	public FTime getT_end() {
		return ((FTime) getAttrVal("T_end"));
	}	
	public void setT_end(FTime T_end) {
		setAttrVal("T_end", T_end);
	}
	public FTime getT_canc() {
		return ((FTime) getAttrVal("T_canc"));
	}	
	public void setT_canc(FTime T_canc) {
		setAttrVal("T_canc", T_canc);
	}
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}	
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	public Integer getQuan_addlimit() {
		return ((Integer) getAttrVal("Quan_addlimit"));
	}	
	public void setQuan_addlimit(Integer Quan_addlimit) {
		setAttrVal("Quan_addlimit", Quan_addlimit);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public FTime getT_end_reg() {
		return ((FTime) getAttrVal("T_end_reg"));
	}	
	public void setT_end_reg(FTime T_end_reg) {
		setAttrVal("T_end_reg", T_end_reg);
	}
	public String getDayslot_name() {
		return ((String) getAttrVal("Dayslot_name"));
	}	
	public void setDayslot_name(String Dayslot_name) {
		setAttrVal("Dayslot_name", Dayslot_name);
	}
	public String getCode_dayslot() {
		return ((String) getAttrVal("Code_dayslot"));
	}	
	public void setCode_dayslot(String Code_dayslot) {
		setAttrVal("Code_dayslot", Code_dayslot);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_deptparamds";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_dep_param_ds";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScDeptParamDsDODesc.class);
	}
	
}