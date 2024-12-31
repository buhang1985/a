package iih.bd.bc.medterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bc.medterm.d.desc.SampCollectTimeDictDODesc;
import java.math.BigDecimal;

/**
 * 标本采集时间 DO数据 
 * 
 */
public class SampCollectTimeDictDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SAMPCOLLECTTIME= "Id_sampcollecttime";
	public static final String ID_SAMPCOLLECTTIMETP= "Id_sampcollecttimetp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_SAMPCOLLECTTIMETP= "Sd_sampcollecttimetp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String LEN_TIME= "Len_time";
	public static final String ID_UNIT_TIME= "Id_unit_time";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_UNIT_TIME= "Name_unit_time";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sampcollecttime() {
		return ((String) getAttrVal("Id_sampcollecttime"));
	}	
	public void setId_sampcollecttime(String Id_sampcollecttime) {
		setAttrVal("Id_sampcollecttime", Id_sampcollecttime);
	}
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}	
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
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
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}	
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public FDouble getLen_time() {
		return ((FDouble) getAttrVal("Len_time"));
	}	
	public void setLen_time(FDouble Len_time) {
		setAttrVal("Len_time", Len_time);
	}
	public String getId_unit_time() {
		return ((String) getAttrVal("Id_unit_time"));
	}	
	public void setId_unit_time(String Id_unit_time) {
		setAttrVal("Id_unit_time", Id_unit_time);
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
	public String getName_unit_time() {
		return ((String) getAttrVal("Name_unit_time"));
	}	
	public void setName_unit_time(String Name_unit_time) {
		setAttrVal("Name_unit_time", Name_unit_time);
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
		return "Id_sampcollecttime";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_sampcol_time";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SampCollectTimeDictDODesc.class);
	}
	
}