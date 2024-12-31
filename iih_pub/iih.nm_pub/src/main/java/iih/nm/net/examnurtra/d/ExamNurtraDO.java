package iih.nm.net.examnurtra.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examnurtra.d.desc.ExamNurtraDODesc;
import java.math.BigDecimal;

/**
 * 护理人员培训 DO数据 
 * 
 */
public class ExamNurtraDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EXAM_NUTRA= "Id_exam_nutra";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_EXAM_TRAPL= "Id_exam_trapl";
	public static final String NAME= "Name";
	public static final String YEAR= "Year";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String CUS_CRDT= "Cus_crdt";
	public static final String SCHEDUL= "Schedul";
	public static final String ID_LCTR_PSN= "Id_lctr_psn";
	public static final String ADDRES= "Addres";
	public static final String ID_NUR_DEP= "Id_nur_dep";
	public static final String SD_TRATP= "Sd_tratp";
	public static final String SPK_UNIT= "Spk_unit";
	public static final String CONTENT= "Content";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String TRA_NAME= "Tra_name";
	public static final String PSN_NAME= "Psn_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String TRATP_NAME= "Tratp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_exam_nutra() {
		return ((String) getAttrVal("Id_exam_nutra"));
	}	
	public void setId_exam_nutra(String Id_exam_nutra) {
		setAttrVal("Id_exam_nutra", Id_exam_nutra);
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
	public String getId_exam_trapl() {
		return ((String) getAttrVal("Id_exam_trapl"));
	}	
	public void setId_exam_trapl(String Id_exam_trapl) {
		setAttrVal("Id_exam_trapl", Id_exam_trapl);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDouble getCus_crdt() {
		return ((FDouble) getAttrVal("Cus_crdt"));
	}	
	public void setCus_crdt(FDouble Cus_crdt) {
		setAttrVal("Cus_crdt", Cus_crdt);
	}
	public FDouble getSchedul() {
		return ((FDouble) getAttrVal("Schedul"));
	}	
	public void setSchedul(FDouble Schedul) {
		setAttrVal("Schedul", Schedul);
	}
	public String getId_lctr_psn() {
		return ((String) getAttrVal("Id_lctr_psn"));
	}	
	public void setId_lctr_psn(String Id_lctr_psn) {
		setAttrVal("Id_lctr_psn", Id_lctr_psn);
	}
	public String getAddres() {
		return ((String) getAttrVal("Addres"));
	}	
	public void setAddres(String Addres) {
		setAttrVal("Addres", Addres);
	}
	public String getId_nur_dep() {
		return ((String) getAttrVal("Id_nur_dep"));
	}	
	public void setId_nur_dep(String Id_nur_dep) {
		setAttrVal("Id_nur_dep", Id_nur_dep);
	}
	public String getSd_tratp() {
		return ((String) getAttrVal("Sd_tratp"));
	}	
	public void setSd_tratp(String Sd_tratp) {
		setAttrVal("Sd_tratp", Sd_tratp);
	}
	public String getSpk_unit() {
		return ((String) getAttrVal("Spk_unit"));
	}	
	public void setSpk_unit(String Spk_unit) {
		setAttrVal("Spk_unit", Spk_unit);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
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
	public String getTra_name() {
		return ((String) getAttrVal("Tra_name"));
	}	
	public void setTra_name(String Tra_name) {
		setAttrVal("Tra_name", Tra_name);
	}
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getTratp_name() {
		return ((String) getAttrVal("Tratp_name"));
	}	
	public void setTratp_name(String Tratp_name) {
		setAttrVal("Tratp_name", Tratp_name);
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
		return "Id_exam_nutra";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_NURTRA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamNurtraDODesc.class);
	}
	
}