package iih.nm.net.examppscorelvl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examppscorelvl.d.desc.ExamppScoreLvlDODesc;
import java.math.BigDecimal;

/**
 * 试卷评分等级 DO数据 
 * 
 */
public class ExamppScoreLvlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PPSCORELVL= "Id_ppscorelvl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PP= "Id_pp";
	public static final String ID_LEVEL= "Id_level";
	public static final String SD_LEVEL= "Sd_level";
	public static final String MIN_SCORE= "Min_score";
	public static final String MAX_SCORE= "Max_score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PP= "Name_pp";
	public static final String NAME_PPSCORELVL= "Name_ppscorelvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ppscorelvl() {
		return ((String) getAttrVal("Id_ppscorelvl"));
	}	
	public void setId_ppscorelvl(String Id_ppscorelvl) {
		setAttrVal("Id_ppscorelvl", Id_ppscorelvl);
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
	public String getId_pp() {
		return ((String) getAttrVal("Id_pp"));
	}	
	public void setId_pp(String Id_pp) {
		setAttrVal("Id_pp", Id_pp);
	}
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	public FDouble getMin_score() {
		return ((FDouble) getAttrVal("Min_score"));
	}	
	public void setMin_score(FDouble Min_score) {
		setAttrVal("Min_score", Min_score);
	}
	public FDouble getMax_score() {
		return ((FDouble) getAttrVal("Max_score"));
	}	
	public void setMax_score(FDouble Max_score) {
		setAttrVal("Max_score", Max_score);
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
	public String getName_pp() {
		return ((String) getAttrVal("Name_pp"));
	}	
	public void setName_pp(String Name_pp) {
		setAttrVal("Name_pp", Name_pp);
	}
	public String getName_ppscorelvl() {
		return ((String) getAttrVal("Name_ppscorelvl"));
	}	
	public void setName_ppscorelvl(String Name_ppscorelvl) {
		setAttrVal("Name_ppscorelvl", Name_ppscorelvl);
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
		return "Id_ppscorelvl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_PP_SCORE_LVL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamppScoreLvlDODesc.class);
	}
	
}