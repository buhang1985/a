package iih.ei.std.d.v1.pis.pisreturn.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信公众号-返回调用结果 DTO数据 
 * 
 */
public class PisReturnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 消息
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 消息
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
}