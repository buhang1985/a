package iih.nm.nqm.nqmtaskdetdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmtaskdetdep.d.desc.NqmTaskDetDepTmplDODesc;
import java.math.BigDecimal;

/**
 * 受检科室受检标准 DO数据 
 * 
 */
public class NqmTaskDetDepTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_TASK_DET_DEPCS= "Id_nqm_task_det_depcs";
	public static final String ID_NQM_TASK_DET_DEP= "Id_nqm_task_det_dep";
	public static final String ID_NQM_CS= "Id_nqm_cs";
	public static final String ID_NQM_TMPL= "Id_nqm_tmpl";
	public static final String COUNT_CHK= "Count_chk";
	public static final String DES= "Des";
	public static final String FG_DONE= "Fg_done";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	public static final String NAME_NQM_TMPL= "Name_nqm_tmpl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_task_det_depcs() {
		return ((String) getAttrVal("Id_nqm_task_det_depcs"));
	}	
	public void setId_nqm_task_det_depcs(String Id_nqm_task_det_depcs) {
		setAttrVal("Id_nqm_task_det_depcs", Id_nqm_task_det_depcs);
	}
	public String getId_nqm_task_det_dep() {
		return ((String) getAttrVal("Id_nqm_task_det_dep"));
	}	
	public void setId_nqm_task_det_dep(String Id_nqm_task_det_dep) {
		setAttrVal("Id_nqm_task_det_dep", Id_nqm_task_det_dep);
	}
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	public String getId_nqm_tmpl() {
		return ((String) getAttrVal("Id_nqm_tmpl"));
	}	
	public void setId_nqm_tmpl(String Id_nqm_tmpl) {
		setAttrVal("Id_nqm_tmpl", Id_nqm_tmpl);
	}
	public Integer getCount_chk() {
		return ((Integer) getAttrVal("Count_chk"));
	}	
	public void setCount_chk(Integer Count_chk) {
		setAttrVal("Count_chk", Count_chk);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_done() {
		return ((FBoolean) getAttrVal("Fg_done"));
	}	
	public void setFg_done(FBoolean Fg_done) {
		setAttrVal("Fg_done", Fg_done);
	}
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	public String getName_nqm_tmpl() {
		return ((String) getAttrVal("Name_nqm_tmpl"));
	}	
	public void setName_nqm_tmpl(String Name_nqm_tmpl) {
		setAttrVal("Name_nqm_tmpl", Name_nqm_tmpl);
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
		return "Id_nqm_task_det_depcs";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_DET_DEPTMPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmTaskDetDepTmplDODesc.class);
	}
	
}