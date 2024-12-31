package iih.nm.net.examppqu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examppqu.d.desc.ExamppQuDODesc;
import java.math.BigDecimal;

/**
 * 试卷试题 DO数据 
 * 
 */
public class ExamppQuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PPQU= "Id_ppqu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PP= "Id_pp";
	public static final String ID_PPSEC= "Id_ppsec";
	public static final String ID_QU= "Id_qu";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PP= "Name_pp";
	public static final String NAME_PPSEC= "Name_ppsec";
	public static final String CONTENT= "Content";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ppqu() {
		return ((String) getAttrVal("Id_ppqu"));
	}	
	public void setId_ppqu(String Id_ppqu) {
		setAttrVal("Id_ppqu", Id_ppqu);
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
	public String getName_pp() {
		return ((String) getAttrVal("Name_pp"));
	}	
	public void setName_pp(String Name_pp) {
		setAttrVal("Name_pp", Name_pp);
	}
	public String getName_ppsec() {
		return ((String) getAttrVal("Name_ppsec"));
	}	
	public void setName_ppsec(String Name_ppsec) {
		setAttrVal("Name_ppsec", Name_ppsec);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
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
		return "Id_ppqu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_PP_QU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamppQuDODesc.class);
	}
	
}