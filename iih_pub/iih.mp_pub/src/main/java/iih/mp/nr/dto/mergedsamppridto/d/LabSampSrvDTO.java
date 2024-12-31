package iih.mp.nr.dto.mergedsamppridto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 写入标本后返回费用对照项目 DTO数据 
 * 
 */
public class LabSampSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本条码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 标本条码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
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
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 计量单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 折后价格
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折后价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 费用类型
	 * @return Integer
	 */
	public Integer getEu_pritp() {
		return ((Integer) getAttrVal("Eu_pritp"));
	}
	/**
	 * 费用类型
	 * @param Eu_pritp
	 */
	public void setEu_pritp(Integer Eu_pritp) {
		setAttrVal("Eu_pritp", Eu_pritp);
	}
}