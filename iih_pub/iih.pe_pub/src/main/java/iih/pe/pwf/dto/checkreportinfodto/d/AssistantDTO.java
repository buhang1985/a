package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 助手信息 DTO数据 
 * 
 */
public class AssistantDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 助手编码
	 * @return String
	 */
	public String getAsststantcode() {
		return ((String) getAttrVal("Asststantcode"));
	}
	/**
	 * 助手编码
	 * @param Asststantcode
	 */
	public void setAsststantcode(String Asststantcode) {
		setAttrVal("Asststantcode", Asststantcode);
	}
	/**
	 * 助手名称
	 * @return String
	 */
	public String getAssistantname() {
		return ((String) getAttrVal("Assistantname"));
	}
	/**
	 * 助手名称
	 * @param Assistantname
	 */
	public void setAssistantname(String Assistantname) {
		setAttrVal("Assistantname", Assistantname);
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