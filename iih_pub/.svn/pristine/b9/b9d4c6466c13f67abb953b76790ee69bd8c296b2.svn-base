package iih.nm.net.examappqu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examappqu.d.desc.NmExamAppQuDODesc;
import java.math.BigDecimal;

/**
 * 人员考试题目 DO数据 
 * 
 */
public class NmExamAppQuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APPQU= "Id_appqu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_EXAMAPP= "Id_examapp";
	public static final String ID_PPSEC= "Id_ppsec";
	public static final String ID_QU= "Id_qu";
	public static final String FG_DOUBT= "Fg_doubt";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_appqu() {
		return ((String) getAttrVal("Id_appqu"));
	}	
	public void setId_appqu(String Id_appqu) {
		setAttrVal("Id_appqu", Id_appqu);
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
	public String getId_examapp() {
		return ((String) getAttrVal("Id_examapp"));
	}	
	public void setId_examapp(String Id_examapp) {
		setAttrVal("Id_examapp", Id_examapp);
	}
	public String getId_ppsec() {
		return ((String) getAttrVal("Id_ppsec"));
	}	
	public void setId_ppsec(String Id_ppsec) {
		setAttrVal("Id_ppsec", Id_ppsec);
	}
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
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
		return "Id_appqu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_APP_QU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmExamAppQuDODesc.class);
	}
	
}