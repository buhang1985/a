package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区患者就诊账户信息 DTO数据 
 * 
 */
public class EntAccInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
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
	 * 患者信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_patcred() {
		return ((FDouble) getAttrVal("Amt_patcred"));
	}
	/**
	 * 患者信用额度
	 * @param Amt_patcred
	 */
	public void setAmt_patcred(FDouble Amt_patcred) {
		setAttrVal("Amt_patcred", Amt_patcred);
	}
	/**
	 * 就诊信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_entcred() {
		return ((FDouble) getAttrVal("Amt_entcred"));
	}
	/**
	 * 就诊信用额度
	 * @param Amt_entcred
	 */
	public void setAmt_entcred(FDouble Amt_entcred) {
		setAttrVal("Amt_entcred", Amt_entcred);
	}
	/**
	 * 住院就诊预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 住院就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 就诊锁定预交金部分
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 就诊锁定预交金部分
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 额外补充金额
	 * @return FDouble
	 */
	public FDouble getAmt_extra() {
		return ((FDouble) getAttrVal("Amt_extra"));
	}
	/**
	 * 额外补充金额
	 * @param Amt_extra
	 */
	public void setAmt_extra(FDouble Amt_extra) {
		setAttrVal("Amt_extra", Amt_extra);
	}
	/**
	 * 预交金催缴警戒金额
	 * @return FDouble
	 */
	public FDouble getAmt_limit() {
		return ((FDouble) getAttrVal("Amt_limit"));
	}
	/**
	 * 预交金催缴警戒金额
	 * @param Amt_limit
	 */
	public void setAmt_limit(FDouble Amt_limit) {
		setAttrVal("Amt_limit", Amt_limit);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
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
	 * @return FDouble
	 */
	public FDouble getAge() {
		return ((FDouble) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(FDouble Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 生日
	 * @return FDateTime
	 */
	public FDateTime getBirthday() {
		return ((FDateTime) getAttrVal("Birthday"));
	}
	/**
	 * 生日
	 * @param Birthday
	 */
	public void setBirthday(FDateTime Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊编码
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 患者身份
	 * @return String
	 */
	public String getPatca() {
		return ((String) getAttrVal("Patca"));
	}
	/**
	 * 患者身份
	 * @param Patca
	 */
	public void setPatca(String Patca) {
		setAttrVal("Patca", Patca);
	}
}