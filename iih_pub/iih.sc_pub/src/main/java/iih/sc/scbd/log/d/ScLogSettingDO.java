package iih.sc.scbd.log.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.log.d.desc.ScLogSettingDODesc;
import java.math.BigDecimal;

/**
 * 日志设置 DO数据 
 * 
 */
public class ScLogSettingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LOGSETTING= "Id_logsetting";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_TABLE= "Name_table";
	public static final String FIELD_PARENT_ID= "Field_parent_id";
	public static final String FIELDS= "Fields";
	public static final String TEMP_CONTENT= "Temp_content";
	public static final String OPERATE_TPS= "Operate_tps";
	public static final String NUM_DAYS_RESV= "Num_days_resv";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_logsetting() {
		return ((String) getAttrVal("Id_logsetting"));
	}	
	public void setId_logsetting(String Id_logsetting) {
		setAttrVal("Id_logsetting", Id_logsetting);
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
	public String getName_table() {
		return ((String) getAttrVal("Name_table"));
	}	
	public void setName_table(String Name_table) {
		setAttrVal("Name_table", Name_table);
	}
	public String getField_parent_id() {
		return ((String) getAttrVal("Field_parent_id"));
	}	
	public void setField_parent_id(String Field_parent_id) {
		setAttrVal("Field_parent_id", Field_parent_id);
	}
	public String getFields() {
		return ((String) getAttrVal("Fields"));
	}	
	public void setFields(String Fields) {
		setAttrVal("Fields", Fields);
	}
	public String getTemp_content() {
		return ((String) getAttrVal("Temp_content"));
	}	
	public void setTemp_content(String Temp_content) {
		setAttrVal("Temp_content", Temp_content);
	}
	public String getOperate_tps() {
		return ((String) getAttrVal("Operate_tps"));
	}	
	public void setOperate_tps(String Operate_tps) {
		setAttrVal("Operate_tps", Operate_tps);
	}
	public Integer getNum_days_resv() {
		return ((Integer) getAttrVal("Num_days_resv"));
	}	
	public void setNum_days_resv(Integer Num_days_resv) {
		setAttrVal("Num_days_resv", Num_days_resv);
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
		return "Id_logsetting";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_log_setting";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScLogSettingDODesc.class);
	}
	
}