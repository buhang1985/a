package iih.pe.phm.perststroke.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.perststroke.d.desc.PeRstStrokeDODesc;
import java.math.BigDecimal;

/**
 * 健康管理_脑卒中评估结果 DO数据 
 * 
 */
public class PeRstStrokeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康评估脑卒中评估结果主键标识
	public static final String ID_PERSTSTROKE= "Id_perststroke";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//年龄得分
	public static final String AGE= "Age";
	//收缩压得分
	public static final String SBP= "Sbp";
	//收缩压治疗标识
	public static final String FG_CURE= "Fg_cure";
	//糖尿病得分
	public static final String DIABETES= "Diabetes";
	//吸烟得分
	public static final String SMOKE= "Smoke";
	//心血管疾病得分
	public static final String CVD= "Cvd";
	//心房纤颤得分
	public static final String AF= "Af";
	//左心室肥厚得分
	public static final String LVH= "Lvh";
	//总分
	public static final String TOTAL= "Total";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//增加风险_一般人群
	public static final String HIGHER_GEN= "Higher_gen";
	//增加风险_低危人群
	public static final String HIGHER_LOWRISK= "Higher_lowrisk";
	//增加风险倍数_一般人群
	public static final String TIMES_GEN= "Times_gen";
	//增加风险倍数_低危人群
	public static final String TIMES_LOWRISK= "Times_lowrisk";
	//预约号
	public static final String NO_APPT= "No_appt";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康评估脑卒中评估结果主键标识
	 * @return String
	 */
	public String getId_perststroke() {
		return ((String) getAttrVal("Id_perststroke"));
	}	
	/**
	 * 健康评估脑卒中评估结果主键标识
	 * @param Id_perststroke
	 */
	public void setId_perststroke(String Id_perststroke) {
		setAttrVal("Id_perststroke", Id_perststroke);
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
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
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
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 年龄得分
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}	
	/**
	 * 年龄得分
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 收缩压得分
	 * @return Integer
	 */
	public Integer getSbp() {
		return ((Integer) getAttrVal("Sbp"));
	}	
	/**
	 * 收缩压得分
	 * @param Sbp
	 */
	public void setSbp(Integer Sbp) {
		setAttrVal("Sbp", Sbp);
	}
	/**
	 * 收缩压治疗标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cure() {
		return ((FBoolean) getAttrVal("Fg_cure"));
	}	
	/**
	 * 收缩压治疗标识
	 * @param Fg_cure
	 */
	public void setFg_cure(FBoolean Fg_cure) {
		setAttrVal("Fg_cure", Fg_cure);
	}
	/**
	 * 糖尿病得分
	 * @return Integer
	 */
	public Integer getDiabetes() {
		return ((Integer) getAttrVal("Diabetes"));
	}	
	/**
	 * 糖尿病得分
	 * @param Diabetes
	 */
	public void setDiabetes(Integer Diabetes) {
		setAttrVal("Diabetes", Diabetes);
	}
	/**
	 * 吸烟得分
	 * @return Integer
	 */
	public Integer getSmoke() {
		return ((Integer) getAttrVal("Smoke"));
	}	
	/**
	 * 吸烟得分
	 * @param Smoke
	 */
	public void setSmoke(Integer Smoke) {
		setAttrVal("Smoke", Smoke);
	}
	/**
	 * 心血管疾病得分
	 * @return Integer
	 */
	public Integer getCvd() {
		return ((Integer) getAttrVal("Cvd"));
	}	
	/**
	 * 心血管疾病得分
	 * @param Cvd
	 */
	public void setCvd(Integer Cvd) {
		setAttrVal("Cvd", Cvd);
	}
	/**
	 * 心房纤颤得分
	 * @return FDouble
	 */
	public FDouble getAf() {
		return ((FDouble) getAttrVal("Af"));
	}	
	/**
	 * 心房纤颤得分
	 * @param Af
	 */
	public void setAf(FDouble Af) {
		setAttrVal("Af", Af);
	}
	/**
	 * 左心室肥厚得分
	 * @return Integer
	 */
	public Integer getLvh() {
		return ((Integer) getAttrVal("Lvh"));
	}	
	/**
	 * 左心室肥厚得分
	 * @param Lvh
	 */
	public void setLvh(Integer Lvh) {
		setAttrVal("Lvh", Lvh);
	}
	/**
	 * 总分
	 * @return Integer
	 */
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}	
	/**
	 * 总分
	 * @param Total
	 */
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
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
	 * 增加风险_一般人群
	 * @return FDouble
	 */
	public FDouble getHigher_gen() {
		return ((FDouble) getAttrVal("Higher_gen"));
	}	
	/**
	 * 增加风险_一般人群
	 * @param Higher_gen
	 */
	public void setHigher_gen(FDouble Higher_gen) {
		setAttrVal("Higher_gen", Higher_gen);
	}
	/**
	 * 增加风险_低危人群
	 * @return FDouble
	 */
	public FDouble getHigher_lowrisk() {
		return ((FDouble) getAttrVal("Higher_lowrisk"));
	}	
	/**
	 * 增加风险_低危人群
	 * @param Higher_lowrisk
	 */
	public void setHigher_lowrisk(FDouble Higher_lowrisk) {
		setAttrVal("Higher_lowrisk", Higher_lowrisk);
	}
	/**
	 * 增加风险倍数_一般人群
	 * @return FDouble
	 */
	public FDouble getTimes_gen() {
		return ((FDouble) getAttrVal("Times_gen"));
	}	
	/**
	 * 增加风险倍数_一般人群
	 * @param Times_gen
	 */
	public void setTimes_gen(FDouble Times_gen) {
		setAttrVal("Times_gen", Times_gen);
	}
	/**
	 * 增加风险倍数_低危人群
	 * @return FDouble
	 */
	public FDouble getTimes_lowrisk() {
		return ((FDouble) getAttrVal("Times_lowrisk"));
	}	
	/**
	 * 增加风险倍数_低危人群
	 * @param Times_lowrisk
	 */
	public void setTimes_lowrisk(FDouble Times_lowrisk) {
		setAttrVal("Times_lowrisk", Times_lowrisk);
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
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
		return "Id_perststroke";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_perststroke";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstStrokeDODesc.class);
	}
	
}