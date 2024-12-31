package iih.pi.reg.dto.adminarea.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 区县查询条件 DTO数据 
 * 
 */
public class PiAdminAreaQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 区县编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 区县编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
}