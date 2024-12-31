package iih.nmr.pkuf.heduplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.heduplan.d.desc.HeduPlanDODesc;
import java.math.BigDecimal;

/**
 * 健康教育计划单 DO数据 
 * 
 */
public class HeduPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康教育计划单主键
	public static final String ID_PKUF_HEDUPLAN= "Id_pkuf_heduplan";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//文书类型
	public static final String NMR_TYPE= "Nmr_type";
	//患者就诊ID
	public static final String ID_ENT= "Id_ent";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//床号
	public static final String NAME_BED= "Name_bed";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//创建记录人员
	public static final String ID_EMP_CREATE= "Id_emp_create";
	//创建记录时间
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//创建人姓名
	public static final String NAME_EMP_CREATE= "Name_emp_create";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康教育计划单主键
	 * @return String
	 */
	public String getId_pkuf_heduplan() {
		return ((String) getAttrVal("Id_pkuf_heduplan"));
	}	
	/**
	 * 健康教育计划单主键
	 * @param Id_pkuf_heduplan
	 */
	public void setId_pkuf_heduplan(String Id_pkuf_heduplan) {
		setAttrVal("Id_pkuf_heduplan", Id_pkuf_heduplan);
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
	 * 文书类型
	 * @return String
	 */
	public String getNmr_type() {
		return ((String) getAttrVal("Nmr_type"));
	}	
	/**
	 * 文书类型
	 * @param Nmr_type
	 */
	public void setNmr_type(String Nmr_type) {
		setAttrVal("Nmr_type", Nmr_type);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 创建记录人员
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 创建记录人员
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 创建记录时间
	 * @return String
	 */
	public String getDt_create() {
		return ((String) getAttrVal("Dt_create"));
	}	
	/**
	 * 创建记录时间
	 * @param Dt_create
	 */
	public void setDt_create(String Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 创建人姓名
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}	
	/**
	 * 创建人姓名
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
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
		return "Id_pkuf_heduplan";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_HEDUPLAN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HeduPlanDODesc.class);
	}
	
}