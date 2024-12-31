package iih.bd.pp.feeprojectrejectplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.feeprojectrejectplan.d.desc.ExclusiveMasterDODesc;
import java.math.BigDecimal;

/**
 * 收费项目排斥主表 DO数据 
 * 
 */
public class ExclusiveMasterDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String MASTER_ID= "Master_id";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String EXCLU_TYPE= "Exclu_type";
	public static final String TIME_LIMIT= "Time_limit";
	public static final String METHOD= "Method";
	public static final String ITM_RETRIEVE_RULE= "Itm_retrieve_rule";
	public static final String MESSGAE= "Messgae";
	public static final String MEMO= "Memo";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getMaster_id() {
		return ((String) getAttrVal("Master_id"));
	}	
	public void setMaster_id(String Master_id) {
		setAttrVal("Master_id", Master_id);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getExclu_type() {
		return ((String) getAttrVal("Exclu_type"));
	}	
	public void setExclu_type(String Exclu_type) {
		setAttrVal("Exclu_type", Exclu_type);
	}
	public String getTime_limit() {
		return ((String) getAttrVal("Time_limit"));
	}	
	public void setTime_limit(String Time_limit) {
		setAttrVal("Time_limit", Time_limit);
	}
	public String getMethod() {
		return ((String) getAttrVal("Method"));
	}	
	public void setMethod(String Method) {
		setAttrVal("Method", Method);
	}
	public String getItm_retrieve_rule() {
		return ((String) getAttrVal("Itm_retrieve_rule"));
	}	
	public void setItm_retrieve_rule(String Itm_retrieve_rule) {
		setAttrVal("Itm_retrieve_rule", Itm_retrieve_rule);
	}
	public String getMessgae() {
		return ((String) getAttrVal("Messgae"));
	}	
	public void setMessgae(String Messgae) {
		setAttrVal("Messgae", Messgae);
	}
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}	
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
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
		return "Master_id";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_exclusive_master";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExclusiveMasterDODesc.class);
	}
	
}