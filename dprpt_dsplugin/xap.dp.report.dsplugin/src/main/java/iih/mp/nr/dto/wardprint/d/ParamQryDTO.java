package iih.mp.nr.dto.wardprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 参数查询DTO DTO数据 
 * 
 */
public class ParamQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 参数组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 参数组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 参数编码
	 * @return String
	 */
	public String getParam_code() {
		return ((String) getAttrVal("Param_code"));
	}
	/**
	 * 参数编码
	 * @param Param_code
	 */
	public void setParam_code(String Param_code) {
		setAttrVal("Param_code", Param_code);
	}
	/**
	 * 参数值
	 * @return FBoolean
	 */
	public FBoolean getParam_value() {
		return ((FBoolean) getAttrVal("Param_value"));
	}
	/**
	 * 参数值
	 * @param Param_value
	 */
	public void setParam_value(FBoolean Param_value) {
		setAttrVal("Param_value", Param_value);
	}
}