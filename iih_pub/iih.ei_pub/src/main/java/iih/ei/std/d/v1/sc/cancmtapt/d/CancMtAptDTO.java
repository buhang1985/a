package iih.ei.std.d.v1.sc.cancmtapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取消预约 DTO数据 
 * 
 */
public class CancMtAptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 结果编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 结果日志
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}	
	/**
	 * 结果日志
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
}