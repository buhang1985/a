package iih.mp.nr.infusion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.infusion.d.desc.InfusionDODesc;
import java.math.BigDecimal;

/**
 * 输液签实体 DO数据 
 * 
 */
public class InfusionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INFUSION_LBL= "Id_infusion_lbl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String BAR_CD= "Bar_cd";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String SD_ENTP= "Sd_entp";
	public static final String PRN_TIMES= "Prn_times";
	public static final String FG_MULTI= "Fg_multi";
	public static final String FG_DG_STG= "Fg_dg_stg";
	public static final String ID_PRTP= "Id_prtp";
	public static final String SD_PRTP= "Sd_prtp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_infusion_lbl() {
		return ((String) getAttrVal("Id_infusion_lbl"));
	}	
	public void setId_infusion_lbl(String Id_infusion_lbl) {
		setAttrVal("Id_infusion_lbl", Id_infusion_lbl);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getBar_cd() {
		return ((String) getAttrVal("Bar_cd"));
	}	
	public void setBar_cd(String Bar_cd) {
		setAttrVal("Bar_cd", Bar_cd);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	public Integer getPrn_times() {
		return ((Integer) getAttrVal("Prn_times"));
	}	
	public void setPrn_times(Integer Prn_times) {
		setAttrVal("Prn_times", Prn_times);
	}
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}	
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
	}
	public FBoolean getFg_dg_stg() {
		return ((FBoolean) getAttrVal("Fg_dg_stg"));
	}	
	public void setFg_dg_stg(FBoolean Fg_dg_stg) {
		setAttrVal("Fg_dg_stg", Fg_dg_stg);
	}
	public String getId_prtp() {
		return ((String) getAttrVal("Id_prtp"));
	}	
	public void setId_prtp(String Id_prtp) {
		setAttrVal("Id_prtp", Id_prtp);
	}
	public String getSd_prtp() {
		return ((String) getAttrVal("Sd_prtp"));
	}	
	public void setSd_prtp(String Sd_prtp) {
		setAttrVal("Sd_prtp", Sd_prtp);
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
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
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
		return "Id_infusion_lbl";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_INFUSION_LBL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InfusionDODesc.class);
	}
	
}