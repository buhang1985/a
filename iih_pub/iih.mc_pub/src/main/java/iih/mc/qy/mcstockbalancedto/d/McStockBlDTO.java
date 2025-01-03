package iih.mc.qy.mcstockbalancedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 耗材结存查询dto DTO数据 
 * 
 */
public class McStockBlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
	}
	/**
	 * 仓库id
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}
	/**
	 * 仓库id
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 物品分类名称
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}
	/**
	 * 物品分类名称
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 有效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}
	/**
	 * 有效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 基本包装单位主键
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}
	/**
	 * 基本包装单位主键
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getPkgbase_name() {
		return ((String) getAttrVal("Pkgbase_name"));
	}
	/**
	 * 基本包装单位名称
	 * @param Pkgbase_name
	 */
	public void setPkgbase_name(String Pkgbase_name) {
		setAttrVal("Pkgbase_name", Pkgbase_name);
	}
	/**
	 * 售价
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}
	/**
	 * 售价
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 进价
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}
	/**
	 * 进价
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 结存数量
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 结存数量
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 预留数量
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}
	/**
	 * 预留数量
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 可用数量
	 * @return FDouble
	 */
	public FDouble getQuan_usable() {
		return ((FDouble) getAttrVal("Quan_usable"));
	}
	/**
	 * 可用数量
	 * @param Quan_usable
	 */
	public void setQuan_usable(FDouble Quan_usable) {
		setAttrVal("Quan_usable", Quan_usable);
	}
	/**
	 * 最低存储
	 * @return FDouble
	 */
	public FDouble getLownum() {
		return ((FDouble) getAttrVal("Lownum"));
	}
	/**
	 * 最低存储
	 * @param Lownum
	 */
	public void setLownum(FDouble Lownum) {
		setAttrVal("Lownum", Lownum);
	}
	/**
	 * 警告标示
	 * @return String
	 */
	public String getSd_warn() {
		return ((String) getAttrVal("Sd_warn"));
	}
	/**
	 * 警告标示
	 * @param Sd_warn
	 */
	public void setSd_warn(String Sd_warn) {
		setAttrVal("Sd_warn", Sd_warn);
	}
	/**
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 供应商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 供应商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getId_sup_fac() {
		return ((String) getAttrVal("Id_sup_fac"));
	}
	/**
	 * 生产厂商
	 * @param Id_sup_fac
	 */
	public void setId_sup_fac(String Id_sup_fac) {
		setAttrVal("Id_sup_fac", Id_sup_fac);
	}
	/**
	 * 生产厂商名称
	 * @return String
	 */
	public String getSup_fac_name() {
		return ((String) getAttrVal("Sup_fac_name"));
	}
	/**
	 * 生产厂商名称
	 * @param Sup_fac_name
	 */
	public void setSup_fac_name(String Sup_fac_name) {
		setAttrVal("Sup_fac_name", Sup_fac_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 物品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 高低值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}
	/**
	 * 高低值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 物品唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 物品唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 是否代管
	 * @return FBoolean
	 */
	public FBoolean getFg_escrow() {
		return ((FBoolean) getAttrVal("Fg_escrow"));
	}
	/**
	 * 是否代管
	 * @param Fg_escrow
	 */
	public void setFg_escrow(FBoolean Fg_escrow) {
		setAttrVal("Fg_escrow", Fg_escrow);
	}
	/**
	 * 供应商条码
	 * @return String
	 */
	public String getSup_bcode() {
		return ((String) getAttrVal("Sup_bcode"));
	}
	/**
	 * 供应商条码
	 * @param Sup_bcode
	 */
	public void setSup_bcode(String Sup_bcode) {
		setAttrVal("Sup_bcode", Sup_bcode);
	}
	/**
	 * 进价总金额
	 * @return FDouble
	 */
	public FDouble getSum_pri() {
		return ((FDouble) getAttrVal("Sum_pri"));
	}
	/**
	 * 进价总金额
	 * @param Sum_pri
	 */
	public void setSum_pri(FDouble Sum_pri) {
		setAttrVal("Sum_pri", Sum_pri);
	}
	/**
	 * 售价总金额
	 * @return FDouble
	 */
	public FDouble getSum_sa() {
		return ((FDouble) getAttrVal("Sum_sa"));
	}
	/**
	 * 售价总金额
	 * @param Sum_sa
	 */
	public void setSum_sa(FDouble Sum_sa) {
		setAttrVal("Sum_sa", Sum_sa);
	}
	/**
	 * 总数量
	 * @return FDouble
	 */
	public FDouble getSum_num() {
		return ((FDouble) getAttrVal("Sum_num"));
	}
	/**
	 * 总数量
	 * @param Sum_num
	 */
	public void setSum_num(FDouble Sum_num) {
		setAttrVal("Sum_num", Sum_num);
	}
}