package iih.bd.pp.listener.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 支付方式事件DTO DTO数据 
 * 
 */
public class PriPmEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作类型
	 * @return String
	 */
	public String getOper_type() {
		return ((String) getAttrVal("Oper_type"));
	}
	/**
	 * 操作类型
	 * @param Oper_type
	 */
	public void setOper_type(String Oper_type) {
		setAttrVal("Oper_type", Oper_type);
	}
	/**
	 * 支付方式编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}
	/**
	 * 支付方式编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 支付方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 标准码
	 * @return String
	 */
	public String getBzcode() {
		return ((String) getAttrVal("Bzcode"));
	}
	/**
	 * 标准码
	 * @param Bzcode
	 */
	public void setBzcode(String Bzcode) {
		setAttrVal("Bzcode", Bzcode);
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
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 停用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}