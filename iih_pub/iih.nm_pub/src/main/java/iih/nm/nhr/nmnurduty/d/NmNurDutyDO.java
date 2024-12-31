package iih.nm.nhr.nmnurduty.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurduty.d.desc.NmNurDutyDODesc;
import java.math.BigDecimal;

/**
 * 人员职务 DO数据 
 * 
 */
public class NmNurDutyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//人员职务主键
	public static final String ID_NUR_DUTY= "Id_nur_duty";
	//所属人员
	public static final String ID_NUR= "Id_nur";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//任命职务id
	public static final String ID_DUTY= "Id_duty";
	//任命职务编码
	public static final String SD_DUTY= "Sd_duty";
	//行政职务id
	public static final String ID_ADMIN_DUTY= "Id_admin_duty";
	//行政职务编码
	public static final String SD_ADMIN_DUTY= "Sd_admin_duty";
	//任命时间
	public static final String DT_APT= "Dt_apt";
	//任命年限
	public static final String APT_YEAR_LENTH= "Apt_year_lenth";
	//任命依据id
	public static final String ID_APT_GIST= "Id_apt_gist";
	//任命依据编码
	public static final String SD_APT_GIST= "Sd_apt_gist";
	//备注
	public static final String DES= "Des";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//名称
	public static final String NAME_DUTY= "Name_duty";
	//名称
	public static final String NAME_ADMIN_DUTY= "Name_admin_duty";
	//名称
	public static final String NAME_APT_GIST= "Name_apt_gist";
	//人员姓名
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 人员职务主键
	 * @return String
	 */
	public String getId_nur_duty() {
		return ((String) getAttrVal("Id_nur_duty"));
	}	
	/**
	 * 人员职务主键
	 * @param Id_nur_duty
	 */
	public void setId_nur_duty(String Id_nur_duty) {
		setAttrVal("Id_nur_duty", Id_nur_duty);
	}
	/**
	 * 所属人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 所属人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 任命职务id
	 * @return String
	 */
	public String getId_duty() {
		return ((String) getAttrVal("Id_duty"));
	}	
	/**
	 * 任命职务id
	 * @param Id_duty
	 */
	public void setId_duty(String Id_duty) {
		setAttrVal("Id_duty", Id_duty);
	}
	/**
	 * 任命职务编码
	 * @return String
	 */
	public String getSd_duty() {
		return ((String) getAttrVal("Sd_duty"));
	}	
	/**
	 * 任命职务编码
	 * @param Sd_duty
	 */
	public void setSd_duty(String Sd_duty) {
		setAttrVal("Sd_duty", Sd_duty);
	}
	/**
	 * 行政职务id
	 * @return String
	 */
	public String getId_admin_duty() {
		return ((String) getAttrVal("Id_admin_duty"));
	}	
	/**
	 * 行政职务id
	 * @param Id_admin_duty
	 */
	public void setId_admin_duty(String Id_admin_duty) {
		setAttrVal("Id_admin_duty", Id_admin_duty);
	}
	/**
	 * 行政职务编码
	 * @return String
	 */
	public String getSd_admin_duty() {
		return ((String) getAttrVal("Sd_admin_duty"));
	}	
	/**
	 * 行政职务编码
	 * @param Sd_admin_duty
	 */
	public void setSd_admin_duty(String Sd_admin_duty) {
		setAttrVal("Sd_admin_duty", Sd_admin_duty);
	}
	/**
	 * 任命时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apt() {
		return ((FDateTime) getAttrVal("Dt_apt"));
	}	
	/**
	 * 任命时间
	 * @param Dt_apt
	 */
	public void setDt_apt(FDateTime Dt_apt) {
		setAttrVal("Dt_apt", Dt_apt);
	}
	/**
	 * 任命年限
	 * @return Integer
	 */
	public Integer getApt_year_lenth() {
		return ((Integer) getAttrVal("Apt_year_lenth"));
	}	
	/**
	 * 任命年限
	 * @param Apt_year_lenth
	 */
	public void setApt_year_lenth(Integer Apt_year_lenth) {
		setAttrVal("Apt_year_lenth", Apt_year_lenth);
	}
	/**
	 * 任命依据id
	 * @return String
	 */
	public String getId_apt_gist() {
		return ((String) getAttrVal("Id_apt_gist"));
	}	
	/**
	 * 任命依据id
	 * @param Id_apt_gist
	 */
	public void setId_apt_gist(String Id_apt_gist) {
		setAttrVal("Id_apt_gist", Id_apt_gist);
	}
	/**
	 * 任命依据编码
	 * @return String
	 */
	public String getSd_apt_gist() {
		return ((String) getAttrVal("Sd_apt_gist"));
	}	
	/**
	 * 任命依据编码
	 * @param Sd_apt_gist
	 */
	public void setSd_apt_gist(String Sd_apt_gist) {
		setAttrVal("Sd_apt_gist", Sd_apt_gist);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	/**
	 * 名称
	 * @param Name_duty
	 */
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_admin_duty() {
		return ((String) getAttrVal("Name_admin_duty"));
	}	
	/**
	 * 名称
	 * @param Name_admin_duty
	 */
	public void setName_admin_duty(String Name_admin_duty) {
		setAttrVal("Name_admin_duty", Name_admin_duty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apt_gist() {
		return ((String) getAttrVal("Name_apt_gist"));
	}	
	/**
	 * 名称
	 * @param Name_apt_gist
	 */
	public void setName_apt_gist(String Name_apt_gist) {
		setAttrVal("Name_apt_gist", Name_apt_gist);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nur_duty";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_DUTY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurDutyDODesc.class);
	}
	
}