package iih.mp.nr.dto.wardprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液贴卡 DTO数据 
 * 
 */
public class InfuLableCardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 长临
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}	
	/**
	 * 长临
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 打印状态
	 * @return Integer
	 */
	public Integer getEu_print() {
		return ((Integer) getAttrVal("Eu_print"));
	}	
	/**
	 * 打印状态
	 * @param Eu_print
	 */
	public void setEu_print(Integer Eu_print) {
		setAttrVal("Eu_print", Eu_print);
	}
	/**
	 * 药品签类型ID
	 * @return String
	 */
	public String getId_labletp() {
		return ((String) getAttrVal("Id_labletp"));
	}	
	/**
	 * 药品签类型ID
	 * @param Id_labletp
	 */
	public void setId_labletp(String Id_labletp) {
		setAttrVal("Id_labletp", Id_labletp);
	}
	/**
	 * 药品签类型编码
	 * @return String
	 */
	public String getSd_labletp() {
		return ((String) getAttrVal("Sd_labletp"));
	}	
	/**
	 * 药品签类型编码
	 * @param Sd_labletp
	 */
	public void setSd_labletp(String Sd_labletp) {
		setAttrVal("Sd_labletp", Sd_labletp);
	}
	/**
	 * 药品签类型名称
	 * @return String
	 */
	public String getName_labletp() {
		return ((String) getAttrVal("Name_labletp"));
	}	
	/**
	 * 药品签类型名称
	 * @param Name_labletp
	 */
	public void setName_labletp(String Name_labletp) {
		setAttrVal("Name_labletp", Name_labletp);
	}
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}	
	/**
	 * 用法ID
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_routes() {
		return ((String) getAttrVal("Name_routes"));
	}	
	/**
	 * 用法名称
	 * @param Name_routes
	 */
	public void setName_routes(String Name_routes) {
		setAttrVal("Name_routes", Name_routes);
	}
	/**
	 * 毒麻标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}	
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
}