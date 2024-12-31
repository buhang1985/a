package iih.mp.ot.dto.exerefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行退费医嘱信息 DTO数据 
 * 
 */
public class RfnOrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 选中状态
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 选中状态
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
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
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
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
	 * 开立医生ID
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生ID
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开立科室ID
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室ID
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 执行科室ID
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室ID
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 记账状态ID
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态ID
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态名称
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态名称
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 停止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 停止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 可退费标记
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}
	/**
	 * 可退费标记
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 费用状态
	 * @return String
	 */
	public String getName_feestatus() {
		return ((String) getAttrVal("Name_feestatus"));
	}
	/**
	 * 费用状态
	 * @param Name_feestatus
	 */
	public void setName_feestatus(String Name_feestatus) {
		setAttrVal("Name_feestatus", Name_feestatus);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 执行人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 执行人名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 执行人名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
}