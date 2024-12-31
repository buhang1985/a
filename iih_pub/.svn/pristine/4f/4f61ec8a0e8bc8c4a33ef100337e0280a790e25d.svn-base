package iih.nm.net.exampp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.exampp.d.desc.ExamppSecDODesc;
import java.math.BigDecimal;

/**
 * 试卷段落 DO数据 
 * 
 */
public class ExamppSecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PPSEC= "Id_ppsec";
	public static final String ID_PP= "Id_pp";
	public static final String TITLE_NO= "Title_no";
	public static final String SERIAL_NO= "Serial_no";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String SCORE= "Score";
	public static final String ID_PAR= "Id_par";
	public static final String QS_NUM= "Qs_num";
	public static final String SCORE_NOW= "Score_now";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DES= "Des";
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ppsec() {
		return ((String) getAttrVal("Id_ppsec"));
	}	
	public void setId_ppsec(String Id_ppsec) {
		setAttrVal("Id_ppsec", Id_ppsec);
	}
	public String getId_pp() {
		return ((String) getAttrVal("Id_pp"));
	}	
	public void setId_pp(String Id_pp) {
		setAttrVal("Id_pp", Id_pp);
	}
	public String getTitle_no() {
		return ((String) getAttrVal("Title_no"));
	}	
	public void setTitle_no(String Title_no) {
		setAttrVal("Title_no", Title_no);
	}
	public Integer getSerial_no() {
		return ((Integer) getAttrVal("Serial_no"));
	}	
	public void setSerial_no(Integer Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public Integer getQs_num() {
		return ((Integer) getAttrVal("Qs_num"));
	}	
	public void setQs_num(Integer Qs_num) {
		setAttrVal("Qs_num", Qs_num);
	}
	public FDouble getScore_now() {
		return ((FDouble) getAttrVal("Score_now"));
	}	
	public void setScore_now(FDouble Score_now) {
		setAttrVal("Score_now", Score_now);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_ppsec";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_PP_SEC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamppSecDODesc.class);
	}
	
}