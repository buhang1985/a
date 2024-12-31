package iih.pe.pitm.pesrvrstnormtxt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvrstnormtxt.d.desc.PeSrvRstNormTxtDODesc;
import java.math.BigDecimal;

/**
 * 体检结果正常时报告内容 DO数据 
 * 
 */
public class PeSrvRstNormTxtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVRSTNORMTXT= "Id_pesrvrstnormtxt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String NORMAL_TXT= "Normal_txt";
	public static final String FG_PEITM= "Fg_peitm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DEPT= "Code_dept";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_CATLOG= "Code_catlog";
	public static final String NAME_CATLOG= "Name_catlog";
	public static final String CODE_ITM= "Code_itm";
	public static final String NAME_ITM= "Name_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvrstnormtxt() {
		return ((String) getAttrVal("Id_pesrvrstnormtxt"));
	}	
	public void setId_pesrvrstnormtxt(String Id_pesrvrstnormtxt) {
		setAttrVal("Id_pesrvrstnormtxt", Id_pesrvrstnormtxt);
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
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	public String getNormal_txt() {
		return ((String) getAttrVal("Normal_txt"));
	}	
	public void setNormal_txt(String Normal_txt) {
		setAttrVal("Normal_txt", Normal_txt);
	}
	public FBoolean getFg_peitm() {
		return ((FBoolean) getAttrVal("Fg_peitm"));
	}	
	public void setFg_peitm(FBoolean Fg_peitm) {
		setAttrVal("Fg_peitm", Fg_peitm);
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
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_catlog() {
		return ((String) getAttrVal("Code_catlog"));
	}	
	public void setCode_catlog(String Code_catlog) {
		setAttrVal("Code_catlog", Code_catlog);
	}
	public String getName_catlog() {
		return ((String) getAttrVal("Name_catlog"));
	}	
	public void setName_catlog(String Name_catlog) {
		setAttrVal("Name_catlog", Name_catlog);
	}
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}	
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}	
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
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
		return "Id_pesrvrstnormtxt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvrstnormtxt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvRstNormTxtDODesc.class);
	}
	
}