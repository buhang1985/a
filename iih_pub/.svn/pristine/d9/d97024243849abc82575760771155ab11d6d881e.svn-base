package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatPhyDODesc;
import java.math.BigDecimal;

/**
 * 患者生理信息 DO数据 
 * 
 */
public class PiPatPhyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATPHY= "Id_patphy";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_PATPHYIND= "Id_patphyind";
	public static final String ID_PATPHYINDOPT= "Id_patphyindopt";
	public static final String NAME_PHYIND= "Name_phyind";
	public static final String NAME_PHYINDOPT= "Name_phyindopt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patphy() {
		return ((String) getAttrVal("Id_patphy"));
	}	
	public void setId_patphy(String Id_patphy) {
		setAttrVal("Id_patphy", Id_patphy);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_patphyind() {
		return ((String) getAttrVal("Id_patphyind"));
	}	
	public void setId_patphyind(String Id_patphyind) {
		setAttrVal("Id_patphyind", Id_patphyind);
	}
	public String getId_patphyindopt() {
		return ((String) getAttrVal("Id_patphyindopt"));
	}	
	public void setId_patphyindopt(String Id_patphyindopt) {
		setAttrVal("Id_patphyindopt", Id_patphyindopt);
	}
	public String getName_phyind() {
		return ((String) getAttrVal("Name_phyind"));
	}	
	public void setName_phyind(String Name_phyind) {
		setAttrVal("Name_phyind", Name_phyind);
	}
	public String getName_phyindopt() {
		return ((String) getAttrVal("Name_phyindopt"));
	}	
	public void setName_phyindopt(String Name_phyindopt) {
		setAttrVal("Name_phyindopt", Name_phyindopt);
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
		return "Id_patphy";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_phy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatPhyDODesc.class);
	}
	
}