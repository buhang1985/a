package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_诊断建议 DTO数据 
 * 
 */
public class Pe3rdDiagDTO extends BaseDTO {
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
	 * 诊断
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}
	/**
	 * 诊断
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getSugg() {
		return ((String) getAttrVal("Sugg"));
	}
	/**
	 * 建议
	 * @param Sugg
	 */
	public void setSugg(String Sugg) {
		setAttrVal("Sugg", Sugg);
	}
	/**
	 * 分类编码
	 * @return String
	 */
	public String getCode_class() {
		return ((String) getAttrVal("Code_class"));
	}
	/**
	 * 分类编码
	 * @param Code_class
	 */
	public void setCode_class(String Code_class) {
		setAttrVal("Code_class", Code_class);
	}
	/**
	 * 关联检索码
	 * @return String
	 */
	public String getCode_index() {
		return ((String) getAttrVal("Code_index"));
	}
	/**
	 * 关联检索码
	 * @param Code_index
	 */
	public void setCode_index(String Code_index) {
		setAttrVal("Code_index", Code_index);
	}
}