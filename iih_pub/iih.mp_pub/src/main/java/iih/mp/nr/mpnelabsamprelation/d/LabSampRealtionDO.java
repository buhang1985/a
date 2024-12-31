package iih.mp.nr.mpnelabsamprelation.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpnelabsamprelation.d.desc.LabSampRealtionDODesc;
import java.math.BigDecimal;

/**
 * 标本项目关系 DO数据 
 * 
 */
public class LabSampRealtionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LABSAMPITMREF= "Id_labsampitmref";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_LABSAMP= "Id_labsamp";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_labsampitmref() {
		return ((String) getAttrVal("Id_labsampitmref"));
	}	
	public void setId_labsampitmref(String Id_labsampitmref) {
		setAttrVal("Id_labsampitmref", Id_labsampitmref);
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
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}	
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
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
		return "Id_labsampitmref";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_LAB_SAMP_ITM_REF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(LabSampRealtionDODesc.class);
	}
	
}