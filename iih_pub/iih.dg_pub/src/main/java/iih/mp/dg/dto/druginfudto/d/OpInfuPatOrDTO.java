package iih.mp.dg.dto.druginfudto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医嘱信息 DTO数据 
 * 
 */
public class OpInfuPatOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	 * 打印时的日期
	 * @return FDateTime
	 */
	public FDateTime getDate() {
		return ((FDateTime) getAttrVal("Date"));
	}
	/**
	 * 打印时的日期
	 * @param Date
	 */
	public void setDate(FDateTime Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getEnt_date() {
		return ((FDateTime) getAttrVal("Ent_date"));
	}
	/**
	 * 就诊时间
	 * @param Ent_date
	 */
	public void setEnt_date(FDateTime Ent_date) {
		setAttrVal("Ent_date", Ent_date);
	}
	/**
	 * 腕带二维码字符串
	 * @return String
	 */
	public String getQrcode_band() {
		return ((String) getAttrVal("Qrcode_band"));
	}
	/**
	 * 腕带二维码字符串
	 * @param Qrcode_band
	 */
	public void setQrcode_band(String Qrcode_band) {
		setAttrVal("Qrcode_band", Qrcode_band);
	}
	/**
	 * 拆解医嘱id
	 * @return String
	 */
	public String getId_pr() {
		return ((String) getAttrVal("Id_pr"));
	}
	/**
	 * 拆解医嘱id
	 * @param Id_pr
	 */
	public void setId_pr(String Id_pr) {
		setAttrVal("Id_pr", Id_pr);
	}
	/**
	 * 执行次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 执行次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 标签二维码
	 * @return String
	 */
	public String getQrcode_label() {
		return ((String) getAttrVal("Qrcode_label"));
	}
	/**
	 * 标签二维码
	 * @param Qrcode_label
	 */
	public void setQrcode_label(String Qrcode_label) {
		setAttrVal("Qrcode_label", Qrcode_label);
	}
	/**
	 * 登记状态
	 * @return String
	 */
	public String getStatus_fin() {
		return ((String) getAttrVal("Status_fin"));
	}
	/**
	 * 登记状态
	 * @param Status_fin
	 */
	public void setStatus_fin(String Status_fin) {
		setAttrVal("Status_fin", Status_fin);
	}
	/**
	 * 总执行次数
	 * @return Integer
	 */
	public Integer getCount() {
		return ((Integer) getAttrVal("Count"));
	}
	/**
	 * 总执行次数
	 * @param Count
	 */
	public void setCount(Integer Count) {
		setAttrVal("Count", Count);
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
}