package iih.ci.preop.ems.d.b;

import xap.mw.core.data.FArrayList;
import iih.ci.preop.order.d.OrderListViewDTO;

public class BasePreOpEmsViewDTO extends OrderListViewDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 治疗方案ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}
	/**
	 * 治疗方案ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 服务明细ID
	 * @return String
	 */
	public String getId_srv_items() {
		return ((String) getAttrVal("Id_srv_items"));
	}
	/**
	 * 服务明细ID
	 * @param Id_srv_items
	 */
	public void setId_srv_items(String Id_srv_items) {
		setAttrVal("Id_srv_items", Id_srv_items);
	}
	/**
	 * 服务明细名称
	 * @return String
	 */
	public String getName_srv_items() {
		return ((String) getAttrVal("Name_srv_items"));
	}
	/**
	 * 服务明细名称
	 * @param Name_srv_items
	 */
	public void setName_srv_items(String Name_srv_items) {
		setAttrVal("Name_srv_items", Name_srv_items);
	}
	/**
	 * 套内项目
	 * @return EmsSetItemList
	 */
	public FArrayList getEmsSetItemList() {
		return ((FArrayList) getAttrVal("EmsSetItemList"));
	}
	/**
	 * 套内项目
	 * @param EmsSetItemList
	 */
	public void setEmsSetItemList(FArrayList EmsSetItemList) {
		setAttrVal("EmsSetItemList", EmsSetItemList);
	}
	/**
	 * 当前诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 当前诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 当前诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 当前诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 当前诊断明细ID
	 * @return String
	 */
	public String getId_diitem() {
		return ((String) getAttrVal("Id_diitem"));
	}
	/**
	 * 当前诊断明细ID
	 * @param Id_diitem
	 */
	public void setId_diitem(String Id_diitem) {
		setAttrVal("Id_diitem", Id_diitem);
	}
	/**
	 * 当前诊断明细名称
	 * @return String
	 */
	public String getName_diitem() {
		return ((String) getAttrVal("Name_diitem"));
	}
	/**
	 * 当前诊断明细名称
	 * @param Name_diitem
	 */
	public void setName_diitem(String Name_diitem) {
		setAttrVal("Name_diitem", Name_diitem);
	}	
}
