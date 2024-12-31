package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpcpEleInvalidInfoDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素值异常信息 DO数据 
 * 
 */
public class HpcpEleInvalidInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_VALID= "Id_ele_valid";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CP= "Id_cp";
	public static final String ID_ELE= "Id_ele";
	public static final String ID_ELETPPPE= "Id_eletpppe";
	public static final String SD_VAL_INVALID_TP= "Sd_val_invalid_tp";
	public static final String ID_VAL_INVALID_TP= "Id_val_invalid_tp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_VAL_INVALID_TP_NAME= "Id_val_invalid_tp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_valid() {
		return ((String) getAttrVal("Id_ele_valid"));
	}	
	public void setId_ele_valid(String Id_ele_valid) {
		setAttrVal("Id_ele_valid", Id_ele_valid);
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
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	public String getId_eletpppe() {
		return ((String) getAttrVal("Id_eletpppe"));
	}	
	public void setId_eletpppe(String Id_eletpppe) {
		setAttrVal("Id_eletpppe", Id_eletpppe);
	}
	public String getSd_val_invalid_tp() {
		return ((String) getAttrVal("Sd_val_invalid_tp"));
	}	
	public void setSd_val_invalid_tp(String Sd_val_invalid_tp) {
		setAttrVal("Sd_val_invalid_tp", Sd_val_invalid_tp);
	}
	public String getId_val_invalid_tp() {
		return ((String) getAttrVal("Id_val_invalid_tp"));
	}	
	public void setId_val_invalid_tp(String Id_val_invalid_tp) {
		setAttrVal("Id_val_invalid_tp", Id_val_invalid_tp);
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
	public String getId_val_invalid_tp_name() {
		return ((String) getAttrVal("Id_val_invalid_tp_name"));
	}	
	public void setId_val_invalid_tp_name(String Id_val_invalid_tp_name) {
		setAttrVal("Id_val_invalid_tp_name", Id_val_invalid_tp_name);
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
		return "Id_ele_valid";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_INVALID_INFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpcpEleInvalidInfoDODesc.class);
	}
	
}