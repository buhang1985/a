package iih.bl.pay.prewarnunit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.prewarnunit.d.desc.BlPrewarnUnitDODesc;
import java.math.BigDecimal;

/**
 * 预交金警告控制策略_合同单位 DO数据 
 * 
 */
public class BlPrewarnUnitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREWARNUNIT= "Id_prewarnunit";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PECMPY= "Id_pecmpy";
	public static final String UNIT_LIMIT= "Unit_limit";
	public static final String PAT_LIMIT= "Pat_limit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prewarnunit() {
		return ((String) getAttrVal("Id_prewarnunit"));
	}	
	public void setId_prewarnunit(String Id_prewarnunit) {
		setAttrVal("Id_prewarnunit", Id_prewarnunit);
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
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	public FDouble getUnit_limit() {
		return ((FDouble) getAttrVal("Unit_limit"));
	}	
	public void setUnit_limit(FDouble Unit_limit) {
		setAttrVal("Unit_limit", Unit_limit);
	}
	public FDouble getPat_limit() {
		return ((FDouble) getAttrVal("Pat_limit"));
	}	
	public void setPat_limit(FDouble Pat_limit) {
		setAttrVal("Pat_limit", Pat_limit);
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
		return "Id_prewarnunit";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prewarn_unit";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrewarnUnitDODesc.class);
	}
	
}