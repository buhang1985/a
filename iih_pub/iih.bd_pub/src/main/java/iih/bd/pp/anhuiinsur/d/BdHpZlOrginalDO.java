package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.anhuiinsur.d.desc.BdHpZlOrginalDODesc;
import java.math.BigDecimal;

/**
 * 安徽医保诊疗目录 DO数据 
 * 
 */
public class BdHpZlOrginalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保计划服务诊疗原始主键
	public static final String ID_HPZLORGINAL= "Id_hpzlorginal";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//自付类别
	public static final String PAY_SELF_TP= "Pay_self_tp";
	//是否需要审批标志
	public static final String STR_APPROVE= "Str_approve";
	//是否二次报销
	public static final String STR_TWO_INSURPAY= "Str_two_insurpay";
	//自理部分进入统筹标志
	public static final String STR_ADD_INSUR= "Str_add_insur";
	//自理部分进入救助医疗标志
	public static final String STR_ADD_INSUR_SAL= "Str_add_insur_sal";
	//特检特制标志
	public static final String STR_SPECIAL_ITM= "Str_special_itm";
	//产地
	public static final String ORIGIN_PLACE= "Origin_place";
	//先付限价
	public static final String AMT_PREPAY_MAX= "Amt_prepay_max";
	//国产限价
	public static final String DOMESTIC_PRI_MAX= "Domestic_pri_max";
	//医院帮定标志
	public static final String STR_HOSPITAL_HELP= "Str_hospital_help";
	//定点医疗机构编号
	public static final String HOSPITAL_CODE= "Hospital_code";
	//单位
	public static final String UNIT= "Unit";
	//生产厂家
	public static final String FIRM_NAME= "Firm_name";
	//经办人
	public static final String ID_EMP_HANDLE= "Id_emp_handle";
	//经办日期
	public static final String DT_HANDLE= "Dt_handle";
	//有效标志
	public static final String STR_EFFECTIVE= "Str_effective";
	//拼音码
	public static final String PY_CODE= "Py_code";
	//五笔码
	public static final String WB_CODE= "Wb_code";
	//自定义码
	public static final String ZDY_CODE= "Zdy_code";
	//国家基本药品目录标志
	public static final String STR_PRC_DRUGLIST= "Str_prc_druglist";
	//国家基本药品目录基层卫生机构用药标志
	public static final String STR_PRC_B_DRUGLIST= "Str_prc_b_druglist";
	//居民使用标志
	public static final String STR_RESIDENT_USE= "Str_resident_use";
	//项目编码
	public static final String CODE= "Code";
	//项目名称
	public static final String NAME= "Name";
	//费用类别编码
	public static final String CODE_CA= "Code_ca";
	//费用类别名称
	public static final String NAME_CA= "Name_ca";
	//收费项目等级
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//单价支付上限
	public static final String PRI_MAX= "Pri_max";
	//离休二乙最高限价
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	//备注
	public static final String NOTE= "Note";
	//限制报销条件
	public static final String DES= "Des";
	//开始时间
	public static final String DT_B= "Dt_b";
	//结束时间
	public static final String DT_E= "Dt_e";
	//普通门诊自付比例
	public static final String RATE_SELF_OEP= "Rate_self_oep";
	//住院自付比例
	public static final String RATE_SELF_IP= "Rate_self_ip";
	//离休自付比例
	public static final String RATE_RETIRE= "Rate_retire";
	//工伤自付比例
	public static final String RATE_INJURY= "Rate_injury";
	//生育自付比例
	public static final String RATE_BIRTH= "Rate_birth";
	//二乙自付比例
	public static final String RATE_EY= "Rate_ey";
	//单位自付比例
	public static final String RATE_UNIT= "Rate_unit";
	//家属子女学生自付比例
	public static final String RATE_FAMILY= "Rate_family";
	//进口差价自付比例
	public static final String RATE_IMPORT_DIFF= "Rate_import_diff";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//序号
	public static final String ORDERNO= "Orderno";
	//定点医疗机构非药品项目编号
	public static final String UNDRUGNO_DMI= "Undrugno_dmi";
	//二乙价格
	public static final String PRI_EY= "Pri_ey";
	//市级最高价格
	public static final String PRI_MAX_CITY= "Pri_max_city";
	//县级最高价格
	public static final String PRI_MAX_COUNTY= "Pri_max_county";
	//县级以下价格
	public static final String PRI_BELOWCOUNY= "Pri_belowcouny";
	//离休价格
	public static final String PRI_RETIRE= "Pri_retire";
	//居民自付比例
	public static final String RATE_RESI= "Rate_resi";
	//军休门诊自付比例
	public static final String RATE_ARMY_OEP= "Rate_army_oep";
	//军休住院自付比例
	public static final String RATE_ARMY_IP= "Rate_army_ip";
	//工伤使用标志
	public static final String FG_INJURY= "Fg_injury";
	//生育使用标志
	public static final String FG_BIRTH= "Fg_birth";
	//基本医疗使用标志
	public static final String FG_BASEMEDIC= "Fg_basemedic";
	//医院等级
	public static final String HOSPITAL_RANK= "Hospital_rank";
	//自付比例开始日期
	public static final String DT_SELF_B= "Dt_self_b";
	//自付比例结束日期
	public static final String DT_SELF_E= "Dt_self_e";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保计划服务诊疗原始主键
	 * @return String
	 */
	public String getId_hpzlorginal() {
		return ((String) getAttrVal("Id_hpzlorginal"));
	}	
	/**
	 * 医保计划服务诊疗原始主键
	 * @param Id_hpzlorginal
	 */
	public void setId_hpzlorginal(String Id_hpzlorginal) {
		setAttrVal("Id_hpzlorginal", Id_hpzlorginal);
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
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 自付类别
	 * @return String
	 */
	public String getPay_self_tp() {
		return ((String) getAttrVal("Pay_self_tp"));
	}	
	/**
	 * 自付类别
	 * @param Pay_self_tp
	 */
	public void setPay_self_tp(String Pay_self_tp) {
		setAttrVal("Pay_self_tp", Pay_self_tp);
	}
	/**
	 * 是否需要审批标志
	 * @return String
	 */
	public String getStr_approve() {
		return ((String) getAttrVal("Str_approve"));
	}	
	/**
	 * 是否需要审批标志
	 * @param Str_approve
	 */
	public void setStr_approve(String Str_approve) {
		setAttrVal("Str_approve", Str_approve);
	}
	/**
	 * 是否二次报销
	 * @return String
	 */
	public String getStr_two_insurpay() {
		return ((String) getAttrVal("Str_two_insurpay"));
	}	
	/**
	 * 是否二次报销
	 * @param Str_two_insurpay
	 */
	public void setStr_two_insurpay(String Str_two_insurpay) {
		setAttrVal("Str_two_insurpay", Str_two_insurpay);
	}
	/**
	 * 自理部分进入统筹标志
	 * @return String
	 */
	public String getStr_add_insur() {
		return ((String) getAttrVal("Str_add_insur"));
	}	
	/**
	 * 自理部分进入统筹标志
	 * @param Str_add_insur
	 */
	public void setStr_add_insur(String Str_add_insur) {
		setAttrVal("Str_add_insur", Str_add_insur);
	}
	/**
	 * 自理部分进入救助医疗标志
	 * @return String
	 */
	public String getStr_add_insur_sal() {
		return ((String) getAttrVal("Str_add_insur_sal"));
	}	
	/**
	 * 自理部分进入救助医疗标志
	 * @param Str_add_insur_sal
	 */
	public void setStr_add_insur_sal(String Str_add_insur_sal) {
		setAttrVal("Str_add_insur_sal", Str_add_insur_sal);
	}
	/**
	 * 特检特制标志
	 * @return String
	 */
	public String getStr_special_itm() {
		return ((String) getAttrVal("Str_special_itm"));
	}	
	/**
	 * 特检特制标志
	 * @param Str_special_itm
	 */
	public void setStr_special_itm(String Str_special_itm) {
		setAttrVal("Str_special_itm", Str_special_itm);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getOrigin_place() {
		return ((String) getAttrVal("Origin_place"));
	}	
	/**
	 * 产地
	 * @param Origin_place
	 */
	public void setOrigin_place(String Origin_place) {
		setAttrVal("Origin_place", Origin_place);
	}
	/**
	 * 先付限价
	 * @return FDouble
	 */
	public FDouble getAmt_prepay_max() {
		return ((FDouble) getAttrVal("Amt_prepay_max"));
	}	
	/**
	 * 先付限价
	 * @param Amt_prepay_max
	 */
	public void setAmt_prepay_max(FDouble Amt_prepay_max) {
		setAttrVal("Amt_prepay_max", Amt_prepay_max);
	}
	/**
	 * 国产限价
	 * @return FDouble
	 */
	public FDouble getDomestic_pri_max() {
		return ((FDouble) getAttrVal("Domestic_pri_max"));
	}	
	/**
	 * 国产限价
	 * @param Domestic_pri_max
	 */
	public void setDomestic_pri_max(FDouble Domestic_pri_max) {
		setAttrVal("Domestic_pri_max", Domestic_pri_max);
	}
	/**
	 * 医院帮定标志
	 * @return String
	 */
	public String getStr_hospital_help() {
		return ((String) getAttrVal("Str_hospital_help"));
	}	
	/**
	 * 医院帮定标志
	 * @param Str_hospital_help
	 */
	public void setStr_hospital_help(String Str_hospital_help) {
		setAttrVal("Str_hospital_help", Str_hospital_help);
	}
	/**
	 * 定点医疗机构编号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 定点医疗机构编号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getFirm_name() {
		return ((String) getAttrVal("Firm_name"));
	}	
	/**
	 * 生产厂家
	 * @param Firm_name
	 */
	public void setFirm_name(String Firm_name) {
		setAttrVal("Firm_name", Firm_name);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getId_emp_handle() {
		return ((String) getAttrVal("Id_emp_handle"));
	}	
	/**
	 * 经办人
	 * @param Id_emp_handle
	 */
	public void setId_emp_handle(String Id_emp_handle) {
		setAttrVal("Id_emp_handle", Id_emp_handle);
	}
	/**
	 * 经办日期
	 * @return FDateTime
	 */
	public FDateTime getDt_handle() {
		return ((FDateTime) getAttrVal("Dt_handle"));
	}	
	/**
	 * 经办日期
	 * @param Dt_handle
	 */
	public void setDt_handle(FDateTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	/**
	 * 有效标志
	 * @return String
	 */
	public String getStr_effective() {
		return ((String) getAttrVal("Str_effective"));
	}	
	/**
	 * 有效标志
	 * @param Str_effective
	 */
	public void setStr_effective(String Str_effective) {
		setAttrVal("Str_effective", Str_effective);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}	
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}	
	/**
	 * 五笔码
	 * @param Wb_code
	 */
	public void setWb_code(String Wb_code) {
		setAttrVal("Wb_code", Wb_code);
	}
	/**
	 * 自定义码
	 * @return String
	 */
	public String getZdy_code() {
		return ((String) getAttrVal("Zdy_code"));
	}	
	/**
	 * 自定义码
	 * @param Zdy_code
	 */
	public void setZdy_code(String Zdy_code) {
		setAttrVal("Zdy_code", Zdy_code);
	}
	/**
	 * 国家基本药品目录标志
	 * @return String
	 */
	public String getStr_prc_druglist() {
		return ((String) getAttrVal("Str_prc_druglist"));
	}	
	/**
	 * 国家基本药品目录标志
	 * @param Str_prc_druglist
	 */
	public void setStr_prc_druglist(String Str_prc_druglist) {
		setAttrVal("Str_prc_druglist", Str_prc_druglist);
	}
	/**
	 * 国家基本药品目录基层卫生机构用药标志
	 * @return String
	 */
	public String getStr_prc_b_druglist() {
		return ((String) getAttrVal("Str_prc_b_druglist"));
	}	
	/**
	 * 国家基本药品目录基层卫生机构用药标志
	 * @param Str_prc_b_druglist
	 */
	public void setStr_prc_b_druglist(String Str_prc_b_druglist) {
		setAttrVal("Str_prc_b_druglist", Str_prc_b_druglist);
	}
	/**
	 * 居民使用标志
	 * @return String
	 */
	public String getStr_resident_use() {
		return ((String) getAttrVal("Str_resident_use"));
	}	
	/**
	 * 居民使用标志
	 * @param Str_resident_use
	 */
	public void setStr_resident_use(String Str_resident_use) {
		setAttrVal("Str_resident_use", Str_resident_use);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 费用类别编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 费用类别编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 费用类别名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	/**
	 * 费用类别名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 收费项目等级
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 收费项目等级
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 单价支付上限
	 * @return FDouble
	 */
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	/**
	 * 单价支付上限
	 * @param Pri_max
	 */
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	/**
	 * 离休二乙最高限价
	 * @return FDouble
	 */
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	/**
	 * 离休二乙最高限价
	 * @param Retire_ey_pri_max
	 */
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 限制报销条件
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 普通门诊自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_oep() {
		return ((FDouble) getAttrVal("Rate_self_oep"));
	}	
	/**
	 * 普通门诊自付比例
	 * @param Rate_self_oep
	 */
	public void setRate_self_oep(FDouble Rate_self_oep) {
		setAttrVal("Rate_self_oep", Rate_self_oep);
	}
	/**
	 * 住院自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_ip() {
		return ((FDouble) getAttrVal("Rate_self_ip"));
	}	
	/**
	 * 住院自付比例
	 * @param Rate_self_ip
	 */
	public void setRate_self_ip(FDouble Rate_self_ip) {
		setAttrVal("Rate_self_ip", Rate_self_ip);
	}
	/**
	 * 离休自付比例
	 * @return FDouble
	 */
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}	
	/**
	 * 离休自付比例
	 * @param Rate_retire
	 */
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	/**
	 * 工伤自付比例
	 * @return FDouble
	 */
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}	
	/**
	 * 工伤自付比例
	 * @param Rate_injury
	 */
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	/**
	 * 生育自付比例
	 * @return FDouble
	 */
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}	
	/**
	 * 生育自付比例
	 * @param Rate_birth
	 */
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	/**
	 * 二乙自付比例
	 * @return FDouble
	 */
	public FDouble getRate_ey() {
		return ((FDouble) getAttrVal("Rate_ey"));
	}	
	/**
	 * 二乙自付比例
	 * @param Rate_ey
	 */
	public void setRate_ey(FDouble Rate_ey) {
		setAttrVal("Rate_ey", Rate_ey);
	}
	/**
	 * 单位自付比例
	 * @return FDouble
	 */
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}	
	/**
	 * 单位自付比例
	 * @param Rate_unit
	 */
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	/**
	 * 家属子女学生自付比例
	 * @return FDouble
	 */
	public FDouble getRate_family() {
		return ((FDouble) getAttrVal("Rate_family"));
	}	
	/**
	 * 家属子女学生自付比例
	 * @param Rate_family
	 */
	public void setRate_family(FDouble Rate_family) {
		setAttrVal("Rate_family", Rate_family);
	}
	/**
	 * 进口差价自付比例
	 * @return FDouble
	 */
	public FDouble getRate_import_diff() {
		return ((FDouble) getAttrVal("Rate_import_diff"));
	}	
	/**
	 * 进口差价自付比例
	 * @param Rate_import_diff
	 */
	public void setRate_import_diff(FDouble Rate_import_diff) {
		setAttrVal("Rate_import_diff", Rate_import_diff);
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
	 * 序号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	/**
	 * 序号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 定点医疗机构非药品项目编号
	 * @return String
	 */
	public String getUndrugno_dmi() {
		return ((String) getAttrVal("Undrugno_dmi"));
	}	
	/**
	 * 定点医疗机构非药品项目编号
	 * @param Undrugno_dmi
	 */
	public void setUndrugno_dmi(String Undrugno_dmi) {
		setAttrVal("Undrugno_dmi", Undrugno_dmi);
	}
	/**
	 * 二乙价格
	 * @return String
	 */
	public String getPri_ey() {
		return ((String) getAttrVal("Pri_ey"));
	}	
	/**
	 * 二乙价格
	 * @param Pri_ey
	 */
	public void setPri_ey(String Pri_ey) {
		setAttrVal("Pri_ey", Pri_ey);
	}
	/**
	 * 市级最高价格
	 * @return String
	 */
	public String getPri_max_city() {
		return ((String) getAttrVal("Pri_max_city"));
	}	
	/**
	 * 市级最高价格
	 * @param Pri_max_city
	 */
	public void setPri_max_city(String Pri_max_city) {
		setAttrVal("Pri_max_city", Pri_max_city);
	}
	/**
	 * 县级最高价格
	 * @return String
	 */
	public String getPri_max_county() {
		return ((String) getAttrVal("Pri_max_county"));
	}	
	/**
	 * 县级最高价格
	 * @param Pri_max_county
	 */
	public void setPri_max_county(String Pri_max_county) {
		setAttrVal("Pri_max_county", Pri_max_county);
	}
	/**
	 * 县级以下价格
	 * @return String
	 */
	public String getPri_belowcouny() {
		return ((String) getAttrVal("Pri_belowcouny"));
	}	
	/**
	 * 县级以下价格
	 * @param Pri_belowcouny
	 */
	public void setPri_belowcouny(String Pri_belowcouny) {
		setAttrVal("Pri_belowcouny", Pri_belowcouny);
	}
	/**
	 * 离休价格
	 * @return String
	 */
	public String getPri_retire() {
		return ((String) getAttrVal("Pri_retire"));
	}	
	/**
	 * 离休价格
	 * @param Pri_retire
	 */
	public void setPri_retire(String Pri_retire) {
		setAttrVal("Pri_retire", Pri_retire);
	}
	/**
	 * 居民自付比例
	 * @return FDouble
	 */
	public FDouble getRate_resi() {
		return ((FDouble) getAttrVal("Rate_resi"));
	}	
	/**
	 * 居民自付比例
	 * @param Rate_resi
	 */
	public void setRate_resi(FDouble Rate_resi) {
		setAttrVal("Rate_resi", Rate_resi);
	}
	/**
	 * 军休门诊自付比例
	 * @return FDouble
	 */
	public FDouble getRate_army_oep() {
		return ((FDouble) getAttrVal("Rate_army_oep"));
	}	
	/**
	 * 军休门诊自付比例
	 * @param Rate_army_oep
	 */
	public void setRate_army_oep(FDouble Rate_army_oep) {
		setAttrVal("Rate_army_oep", Rate_army_oep);
	}
	/**
	 * 军休住院自付比例
	 * @return FDouble
	 */
	public FDouble getRate_army_ip() {
		return ((FDouble) getAttrVal("Rate_army_ip"));
	}	
	/**
	 * 军休住院自付比例
	 * @param Rate_army_ip
	 */
	public void setRate_army_ip(FDouble Rate_army_ip) {
		setAttrVal("Rate_army_ip", Rate_army_ip);
	}
	/**
	 * 工伤使用标志
	 * @return String
	 */
	public String getFg_injury() {
		return ((String) getAttrVal("Fg_injury"));
	}	
	/**
	 * 工伤使用标志
	 * @param Fg_injury
	 */
	public void setFg_injury(String Fg_injury) {
		setAttrVal("Fg_injury", Fg_injury);
	}
	/**
	 * 生育使用标志
	 * @return String
	 */
	public String getFg_birth() {
		return ((String) getAttrVal("Fg_birth"));
	}	
	/**
	 * 生育使用标志
	 * @param Fg_birth
	 */
	public void setFg_birth(String Fg_birth) {
		setAttrVal("Fg_birth", Fg_birth);
	}
	/**
	 * 基本医疗使用标志
	 * @return String
	 */
	public String getFg_basemedic() {
		return ((String) getAttrVal("Fg_basemedic"));
	}	
	/**
	 * 基本医疗使用标志
	 * @param Fg_basemedic
	 */
	public void setFg_basemedic(String Fg_basemedic) {
		setAttrVal("Fg_basemedic", Fg_basemedic);
	}
	/**
	 * 医院等级
	 * @return String
	 */
	public String getHospital_rank() {
		return ((String) getAttrVal("Hospital_rank"));
	}	
	/**
	 * 医院等级
	 * @param Hospital_rank
	 */
	public void setHospital_rank(String Hospital_rank) {
		setAttrVal("Hospital_rank", Hospital_rank);
	}
	/**
	 * 自付比例开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_self_b() {
		return ((FDateTime) getAttrVal("Dt_self_b"));
	}	
	/**
	 * 自付比例开始日期
	 * @param Dt_self_b
	 */
	public void setDt_self_b(FDateTime Dt_self_b) {
		setAttrVal("Dt_self_b", Dt_self_b);
	}
	/**
	 * 自付比例结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_self_e() {
		return ((FDateTime) getAttrVal("Dt_self_e"));
	}	
	/**
	 * 自付比例结束日期
	 * @param Dt_self_e
	 */
	public void setDt_self_e(FDateTime Dt_self_e) {
		setAttrVal("Dt_self_e", Dt_self_e);
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
		return "Id_hpzlorginal";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_ZL_ORGINAL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdHpZlOrginalDODesc.class);
	}
	
}