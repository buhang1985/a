package iih.nm.nqm.qctplapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.qctplapp.d.desc.QctplAppEleDODesc;
import java.math.BigDecimal;

/**
 * 质量控制应用项目 DO数据 
 * 
 */
public class QctplAppEleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QCTPL_APP_ELE= "Id_qctpl_app_ele";
	public static final String ID_QCTPL_APP= "Id_qctpl_app";
	public static final String ID_QCTPL_ELE= "Id_qctpl_ele";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_PAR= "Id_par";
	public static final String SCORE= "Score";
	public static final String RATE_PASS= "Rate_pass";
	public static final String REMARKS= "Remarks";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qctpl_app_ele() {
		return ((String) getAttrVal("Id_qctpl_app_ele"));
	}	
	public void setId_qctpl_app_ele(String Id_qctpl_app_ele) {
		setAttrVal("Id_qctpl_app_ele", Id_qctpl_app_ele);
	}
	public String getId_qctpl_app() {
		return ((String) getAttrVal("Id_qctpl_app"));
	}	
	public void setId_qctpl_app(String Id_qctpl_app) {
		setAttrVal("Id_qctpl_app", Id_qctpl_app);
	}
	public String getId_qctpl_ele() {
		return ((String) getAttrVal("Id_qctpl_ele"));
	}	
	public void setId_qctpl_ele(String Id_qctpl_ele) {
		setAttrVal("Id_qctpl_ele", Id_qctpl_ele);
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
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	public FDouble getRate_pass() {
		return ((FDouble) getAttrVal("Rate_pass"));
	}	
	public void setRate_pass(FDouble Rate_pass) {
		setAttrVal("Rate_pass", Rate_pass);
	}
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}	
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
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
		return "Id_qctpl_app_ele";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_QCTPL_APP_ELE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QctplAppEleDODesc.class);
	}
	
}