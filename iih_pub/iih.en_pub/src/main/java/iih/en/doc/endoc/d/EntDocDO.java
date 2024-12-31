package iih.en.doc.endoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.doc.endoc.d.desc.EntDocDODesc;
import java.math.BigDecimal;

/**
 * 就诊建档 DO数据 
 * 
 */
public class EntDocDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTDOC= "Id_entdoc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String SD_DOCTP= "Sd_doctp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String ID_MARI_PAT= "Id_mari_pat";
	public static final String SD_MARI_PAT= "Sd_mari_pat";
	public static final String TELNO_PAT= "Telno_pat";
	public static final String ID_ADMDIV_ADDR= "Id_admdiv_addr";
	public static final String SD_ADMDIV_ADDR= "Sd_admdiv_addr";
	public static final String ADDR_PAT= "Addr_pat";
	public static final String ID_PATCA= "Id_patca";
	public static final String DT_INSERT= "Dt_insert";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_ENT= "Dt_ent";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DOCTP= "Name_doctp";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_MARI_PAT= "Name_mari_pat";
	public static final String NAME_ADMDIV_ADDR= "Name_admdiv_addr";
	public static final String NAME_PATCA= "Name_patca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entdoc() {
		return ((String) getAttrVal("Id_entdoc"));
	}	
	public void setId_entdoc(String Id_entdoc) {
		setAttrVal("Id_entdoc", Id_entdoc);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getSd_doctp() {
		return ((String) getAttrVal("Sd_doctp"));
	}	
	public void setSd_doctp(String Sd_doctp) {
		setAttrVal("Sd_doctp", Sd_doctp);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getId_mari_pat() {
		return ((String) getAttrVal("Id_mari_pat"));
	}	
	public void setId_mari_pat(String Id_mari_pat) {
		setAttrVal("Id_mari_pat", Id_mari_pat);
	}
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}	
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}	
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	public String getId_admdiv_addr() {
		return ((String) getAttrVal("Id_admdiv_addr"));
	}	
	public void setId_admdiv_addr(String Id_admdiv_addr) {
		setAttrVal("Id_admdiv_addr", Id_admdiv_addr);
	}
	public String getSd_admdiv_addr() {
		return ((String) getAttrVal("Sd_admdiv_addr"));
	}	
	public void setSd_admdiv_addr(String Sd_admdiv_addr) {
		setAttrVal("Sd_admdiv_addr", Sd_admdiv_addr);
	}
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}	
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_ent() {
		return ((FDateTime) getAttrVal("Dt_ent"));
	}	
	public void setDt_ent(FDateTime Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
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
	public String getName_doctp() {
		return ((String) getAttrVal("Name_doctp"));
	}	
	public void setName_doctp(String Name_doctp) {
		setAttrVal("Name_doctp", Name_doctp);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_mari_pat() {
		return ((String) getAttrVal("Name_mari_pat"));
	}	
	public void setName_mari_pat(String Name_mari_pat) {
		setAttrVal("Name_mari_pat", Name_mari_pat);
	}
	public String getName_admdiv_addr() {
		return ((String) getAttrVal("Name_admdiv_addr"));
	}	
	public void setName_admdiv_addr(String Name_admdiv_addr) {
		setAttrVal("Name_admdiv_addr", Name_admdiv_addr);
	}
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
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
		return "Id_entdoc";
	}
	
	@Override
	public String getTableName() {	  
		return "en_doc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntDocDODesc.class);
	}
	
}