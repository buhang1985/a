package iih.nm.nqm.dto.nqmchktable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 值数据源类型 DTO数据 
 * 
 */
public class ValueDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 选项id
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 选项id
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 选项编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 选项编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 选项名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 选项名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 分值
	 * @return FDouble
	 */
	public FDouble getValue() {
		return ((FDouble) getAttrVal("Value"));
	}
	/**
	 * 分值
	 * @param Value
	 */
	public void setValue(FDouble Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 权重
	 * @return FDouble
	 */
	public FDouble getWi() {
		return ((FDouble) getAttrVal("Wi"));
	}
	/**
	 * 权重
	 * @param Wi
	 */
	public void setWi(FDouble Wi) {
		setAttrVal("Wi", Wi);
	}
	/**
	 * 百分比
	 * @return FDouble
	 */
	public FDouble getPct() {
		return ((FDouble) getAttrVal("Pct"));
	}
	/**
	 * 百分比
	 * @param Pct
	 */
	public void setPct(FDouble Pct) {
		setAttrVal("Pct", Pct);
	}
}