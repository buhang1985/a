package iih.sc.att.sctaskexecperi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.att.sctaskexecperi.d.desc.ScTaskExecPeriDODesc;
import java.math.BigDecimal;

/**
 * 考勤执行期间 DO数据 
 * 
 */
public class ScTaskExecPeriDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCTASKPRI= "Id_sctaskpri";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String TASKYEAR= "Taskyear";
	public static final String TASKMONTH= "Taskmonth";
	public static final String D_B= "D_b";
	public static final String D_E= "D_e";
	public static final String ACCYEAR= "Accyear";
	public static final String ACCMONTH= "Accmonth";
	public static final String FG_SEAL= "Fg_seal";
	public static final String FG_CUR= "Fg_cur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sctaskpri() {
		return ((String) getAttrVal("Id_sctaskpri"));
	}	
	public void setId_sctaskpri(String Id_sctaskpri) {
		setAttrVal("Id_sctaskpri", Id_sctaskpri);
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
	public String getTaskyear() {
		return ((String) getAttrVal("Taskyear"));
	}	
	public void setTaskyear(String Taskyear) {
		setAttrVal("Taskyear", Taskyear);
	}
	public String getTaskmonth() {
		return ((String) getAttrVal("Taskmonth"));
	}	
	public void setTaskmonth(String Taskmonth) {
		setAttrVal("Taskmonth", Taskmonth);
	}
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}	
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}	
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
	}
	public String getAccyear() {
		return ((String) getAttrVal("Accyear"));
	}	
	public void setAccyear(String Accyear) {
		setAttrVal("Accyear", Accyear);
	}
	public String getAccmonth() {
		return ((String) getAttrVal("Accmonth"));
	}	
	public void setAccmonth(String Accmonth) {
		setAttrVal("Accmonth", Accmonth);
	}
	public FBoolean getFg_seal() {
		return ((FBoolean) getAttrVal("Fg_seal"));
	}	
	public void setFg_seal(FBoolean Fg_seal) {
		setAttrVal("Fg_seal", Fg_seal);
	}
	public FBoolean getFg_cur() {
		return ((FBoolean) getAttrVal("Fg_cur"));
	}	
	public void setFg_cur(FBoolean Fg_cur) {
		setAttrVal("Fg_cur", Fg_cur);
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
		return "Id_sctaskpri";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_task_exec_peri";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScTaskExecPeriDODesc.class);
	}
	
}