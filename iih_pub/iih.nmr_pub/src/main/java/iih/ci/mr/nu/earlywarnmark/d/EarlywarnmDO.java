package iih.ci.mr.nu.earlywarnmark.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.earlywarnmark.d.desc.EarlywarnmDODesc;
import java.math.BigDecimal;

/**
 * 早期预警患者评分信息 DO数据 
 * 
 */
public class EarlywarnmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EARLYWARN= "Id_earlywarn";
	public static final String ID_EARLYWARINFO= "Id_earlywarinfo";
	public static final String HEARTSCORE= "Heartscore";
	public static final String SYSPRESCORE= "Sysprescore";
	public static final String BREATHSCORE= "Breathscore";
	public static final String TEMPSCORE= "Tempscore";
	public static final String CONSCSCORE= "Conscscore";
	public static final String VALUE_HEART= "Value_heart";
	public static final String VALUE_SYSPRE= "Value_syspre";
	public static final String VALUE_BREAT= "Value_breat";
	public static final String VALUE_TEMPERATURE= "Value_temperature";
	public static final String TOTALSCORE= "Totalscore";
	public static final String DT_EARLY= "Dt_early";
	public static final String ID_HEARTRATE= "Id_heartrate";
	public static final String SD_HEARTRATE= "Sd_heartrate";
	public static final String ID_SYSPRE= "Id_syspre";
	public static final String SD_SYSPRE= "Sd_syspre";
	public static final String ID_BREATHING= "Id_breathing";
	public static final String SD_BREATHING= "Sd_breathing";
	public static final String ID_TEMPERATURE= "Id_temperature";
	public static final String SD_TEMPERATURE= "Sd_temperature";
	public static final String ID_MENTALITY= "Id_mentality";
	public static final String SD_MENTALITY= "Sd_mentality";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HERAT= "Name_herat";
	public static final String NAME_SYSPRE= "Name_syspre";
	public static final String NAME_BREATH= "Name_breath";
	public static final String NAME_TEM= "Name_tem";
	public static final String NAME_MEN= "Name_men";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_earlywarn() {
		return ((String) getAttrVal("Id_earlywarn"));
	}	
	public void setId_earlywarn(String Id_earlywarn) {
		setAttrVal("Id_earlywarn", Id_earlywarn);
	}
	public String getId_earlywarinfo() {
		return ((String) getAttrVal("Id_earlywarinfo"));
	}	
	public void setId_earlywarinfo(String Id_earlywarinfo) {
		setAttrVal("Id_earlywarinfo", Id_earlywarinfo);
	}
	public FDouble getHeartscore() {
		return ((FDouble) getAttrVal("Heartscore"));
	}	
	public void setHeartscore(FDouble Heartscore) {
		setAttrVal("Heartscore", Heartscore);
	}
	public FDouble getSysprescore() {
		return ((FDouble) getAttrVal("Sysprescore"));
	}	
	public void setSysprescore(FDouble Sysprescore) {
		setAttrVal("Sysprescore", Sysprescore);
	}
	public FDouble getBreathscore() {
		return ((FDouble) getAttrVal("Breathscore"));
	}	
	public void setBreathscore(FDouble Breathscore) {
		setAttrVal("Breathscore", Breathscore);
	}
	public FDouble getTempscore() {
		return ((FDouble) getAttrVal("Tempscore"));
	}	
	public void setTempscore(FDouble Tempscore) {
		setAttrVal("Tempscore", Tempscore);
	}
	public FDouble getConscscore() {
		return ((FDouble) getAttrVal("Conscscore"));
	}	
	public void setConscscore(FDouble Conscscore) {
		setAttrVal("Conscscore", Conscscore);
	}
	public Integer getValue_heart() {
		return ((Integer) getAttrVal("Value_heart"));
	}	
	public void setValue_heart(Integer Value_heart) {
		setAttrVal("Value_heart", Value_heart);
	}
	public Integer getValue_syspre() {
		return ((Integer) getAttrVal("Value_syspre"));
	}	
	public void setValue_syspre(Integer Value_syspre) {
		setAttrVal("Value_syspre", Value_syspre);
	}
	public Integer getValue_breat() {
		return ((Integer) getAttrVal("Value_breat"));
	}	
	public void setValue_breat(Integer Value_breat) {
		setAttrVal("Value_breat", Value_breat);
	}
	public FDouble getValue_temperature() {
		return ((FDouble) getAttrVal("Value_temperature"));
	}	
	public void setValue_temperature(FDouble Value_temperature) {
		setAttrVal("Value_temperature", Value_temperature);
	}
	public FDouble getTotalscore() {
		return ((FDouble) getAttrVal("Totalscore"));
	}	
	public void setTotalscore(FDouble Totalscore) {
		setAttrVal("Totalscore", Totalscore);
	}
	public FDateTime getDt_early() {
		return ((FDateTime) getAttrVal("Dt_early"));
	}	
	public void setDt_early(FDateTime Dt_early) {
		setAttrVal("Dt_early", Dt_early);
	}
	public String getId_heartrate() {
		return ((String) getAttrVal("Id_heartrate"));
	}	
	public void setId_heartrate(String Id_heartrate) {
		setAttrVal("Id_heartrate", Id_heartrate);
	}
	public String getSd_heartrate() {
		return ((String) getAttrVal("Sd_heartrate"));
	}	
	public void setSd_heartrate(String Sd_heartrate) {
		setAttrVal("Sd_heartrate", Sd_heartrate);
	}
	public String getId_syspre() {
		return ((String) getAttrVal("Id_syspre"));
	}	
	public void setId_syspre(String Id_syspre) {
		setAttrVal("Id_syspre", Id_syspre);
	}
	public String getSd_syspre() {
		return ((String) getAttrVal("Sd_syspre"));
	}	
	public void setSd_syspre(String Sd_syspre) {
		setAttrVal("Sd_syspre", Sd_syspre);
	}
	public String getId_breathing() {
		return ((String) getAttrVal("Id_breathing"));
	}	
	public void setId_breathing(String Id_breathing) {
		setAttrVal("Id_breathing", Id_breathing);
	}
	public String getSd_breathing() {
		return ((String) getAttrVal("Sd_breathing"));
	}	
	public void setSd_breathing(String Sd_breathing) {
		setAttrVal("Sd_breathing", Sd_breathing);
	}
	public String getId_temperature() {
		return ((String) getAttrVal("Id_temperature"));
	}	
	public void setId_temperature(String Id_temperature) {
		setAttrVal("Id_temperature", Id_temperature);
	}
	public String getSd_temperature() {
		return ((String) getAttrVal("Sd_temperature"));
	}	
	public void setSd_temperature(String Sd_temperature) {
		setAttrVal("Sd_temperature", Sd_temperature);
	}
	public String getId_mentality() {
		return ((String) getAttrVal("Id_mentality"));
	}	
	public void setId_mentality(String Id_mentality) {
		setAttrVal("Id_mentality", Id_mentality);
	}
	public String getSd_mentality() {
		return ((String) getAttrVal("Sd_mentality"));
	}	
	public void setSd_mentality(String Sd_mentality) {
		setAttrVal("Sd_mentality", Sd_mentality);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getName_herat() {
		return ((String) getAttrVal("Name_herat"));
	}	
	public void setName_herat(String Name_herat) {
		setAttrVal("Name_herat", Name_herat);
	}
	public String getName_syspre() {
		return ((String) getAttrVal("Name_syspre"));
	}	
	public void setName_syspre(String Name_syspre) {
		setAttrVal("Name_syspre", Name_syspre);
	}
	public String getName_breath() {
		return ((String) getAttrVal("Name_breath"));
	}	
	public void setName_breath(String Name_breath) {
		setAttrVal("Name_breath", Name_breath);
	}
	public String getName_tem() {
		return ((String) getAttrVal("Name_tem"));
	}	
	public void setName_tem(String Name_tem) {
		setAttrVal("Name_tem", Name_tem);
	}
	public String getName_men() {
		return ((String) getAttrVal("Name_men"));
	}	
	public void setName_men(String Name_men) {
		setAttrVal("Name_men", Name_men);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_earlywarn";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_early_warn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EarlywarnmDODesc.class);
	}
	
}