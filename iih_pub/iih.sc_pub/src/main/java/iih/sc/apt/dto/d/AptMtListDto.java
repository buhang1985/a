package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技辅预约列表dto DTO数据 
 * 
 */
public class AptMtListDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 已预约列表主键id
	 * @return String
	 */
	public String getId_mtdto() {
		return ((String) getAttrVal("Id_mtdto"));
	}
	/**
	 * 已预约列表主键id
	 * @param Id_mtdto
	 */
	public void setId_mtdto(String Id_mtdto) {
		setAttrVal("Id_mtdto", Id_mtdto);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}
	/**
	 * 票号
	 * @param Queno
	 */
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 是否急诊
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 是否急诊
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
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
	public String getDt_birth_pat() {
		return ((String) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 年龄
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(String Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getId_sex_name() {
		return ((String) getAttrVal("Id_sex_name"));
	}
	/**
	 * 性别名称
	 * @param Id_sex_name
	 */
	public void setId_sex_name(String Id_sex_name) {
		setAttrVal("Id_sex_name", Id_sex_name);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 申请科室
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getId_dep_name() {
		return ((String) getAttrVal("Id_dep_name"));
	}
	/**
	 * 部门名称
	 * @param Id_dep_name
	 */
	public void setId_dep_name(String Id_dep_name) {
		setAttrVal("Id_dep_name", Id_dep_name);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getBegin_date() {
		return ((FDate) getAttrVal("Begin_date"));
	}
	/**
	 * 开始日期
	 * @param Begin_date
	 */
	public void setBegin_date(FDate Begin_date) {
		setAttrVal("Begin_date", Begin_date);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getEnd_date() {
		return ((FDate) getAttrVal("End_date"));
	}
	/**
	 * 结束日期
	 * @param End_date
	 */
	public void setEnd_date(FDate End_date) {
		setAttrVal("End_date", End_date);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApply_number() {
		return ((String) getAttrVal("Apply_number"));
	}
	/**
	 * 申请单号
	 * @param Apply_number
	 */
	public void setApply_number(String Apply_number) {
		setAttrVal("Apply_number", Apply_number);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 排班资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 检查日期大于预约日期天数
	 * @return Integer
	 */
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}
	/**
	 * 检查日期大于预约日期天数
	 * @param Days
	 */
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
}