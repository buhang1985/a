package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 冠脉造影及介入手术信息(CVIS冠脉造影及介入手术报告的信息) DTO数据 
 * 
 */
public class CvisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getCkitemname() {
		return ((String) getAttrVal("Ckitemname"));
	}
	/**
	 * 检查项目名称
	 * @param Ckitemname
	 */
	public void setCkitemname(String Ckitemname) {
		setAttrVal("Ckitemname", Ckitemname);
	}
	/**
	 * 手术日期
	 * @return FDate
	 */
	public FDate getOperationdate() {
		return ((FDate) getAttrVal("Operationdate"));
	}
	/**
	 * 手术日期
	 * @param Operationdate
	 */
	public void setOperationdate(FDate Operationdate) {
		setAttrVal("Operationdate", Operationdate);
	}
	/**
	 * 手术间编码
	 * @return String
	 */
	public String getOrcode() {
		return ((String) getAttrVal("Orcode"));
	}
	/**
	 * 手术间编码
	 * @param Orcode
	 */
	public void setOrcode(String Orcode) {
		setAttrVal("Orcode", Orcode);
	}
	/**
	 * 手术间名称
	 * @return String
	 */
	public String getOrname() {
		return ((String) getAttrVal("Orname"));
	}
	/**
	 * 手术间名称
	 * @param Orname
	 */
	public void setOrname(String Orname) {
		setAttrVal("Orname", Orname);
	}
	/**
	 * 术者信息
	 * @return FArrayList
	 */
	public FArrayList getOperator() {
		return ((FArrayList) getAttrVal("Operator"));
	}
	/**
	 * 术者信息
	 * @param Operator
	 */
	public void setOperator(FArrayList Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 助手信息
	 * @return FArrayList
	 */
	public FArrayList getAssistant() {
		return ((FArrayList) getAttrVal("Assistant"));
	}
	/**
	 * 助手信息
	 * @param Assistant
	 */
	public void setAssistant(FArrayList Assistant) {
		setAttrVal("Assistant", Assistant);
	}
	/**
	 * 报告上各项信息(如果不能结构化，则填写到不能够与项目对应的客观所见部分)
	 * @return FArrayList
	 */
	public FArrayList getRptitem() {
		return ((FArrayList) getAttrVal("Rptitem"));
	}
	/**
	 * 报告上各项信息(如果不能结构化，则填写到不能够与项目对应的客观所见部分)
	 * @param Rptitem
	 */
	public void setRptitem(FArrayList Rptitem) {
		setAttrVal("Rptitem", Rptitem);
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