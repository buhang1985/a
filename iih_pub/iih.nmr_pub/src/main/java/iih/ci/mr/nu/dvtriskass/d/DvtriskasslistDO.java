package iih.ci.mr.nu.dvtriskass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.dvtriskass.d.desc.DvtriskasslistDODesc;
import java.math.BigDecimal;

/**
 * DVT风险评估单列表 DO数据 
 * 
 */
public class DvtriskasslistDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DVTRISKASSLIST= "Id_dvtriskasslist";
	public static final String ID_DVT= "Id_dvt";
	public static final String ID_AGE_RANGE= "Id_age_range";
	public static final String SD_AGE_RANGE= "Sd_age_range";
	public static final String ID_BMI= "Id_bmi";
	public static final String SD_BMI= "Sd_bmi";
	public static final String ID_ACTIVE= "Id_active";
	public static final String SD_ACTIVE= "Sd_active";
	public static final String ID_TRAUMA_RISK= "Id_trauma_risk";
	public static final String SD_TRAUMA_RISK= "Sd_trauma_risk";
	public static final String ID_SPECIAL_RISK= "Id_special_risk";
	public static final String SD_SPECIAL_RISK= "Sd_special_risk";
	public static final String ID_DISEASE_RISK= "Id_disease_risk";
	public static final String SD_DISEASE_RISK= "Sd_disease_risk";
	public static final String ID_SURGERY= "Id_surgery";
	public static final String SD_SURGERY= "Sd_surgery";
	public static final String ID_NURSING_MEASURES= "Id_nursing_measures";
	public static final String SD_NURSING_MEASURES= "Sd_nursing_measures";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String NUM_WEIGHT= "Num_weight";
	public static final String NUM_HEIGHT= "Num_height";
	public static final String EXECUTION_DATE= "Execution_date";
	public static final String SC_AGE_RANGE= "Sc_age_range";
	public static final String SC_BMI= "Sc_bmi";
	public static final String SC_ACTIVE= "Sc_active";
	public static final String SC_TRAUMA_RISK= "Sc_trauma_risk";
	public static final String SC_SPECIAL_RISK= "Sc_special_risk";
	public static final String SC_DISEASE_RISK= "Sc_disease_risk";
	public static final String SC_SURGERY= "Sc_surgery";
	public static final String SC_NURSING_MEASURES= "Sc_nursing_measures";
	public static final String TOTAL_SCORE= "Total_score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_AGE_RANGE= "Name_age_range";
	public static final String NAME_BMI= "Name_bmi";
	public static final String NAME_ACTIVE= "Name_active";
	public static final String NAME_TRAUMA_RISK= "Name_trauma_risk";
	public static final String NAME_SPECIAL_RISK= "Name_special_risk";
	public static final String NAME_DISEASE_RISK= "Name_disease_risk";
	public static final String NAME_SURGERY= "Name_surgery";
	public static final String NAME_NURSING_MEASURES= "Name_nursing_measures";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dvtriskasslist() {
		return ((String) getAttrVal("Id_dvtriskasslist"));
	}	
	public void setId_dvtriskasslist(String Id_dvtriskasslist) {
		setAttrVal("Id_dvtriskasslist", Id_dvtriskasslist);
	}
	public String getId_dvt() {
		return ((String) getAttrVal("Id_dvt"));
	}	
	public void setId_dvt(String Id_dvt) {
		setAttrVal("Id_dvt", Id_dvt);
	}
	public String getId_age_range() {
		return ((String) getAttrVal("Id_age_range"));
	}	
	public void setId_age_range(String Id_age_range) {
		setAttrVal("Id_age_range", Id_age_range);
	}
	public String getSd_age_range() {
		return ((String) getAttrVal("Sd_age_range"));
	}	
	public void setSd_age_range(String Sd_age_range) {
		setAttrVal("Sd_age_range", Sd_age_range);
	}
	public String getId_bmi() {
		return ((String) getAttrVal("Id_bmi"));
	}	
	public void setId_bmi(String Id_bmi) {
		setAttrVal("Id_bmi", Id_bmi);
	}
	public String getSd_bmi() {
		return ((String) getAttrVal("Sd_bmi"));
	}	
	public void setSd_bmi(String Sd_bmi) {
		setAttrVal("Sd_bmi", Sd_bmi);
	}
	public String getId_active() {
		return ((String) getAttrVal("Id_active"));
	}	
	public void setId_active(String Id_active) {
		setAttrVal("Id_active", Id_active);
	}
	public String getSd_active() {
		return ((String) getAttrVal("Sd_active"));
	}	
	public void setSd_active(String Sd_active) {
		setAttrVal("Sd_active", Sd_active);
	}
	public String getId_trauma_risk() {
		return ((String) getAttrVal("Id_trauma_risk"));
	}	
	public void setId_trauma_risk(String Id_trauma_risk) {
		setAttrVal("Id_trauma_risk", Id_trauma_risk);
	}
	public String getSd_trauma_risk() {
		return ((String) getAttrVal("Sd_trauma_risk"));
	}	
	public void setSd_trauma_risk(String Sd_trauma_risk) {
		setAttrVal("Sd_trauma_risk", Sd_trauma_risk);
	}
	public String getId_special_risk() {
		return ((String) getAttrVal("Id_special_risk"));
	}	
	public void setId_special_risk(String Id_special_risk) {
		setAttrVal("Id_special_risk", Id_special_risk);
	}
	public String getSd_special_risk() {
		return ((String) getAttrVal("Sd_special_risk"));
	}	
	public void setSd_special_risk(String Sd_special_risk) {
		setAttrVal("Sd_special_risk", Sd_special_risk);
	}
	public String getId_disease_risk() {
		return ((String) getAttrVal("Id_disease_risk"));
	}	
	public void setId_disease_risk(String Id_disease_risk) {
		setAttrVal("Id_disease_risk", Id_disease_risk);
	}
	public String getSd_disease_risk() {
		return ((String) getAttrVal("Sd_disease_risk"));
	}	
	public void setSd_disease_risk(String Sd_disease_risk) {
		setAttrVal("Sd_disease_risk", Sd_disease_risk);
	}
	public String getId_surgery() {
		return ((String) getAttrVal("Id_surgery"));
	}	
	public void setId_surgery(String Id_surgery) {
		setAttrVal("Id_surgery", Id_surgery);
	}
	public String getSd_surgery() {
		return ((String) getAttrVal("Sd_surgery"));
	}	
	public void setSd_surgery(String Sd_surgery) {
		setAttrVal("Sd_surgery", Sd_surgery);
	}
	public String getId_nursing_measures() {
		return ((String) getAttrVal("Id_nursing_measures"));
	}	
	public void setId_nursing_measures(String Id_nursing_measures) {
		setAttrVal("Id_nursing_measures", Id_nursing_measures);
	}
	public String getSd_nursing_measures() {
		return ((String) getAttrVal("Sd_nursing_measures"));
	}	
	public void setSd_nursing_measures(String Sd_nursing_measures) {
		setAttrVal("Sd_nursing_measures", Sd_nursing_measures);
	}
	public String getId_signature() {
		return ((String) getAttrVal("Id_signature"));
	}	
	public void setId_signature(String Id_signature) {
		setAttrVal("Id_signature", Id_signature);
	}
	public FDouble getNum_weight() {
		return ((FDouble) getAttrVal("Num_weight"));
	}	
	public void setNum_weight(FDouble Num_weight) {
		setAttrVal("Num_weight", Num_weight);
	}
	public FDouble getNum_height() {
		return ((FDouble) getAttrVal("Num_height"));
	}	
	public void setNum_height(FDouble Num_height) {
		setAttrVal("Num_height", Num_height);
	}
	public FDateTime getExecution_date() {
		return ((FDateTime) getAttrVal("Execution_date"));
	}	
	public void setExecution_date(FDateTime Execution_date) {
		setAttrVal("Execution_date", Execution_date);
	}
	public FDouble getSc_age_range() {
		return ((FDouble) getAttrVal("Sc_age_range"));
	}	
	public void setSc_age_range(FDouble Sc_age_range) {
		setAttrVal("Sc_age_range", Sc_age_range);
	}
	public FDouble getSc_bmi() {
		return ((FDouble) getAttrVal("Sc_bmi"));
	}	
	public void setSc_bmi(FDouble Sc_bmi) {
		setAttrVal("Sc_bmi", Sc_bmi);
	}
	public FDouble getSc_active() {
		return ((FDouble) getAttrVal("Sc_active"));
	}	
	public void setSc_active(FDouble Sc_active) {
		setAttrVal("Sc_active", Sc_active);
	}
	public FDouble getSc_trauma_risk() {
		return ((FDouble) getAttrVal("Sc_trauma_risk"));
	}	
	public void setSc_trauma_risk(FDouble Sc_trauma_risk) {
		setAttrVal("Sc_trauma_risk", Sc_trauma_risk);
	}
	public FDouble getSc_special_risk() {
		return ((FDouble) getAttrVal("Sc_special_risk"));
	}	
	public void setSc_special_risk(FDouble Sc_special_risk) {
		setAttrVal("Sc_special_risk", Sc_special_risk);
	}
	public FDouble getSc_disease_risk() {
		return ((FDouble) getAttrVal("Sc_disease_risk"));
	}	
	public void setSc_disease_risk(FDouble Sc_disease_risk) {
		setAttrVal("Sc_disease_risk", Sc_disease_risk);
	}
	public FDouble getSc_surgery() {
		return ((FDouble) getAttrVal("Sc_surgery"));
	}	
	public void setSc_surgery(FDouble Sc_surgery) {
		setAttrVal("Sc_surgery", Sc_surgery);
	}
	public FDouble getSc_nursing_measures() {
		return ((FDouble) getAttrVal("Sc_nursing_measures"));
	}	
	public void setSc_nursing_measures(FDouble Sc_nursing_measures) {
		setAttrVal("Sc_nursing_measures", Sc_nursing_measures);
	}
	public FDouble getTotal_score() {
		return ((FDouble) getAttrVal("Total_score"));
	}	
	public void setTotal_score(FDouble Total_score) {
		setAttrVal("Total_score", Total_score);
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
	public String getName_age_range() {
		return ((String) getAttrVal("Name_age_range"));
	}	
	public void setName_age_range(String Name_age_range) {
		setAttrVal("Name_age_range", Name_age_range);
	}
	public String getName_bmi() {
		return ((String) getAttrVal("Name_bmi"));
	}	
	public void setName_bmi(String Name_bmi) {
		setAttrVal("Name_bmi", Name_bmi);
	}
	public String getName_active() {
		return ((String) getAttrVal("Name_active"));
	}	
	public void setName_active(String Name_active) {
		setAttrVal("Name_active", Name_active);
	}
	public String getName_trauma_risk() {
		return ((String) getAttrVal("Name_trauma_risk"));
	}	
	public void setName_trauma_risk(String Name_trauma_risk) {
		setAttrVal("Name_trauma_risk", Name_trauma_risk);
	}
	public String getName_special_risk() {
		return ((String) getAttrVal("Name_special_risk"));
	}	
	public void setName_special_risk(String Name_special_risk) {
		setAttrVal("Name_special_risk", Name_special_risk);
	}
	public String getName_disease_risk() {
		return ((String) getAttrVal("Name_disease_risk"));
	}	
	public void setName_disease_risk(String Name_disease_risk) {
		setAttrVal("Name_disease_risk", Name_disease_risk);
	}
	public String getName_surgery() {
		return ((String) getAttrVal("Name_surgery"));
	}	
	public void setName_surgery(String Name_surgery) {
		setAttrVal("Name_surgery", Name_surgery);
	}
	public String getName_nursing_measures() {
		return ((String) getAttrVal("Name_nursing_measures"));
	}	
	public void setName_nursing_measures(String Name_nursing_measures) {
		setAttrVal("Name_nursing_measures", Name_nursing_measures);
	}
	public String getName_signature() {
		return ((String) getAttrVal("Name_signature"));
	}	
	public void setName_signature(String Name_signature) {
		setAttrVal("Name_signature", Name_signature);
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
		return "Id_dvtriskasslist";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_dvtriskasslist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DvtriskasslistDODesc.class);
	}
	
}