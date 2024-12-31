package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 仪器或医生客观所见信息 DTO数据 
 * 
 */
public class ObjectiveObservationDTO extends BaseDTO {
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
	 * 项目结果值文本
	 * @return String
	 */
	public String getItemresult() {
		return ((String) getAttrVal("Itemresult"));
	}
	/**
	 * 项目结果值文本
	 * @param Itemresult
	 */
	public void setItemresult(String Itemresult) {
		setAttrVal("Itemresult", Itemresult);
	}
	/**
	 * 子项目具体信息
	 * @return FArrayList
	 */
	public FArrayList getSubitem() {
		return ((FArrayList) getAttrVal("Subitem"));
	}
	/**
	 * 子项目具体信息
	 * @param Subitem
	 */
	public void setSubitem(FArrayList Subitem) {
		setAttrVal("Subitem", Subitem);
	}
	/**
	 * 检查类型编码
	 * @return String
	 */
	public String getCktypecode() {
		return ((String) getAttrVal("Cktypecode"));
	}
	/**
	 * 检查类型编码
	 * @param Cktypecode
	 */
	public void setCktypecode(String Cktypecode) {
		setAttrVal("Cktypecode", Cktypecode);
	}
}