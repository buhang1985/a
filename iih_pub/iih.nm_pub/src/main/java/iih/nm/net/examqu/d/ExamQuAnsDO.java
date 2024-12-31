package iih.nm.net.examqu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examqu.d.desc.ExamQuAnsDODesc;
import java.math.BigDecimal;

/**
 * 答案 DO数据 
 * 
 */
public class ExamQuAnsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QU_ANS= "Id_qu_ans";
	public static final String ID_QU= "Id_qu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String SERIAL_NO= "Serial_no";
	public static final String CODE= "Code";
	public static final String CONTENT= "Content";
	public static final String FG_RIGHT= "Fg_right";
	public static final String ANS_CONTENT= "Ans_content";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qu_ans() {
		return ((String) getAttrVal("Id_qu_ans"));
	}	
	public void setId_qu_ans(String Id_qu_ans) {
		setAttrVal("Id_qu_ans", Id_qu_ans);
	}
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
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
	public Integer getSerial_no() {
		return ((Integer) getAttrVal("Serial_no"));
	}	
	public void setSerial_no(Integer Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public FBoolean getFg_right() {
		return ((FBoolean) getAttrVal("Fg_right"));
	}	
	public void setFg_right(FBoolean Fg_right) {
		setAttrVal("Fg_right", Fg_right);
	}
	public String getAns_content() {
		return ((String) getAttrVal("Ans_content"));
	}	
	public void setAns_content(String Ans_content) {
		setAttrVal("Ans_content", Ans_content);
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
		return "Id_qu_ans";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_QU_ANS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamQuAnsDODesc.class);
	}
	
}