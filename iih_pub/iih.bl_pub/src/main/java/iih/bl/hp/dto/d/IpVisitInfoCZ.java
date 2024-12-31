package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 登记信息冲正dto DTO数据 
 * 
 */
public class IpVisitInfoCZ extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发送方撤销交易流水号
	 * @return String
	 */
	public String getCanctradeno() {
		return ((String) getAttrVal("Canctradeno"));
	}
	/**
	 * 发送方撤销交易流水号
	 * @param Canctradeno
	 */
	public void setCanctradeno(String Canctradeno) {
		setAttrVal("Canctradeno", Canctradeno);
	}
	/**
	 * 经办人名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 经办人名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
}