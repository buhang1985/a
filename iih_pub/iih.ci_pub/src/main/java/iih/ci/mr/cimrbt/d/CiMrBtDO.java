package iih.ci.mr.cimrbt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrbt.d.desc.CiMrBtDODesc;
import java.math.BigDecimal;

/**
 * 病历业务分类 DO数据 
 * 
 */
public class CiMrBtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_BT= "Id_mr_bt";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String NAME= "Name";
	public static final String ID_DI= "Id_di";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_MRCACTM= "Code_mrcactm";
	public static final String NAME_MRCACTM= "Name_mrcactm";
	public static final String CODE_DI= "Code_di";
	public static final String NAME_DI= "Name_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_bt() {
		return ((String) getAttrVal("Id_mr_bt"));
	}	
	public void setId_mr_bt(String Id_mr_bt) {
		setAttrVal("Id_mr_bt", Id_mr_bt);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
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
	public String getCode_mrcactm() {
		return ((String) getAttrVal("Code_mrcactm"));
	}	
	public void setCode_mrcactm(String Code_mrcactm) {
		setAttrVal("Code_mrcactm", Code_mrcactm);
	}
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}	
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_mr_bt";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_bt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrBtDODesc.class);
	}
	
}