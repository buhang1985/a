package iih.ci.ord.ms.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * MS095处方类别代码消息 DTO数据 
 * 
 */
public class MSUdidocPresTypeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_udidoc() {
		return ((String) getAttrVal("Id_udidoc"));
	}
	/**
	 * 主键
	 * @param Id_udidoc
	 */
	public void setId_udidoc(String Id_udidoc) {
		setAttrVal("Id_udidoc", Id_udidoc);
	}
	/**
	 * 疾病诊断类别编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 疾病诊断类别编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 疾病诊断类别名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 疾病诊断类别名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 版本号
	 * @return String
	 */
	public String getItem_version() {
		return ((String) getAttrVal("Item_version"));
	}
	/**
	 * 版本号
	 * @param Item_version
	 */
	public void setItem_version(String Item_version) {
		setAttrVal("Item_version", Item_version);
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