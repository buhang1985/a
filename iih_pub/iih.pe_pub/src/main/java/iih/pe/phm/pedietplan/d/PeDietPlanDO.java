package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pedietplan.d.desc.PeDietPlanDODesc;
import java.math.BigDecimal;

/**
 * 体检饮食计划 DO数据 
 * 
 */
public class PeDietPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检饮食计划主键标识
	public static final String ID_PEDIETPLAN= "Id_pedietplan";
	//体检饮食计划父ID
	public static final String ID_PEDIETPLAN_PAR= "Id_pedietplan_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//健康服务预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//劳动强度
	public static final String LABOURCA= "Labourca";
	//标准体重
	public static final String STDWEGHT= "Stdweght";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//能量
	public static final String ENERGY= "Energy";
	//蛋白质
	public static final String PROTEIN= "Protein";
	//脂肪
	public static final String FAT= "Fat";
	//碳水化合物
	public static final String CARBOHYDRATE= "Carbohydrate";
	//主食
	public static final String STAPLEFOOD= "Staplefood";
	//奶类
	public static final String MILK= "Milk";
	//蛋类
	public static final String EGG= "Egg";
	//肉类
	public static final String MEAT= "Meat";
	//豆制品
	public static final String BEANPRODUCTS= "Beanproducts";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//婚姻状况编码
	public static final String SD_MARRY= "Sd_marry";
	//移动电话
	public static final String MOB= "Mob";
	//家庭电话
	public static final String TEL= "Tel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检饮食计划主键标识
	 * @return String
	 */
	public String getId_pedietplan() {
		return ((String) getAttrVal("Id_pedietplan"));
	}	
	/**
	 * 体检饮食计划主键标识
	 * @param Id_pedietplan
	 */
	public void setId_pedietplan(String Id_pedietplan) {
		setAttrVal("Id_pedietplan", Id_pedietplan);
	}
	/**
	 * 体检饮食计划父ID
	 * @return String
	 */
	public String getId_pedietplan_par() {
		return ((String) getAttrVal("Id_pedietplan_par"));
	}	
	/**
	 * 体检饮食计划父ID
	 * @param Id_pedietplan_par
	 */
	public void setId_pedietplan_par(String Id_pedietplan_par) {
		setAttrVal("Id_pedietplan_par", Id_pedietplan_par);
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
	 * 健康服务预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康服务预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 劳动强度
	 * @return Integer
	 */
	public Integer getLabourca() {
		return ((Integer) getAttrVal("Labourca"));
	}	
	/**
	 * 劳动强度
	 * @param Labourca
	 */
	public void setLabourca(Integer Labourca) {
		setAttrVal("Labourca", Labourca);
	}
	/**
	 * 标准体重
	 * @return FDouble
	 */
	public FDouble getStdweght() {
		return ((FDouble) getAttrVal("Stdweght"));
	}	
	/**
	 * 标准体重
	 * @param Stdweght
	 */
	public void setStdweght(FDouble Stdweght) {
		setAttrVal("Stdweght", Stdweght);
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
	 * 能量
	 * @return FDouble
	 */
	public FDouble getEnergy() {
		return ((FDouble) getAttrVal("Energy"));
	}	
	/**
	 * 能量
	 * @param Energy
	 */
	public void setEnergy(FDouble Energy) {
		setAttrVal("Energy", Energy);
	}
	/**
	 * 蛋白质
	 * @return FDouble
	 */
	public FDouble getProtein() {
		return ((FDouble) getAttrVal("Protein"));
	}	
	/**
	 * 蛋白质
	 * @param Protein
	 */
	public void setProtein(FDouble Protein) {
		setAttrVal("Protein", Protein);
	}
	/**
	 * 脂肪
	 * @return FDouble
	 */
	public FDouble getFat() {
		return ((FDouble) getAttrVal("Fat"));
	}	
	/**
	 * 脂肪
	 * @param Fat
	 */
	public void setFat(FDouble Fat) {
		setAttrVal("Fat", Fat);
	}
	/**
	 * 碳水化合物
	 * @return FDouble
	 */
	public FDouble getCarbohydrate() {
		return ((FDouble) getAttrVal("Carbohydrate"));
	}	
	/**
	 * 碳水化合物
	 * @param Carbohydrate
	 */
	public void setCarbohydrate(FDouble Carbohydrate) {
		setAttrVal("Carbohydrate", Carbohydrate);
	}
	/**
	 * 主食
	 * @return FDouble
	 */
	public FDouble getStaplefood() {
		return ((FDouble) getAttrVal("Staplefood"));
	}	
	/**
	 * 主食
	 * @param Staplefood
	 */
	public void setStaplefood(FDouble Staplefood) {
		setAttrVal("Staplefood", Staplefood);
	}
	/**
	 * 奶类
	 * @return FDouble
	 */
	public FDouble getMilk() {
		return ((FDouble) getAttrVal("Milk"));
	}	
	/**
	 * 奶类
	 * @param Milk
	 */
	public void setMilk(FDouble Milk) {
		setAttrVal("Milk", Milk);
	}
	/**
	 * 蛋类
	 * @return FDouble
	 */
	public FDouble getEgg() {
		return ((FDouble) getAttrVal("Egg"));
	}	
	/**
	 * 蛋类
	 * @param Egg
	 */
	public void setEgg(FDouble Egg) {
		setAttrVal("Egg", Egg);
	}
	/**
	 * 肉类
	 * @return FDouble
	 */
	public FDouble getMeat() {
		return ((FDouble) getAttrVal("Meat"));
	}	
	/**
	 * 肉类
	 * @param Meat
	 */
	public void setMeat(FDouble Meat) {
		setAttrVal("Meat", Meat);
	}
	/**
	 * 豆制品
	 * @return FDouble
	 */
	public FDouble getBeanproducts() {
		return ((FDouble) getAttrVal("Beanproducts"));
	}	
	/**
	 * 豆制品
	 * @param Beanproducts
	 */
	public void setBeanproducts(FDouble Beanproducts) {
		setAttrVal("Beanproducts", Beanproducts);
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
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 性别编码
	 * @return Integer
	 */
	public Integer getSd_sex_psn() {
		return ((Integer) getAttrVal("Sd_sex_psn"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_psn
	 */
	public void setSd_sex_psn(Integer Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_psn() {
		return ((Integer) getAttrVal("Age_psn"));
	}	
	/**
	 * 年龄
	 * @param Age_psn
	 */
	public void setAge_psn(Integer Age_psn) {
		setAttrVal("Age_psn", Age_psn);
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
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 家庭电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
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
		return "Id_pedietplan";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pedietplan";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDietPlanDODesc.class);
	}
	
}