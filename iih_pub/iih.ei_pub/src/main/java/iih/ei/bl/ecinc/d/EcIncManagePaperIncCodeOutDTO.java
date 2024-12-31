package iih.ei.bl.ecinc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取纸质票据有效号段出参 DTO数据 
 * 
 */
public class EcIncManagePaperIncCodeOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 电子票据类型
	 * @return String
	 */
	public String getEcinc_type() {
		return ((String) getAttrVal("Ecinc_type"));
	}
	/**
	 * 电子票据类型
	 * @param Ecinc_type
	 */
	public void setEcinc_type(String Ecinc_type) {
		setAttrVal("Ecinc_type", Ecinc_type);
	}
	/**
	 * 电子票据代码
	 * @return String
	 */
	public String getEcinc_code() {
		return ((String) getAttrVal("Ecinc_code"));
	}
	/**
	 * 电子票据代码
	 * @param Ecinc_code
	 */
	public void setEcinc_code(String Ecinc_code) {
		setAttrVal("Ecinc_code", Ecinc_code);
	}
}