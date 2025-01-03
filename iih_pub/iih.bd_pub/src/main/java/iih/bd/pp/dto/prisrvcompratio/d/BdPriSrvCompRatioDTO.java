package iih.bd.pp.dto.prisrvcompratio.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 组合定价特殊比例 DTO数据 
 * 
 */
public class BdPriSrvCompRatioDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 定价服务
	 * @return String
	 */
	public String getId_srv_bl() {
		return ((String) getAttrVal("Id_srv_bl"));
	}
	/**
	 * 定价服务
	 * @param Id_srv_bl
	 */
	public void setId_srv_bl(String Id_srv_bl) {
		setAttrVal("Id_srv_bl", Id_srv_bl);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 比例
	 * @return FDouble
	 */
	public FDouble getRatio() {
		return ((FDouble) getAttrVal("Ratio"));
	}
	/**
	 * 比例
	 * @param Ratio
	 */
	public void setRatio(FDouble Ratio) {
		setAttrVal("Ratio", Ratio);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
}