package iih.bl.inc.blinctransfer.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发票票据转移 DTO数据 
 * 
 */
public class BlIncTransferDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 票据分类ID
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}
	/**
	 * 票据分类ID
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}
	/**
	 * 票据包编号
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 领用日期
	 * @return FDateTime
	 */
	public FDateTime getDt_iss() {
		return ((FDateTime) getAttrVal("Dt_iss"));
	}
	/**
	 * 领用日期
	 * @param Dt_iss
	 */
	public void setDt_iss(FDateTime Dt_iss) {
		setAttrVal("Dt_iss", Dt_iss);
	}
	/**
	 * 领用票据开始号
	 * @return String
	 */
	public String getNum_b() {
		return ((String) getAttrVal("Num_b"));
	}
	/**
	 * 领用票据开始号
	 * @param Num_b
	 */
	public void setNum_b(String Num_b) {
		setAttrVal("Num_b", Num_b);
	}
	/**
	 * 领用票据结束号
	 * @return String
	 */
	public String getNum_e() {
		return ((String) getAttrVal("Num_e"));
	}
	/**
	 * 领用票据结束号
	 * @param Num_e
	 */
	public void setNum_e(String Num_e) {
		setAttrVal("Num_e", Num_e);
	}
	/**
	 * 下次使用票据号
	 * @return String
	 */
	public String getIncno_cur() {
		return ((String) getAttrVal("Incno_cur"));
	}
	/**
	 * 下次使用票据号
	 * @param Incno_cur
	 */
	public void setIncno_cur(String Incno_cur) {
		setAttrVal("Incno_cur", Incno_cur);
	}
	/**
	 * 当前使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_curuse() {
		return ((FBoolean) getAttrVal("Fg_curuse"));
	}
	/**
	 * 当前使用标志
	 * @param Fg_curuse
	 */
	public void setFg_curuse(FBoolean Fg_curuse) {
		setAttrVal("Fg_curuse", Fg_curuse);
	}
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
	 * 票据转移接受人名称
	 * @return String
	 */
	public String getName_emp_iss_tf() {
		return ((String) getAttrVal("Name_emp_iss_tf"));
	}
	/**
	 * 票据转移接受人名称
	 * @param Name_emp_iss_tf
	 */
	public void setName_emp_iss_tf(String Name_emp_iss_tf) {
		setAttrVal("Name_emp_iss_tf", Name_emp_iss_tf);
	}
	/**
	 * 原领用计算机ID
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}
	/**
	 * 原领用计算机ID
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 原领用计算机名称
	 * @return String
	 */
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}
	/**
	 * 原领用计算机名称
	 * @param Name_pc
	 */
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
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
	/**
	 * 票据领用ID
	 * @return String
	 */
	public String getId_inc_iss() {
		return ((String) getAttrVal("Id_inc_iss"));
	}
	/**
	 * 票据领用ID
	 * @param Id_inc_iss
	 */
	public void setId_inc_iss(String Id_inc_iss) {
		setAttrVal("Id_inc_iss", Id_inc_iss);
	}
	/**
	 * 票据转移id
	 * @return String
	 */
	public String getId_iss_tf() {
		return ((String) getAttrVal("Id_iss_tf"));
	}
	/**
	 * 票据转移id
	 * @param Id_iss_tf
	 */
	public void setId_iss_tf(String Id_iss_tf) {
		setAttrVal("Id_iss_tf", Id_iss_tf);
	}
	/**
	 * 票据分类名称
	 * @return String
	 */
	public String getName_innca() {
		return ((String) getAttrVal("Name_innca"));
	}
	/**
	 * 票据分类名称
	 * @param Name_innca
	 */
	public void setName_innca(String Name_innca) {
		setAttrVal("Name_innca", Name_innca);
	}
}