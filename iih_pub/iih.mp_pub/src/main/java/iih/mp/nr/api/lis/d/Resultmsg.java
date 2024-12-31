package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Lis接口异常信息DTO DTO数据 
 * 
 */
public class Resultmsg extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 异常编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 异常描述
	 * @return String
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}
	/**
	 * 异常描述
	 * @param Message
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}
}