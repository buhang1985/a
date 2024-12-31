package iih.mp.nr.dto.skinexe.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 皮试执行参数 DTO数据 
 * 
 */
public class SkinExeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
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
	 * 皮试结果ID
	 * @return String
	 */
	public String getId_skin_res() {
		return ((String) getAttrVal("Id_skin_res"));
	}
	/**
	 * 皮试结果ID
	 * @param Id_skin_res
	 */
	public void setId_skin_res(String Id_skin_res) {
		setAttrVal("Id_skin_res", Id_skin_res);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_skin_res() {
		return ((String) getAttrVal("Sd_skin_res"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_skin_res
	 */
	public void setSd_skin_res(String Sd_skin_res) {
		setAttrVal("Sd_skin_res", Sd_skin_res);
	}
	/**
	 * 皮试id
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}
	/**
	 * 皮试id
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 确认人
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 创建时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 严重等级
	 * @return Integer
	 */
	public Integer getDegree() {
		return ((Integer) getAttrVal("Degree"));
	}
	/**
	 * 严重等级
	 * @param Degree
	 */
	public void setDegree(Integer Degree) {
		setAttrVal("Degree", Degree);
	}
	/**
	 * 严重等级描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 严重等级描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 等待时间
	 * @return String
	 */
	public String getWaittime() {
		return ((String) getAttrVal("Waittime"));
	}
	/**
	 * 等待时间
	 * @param Waittime
	 */
	public void setWaittime(String Waittime) {
		setAttrVal("Waittime", Waittime);
	}
	/**
	 * 双签确认人
	 * @return String
	 */
	public String getId_other_confirm() {
		return ((String) getAttrVal("Id_other_confirm"));
	}
	/**
	 * 双签确认人
	 * @param Id_other_confirm
	 */
	public void setId_other_confirm(String Id_other_confirm) {
		setAttrVal("Id_other_confirm", Id_other_confirm);
	}
}