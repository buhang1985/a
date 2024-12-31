package iih.ci.preop.ems.d;

import iih.ci.ems.b.BaseOrderListViewDTO;
import xap.mw.coreitf.d.FDateTime;

/**
 * 空医疗单 DTO数据 
 * 
 */
public class EmptyEmsViewDTO extends BaseOrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Name_srv
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 处置明细名称
	 * @return String
	 */
	public String getName_srv_items() {
		return ((String) getAttrVal("Name_srv_items"));
	}
	/**
	 * 处置明细名称
	 * @param Name_srv_items
	 */
	public void setName_srv_items(String Name_srv_items) {
		setAttrVal("Name_srv_items", Name_srv_items);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 标本采集时间
	 * @return FDateTime
	 */
	public FDateTime getDt_samp() {
		return ((FDateTime) getAttrVal("Dt_samp"));
	}
	/**
	 * 标本采集时间
	 * @param Dt_samp
	 */
	public void setDt_samp(FDateTime Dt_samp) {
		setAttrVal("Dt_samp", Dt_samp);
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