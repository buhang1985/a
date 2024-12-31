package iih.ei.std.d.v1.mp.wribackskintestresult.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试结果返回参数 DTO数据 
 * 
 */
public class ReturnParamsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 0: 成功  非0：错误
	 * @return Integer
	 */
	public Integer getCode() {
		return ((Integer) getAttrVal("Code"));
	}
	/**
	 * 0: 成功  非0：错误
	 * @param Code
	 */
	public void setCode(Integer Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 错误消息
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 错误消息
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
}