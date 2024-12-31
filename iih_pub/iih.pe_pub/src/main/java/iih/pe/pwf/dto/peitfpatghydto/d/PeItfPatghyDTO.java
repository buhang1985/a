package iih.pe.pwf.dto.peitfpatghydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检病理报告DTO DTO数据 
 * 
 */
public class PeItfPatghyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 检查所见
	 * @return String
	 */
	public String getDes_rptpathgy() {
		return ((String) getAttrVal("Des_rptpathgy"));
	}
	/**
	 * 检查所见
	 * @param Des_rptpathgy
	 */
	public void setDes_rptpathgy(String Des_rptpathgy) {
		setAttrVal("Des_rptpathgy", Des_rptpathgy);
	}
	/**
	 * 报告单号
	 * @return String
	 */
	public String getNo_rptpathgy() {
		return ((String) getAttrVal("No_rptpathgy"));
	}
	/**
	 * 报告单号
	 * @param No_rptpathgy
	 */
	public void setNo_rptpathgy(String No_rptpathgy) {
		setAttrVal("No_rptpathgy", No_rptpathgy);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_pathgy() {
		return ((String) getAttrVal("Des_pathgy"));
	}
	/**
	 * 备注
	 * @param Des_pathgy
	 */
	public void setDes_pathgy(String Des_pathgy) {
		setAttrVal("Des_pathgy", Des_pathgy);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getDes_advice() {
		return ((String) getAttrVal("Des_advice"));
	}
	/**
	 * 建议
	 * @param Des_advice
	 */
	public void setDes_advice(String Des_advice) {
		setAttrVal("Des_advice", Des_advice);
	}
	/**
	 * 报告时间
	 * @return String
	 */
	public String getDt_rptpathgy() {
		return ((String) getAttrVal("Dt_rptpathgy"));
	}
	/**
	 * 报告时间
	 * @param Dt_rptpathgy
	 */
	public void setDt_rptpathgy(String Dt_rptpathgy) {
		setAttrVal("Dt_rptpathgy", Dt_rptpathgy);
	}
	/**
	 * 报告人
	 * @return String
	 */
	public String getCode_emp_rpt() {
		return ((String) getAttrVal("Code_emp_rpt"));
	}
	/**
	 * 报告人
	 * @param Code_emp_rpt
	 */
	public void setCode_emp_rpt(String Code_emp_rpt) {
		setAttrVal("Code_emp_rpt", Code_emp_rpt);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getCode_dep_rpt() {
		return ((String) getAttrVal("Code_dep_rpt"));
	}
	/**
	 * 报告科室
	 * @param Code_dep_rpt
	 */
	public void setCode_dep_rpt(String Code_dep_rpt) {
		setAttrVal("Code_dep_rpt", Code_dep_rpt);
	}
	/**
	 * 肉眼所见
	 * @return String
	 */
	public String getExam_para() {
		return ((String) getAttrVal("Exam_para"));
	}
	/**
	 * 肉眼所见
	 * @param Exam_para
	 */
	public void setExam_para(String Exam_para) {
		setAttrVal("Exam_para", Exam_para);
	}
	/**
	 * 镜下所见
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}
	/**
	 * 镜下所见
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
	}
	/**
	 * 诊断意见
	 * @return String
	 */
	public String getImpression() {
		return ((String) getAttrVal("Impression"));
	}
	/**
	 * 诊断意见
	 * @param Impression
	 */
	public void setImpression(String Impression) {
		setAttrVal("Impression", Impression);
	}
	/**
	 * 诊断医师
	 * @return String
	 */
	public String getCode_technician() {
		return ((String) getAttrVal("Code_technician"));
	}
	/**
	 * 诊断医师
	 * @param Code_technician
	 */
	public void setCode_technician(String Code_technician) {
		setAttrVal("Code_technician", Code_technician);
	}
	/**
	 * 审核医师
	 * @return String
	 */
	public String getCode_reporter() {
		return ((String) getAttrVal("Code_reporter"));
	}
	/**
	 * 审核医师
	 * @param Code_reporter
	 */
	public void setCode_reporter(String Code_reporter) {
		setAttrVal("Code_reporter", Code_reporter);
	}
}