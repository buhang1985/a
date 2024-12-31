package iih.nm.nca.nmncatmplca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nca.nmncatmplca.d.desc.NmNcaTmplcaDODesc;
import java.math.BigDecimal;

/**
 * 满意度问卷模板分类 DO数据 
 * 
 */
public class NmNcaTmplcaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NCA_TMPLCA= "Id_nca_tmplca";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String RES= "Res";
	public static final String CTR1= "Ctr1";
	public static final String CTR2= "Ctr2";
	public static final String CTR3= "Ctr3";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nca_tmplca() {
		return ((String) getAttrVal("Id_nca_tmplca"));
	}	
	public void setId_nca_tmplca(String Id_nca_tmplca) {
		setAttrVal("Id_nca_tmplca", Id_nca_tmplca);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getRes() {
		return ((String) getAttrVal("Res"));
	}	
	public void setRes(String Res) {
		setAttrVal("Res", Res);
	}
	public String getCtr1() {
		return ((String) getAttrVal("Ctr1"));
	}	
	public void setCtr1(String Ctr1) {
		setAttrVal("Ctr1", Ctr1);
	}
	public String getCtr2() {
		return ((String) getAttrVal("Ctr2"));
	}	
	public void setCtr2(String Ctr2) {
		setAttrVal("Ctr2", Ctr2);
	}
	public String getCtr3() {
		return ((String) getAttrVal("Ctr3"));
	}	
	public void setCtr3(String Ctr3) {
		setAttrVal("Ctr3", Ctr3);
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
		return "Id_nca_tmplca";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NCA_TMPLCA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNcaTmplcaDODesc.class);
	}
	
}