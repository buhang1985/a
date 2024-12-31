package iih.sfda.adbd.dto.evfuncdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 事件对应功能节点 DTO数据 
 * 
 */
public class EvFuncDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 事件类型标识
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}
	/**
	 * 事件类型标识
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getName_aer_ev() {
		return ((String) getAttrVal("Name_aer_ev"));
	}
	/**
	 * 事件类型
	 * @param Name_aer_ev
	 */
	public void setName_aer_ev(String Name_aer_ev) {
		setAttrVal("Name_aer_ev", Name_aer_ev);
	}
	/**
	 * 事件类型编码
	 * @return String
	 */
	public String getCode_aer_ev() {
		return ((String) getAttrVal("Code_aer_ev"));
	}
	/**
	 * 事件类型编码
	 * @param Code_aer_ev
	 */
	public void setCode_aer_ev(String Code_aer_ev) {
		setAttrVal("Code_aer_ev", Code_aer_ev);
	}
	/**
	 * 事件分类id
	 * @return String
	 */
	public String getId_aer_ev_ca() {
		return ((String) getAttrVal("Id_aer_ev_ca"));
	}
	/**
	 * 事件分类id
	 * @param Id_aer_ev_ca
	 */
	public void setId_aer_ev_ca(String Id_aer_ev_ca) {
		setAttrVal("Id_aer_ev_ca", Id_aer_ev_ca);
	}
	/**
	 * 事件分类
	 * @return String
	 */
	public String getName_aer_ev_ca() {
		return ((String) getAttrVal("Name_aer_ev_ca"));
	}
	/**
	 * 事件分类
	 * @param Name_aer_ev_ca
	 */
	public void setName_aer_ev_ca(String Name_aer_ev_ca) {
		setAttrVal("Name_aer_ev_ca", Name_aer_ev_ca);
	}
	/**
	 * 事件功能节点id
	 * @return String
	 */
	public String getId_func_ev() {
		return ((String) getAttrVal("Id_func_ev"));
	}
	/**
	 * 事件功能节点id
	 * @param Id_func_ev
	 */
	public void setId_func_ev(String Id_func_ev) {
		setAttrVal("Id_func_ev", Id_func_ev);
	}
	/**
	 * 功能节点名称
	 * @return String
	 */
	public String getName_func_ev() {
		return ((String) getAttrVal("Name_func_ev"));
	}
	/**
	 * 功能节点名称
	 * @param Name_func_ev
	 */
	public void setName_func_ev(String Name_func_ev) {
		setAttrVal("Name_func_ev", Name_func_ev);
	}
	/**
	 * 是否客开
	 * @return FBoolean
	 */
	public FBoolean getFg_custom() {
		return ((FBoolean) getAttrVal("Fg_custom"));
	}
	/**
	 * 是否客开
	 * @param Fg_custom
	 */
	public void setFg_custom(FBoolean Fg_custom) {
		setAttrVal("Fg_custom", Fg_custom);
	}
}