package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.EnPeCmpyItmDODesc;
import java.math.BigDecimal;

/**
 * 团检记录明细 DO数据 
 * 
 */
public class EnPeCmpyItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECMPYITM= "Id_pecmpyitm";
	public static final String ID_PECMPY= "Id_pecmpy";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_GRP= "Id_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pecmpyitm() {
		return ((String) getAttrVal("Id_pecmpyitm"));
	}	
	public void setId_pecmpyitm(String Id_pecmpyitm) {
		setAttrVal("Id_pecmpyitm", Id_pecmpyitm);
	}
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
		return "Id_pecmpyitm";
	}
	
	@Override
	public String getTableName() {	  
		return "en_pe_cmpy_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnPeCmpyItmDODesc.class);
	}
	
}