package iih.ci.ord.ip.dto.ems.uiemsdto;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 西药医疗单子 DTO数据 
 * 
 */
public class EmsDrugsItemViewDTO extends BaseDTO {
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
	 * 可用库存
	 * @return FDouble
	 */
	public FDouble getFact_count() {
		return ((FDouble) getAttrVal("Fact_count"));
	}
	/**
	 * 可用库存
	 * @param Fact_count
	 */
	public void setFact_count(FDouble Fact_count) {
		setAttrVal("Fact_count", Fact_count);
	}
	/**
	 * 自备药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 自备药标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 计量
	 * @return String
	 */
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}
	/**
	 * 计量
	 * @param Quan_med
	 */
	public void setQuan_med(String Quan_med) {
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
	 * 使用说明
	 * @return String
	 */
	public String getNote_srv() {
		return ((String) getAttrVal("Note_srv"));
	}
	/**
	 * 使用说明
	 * @param Note_srv
	 */
	public void setNote_srv(String Note_srv) {
		setAttrVal("Note_srv", Note_srv);
	}
}