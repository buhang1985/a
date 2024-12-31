package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE住院医嘱类型DTO DTO数据 
 * 
 */
public class IEIpOrCateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE住院医嘱类型主键标识
	 * @return String
	 */
	public String getId_ieiporcate() {
		return ((String) getAttrVal("Id_ieiporcate"));
	}
	/**
	 * IE住院医嘱类型主键标识
	 * @param Id_ieiporcate
	 */
	public void setId_ieiporcate(String Id_ieiporcate) {
		setAttrVal("Id_ieiporcate", Id_ieiporcate);
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
	 * 医嘱类型编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 医嘱类型编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医嘱类型名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医嘱类型名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 打印方式
	 * @return String
	 */
	public String getPrintmode() {
		return ((String) getAttrVal("Printmode"));
	}
	/**
	 * 打印方式
	 * @param Printmode
	 */
	public void setPrintmode(String Printmode) {
		setAttrVal("Printmode", Printmode);
	}
	/**
	 * 是否打印
	 * @return String
	 */
	public String getOrderprint() {
		return ((String) getAttrVal("Orderprint"));
	}
	/**
	 * 是否打印
	 * @param Orderprint
	 */
	public void setOrderprint(String Orderprint) {
		setAttrVal("Orderprint", Orderprint);
	}
	/**
	 * 费用标志
	 * @return String
	 */
	public String getMemo_string() {
		return ((String) getAttrVal("Memo_string"));
	}
	/**
	 * 费用标志
	 * @param Memo_string
	 */
	public void setMemo_string(String Memo_string) {
		setAttrVal("Memo_string", Memo_string);
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