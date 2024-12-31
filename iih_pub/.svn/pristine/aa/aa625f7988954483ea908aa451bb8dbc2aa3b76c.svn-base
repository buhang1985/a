package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.BdHpPrestpDODesc;
import java.math.BigDecimal;

/**
 * 医保计划处方类型 DO数据 
 * 
 */
public class BdHpPrestpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPPRESTP= "Id_hpprestp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_HP= "Id_hp";
	public static final String ID_PRESTP= "Id_prestp";
	public static final String SD_PRESTP= "Sd_prestp";
	public static final String CODE_HP= "Code_hp";
	public static final String NAME_HP= "Name_hp";
	public static final String PRESTP_NAME= "Prestp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpprestp() {
		return ((String) getAttrVal("Id_hpprestp"));
	}	
	public void setId_hpprestp(String Id_hpprestp) {
		setAttrVal("Id_hpprestp", Id_hpprestp);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	public String getPrestp_name() {
		return ((String) getAttrVal("Prestp_name"));
	}	
	public void setPrestp_name(String Prestp_name) {
		setAttrVal("Prestp_name", Prestp_name);
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
		return "Id_hpprestp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_prestp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdHpPrestpDODesc.class);
	}
	
}