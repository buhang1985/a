package iih.pe.papt.dto.peitfchargedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检接口_收费项目 DTO数据 
 * 
 */
public class PeItfChargeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 基础服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 基础服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 体检预约项目id
	 * @return String
	 */
	public String getId_pepsnapptcat() {
		return ((String) getAttrVal("Id_pepsnapptcat"));
	}
	/**
	 * 体检预约项目id
	 * @param Id_pepsnapptcat
	 */
	public void setId_pepsnapptcat(String Id_pepsnapptcat) {
		setAttrVal("Id_pepsnapptcat", Id_pepsnapptcat);
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
	 * 价格比例
	 * @return FDouble
	 */
	public FDouble getRatio_pripat() {
		return ((FDouble) getAttrVal("Ratio_pripat"));
	}
	/**
	 * 价格比例
	 * @param Ratio_pripat
	 */
	public void setRatio_pripat(FDouble Ratio_pripat) {
		setAttrVal("Ratio_pripat", Ratio_pripat);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 收费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}
	/**
	 * 收费标志
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 体检预约单
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检预约单
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
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
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
}