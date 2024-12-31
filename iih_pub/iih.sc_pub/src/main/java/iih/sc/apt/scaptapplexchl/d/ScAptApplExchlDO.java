package iih.sc.apt.scaptapplexchl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scaptapplexchl.d.desc.ScAptApplExchlDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_申请_外部渠道 DO数据 
 * 
 */
public class ScAptApplExchlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTAPPLEXCHL= "Id_aptapplexchl";
	public static final String ID_APTAPPL= "Id_aptappl";
	public static final String NAME_ORG_APPL= "Name_org_appl";
	public static final String NAME_DEP_APPL= "Name_dep_appl";
	public static final String NAME_PHY_APPL= "Name_phy_appl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptapplexchl() {
		return ((String) getAttrVal("Id_aptapplexchl"));
	}	
	public void setId_aptapplexchl(String Id_aptapplexchl) {
		setAttrVal("Id_aptapplexchl", Id_aptapplexchl);
	}
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	public String getName_org_appl() {
		return ((String) getAttrVal("Name_org_appl"));
	}	
	public void setName_org_appl(String Name_org_appl) {
		setAttrVal("Name_org_appl", Name_org_appl);
	}
	public String getName_dep_appl() {
		return ((String) getAttrVal("Name_dep_appl"));
	}	
	public void setName_dep_appl(String Name_dep_appl) {
		setAttrVal("Name_dep_appl", Name_dep_appl);
	}
	public String getName_phy_appl() {
		return ((String) getAttrVal("Name_phy_appl"));
	}	
	public void setName_phy_appl(String Name_phy_appl) {
		setAttrVal("Name_phy_appl", Name_phy_appl);
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
		return "Id_aptapplexchl";
	}
	
	@Override
	public String getTableName() {	  
		return "SC_APT_APPL_EXCHL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptApplExchlDODesc.class);
	}
	
}