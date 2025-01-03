package iih.mm.itf.material.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * ReserveResultDTO DTO数据 
 * 
 */
public class ReserveResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行科室主键
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室主键
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 进口分类
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}
	/**
	 * 进口分类
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
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
	 * 价格_实际单位
	 * @return FDouble
	 */
	public FDouble getPrice_act() {
		return ((FDouble) getAttrVal("Price_act"));
	}
	/**
	 * 价格_实际单位
	 * @param Price_act
	 */
	public void setPrice_act(FDouble Price_act) {
		setAttrVal("Price_act", Price_act);
	}
	/**
	 * 价格_零售包装单位
	 * @return FDouble
	 */
	public FDouble getPrice_sale() {
		return ((FDouble) getAttrVal("Price_sale"));
	}
	/**
	 * 价格_零售包装单位
	 * @param Price_sale
	 */
	public void setPrice_sale(FDouble Price_sale) {
		setAttrVal("Price_sale", Price_sale);
	}
	/**
	 * 进价_实际单位
	 * @return FDouble
	 */
	public FDouble getPrice_in() {
		return ((FDouble) getAttrVal("Price_in"));
	}
	/**
	 * 进价_实际单位
	 * @param Price_in
	 */
	public void setPrice_in(FDouble Price_in) {
		setAttrVal("Price_in", Price_in);
	}
	/**
	 * 预留数量_基本包装单位
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}
	/**
	 * 预留数量_基本包装单位
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}
	/**
	 * 预留数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_act() {
		return ((FDouble) getAttrVal("Quan_act"));
	}
	/**
	 * 预留数量_实际单位
	 * @param Quan_act
	 */
	public void setQuan_act(FDouble Quan_act) {
		setAttrVal("Quan_act", Quan_act);
	}
	/**
	 * 服务条目ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 服务条目ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
}