package iih.bd.fc.orpltpfunparam.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 闭环功能节点匹配参数 DTO数据 
 * 
 */
public class OrpltpFunDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 闭环类型
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环类型
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 功能节点
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能节点
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 操作
	 * @return String
	 */
	public String getOper_code() {
		return ((String) getAttrVal("Oper_code"));
	}
	/**
	 * 操作
	 * @param Oper_code
	 */
	public void setOper_code(String Oper_code) {
		setAttrVal("Oper_code", Oper_code);
	}
}