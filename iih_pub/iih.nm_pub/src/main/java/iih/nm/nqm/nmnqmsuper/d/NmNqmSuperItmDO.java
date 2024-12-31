package iih.nm.nqm.nmnqmsuper.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmsuper.d.desc.NmNqmSuperItmDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_督导项_选项 DO数据 
 * 
 */
public class NmNqmSuperItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_SUPER_ITM= "Id_nqm_super_itm";
	public static final String ID_NQM_SUPER= "Id_nqm_super";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DES= "Des";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FLAG= "Flag";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_super_itm() {
		return ((String) getAttrVal("Id_nqm_super_itm"));
	}	
	public void setId_nqm_super_itm(String Id_nqm_super_itm) {
		setAttrVal("Id_nqm_super_itm", Id_nqm_super_itm);
	}
	public String getId_nqm_super() {
		return ((String) getAttrVal("Id_nqm_super"));
	}	
	public void setId_nqm_super(String Id_nqm_super) {
		setAttrVal("Id_nqm_super", Id_nqm_super);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public Integer getFlag() {
		return ((Integer) getAttrVal("Flag"));
	}	
	public void setFlag(Integer Flag) {
		setAttrVal("Flag", Flag);
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
		return "Id_nqm_super_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_SUPER_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmSuperItmDODesc.class);
	}
	
}