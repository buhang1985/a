package iih.ci.ord.dto.thirdparam;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方传入的参数
 * 收费传CI参数dto DTO数据 
 * 
 */
public class ChargeForCiParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 操作人id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 操作人id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 是否物品标示
	 * @return String
	 */
	public String getFg_mm() {
		return ((String) getAttrVal("Fg_mm"));
	}
	/**
	 * 是否物品标示
	 * @param Fg_mm
	 */
	public void setFg_mm(String Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 开立时间
	 * @return String
	 */
	public String getDt_b() {
		return ((String) getAttrVal("Dt_b"));
	}
	/**
	 * 开立时间
	 * @param Dt_b
	 */
	public void setDt_b(String Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 总量单位
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}
	/**
	 * 总量单位
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
	/**
	 * 单价
	 * @return String
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_ap() {
		return ((String) getAttrVal("Name_dep_ap"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_ap
	 */
	public void setName_dep_ap(String Name_dep_ap) {
		setAttrVal("Name_dep_ap", Name_dep_ap);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 药房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
}