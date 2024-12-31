package iih.nm.nhr.nmnureduexp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnureduexp.d.desc.NmNurEduExpDODesc;
import java.math.BigDecimal;

/**
 * 护理人员_教育经历 DO数据 
 * 
 */
public class NmNurEduExpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUE_EDUEXP= "Id_nue_eduexp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String NAME_SCH= "Name_sch";
	public static final String ID_MAJOR_CA= "Id_major_ca";
	public static final String SD_MAJOR_CA= "Sd_major_ca";
	public static final String ID_MAJOR= "Id_major";
	public static final String SD_MAJOR= "Sd_major";
	public static final String ID_LENTH_SCH= "Id_lenth_sch";
	public static final String SD_LENTH_SCH= "Sd_lenth_sch";
	public static final String ID_EDUCAT= "Id_educat";
	public static final String SD_EDUCAT= "Sd_educat";
	public static final String ID_DEGREE= "Id_degree";
	public static final String SD_DEGREE= "Sd_degree";
	public static final String ID_EDUFORM= "Id_eduform";
	public static final String SD_EDUFORM= "Sd_eduform";
	public static final String DT_GRADU= "Dt_gradu";
	public static final String FG_HGT_EDU= "Fg_hgt_edu";
	public static final String FG_FIR_EDU= "Fg_fir_edu";
	public static final String FG_BASE_EDU= "Fg_base_edu";
	public static final String ID_NUR= "Id_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MAJOR_CA= "Name_major_ca";
	public static final String NAME_MAJOR= "Name_major";
	public static final String NAME_LENGTH_SCH= "Name_length_sch";
	public static final String NAME_EDUCAT= "Name_educat";
	public static final String NAME_DEGREE= "Name_degree";
	public static final String NAME_EDUFORM= "Name_eduform";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nue_eduexp() {
		return ((String) getAttrVal("Id_nue_eduexp"));
	}	
	public void setId_nue_eduexp(String Id_nue_eduexp) {
		setAttrVal("Id_nue_eduexp", Id_nue_eduexp);
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
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getName_sch() {
		return ((String) getAttrVal("Name_sch"));
	}	
	public void setName_sch(String Name_sch) {
		setAttrVal("Name_sch", Name_sch);
	}
	public String getId_major_ca() {
		return ((String) getAttrVal("Id_major_ca"));
	}	
	public void setId_major_ca(String Id_major_ca) {
		setAttrVal("Id_major_ca", Id_major_ca);
	}
	public String getSd_major_ca() {
		return ((String) getAttrVal("Sd_major_ca"));
	}	
	public void setSd_major_ca(String Sd_major_ca) {
		setAttrVal("Sd_major_ca", Sd_major_ca);
	}
	public String getId_major() {
		return ((String) getAttrVal("Id_major"));
	}	
	public void setId_major(String Id_major) {
		setAttrVal("Id_major", Id_major);
	}
	public String getSd_major() {
		return ((String) getAttrVal("Sd_major"));
	}	
	public void setSd_major(String Sd_major) {
		setAttrVal("Sd_major", Sd_major);
	}
	public String getId_lenth_sch() {
		return ((String) getAttrVal("Id_lenth_sch"));
	}	
	public void setId_lenth_sch(String Id_lenth_sch) {
		setAttrVal("Id_lenth_sch", Id_lenth_sch);
	}
	public String getSd_lenth_sch() {
		return ((String) getAttrVal("Sd_lenth_sch"));
	}	
	public void setSd_lenth_sch(String Sd_lenth_sch) {
		setAttrVal("Sd_lenth_sch", Sd_lenth_sch);
	}
	public String getId_educat() {
		return ((String) getAttrVal("Id_educat"));
	}	
	public void setId_educat(String Id_educat) {
		setAttrVal("Id_educat", Id_educat);
	}
	public String getSd_educat() {
		return ((String) getAttrVal("Sd_educat"));
	}	
	public void setSd_educat(String Sd_educat) {
		setAttrVal("Sd_educat", Sd_educat);
	}
	public String getId_degree() {
		return ((String) getAttrVal("Id_degree"));
	}	
	public void setId_degree(String Id_degree) {
		setAttrVal("Id_degree", Id_degree);
	}
	public String getSd_degree() {
		return ((String) getAttrVal("Sd_degree"));
	}	
	public void setSd_degree(String Sd_degree) {
		setAttrVal("Sd_degree", Sd_degree);
	}
	public String getId_eduform() {
		return ((String) getAttrVal("Id_eduform"));
	}	
	public void setId_eduform(String Id_eduform) {
		setAttrVal("Id_eduform", Id_eduform);
	}
	public String getSd_eduform() {
		return ((String) getAttrVal("Sd_eduform"));
	}	
	public void setSd_eduform(String Sd_eduform) {
		setAttrVal("Sd_eduform", Sd_eduform);
	}
	public FDate getDt_gradu() {
		return ((FDate) getAttrVal("Dt_gradu"));
	}	
	public void setDt_gradu(FDate Dt_gradu) {
		setAttrVal("Dt_gradu", Dt_gradu);
	}
	public FBoolean getFg_hgt_edu() {
		return ((FBoolean) getAttrVal("Fg_hgt_edu"));
	}	
	public void setFg_hgt_edu(FBoolean Fg_hgt_edu) {
		setAttrVal("Fg_hgt_edu", Fg_hgt_edu);
	}
	public FBoolean getFg_fir_edu() {
		return ((FBoolean) getAttrVal("Fg_fir_edu"));
	}	
	public void setFg_fir_edu(FBoolean Fg_fir_edu) {
		setAttrVal("Fg_fir_edu", Fg_fir_edu);
	}
	public FBoolean getFg_base_edu() {
		return ((FBoolean) getAttrVal("Fg_base_edu"));
	}	
	public void setFg_base_edu(FBoolean Fg_base_edu) {
		setAttrVal("Fg_base_edu", Fg_base_edu);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	public String getName_major_ca() {
		return ((String) getAttrVal("Name_major_ca"));
	}	
	public void setName_major_ca(String Name_major_ca) {
		setAttrVal("Name_major_ca", Name_major_ca);
	}
	public String getName_major() {
		return ((String) getAttrVal("Name_major"));
	}	
	public void setName_major(String Name_major) {
		setAttrVal("Name_major", Name_major);
	}
	public String getName_length_sch() {
		return ((String) getAttrVal("Name_length_sch"));
	}	
	public void setName_length_sch(String Name_length_sch) {
		setAttrVal("Name_length_sch", Name_length_sch);
	}
	public String getName_educat() {
		return ((String) getAttrVal("Name_educat"));
	}	
	public void setName_educat(String Name_educat) {
		setAttrVal("Name_educat", Name_educat);
	}
	public String getName_degree() {
		return ((String) getAttrVal("Name_degree"));
	}	
	public void setName_degree(String Name_degree) {
		setAttrVal("Name_degree", Name_degree);
	}
	public String getName_eduform() {
		return ((String) getAttrVal("Name_eduform"));
	}	
	public void setName_eduform(String Name_eduform) {
		setAttrVal("Name_eduform", Name_eduform);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_nue_eduexp";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_EDUEXP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurEduExpDODesc.class);
	}
	
}