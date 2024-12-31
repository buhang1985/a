package iih.mi.mc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保患者增量维护dto DTO数据 
 * 
 */
public class MiHpPatSpecDrugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保患者增量维护主键
	 * @return String
	 */
	public String getId_mimcpatspecdrugaquan() {
		return ((String) getAttrVal("Id_mimcpatspecdrugaquan"));
	}
	/**
	 * 医保患者增量维护主键
	 * @param Id_mimcpatspecdrugaquan
	 */
	public void setId_mimcpatspecdrugaquan(String Id_mimcpatspecdrugaquan) {
		setAttrVal("Id_mimcpatspecdrugaquan", Id_mimcpatspecdrugaquan);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 原开立总量
	 * @return FDouble
	 */
	public FDouble getMonth_limit_quan() {
		return ((FDouble) getAttrVal("Month_limit_quan"));
	}
	/**
	 * 原开立总量
	 * @param Month_limit_quan
	 */
	public void setMonth_limit_quan(FDouble Month_limit_quan) {
		setAttrVal("Month_limit_quan", Month_limit_quan);
	}
	/**
	 * 本月已增量
	 * @return FDouble
	 */
	public FDouble getAdd_quan() {
		return ((FDouble) getAttrVal("Add_quan"));
	}
	/**
	 * 本月已增量
	 * @param Add_quan
	 */
	public void setAdd_quan(FDouble Add_quan) {
		setAttrVal("Add_quan", Add_quan);
	}
	/**
	 * 调整量
	 * @return Integer
	 */
	public Integer getCan_quan() {
		return ((Integer) getAttrVal("Can_quan"));
	}
	/**
	 * 调整量
	 * @param Can_quan
	 */
	public void setCan_quan(Integer Can_quan) {
		setAttrVal("Can_quan", Can_quan);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
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
	 * 单位id
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位id
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
}