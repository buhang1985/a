package iih.cssd.dpp.dto.stz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 灭菌查询方案 DTO数据 
 * 
 */
public class QueryStzDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 灭菌器
	 * @return String
	 */
	public String getId_dfp_instr() {
		return ((String) getAttrVal("Id_dfp_instr"));
	}
	/**
	 * 灭菌器
	 * @param Id_dfp_instr
	 */
	public void setId_dfp_instr(String Id_dfp_instr) {
		setAttrVal("Id_dfp_instr", Id_dfp_instr);
	}
	/**
	 * 灭菌器名称
	 * @return String
	 */
	public String getName_dfp_instr() {
		return ((String) getAttrVal("Name_dfp_instr"));
	}
	/**
	 * 灭菌器名称
	 * @param Name_dfp_instr
	 */
	public void setName_dfp_instr(String Name_dfp_instr) {
		setAttrVal("Name_dfp_instr", Name_dfp_instr);
	}
	/**
	 * 灭菌方式id
	 * @return String
	 */
	public String getId_pkgstz() {
		return ((String) getAttrVal("Id_pkgstz"));
	}
	/**
	 * 灭菌方式id
	 * @param Id_pkgstz
	 */
	public void setId_pkgstz(String Id_pkgstz) {
		setAttrVal("Id_pkgstz", Id_pkgstz);
	}
	/**
	 * 灭菌方式名称
	 * @return String
	 */
	public String getName_pkgstz() {
		return ((String) getAttrVal("Name_pkgstz"));
	}
	/**
	 * 灭菌方式名称
	 * @param Name_pkgstz
	 */
	public void setName_pkgstz(String Name_pkgstz) {
		setAttrVal("Name_pkgstz", Name_pkgstz);
	}
	/**
	 * 灭菌程序
	 * @return String
	 */
	public String getId_pro() {
		return ((String) getAttrVal("Id_pro"));
	}
	/**
	 * 灭菌程序
	 * @param Id_pro
	 */
	public void setId_pro(String Id_pro) {
		setAttrVal("Id_pro", Id_pro);
	}
	/**
	 * 灭菌程序名称
	 * @return String
	 */
	public String getName_pro() {
		return ((String) getAttrVal("Name_pro"));
	}
	/**
	 * 灭菌程序名称
	 * @param Name_pro
	 */
	public void setName_pro(String Name_pro) {
		setAttrVal("Name_pro", Name_pro);
	}
	/**
	 * 灭菌结果id
	 * @return String
	 */
	public String getId_result() {
		return ((String) getAttrVal("Id_result"));
	}
	/**
	 * 灭菌结果id
	 * @param Id_result
	 */
	public void setId_result(String Id_result) {
		setAttrVal("Id_result", Id_result);
	}
	/**
	 * 灭菌结果名称
	 * @return String
	 */
	public String getName_result() {
		return ((String) getAttrVal("Name_result"));
	}
	/**
	 * 灭菌结果名称
	 * @param Name_result
	 */
	public void setName_result(String Name_result) {
		setAttrVal("Name_result", Name_result);
	}
	/**
	 * 灭菌开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stz_start() {
		return ((FDateTime) getAttrVal("Dt_stz_start"));
	}
	/**
	 * 灭菌开始时间
	 * @param Dt_stz_start
	 */
	public void setDt_stz_start(FDateTime Dt_stz_start) {
		setAttrVal("Dt_stz_start", Dt_stz_start);
	}
	/**
	 * 灭菌结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stz_end() {
		return ((FDateTime) getAttrVal("Dt_stz_end"));
	}
	/**
	 * 灭菌结束时间
	 * @param Dt_stz_end
	 */
	public void setDt_stz_end(FDateTime Dt_stz_end) {
		setAttrVal("Dt_stz_end", Dt_stz_end);
	}
	/**
	 * 灭菌人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 灭菌人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 灭菌人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 灭菌人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
}