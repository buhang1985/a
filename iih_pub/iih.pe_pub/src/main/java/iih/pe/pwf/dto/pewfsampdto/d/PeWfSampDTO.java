package iih.pe.pwf.dto.pewfsampdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检流程-标本采集 DTO数据 
 * 
 */
public class PeWfSampDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检标本类型ID
	 * @return String
	 */
	public String getId_pesrvsampleca() {
		return ((String) getAttrVal("Id_pesrvsampleca"));
	}
	/**
	 * 体检标本类型ID
	 * @param Id_pesrvsampleca
	 */
	public void setId_pesrvsampleca(String Id_pesrvsampleca) {
		setAttrVal("Id_pesrvsampleca", Id_pesrvsampleca);
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