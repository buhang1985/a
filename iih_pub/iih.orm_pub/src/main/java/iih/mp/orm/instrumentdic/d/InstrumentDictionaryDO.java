package iih.mp.orm.instrumentdic.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.instrumentdic.d.desc.InstrumentDictionaryDODesc;
import java.math.BigDecimal;

/**
 * 器械字典 DO数据 
 * 
 */
public class InstrumentDictionaryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMOM= "Id_mmom";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_OMCA= "Id_omca";
	public static final String ID_OMTP= "Id_omtp";
	public static final String SD_OMTP= "Sd_omtp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String NAME_OTH= "Name_oth";
	public static final String SPEC= "Spec";
	public static final String USE= "Use";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String OMCA_CODE= "Omca_code";
	public static final String OMCA_NAME= "Omca_name";
	public static final String OMTP_NAME= "Omtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmom() {
		return ((String) getAttrVal("Id_mmom"));
	}	
	public void setId_mmom(String Id_mmom) {
		setAttrVal("Id_mmom", Id_mmom);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_omca() {
		return ((String) getAttrVal("Id_omca"));
	}	
	public void setId_omca(String Id_omca) {
		setAttrVal("Id_omca", Id_omca);
	}
	public String getId_omtp() {
		return ((String) getAttrVal("Id_omtp"));
	}	
	public void setId_omtp(String Id_omtp) {
		setAttrVal("Id_omtp", Id_omtp);
	}
	public String getSd_omtp() {
		return ((String) getAttrVal("Sd_omtp"));
	}	
	public void setSd_omtp(String Sd_omtp) {
		setAttrVal("Sd_omtp", Sd_omtp);
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
	public String getName_oth() {
		return ((String) getAttrVal("Name_oth"));
	}	
	public void setName_oth(String Name_oth) {
		setAttrVal("Name_oth", Name_oth);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getUse() {
		return ((String) getAttrVal("Use"));
	}	
	public void setUse(String Use) {
		setAttrVal("Use", Use);
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
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getOmca_code() {
		return ((String) getAttrVal("Omca_code"));
	}	
	public void setOmca_code(String Omca_code) {
		setAttrVal("Omca_code", Omca_code);
	}
	public String getOmca_name() {
		return ((String) getAttrVal("Omca_name"));
	}	
	public void setOmca_name(String Omca_name) {
		setAttrVal("Omca_name", Omca_name);
	}
	public String getOmtp_name() {
		return ((String) getAttrVal("Omtp_name"));
	}	
	public void setOmtp_name(String Omtp_name) {
		setAttrVal("Omtp_name", Omtp_name);
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
		return "Id_mmom";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_orm_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InstrumentDictionaryDODesc.class);
	}
	
}