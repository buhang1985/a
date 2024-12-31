package iih.pe.pitm.dto.pesdlanlingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_规则明细 DTO数据 
 * 
 */
public class Pe3rdRulesDtlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 规则编码
	 * @return String
	 */
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}
	/**
	 * 规则编码
	 * @param Code_rule
	 */
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	/**
	 * 编码ID
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码ID
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 左括号
	 * @return String
	 */
	public String getLeft_bracket() {
		return ((String) getAttrVal("Left_bracket"));
	}
	/**
	 * 左括号
	 * @param Left_bracket
	 */
	public void setLeft_bracket(String Left_bracket) {
		setAttrVal("Left_bracket", Left_bracket);
	}
	/**
	 * 结果编码
	 * @return String
	 */
	public String getOperand() {
		return ((String) getAttrVal("Operand"));
	}
	/**
	 * 结果编码
	 * @param Operand
	 */
	public void setOperand(String Operand) {
		setAttrVal("Operand", Operand);
	}
	/**
	 * 操作符
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作符
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 关键字
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 关键字
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 右括号
	 * @return String
	 */
	public String getRight_bracket() {
		return ((String) getAttrVal("Right_bracket"));
	}
	/**
	 * 右括号
	 * @param Right_bracket
	 */
	public void setRight_bracket(String Right_bracket) {
		setAttrVal("Right_bracket", Right_bracket);
	}
	/**
	 * 逻辑操作符
	 * @return String
	 */
	public String getLogic_operator() {
		return ((String) getAttrVal("Logic_operator"));
	}
	/**
	 * 逻辑操作符
	 * @param Logic_operator
	 */
	public void setLogic_operator(String Logic_operator) {
		setAttrVal("Logic_operator", Logic_operator);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 项目结果编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}
	/**
	 * 项目结果编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
}