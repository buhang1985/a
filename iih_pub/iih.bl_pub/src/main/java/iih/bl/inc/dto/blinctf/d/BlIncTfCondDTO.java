package iih.bl.inc.dto.blinctf.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 票据转移撤销出入参DTO DTO数据 
 * 
 */
public class BlIncTfCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 原票据领用人ID
	 * @return String
	 */
	public String getId_emp_iss() {
		return ((String) getAttrVal("Id_emp_iss"));
	}
	/**
	 * 原票据领用人ID
	 * @param Id_emp_iss
	 */
	public void setId_emp_iss(String Id_emp_iss) {
		setAttrVal("Id_emp_iss", Id_emp_iss);
	}
	/**
	 * 原票据领用计算机ID
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}
	/**
	 * 原票据领用计算机ID
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 票据转移接受人员ID
	 * @return String
	 */
	public String getId_emp_iss_tf() {
		return ((String) getAttrVal("Id_emp_iss_tf"));
	}
	/**
	 * 票据转移接受人员ID
	 * @param Id_emp_iss_tf
	 */
	public void setId_emp_iss_tf(String Id_emp_iss_tf) {
		setAttrVal("Id_emp_iss_tf", Id_emp_iss_tf);
	}
	/**
	 * 票据转移接受计算机ID
	 * @return String
	 */
	public String getId_pc_tf() {
		return ((String) getAttrVal("Id_pc_tf"));
	}
	/**
	 * 票据转移接受计算机ID
	 * @param Id_pc_tf
	 */
	public void setId_pc_tf(String Id_pc_tf) {
		setAttrVal("Id_pc_tf", Id_pc_tf);
	}
	/**
	 * 票据列表
	 * @return FArrayList
	 */
	public FArrayList getInclist() {
		return ((FArrayList) getAttrVal("Inclist"));
	}
	/**
	 * 票据列表
	 * @param Inclist
	 */
	public void setInclist(FArrayList Inclist) {
		setAttrVal("Inclist", Inclist);
	}
	/**
	 * 票据领用Id
	 * @return String
	 */
	public String getId_inc_iss() {
		return ((String) getAttrVal("Id_inc_iss"));
	}
	/**
	 * 票据领用Id
	 * @param Id_inc_iss
	 */
	public void setId_inc_iss(String Id_inc_iss) {
		setAttrVal("Id_inc_iss", Id_inc_iss);
	}
	/**
	 * 原票据领用人名称
	 * @return String
	 */
	public String getName_emp_iss() {
		return ((String) getAttrVal("Name_emp_iss"));
	}
	/**
	 * 原票据领用人名称
	 * @param Name_emp_iss
	 */
	public void setName_emp_iss(String Name_emp_iss) {
		setAttrVal("Name_emp_iss", Name_emp_iss);
	}
	/**
	 * 原票据领用计算机名称
	 * @return String
	 */
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}
	/**
	 * 原票据领用计算机名称
	 * @param Name_pc
	 */
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
	}
	/**
	 * 票据转移接受人员名称
	 * @return String
	 */
	public String getName_emp_iss_tf() {
		return ((String) getAttrVal("Name_emp_iss_tf"));
	}
	/**
	 * 票据转移接受人员名称
	 * @param Name_emp_iss_tf
	 */
	public void setName_emp_iss_tf(String Name_emp_iss_tf) {
		setAttrVal("Name_emp_iss_tf", Name_emp_iss_tf);
	}
	/**
	 * 票据转移接受计算机名称
	 * @return String
	 */
	public String getName_pc_tf() {
		return ((String) getAttrVal("Name_pc_tf"));
	}
	/**
	 * 票据转移接受计算机名称
	 * @param Name_pc_tf
	 */
	public void setName_pc_tf(String Name_pc_tf) {
		setAttrVal("Name_pc_tf", Name_pc_tf);
	}
}