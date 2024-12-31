package iih.ci.ord.i.external.provide.meta.bl;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 记账/销账医嘱数据对象
 * 
 * @author HUMS
 *
 */
public class OrderAccountDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * 医嘱主键
	 * 
	 * @return
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	/**
	 * 医嘱主键
	 * 
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 科研标识
	 * @return
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}
	/**
	 * 科研标识
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	
	/**
	 * 记账类型（预交金记账、高端商保记账、科研记账）
	 * 
	 * @return
	 */
	public String getAccount_type() {
		return ((String) getAttrVal("Account_type"));
	}

	/**
	 * 记账类型（预交金记账、高端商保记账、科研记账）
	 * 
	 * @param Account_type
	 */
	public void setAccount_type(String Account_type) {
		setAttrVal("Account_type", Account_type);
	}

	/**
	 * 是否允许记账/销账
	 * 
	 * @return
	 */
	public FBoolean getFg_allowed_account() {
		return ((FBoolean) getAttrVal("Fg_allowed_account"));
	}

	/**
	 * 是否允许记账/销账
	 * 
	 * @param Fg_allowed_account
	 */
	public void setFg_allowed_account(FBoolean Fg_allowed_account) {
		setAttrVal("Fg_allowed_account", Fg_allowed_account);
	}

	/**
	 * 不允许记账/销账信息
	 * 
	 * @return
	 */
	public String getMessageInfo() {
		return ((String) getAttrVal("MessageInfo"));
	}

	/**
	 * 不允许记账/销账信息
	 * 
	 * @param 信息
	 */
	public void setMessageInfo(String MessageInfo) {
		setAttrVal("MessageInfo", MessageInfo);
	}
}
