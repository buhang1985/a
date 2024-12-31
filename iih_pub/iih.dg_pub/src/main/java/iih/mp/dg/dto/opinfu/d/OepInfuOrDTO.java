package iih.mp.dg.dto.opinfu.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液管理医嘱信息 DTO数据 
 * 
 */
public class OepInfuOrDTO extends BaseDTO {
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
	 * 医嘱类型
	 * @return String
	 */
	public String getOrdertp() {
		return ((String) getAttrVal("Ordertp"));
	}
	/**
	 * 医嘱类型
	 * @param Ordertp
	 */
	public void setOrdertp(String Ordertp) {
		setAttrVal("Ordertp", Ordertp);
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
	 * 登记标志
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}
	/**
	 * 登记标志
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
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
}