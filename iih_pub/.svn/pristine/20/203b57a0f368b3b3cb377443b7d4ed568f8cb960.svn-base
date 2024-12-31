package iih.mp.mpbd.mobileapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mobileapp.d.desc.MpMbhAppDODesc;
import java.math.BigDecimal;

/**
 * 移动医疗app DO数据 
 * 
 */
public class MpMbhAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MBH_APP= "Id_mbh_app";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String MOBILETYPE= "Mobiletype";
	public static final String RESOLUTION= "Resolution";
	public static final String SYSCA= "Sysca";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mbh_app() {
		return ((String) getAttrVal("Id_mbh_app"));
	}	
	public void setId_mbh_app(String Id_mbh_app) {
		setAttrVal("Id_mbh_app", Id_mbh_app);
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
	public String getMobiletype() {
		return ((String) getAttrVal("Mobiletype"));
	}	
	public void setMobiletype(String Mobiletype) {
		setAttrVal("Mobiletype", Mobiletype);
	}
	public String getResolution() {
		return ((String) getAttrVal("Resolution"));
	}	
	public void setResolution(String Resolution) {
		setAttrVal("Resolution", Resolution);
	}
	public String getSysca() {
		return ((String) getAttrVal("Sysca"));
	}	
	public void setSysca(String Sysca) {
		setAttrVal("Sysca", Sysca);
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
		return "Id_mbh_app";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mbh_app";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpMbhAppDODesc.class);
	}
	
}