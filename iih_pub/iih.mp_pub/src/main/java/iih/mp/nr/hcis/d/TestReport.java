package iih.mp.nr.hcis.d;

import java.io.Serializable;
/**
 * 
* @ClassName: TestReport 
* @Description: 检验申请单(主记录)数据
* @author zhy
* @date 2019年5月23日 下午6:11:23 
*
 */
public class TestReport implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者唯一标识 ID(关联 ID)
	 */
	private String patient_id;
	
	/**
	 * 申请编号
	 */
	private String inspection_id;
	
	/**
	 * 申请科室
	 */
	private String  dept_name;
	
	/**
	 * 标本类型
	 */
	private String sample_class_name;
    
	/**
	 * 标本说明
	 */
	private String sample_notes;
	
	/**
	 * 检验项目名称
	 */
	private String test_order_name;
	
	/**
	 * 申请时间(格式: yyyy-MM-dd HH:mm:ss.fff)
	 */
	private String requisition_time;
	
	/**
	 * 申请人
	 */
	private String requisition_person;
	
	/**
	 * 采样时间(格式: yyyy-MM-dd HH:mm:ss.fff)
	 */
	private String sampling_time;
	
	/**
	 * 接收时间(格式: yyyy-MM-dd HH:mm:ss.fff)
	 */
	private String incept_time;
	
	/**
	 * 检验时间(格式: yyyy-MM-dd HH:mm:ss.fff)
	 */
	private String inspection_time;
	
	/**
	 * 检验人或报告人
	 */
	private String inspection_person;
	
	/**
	 * 报告生成时间(格式: yyyy-MM-dd HH:mm:ss.fff)
	 */
	private String report_time;

	public String getPatient_id() {
		return patient_id;
	}

	public String getInspection_id() {
		return inspection_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public String getSample_class_name() {
		return sample_class_name;
	}

	public String getSample_notes() {
		return sample_notes;
	}

	public String getTest_order_name() {
		return test_order_name;
	}

	public String getRequisition_time() {
		return requisition_time;
	}

	public String getRequisition_person() {
		return requisition_person;
	}

	public String getSampling_time() {
		return sampling_time;
	}

	public String getIncept_time() {
		return incept_time;
	}

	public String getInspection_time() {
		return inspection_time;
	}

	public String getInspection_person() {
		return inspection_person;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setInspection_id(String inspection_id) {
		this.inspection_id = inspection_id;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public void setSample_class_name(String sample_class_name) {
		this.sample_class_name = sample_class_name;
	}

	public void setSample_notes(String sample_notes) {
		this.sample_notes = sample_notes;
	}

	public void setTest_order_name(String test_order_name) {
		this.test_order_name = test_order_name;
	}

	public void setRequisition_time(String requisition_time) {
		this.requisition_time = requisition_time;
	}

	public void setRequisition_person(String requisition_person) {
		this.requisition_person = requisition_person;
	}

	public void setSampling_time(String sampling_time) {
		this.sampling_time = sampling_time;
	}

	public void setIncept_time(String incept_time) {
		this.incept_time = incept_time;
	}

	public void setInspection_time(String inspection_time) {
		this.inspection_time = inspection_time;
	}

	public void setInspection_person(String inspection_person) {
		this.inspection_person = inspection_person;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	
	
}
