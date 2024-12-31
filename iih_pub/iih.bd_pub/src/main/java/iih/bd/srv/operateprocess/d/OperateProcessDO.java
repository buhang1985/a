package iih.bd.srv.operateprocess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.operateprocess.d.desc.OperateProcessDODesc;
import java.math.BigDecimal;

/**
 * 操作流程 DO数据 
 * 
 */
public class OperateProcessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BD_MRM_OP= "Id_bd_mrm_op";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_BD_MRM_OT_CU= "Id_bd_mrm_ot_cu";
	public static final String FG_START= "Fg_start";
	public static final String FG_END= "Fg_end";
	public static final String ID_BD_MRM_OT_FW= "Id_bd_mrm_ot_fw";
	public static final String ID_BD_MRM_OT_BO= "Id_bd_mrm_ot_bo";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CU_OPERATTYPE_NAME= "Cu_operattype_name";
	public static final String CU_OPERATTYPE_CODE= "Cu_operattype_code";
	public static final String FW_OPERATTYPE_NAME= "Fw_operattype_name";
	public static final String FW_OPERATTYPE_CODE= "Fw_operattype_code";
	public static final String BO_OPERATTYPE_NAME= "Bo_operattype_name";
	public static final String BO_OPERATTYPE_CODE= "Bo_operattype_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bd_mrm_op() {
		return ((String) getAttrVal("Id_bd_mrm_op"));
	}	
	public void setId_bd_mrm_op(String Id_bd_mrm_op) {
		setAttrVal("Id_bd_mrm_op", Id_bd_mrm_op);
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
	public String getId_bd_mrm_ot_cu() {
		return ((String) getAttrVal("Id_bd_mrm_ot_cu"));
	}	
	public void setId_bd_mrm_ot_cu(String Id_bd_mrm_ot_cu) {
		setAttrVal("Id_bd_mrm_ot_cu", Id_bd_mrm_ot_cu);
	}
	public FBoolean getFg_start() {
		return ((FBoolean) getAttrVal("Fg_start"));
	}	
	public void setFg_start(FBoolean Fg_start) {
		setAttrVal("Fg_start", Fg_start);
	}
	public FBoolean getFg_end() {
		return ((FBoolean) getAttrVal("Fg_end"));
	}	
	public void setFg_end(FBoolean Fg_end) {
		setAttrVal("Fg_end", Fg_end);
	}
	public String getId_bd_mrm_ot_fw() {
		return ((String) getAttrVal("Id_bd_mrm_ot_fw"));
	}	
	public void setId_bd_mrm_ot_fw(String Id_bd_mrm_ot_fw) {
		setAttrVal("Id_bd_mrm_ot_fw", Id_bd_mrm_ot_fw);
	}
	public String getId_bd_mrm_ot_bo() {
		return ((String) getAttrVal("Id_bd_mrm_ot_bo"));
	}	
	public void setId_bd_mrm_ot_bo(String Id_bd_mrm_ot_bo) {
		setAttrVal("Id_bd_mrm_ot_bo", Id_bd_mrm_ot_bo);
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
	public String getCu_operattype_name() {
		return ((String) getAttrVal("Cu_operattype_name"));
	}	
	public void setCu_operattype_name(String Cu_operattype_name) {
		setAttrVal("Cu_operattype_name", Cu_operattype_name);
	}
	public String getCu_operattype_code() {
		return ((String) getAttrVal("Cu_operattype_code"));
	}	
	public void setCu_operattype_code(String Cu_operattype_code) {
		setAttrVal("Cu_operattype_code", Cu_operattype_code);
	}
	public String getFw_operattype_name() {
		return ((String) getAttrVal("Fw_operattype_name"));
	}	
	public void setFw_operattype_name(String Fw_operattype_name) {
		setAttrVal("Fw_operattype_name", Fw_operattype_name);
	}
	public String getFw_operattype_code() {
		return ((String) getAttrVal("Fw_operattype_code"));
	}	
	public void setFw_operattype_code(String Fw_operattype_code) {
		setAttrVal("Fw_operattype_code", Fw_operattype_code);
	}
	public String getBo_operattype_name() {
		return ((String) getAttrVal("Bo_operattype_name"));
	}	
	public void setBo_operattype_name(String Bo_operattype_name) {
		setAttrVal("Bo_operattype_name", Bo_operattype_name);
	}
	public String getBo_operattype_code() {
		return ((String) getAttrVal("Bo_operattype_code"));
	}	
	public void setBo_operattype_code(String Bo_operattype_code) {
		setAttrVal("Bo_operattype_code", Bo_operattype_code);
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
		return "Id_bd_mrm_op";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrm_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperateProcessDODesc.class);
	}
	
}