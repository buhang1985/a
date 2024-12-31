package iih.pi.dic.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者分类集成平台dto DTO数据 
 * 
 */
public class PiPatCaIEDTO extends BaseDTO {
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
	 * 身份编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 身份编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 身份名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 身份名称
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