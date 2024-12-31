package iih.mp.nr.dto.infusionexedetail.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液医嘱执行明细 DTO数据 
 * 
 */
public class InfusionExeDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 返回错误信息
	 * @return String
	 */
	public String getMessage() {
		return ((String) getAttrVal("Message"));
	}
	/**
	 * 返回错误信息
	 * @param Message
	 */
	public void setMessage(String Message) {
		setAttrVal("Message", Message);
	}
}