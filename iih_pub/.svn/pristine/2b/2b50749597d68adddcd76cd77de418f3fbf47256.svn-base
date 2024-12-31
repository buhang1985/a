package iih.bd.mm.wahouseunittype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.wahouseunittype.d.desc.WahouseUnitTypeDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_仓库单位类型 DO数据 
 * 
 */
public class WahouseUnitTypeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WHPKGUTP= "Id_whpkgutp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WH= "Id_wh";
	public static final String ID_MMPKGUTP= "Id_mmpkgutp";
	public static final String FG_DEF= "Fg_def";
	public static final String ID_OPERATER= "Id_operater";
	public static final String DT_ST= "Dt_st";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WH_NAME= "Wh_name";
	public static final String MMPKTP_NAME= "Mmpktp_name";
	public static final String OPER_NAME= "Oper_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_whpkgutp() {
		return ((String) getAttrVal("Id_whpkgutp"));
	}	
	public void setId_whpkgutp(String Id_whpkgutp) {
		setAttrVal("Id_whpkgutp", Id_whpkgutp);
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
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_mmpkgutp() {
		return ((String) getAttrVal("Id_mmpkgutp"));
	}	
	public void setId_mmpkgutp(String Id_mmpkgutp) {
		setAttrVal("Id_mmpkgutp", Id_mmpkgutp);
	}
	public FBoolean getFg_def() {
		return ((FBoolean) getAttrVal("Fg_def"));
	}	
	public void setFg_def(FBoolean Fg_def) {
		setAttrVal("Fg_def", Fg_def);
	}
	public String getId_operater() {
		return ((String) getAttrVal("Id_operater"));
	}	
	public void setId_operater(String Id_operater) {
		setAttrVal("Id_operater", Id_operater);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
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
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getMmpktp_name() {
		return ((String) getAttrVal("Mmpktp_name"));
	}	
	public void setMmpktp_name(String Mmpktp_name) {
		setAttrVal("Mmpktp_name", Mmpktp_name);
	}
	public String getOper_name() {
		return ((String) getAttrVal("Oper_name"));
	}	
	public void setOper_name(String Oper_name) {
		setAttrVal("Oper_name", Oper_name);
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
		return "Id_whpkgutp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_WH_PKGUTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WahouseUnitTypeDODesc.class);
	}
	
}