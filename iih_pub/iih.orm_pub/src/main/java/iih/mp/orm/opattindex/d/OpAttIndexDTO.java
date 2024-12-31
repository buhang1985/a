package iih.mp.orm.opattindex.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术关注指标 DTO数据 
 * 
 */
public class OpAttIndexDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 项目
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getResult() {
		return ((String) getAttrVal("Result"));
	}
	/**
	 * 结果
	 * @param Result
	 */
	public void setResult(String Result) {
		setAttrVal("Result", Result);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit_name() {
		return ((String) getAttrVal("Unit_name"));
	}
	/**
	 * 单位
	 * @param Unit_name
	 */
	public void setUnit_name(String Unit_name) {
		setAttrVal("Unit_name", Unit_name);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getReference() {
		return ((String) getAttrVal("Reference"));
	}
	/**
	 * 参考值
	 * @param Reference
	 */
	public void setReference(String Reference) {
		setAttrVal("Reference", Reference);
	}
}