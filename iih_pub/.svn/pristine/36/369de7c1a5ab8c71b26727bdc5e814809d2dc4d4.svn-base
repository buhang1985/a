package iih.bd.fc.querule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.querule.d.desc.QueRuleDODesc;
import java.math.BigDecimal;

/**
 * 队列规则 DO数据 
 * 
 */
public class QueRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QUERULE= "Id_querule";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_QUERULETYPE= "Sd_queruletype";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String QUAN_WAIT= "Quan_wait";
	public static final String ID_FUN= "Id_fun";
	public static final String ID_QUEBENTP= "Id_quebentp";
	public static final String SD_QUEBENTP= "Sd_quebentp";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String RSN_REFUSE= "Rsn_refuse";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_querule() {
		return ((String) getAttrVal("Id_querule"));
	}	
	public void setId_querule(String Id_querule) {
		setAttrVal("Id_querule", Id_querule);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public Integer getSd_queruletype() {
		return ((Integer) getAttrVal("Sd_queruletype"));
	}	
	public void setSd_queruletype(Integer Sd_queruletype) {
		setAttrVal("Sd_queruletype", Sd_queruletype);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public Integer getQuan_wait() {
		return ((Integer) getAttrVal("Quan_wait"));
	}	
	public void setQuan_wait(Integer Quan_wait) {
		setAttrVal("Quan_wait", Quan_wait);
	}
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}	
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
	public String getId_quebentp() {
		return ((String) getAttrVal("Id_quebentp"));
	}	
	public void setId_quebentp(String Id_quebentp) {
		setAttrVal("Id_quebentp", Id_quebentp);
	}
	public String getSd_quebentp() {
		return ((String) getAttrVal("Sd_quebentp"));
	}	
	public void setSd_quebentp(String Sd_quebentp) {
		setAttrVal("Sd_quebentp", Sd_quebentp);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getRsn_refuse() {
		return ((String) getAttrVal("Rsn_refuse"));
	}	
	public void setRsn_refuse(String Rsn_refuse) {
		setAttrVal("Rsn_refuse", Rsn_refuse);
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
		return "Id_querule";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_que_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QueRuleDODesc.class);
	}
	
}