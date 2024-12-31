package iih.mc.st.stockcheckitemdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 耗材盘点项目DTO DTO数据 
 * 
 */
public class StockCheckItemDTO extends BaseDTO {
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
	 * 物品特性
	 * @return String
	 */
	public String getFeature() {
		return ((String) getAttrVal("Feature"));
	}
	/**
	 * 物品特性
	 * @param Feature
	 */
	public void setFeature(String Feature) {
		setAttrVal("Feature", Feature);
	}
	/**
	 * 生产厂商主键
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 生产厂商主键
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 生产厂商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 入库单主键
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 入库单主键
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 入库单号
	 * @return String
	 */
	public String getOrder_code() {
		return ((String) getAttrVal("Order_code"));
	}
	/**
	 * 入库单号
	 * @param Order_code
	 */
	public void setOrder_code(String Order_code) {
		setAttrVal("Order_code", Order_code);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
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
	 * 失效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}
	/**
	 * 失效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 货位主键
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}
	/**
	 * 货位主键
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
	}
	/**
	 * 货位编码
	 * @return String
	 */
	public String getLoc_code() {
		return ((String) getAttrVal("Loc_code"));
	}
	/**
	 * 货位编码
	 * @param Loc_code
	 */
	public void setLoc_code(String Loc_code) {
		setAttrVal("Loc_code", Loc_code);
	}
	/**
	 * 货位名称
	 * @return String
	 */
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}
	/**
	 * 货位名称
	 * @param Loc_name
	 */
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_mmpkgu_base() {
		return ((String) getAttrVal("Id_mmpkgu_base"));
	}
	/**
	 * 基本包装单位
	 * @param Id_mmpkgu_base
	 */
	public void setId_mmpkgu_base(String Id_mmpkgu_base) {
		setAttrVal("Id_mmpkgu_base", Id_mmpkgu_base);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getMmbasepkguname() {
		return ((String) getAttrVal("Mmbasepkguname"));
	}
	/**
	 * 基本包装单位名称
	 * @param Mmbasepkguname
	 */
	public void setMmbasepkguname(String Mmbasepkguname) {
		setAttrVal("Mmbasepkguname", Mmbasepkguname);
	}
	/**
	 * 实际包装单位
	 * @return String
	 */
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}
	/**
	 * 实际包装单位
	 * @param Id_mmpkgu_actual
	 */
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	/**
	 * 实际包装单位名称
	 * @return String
	 */
	public String getMmactpkguname() {
		return ((String) getAttrVal("Mmactpkguname"));
	}
	/**
	 * 实际包装单位名称
	 * @param Mmactpkguname
	 */
	public void setMmactpkguname(String Mmactpkguname) {
		setAttrVal("Mmactpkguname", Mmactpkguname);
	}
	/**
	 * 进价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_base() {
		return ((FDouble) getAttrVal("Pri_base"));
	}
	/**
	 * 进价_基本单位
	 * @param Pri_base
	 */
	public void setPri_base(FDouble Pri_base) {
		setAttrVal("Pri_base", Pri_base);
	}
	/**
	 * 进价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}
	/**
	 * 进价_实际单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 售价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_sa_base() {
		return ((FDouble) getAttrVal("Pri_sa_base"));
	}
	/**
	 * 售价_基本单位
	 * @param Pri_sa_base
	 */
	public void setPri_sa_base(FDouble Pri_sa_base) {
		setAttrVal("Pri_sa_base", Pri_sa_base);
	}
	/**
	 * 售价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}
	/**
	 * 售价_实际单位
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 账面数量_实际包装单位
	 * @return FDouble
	 */
	public FDouble getQuan_bk_actual() {
		return ((FDouble) getAttrVal("Quan_bk_actual"));
	}
	/**
	 * 账面数量_实际包装单位
	 * @param Quan_bk_actual
	 */
	public void setQuan_bk_actual(FDouble Quan_bk_actual) {
		setAttrVal("Quan_bk_actual", Quan_bk_actual);
	}
	/**
	 * 预留数量_实际包装单位
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}
	/**
	 * 预留数量_实际包装单位
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getMm_pycode() {
		return ((String) getAttrVal("Mm_pycode"));
	}
	/**
	 * 拼音码
	 * @param Mm_pycode
	 */
	public void setMm_pycode(String Mm_pycode) {
		setAttrVal("Mm_pycode", Mm_pycode);
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
}