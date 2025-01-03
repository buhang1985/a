package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分诊台信息DTO DTO数据 
 * 
 */
public class TriageBenInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分诊台ID
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}
	/**
	 * 分诊台ID
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 分诊台名称
	 * @return String
	 */
	public String getName_queben() {
		return ((String) getAttrVal("Name_queben"));
	}
	/**
	 * 分诊台名称
	 * @param Name_queben
	 */
	public void setName_queben(String Name_queben) {
		setAttrVal("Name_queben", Name_queben);
	}
	/**
	 * 日期分组ID
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组ID
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 日期分组名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 日期分组名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 医生ID
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 医生ID
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 分诊台管理科室
	 * @return FArrayList
	 */
	public FArrayList getDeps() {
		return ((FArrayList) getAttrVal("Deps"));
	}
	/**
	 * 分诊台管理科室
	 * @param Deps
	 */
	public void setDeps(FArrayList Deps) {
		setAttrVal("Deps", Deps);
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
	 * 排班类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDate() {
		return ((FDate) getAttrVal("Date"));
	}
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(FDate Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 分诊台状态
	 * @return String
	 */
	public String getEu_pause() {
		return ((String) getAttrVal("Eu_pause"));
	}
	/**
	 * 分诊台状态
	 * @param Eu_pause
	 */
	public void setEu_pause(String Eu_pause) {
		setAttrVal("Eu_pause", Eu_pause);
	}
}