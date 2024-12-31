package iih.cssd.dpp.dto.stz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 包灭菌结果录入 DTO数据 
 * 
 */
public class StzResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 监测包ID
	 * @return String
	 */
	public String getId_dfp_stz_itm() {
		return ((String) getAttrVal("Id_dfp_stz_itm"));
	}
	/**
	 * 监测包ID
	 * @param Id_dfp_stz_itm
	 */
	public void setId_dfp_stz_itm(String Id_dfp_stz_itm) {
		setAttrVal("Id_dfp_stz_itm", Id_dfp_stz_itm);
	}
	/**
	 * 包灭菌ID
	 * @return String
	 */
	public String getId_dfp_stz() {
		return ((String) getAttrVal("Id_dfp_stz"));
	}
	/**
	 * 包灭菌ID
	 * @param Id_dfp_stz
	 */
	public void setId_dfp_stz(String Id_dfp_stz) {
		setAttrVal("Id_dfp_stz", Id_dfp_stz);
	}
	/**
	 * 包类型
	 * @return String
	 */
	public String getName_eu_tp() {
		return ((String) getAttrVal("Name_eu_tp"));
	}
	/**
	 * 包类型
	 * @param Name_eu_tp
	 */
	public void setName_eu_tp(String Name_eu_tp) {
		setAttrVal("Name_eu_tp", Name_eu_tp);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 条码号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 灭菌结果
	 * @return String
	 */
	public String getName_result() {
		return ((String) getAttrVal("Name_result"));
	}
	/**
	 * 灭菌结果
	 * @param Name_result
	 */
	public void setName_result(String Name_result) {
		setAttrVal("Name_result", Name_result);
	}
	/**
	 * 已出结果标记
	 * @return String
	 */
	public String getFg_result() {
		return ((String) getAttrVal("Fg_result"));
	}
	/**
	 * 已出结果标记
	 * @param Fg_result
	 */
	public void setFg_result(String Fg_result) {
		setAttrVal("Fg_result", Fg_result);
	}
	/**
	 * 灭菌器
	 * @return String
	 */
	public String getName_dfp_instr() {
		return ((String) getAttrVal("Name_dfp_instr"));
	}
	/**
	 * 灭菌器
	 * @param Name_dfp_instr
	 */
	public void setName_dfp_instr(String Name_dfp_instr) {
		setAttrVal("Name_dfp_instr", Name_dfp_instr);
	}
	/**
	 * 灭菌批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 灭菌批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 灭菌方式
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}
	/**
	 * 灭菌方式
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}
	/**
	 * 灭菌程序
	 * @return String
	 */
	public String getName_pro() {
		return ((String) getAttrVal("Name_pro"));
	}
	/**
	 * 灭菌程序
	 * @param Name_pro
	 */
	public void setName_pro(String Name_pro) {
		setAttrVal("Name_pro", Name_pro);
	}
	/**
	 * 灭菌开始时间
	 * @return String
	 */
	public String getDt_stz() {
		return ((String) getAttrVal("Dt_stz"));
	}
	/**
	 * 灭菌开始时间
	 * @param Dt_stz
	 */
	public void setDt_stz(String Dt_stz) {
		setAttrVal("Dt_stz", Dt_stz);
	}
	/**
	 * 灭菌人
	 * @return String
	 */
	public String getName_emp_stz() {
		return ((String) getAttrVal("Name_emp_stz"));
	}
	/**
	 * 灭菌人
	 * @param Name_emp_stz
	 */
	public void setName_emp_stz(String Name_emp_stz) {
		setAttrVal("Name_emp_stz", Name_emp_stz);
	}
	/**
	 * 灭菌科室
	 * @return String
	 */
	public String getName_dep_stz() {
		return ((String) getAttrVal("Name_dep_stz"));
	}
	/**
	 * 灭菌科室
	 * @param Name_dep_stz
	 */
	public void setName_dep_stz(String Name_dep_stz) {
		setAttrVal("Name_dep_stz", Name_dep_stz);
	}
}