package iih.mp.nr.dto.mergedsamppridto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本费用对照 DTO数据 
 * 
 */
public class SampPriConstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用对照主键ID
	 * @return String
	 */
	public String getId_samp_pri() {
		return ((String) getAttrVal("Id_samp_pri"));
	}
	/**
	 * 费用对照主键ID
	 * @param Id_samp_pri
	 */
	public void setId_samp_pri(String Id_samp_pri) {
		setAttrVal("Id_samp_pri", Id_samp_pri);
	}
	/**
	 * 费用项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 费用项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 儿童对照项目
	 * @return String
	 */
	public String getId_srv_const() {
		return ((String) getAttrVal("Id_srv_const"));
	}
	/**
	 * 儿童对照项目
	 * @param Id_srv_const
	 */
	public void setId_srv_const(String Id_srv_const) {
		setAttrVal("Id_srv_const", Id_srv_const);
	}
	/**
	 * 儿童项目单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 儿童项目单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
}