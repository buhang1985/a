package iih.pe.phm.pegencond.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pegencond.d.desc.PeGenCondDODesc;
import java.math.BigDecimal;

/**
 * 健康管理一般健康状态 DO数据 
 * 
 */
public class PeGenCondDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检一般健康状况评估主键标识
	public static final String ID_PEGENCOND= "Id_pegencond";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//健康管理预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//身高
	public static final String HEIGHT= "Height";
	//体重
	public static final String WEIGHT= "Weight";
	//理想体重
	public static final String IDEALWEIGHT= "Idealweight";
	//体重指数
	public static final String BMI= "Bmi";
	//收缩压
	public static final String SYSTOLIC= "Systolic";
	//舒张压
	public static final String DIASTOLIC= "Diastolic";
	//血糖
	public static final String GLUCOSE= "Glucose";
	//餐后2小时血糖
	public static final String POSTGLUCOSE= "Postglucose";
	//腰围
	public static final String WAISTLINE= "Waistline";
	//臀围
	public static final String HIPLINE= "Hipline";
	//腰臀比
	public static final String WAISTHIPRATIO= "Waisthipratio";
	//胆固醇
	public static final String TC= "Tc";
	//低密度脂蛋白
	public static final String LDL= "Ldl";
	//高密度脂蛋白
	public static final String HDL= "Hdl";
	//甘油三酯
	public static final String TG= "Tg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//血压分级
	public static final String LEVEL_BP= "Level_bp";
	//体重指数分级
	public static final String LEVEL_BMI= "Level_bmi";
	//血脂分级
	public static final String LEVEL_BLDFAT= "Level_bldfat";
	//血糖分级
	public static final String LEVEL_GLU= "Level_glu";
	//客户编码
	public static final String CODE= "Code";
	//姓名
	public static final String NAME= "Name";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//年龄
	public static final String AGE= "Age";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//性别ID
	public static final String ID_SEX= "Id_sex";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检一般健康状况评估主键标识
	 * @return String
	 */
	public String getId_pegencond() {
		return ((String) getAttrVal("Id_pegencond"));
	}	
	/**
	 * 体检一般健康状况评估主键标识
	 * @param Id_pegencond
	 */
	public void setId_pegencond(String Id_pegencond) {
		setAttrVal("Id_pegencond", Id_pegencond);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 体检个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 健康管理预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康管理预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 身高
	 * @return FDouble
	 */
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 理想体重
	 * @return FDouble
	 */
	public FDouble getIdealweight() {
		return ((FDouble) getAttrVal("Idealweight"));
	}	
	/**
	 * 理想体重
	 * @param Idealweight
	 */
	public void setIdealweight(FDouble Idealweight) {
		setAttrVal("Idealweight", Idealweight);
	}
	/**
	 * 体重指数
	 * @return FDouble
	 */
	public FDouble getBmi() {
		return ((FDouble) getAttrVal("Bmi"));
	}	
	/**
	 * 体重指数
	 * @param Bmi
	 */
	public void setBmi(FDouble Bmi) {
		setAttrVal("Bmi", Bmi);
	}
	/**
	 * 收缩压
	 * @return Integer
	 */
	public Integer getSystolic() {
		return ((Integer) getAttrVal("Systolic"));
	}	
	/**
	 * 收缩压
	 * @param Systolic
	 */
	public void setSystolic(Integer Systolic) {
		setAttrVal("Systolic", Systolic);
	}
	/**
	 * 舒张压
	 * @return Integer
	 */
	public Integer getDiastolic() {
		return ((Integer) getAttrVal("Diastolic"));
	}	
	/**
	 * 舒张压
	 * @param Diastolic
	 */
	public void setDiastolic(Integer Diastolic) {
		setAttrVal("Diastolic", Diastolic);
	}
	/**
	 * 血糖
	 * @return FDouble
	 */
	public FDouble getGlucose() {
		return ((FDouble) getAttrVal("Glucose"));
	}	
	/**
	 * 血糖
	 * @param Glucose
	 */
	public void setGlucose(FDouble Glucose) {
		setAttrVal("Glucose", Glucose);
	}
	/**
	 * 餐后2小时血糖
	 * @return FDouble
	 */
	public FDouble getPostglucose() {
		return ((FDouble) getAttrVal("Postglucose"));
	}	
	/**
	 * 餐后2小时血糖
	 * @param Postglucose
	 */
	public void setPostglucose(FDouble Postglucose) {
		setAttrVal("Postglucose", Postglucose);
	}
	/**
	 * 腰围
	 * @return FDouble
	 */
	public FDouble getWaistline() {
		return ((FDouble) getAttrVal("Waistline"));
	}	
	/**
	 * 腰围
	 * @param Waistline
	 */
	public void setWaistline(FDouble Waistline) {
		setAttrVal("Waistline", Waistline);
	}
	/**
	 * 臀围
	 * @return FDouble
	 */
	public FDouble getHipline() {
		return ((FDouble) getAttrVal("Hipline"));
	}	
	/**
	 * 臀围
	 * @param Hipline
	 */
	public void setHipline(FDouble Hipline) {
		setAttrVal("Hipline", Hipline);
	}
	/**
	 * 腰臀比
	 * @return FDouble
	 */
	public FDouble getWaisthipratio() {
		return ((FDouble) getAttrVal("Waisthipratio"));
	}	
	/**
	 * 腰臀比
	 * @param Waisthipratio
	 */
	public void setWaisthipratio(FDouble Waisthipratio) {
		setAttrVal("Waisthipratio", Waisthipratio);
	}
	/**
	 * 胆固醇
	 * @return FDouble
	 */
	public FDouble getTc() {
		return ((FDouble) getAttrVal("Tc"));
	}	
	/**
	 * 胆固醇
	 * @param Tc
	 */
	public void setTc(FDouble Tc) {
		setAttrVal("Tc", Tc);
	}
	/**
	 * 低密度脂蛋白
	 * @return FDouble
	 */
	public FDouble getLdl() {
		return ((FDouble) getAttrVal("Ldl"));
	}	
	/**
	 * 低密度脂蛋白
	 * @param Ldl
	 */
	public void setLdl(FDouble Ldl) {
		setAttrVal("Ldl", Ldl);
	}
	/**
	 * 高密度脂蛋白
	 * @return FDouble
	 */
	public FDouble getHdl() {
		return ((FDouble) getAttrVal("Hdl"));
	}	
	/**
	 * 高密度脂蛋白
	 * @param Hdl
	 */
	public void setHdl(FDouble Hdl) {
		setAttrVal("Hdl", Hdl);
	}
	/**
	 * 甘油三酯
	 * @return FDouble
	 */
	public FDouble getTg() {
		return ((FDouble) getAttrVal("Tg"));
	}	
	/**
	 * 甘油三酯
	 * @param Tg
	 */
	public void setTg(FDouble Tg) {
		setAttrVal("Tg", Tg);
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
	 * 血压分级
	 * @return Integer
	 */
	public Integer getLevel_bp() {
		return ((Integer) getAttrVal("Level_bp"));
	}	
	/**
	 * 血压分级
	 * @param Level_bp
	 */
	public void setLevel_bp(Integer Level_bp) {
		setAttrVal("Level_bp", Level_bp);
	}
	/**
	 * 体重指数分级
	 * @return Integer
	 */
	public Integer getLevel_bmi() {
		return ((Integer) getAttrVal("Level_bmi"));
	}	
	/**
	 * 体重指数分级
	 * @param Level_bmi
	 */
	public void setLevel_bmi(Integer Level_bmi) {
		setAttrVal("Level_bmi", Level_bmi);
	}
	/**
	 * 血脂分级
	 * @return Integer
	 */
	public Integer getLevel_bldfat() {
		return ((Integer) getAttrVal("Level_bldfat"));
	}	
	/**
	 * 血脂分级
	 * @param Level_bldfat
	 */
	public void setLevel_bldfat(Integer Level_bldfat) {
		setAttrVal("Level_bldfat", Level_bldfat);
	}
	/**
	 * 血糖分级
	 * @return Integer
	 */
	public Integer getLevel_glu() {
		return ((Integer) getAttrVal("Level_glu"));
	}	
	/**
	 * 血糖分级
	 * @param Level_glu
	 */
	public void setLevel_glu(Integer Level_glu) {
		setAttrVal("Level_glu", Level_glu);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 客户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别ID
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}	
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
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
		return "Id_pegencond";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pegencond";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeGenCondDODesc.class);
	}
	
}