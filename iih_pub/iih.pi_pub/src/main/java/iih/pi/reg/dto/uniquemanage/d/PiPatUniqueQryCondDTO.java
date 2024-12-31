package iih.pi.reg.dto.uniquemanage.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者唯一性管理查询条件 DTO数据 
 * 
 */
public class PiPatUniqueQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 第三方平台id
	 * @return String
	 */
	public String getId_third() {
		return ((String) getAttrVal("Id_third"));
	}
	/**
	 * 第三方平台id
	 * @param Id_third
	 */
	public void setId_third(String Id_third) {
		setAttrVal("Id_third", Id_third);
	}
	/**
	 * 第三方平台编码
	 * @return String
	 */
	public String getCode_third() {
		return ((String) getAttrVal("Code_third"));
	}
	/**
	 * 第三方平台编码
	 * @param Code_third
	 */
	public void setCode_third(String Code_third) {
		setAttrVal("Code_third", Code_third);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
}