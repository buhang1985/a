package iih.mm.itf.material.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * GetMaterialPriceDTO DTO数据 
 * 
 */
public class GetMaterialPriceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 请求单位主键
	 * @return String
	 */
	public String getReq_unit_id() {
		return ((String) getAttrVal("Req_unit_id"));
	}
	/**
	 * 请求单位主键
	 * @param Req_unit_id
	 */
	public void setReq_unit_id(String Req_unit_id) {
		setAttrVal("Req_unit_id", Req_unit_id);
	}
	/**
	 * 请求单位价格
	 * @return FDouble
	 */
	public FDouble getPrice_act() {
		return ((FDouble) getAttrVal("Price_act"));
	}
	/**
	 * 请求单位价格
	 * @param Price_act
	 */
	public void setPrice_act(FDouble Price_act) {
		setAttrVal("Price_act", Price_act);
	}
	/**
	 * 基础单位
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}
	/**
	 * 基础单位
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}
	/**
	 * 系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 成功标志
	 * @return FBoolean
	 */
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}
	/**
	 * 成功标志
	 * @param Fg_success
	 */
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
	}
	/**
	 * 错误信息
	 * @return String
	 */
	public String getError_msg() {
		return ((String) getAttrVal("Error_msg"));
	}
	/**
	 * 错误信息
	 * @param Error_msg
	 */
	public void setError_msg(String Error_msg) {
		setAttrVal("Error_msg", Error_msg);
	}
}