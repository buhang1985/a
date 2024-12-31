package iih.bd.mhi.hpunpasscompareinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpunpasscompareinfo.d.desc.HpUnPassCompareInfoDODesc;
import java.math.BigDecimal;

/**
 * 医保对照_未通过对照信息 DO数据 
 * 
 */
public class HpUnPassCompareInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_UNPASSCOMPARE= "Id_unpasscompare";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String FEEITEM_CODE= "Feeitem_code";
	public static final String FEEITEM_NAME= "Feeitem_name";
	public static final String FEEITEMCA= "Feeitemca";
	public static final String DATE_START= "Date_start";
	public static final String DATE_END= "Date_end";
	public static final String FEECA= "Feeca";
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	public static final String PRI_MAX= "Pri_max";
	public static final String DOSAGE= "Dosage";
	public static final String DOSE_UNIT= "Dose_unit";
	public static final String SPEC= "Spec";
	public static final String HOSP_DOSAGE= "Hosp_dosage";
	public static final String HOSP_PRICE= "Hosp_price";
	public static final String HOSP_PLACE= "Hosp_place";
	public static final String UPLOAD_TIME= "Upload_time";
	public static final String DRUG_TABOO= "Drug_taboo";
	public static final String ADVERSE_REACTION= "Adverse_reaction";
	public static final String PRECAUTION= "Precaution";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_unpasscompare() {
		return ((String) getAttrVal("Id_unpasscompare"));
	}	
	public void setId_unpasscompare(String Id_unpasscompare) {
		setAttrVal("Id_unpasscompare", Id_unpasscompare);
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
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
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
	public String getFeeitem_code() {
		return ((String) getAttrVal("Feeitem_code"));
	}	
	public void setFeeitem_code(String Feeitem_code) {
		setAttrVal("Feeitem_code", Feeitem_code);
	}
	public String getFeeitem_name() {
		return ((String) getAttrVal("Feeitem_name"));
	}	
	public void setFeeitem_name(String Feeitem_name) {
		setAttrVal("Feeitem_name", Feeitem_name);
	}
	public String getFeeitemca() {
		return ((String) getAttrVal("Feeitemca"));
	}	
	public void setFeeitemca(String Feeitemca) {
		setAttrVal("Feeitemca", Feeitemca);
	}
	public String getDate_start() {
		return ((String) getAttrVal("Date_start"));
	}	
	public void setDate_start(String Date_start) {
		setAttrVal("Date_start", Date_start);
	}
	public String getDate_end() {
		return ((String) getAttrVal("Date_end"));
	}	
	public void setDate_end(String Date_end) {
		setAttrVal("Date_end", Date_end);
	}
	public String getFeeca() {
		return ((String) getAttrVal("Feeca"));
	}	
	public void setFeeca(String Feeca) {
		setAttrVal("Feeca", Feeca);
	}
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	public String getPri_max() {
		return ((String) getAttrVal("Pri_max"));
	}	
	public void setPri_max(String Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}	
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	public String getDose_unit() {
		return ((String) getAttrVal("Dose_unit"));
	}	
	public void setDose_unit(String Dose_unit) {
		setAttrVal("Dose_unit", Dose_unit);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getHosp_dosage() {
		return ((String) getAttrVal("Hosp_dosage"));
	}	
	public void setHosp_dosage(String Hosp_dosage) {
		setAttrVal("Hosp_dosage", Hosp_dosage);
	}
	public String getHosp_price() {
		return ((String) getAttrVal("Hosp_price"));
	}	
	public void setHosp_price(String Hosp_price) {
		setAttrVal("Hosp_price", Hosp_price);
	}
	public String getHosp_place() {
		return ((String) getAttrVal("Hosp_place"));
	}	
	public void setHosp_place(String Hosp_place) {
		setAttrVal("Hosp_place", Hosp_place);
	}
	public String getUpload_time() {
		return ((String) getAttrVal("Upload_time"));
	}	
	public void setUpload_time(String Upload_time) {
		setAttrVal("Upload_time", Upload_time);
	}
	public String getDrug_taboo() {
		return ((String) getAttrVal("Drug_taboo"));
	}	
	public void setDrug_taboo(String Drug_taboo) {
		setAttrVal("Drug_taboo", Drug_taboo);
	}
	public String getAdverse_reaction() {
		return ((String) getAttrVal("Adverse_reaction"));
	}	
	public void setAdverse_reaction(String Adverse_reaction) {
		setAttrVal("Adverse_reaction", Adverse_reaction);
	}
	public String getPrecaution() {
		return ((String) getAttrVal("Precaution"));
	}	
	public void setPrecaution(String Precaution) {
		setAttrVal("Precaution", Precaution);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_unpasscompare";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_UNPASSCOMPARE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpUnPassCompareInfoDODesc.class);
	}
	
}