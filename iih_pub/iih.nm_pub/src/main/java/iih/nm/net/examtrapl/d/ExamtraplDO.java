package iih.nm.net.examtrapl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examtrapl.d.desc.ExamtraplDODesc;
import java.math.BigDecimal;

/**
 * 培训计划 DO数据 
 * 
 */
public class ExamtraplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EXAM_TRAPL= "Id_exam_trapl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String ID_SPK_PSN= "Id_spk_psn";
	public static final String FG_INFO= "Fg_info";
	public static final String DT_BEGIN_INFO= "Dt_begin_info";
	public static final String DT_END_INFO= "Dt_end_info";
	public static final String DT_BEGIN_PL= "Dt_begin_pl";
	public static final String DT_END_PL= "Dt_end_pl";
	public static final String ADDRES= "Addres";
	public static final String SD_TRATP= "Sd_tratp";
	public static final String CONTENT= "Content";
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	public static final String SD_STATUS= "Sd_status";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PSN= "Name_psn";
	public static final String NAME_TRATP= "Name_tratp";
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_exam_trapl() {
		return ((String) getAttrVal("Id_exam_trapl"));
	}	
	public void setId_exam_trapl(String Id_exam_trapl) {
		setAttrVal("Id_exam_trapl", Id_exam_trapl);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_spk_psn() {
		return ((String) getAttrVal("Id_spk_psn"));
	}	
	public void setId_spk_psn(String Id_spk_psn) {
		setAttrVal("Id_spk_psn", Id_spk_psn);
	}
	public FBoolean getFg_info() {
		return ((FBoolean) getAttrVal("Fg_info"));
	}	
	public void setFg_info(FBoolean Fg_info) {
		setAttrVal("Fg_info", Fg_info);
	}
	public FDateTime getDt_begin_info() {
		return ((FDateTime) getAttrVal("Dt_begin_info"));
	}	
	public void setDt_begin_info(FDateTime Dt_begin_info) {
		setAttrVal("Dt_begin_info", Dt_begin_info);
	}
	public FDateTime getDt_end_info() {
		return ((FDateTime) getAttrVal("Dt_end_info"));
	}	
	public void setDt_end_info(FDateTime Dt_end_info) {
		setAttrVal("Dt_end_info", Dt_end_info);
	}
	public FDateTime getDt_begin_pl() {
		return ((FDateTime) getAttrVal("Dt_begin_pl"));
	}	
	public void setDt_begin_pl(FDateTime Dt_begin_pl) {
		setAttrVal("Dt_begin_pl", Dt_begin_pl);
	}
	public FDateTime getDt_end_pl() {
		return ((FDateTime) getAttrVal("Dt_end_pl"));
	}	
	public void setDt_end_pl(FDateTime Dt_end_pl) {
		setAttrVal("Dt_end_pl", Dt_end_pl);
	}
	public String getAddres() {
		return ((String) getAttrVal("Addres"));
	}	
	public void setAddres(String Addres) {
		setAttrVal("Addres", Addres);
	}
	public String getSd_tratp() {
		return ((String) getAttrVal("Sd_tratp"));
	}	
	public void setSd_tratp(String Sd_tratp) {
		setAttrVal("Sd_tratp", Sd_tratp);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getSd_nur_level() {
		return ((String) getAttrVal("Sd_nur_level"));
	}	
	public void setSd_nur_level(String Sd_nur_level) {
		setAttrVal("Sd_nur_level", Sd_nur_level);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public String getName_tratp() {
		return ((String) getAttrVal("Name_tratp"));
	}	
	public void setName_tratp(String Name_tratp) {
		setAttrVal("Name_tratp", Name_tratp);
	}
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_exam_trapl";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_exam_trapl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamtraplDODesc.class);
	}
	
}