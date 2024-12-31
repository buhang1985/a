package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_结果诊断关联 DTO数据 
 * 
 */
public class Pe3rdResultClassDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结果编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}
	/**
	 * 结果编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 类别编码
	 * @return String
	 */
	public String getCode_class() {
		return ((String) getAttrVal("Code_class"));
	}
	/**
	 * 类别编码
	 * @param Code_class
	 */
	public void setCode_class(String Code_class) {
		setAttrVal("Code_class", Code_class);
	}
}