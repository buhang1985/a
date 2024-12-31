package iih.ei.std.d.v1.en.cancapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取消预约入参DTO DTO数据 
 * 
 */
public class CancAptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}	
	/**
	 * 操作员
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
}