package iih.ci.mr.nu.antencare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.antencare.d.desc.InspRecDODesc;
import java.math.BigDecimal;

/**
 * 检查记录 DO数据 
 * 
 */
public class InspRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_ANT= "Id_ant";
	public static final String DROPSY= "Dropsy";
	public static final String PRESENTAT= "Presentat";
	public static final String PROTEIN= "Protein";
	public static final String CHANGEMEA= "Changemea";
	public static final String GEST_WEEKS= "Gest_weeks";
	public static final String DBP_REC= "Dbp_rec";
	public static final String FETAL_LIE= "Fetal_lie";
	public static final String SBP_REC= "Sbp_rec";
	public static final String FETAL_HEART= "Fetal_heart";
	public static final String WEIGHT_REC= "Weight_rec";
	public static final String FUNDAL_HEIGHT= "Fundal_height";
	public static final String ABD_GIRTH= "Abd_girth";
	public static final String FERROHEME= "Ferroheme";
	public static final String DT_REC= "Dt_rec";
	public static final String DUE_DATE_REC= "Due_date_rec";
	public static final String ID_REC_SIGN= "Id_rec_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_REC_SIGN= "Name_rec_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public InspRecDO () {
		super();
	}
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
	}
	public String getId_ant() {
		return ((String) getAttrVal("Id_ant"));
	}	
	public void setId_ant(String Id_ant) {
		setAttrVal("Id_ant", Id_ant);
	}
	public String getDropsy() {
		return ((String) getAttrVal("Dropsy"));
	}	
	public void setDropsy(String Dropsy) {
		setAttrVal("Dropsy", Dropsy);
	}
	public String getPresentat() {
		return ((String) getAttrVal("Presentat"));
	}	
	public void setPresentat(String Presentat) {
		setAttrVal("Presentat", Presentat);
	}
	public String getProtein() {
		return ((String) getAttrVal("Protein"));
	}	
	public void setProtein(String Protein) {
		setAttrVal("Protein", Protein);
	}
	public String getChangemea() {
		return ((String) getAttrVal("Changemea"));
	}	
	public void setChangemea(String Changemea) {
		setAttrVal("Changemea", Changemea);
	}
	public Integer getGest_weeks() {
		return ((Integer) getAttrVal("Gest_weeks"));
	}	
	public void setGest_weeks(Integer Gest_weeks) {
		setAttrVal("Gest_weeks", Gest_weeks);
	}
	public Integer getDbp_rec() {
		return ((Integer) getAttrVal("Dbp_rec"));
	}	
	public void setDbp_rec(Integer Dbp_rec) {
		setAttrVal("Dbp_rec", Dbp_rec);
	}
	public Integer getFetal_lie() {
		return ((Integer) getAttrVal("Fetal_lie"));
	}	
	public void setFetal_lie(Integer Fetal_lie) {
		setAttrVal("Fetal_lie", Fetal_lie);
	}
	public Integer getSbp_rec() {
		return ((Integer) getAttrVal("Sbp_rec"));
	}	
	public void setSbp_rec(Integer Sbp_rec) {
		setAttrVal("Sbp_rec", Sbp_rec);
	}
	public Integer getFetal_heart() {
		return ((Integer) getAttrVal("Fetal_heart"));
	}	
	public void setFetal_heart(Integer Fetal_heart) {
		setAttrVal("Fetal_heart", Fetal_heart);
	}
	public FDouble getWeight_rec() {
		return ((FDouble) getAttrVal("Weight_rec"));
	}	
	public void setWeight_rec(FDouble Weight_rec) {
		setAttrVal("Weight_rec", Weight_rec);
	}
	public FDouble getFundal_height() {
		return ((FDouble) getAttrVal("Fundal_height"));
	}	
	public void setFundal_height(FDouble Fundal_height) {
		setAttrVal("Fundal_height", Fundal_height);
	}
	public FDouble getAbd_girth() {
		return ((FDouble) getAttrVal("Abd_girth"));
	}	
	public void setAbd_girth(FDouble Abd_girth) {
		setAttrVal("Abd_girth", Abd_girth);
	}
	public FDouble getFerroheme() {
		return ((FDouble) getAttrVal("Ferroheme"));
	}	
	public void setFerroheme(FDouble Ferroheme) {
		setAttrVal("Ferroheme", Ferroheme);
	}
	public FDate getDt_rec() {
		return ((FDate) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDate Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public FDate getDue_date_rec() {
		return ((FDate) getAttrVal("Due_date_rec"));
	}	
	public void setDue_date_rec(FDate Due_date_rec) {
		setAttrVal("Due_date_rec", Due_date_rec);
	}
	public String getId_rec_sign() {
		return ((String) getAttrVal("Id_rec_sign"));
	}	
	public void setId_rec_sign(String Id_rec_sign) {
		setAttrVal("Id_rec_sign", Id_rec_sign);
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
	public String getName_rec_sign() {
		return ((String) getAttrVal("Name_rec_sign"));
	}	
	public void setName_rec_sign(String Name_rec_sign) {
		setAttrVal("Name_rec_sign", Name_rec_sign);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_INSPREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InspRecDODesc.class);
	}
	
}