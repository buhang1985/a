package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dto.ems.uiemsdto.b.BaseDrugsItemViewDTO;

import java.math.BigDecimal;

/**
 * 草药医疗单子 DTO数据 
 * 
 */
public class EmsHerbsItemViewDTO extends BaseDrugsItemViewDTO {
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
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
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
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}
	/**
	 * 规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 计量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 计量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 计量单位ID
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 计量单位ID
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 计量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 煎法要求ID
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求ID
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 煎法要求过滤条件
	 * @return String
	 */
	public String getFilter_boildes() {
		return ((String) getAttrVal("Filter_boildes"));
	}
	/**
	 * 煎法要求过滤条件
	 * @param Filter_boildes
	 */
	public void setFilter_boildes(String Filter_boildes) {
		setAttrVal("Filter_boildes", Filter_boildes);
	}
	/**
	 * 付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_total() {
		return ((FDouble) getAttrVal("Quan_total"));
	}
	/**
	 * 总量
	 * @param Quan_total
	 */
	public void setQuan_total(FDouble Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 参考价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 总价
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 总价
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 零售单位ID
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 零售单位ID
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 折扣价系数
	 * @return String
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣价系数
	 * @param Price_ratio
	 */
	public void setPrice_ratio(String Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 零售单位
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPrice_standard() {
		return ((FDouble) getAttrVal("Price_standard"));
	}
	/**
	 * 标准价
	 * @param Price_standard
	 */
	public void setPrice_standard(FDouble Price_standard) {
		setAttrVal("Price_standard", Price_standard);
	}
	/**
	 * 自定义标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}
	/**
	 * 自定义标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	/**
	 * 自付费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自付费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 医保适应症标识
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 医保适应症标识
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
	}
	/**
	 * 换算系数_当前
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}
	/**
	 * 换算系数_当前
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}
	/**
	 * 换算系数_医基
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 换算系数_医基
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 取整模式
	 * @return String
	 */
	public String getSd_opmutp() {
		return ((String) getAttrVal("Sd_opmutp"));
	}
	/**
	 * 取整模式
	 * @param Sd_opmutp
	 */
	public void setSd_opmutp(String Sd_opmutp) {
		setAttrVal("Sd_opmutp", Sd_opmutp);
	}
	
	/**
	 * 包装单位急诊流水取整模式编码
	 * @return String
	 */
	public String getSd_ermutp() {
		return ((String) getAttrVal("Sd_ermutp"));
	}
	/**
	 * 包装单位急诊流水取整模式编码
	 * @param Sd_ermutp
	 */
	public void setSd_ermutp(String Sd_ermutp) {
		setAttrVal("Sd_ermutp", Sd_ermutp);
	}
	/**
	 * 包装单位急症抢救取整模式编码
	 * @return String
	 */
	public String getSd_er1mutp() {
		return ((String) getAttrVal("Sd_er1mutp"));
	}
	/**
	 * 包装单位急诊抢救取整模式编码
	 * @param Sd_er1mutp
	 */
	public void setSd_er1mutp(String Sd_er1mutp) {
		setAttrVal("Sd_er1mutp", Sd_er1mutp);
	}
	
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_or_srv() {
		return ((String) getAttrVal("Id_or_srv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_or_srv
	 */
	public void setId_or_srv(String Id_or_srv) {
		setAttrVal("Id_or_srv", Id_or_srv);
	}
	/**
	 * 商品名
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 商品名
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 频次数量
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 天数
	 * @return Integer
	 */
	public Integer getUsedays() {
		return ((Integer) getAttrVal("Usedays"));
	}
	/**
	 * 天数
	 * @param Usedays
	 */
	public void setUsedays(Integer Usedays) {
		setAttrVal("Usedays", Usedays);
	}
	/**
	 * 与付数无关标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}
	/**
	 * 与付数无关标识
	 * @param Fg_selfsrv
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 药房ID
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 药房ID
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 药房过滤条件
	 * @return String
	 */
	public String getFilter_dep_wh() {
		return ((String) getAttrVal("Filter_dep_wh"));
	}
	/**
	 * 药房过滤条件
	 * @param Filter_dep_wh
	 */
	public void setFilter_dep_wh(String Filter_dep_wh) {
		setAttrVal("Filter_dep_wh", Filter_dep_wh);
	}
}