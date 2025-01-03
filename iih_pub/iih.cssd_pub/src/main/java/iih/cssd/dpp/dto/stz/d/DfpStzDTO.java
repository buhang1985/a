package iih.cssd.dpp.dto.stz.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包灭菌DTO DTO数据 
 * 
 */
public class DfpStzDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 灭菌id
	 * @return String
	 */
	public String getId_dfp_stz() {
		return ((String) getAttrVal("Id_dfp_stz"));
	}
	/**
	 * 灭菌id
	 * @param Id_dfp_stz
	 */
	public void setId_dfp_stz(String Id_dfp_stz) {
		setAttrVal("Id_dfp_stz", Id_dfp_stz);
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
	/**
	 * 灭菌方式
	 * @return String
	 */
	public String getId_pkgstz() {
		return ((String) getAttrVal("Id_pkgstz"));
	}
	/**
	 * 灭菌方式
	 * @param Id_pkgstz
	 */
	public void setId_pkgstz(String Id_pkgstz) {
		setAttrVal("Id_pkgstz", Id_pkgstz);
	}
	/**
	 * 灭菌方式编码
	 * @return String
	 */
	public String getSd_pkgstz() {
		return ((String) getAttrVal("Sd_pkgstz"));
	}
	/**
	 * 灭菌方式编码
	 * @param Sd_pkgstz
	 */
	public void setSd_pkgstz(String Sd_pkgstz) {
		setAttrVal("Sd_pkgstz", Sd_pkgstz);
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
	 * 灭菌开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 灭菌开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 灭菌结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 灭菌结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 灭菌人
	 * @return String
	 */
	public String getId_emp_stz() {
		return ((String) getAttrVal("Id_emp_stz"));
	}
	/**
	 * 灭菌人
	 * @param Id_emp_stz
	 */
	public void setId_emp_stz(String Id_emp_stz) {
		setAttrVal("Id_emp_stz", Id_emp_stz);
	}
	/**
	 * 灭菌人名称
	 * @return String
	 */
	public String getName_emp_stz() {
		return ((String) getAttrVal("Name_emp_stz"));
	}
	/**
	 * 灭菌人名称
	 * @param Name_emp_stz
	 */
	public void setName_emp_stz(String Name_emp_stz) {
		setAttrVal("Name_emp_stz", Name_emp_stz);
	}
	/**
	 * 灭菌科室
	 * @return String
	 */
	public String getId_dep_stz() {
		return ((String) getAttrVal("Id_dep_stz"));
	}
	/**
	 * 灭菌科室
	 * @param Id_dep_stz
	 */
	public void setId_dep_stz(String Id_dep_stz) {
		setAttrVal("Id_dep_stz", Id_dep_stz);
	}
	/**
	 * 灭菌科室名称
	 * @return String
	 */
	public String getName_dep_stz() {
		return ((String) getAttrVal("Name_dep_stz"));
	}
	/**
	 * 灭菌科室名称
	 * @param Name_dep_stz
	 */
	public void setName_dep_stz(String Name_dep_stz) {
		setAttrVal("Name_dep_stz", Name_dep_stz);
	}
	/**
	 * 锅次
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 锅次
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 灭菌锅次码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 灭菌锅次码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
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
	 * 灭菌结果编码
	 * @return String
	 */
	public String getSd_result() {
		return ((String) getAttrVal("Sd_result"));
	}
	/**
	 * 灭菌结果编码
	 * @param Sd_result
	 */
	public void setSd_result(String Sd_result) {
		setAttrVal("Sd_result", Sd_result);
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
	 * 灭菌程序id
	 * @return String
	 */
	public String getId_pro() {
		return ((String) getAttrVal("Id_pro"));
	}
	/**
	 * 灭菌程序id
	 * @param Id_pro
	 */
	public void setId_pro(String Id_pro) {
		setAttrVal("Id_pro", Id_pro);
	}
	/**
	 * 灭菌程序编码
	 * @return String
	 */
	public String getSd_pro() {
		return ((String) getAttrVal("Sd_pro"));
	}
	/**
	 * 灭菌程序编码
	 * @param Sd_pro
	 */
	public void setSd_pro(String Sd_pro) {
		setAttrVal("Sd_pro", Sd_pro);
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
	 * 灭菌包数量
	 * @return Integer
	 */
	public Integer getNum_dfps() {
		return ((Integer) getAttrVal("Num_dfps"));
	}
	/**
	 * 灭菌包数量
	 * @param Num_dfps
	 */
	public void setNum_dfps(Integer Num_dfps) {
		setAttrVal("Num_dfps", Num_dfps);
	}
	/**
	 * 灭菌明细
	 * @return FArrayList
	 */
	public FArrayList getArrayitms() {
		return ((FArrayList) getAttrVal("Arrayitms"));
	}
	/**
	 * 灭菌明细
	 * @param Arrayitms
	 */
	public void setArrayitms(FArrayList Arrayitms) {
		setAttrVal("Arrayitms", Arrayitms);
	}
}