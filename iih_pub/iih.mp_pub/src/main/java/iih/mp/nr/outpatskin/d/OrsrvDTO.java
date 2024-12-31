package iih.mp.nr.outpatskin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗服务 DTO数据 
 * 
 */
public class OrsrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 关联皮试医嘱ID
	 * @return String
	 */
	public String getId_or_skin() {
		return ((String) getAttrVal("Id_or_skin"));
	}
	/**
	 * 关联皮试医嘱ID
	 * @param Id_or_skin
	 */
	public void setId_or_skin(String Id_or_skin) {
		setAttrVal("Id_or_skin", Id_or_skin);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 皮试结果录入表ID
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}
	/**
	 * 皮试结果录入表ID
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 皮试结果时间
	 * @return FDateTime
	 */
	public FDateTime getDt_skintest() {
		return ((FDateTime) getAttrVal("Dt_skintest"));
	}
	/**
	 * 皮试结果时间
	 * @param Dt_skintest
	 */
	public void setDt_skintest(FDateTime Dt_skintest) {
		setAttrVal("Dt_skintest", Dt_skintest);
	}
	/**
	 * 皮试结果ID
	 * @return String
	 */
	public String getId_rst_skintest() {
		return ((String) getAttrVal("Id_rst_skintest"));
	}
	/**
	 * 皮试结果ID
	 * @param Id_rst_skintest
	 */
	public void setId_rst_skintest(String Id_rst_skintest) {
		setAttrVal("Id_rst_skintest", Id_rst_skintest);
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
	 * 皮试结果
	 * @return String
	 */
	public String getRst_skintest() {
		return ((String) getAttrVal("Rst_skintest"));
	}
	/**
	 * 皮试结果
	 * @param Rst_skintest
	 */
	public void setRst_skintest(String Rst_skintest) {
		setAttrVal("Rst_skintest", Rst_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_rstskintest() {
		return ((String) getAttrVal("Name_rstskintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_rstskintest
	 */
	public void setName_rstskintest(String Name_rstskintest) {
		setAttrVal("Name_rstskintest", Name_rstskintest);
	}
	/**
	 * 录入人ID
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 录入人ID
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 录入人姓名
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
}