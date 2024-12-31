package iih.bd.srv.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查项目DTO DTO数据 
 * 
 */
public class IEOpRisItmCateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE门诊检查项目分组主键标识
	 * @return String
	 */
	public String getId_ieoprisitmcate() {
		return ((String) getAttrVal("Id_ieoprisitmcate"));
	}
	/**
	 * IE门诊检查项目分组主键标识
	 * @param Id_ieoprisitmcate
	 */
	public void setId_ieoprisitmcate(String Id_ieoprisitmcate) {
		setAttrVal("Id_ieoprisitmcate", Id_ieoprisitmcate);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getAction() {
		return ((String) getAttrVal("Action"));
	}
	/**
	 * 操作类型
	 * @param Action
	 */
	public void setAction(String Action) {
		setAttrVal("Action", Action);
	}
	/**
	 * 分组编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 分组编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 分组名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 分组名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 报表头
	 * @return String
	 */
	public String getReport_header() {
		return ((String) getAttrVal("Report_header"));
	}
	/**
	 * 报表头
	 * @param Report_header
	 */
	public void setReport_header(String Report_header) {
		setAttrVal("Report_header", Report_header);
	}
	/**
	 * 报表尾
	 * @return String
	 */
	public String getReport_footer() {
		return ((String) getAttrVal("Report_footer"));
	}
	/**
	 * 报表尾
	 * @param Report_footer
	 */
	public void setReport_footer(String Report_footer) {
		setAttrVal("Report_footer", Report_footer);
	}
	/**
	 * 科室模板
	 * @return String
	 */
	public String getApply_template() {
		return ((String) getAttrVal("Apply_template"));
	}
	/**
	 * 科室模板
	 * @param Apply_template
	 */
	public void setApply_template(String Apply_template) {
		setAttrVal("Apply_template", Apply_template);
	}
	/**
	 * 对应报表号
	 * @return String
	 */
	public String getAppointment_report_code() {
		return ((String) getAttrVal("Appointment_report_code"));
	}
	/**
	 * 对应报表号
	 * @param Appointment_report_code
	 */
	public void setAppointment_report_code(String Appointment_report_code) {
		setAttrVal("Appointment_report_code", Appointment_report_code);
	}
	/**
	 * 提前分钟
	 * @return String
	 */
	public String getAhead_exam_time() {
		return ((String) getAttrVal("Ahead_exam_time"));
	}
	/**
	 * 提前分钟
	 * @param Ahead_exam_time
	 */
	public void setAhead_exam_time(String Ahead_exam_time) {
		setAttrVal("Ahead_exam_time", Ahead_exam_time);
	}
	/**
	 * 预约单条码号
	 * @return String
	 */
	public String getTm_report_code() {
		return ((String) getAttrVal("Tm_report_code"));
	}
	/**
	 * 预约单条码号
	 * @param Tm_report_code
	 */
	public void setTm_report_code(String Tm_report_code) {
		setAttrVal("Tm_report_code", Tm_report_code);
	}
	/**
	 * 是否扫描
	 * @return String
	 */
	public String getScan_flag() {
		return ((String) getAttrVal("Scan_flag"));
	}
	/**
	 * 是否扫描
	 * @param Scan_flag
	 */
	public void setScan_flag(String Scan_flag) {
		setAttrVal("Scan_flag", Scan_flag);
	}
	/**
	 * 是否称体重
	 * @return String
	 */
	public String getWeight_flag() {
		return ((String) getAttrVal("Weight_flag"));
	}
	/**
	 * 是否称体重
	 * @param Weight_flag
	 */
	public void setWeight_flag(String Weight_flag) {
		setAttrVal("Weight_flag", Weight_flag);
	}
	/**
	 * 是否同一天
	 * @return String
	 */
	public String getSame_day_flag() {
		return ((String) getAttrVal("Same_day_flag"));
	}
	/**
	 * 是否同一天
	 * @param Same_day_flag
	 */
	public void setSame_day_flag(String Same_day_flag) {
		setAttrVal("Same_day_flag", Same_day_flag);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
}