package iih.mm.qy.drugintoutdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医嘱信息 DTO数据 
 * 
 */
public class PatOrderInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getOrder_code() {
		return ((String) getAttrVal("Order_code"));
	}
	/**
	 * 医嘱编码
	 * @param Order_code
	 */
	public void setOrder_code(String Order_code) {
		setAttrVal("Order_code", Order_code);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getOrder_content() {
		return ((String) getAttrVal("Order_content"));
	}
	/**
	 * 医嘱内容
	 * @param Order_content
	 */
	public void setOrder_content(String Order_content) {
		setAttrVal("Order_content", Order_content);
	}
	/**
	 * 生效时间
	 * @return FDateTime
	 */
	public FDateTime getEffecttime() {
		return ((FDateTime) getAttrVal("Effecttime"));
	}
	/**
	 * 生效时间
	 * @param Effecttime
	 */
	public void setEffecttime(FDateTime Effecttime) {
		setAttrVal("Effecttime", Effecttime);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getEndtime() {
		return ((FDateTime) getAttrVal("Endtime"));
	}
	/**
	 * 截止时间
	 * @param Endtime
	 */
	public void setEndtime(FDateTime Endtime) {
		setAttrVal("Endtime", Endtime);
	}
	/**
	 * 开单医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开单医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_type() {
		return ((String) getAttrVal("Code_type"));
	}
	/**
	 * 就诊类型
	 * @param Code_type
	 */
	public void setCode_type(String Code_type) {
		setAttrVal("Code_type", Code_type);
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
}