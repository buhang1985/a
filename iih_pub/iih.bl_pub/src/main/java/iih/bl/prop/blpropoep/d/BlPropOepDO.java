package iih.bl.prop.blpropoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.prop.blpropoep.d.desc.BlPropOepDODesc;
import java.math.BigDecimal;

/**
 * 分摊_门诊 DO数据 
 * 
 */
public class BlPropOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PROPOEP= "Id_propoep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_PROP= "Dt_prop";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String ID_STOEP= "Id_stoep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_propoep() {
		return ((String) getAttrVal("Id_propoep"));
	}	
	public void setId_propoep(String Id_propoep) {
		setAttrVal("Id_propoep", Id_propoep);
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
	public FDateTime getDt_prop() {
		return ((FDateTime) getAttrVal("Dt_prop"));
	}	
	public void setDt_prop(FDateTime Dt_prop) {
		setAttrVal("Dt_prop", Dt_prop);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
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
		return "Id_propoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prop_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPropOepDODesc.class);
	}
	
}