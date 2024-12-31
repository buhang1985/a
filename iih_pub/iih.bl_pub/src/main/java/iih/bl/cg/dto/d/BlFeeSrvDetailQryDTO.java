package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用项目明细 DTO数据 
 * 
 */
public class BlFeeSrvDetailQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_num() {
		return ((String) getAttrVal("Bed_num"));
	}
	/**
	 * 床号
	 * @param Bed_num
	 */
	public void setBed_num(String Bed_num) {
		setAttrVal("Bed_num", Bed_num);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getMp_time() {
		return ((FDateTime) getAttrVal("Mp_time"));
	}
	/**
	 * 执行时间
	 * @param Mp_time
	 */
	public void setMp_time(FDateTime Mp_time) {
		setAttrVal("Mp_time", Mp_time);
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
	 * 单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 开立人
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 开立人
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getName_mp() {
		return ((String) getAttrVal("Name_mp"));
	}
	/**
	 * 执行人
	 * @param Name_mp
	 */
	public void setName_mp(String Name_mp) {
		setAttrVal("Name_mp", Name_mp);
	}
	/**
	 * 开立人id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立人id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 执行人id
	 * @return String
	 */
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}
	/**
	 * 执行人id
	 * @param Id_emp_mp
	 */
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getOr_time() {
		return ((FDateTime) getAttrVal("Or_time"));
	}
	/**
	 * 开立时间
	 * @param Or_time
	 */
	public void setOr_time(FDateTime Or_time) {
		setAttrVal("Or_time", Or_time);
	}
	/**
	 * 记账人
	 * @return String
	 */
	public String getName_cg() {
		return ((String) getAttrVal("Name_cg"));
	}
	/**
	 * 记账人
	 * @param Name_cg
	 */
	public void setName_cg(String Name_cg) {
		setAttrVal("Name_cg", Name_cg);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getCg_time() {
		return ((FDateTime) getAttrVal("Cg_time"));
	}
	/**
	 * 记账时间
	 * @param Cg_time
	 */
	public void setCg_time(FDateTime Cg_time) {
		setAttrVal("Cg_time", Cg_time);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getMp_depname() {
		return ((String) getAttrVal("Mp_depname"));
	}
	/**
	 * 执行科室
	 * @param Mp_depname
	 */
	public void setMp_depname(String Mp_depname) {
		setAttrVal("Mp_depname", Mp_depname);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getOr_depname() {
		return ((String) getAttrVal("Or_depname"));
	}
	/**
	 * 开立科室
	 * @param Mp_depname
	 */
	public void setOr_depname(String Or_depname) {
		setAttrVal("Or_depname", Or_depname);
	}	
}