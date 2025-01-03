package iih.en.pv.out.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊事件DTO DTO数据 
 * 
 */
public class EnEvtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊事件id
	 * @return String
	 */
	public String getId_entevt() {
		return ((String) getAttrVal("Id_entevt"));
	}
	/**
	 * 就诊事件id
	 * @param Id_entevt
	 */
	public void setId_entevt(String Id_entevt) {
		setAttrVal("Id_entevt", Id_entevt);
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
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getSd_entevt() {
		return ((String) getAttrVal("Sd_entevt"));
	}
	/**
	 * 事件类型
	 * @param Sd_entevt
	 */
	public void setSd_entevt(String Sd_entevt) {
		setAttrVal("Sd_entevt", Sd_entevt);
	}
	/**
	 * 事件类型名称
	 * @return String
	 */
	public String getName_entevt() {
		return ((String) getAttrVal("Name_entevt"));
	}
	/**
	 * 事件类型名称
	 * @param Name_entevt
	 */
	public void setName_entevt(String Name_entevt) {
		setAttrVal("Name_entevt", Name_entevt);
	}
	/**
	 * 简述
	 * @return String
	 */
	public String getShort_des() {
		return ((String) getAttrVal("Short_des"));
	}
	/**
	 * 简述
	 * @param Short_des
	 */
	public void setShort_des(String Short_des) {
		setAttrVal("Short_des", Short_des);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 事件时间
	 * @return FDateTime
	 */
	public FDateTime getDt_evt() {
		return ((FDateTime) getAttrVal("Dt_evt"));
	}
	/**
	 * 事件时间
	 * @param Dt_evt
	 */
	public void setDt_evt(FDateTime Dt_evt) {
		setAttrVal("Dt_evt", Dt_evt);
	}
	/**
	 * 记录人
	 * @return String
	 */
	public String getId_emp_rec() {
		return ((String) getAttrVal("Id_emp_rec"));
	}
	/**
	 * 记录人
	 * @param Id_emp_rec
	 */
	public void setId_emp_rec(String Id_emp_rec) {
		setAttrVal("Id_emp_rec", Id_emp_rec);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getName_emp_rec() {
		return ((String) getAttrVal("Name_emp_rec"));
	}
	/**
	 * displaynam10
	 * @param Name_emp_rec
	 */
	public void setName_emp_rec(String Name_emp_rec) {
		setAttrVal("Name_emp_rec", Name_emp_rec);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}
	/**
	 * 记录时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 旧数据
	 * @return String
	 */
	public String getVal_old() {
		return ((String) getAttrVal("Val_old"));
	}
	/**
	 * 旧数据
	 * @param Val_old
	 */
	public void setVal_old(String Val_old) {
		setAttrVal("Val_old", Val_old);
	}
	/**
	 * 新数据
	 * @return String
	 */
	public String getVal_new() {
		return ((String) getAttrVal("Val_new"));
	}
	/**
	 * 新数据
	 * @param Val_new
	 */
	public void setVal_new(String Val_new) {
		setAttrVal("Val_new", Val_new);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}
	/**
	 * 操作科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	
}