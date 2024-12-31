package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 子项目具体信息 DTO数据 
 * 
 */
public class SubItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 子项目编码
	 * @return String
	 */
	public String getSubitemcode() {
		return ((String) getAttrVal("Subitemcode"));
	}
	/**
	 * 子项目编码
	 * @param Subitemcode
	 */
	public void setSubitemcode(String Subitemcode) {
		setAttrVal("Subitemcode", Subitemcode);
	}
	/**
	 * 子项目名称
	 * @return String
	 */
	public String getSubitemname() {
		return ((String) getAttrVal("Subitemname"));
	}
	/**
	 * 子项目名称
	 * @param Subitemname
	 */
	public void setSubitemname(String Subitemname) {
		setAttrVal("Subitemname", Subitemname);
	}
	/**
	 * 子项目结果值文本
	 * @return String
	 */
	public String getSubitemresult() {
		return ((String) getAttrVal("Subitemresult"));
	}
	/**
	 * 子项目结果值文本
	 * @param Subitemresult
	 */
	public void setSubitemresult(String Subitemresult) {
		setAttrVal("Subitemresult", Subitemresult);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getItemcode() {
		return ((String) getAttrVal("Itemcode"));
	}
	/**
	 * 项目编码
	 * @param Itemcode
	 */
	public void setItemcode(String Itemcode) {
		setAttrVal("Itemcode", Itemcode);
	}
}