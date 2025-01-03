package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enfee.d.desc.EnFixedFeeDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_固定费用 DO数据 
 * 
 */
public class EnFixedFeeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTDCG= "Id_entdcg";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DCG_MODE= "Id_dcg_mode";
	public static final String SD_DCG_MODE= "Sd_dcg_mode";
	public static final String DT_DCG_BILL= "Dt_dcg_bill";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entdcg() {
		return ((String) getAttrVal("Id_entdcg"));
	}	
	public void setId_entdcg(String Id_entdcg) {
		setAttrVal("Id_entdcg", Id_entdcg);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_dcg_mode() {
		return ((String) getAttrVal("Id_dcg_mode"));
	}	
	public void setId_dcg_mode(String Id_dcg_mode) {
		setAttrVal("Id_dcg_mode", Id_dcg_mode);
	}
	public String getSd_dcg_mode() {
		return ((String) getAttrVal("Sd_dcg_mode"));
	}	
	public void setSd_dcg_mode(String Sd_dcg_mode) {
		setAttrVal("Sd_dcg_mode", Sd_dcg_mode);
	}
	public FDateTime getDt_dcg_bill() {
		return ((FDateTime) getAttrVal("Dt_dcg_bill"));
	}	
	public void setDt_dcg_bill(FDateTime Dt_dcg_bill) {
		setAttrVal("Dt_dcg_bill", Dt_dcg_bill);
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
		return "Id_entdcg";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_dcg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnFixedFeeDODesc.class);
	}
	
}