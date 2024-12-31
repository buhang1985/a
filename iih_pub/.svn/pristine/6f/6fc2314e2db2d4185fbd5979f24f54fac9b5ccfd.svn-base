package iih.bd.srv.mrcompleterule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrcompleterule.d.desc.MrCompleteRuleDODesc;
import java.math.BigDecimal;

/**
 * 病历完成规则 DO数据 
 * 
 */
public class MrCompleteRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_COMPLETE_RULE= "Id_mr_complete_rule";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String FG_CHANGE= "Fg_change";
	public static final String ID_CHANGE_MRTPS= "Id_change_mrtps";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String MRTP_CODE= "Mrtp_code";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String MRTP_CHANGE_CODE= "Mrtp_change_code";
	public static final String MRTP_CHANGE_NAME= "Mrtp_change_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_complete_rule() {
		return ((String) getAttrVal("Id_mr_complete_rule"));
	}	
	public void setId_mr_complete_rule(String Id_mr_complete_rule) {
		setAttrVal("Id_mr_complete_rule", Id_mr_complete_rule);
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
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public FBoolean getFg_change() {
		return ((FBoolean) getAttrVal("Fg_change"));
	}	
	public void setFg_change(FBoolean Fg_change) {
		setAttrVal("Fg_change", Fg_change);
	}
	public String getId_change_mrtps() {
		return ((String) getAttrVal("Id_change_mrtps"));
	}	
	public void setId_change_mrtps(String Id_change_mrtps) {
		setAttrVal("Id_change_mrtps", Id_change_mrtps);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	public String getMrtp_change_code() {
		return ((String) getAttrVal("Mrtp_change_code"));
	}	
	public void setMrtp_change_code(String Mrtp_change_code) {
		setAttrVal("Mrtp_change_code", Mrtp_change_code);
	}
	public String getMrtp_change_name() {
		return ((String) getAttrVal("Mrtp_change_name"));
	}	
	public void setMrtp_change_name(String Mrtp_change_name) {
		setAttrVal("Mrtp_change_name", Mrtp_change_name);
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
		return "Id_mr_complete_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_complete_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrCompleteRuleDODesc.class);
	}
	
}