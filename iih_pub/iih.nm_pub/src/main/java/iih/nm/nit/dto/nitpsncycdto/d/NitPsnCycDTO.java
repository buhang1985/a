package iih.nm.nit.dto.nitpsncycdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 科室轮转dto DTO数据 
 * 
 */
public class NitPsnCycDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室轮转主键
	 * @return String
	 */
	public String getId_psn_cyc() {
		return ((String) getAttrVal("Id_psn_cyc"));
	}
	/**
	 * 科室轮转主键
	 * @param Id_psn_cyc
	 */
	public void setId_psn_cyc(String Id_psn_cyc) {
		setAttrVal("Id_psn_cyc", Id_psn_cyc);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 实习计划id
	 * @return String
	 */
	public String getId_pracgrp_pl() {
		return ((String) getAttrVal("Id_pracgrp_pl"));
	}
	/**
	 * 实习计划id
	 * @param Id_pracgrp_pl
	 */
	public void setId_pracgrp_pl(String Id_pracgrp_pl) {
		setAttrVal("Id_pracgrp_pl", Id_pracgrp_pl);
	}
	/**
	 * 实习科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 实习科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 实习进修生id
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}
	/**
	 * 实习进修生id
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	/**
	 * 实习小组id
	 * @return String
	 */
	public String getId_pracgrp() {
		return ((String) getAttrVal("Id_pracgrp"));
	}
	/**
	 * 实习小组id
	 * @param Id_pracgrp
	 */
	public void setId_pracgrp(String Id_pracgrp) {
		setAttrVal("Id_pracgrp", Id_pracgrp);
	}
	/**
	 * 实习计划名称
	 * @return String
	 */
	public String getName_pracgrp_pl() {
		return ((String) getAttrVal("Name_pracgrp_pl"));
	}
	/**
	 * 实习计划名称
	 * @param Name_pracgrp_pl
	 */
	public void setName_pracgrp_pl(String Name_pracgrp_pl) {
		setAttrVal("Name_pracgrp_pl", Name_pracgrp_pl);
	}
	/**
	 * 实习人员姓名
	 * @return String
	 */
	public String getName_psninfo() {
		return ((String) getAttrVal("Name_psninfo"));
	}
	/**
	 * 实习人员姓名
	 * @param Name_psninfo
	 */
	public void setName_psninfo(String Name_psninfo) {
		setAttrVal("Name_psninfo", Name_psninfo);
	}
	/**
	 * 实习小组
	 * @return String
	 */
	public String getName_pracgrp() {
		return ((String) getAttrVal("Name_pracgrp"));
	}
	/**
	 * 实习小组
	 * @param Name_pracgrp
	 */
	public void setName_pracgrp(String Name_pracgrp) {
		setAttrVal("Name_pracgrp", Name_pracgrp);
	}
	/**
	 * 人员类别
	 * @return String
	 */
	public String getName_wkca() {
		return ((String) getAttrVal("Name_wkca"));
	}
	/**
	 * 人员类别
	 * @param Name_wkca
	 */
	public void setName_wkca(String Name_wkca) {
		setAttrVal("Name_wkca", Name_wkca);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 实习开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 实习开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 实习结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 实习结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 理论成绩
	 * @return FDouble
	 */
	public FDouble getGrade() {
		return ((FDouble) getAttrVal("Grade"));
	}
	/**
	 * 理论成绩
	 * @param Grade
	 */
	public void setGrade(FDouble Grade) {
		setAttrVal("Grade", Grade);
	}
	/**
	 * 成绩等级id
	 * @return String
	 */
	public String getId_grd_lvl() {
		return ((String) getAttrVal("Id_grd_lvl"));
	}
	/**
	 * 成绩等级id
	 * @param Id_grd_lvl
	 */
	public void setId_grd_lvl(String Id_grd_lvl) {
		setAttrVal("Id_grd_lvl", Id_grd_lvl);
	}
	/**
	 * 成绩等级编码
	 * @return String
	 */
	public String getSd_grd_lvl() {
		return ((String) getAttrVal("Sd_grd_lvl"));
	}
	/**
	 * 成绩等级编码
	 * @param Sd_grd_lvl
	 */
	public void setSd_grd_lvl(String Sd_grd_lvl) {
		setAttrVal("Sd_grd_lvl", Sd_grd_lvl);
	}
	/**
	 * 成绩等级名称
	 * @return String
	 */
	public String getName_grd_lvl() {
		return ((String) getAttrVal("Name_grd_lvl"));
	}
	/**
	 * 成绩等级名称
	 * @param Name_grd_lvl
	 */
	public void setName_grd_lvl(String Name_grd_lvl) {
		setAttrVal("Name_grd_lvl", Name_grd_lvl);
	}
	/**
	 * 实操成绩
	 * @return FDouble
	 */
	public FDouble getAct_grade() {
		return ((FDouble) getAttrVal("Act_grade"));
	}
	/**
	 * 实操成绩
	 * @param Act_grade
	 */
	public void setAct_grade(FDouble Act_grade) {
		setAttrVal("Act_grade", Act_grade);
	}
	/**
	 * 实操成绩等级id
	 * @return String
	 */
	public String getId_act_grd_lvl() {
		return ((String) getAttrVal("Id_act_grd_lvl"));
	}
	/**
	 * 实操成绩等级id
	 * @param Id_act_grd_lvl
	 */
	public void setId_act_grd_lvl(String Id_act_grd_lvl) {
		setAttrVal("Id_act_grd_lvl", Id_act_grd_lvl);
	}
	/**
	 * 实操等级编码
	 * @return String
	 */
	public String getSd_act_grd_lvl() {
		return ((String) getAttrVal("Sd_act_grd_lvl"));
	}
	/**
	 * 实操等级编码
	 * @param Sd_act_grd_lvl
	 */
	public void setSd_act_grd_lvl(String Sd_act_grd_lvl) {
		setAttrVal("Sd_act_grd_lvl", Sd_act_grd_lvl);
	}
	/**
	 * 实操等级名称
	 * @return String
	 */
	public String getName_act_grd_lvl() {
		return ((String) getAttrVal("Name_act_grd_lvl"));
	}
	/**
	 * 实操等级名称
	 * @param Name_act_grd_lvl
	 */
	public void setName_act_grd_lvl(String Name_act_grd_lvl) {
		setAttrVal("Name_act_grd_lvl", Name_act_grd_lvl);
	}
	/**
	 * 成绩评优id
	 * @return String
	 */
	public String getId_appra() {
		return ((String) getAttrVal("Id_appra"));
	}
	/**
	 * 成绩评优id
	 * @param Id_appra
	 */
	public void setId_appra(String Id_appra) {
		setAttrVal("Id_appra", Id_appra);
	}
	/**
	 * 成绩评优编码
	 * @return String
	 */
	public String getSd_appra() {
		return ((String) getAttrVal("Sd_appra"));
	}
	/**
	 * 成绩评优编码
	 * @param Sd_appra
	 */
	public void setSd_appra(String Sd_appra) {
		setAttrVal("Sd_appra", Sd_appra);
	}
	/**
	 * 成绩评优名称
	 * @return String
	 */
	public String getName_appra() {
		return ((String) getAttrVal("Name_appra"));
	}
	/**
	 * 成绩评优名称
	 * @param Name_appra
	 */
	public void setName_appra(String Name_appra) {
		setAttrVal("Name_appra", Name_appra);
	}
	/**
	 * 科室评价
	 * @return String
	 */
	public String getDep_ass() {
		return ((String) getAttrVal("Dep_ass"));
	}
	/**
	 * 科室评价
	 * @param Dep_ass
	 */
	public void setDep_ass(String Dep_ass) {
		setAttrVal("Dep_ass", Dep_ass);
	}
	/**
	 * 通过标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pass() {
		return ((FBoolean) getAttrVal("Fg_pass"));
	}
	/**
	 * 通过标识
	 * @param Fg_pass
	 */
	public void setFg_pass(FBoolean Fg_pass) {
		setAttrVal("Fg_pass", Fg_pass);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg() {
		return ((String) getAttrVal("Id_reg"));
	}
	/**
	 * 登记人
	 * @param Id_reg
	 */
	public void setId_reg(String Id_reg) {
		setAttrVal("Id_reg", Id_reg);
	}
	/**
	 * 登记人姓名
	 * @return String
	 */
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}
	/**
	 * 登记人姓名
	 * @param Name_reg
	 */
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
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
	 * 实习周数
	 * @return String
	 */
	public String getTotal_weeks() {
		return ((String) getAttrVal("Total_weeks"));
	}
	/**
	 * 实习周数
	 * @param Total_weeks
	 */
	public void setTotal_weeks(String Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
	}
	/**
	 * 科室轮转状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 科室轮转状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 科室轮转状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 科室轮转状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
}