package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
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
}