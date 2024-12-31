package iih.ei.std.d.v1.ci.ent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 结果DTO DTO数据 
 * 
 */
public class ResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果编码
	 * @return String
	 */
	public String getResultcode() {
		return ((String) getAttrVal("Resultcode"));
	}
	/**
	 * 结果编码
	 * @param Resultcode
	 */
	public void setResultcode(String Resultcode) {
		setAttrVal("Resultcode", Resultcode);
	}
	/**
	 * 提示信息
	 * @return String
	 */
	public String getResultmsg() {
		return ((String) getAttrVal("Resultmsg"));
	}
	/**
	 * 提示信息
	 * @param Resultmsg
	 */
	public void setResultmsg(String Resultmsg) {
		setAttrVal("Resultmsg", Resultmsg);
	}
}