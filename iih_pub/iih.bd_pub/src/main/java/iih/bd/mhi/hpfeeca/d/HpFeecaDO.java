package iih.bd.mhi.hpfeeca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpfeeca.d.desc.HpFeecaDODesc;
import java.math.BigDecimal;

/**
 * 医保计划_费用分类字典 DO数据 
 * 
 */
public class HpFeecaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPFEECA= "Id_hpfeeca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PAR= "Id_par";
	public static final String ID_INCCA= "Id_incca";
	public static final String ID_INCCAITM= "Id_inccaitm";
	public static final String CODE_INCCAITM= "Code_inccaitm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_NAME= "Hp_name";
	public static final String PAR_NAME= "Par_name";
	public static final String NAME_INCCA= "Name_incca";
	public static final String NAME_INCCAITM= "Name_inccaitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpfeeca() {
		return ((String) getAttrVal("Id_hpfeeca"));
	}	
	public void setId_hpfeeca(String Id_hpfeeca) {
		setAttrVal("Id_hpfeeca", Id_hpfeeca);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	public String getId_inccaitm() {
		return ((String) getAttrVal("Id_inccaitm"));
	}	
	public void setId_inccaitm(String Id_inccaitm) {
		setAttrVal("Id_inccaitm", Id_inccaitm);
	}
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}	
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
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
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	public String getPar_name() {
		return ((String) getAttrVal("Par_name"));
	}	
	public void setPar_name(String Par_name) {
		setAttrVal("Par_name", Par_name);
	}
	public String getName_incca() {
		return ((String) getAttrVal("Name_incca"));
	}	
	public void setName_incca(String Name_incca) {
		setAttrVal("Name_incca", Name_incca);
	}
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}	
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
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
		return "Id_hpfeeca";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_FEECA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpFeecaDODesc.class);
	}
	
}