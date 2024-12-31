package iih.nm.nqm.nmnqmtaskdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmNqmTaskDepmtplDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_科室检查标准模板 DO数据 
 * 
 */
public class NmNqmTaskDepmtplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_TASK_DEPMTPL= "Id_nqm_task_depmtpl";
	public static final String ID_NQM_TASK_DEP= "Id_nqm_task_dep";
	public static final String ID_NQM_TMPL= "Id_nqm_tmpl";
	public static final String ID_NQM_CS= "Id_nqm_cs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_TMPL= "Name_tmpl";
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_task_depmtpl() {
		return ((String) getAttrVal("Id_nqm_task_depmtpl"));
	}	
	public void setId_nqm_task_depmtpl(String Id_nqm_task_depmtpl) {
		setAttrVal("Id_nqm_task_depmtpl", Id_nqm_task_depmtpl);
	}
	public String getId_nqm_task_dep() {
		return ((String) getAttrVal("Id_nqm_task_dep"));
	}	
	public void setId_nqm_task_dep(String Id_nqm_task_dep) {
		setAttrVal("Id_nqm_task_dep", Id_nqm_task_dep);
	}
	public String getId_nqm_tmpl() {
		return ((String) getAttrVal("Id_nqm_tmpl"));
	}	
	public void setId_nqm_tmpl(String Id_nqm_tmpl) {
		setAttrVal("Id_nqm_tmpl", Id_nqm_tmpl);
	}
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
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
	public String getName_tmpl() {
		return ((String) getAttrVal("Name_tmpl"));
	}	
	public void setName_tmpl(String Name_tmpl) {
		setAttrVal("Name_tmpl", Name_tmpl);
	}
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
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
		return "Id_nqm_task_depmtpl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_DEPMTPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskDepmtplDODesc.class);
	}
	
}