package iih.mp.dg.dto.ipcheck.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 库存校验dto DTO数据 
 * 
 */
public class StockCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 逻辑主键
	 * @return String
	 */
	public String getId_logic() {
		return ((String) getAttrVal("Id_logic"));
	}
	/**
	 * 逻辑主键
	 * @param Id_logic
	 */
	public void setId_logic(String Id_logic) {
		setAttrVal("Id_logic", Id_logic);
	}
	/**
	 * 医嘱服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 请领科室
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂家
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 请领单位
	 * @return String
	 */
	public String getId_pkgu_ap() {
		return ((String) getAttrVal("Id_pkgu_ap"));
	}
	/**
	 * 请领单位
	 * @param Id_pkgu_ap
	 */
	public void setId_pkgu_ap(String Id_pkgu_ap) {
		setAttrVal("Id_pkgu_ap", Id_pkgu_ap);
	}
	/**
	 * 基本单位
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}
	/**
	 * 基本单位
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 当前单位
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 当前单位
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 当前单位名称
	 * @return String
	 */
	public String getPkgcur_name() {
		return ((String) getAttrVal("Pkgcur_name"));
	}
	/**
	 * 当前单位名称
	 * @param Pkgcur_name
	 */
	public void setPkgcur_name(String Pkgcur_name) {
		setAttrVal("Pkgcur_name", Pkgcur_name);
	}
	/**
	 * 基本和当前单转换率
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 基本和当前单转换率
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 请领数量
	 * @return FDouble
	 */
	public FDouble getQuan_ap() {
		return ((FDouble) getAttrVal("Quan_ap"));
	}
	/**
	 * 请领数量
	 * @param Quan_ap
	 */
	public void setQuan_ap(FDouble Quan_ap) {
		setAttrVal("Quan_ap", Quan_ap);
	}
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getEn_su() {
		return ((Integer) getAttrVal("En_su"));
	}
	/**
	 * 状态
	 * @param En_su
	 */
	public void setEn_su(Integer En_su) {
		setAttrVal("En_su", En_su);
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
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 库存量
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 库存量
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 总用量
	 * @return FDouble
	 */
	public FDouble getQuan_ap_sum() {
		return ((FDouble) getAttrVal("Quan_ap_sum"));
	}
	/**
	 * 总用量
	 * @param Quan_ap_sum
	 */
	public void setQuan_ap_sum(FDouble Quan_ap_sum) {
		setAttrVal("Quan_ap_sum", Quan_ap_sum);
	}
	/**
	 * 差量
	 * @return FDouble
	 */
	public FDouble getQuan_diff() {
		return ((FDouble) getAttrVal("Quan_diff"));
	}
	/**
	 * 差量
	 * @param Quan_diff
	 */
	public void setQuan_diff(FDouble Quan_diff) {
		setAttrVal("Quan_diff", Quan_diff);
	}
}