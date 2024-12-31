package iih.mi.mc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保特殊病患者dto DTO数据 
 * 
 */
public class MiMcPatSpecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保特殊病患者诊断主键
	 * @return String
	 */
	public String getId_mimcpatspec() {
		return ((String) getAttrVal("Id_mimcpatspec"));
	}	
	/**
	 * 医保特殊病患者诊断主键
	 * @param Id_mimcpatspec
	 */
	public void setId_mimcpatspec(String Id_mimcpatspec) {
		setAttrVal("Id_mimcpatspec", Id_mimcpatspec);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	/**
	 * 编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
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
	 * 医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}	
	/**
	 * 联系电话
	 * @param Tel_pat
	 */
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSexname_pat() {
		return ((String) getAttrVal("Sexname_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sexname_pat
	 */
	public void setSexname_pat(String Sexname_pat) {
		setAttrVal("Sexname_pat", Sexname_pat);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 病种名称
	 * @return String
	 */
	public String getName_ds() {
		return ((String) getAttrVal("Name_ds"));
	}	
	/**
	 * 病种名称
	 * @param Name_ds
	 */
	public void setName_ds(String Name_ds) {
		setAttrVal("Name_ds", Name_ds);
	}
	/**
	 * 病种编码
	 * @return String
	 */
	public String getCode_ds() {
		return ((String) getAttrVal("Code_ds"));
	}	
	/**
	 * 病种编码
	 * @param Code_ds
	 */
	public void setCode_ds(String Code_ds) {
		setAttrVal("Code_ds", Code_ds);
	}
}