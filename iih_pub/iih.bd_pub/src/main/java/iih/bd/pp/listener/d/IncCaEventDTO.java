package iih.bd.pp.listener.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 账单分类事件DTO DTO数据 
 * 
 */
public class IncCaEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 账单类别编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 账单类别编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 账单类别名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 账单类别名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
}