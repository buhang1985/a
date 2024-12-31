package iih.bl.cg.blrecgoepdto.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blrecgoepdto.d.desc.BlRecgOepDTODesc;
import java.math.BigDecimal;

/**
 * 门诊重划价DTO DO数据 
 * 
 */
public class BlRecgOepDTO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String PAT_ID_PRIPAT= "Pat_id_pripat";
	public static final String ID_DEP_REG= "Id_dep_reg";
	public static final String PAT_DT_ACPT= "Pat_dt_acpt";
	public static final String PAT_PRIPAT_NAME= "Pat_pripat_name";
	public static final String PAT_ID_ENT= "Pat_id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	public String getPat_id_pripat() {
		return ((String) getAttrVal("Pat_id_pripat"));
	}	
	public void setPat_id_pripat(String Pat_id_pripat) {
		setAttrVal("Pat_id_pripat", Pat_id_pripat);
	}
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}	
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	public FDateTime getPat_dt_acpt() {
		return ((FDateTime) getAttrVal("Pat_dt_acpt"));
	}	
	public void setPat_dt_acpt(FDateTime Pat_dt_acpt) {
		setAttrVal("Pat_dt_acpt", Pat_dt_acpt);
	}
	public String getPat_pripat_name() {
		return ((String) getAttrVal("Pat_pripat_name"));
	}	
	public void setPat_pripat_name(String Pat_pripat_name) {
		setAttrVal("Pat_pripat_name", Pat_pripat_name);
	}
	public String getPat_id_ent() {
		return ((String) getAttrVal("Pat_id_ent"));
	}	
	public void setPat_id_ent(String Pat_id_ent) {
		setAttrVal("Pat_id_ent", Pat_id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Pat_code";
	}
	
	@Override
	public String getTableName() {	  
		return "dto";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRecgOepDTODesc.class);
	}
	
}