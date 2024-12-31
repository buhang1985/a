package iih.pi.reg.dto.uniquemanage.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者唯一性管理删除条件 DTO数据 
 * 
 */
public class PiPatUniqueDeleteCondDTO extends BaseDTO {
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
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
}