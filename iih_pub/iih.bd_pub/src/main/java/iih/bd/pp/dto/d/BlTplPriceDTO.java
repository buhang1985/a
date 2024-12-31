package iih.bd.pp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用模板价格DTO DTO数据 
 * 
 */
public class BlTplPriceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用模板ID
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}
	/**
	 * 费用模板ID
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
	}
	/**
	 * 费用模板名称
	 * @return String
	 */
	public String getName_bltpl() {
		return ((String) getAttrVal("Name_bltpl"));
	}
	/**
	 * 费用模板名称
	 * @param Name_bltpl
	 */
	public void setName_bltpl(String Name_bltpl) {
		setAttrVal("Name_bltpl", Name_bltpl);
	}
	/**
	 * 费用模板类型编码
	 * @return String
	 */
	public String getSd_bltpltp() {
		return ((String) getAttrVal("Sd_bltpltp"));
	}
	/**
	 * 费用模板类型编码
	 * @param Sd_bltpltp
	 */
	public void setSd_bltpltp(String Sd_bltpltp) {
		setAttrVal("Sd_bltpltp", Sd_bltpltp);
	}
	/**
	 * 所属类型
	 * @return String
	 */
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}
	/**
	 * 所属类型
	 * @param Sd_owtp
	 */
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	/**
	 * 所属科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 所属科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 所属人员ID
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 所属人员ID
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 明细集合
	 * @return FArrayList
	 */
	public FArrayList getItm_list() {
		return ((FArrayList) getAttrVal("Itm_list"));
	}
	/**
	 * 明细集合
	 * @param Itm_list
	 */
	public void setItm_list(FArrayList Itm_list) {
		setAttrVal("Itm_list", Itm_list);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPrice_std() {
		return ((FDouble) getAttrVal("Price_std"));
	}
	/**
	 * 标准价格
	 * @param Price_std
	 */
	public void setPrice_std(FDouble Price_std) {
		setAttrVal("Price_std", Price_std);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}
	/**
	 * 价格系数
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 折后价
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折后价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
}