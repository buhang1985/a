package iih.pi.dic.pipatbbrms055dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者分类集成平台MS055用DTO DTO数据 
 * 
 */
public class Pipatbbrms055dto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
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
	 * 患者性别
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}
	/**
	 * 患者性别
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保卡号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 患者类型
	 * @return Integer
	 */
	public Integer getPatienttype() {
		return ((Integer) getAttrVal("Patienttype"));
	}
	/**
	 * 患者类型
	 * @param Patienttype
	 */
	public void setPatienttype(Integer Patienttype) {
		setAttrVal("Patienttype", Patienttype);
	}
}