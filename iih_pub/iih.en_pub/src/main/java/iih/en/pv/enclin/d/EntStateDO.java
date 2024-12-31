package iih.en.pv.enclin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enclin.d.desc.EntStateDODesc;
import java.math.BigDecimal;

/**
 * 就诊状况 DO数据 
 * 
 */
public class EntStateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTSTATE= "Id_entstate";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_ENSTATETP= "Id_enstatetp";
	public static final String SD_ENSTATETP= "Sd_enstatetp";
	public static final String ID_ENTSTATEDEF= "Id_entstatedef";
	public static final String VAL= "Val";
	public static final String FG_SHOW= "Fg_show";
	public static final String DT_OCC= "Dt_occ";
	public static final String ID_KEY_SOURSE= "Id_key_sourse";
	public static final String ID_PAT= "Id_pat";
	public static final String DT_INVALID= "Dt_invalid";
	public static final String NAME_ENSTATETP= "Name_enstatetp";
	public static final String NAME_VAL= "Name_val";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entstate() {
		return ((String) getAttrVal("Id_entstate"));
	}	
	public void setId_entstate(String Id_entstate) {
		setAttrVal("Id_entstate", Id_entstate);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}	
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}	
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	public String getId_entstatedef() {
		return ((String) getAttrVal("Id_entstatedef"));
	}	
	public void setId_entstatedef(String Id_entstatedef) {
		setAttrVal("Id_entstatedef", Id_entstatedef);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public FBoolean getFg_show() {
		return ((FBoolean) getAttrVal("Fg_show"));
	}	
	public void setFg_show(FBoolean Fg_show) {
		setAttrVal("Fg_show", Fg_show);
	}
	public FDateTime getDt_occ() {
		return ((FDateTime) getAttrVal("Dt_occ"));
	}	
	public void setDt_occ(FDateTime Dt_occ) {
		setAttrVal("Dt_occ", Dt_occ);
	}
	public String getId_key_sourse() {
		return ((String) getAttrVal("Id_key_sourse"));
	}	
	public void setId_key_sourse(String Id_key_sourse) {
		setAttrVal("Id_key_sourse", Id_key_sourse);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	public String getName_enstatetp() {
		return ((String) getAttrVal("Name_enstatetp"));
	}	
	public void setName_enstatetp(String Name_enstatetp) {
		setAttrVal("Name_enstatetp", Name_enstatetp);
	}
	public String getName_val() {
		return ((String) getAttrVal("Name_val"));
	}	
	public void setName_val(String Name_val) {
		setAttrVal("Name_val", Name_val);
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
		return "Id_entstate";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_state";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntStateDODesc.class);
	}
	
}