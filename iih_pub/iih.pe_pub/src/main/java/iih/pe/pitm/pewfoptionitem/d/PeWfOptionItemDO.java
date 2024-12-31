package iih.pe.pitm.pewfoptionitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pewfoptionitem.d.desc.PeWfOptionItemDODesc;
import java.math.BigDecimal;

/**
 * 流程选项与体检结果关联关系 DO数据 
 * 
 */
public class PeWfOptionItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFOPTIONITEM= "Id_pewfoptionitem";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEWFOPTIONDEF= "Id_pewfoptiondef";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String TRIGGER_ACTION_TYPE= "Trigger_action_type";
	public static final String TRIGGER_ACTION_STATE= "Trigger_action_state";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PEWFOPTIONDEF= "Name_pewfoptiondef";
	public static final String CODE_PEWFOPTIONDEF= "Code_pewfoptiondef";
	public static final String CODE_ITM= "Code_itm";
	public static final String NAME_ITM= "Name_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfoptionitem() {
		return ((String) getAttrVal("Id_pewfoptionitem"));
	}	
	public void setId_pewfoptionitem(String Id_pewfoptionitem) {
		setAttrVal("Id_pewfoptionitem", Id_pewfoptionitem);
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
	public String getId_pewfoptiondef() {
		return ((String) getAttrVal("Id_pewfoptiondef"));
	}	
	public void setId_pewfoptiondef(String Id_pewfoptiondef) {
		setAttrVal("Id_pewfoptiondef", Id_pewfoptiondef);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	public Integer getTrigger_action_type() {
		return ((Integer) getAttrVal("Trigger_action_type"));
	}	
	public void setTrigger_action_type(Integer Trigger_action_type) {
		setAttrVal("Trigger_action_type", Trigger_action_type);
	}
	public Integer getTrigger_action_state() {
		return ((Integer) getAttrVal("Trigger_action_state"));
	}	
	public void setTrigger_action_state(Integer Trigger_action_state) {
		setAttrVal("Trigger_action_state", Trigger_action_state);
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
	public String getName_pewfoptiondef() {
		return ((String) getAttrVal("Name_pewfoptiondef"));
	}	
	public void setName_pewfoptiondef(String Name_pewfoptiondef) {
		setAttrVal("Name_pewfoptiondef", Name_pewfoptiondef);
	}
	public String getCode_pewfoptiondef() {
		return ((String) getAttrVal("Code_pewfoptiondef"));
	}	
	public void setCode_pewfoptiondef(String Code_pewfoptiondef) {
		setAttrVal("Code_pewfoptiondef", Code_pewfoptiondef);
	}
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}	
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}	
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
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
		return "Id_pewfoptionitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pewfoptionitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfOptionItemDODesc.class);
	}
	
}