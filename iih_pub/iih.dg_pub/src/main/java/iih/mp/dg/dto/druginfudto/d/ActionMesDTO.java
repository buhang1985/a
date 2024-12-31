package iih.mp.dg.dto.druginfudto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液执行信息 DTO数据 
 * 
 */
public class ActionMesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getStatus_fin() {
		return ((String) getAttrVal("Status_fin"));
	}
	/**
	 * 执行状态
	 * @param Status_fin
	 */
	public void setStatus_fin(String Status_fin) {
		setAttrVal("Status_fin", Status_fin);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getBegin_date() {
		return ((FDateTime) getAttrVal("Begin_date"));
	}
	/**
	 * 开始时间
	 * @param Begin_date
	 */
	public void setBegin_date(FDateTime Begin_date) {
		setAttrVal("Begin_date", Begin_date);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getEnd_date() {
		return ((FDateTime) getAttrVal("End_date"));
	}
	/**
	 * 结束时间
	 * @param End_date
	 */
	public void setEnd_date(FDateTime End_date) {
		setAttrVal("End_date", End_date);
	}
	/**
	 * 巡视时间
	 * @return FDateTime
	 */
	public FDateTime getCheck_date() {
		return ((FDateTime) getAttrVal("Check_date"));
	}
	/**
	 * 巡视时间
	 * @param Check_date
	 */
	public void setCheck_date(FDateTime Check_date) {
		setAttrVal("Check_date", Check_date);
	}
	/**
	 * 巡视人id
	 * @return String
	 */
	public String getId_check() {
		return ((String) getAttrVal("Id_check"));
	}
	/**
	 * 巡视人id
	 * @param Id_check
	 */
	public void setId_check(String Id_check) {
		setAttrVal("Id_check", Id_check);
	}
	/**
	 * 巡视人姓名
	 * @return String
	 */
	public String getName_check() {
		return ((String) getAttrVal("Name_check"));
	}
	/**
	 * 巡视人姓名
	 * @param Name_check
	 */
	public void setName_check(String Name_check) {
		setAttrVal("Name_check", Name_check);
	}
	/**
	 * 负责人id
	 * @return String
	 */
	public String getId_charge() {
		return ((String) getAttrVal("Id_charge"));
	}
	/**
	 * 负责人id
	 * @param Id_charge
	 */
	public void setId_charge(String Id_charge) {
		setAttrVal("Id_charge", Id_charge);
	}
	/**
	 * 负责人姓名
	 * @return String
	 */
	public String getName_charge() {
		return ((String) getAttrVal("Name_charge"));
	}
	/**
	 * 负责人姓名
	 * @param Name_charge
	 */
	public void setName_charge(String Name_charge) {
		setAttrVal("Name_charge", Name_charge);
	}
	/**
	 * 输液情况
	 * @return FBoolean
	 */
	public FBoolean getFg_matter() {
		return ((FBoolean) getAttrVal("Fg_matter"));
	}
	/**
	 * 输液情况
	 * @param Fg_matter
	 */
	public void setFg_matter(FBoolean Fg_matter) {
		setAttrVal("Fg_matter", Fg_matter);
	}
	/**
	 * 输液说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 输液说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 总用量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 总用量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 输液登记id
	 * @return String
	 */
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}
	/**
	 * 输液登记id
	 * @param Id_dginfu
	 */
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}
	/**
	 * 医嘱执行id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}
	/**
	 * 单位
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	/**
	 * 滴速
	 * @return Integer
	 */
	public Integer getDri_speed() {
		return ((Integer) getAttrVal("Dri_speed"));
	}
	/**
	 * 滴速
	 * @param Dri_speed
	 */
	public void setDri_speed(Integer Dri_speed) {
		setAttrVal("Dri_speed", Dri_speed);
	}
	/**
	 * 巡视结果
	 * @return String
	 */
	public String getCheck_matter() {
		return ((String) getAttrVal("Check_matter"));
	}
	/**
	 * 巡视结果
	 * @param Check_matter
	 */
	public void setCheck_matter(String Check_matter) {
		setAttrVal("Check_matter", Check_matter);
	}
	/**
	 * 执行类型
	 * @return String
	 */
	public String getId_dgprtp() {
		return ((String) getAttrVal("Id_dgprtp"));
	}
	/**
	 * 执行类型
	 * @param Id_dgprtp
	 */
	public void setId_dgprtp(String Id_dgprtp) {
		setAttrVal("Id_dgprtp", Id_dgprtp);
	}
	/**
	 * 执行类型编码
	 * @return String
	 */
	public String getSd_dgprtp() {
		return ((String) getAttrVal("Sd_dgprtp"));
	}
	/**
	 * 执行类型编码
	 * @param Sd_dgprtp
	 */
	public void setSd_dgprtp(String Sd_dgprtp) {
		setAttrVal("Sd_dgprtp", Sd_dgprtp);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getName_dj() {
		return ((String) getAttrVal("Name_dj"));
	}
	/**
	 * 登记人
	 * @param Name_dj
	 */
	public void setName_dj(String Name_dj) {
		setAttrVal("Name_dj", Name_dj);
	}
	/**
	 * 皮试
	 * @return FBoolean
	 */
	public FBoolean getSkintest() {
		return ((FBoolean) getAttrVal("Skintest"));
	}
	/**
	 * 皮试
	 * @param Skintest
	 */
	public void setSkintest(FBoolean Skintest) {
		setAttrVal("Skintest", Skintest);
	}
	/**
	 * 皮试结果
	 * @return String
	 */
	public String getName_skintest() {
		return ((String) getAttrVal("Name_skintest"));
	}
	/**
	 * 皮试结果
	 * @param Name_skintest
	 */
	public void setName_skintest(String Name_skintest) {
		setAttrVal("Name_skintest", Name_skintest);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 执行科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
}