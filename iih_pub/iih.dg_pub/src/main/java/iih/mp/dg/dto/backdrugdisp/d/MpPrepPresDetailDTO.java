package iih.mp.dg.dto.backdrugdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药明细 DTO数据 
 * 
 */
public class MpPrepPresDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_orsrv() {
		return ((String) getAttrVal("Name_orsrv"));
	}
	/**
	 * 服务名称
	 * @param Name_orsrv
	 */
	public void setName_orsrv(String Name_orsrv) {
		setAttrVal("Name_orsrv", Name_orsrv);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 批号
	 * @return String
	 */
	public String getBatno() {
		return ((String) getAttrVal("Batno"));
	}
	/**
	 * 批号
	 * @param Batno
	 */
	public void setBatno(String Batno) {
		setAttrVal("Batno", Batno);
	}
	/**
	 * 厂商名称
	 * @return String
	 */
	public String getName_factory() {
		return ((String) getAttrVal("Name_factory"));
	}
	/**
	 * 厂商名称
	 * @param Name_factory
	 */
	public void setName_factory(String Name_factory) {
		setAttrVal("Name_factory", Name_factory);
	}
	/**
	 * OTC标识
	 * @return String
	 */
	public String getFg_otc() {
		return ((String) getAttrVal("Fg_otc"));
	}
	/**
	 * OTC标识
	 * @param Fg_otc
	 */
	public void setFg_otc(String Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单次剂量
	 * @return String
	 */
	public String getSingle_med() {
		return ((String) getAttrVal("Single_med"));
	}
	/**
	 * 单次剂量
	 * @param Single_med
	 */
	public void setSingle_med(String Single_med) {
		setAttrVal("Single_med", Single_med);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
}