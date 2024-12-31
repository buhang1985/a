package iih.ci.ord.dto.skintest.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试结果dto DTO数据 
 * 
 */
public class SkinTestRstDTO extends BaseDTO {
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
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试时间
	 * @return FDateTime
	 */
	public FDateTime getDt_skintest() {
		return ((FDateTime) getAttrVal("Dt_skintest"));
	}
	/**
	 * 皮试时间
	 * @param Dt_skintest
	 */
	public void setDt_skintest(FDateTime Dt_skintest) {
		setAttrVal("Dt_skintest", Dt_skintest);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 皮试录入人id
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 皮试录入人id
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 强制用药原因
	 * @return String
	 */
	public String getSkip_skintest_reason() {
		return ((String) getAttrVal("Skip_skintest_reason"));
	}
	/**
	 * 强制用药原因
	 * @param Skip_skintest_reason
	 */
	public void setSkip_skintest_reason(String Skip_skintest_reason) {
		setAttrVal("Skip_skintest_reason", Skip_skintest_reason);
	}
	/**
	 * 皮试录入人名称
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 皮试录入人名称
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 皮试服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 皮试服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 皮试药品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 皮试药品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
}