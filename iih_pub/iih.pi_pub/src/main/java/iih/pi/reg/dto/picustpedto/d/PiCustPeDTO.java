package iih.pi.reg.dto.picustpedto.d;

import xap.mw.core.data.*;

/**
 * 团检单位信息 DTO数据 
 * 
 */
public class PiCustPeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 客户id
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}
	/**
	 * 客户id
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 合同单位
	 * @return String
	 */
	public String getCust_name() {
		return ((String) getAttrVal("Cust_name"));
	}
	/**
	 * 合同单位
	 * @param Cust_name
	 */
	public void setCust_name(String Cust_name) {
		setAttrVal("Cust_name", Cust_name);
	}
	/**
	 * 合同单位编码
	 * @return String
	 */
	public String getCust_code() {
		return ((String) getAttrVal("Cust_code"));
	}
	/**
	 * 合同单位编码
	 * @param Cust_code
	 */
	public void setCust_code(String Cust_code) {
		setAttrVal("Cust_code", Cust_code);
	}
}