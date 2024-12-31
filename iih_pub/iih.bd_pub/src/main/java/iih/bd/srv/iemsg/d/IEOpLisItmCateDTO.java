package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检验项目DTO DTO数据 
 * 
 */
public class IEOpLisItmCateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE门诊检验项目分组主键标识
	 * @return String
	 */
	public String getId_ieoplisitmcate() {
		return ((String) getAttrVal("Id_ieoplisitmcate"));
	}
	/**
	 * IE门诊检验项目分组主键标识
	 * @param Id_ieoplisitmcate
	 */
	public void setId_ieoplisitmcate(String Id_ieoplisitmcate) {
		setAttrVal("Id_ieoplisitmcate", Id_ieoplisitmcate);
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
	 * 排序码
	 * @return String
	 */
	public String getSort_no() {
		return ((String) getAttrVal("Sort_no"));
	}
	/**
	 * 排序码
	 * @param Sort_no
	 */
	public void setSort_no(String Sort_no) {
		setAttrVal("Sort_no", Sort_no);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 类型编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 类型名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
}