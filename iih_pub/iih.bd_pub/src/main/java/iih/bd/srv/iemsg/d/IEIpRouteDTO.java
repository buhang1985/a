package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE住院给药途径DTO DTO数据 
 * 
 */
public class IEIpRouteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE住院给药途径主键标识
	 * @return String
	 */
	public String getId_ieiproute() {
		return ((String) getAttrVal("Id_ieiproute"));
	}
	/**
	 * IE住院给药途径主键标识
	 * @param Id_ieiproute
	 */
	public void setId_ieiproute(String Id_ieiproute) {
		setAttrVal("Id_ieiproute", Id_ieiproute);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 用药途径编码
	 * @return String
	 */
	public String getSupply_code() {
		return ((String) getAttrVal("Supply_code"));
	}
	/**
	 * 用药途径编码
	 * @param Supply_code
	 */
	public void setSupply_code(String Supply_code) {
		setAttrVal("Supply_code", Supply_code);
	}
	/**
	 * 用药途径名称
	 * @return String
	 */
	public String getSupply_name() {
		return ((String) getAttrVal("Supply_name"));
	}
	/**
	 * 用药途径名称
	 * @param Supply_name
	 */
	public void setSupply_name(String Supply_name) {
		setAttrVal("Supply_name", Supply_name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 版本号
	 * @return String
	 */
	public String getItemversion() {
		return ((String) getAttrVal("Itemversion"));
	}
	/**
	 * 版本号
	 * @param Itemversion
	 */
	public void setItemversion(String Itemversion) {
		setAttrVal("Itemversion", Itemversion);
	}
	/**
	 * 编码值
	 * @return String
	 */
	public String getCodevalue() {
		return ((String) getAttrVal("Codevalue"));
	}
	/**
	 * 编码值
	 * @param Codevalue
	 */
	public void setCodevalue(String Codevalue) {
		setAttrVal("Codevalue", Codevalue);
	}
	/**
	 * 停用标志
	 * @return String
	 */
	public String getStopflag() {
		return ((String) getAttrVal("Stopflag"));
	}
	/**
	 * 停用标志
	 * @param Stopflag
	 */
	public void setStopflag(String Stopflag) {
		setAttrVal("Stopflag", Stopflag);
	}
}