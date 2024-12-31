package iih.pe.pqry.pedisagedisrpt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检疾病年龄分布 DTO数据 
 * 
 */
public class PeDisAgeDisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge_psn() {
		return ((String) getAttrVal("Age_psn"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge_psn(String Age_psn) {
		setAttrVal("Age_psn", Age_psn);
	}
	/**
	 * 比例
	 * @return String
	 */
	public String getScale() {
		return ((String) getAttrVal("Scale"));
	}
	/**
	 * 比例
	 * @param Scale
	 */
	public void setScale(String Scale) {
		setAttrVal("Scale", Scale);
	}
}