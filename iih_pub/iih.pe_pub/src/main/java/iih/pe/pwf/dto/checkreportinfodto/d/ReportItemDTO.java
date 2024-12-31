package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 报告上各项信息(如果不能结构化，则填写到不能够与项目对应的客观所见部分) DTO数据 
 * 
 */
public class ReportItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 项目名称
	 * @return String
	 */
	public String getItemname() {
		return ((String) getAttrVal("Itemname"));
	}
	/**
	 * 项目名称
	 * @param Itemname
	 */
	public void setItemname(String Itemname) {
		setAttrVal("Itemname", Itemname);
	}
	/**
	 * 项目值文本
	 * @return String
	 */
	public String getItemvalue() {
		return ((String) getAttrVal("Itemvalue"));
	}
	/**
	 * 项目值文本
	 * @param Itemvalue
	 */
	public void setItemvalue(String Itemvalue) {
		setAttrVal("Itemvalue", Itemvalue);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getCkitemcode() {
		return ((String) getAttrVal("Ckitemcode"));
	}
	/**
	 * 检查项目编码
	 * @param Ckitemcode
	 */
	public void setCkitemcode(String Ckitemcode) {
		setAttrVal("Ckitemcode", Ckitemcode);
	}
}