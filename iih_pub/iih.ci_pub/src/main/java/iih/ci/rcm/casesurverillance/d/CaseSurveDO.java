package iih.ci.rcm.casesurverillance.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.casesurverillance.d.desc.CaseSurveDODesc;
import java.math.BigDecimal;

/**
 * ICU病例监测 DO数据 
 * 
 */
public class CaseSurveDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//ICU病例监测id
	public static final String ID_CASE= "Id_case";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//患者
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String SD_PAT= "Sd_pat";
	//患者名称
	public static final String NAME_PAT= "Name_pat";
	//科别
	public static final String ID_DEPT= "Id_dept";
	//科别编码
	public static final String CODE_DEPT= "Code_dept";
	//科别名称
	public static final String NAME_DEPT= "Name_dept";
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//调查时间
	public static final String INVESTTIME= "Investtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调查者
	public static final String ID_PSN= "Id_psn";
	//入ICU日期
	public static final String ENTRY_ICU_DATE= "Entry_icu_date";
	//出ICU日期
	public static final String OUT_ICU_DATE= "Out_icu_date";
	//转入科别
	public static final String CHANGE_INTO_CATEGORY= "Change_into_category";
	//转出科别
	public static final String ROLL_OUT_CATEGORY= "Roll_out_category";
	//住ICU时间
	public static final String INTO_CATEGORY_DAY= "Into_category_day";
	//气道1d
	public static final String AIRWAY_1D= "Airway_1d";
	//气道2d
	public static final String AIRWAY_2D= "Airway_2d";
	//机械通气1d
	public static final String MECH_VENT_1D= "Mech_vent_1d";
	//机械通气2d
	public static final String MECH_VENT_2D= "Mech_vent_2d";
	//中心静脉导管1d
	public static final String CEN_VEN_CATH_1D= "Cen_ven_cath_1d";
	//中心静脉导管2d
	public static final String CEN_VEN_CATH_2D= "Cen_ven_cath_2d";
	//尿管1d
	public static final String URETER_1D= "Ureter_1d";
	//尿管2d
	public static final String URETER_2D= "Ureter_2d";
	//动脉置管1d
	public static final String ARTE_CATH_1D= "Arte_cath_1d";
	//动脉置管2d
	public static final String ARTE_CATH_2D= "Arte_cath_2d";
	//其他装置1d
	public static final String OTHER_DEVICE_1D= "Other_device_1d";
	//其他装置2d
	public static final String OTHER_DEVICE_2D= "Other_device_2d";
	//APACHE II评分
	public static final String APACHE_SCORE= "Apache_score";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//患者名称
	public static final String HOS_NAME_PAT= "Hos_name_pat";
	//患者编码
	public static final String HOS_SD_PAT= "Hos_sd_pat";
	//名称
	public static final String ENTRY_DEPT_NAME= "Entry_dept_name";
	//编码
	public static final String ENTRY_DEPT_CODE= "Entry_dept_code";
	//编码
	public static final String OUT_DEPT_CODE= "Out_dept_code";
	//名称
	public static final String OUT_DEPT_NAME= "Out_dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * ICU病例监测id
	 * @return String
	 */
	public String getId_case() {
		return ((String) getAttrVal("Id_case"));
	}	
	/**
	 * ICU病例监测id
	 * @param Id_case
	 */
	public void setId_case(String Id_case) {
		setAttrVal("Id_case", Id_case);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 患者编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 科别
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 科别
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 科别编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科别编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科别名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科别名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 院感上报主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 调查时间
	 * @return FDateTime
	 */
	public FDateTime getInvesttime() {
		return ((FDateTime) getAttrVal("Investtime"));
	}	
	/**
	 * 调查时间
	 * @param Investtime
	 */
	public void setInvesttime(FDateTime Investtime) {
		setAttrVal("Investtime", Investtime);
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
	 * 调查者
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 调查者
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 入ICU日期
	 * @return FDateTime
	 */
	public FDateTime getEntry_icu_date() {
		return ((FDateTime) getAttrVal("Entry_icu_date"));
	}	
	/**
	 * 入ICU日期
	 * @param Entry_icu_date
	 */
	public void setEntry_icu_date(FDateTime Entry_icu_date) {
		setAttrVal("Entry_icu_date", Entry_icu_date);
	}
	/**
	 * 出ICU日期
	 * @return FDateTime
	 */
	public FDateTime getOut_icu_date() {
		return ((FDateTime) getAttrVal("Out_icu_date"));
	}	
	/**
	 * 出ICU日期
	 * @param Out_icu_date
	 */
	public void setOut_icu_date(FDateTime Out_icu_date) {
		setAttrVal("Out_icu_date", Out_icu_date);
	}
	/**
	 * 转入科别
	 * @return String
	 */
	public String getChange_into_category() {
		return ((String) getAttrVal("Change_into_category"));
	}	
	/**
	 * 转入科别
	 * @param Change_into_category
	 */
	public void setChange_into_category(String Change_into_category) {
		setAttrVal("Change_into_category", Change_into_category);
	}
	/**
	 * 转出科别
	 * @return String
	 */
	public String getRoll_out_category() {
		return ((String) getAttrVal("Roll_out_category"));
	}	
	/**
	 * 转出科别
	 * @param Roll_out_category
	 */
	public void setRoll_out_category(String Roll_out_category) {
		setAttrVal("Roll_out_category", Roll_out_category);
	}
	/**
	 * 住ICU时间
	 * @return String
	 */
	public String getInto_category_day() {
		return ((String) getAttrVal("Into_category_day"));
	}	
	/**
	 * 住ICU时间
	 * @param Into_category_day
	 */
	public void setInto_category_day(String Into_category_day) {
		setAttrVal("Into_category_day", Into_category_day);
	}
	/**
	 * 气道1d
	 * @return FBoolean
	 */
	public FBoolean getAirway_1d() {
		return ((FBoolean) getAttrVal("Airway_1d"));
	}	
	/**
	 * 气道1d
	 * @param Airway_1d
	 */
	public void setAirway_1d(FBoolean Airway_1d) {
		setAttrVal("Airway_1d", Airway_1d);
	}
	/**
	 * 气道2d
	 * @return FBoolean
	 */
	public FBoolean getAirway_2d() {
		return ((FBoolean) getAttrVal("Airway_2d"));
	}	
	/**
	 * 气道2d
	 * @param Airway_2d
	 */
	public void setAirway_2d(FBoolean Airway_2d) {
		setAttrVal("Airway_2d", Airway_2d);
	}
	/**
	 * 机械通气1d
	 * @return FBoolean
	 */
	public FBoolean getMech_vent_1d() {
		return ((FBoolean) getAttrVal("Mech_vent_1d"));
	}	
	/**
	 * 机械通气1d
	 * @param Mech_vent_1d
	 */
	public void setMech_vent_1d(FBoolean Mech_vent_1d) {
		setAttrVal("Mech_vent_1d", Mech_vent_1d);
	}
	/**
	 * 机械通气2d
	 * @return FBoolean
	 */
	public FBoolean getMech_vent_2d() {
		return ((FBoolean) getAttrVal("Mech_vent_2d"));
	}	
	/**
	 * 机械通气2d
	 * @param Mech_vent_2d
	 */
	public void setMech_vent_2d(FBoolean Mech_vent_2d) {
		setAttrVal("Mech_vent_2d", Mech_vent_2d);
	}
	/**
	 * 中心静脉导管1d
	 * @return FBoolean
	 */
	public FBoolean getCen_ven_cath_1d() {
		return ((FBoolean) getAttrVal("Cen_ven_cath_1d"));
	}	
	/**
	 * 中心静脉导管1d
	 * @param Cen_ven_cath_1d
	 */
	public void setCen_ven_cath_1d(FBoolean Cen_ven_cath_1d) {
		setAttrVal("Cen_ven_cath_1d", Cen_ven_cath_1d);
	}
	/**
	 * 中心静脉导管2d
	 * @return FBoolean
	 */
	public FBoolean getCen_ven_cath_2d() {
		return ((FBoolean) getAttrVal("Cen_ven_cath_2d"));
	}	
	/**
	 * 中心静脉导管2d
	 * @param Cen_ven_cath_2d
	 */
	public void setCen_ven_cath_2d(FBoolean Cen_ven_cath_2d) {
		setAttrVal("Cen_ven_cath_2d", Cen_ven_cath_2d);
	}
	/**
	 * 尿管1d
	 * @return FBoolean
	 */
	public FBoolean getUreter_1d() {
		return ((FBoolean) getAttrVal("Ureter_1d"));
	}	
	/**
	 * 尿管1d
	 * @param Ureter_1d
	 */
	public void setUreter_1d(FBoolean Ureter_1d) {
		setAttrVal("Ureter_1d", Ureter_1d);
	}
	/**
	 * 尿管2d
	 * @return FBoolean
	 */
	public FBoolean getUreter_2d() {
		return ((FBoolean) getAttrVal("Ureter_2d"));
	}	
	/**
	 * 尿管2d
	 * @param Ureter_2d
	 */
	public void setUreter_2d(FBoolean Ureter_2d) {
		setAttrVal("Ureter_2d", Ureter_2d);
	}
	/**
	 * 动脉置管1d
	 * @return FBoolean
	 */
	public FBoolean getArte_cath_1d() {
		return ((FBoolean) getAttrVal("Arte_cath_1d"));
	}	
	/**
	 * 动脉置管1d
	 * @param Arte_cath_1d
	 */
	public void setArte_cath_1d(FBoolean Arte_cath_1d) {
		setAttrVal("Arte_cath_1d", Arte_cath_1d);
	}
	/**
	 * 动脉置管2d
	 * @return FBoolean
	 */
	public FBoolean getArte_cath_2d() {
		return ((FBoolean) getAttrVal("Arte_cath_2d"));
	}	
	/**
	 * 动脉置管2d
	 * @param Arte_cath_2d
	 */
	public void setArte_cath_2d(FBoolean Arte_cath_2d) {
		setAttrVal("Arte_cath_2d", Arte_cath_2d);
	}
	/**
	 * 其他装置1d
	 * @return FBoolean
	 */
	public FBoolean getOther_device_1d() {
		return ((FBoolean) getAttrVal("Other_device_1d"));
	}	
	/**
	 * 其他装置1d
	 * @param Other_device_1d
	 */
	public void setOther_device_1d(FBoolean Other_device_1d) {
		setAttrVal("Other_device_1d", Other_device_1d);
	}
	/**
	 * 其他装置2d
	 * @return FBoolean
	 */
	public FBoolean getOther_device_2d() {
		return ((FBoolean) getAttrVal("Other_device_2d"));
	}	
	/**
	 * 其他装置2d
	 * @param Other_device_2d
	 */
	public void setOther_device_2d(FBoolean Other_device_2d) {
		setAttrVal("Other_device_2d", Other_device_2d);
	}
	/**
	 * APACHE II评分
	 * @return Integer
	 */
	public Integer getApache_score() {
		return ((Integer) getAttrVal("Apache_score"));
	}	
	/**
	 * APACHE II评分
	 * @param Apache_score
	 */
	public void setApache_score(Integer Apache_score) {
		setAttrVal("Apache_score", Apache_score);
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
	 * 名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getHos_name_pat() {
		return ((String) getAttrVal("Hos_name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Hos_name_pat
	 */
	public void setHos_name_pat(String Hos_name_pat) {
		setAttrVal("Hos_name_pat", Hos_name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getHos_sd_pat() {
		return ((String) getAttrVal("Hos_sd_pat"));
	}	
	/**
	 * 患者编码
	 * @param Hos_sd_pat
	 */
	public void setHos_sd_pat(String Hos_sd_pat) {
		setAttrVal("Hos_sd_pat", Hos_sd_pat);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEntry_dept_name() {
		return ((String) getAttrVal("Entry_dept_name"));
	}	
	/**
	 * 名称
	 * @param Entry_dept_name
	 */
	public void setEntry_dept_name(String Entry_dept_name) {
		setAttrVal("Entry_dept_name", Entry_dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getEntry_dept_code() {
		return ((String) getAttrVal("Entry_dept_code"));
	}	
	/**
	 * 编码
	 * @param Entry_dept_code
	 */
	public void setEntry_dept_code(String Entry_dept_code) {
		setAttrVal("Entry_dept_code", Entry_dept_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOut_dept_code() {
		return ((String) getAttrVal("Out_dept_code"));
	}	
	/**
	 * 编码
	 * @param Out_dept_code
	 */
	public void setOut_dept_code(String Out_dept_code) {
		setAttrVal("Out_dept_code", Out_dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOut_dept_name() {
		return ((String) getAttrVal("Out_dept_name"));
	}	
	/**
	 * 名称
	 * @param Out_dept_name
	 */
	public void setOut_dept_name(String Out_dept_name) {
		setAttrVal("Out_dept_name", Out_dept_name);
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
		return "Id_case";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_casesur";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CaseSurveDODesc.class);
	}
	
}