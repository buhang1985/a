package iih.bd.pp.singlediamt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.singlediamt.d.desc.SingleDiAmtDODesc;
import java.math.BigDecimal;

/**
 * 医保计划下单病种控费表 DO数据 
 * 
 */
public class SingleDiAmtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPSINGLEDIAMT= "Id_hpsinglediamt";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_HPDIORGINAL= "Id_hpdiorginal";
	public static final String ID_ENTTP= "Id_enttp";
	public static final String AMT= "Amt";
	public static final String ID_MEDKINDAH= "Id_medkindah";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String HPDIORGINAL_NAME= "Hpdiorginal_name";
	public static final String HPDIORGINAL_CODE= "Hpdiorginal_code";
	public static final String ENTP_CODE= "Entp_code";
	public static final String ENTP_NAME= "Entp_name";
	public static final String MEDKINDAH_CODE= "Medkindah_code";
	public static final String MEDKINDAH_NAME= "Medkindah_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpsinglediamt() {
		return ((String) getAttrVal("Id_hpsinglediamt"));
	}	
	public void setId_hpsinglediamt(String Id_hpsinglediamt) {
		setAttrVal("Id_hpsinglediamt", Id_hpsinglediamt);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	public String getId_hpdiorginal() {
		return ((String) getAttrVal("Id_hpdiorginal"));
	}	
	public void setId_hpdiorginal(String Id_hpdiorginal) {
		setAttrVal("Id_hpdiorginal", Id_hpdiorginal);
	}
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getId_medkindah() {
		return ((String) getAttrVal("Id_medkindah"));
	}	
	public void setId_medkindah(String Id_medkindah) {
		setAttrVal("Id_medkindah", Id_medkindah);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getHpdiorginal_name() {
		return ((String) getAttrVal("Hpdiorginal_name"));
	}	
	public void setHpdiorginal_name(String Hpdiorginal_name) {
		setAttrVal("Hpdiorginal_name", Hpdiorginal_name);
	}
	public String getHpdiorginal_code() {
		return ((String) getAttrVal("Hpdiorginal_code"));
	}	
	public void setHpdiorginal_code(String Hpdiorginal_code) {
		setAttrVal("Hpdiorginal_code", Hpdiorginal_code);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getMedkindah_code() {
		return ((String) getAttrVal("Medkindah_code"));
	}	
	public void setMedkindah_code(String Medkindah_code) {
		setAttrVal("Medkindah_code", Medkindah_code);
	}
	public String getMedkindah_name() {
		return ((String) getAttrVal("Medkindah_name"));
	}	
	public void setMedkindah_name(String Medkindah_name) {
		setAttrVal("Medkindah_name", Medkindah_name);
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
		return "Id_hpsinglediamt";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_SINGLE_DI_AMT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SingleDiAmtDODesc.class);
	}
	
}