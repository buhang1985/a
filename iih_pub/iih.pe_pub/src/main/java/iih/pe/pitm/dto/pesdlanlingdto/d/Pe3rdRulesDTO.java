package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_规则 DTO数据 
 * 
 */
public class Pe3rdRulesDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 规则编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 规则编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 规则名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 检索码
	 * @return String
	 */
	public String getCode_index() {
		return ((String) getAttrVal("Code_index"));
	}
	/**
	 * 检索码
	 * @param Code_index
	 */
	public void setCode_index(String Code_index) {
		setAttrVal("Code_index", Code_index);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}
	/**
	 * 科室
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
}