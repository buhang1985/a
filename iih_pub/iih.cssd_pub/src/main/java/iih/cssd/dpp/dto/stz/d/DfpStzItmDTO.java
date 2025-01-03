package iih.cssd.dpp.dto.stz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包灭菌明细 DTO数据 
 * 
 */
public class DfpStzItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 包灭菌子项
	 * @return String
	 */
	public String getId_dfp_stz_itm() {
		return ((String) getAttrVal("Id_dfp_stz_itm"));
	}
	/**
	 * 包灭菌子项
	 * @param Id_dfp_stz_itm
	 */
	public void setId_dfp_stz_itm(String Id_dfp_stz_itm) {
		setAttrVal("Id_dfp_stz_itm", Id_dfp_stz_itm);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 包名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}
	/**
	 * 包名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
	}
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar_dfp() {
		return ((String) getAttrVal("No_bar_dfp"));
	}
	/**
	 * 识别码
	 * @param No_bar_dfp
	 */
	public void setNo_bar_dfp(String No_bar_dfp) {
		setAttrVal("No_bar_dfp", No_bar_dfp);
	}
	/**
	 * 核对人
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}
	/**
	 * 核对人
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 核对人名称
	 * @return String
	 */
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}
	/**
	 * 核对人名称
	 * @param Name_emp_chk
	 */
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	/**
	 * 核对科室
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}
	/**
	 * 核对科室
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 核对科室名称
	 * @return String
	 */
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}
	/**
	 * 核对科室名称
	 * @param Name_dep_chk
	 */
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
	}
	/**
	 * 核对时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}
	/**
	 * 核对时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 包灭菌
	 * @return String
	 */
	public String getId_dfp_stz() {
		return ((String) getAttrVal("Id_dfp_stz"));
	}
	/**
	 * 包灭菌
	 * @param Id_dfp_stz
	 */
	public void setId_dfp_stz(String Id_dfp_stz) {
		setAttrVal("Id_dfp_stz", Id_dfp_stz);
	}
	/**
	 * 锅次
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 锅次
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 灭菌日期
	 * @return FDate
	 */
	public FDate getDt_stz() {
		return ((FDate) getAttrVal("Dt_stz"));
	}
	/**
	 * 灭菌日期
	 * @param Dt_stz
	 */
	public void setDt_stz(FDate Dt_stz) {
		setAttrVal("Dt_stz", Dt_stz);
	}
	/**
	 * 灭菌设备
	 * @return String
	 */
	public String getId_dfp_instr() {
		return ((String) getAttrVal("Id_dfp_instr"));
	}
	/**
	 * 灭菌设备
	 * @param Id_dfp_instr
	 */
	public void setId_dfp_instr(String Id_dfp_instr) {
		setAttrVal("Id_dfp_instr", Id_dfp_instr);
	}
	/**
	 * 灭菌设备名称
	 * @return String
	 */
	public String getName_dfp_instr() {
		return ((String) getAttrVal("Name_dfp_instr"));
	}
	/**
	 * 灭菌设备名称
	 * @param Name_dfp_instr
	 */
	public void setName_dfp_instr(String Name_dfp_instr) {
		setAttrVal("Name_dfp_instr", Name_dfp_instr);
	}
}