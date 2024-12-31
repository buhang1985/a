package iih.mp.nr.api.obsqpply.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查确费出参 DTO数据 
 * 
 */
public class ObsConfirmFeeRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果类型
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 结果类型
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 异常信息
	 * @return String
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}
	/**
	 * 异常信息
	 * @param Message
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}
}