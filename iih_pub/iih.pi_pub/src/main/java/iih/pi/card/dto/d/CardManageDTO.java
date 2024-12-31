package iih.pi.card.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 卡管理DTO DTO数据 
 * 
 */
public class CardManageDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 领用人
	 * @return String
	 */
	public String getId_emp_get() {
		return ((String) getAttrVal("Id_emp_get"));
	}
	/**
	 * 领用人
	 * @param Id_emp_get
	 */
	public void setId_emp_get(String Id_emp_get) {
		setAttrVal("Id_emp_get", Id_emp_get);
	}
	/**
	 * 领用人名称
	 * @return String
	 */
	public String getName_emp_get() {
		return ((String) getAttrVal("Name_emp_get"));
	}
	/**
	 * 领用人名称
	 * @param Name_emp_get
	 */
	public void setName_emp_get(String Name_emp_get) {
		setAttrVal("Name_emp_get", Name_emp_get);
	}
	/**
	 * 卡类型
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}
	/**
	 * 卡类型
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 卡类型名称
	 * @return String
	 */
	public String getName_patcardtp() {
		return ((String) getAttrVal("Name_patcardtp"));
	}
	/**
	 * 卡类型名称
	 * @param Name_patcardtp
	 */
	public void setName_patcardtp(String Name_patcardtp) {
		setAttrVal("Name_patcardtp", Name_patcardtp);
	}
	/**
	 * 起始卡号
	 * @return String
	 */
	public String getCode_begin() {
		return ((String) getAttrVal("Code_begin"));
	}
	/**
	 * 起始卡号
	 * @param Code_begin
	 */
	public void setCode_begin(String Code_begin) {
		setAttrVal("Code_begin", Code_begin);
	}
	/**
	 * 终止卡号
	 * @return String
	 */
	public String getCode_end() {
		return ((String) getAttrVal("Code_end"));
	}
	/**
	 * 终止卡号
	 * @param Code_end
	 */
	public void setCode_end(String Code_end) {
		setAttrVal("Code_end", Code_end);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getAmount() {
		return ((Integer) getAttrVal("Amount"));
	}
	/**
	 * 数量
	 * @param Amount
	 */
	public void setAmount(Integer Amount) {
		setAttrVal("Amount", Amount);
	}
	
	/**
	 * 卡密标识
	 * @return FBoolean
	 */
	public FBoolean getFg_password() {
		return ((FBoolean) getAttrVal("Fg_password"));
	}
	/**
	 * 卡密标识
	 * @param Amount
	 */
	public void setFg_passwordt(FBoolean Fg_password) {
		setAttrVal("Fg_password", Fg_password);
	}
}