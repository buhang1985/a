package iih.pe.pwf.pedayinit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pedayinit.d.desc.PeDayInitDODesc;
import java.math.BigDecimal;

/**
 * 体检流程每日初始化 DO数据 
 * 
 */
public class PeDayInitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDAYINIT= "Id_pedayinit";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_INIT= "Dt_init";
	public static final String FG_INIT= "Fg_init";
	public static final String PE_PSN_NO= "Pe_psn_no";
	public static final String PE_CORP_NO= "Pe_corp_no";
	public static final String PE_CHARGE_NO= "Pe_charge_no";
	public static final String PE_ID_NO= "Pe_id_no";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedayinit() {
		return ((String) getAttrVal("Id_pedayinit"));
	}	
	public void setId_pedayinit(String Id_pedayinit) {
		setAttrVal("Id_pedayinit", Id_pedayinit);
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
	public FDate getDt_init() {
		return ((FDate) getAttrVal("Dt_init"));
	}	
	public void setDt_init(FDate Dt_init) {
		setAttrVal("Dt_init", Dt_init);
	}
	public FBoolean getFg_init() {
		return ((FBoolean) getAttrVal("Fg_init"));
	}	
	public void setFg_init(FBoolean Fg_init) {
		setAttrVal("Fg_init", Fg_init);
	}
	public Integer getPe_psn_no() {
		return ((Integer) getAttrVal("Pe_psn_no"));
	}	
	public void setPe_psn_no(Integer Pe_psn_no) {
		setAttrVal("Pe_psn_no", Pe_psn_no);
	}
	public Integer getPe_corp_no() {
		return ((Integer) getAttrVal("Pe_corp_no"));
	}	
	public void setPe_corp_no(Integer Pe_corp_no) {
		setAttrVal("Pe_corp_no", Pe_corp_no);
	}
	public Integer getPe_charge_no() {
		return ((Integer) getAttrVal("Pe_charge_no"));
	}	
	public void setPe_charge_no(Integer Pe_charge_no) {
		setAttrVal("Pe_charge_no", Pe_charge_no);
	}
	public Integer getPe_id_no() {
		return ((Integer) getAttrVal("Pe_id_no"));
	}	
	public void setPe_id_no(Integer Pe_id_no) {
		setAttrVal("Pe_id_no", Pe_id_no);
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
		return "Id_pedayinit";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pedayinit";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDayInitDODesc.class);
	}
	
}