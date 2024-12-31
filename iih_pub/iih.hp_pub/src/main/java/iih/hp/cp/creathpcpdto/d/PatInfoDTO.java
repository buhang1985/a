package iih.hp.cp.creathpcpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息 DTO数据 
 * 
 */
public class PatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者身份
	 * @return String
	 */
	public String getIdentity() {
		return ((String) getAttrVal("Identity"));
	}
	/**
	 * 患者身份
	 * @param Identity
	 */
	public void setIdentity(String Identity) {
		setAttrVal("Identity", Identity);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 诊闭时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 诊闭时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 在院天数
	 * @return Integer
	 */
	public Integer getIndays() {
		return ((Integer) getAttrVal("Indays"));
	}
	/**
	 * 在院天数
	 * @param Indays
	 */
	public void setIndays(Integer Indays) {
		setAttrVal("Indays", Indays);
	}
	/**
	 * 病情转归
	 * @return String
	 */
	public String getSd_outcomes() {
		return ((String) getAttrVal("Sd_outcomes"));
	}
	/**
	 * 病情转归
	 * @param Sd_outcomes
	 */
	public void setSd_outcomes(String Sd_outcomes) {
		setAttrVal("Sd_outcomes", Sd_outcomes);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getInpatarea() {
		return ((String) getAttrVal("Inpatarea"));
	}
	/**
	 * 病区
	 * @param Inpatarea
	 */
	public void setInpatarea(String Inpatarea) {
		setAttrVal("Inpatarea", Inpatarea);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}
	/**
	 * 床号
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 医嘱数
	 * @return Integer
	 */
	public Integer getCiornum() {
		return ((Integer) getAttrVal("Ciornum"));
	}
	/**
	 * 医嘱数
	 * @param Ciornum
	 */
	public void setCiornum(Integer Ciornum) {
		setAttrVal("Ciornum", Ciornum);
	}
	/**
	 * 离院转归
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}
	/**
	 * 离院转归
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 患者医嘱明细
	 * @return FArrayList
	 */
	public FArrayList getCioritems() {
		return ((FArrayList) getAttrVal("Cioritems"));
	}
	/**
	 * 患者医嘱明细
	 * @param Cioritems
	 */
	public void setCioritems(FArrayList Cioritems) {
		setAttrVal("Cioritems", Cioritems);
	}
	/**
	 * 是否选中
	 * @return FBoolean
	 */
	public FBoolean getFg_selected() {
		return ((FBoolean) getAttrVal("Fg_selected"));
	}
	/**
	 * 是否选中
	 * @param Fg_selected
	 */
	public void setFg_selected(FBoolean Fg_selected) {
		setAttrVal("Fg_selected", Fg_selected);
	}
}