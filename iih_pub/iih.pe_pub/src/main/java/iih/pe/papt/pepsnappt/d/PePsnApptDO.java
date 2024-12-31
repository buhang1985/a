package iih.pe.papt.pepsnappt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pepsnappt.d.desc.PePsnApptDODesc;
import java.math.BigDecimal;

/**
 * 体检个人预约单 DO数据 
 * 
 */
public class PePsnApptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检预约单主键标识
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检套餐ID
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	//就诊流水号
	public static final String ID_EN= "Id_en";
	//体检次数
	public static final String PE_TIMES= "Pe_times";
	//会员卡ID
	public static final String ID_PEPSNCARD= "Id_pepsncard";
	//预约会员卡
	public static final String NO_CARD= "No_card";
	//个人单位标识
	public static final String FG_PETP= "Fg_petp";
	//原预约单ID
	public static final String ID_PEPSNAPPT_FORMER= "Id_pepsnappt_former";
	//预约类型
	public static final String APTTP= "Apttp";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检团体ID
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	//团体预约ID
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//团体预约分组ID
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//家属标识
	public static final String FG_FAMILY= "Fg_family";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//加项收费标识
	public static final String FG_ADDCHARGE= "Fg_addcharge";
	//预约时间
	public static final String DT_APPT= "Dt_appt";
	//预约时间段
	public static final String ID_PEAPPTTLADDER= "Id_peappttladder";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//登记日期
	public static final String DT_REG= "Dt_reg";
	//登记类型编码
	public static final String SD_REGTP= "Sd_regtp";
	//登记类型ID
	public static final String ID_REGTP= "Id_regtp";
	//体检状态
	public static final String PESTATUS= "Pestatus";
	//后付费体检标识
	public static final String FG_NOPAY= "Fg_nopay";
	//VIP标识
	public static final String FG_VIP= "Fg_vip";
	//用餐荤素标识
	public static final String FG_MEAL= "Fg_meal";
	//清真饮食
	public static final String FG_MUSLIM= "Fg_muslim";
	//收费标识
	public static final String FG_PAID= "Fg_paid";
	//体检登记备注
	public static final String RMK_PE= "Rmk_pe";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//体检总费用
	public static final String CHARGE_PE= "Charge_pe";
	//整单折扣
	public static final String DIS_TOTAL= "Dis_total";
	//体检费倍数
	public static final String BASEPRITIMES= "Basepritimes";
	//折后实收费用
	public static final String DIS_CHARGE= "Dis_charge";
	//套餐价格
	public static final String CHARGE_PE_SET= "Charge_pe_set";
	//加项价格
	public static final String CHARGE_PE_ADD= "Charge_pe_add";
	//减项价格
	public static final String CHARGE_PE_SUB= "Charge_pe_sub";
	//证件类型
	public static final String IDTP= "Idtp";
	//婚姻状况
	public static final String MARRIAGE= "Marriage";
	//性别
	public static final String SEX= "Sex";
	//存在标识
	public static final String FG_EXIST= "Fg_exist";
	//登记员
	public static final String ID_REGISTRAR= "Id_registrar";
	//实际体检标识
	public static final String FG_CHECK= "Fg_check";
	//首次体检日期
	public static final String DT_CHECKED= "Dt_checked";
	//部门
	public static final String DEP= "Dep";
	//导引单打印标识
	public static final String FG_GUIDERPRINT= "Fg_guiderprint";
	//条码打印标识
	public static final String FG_BARCODEPRINT= "Fg_barcodeprint";
	//客户编码
	public static final String CODE_PAT= "Code_pat";
	//就诊次数
	public static final String TIMES= "Times";
	//体检客户分组ID
	public static final String ID_PEMULTIGROUP= "Id_pemultigroup";
	//体检客户分组编码
	public static final String SD_PEMULTIGROUP= "Sd_pemultigroup";
	//导引单收回
	public static final String FG_GUIDERBACK= "Fg_guiderback";
	//导引单收回时间
	public static final String DT_GUIDERBACK= "Dt_guiderback";
	//工种
	public static final String PROFESSION= "Profession";
	//行业
	public static final String INDUSTRY= "Industry";
	//单位名称
	public static final String COMPANY= "Company";
	//岗位状态
	public static final String ST_JOB= "St_job";
	//在岗时间
	public static final String JOB_TIME= "Job_time";
	//工龄
	public static final String WORKINGAGE= "Workingage";
	//更新次数
	public static final String CT_PRN= "Ct_prn";
	//体检身份类型
	public static final String IDENTITYTP= "Identitytp";
	//门诊收费标识
	public static final String FG_BL_PAY= "Fg_bl_pay";
	//门诊收费时间
	public static final String DT_BL_PAY= "Dt_bl_pay";
	//自付标识
	public static final String FG_PAYSELF= "Fg_payself";
	//证件号码
	public static final String IDCODE= "Idcode";
	//移动电话
	public static final String MOB= "Mob";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//客户编码
	public static final String CODE= "Code";
	//门诊就诊ID
	public static final String ID_PAT= "Id_pat";
	//姓名
	public static final String NAME= "Name";
	//拼音
	public static final String PYCODE= "Pycode";
	//编码
	public static final String CODE_STEP= "Code_step";
	//名称
	public static final String NAME_STEP= "Name_step";
	//登记类型编码
	public static final String CODE_REGTP= "Code_regtp";
	//登记类型
	public static final String NAME_REGTP= "Name_regtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检预约单主键标识
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单主键标识
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
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
	 * 体检套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	/**
	 * 体检套餐ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊流水号
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getPe_times() {
		return ((Integer) getAttrVal("Pe_times"));
	}	
	/**
	 * 体检次数
	 * @param Pe_times
	 */
	public void setPe_times(Integer Pe_times) {
		setAttrVal("Pe_times", Pe_times);
	}
	/**
	 * 会员卡ID
	 * @return String
	 */
	public String getId_pepsncard() {
		return ((String) getAttrVal("Id_pepsncard"));
	}	
	/**
	 * 会员卡ID
	 * @param Id_pepsncard
	 */
	public void setId_pepsncard(String Id_pepsncard) {
		setAttrVal("Id_pepsncard", Id_pepsncard);
	}
	/**
	 * 预约会员卡
	 * @return String
	 */
	public String getNo_card() {
		return ((String) getAttrVal("No_card"));
	}	
	/**
	 * 预约会员卡
	 * @param No_card
	 */
	public void setNo_card(String No_card) {
		setAttrVal("No_card", No_card);
	}
	/**
	 * 个人单位标识
	 * @return FBoolean
	 */
	public FBoolean getFg_petp() {
		return ((FBoolean) getAttrVal("Fg_petp"));
	}	
	/**
	 * 个人单位标识
	 * @param Fg_petp
	 */
	public void setFg_petp(FBoolean Fg_petp) {
		setAttrVal("Fg_petp", Fg_petp);
	}
	/**
	 * 原预约单ID
	 * @return String
	 */
	public String getId_pepsnappt_former() {
		return ((String) getAttrVal("Id_pepsnappt_former"));
	}	
	/**
	 * 原预约单ID
	 * @param Id_pepsnappt_former
	 */
	public void setId_pepsnappt_former(String Id_pepsnappt_former) {
		setAttrVal("Id_pepsnappt_former", Id_pepsnappt_former);
	}
	/**
	 * 预约类型
	 * @return Integer
	 */
	public Integer getApttp() {
		return ((Integer) getAttrVal("Apttp"));
	}	
	/**
	 * 预约类型
	 * @param Apttp
	 */
	public void setApttp(Integer Apttp) {
		setAttrVal("Apttp", Apttp);
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
	 * 体检团体ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	/**
	 * 体检团体ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	/**
	 * 团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
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
	 * 团体预约分组ID
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}	
	/**
	 * 团体预约分组ID
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
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
	 * 家属标识
	 * @return FBoolean
	 */
	public FBoolean getFg_family() {
		return ((FBoolean) getAttrVal("Fg_family"));
	}	
	/**
	 * 家属标识
	 * @param Fg_family
	 */
	public void setFg_family(FBoolean Fg_family) {
		setAttrVal("Fg_family", Fg_family);
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
	 * 加项收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_addcharge() {
		return ((FBoolean) getAttrVal("Fg_addcharge"));
	}	
	/**
	 * 加项收费标识
	 * @param Fg_addcharge
	 */
	public void setFg_addcharge(FBoolean Fg_addcharge) {
		setAttrVal("Fg_addcharge", Fg_addcharge);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约时间段
	 * @return String
	 */
	public String getId_peappttladder() {
		return ((String) getAttrVal("Id_peappttladder"));
	}	
	/**
	 * 预约时间段
	 * @param Id_peappttladder
	 */
	public void setId_peappttladder(String Id_peappttladder) {
		setAttrVal("Id_peappttladder", Id_peappttladder);
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
	 * 登记日期
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记日期
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 登记类型编码
	 * @return String
	 */
	public String getSd_regtp() {
		return ((String) getAttrVal("Sd_regtp"));
	}	
	/**
	 * 登记类型编码
	 * @param Sd_regtp
	 */
	public void setSd_regtp(String Sd_regtp) {
		setAttrVal("Sd_regtp", Sd_regtp);
	}
	/**
	 * 登记类型ID
	 * @return String
	 */
	public String getId_regtp() {
		return ((String) getAttrVal("Id_regtp"));
	}	
	/**
	 * 登记类型ID
	 * @param Id_regtp
	 */
	public void setId_regtp(String Id_regtp) {
		setAttrVal("Id_regtp", Id_regtp);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}	
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	/**
	 * 后付费体检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nopay() {
		return ((FBoolean) getAttrVal("Fg_nopay"));
	}	
	/**
	 * 后付费体检标识
	 * @param Fg_nopay
	 */
	public void setFg_nopay(FBoolean Fg_nopay) {
		setAttrVal("Fg_nopay", Fg_nopay);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 用餐荤素标识
	 * @return FBoolean
	 */
	public FBoolean getFg_meal() {
		return ((FBoolean) getAttrVal("Fg_meal"));
	}	
	/**
	 * 用餐荤素标识
	 * @param Fg_meal
	 */
	public void setFg_meal(FBoolean Fg_meal) {
		setAttrVal("Fg_meal", Fg_meal);
	}
	/**
	 * 清真饮食
	 * @return FBoolean
	 */
	public FBoolean getFg_muslim() {
		return ((FBoolean) getAttrVal("Fg_muslim"));
	}	
	/**
	 * 清真饮食
	 * @param Fg_muslim
	 */
	public void setFg_muslim(FBoolean Fg_muslim) {
		setAttrVal("Fg_muslim", Fg_muslim);
	}
	/**
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_paid() {
		return ((FBoolean) getAttrVal("Fg_paid"));
	}	
	/**
	 * 收费标识
	 * @param Fg_paid
	 */
	public void setFg_paid(FBoolean Fg_paid) {
		setAttrVal("Fg_paid", Fg_paid);
	}
	/**
	 * 体检登记备注
	 * @return String
	 */
	public String getRmk_pe() {
		return ((String) getAttrVal("Rmk_pe"));
	}	
	/**
	 * 体检登记备注
	 * @param Rmk_pe
	 */
	public void setRmk_pe(String Rmk_pe) {
		setAttrVal("Rmk_pe", Rmk_pe);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 体检总费用
	 * @return FDouble
	 */
	public FDouble getCharge_pe() {
		return ((FDouble) getAttrVal("Charge_pe"));
	}	
	/**
	 * 体检总费用
	 * @param Charge_pe
	 */
	public void setCharge_pe(FDouble Charge_pe) {
		setAttrVal("Charge_pe", Charge_pe);
	}
	/**
	 * 整单折扣
	 * @return FDouble
	 */
	public FDouble getDis_total() {
		return ((FDouble) getAttrVal("Dis_total"));
	}	
	/**
	 * 整单折扣
	 * @param Dis_total
	 */
	public void setDis_total(FDouble Dis_total) {
		setAttrVal("Dis_total", Dis_total);
	}
	/**
	 * 体检费倍数
	 * @return Integer
	 */
	public Integer getBasepritimes() {
		return ((Integer) getAttrVal("Basepritimes"));
	}	
	/**
	 * 体检费倍数
	 * @param Basepritimes
	 */
	public void setBasepritimes(Integer Basepritimes) {
		setAttrVal("Basepritimes", Basepritimes);
	}
	/**
	 * 折后实收费用
	 * @return FDouble
	 */
	public FDouble getDis_charge() {
		return ((FDouble) getAttrVal("Dis_charge"));
	}	
	/**
	 * 折后实收费用
	 * @param Dis_charge
	 */
	public void setDis_charge(FDouble Dis_charge) {
		setAttrVal("Dis_charge", Dis_charge);
	}
	/**
	 * 套餐价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_set() {
		return ((FDouble) getAttrVal("Charge_pe_set"));
	}	
	/**
	 * 套餐价格
	 * @param Charge_pe_set
	 */
	public void setCharge_pe_set(FDouble Charge_pe_set) {
		setAttrVal("Charge_pe_set", Charge_pe_set);
	}
	/**
	 * 加项价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_add() {
		return ((FDouble) getAttrVal("Charge_pe_add"));
	}	
	/**
	 * 加项价格
	 * @param Charge_pe_add
	 */
	public void setCharge_pe_add(FDouble Charge_pe_add) {
		setAttrVal("Charge_pe_add", Charge_pe_add);
	}
	/**
	 * 减项价格
	 * @return FDouble
	 */
	public FDouble getCharge_pe_sub() {
		return ((FDouble) getAttrVal("Charge_pe_sub"));
	}	
	/**
	 * 减项价格
	 * @param Charge_pe_sub
	 */
	public void setCharge_pe_sub(FDouble Charge_pe_sub) {
		setAttrVal("Charge_pe_sub", Charge_pe_sub);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getIdtp() {
		return ((String) getAttrVal("Idtp"));
	}	
	/**
	 * 证件类型
	 * @param Idtp
	 */
	public void setIdtp(String Idtp) {
		setAttrVal("Idtp", Idtp);
	}
	/**
	 * 婚姻状况
	 * @return Integer
	 */
	public Integer getMarriage() {
		return ((Integer) getAttrVal("Marriage"));
	}	
	/**
	 * 婚姻状况
	 * @param Marriage
	 */
	public void setMarriage(Integer Marriage) {
		setAttrVal("Marriage", Marriage);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSex() {
		return ((Integer) getAttrVal("Sex"));
	}	
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(Integer Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 存在标识
	 * @return FBoolean
	 */
	public FBoolean getFg_exist() {
		return ((FBoolean) getAttrVal("Fg_exist"));
	}	
	/**
	 * 存在标识
	 * @param Fg_exist
	 */
	public void setFg_exist(FBoolean Fg_exist) {
		setAttrVal("Fg_exist", Fg_exist);
	}
	/**
	 * 登记员
	 * @return String
	 */
	public String getId_registrar() {
		return ((String) getAttrVal("Id_registrar"));
	}	
	/**
	 * 登记员
	 * @param Id_registrar
	 */
	public void setId_registrar(String Id_registrar) {
		setAttrVal("Id_registrar", Id_registrar);
	}
	/**
	 * 实际体检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}	
	/**
	 * 实际体检标识
	 * @param Fg_check
	 */
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	/**
	 * 首次体检日期
	 * @return FDate
	 */
	public FDate getDt_checked() {
		return ((FDate) getAttrVal("Dt_checked"));
	}	
	/**
	 * 首次体检日期
	 * @param Dt_checked
	 */
	public void setDt_checked(FDate Dt_checked) {
		setAttrVal("Dt_checked", Dt_checked);
	}
	/**
	 * 部门
	 * @return String
	 */
	public String getDep() {
		return ((String) getAttrVal("Dep"));
	}	
	/**
	 * 部门
	 * @param Dep
	 */
	public void setDep(String Dep) {
		setAttrVal("Dep", Dep);
	}
	/**
	 * 导引单打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_guiderprint() {
		return ((FBoolean) getAttrVal("Fg_guiderprint"));
	}	
	/**
	 * 导引单打印标识
	 * @param Fg_guiderprint
	 */
	public void setFg_guiderprint(FBoolean Fg_guiderprint) {
		setAttrVal("Fg_guiderprint", Fg_guiderprint);
	}
	/**
	 * 条码打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_barcodeprint() {
		return ((FBoolean) getAttrVal("Fg_barcodeprint"));
	}	
	/**
	 * 条码打印标识
	 * @param Fg_barcodeprint
	 */
	public void setFg_barcodeprint(FBoolean Fg_barcodeprint) {
		setAttrVal("Fg_barcodeprint", Fg_barcodeprint);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 客户编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 体检客户分组ID
	 * @return String
	 */
	public String getId_pemultigroup() {
		return ((String) getAttrVal("Id_pemultigroup"));
	}	
	/**
	 * 体检客户分组ID
	 * @param Id_pemultigroup
	 */
	public void setId_pemultigroup(String Id_pemultigroup) {
		setAttrVal("Id_pemultigroup", Id_pemultigroup);
	}
	/**
	 * 体检客户分组编码
	 * @return String
	 */
	public String getSd_pemultigroup() {
		return ((String) getAttrVal("Sd_pemultigroup"));
	}	
	/**
	 * 体检客户分组编码
	 * @param Sd_pemultigroup
	 */
	public void setSd_pemultigroup(String Sd_pemultigroup) {
		setAttrVal("Sd_pemultigroup", Sd_pemultigroup);
	}
	/**
	 * 导引单收回
	 * @return FBoolean
	 */
	public FBoolean getFg_guiderback() {
		return ((FBoolean) getAttrVal("Fg_guiderback"));
	}	
	/**
	 * 导引单收回
	 * @param Fg_guiderback
	 */
	public void setFg_guiderback(FBoolean Fg_guiderback) {
		setAttrVal("Fg_guiderback", Fg_guiderback);
	}
	/**
	 * 导引单收回时间
	 * @return FDateTime
	 */
	public FDateTime getDt_guiderback() {
		return ((FDateTime) getAttrVal("Dt_guiderback"));
	}	
	/**
	 * 导引单收回时间
	 * @param Dt_guiderback
	 */
	public void setDt_guiderback(FDateTime Dt_guiderback) {
		setAttrVal("Dt_guiderback", Dt_guiderback);
	}
	/**
	 * 工种
	 * @return String
	 */
	public String getProfession() {
		return ((String) getAttrVal("Profession"));
	}	
	/**
	 * 工种
	 * @param Profession
	 */
	public void setProfession(String Profession) {
		setAttrVal("Profession", Profession);
	}
	/**
	 * 行业
	 * @return String
	 */
	public String getIndustry() {
		return ((String) getAttrVal("Industry"));
	}	
	/**
	 * 行业
	 * @param Industry
	 */
	public void setIndustry(String Industry) {
		setAttrVal("Industry", Industry);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getCompany() {
		return ((String) getAttrVal("Company"));
	}	
	/**
	 * 单位名称
	 * @param Company
	 */
	public void setCompany(String Company) {
		setAttrVal("Company", Company);
	}
	/**
	 * 岗位状态
	 * @return Integer
	 */
	public Integer getSt_job() {
		return ((Integer) getAttrVal("St_job"));
	}	
	/**
	 * 岗位状态
	 * @param St_job
	 */
	public void setSt_job(Integer St_job) {
		setAttrVal("St_job", St_job);
	}
	/**
	 * 在岗时间
	 * @return String
	 */
	public String getJob_time() {
		return ((String) getAttrVal("Job_time"));
	}	
	/**
	 * 在岗时间
	 * @param Job_time
	 */
	public void setJob_time(String Job_time) {
		setAttrVal("Job_time", Job_time);
	}
	/**
	 * 工龄
	 * @return String
	 */
	public String getWorkingage() {
		return ((String) getAttrVal("Workingage"));
	}	
	/**
	 * 工龄
	 * @param Workingage
	 */
	public void setWorkingage(String Workingage) {
		setAttrVal("Workingage", Workingage);
	}
	/**
	 * 更新次数
	 * @return Integer
	 */
	public Integer getCt_prn() {
		return ((Integer) getAttrVal("Ct_prn"));
	}	
	/**
	 * 更新次数
	 * @param Ct_prn
	 */
	public void setCt_prn(Integer Ct_prn) {
		setAttrVal("Ct_prn", Ct_prn);
	}
	/**
	 * 体检身份类型
	 * @return Integer
	 */
	public Integer getIdentitytp() {
		return ((Integer) getAttrVal("Identitytp"));
	}	
	/**
	 * 体检身份类型
	 * @param Identitytp
	 */
	public void setIdentitytp(Integer Identitytp) {
		setAttrVal("Identitytp", Identitytp);
	}
	/**
	 * 门诊收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl_pay() {
		return ((FBoolean) getAttrVal("Fg_bl_pay"));
	}	
	/**
	 * 门诊收费标识
	 * @param Fg_bl_pay
	 */
	public void setFg_bl_pay(FBoolean Fg_bl_pay) {
		setAttrVal("Fg_bl_pay", Fg_bl_pay);
	}
	/**
	 * 门诊收费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bl_pay() {
		return ((FDateTime) getAttrVal("Dt_bl_pay"));
	}	
	/**
	 * 门诊收费时间
	 * @param Dt_bl_pay
	 */
	public void setDt_bl_pay(FDateTime Dt_bl_pay) {
		setAttrVal("Dt_bl_pay", Dt_bl_pay);
	}
	/**
	 * 自付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}	
	/**
	 * 自付标识
	 * @param Fg_payself
	 */
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
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
	 * 门诊就诊ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 门诊就诊ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_step() {
		return ((String) getAttrVal("Code_step"));
	}	
	/**
	 * 编码
	 * @param Code_step
	 */
	public void setCode_step(String Code_step) {
		setAttrVal("Code_step", Code_step);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_step() {
		return ((String) getAttrVal("Name_step"));
	}	
	/**
	 * 名称
	 * @param Name_step
	 */
	public void setName_step(String Name_step) {
		setAttrVal("Name_step", Name_step);
	}
	/**
	 * 登记类型编码
	 * @return String
	 */
	public String getCode_regtp() {
		return ((String) getAttrVal("Code_regtp"));
	}	
	/**
	 * 登记类型编码
	 * @param Code_regtp
	 */
	public void setCode_regtp(String Code_regtp) {
		setAttrVal("Code_regtp", Code_regtp);
	}
	/**
	 * 登记类型
	 * @return String
	 */
	public String getName_regtp() {
		return ((String) getAttrVal("Name_regtp"));
	}	
	/**
	 * 登记类型
	 * @param Name_regtp
	 */
	public void setName_regtp(String Name_regtp) {
		setAttrVal("Name_regtp", Name_regtp);
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
		return "Id_pepsnappt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pepsnappt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnApptDODesc.class);
	}
	
}