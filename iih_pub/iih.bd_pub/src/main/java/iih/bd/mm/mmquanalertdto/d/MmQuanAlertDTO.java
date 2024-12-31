package iih.bd.mm.mmquanalertdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 物品库存量预警 DTO数据 
 * 
 */
public class MmQuanAlertDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
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
	 * 现存量
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 现存量
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 最低库存
	 * @return FDouble
	 */
	public FDouble getLownum() {
		return ((FDouble) getAttrVal("Lownum"));
	}
	/**
	 * 最低库存
	 * @param Lownum
	 */
	public void setLownum(FDouble Lownum) {
		setAttrVal("Lownum", Lownum);
	}
	/**
	 * 药品数量
	 * @return Integer
	 */
	public Integer getQuan_mm() {
		return ((Integer) getAttrVal("Quan_mm"));
	}
	/**
	 * 药品数量
	 * @param Quan_mm
	 */
	public void setQuan_mm(Integer Quan_mm) {
		setAttrVal("Quan_mm", Quan_mm);
	}
	/**
	 * 缺省量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 缺省量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 零售包装单位
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}
	/**
	 * 零售包装单位
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 库存为空数量
	 * @return Integer
	 */
	public Integer getQuan_zero() {
		return ((Integer) getAttrVal("Quan_zero"));
	}
	/**
	 * 库存为空数量
	 * @param Quan_zero
	 */
	public void setQuan_zero(Integer Quan_zero) {
		setAttrVal("Quan_zero", Quan_zero);
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
	 * 描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
	/**
	 * 打印名
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}
	/**
	 * 打印名
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * 通用名
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
}