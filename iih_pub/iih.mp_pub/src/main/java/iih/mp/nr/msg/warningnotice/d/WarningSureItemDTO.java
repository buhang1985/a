package iih.mp.nr.msg.warningnotice.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预警信息返回信息细目 DTO数据 
 * 
 */
public class WarningSureItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回结果代码
	 * @return String
	 */
	public String getItemcode() {
		return ((String) getAttrVal("Itemcode"));
	}
	/**
	 * 返回结果代码
	 * @param Itemcode
	 */
	public void setItemcode(String Itemcode) {
		setAttrVal("Itemcode", Itemcode);
	}
	/**
	 * 返回结果项目
	 * @return String
	 */
	public String getItemname() {
		return ((String) getAttrVal("Itemname"));
	}
	/**
	 * 返回结果项目
	 * @param Itemname
	 */
	public void setItemname(String Itemname) {
		setAttrVal("Itemname", Itemname);
	}
	/**
	 * 返回结果项目值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 返回结果项目值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
}