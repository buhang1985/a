package iih.ci.mrm.cimrmcopy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrmcopy.d.desc.CiMrmCopyDODesc;
import java.math.BigDecimal;

/**
 * 病案复印登记 DO数据 
 * 
 */
public class CiMrmCopyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CI_MRM_CP= "Id_ci_mrm_cp";
	public static final String ID_AMR= "Id_amr";
	public static final String ID_BD_MRM_PT= "Id_bd_mrm_pt";
	public static final String CODE_AMR= "Code_amr";
	public static final String FG_LOCAL= "Fg_local";
	public static final String ID_PURPOSE= "Id_purpose";
	public static final String SD_PURPOSE= "Sd_purpose";
	public static final String ID_RELATIONSHIP= "Id_relationship";
	public static final String SD_RELATIONSHIP= "Sd_relationship";
	public static final String ID_CARDTYPE= "Id_cardtype";
	public static final String SD_CARDTYPE= "Sd_cardtype";
	public static final String COPIES= "Copies";
	public static final String COPYNUM= "Copynum";
	public static final String TOTAL= "Total";
	public static final String DES= "Des";
	public static final String AGENT= "Agent";
	public static final String CODE_FILE= "Code_file";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MRM_PT_NAME= "Mrm_pt_name";
	public static final String NAME_PURPOSE= "Name_purpose";
	public static final String NAME_RELATIONSHIP= "Name_relationship";
	public static final String CARDTYPE_NAME= "Cardtype_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ci_mrm_cp() {
		return ((String) getAttrVal("Id_ci_mrm_cp"));
	}	
	public void setId_ci_mrm_cp(String Id_ci_mrm_cp) {
		setAttrVal("Id_ci_mrm_cp", Id_ci_mrm_cp);
	}
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}	
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	public String getId_bd_mrm_pt() {
		return ((String) getAttrVal("Id_bd_mrm_pt"));
	}	
	public void setId_bd_mrm_pt(String Id_bd_mrm_pt) {
		setAttrVal("Id_bd_mrm_pt", Id_bd_mrm_pt);
	}
	public String getCode_amr() {
		return ((String) getAttrVal("Code_amr"));
	}	
	public void setCode_amr(String Code_amr) {
		setAttrVal("Code_amr", Code_amr);
	}
	public FBoolean getFg_local() {
		return ((FBoolean) getAttrVal("Fg_local"));
	}	
	public void setFg_local(FBoolean Fg_local) {
		setAttrVal("Fg_local", Fg_local);
	}
	public String getId_purpose() {
		return ((String) getAttrVal("Id_purpose"));
	}	
	public void setId_purpose(String Id_purpose) {
		setAttrVal("Id_purpose", Id_purpose);
	}
	public String getSd_purpose() {
		return ((String) getAttrVal("Sd_purpose"));
	}	
	public void setSd_purpose(String Sd_purpose) {
		setAttrVal("Sd_purpose", Sd_purpose);
	}
	public String getId_relationship() {
		return ((String) getAttrVal("Id_relationship"));
	}	
	public void setId_relationship(String Id_relationship) {
		setAttrVal("Id_relationship", Id_relationship);
	}
	public String getSd_relationship() {
		return ((String) getAttrVal("Sd_relationship"));
	}	
	public void setSd_relationship(String Sd_relationship) {
		setAttrVal("Sd_relationship", Sd_relationship);
	}
	public String getId_cardtype() {
		return ((String) getAttrVal("Id_cardtype"));
	}	
	public void setId_cardtype(String Id_cardtype) {
		setAttrVal("Id_cardtype", Id_cardtype);
	}
	public String getSd_cardtype() {
		return ((String) getAttrVal("Sd_cardtype"));
	}	
	public void setSd_cardtype(String Sd_cardtype) {
		setAttrVal("Sd_cardtype", Sd_cardtype);
	}
	public Integer getCopies() {
		return ((Integer) getAttrVal("Copies"));
	}	
	public void setCopies(Integer Copies) {
		setAttrVal("Copies", Copies);
	}
	public Integer getCopynum() {
		return ((Integer) getAttrVal("Copynum"));
	}	
	public void setCopynum(Integer Copynum) {
		setAttrVal("Copynum", Copynum);
	}
	public FDouble getTotal() {
		return ((FDouble) getAttrVal("Total"));
	}	
	public void setTotal(FDouble Total) {
		setAttrVal("Total", Total);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getAgent() {
		return ((String) getAttrVal("Agent"));
	}	
	public void setAgent(String Agent) {
		setAttrVal("Agent", Agent);
	}
	public String getCode_file() {
		return ((String) getAttrVal("Code_file"));
	}	
	public void setCode_file(String Code_file) {
		setAttrVal("Code_file", Code_file);
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
	public String getMrm_pt_name() {
		return ((String) getAttrVal("Mrm_pt_name"));
	}	
	public void setMrm_pt_name(String Mrm_pt_name) {
		setAttrVal("Mrm_pt_name", Mrm_pt_name);
	}
	public String getName_purpose() {
		return ((String) getAttrVal("Name_purpose"));
	}	
	public void setName_purpose(String Name_purpose) {
		setAttrVal("Name_purpose", Name_purpose);
	}
	public String getName_relationship() {
		return ((String) getAttrVal("Name_relationship"));
	}	
	public void setName_relationship(String Name_relationship) {
		setAttrVal("Name_relationship", Name_relationship);
	}
	public String getCardtype_name() {
		return ((String) getAttrVal("Cardtype_name"));
	}	
	public void setCardtype_name(String Cardtype_name) {
		setAttrVal("Cardtype_name", Cardtype_name);
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
		return "Id_ci_mrm_cp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_cp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrmCopyDODesc.class);
	}
	
}