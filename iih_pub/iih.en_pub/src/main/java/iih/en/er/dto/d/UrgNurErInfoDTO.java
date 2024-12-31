package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊留观护士站-急诊信息 DTO数据 
 * 
 */
public class UrgNurErInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 滞留时长
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}
	/**
	 * 滞留时长
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 评分等级
	 * @return String
	 */
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}
	/**
	 * 评分等级
	 * @param Name_level
	 */
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	/**
	 * 评分等级sd
	 * @return String
	 */
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}
	/**
	 * 评分等级sd
	 * @param Sd_level
	 */
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	/**
	 * 绿色通道
	 * @return String
	 */
	public String getGreen_channel() {
		return ((String) getAttrVal("Green_channel"));
	}
	/**
	 * 绿色通道
	 * @param Green_channel
	 */
	public void setGreen_channel(String Green_channel) {
		setAttrVal("Green_channel", Green_channel);
	}
	/**
	 * 血压
	 * @return String
	 */
	public String getBlood_pressure() {
		return ((String) getAttrVal("Blood_pressure"));
	}
	/**
	 * 血压
	 * @param Blood_pressure
	 */
	public void setBlood_pressure(String Blood_pressure) {
		setAttrVal("Blood_pressure", Blood_pressure);
	}
	/**
	 * spo2
	 * @return String
	 */
	public String getSpo2() {
		return ((String) getAttrVal("Spo2"));
	}
	/**
	 * spo2
	 * @param Spo2
	 */
	public void setSpo2(String Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	/**
	 * 体温
	 * @return String
	 */
	public String getTemperature() {
		return ((String) getAttrVal("Temperature"));
	}
	/**
	 * 体温
	 * @param Temperature
	 */
	public void setTemperature(String Temperature) {
		setAttrVal("Temperature", Temperature);
	}
	/**
	 * 心率
	 * @return String
	 */
	public String getHeart_rate() {
		return ((String) getAttrVal("Heart_rate"));
	}
	/**
	 * 心率
	 * @param Heart_rate
	 */
	public void setHeart_rate(String Heart_rate) {
		setAttrVal("Heart_rate", Heart_rate);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 过敏
	 * @return String
	 */
	public String getAllergy() {
		return ((String) getAttrVal("Allergy"));
	}
	/**
	 * 过敏
	 * @param Allergy
	 */
	public void setAllergy(String Allergy) {
		setAttrVal("Allergy", Allergy);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 评分MAP
	 * @return FMap
	 */
	public FMap getErscoremap() {
		return ((FMap) getAttrVal("Erscoremap"));
	}
	/**
	 * 评分MAP
	 * @param Erscoremap
	 */
	public void setErscoremap(FMap Erscoremap) {
		setAttrVal("Erscoremap", Erscoremap);
	}
	/**
	 * 评分类型sd
	 * @return String
	 */
	public String getSd_scoretp() {
		return ((String) getAttrVal("Sd_scoretp"));
	}
	/**
	 * 评分类型sd
	 * @param Sd_scoretp
	 */
	public void setSd_scoretp(String Sd_scoretp) {
		setAttrVal("Sd_scoretp", Sd_scoretp);
	}
	/**
	 * 评分类型
	 * @return String
	 */
	public String getName_scoretp() {
		return ((String) getAttrVal("Name_scoretp"));
	}
	/**
	 * 评分类型
	 * @param Name_scoretp
	 */
	public void setName_scoretp(String Name_scoretp) {
		setAttrVal("Name_scoretp", Name_scoretp);
	}
	/**
	 * 评分
	 * @return String
	 */
	public String getScore() {
		return ((String) getAttrVal("Score"));
	}
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(String Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}