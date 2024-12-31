package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 术者信息 DTO数据 
 * 
 */
public class OperatorDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 术者编码
	 * @return String
	 */
	public String getOperatorcode() {
		return ((String) getAttrVal("Operatorcode"));
	}
	/**
	 * 术者编码
	 * @param Operatorcode
	 */
	public void setOperatorcode(String Operatorcode) {
		setAttrVal("Operatorcode", Operatorcode);
	}
	/**
	 * 术者名称
	 * @return String
	 */
	public String getOperatorname() {
		return ((String) getAttrVal("Operatorname"));
	}
	/**
	 * 术者名称
	 * @param Operatorname
	 */
	public void setOperatorname(String Operatorname) {
		setAttrVal("Operatorname", Operatorname);
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