package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预住院查询条件 DTO数据 
 * 
 */
public class IppreQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 病区id
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 查询sql
	 * @return String
	 */
	public String getSqlval() {
		return ((String) getAttrVal("Sqlval"));
	}
	/**
	 * 查询sql
	 * @param Sqlval
	 */
	public void setSqlval(String Sqlval) {
		setAttrVal("Sqlval", Sqlval);
	}
	/**
	 * 患者状态过滤
	 * @return String
	 */
	public String getPatstatusfilter() {
		return ((String) getAttrVal("Patstatusfilter"));
	}
	/**
	 * 患者状态过滤
	 * @param Patstatusfilter
	 */
	public void setPatstatusfilter(String Patstatusfilter) {
		setAttrVal("Patstatusfilter", Patstatusfilter);
	}
}