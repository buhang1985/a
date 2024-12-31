package iih.pe.pwf.dto.pewfoptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检流程-选项 DTO数据 
 * 
 */
public class PeWfOptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检流程选项定义ID
	 * @return String
	 */
	public String getId_pewfoptiondef() {
		return ((String) getAttrVal("Id_pewfoptiondef"));
	}
	/**
	 * 体检流程选项定义ID
	 * @param Id_pewfoptiondef
	 */
	public void setId_pewfoptiondef(String Id_pewfoptiondef) {
		setAttrVal("Id_pewfoptiondef", Id_pewfoptiondef);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
}