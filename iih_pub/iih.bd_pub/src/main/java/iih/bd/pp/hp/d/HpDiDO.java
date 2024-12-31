package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.HpDiDODesc;
import java.math.BigDecimal;

/**
 * 医保计划与疾病关系 DO数据 
 * 
 */
public class HpDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPDI= "Id_hpdi";
	public static final String ID_HP= "Id_hp";
	public static final String ID_DI= "Id_di";
	public static final String ID_ENTTP= "Id_enttp";
	public static final String AMT_PRICE= "Amt_price";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DI_CODE= "Di_code";
	public static final String DI_NAME= "Di_name";
	public static final String ENTTP_CODE= "Enttp_code";
	public static final String ENTTP_NAME= "Enttp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}	
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	public FDouble getAmt_price() {
		return ((FDouble) getAttrVal("Amt_price"));
	}	
	public void setAmt_price(FDouble Amt_price) {
		setAttrVal("Amt_price", Amt_price);
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
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}	
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	public String getEnttp_code() {
		return ((String) getAttrVal("Enttp_code"));
	}	
	public void setEnttp_code(String Enttp_code) {
		setAttrVal("Enttp_code", Enttp_code);
	}
	public String getEnttp_name() {
		return ((String) getAttrVal("Enttp_name"));
	}	
	public void setEnttp_name(String Enttp_name) {
		setAttrVal("Enttp_name", Enttp_name);
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
		return "Id_hpdi";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpDiDODesc.class);
	}
	
}