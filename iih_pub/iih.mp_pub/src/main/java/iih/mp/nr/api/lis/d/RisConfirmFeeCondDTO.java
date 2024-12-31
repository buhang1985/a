package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验确费入参 DTO数据 
 * 
 */
public class RisConfirmFeeCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 费用状态
	 * @return String
	 */
	public String getStatus_bl() {
		return ((String) getAttrVal("Status_bl"));
	}
	/**
	 * 费用状态
	 * @param Status_bl
	 */
	public void setStatus_bl(String Status_bl) {
		setAttrVal("Status_bl", Status_bl);
	}
}