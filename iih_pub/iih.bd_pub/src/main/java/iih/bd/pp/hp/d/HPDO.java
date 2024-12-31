package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.HPDODesc;
import java.math.BigDecimal;

/**
 * 医保产品 DO数据 
 * 
 */
public class HPDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HP= "Id_hp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CUST= "Id_cust";
	public static final String CODE= "Code";
	public static final String SD_HPTP= "Sd_hptp";
	public static final String ID_HPTP= "Id_hptp";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_PAR= "Id_par";
	public static final String EU_HPCALCPROP= "Eu_hpcalcprop";
	public static final String ID_FUNCPROP= "Id_funcprop";
	public static final String EU_HPCALCRATE= "Eu_hpcalcrate";
	public static final String ID_FUNCRATE= "Id_funcrate";
	public static final String EU_SCOPE= "Eu_scope";
	public static final String EU_SRVORCA_MD= "Eu_srvorca_md";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String EU_HPMMRELTP= "Eu_hpmmreltp";
	public static final String FG_CARDST= "Fg_cardst";
	public static final String FG_SABINC= "Fg_sabinc";
	public static final String FG_SABINC_ENT= "Fg_sabinc_ent";
	public static final String EU_SABINCPRN= "Eu_sabincprn";
	public static final String FG_BLACK_DI= "Fg_black_di";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_HPCG= "Fg_hpcg";
	public static final String FG_DEFAULT= "Fg_default";
	public static final String FG_REQHPCODE= "Fg_reqhpcode";
	public static final String FG_PREPAY= "Fg_prepay";
	public static final String HP_HOSPITAL_CODE= "Hp_hospital_code";
	public static final String ID_REFHP= "Id_refhp";
	public static final String CUST_CODE= "Cust_code";
	public static final String CUST_NAME= "Cust_name";
	public static final String NAME_HPTP= "Name_hptp";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String REFHP_NAME= "Refhp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}	
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
	}
	public String getId_hptp() {
		return ((String) getAttrVal("Id_hptp"));
	}	
	public void setId_hptp(String Id_hptp) {
		setAttrVal("Id_hptp", Id_hptp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public Integer getEu_hpcalcprop() {
		return ((Integer) getAttrVal("Eu_hpcalcprop"));
	}	
	public void setEu_hpcalcprop(Integer Eu_hpcalcprop) {
		setAttrVal("Eu_hpcalcprop", Eu_hpcalcprop);
	}
	public String getId_funcprop() {
		return ((String) getAttrVal("Id_funcprop"));
	}	
	public void setId_funcprop(String Id_funcprop) {
		setAttrVal("Id_funcprop", Id_funcprop);
	}
	public Integer getEu_hpcalcrate() {
		return ((Integer) getAttrVal("Eu_hpcalcrate"));
	}	
	public void setEu_hpcalcrate(Integer Eu_hpcalcrate) {
		setAttrVal("Eu_hpcalcrate", Eu_hpcalcrate);
	}
	public String getId_funcrate() {
		return ((String) getAttrVal("Id_funcrate"));
	}	
	public void setId_funcrate(String Id_funcrate) {
		setAttrVal("Id_funcrate", Id_funcrate);
	}
	public Integer getEu_scope() {
		return ((Integer) getAttrVal("Eu_scope"));
	}	
	public void setEu_scope(Integer Eu_scope) {
		setAttrVal("Eu_scope", Eu_scope);
	}
	public Integer getEu_srvorca_md() {
		return ((Integer) getAttrVal("Eu_srvorca_md"));
	}	
	public void setEu_srvorca_md(Integer Eu_srvorca_md) {
		setAttrVal("Eu_srvorca_md", Eu_srvorca_md);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public Integer getEu_hpmmreltp() {
		return ((Integer) getAttrVal("Eu_hpmmreltp"));
	}	
	public void setEu_hpmmreltp(Integer Eu_hpmmreltp) {
		setAttrVal("Eu_hpmmreltp", Eu_hpmmreltp);
	}
	public FBoolean getFg_cardst() {
		return ((FBoolean) getAttrVal("Fg_cardst"));
	}	
	public void setFg_cardst(FBoolean Fg_cardst) {
		setAttrVal("Fg_cardst", Fg_cardst);
	}
	public FBoolean getFg_sabinc() {
		return ((FBoolean) getAttrVal("Fg_sabinc"));
	}	
	public void setFg_sabinc(FBoolean Fg_sabinc) {
		setAttrVal("Fg_sabinc", Fg_sabinc);
	}
	public FBoolean getFg_sabinc_ent() {
		return ((FBoolean) getAttrVal("Fg_sabinc_ent"));
	}	
	public void setFg_sabinc_ent(FBoolean Fg_sabinc_ent) {
		setAttrVal("Fg_sabinc_ent", Fg_sabinc_ent);
	}
	public Integer getEu_sabincprn() {
		return ((Integer) getAttrVal("Eu_sabincprn"));
	}	
	public void setEu_sabincprn(Integer Eu_sabincprn) {
		setAttrVal("Eu_sabincprn", Eu_sabincprn);
	}
	public FBoolean getFg_black_di() {
		return ((FBoolean) getAttrVal("Fg_black_di"));
	}	
	public void setFg_black_di(FBoolean Fg_black_di) {
		setAttrVal("Fg_black_di", Fg_black_di);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}	
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	public FBoolean getFg_reqhpcode() {
		return ((FBoolean) getAttrVal("Fg_reqhpcode"));
	}	
	public void setFg_reqhpcode(FBoolean Fg_reqhpcode) {
		setAttrVal("Fg_reqhpcode", Fg_reqhpcode);
	}
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}	
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	public String getHp_hospital_code() {
		return ((String) getAttrVal("Hp_hospital_code"));
	}	
	public void setHp_hospital_code(String Hp_hospital_code) {
		setAttrVal("Hp_hospital_code", Hp_hospital_code);
	}
	public String getId_refhp() {
		return ((String) getAttrVal("Id_refhp"));
	}	
	public void setId_refhp(String Id_refhp) {
		setAttrVal("Id_refhp", Id_refhp);
	}
	public String getCust_code() {
		return ((String) getAttrVal("Cust_code"));
	}	
	public void setCust_code(String Cust_code) {
		setAttrVal("Cust_code", Cust_code);
	}
	public String getCust_name() {
		return ((String) getAttrVal("Cust_name"));
	}	
	public void setCust_name(String Cust_name) {
		setAttrVal("Cust_name", Cust_name);
	}
	public String getName_hptp() {
		return ((String) getAttrVal("Name_hptp"));
	}	
	public void setName_hptp(String Name_hptp) {
		setAttrVal("Name_hptp", Name_hptp);
	}
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	public String getRefhp_name() {
		return ((String) getAttrVal("Refhp_name"));
	}	
	public void setRefhp_name(String Refhp_name) {
		setAttrVal("Refhp_name", Refhp_name);
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
		return "Id_hp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HPDODesc.class);
	}
	
}