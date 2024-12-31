package iih.ci.mrqc.mroperrisklistdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术风险评估表统计 DTO数据 
 * 
 */
public class MrOperRiskListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 提交时间
	 * @return FDateTime
	 */
	public FDateTime getSubmit_time() {
		return ((FDateTime) getAttrVal("Submit_time"));
	}
	/**
	 * 提交时间
	 * @param Submit_time
	 */
	public void setSubmit_time(FDateTime Submit_time) {
		setAttrVal("Submit_time", Submit_time);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getHosp_number() {
		return ((String) getAttrVal("Hosp_number"));
	}
	/**
	 * 住院号
	 * @param Hosp_number
	 */
	public void setHosp_number(String Hosp_number) {
		setAttrVal("Hosp_number", Hosp_number);
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
	 * 手术切口清洁度
	 * @return String
	 */
	public String getOpe_clean() {
		return ((String) getAttrVal("Ope_clean"));
	}
	/**
	 * 手术切口清洁度
	 * @param Ope_clean
	 */
	public void setOpe_clean(String Ope_clean) {
		setAttrVal("Ope_clean", Ope_clean);
	}
	/**
	 * 手术切口清洁度分值
	 * @return String
	 */
	public String getOpe_clean_number() {
		return ((String) getAttrVal("Ope_clean_number"));
	}
	/**
	 * 手术切口清洁度分值
	 * @param Ope_clean_number
	 */
	public void setOpe_clean_number(String Ope_clean_number) {
		setAttrVal("Ope_clean_number", Ope_clean_number);
	}
	/**
	 * 麻醉分级
	 * @return String
	 */
	public String getPoison_level() {
		return ((String) getAttrVal("Poison_level"));
	}
	/**
	 * 麻醉分级
	 * @param Poison_level
	 */
	public void setPoison_level(String Poison_level) {
		setAttrVal("Poison_level", Poison_level);
	}
	/**
	 * 麻醉分级分值
	 * @return String
	 */
	public String getPoison_level_number() {
		return ((String) getAttrVal("Poison_level_number"));
	}
	/**
	 * 麻醉分级分值
	 * @param Poison_level_number
	 */
	public void setPoison_level_number(String Poison_level_number) {
		setAttrVal("Poison_level_number", Poison_level_number);
	}
	/**
	 * 持续时间
	 * @return String
	 */
	public String getContinue_time() {
		return ((String) getAttrVal("Continue_time"));
	}
	/**
	 * 持续时间
	 * @param Continue_time
	 */
	public void setContinue_time(String Continue_time) {
		setAttrVal("Continue_time", Continue_time);
	}
	/**
	 * 持续时间分值
	 * @return String
	 */
	public String getContinue_time_number() {
		return ((String) getAttrVal("Continue_time_number"));
	}
	/**
	 * 持续时间分值
	 * @param Continue_time_number
	 */
	public void setContinue_time_number(String Continue_time_number) {
		setAttrVal("Continue_time_number", Continue_time_number);
	}
	/**
	 * 手术风险评估合计分值
	 * @return String
	 */
	public String getSum_number() {
		return ((String) getAttrVal("Sum_number"));
	}
	/**
	 * 手术风险评估合计分值
	 * @param Sum_number
	 */
	public void setSum_number(String Sum_number) {
		setAttrVal("Sum_number", Sum_number);
	}
	/**
	 * NISS
	 * @return String
	 */
	public String getNnis() {
		return ((String) getAttrVal("Nnis"));
	}
	/**
	 * NISS
	 * @param Nnis
	 */
	public void setNnis(String Nnis) {
		setAttrVal("Nnis", Nnis);
	}
	/**
	 * 切口愈合
	 * @return String
	 */
	public String getIncision_healing() {
		return ((String) getAttrVal("Incision_healing"));
	}
	/**
	 * 切口愈合
	 * @param Incision_healing
	 */
	public void setIncision_healing(String Incision_healing) {
		setAttrVal("Incision_healing", Incision_healing);
	}
	/**
	 * 手术类别
	 * @return String
	 */
	public String getOpe_class() {
		return ((String) getAttrVal("Ope_class"));
	}
	/**
	 * 手术类别
	 * @param Ope_class
	 */
	public void setOpe_class(String Ope_class) {
		setAttrVal("Ope_class", Ope_class);
	}
	/**
	 * 是否急诊
	 * @return String
	 */
	public String getWhether_emergency() {
		return ((String) getAttrVal("Whether_emergency"));
	}
	/**
	 * 是否急诊
	 * @param Whether_emergency
	 */
	public void setWhether_emergency(String Whether_emergency) {
		setAttrVal("Whether_emergency", Whether_emergency);
	}
	/**
	 * 手术时间
	 * @return String
	 */
	public String getOpe_time() {
		return ((String) getAttrVal("Ope_time"));
	}
	/**
	 * 手术时间
	 * @param Ope_time
	 */
	public void setOpe_time(String Ope_time) {
		setAttrVal("Ope_time", Ope_time);
	}
	/**
	 * 出院时间
	 * @return FDate
	 */
	public FDate getHosp_out_time() {
		return ((FDate) getAttrVal("Hosp_out_time"));
	}
	/**
	 * 出院时间
	 * @param Hosp_out_time
	 */
	public void setHosp_out_time(FDate Hosp_out_time) {
		setAttrVal("Hosp_out_time", Hosp_out_time);
	}
	/**
	 * 科别
	 * @return String
	 */
	public String getDepment_class() {
		return ((String) getAttrVal("Depment_class"));
	}
	/**
	 * 科别
	 * @param Depment_class
	 */
	public void setDepment_class(String Depment_class) {
		setAttrVal("Depment_class", Depment_class);
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
}