package iih.ci.ord.dto.ems;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class EmsDrugCreatParamDTO extends BaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 服务Ids
	 * @return FArrayList
	 */
	public FArrayList getId_srvs() {
		return ((FArrayList) getAttrVal("Id_srvs"));
	}
	/**
	 * 服务Id
	 * @param Id_srv
	 */
	public void setId_srvs(FArrayList Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 物品Id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品Id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 用法Id
	 * @return Id_route
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 服务Id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 长临标识
	 * @return Fg_long
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}

	/**
	 * 总量单位
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量单位
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 总量单位Id
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 总量单位Id
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 加急标识
	 * @return Fg_urgent
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param FBoolean
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 领药方式id
	 * @return Id_drugdeliverymethod
	 */
	public String getId_drugdeliverymethod() {
		return ((String) getAttrVal("Id_drugdeliverymethod"));
	}
	/**
	 * 领药方式id
	 * @param String
	 */
	public void setId_drugdeliverymethod(String Id_drugdeliverymethod) {
		setAttrVal("Id_drugdeliverymethod", Id_drugdeliverymethod);
	}
	/**
	 * 领药方式编
	 * @return Sd_drugdeliverymethod
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}
	/**
	 * 领药方式编码
	 * @param String
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
	/**
	 * 领药方式名称
	 * @return Name_drugdeliverymethod
	 */
	public String getName_drugdeliverymethod() {
		return ((String) getAttrVal("Name_drugdeliverymethod"));
	}
	/**
	 * 领药方式名称
	 * @param String
	 */
	public void setName_drugdeliverymethod(String Name_drugdeliverymethod) {
		setAttrVal("Name_drugdeliverymethod", Name_drugdeliverymethod);
	}
}
