package iih.nm.net.examappqu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examappqu.d.desc.NmExamAppQuAnsDODesc;
import java.math.BigDecimal;

/**
 * 人员考试题目答案 DO数据 
 * 
 */
public class NmExamAppQuAnsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APPANS= "Id_appans";
	public static final String ID_APPQU= "Id_appqu";
	public static final String ID_QU= "Id_qu";
	public static final String ID_QU_ANS= "Id_qu_ans";
	public static final String CODE_ANS= "Code_ans";
	public static final String CONTENT_ANS= "Content_ans";
	public static final String SOLUTIONS= "Solutions";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_appans() {
		return ((String) getAttrVal("Id_appans"));
	}	
	public void setId_appans(String Id_appans) {
		setAttrVal("Id_appans", Id_appans);
	}
	public String getId_appqu() {
		return ((String) getAttrVal("Id_appqu"));
	}	
	public void setId_appqu(String Id_appqu) {
		setAttrVal("Id_appqu", Id_appqu);
	}
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	public String getId_qu_ans() {
		return ((String) getAttrVal("Id_qu_ans"));
	}	
	public void setId_qu_ans(String Id_qu_ans) {
		setAttrVal("Id_qu_ans", Id_qu_ans);
	}
	public String getCode_ans() {
		return ((String) getAttrVal("Code_ans"));
	}	
	public void setCode_ans(String Code_ans) {
		setAttrVal("Code_ans", Code_ans);
	}
	public String getContent_ans() {
		return ((String) getAttrVal("Content_ans"));
	}	
	public void setContent_ans(String Content_ans) {
		setAttrVal("Content_ans", Content_ans);
	}
	public String getSolutions() {
		return ((String) getAttrVal("Solutions"));
	}	
	public void setSolutions(String Solutions) {
		setAttrVal("Solutions", Solutions);
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
		return "Id_appans";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_APP_QU_ANS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmExamAppQuAnsDODesc.class);
	}
	
}