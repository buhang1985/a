package iih.ei.std.consis.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.vo.pub.formulaset.function.Date;


/**
 * 处方信息JavaBean对象
 * 
 * @author dj.zhang
 * @data 2018年7月12日上午10:24:04
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescInforParamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "PRESC_DATE")
	private String presc_date;
	@XmlElement(name = "PRESC_NO")
	private String presc_no;
	@XmlElement(name = "DISPENSARY")
	private String dispensary;
	@XmlElement(name = "PATIENT_ID")
	private String patient_id;
	@XmlElement(name = "PATIENT_NAME")
	private String patient_name;
	@XmlElement(name = "INVOICE_NO")
	private String invoice_no;
	@XmlElement(name = "PATIENT_TYPE")
	private String patient_type;
	@XmlElement(name = "DATE_OF_BIRTH")
	private String date_of_birth;
	@XmlElement(name = "SEX")
	private String sex;
	@XmlElement(name = "PRESC_IDENTITY")
	private String presc_identity;
	@XmlElement(name = "CHARGE_TYPE")
	private String charge_type;
	@XmlElement(name = "PRESC_ATTR")
	private String presc_attr;
	@XmlElement(name = "PRESC_INFO")
	private String presc_info;
	@XmlElement(name = "RCPT_INFO")
	private String rcpt_info;
	@XmlElement(name = "RCPT_REMARK")
	private String rcpt_remark;
	@XmlElement(name = "REPETITION")
	private Integer repetition;
	@XmlElement(name = "COSTS")
	private Double costs;
	@XmlElement(name = "PAYMENTS")
	private Double payments;
	@XmlElement(name = "ORDERED_BY")
	private String ordered_by;
	@XmlElement(name = "ORDERED_BY_NAME")
	private String ordered_by_name;
	@XmlElement(name = "PRESCRIBED_BY")
	private String prescribed_by;
	@XmlElement(name = "ENTERED_BY")
	private String entered_by;
	@XmlElement(name = "DISPENSE_PRI")
	private Integer dispense_pri;

	@XmlElement(name = "CONSIS_PRESC_DTLVW")
	private PrescInforParamBeanDetail[] _prescBeanDetails;

	/**
	 * 处方明细信息
	 * 
	 * @return
	 */
	public PrescInforParamBeanDetail[] get_prescBeanDetails() {
		return _prescBeanDetails;
	}

	/**
	 * 处方明细信息
	 * 
	 * @param _prescBeanDetails
	 */
	public void set_prescBeanDetails(PrescInforParamBeanDetail[] _prescBeanDetails) {
		this._prescBeanDetails = _prescBeanDetails;
	}

	/**
	 * 处方时间
	 * 
	 * @return
	 */
	public String getPresc_date() {
		return presc_date;
	}

	/**
	 * 处方时间
	 * 
	 * @param presc_date
	 */
	public void setPresc_date(String presc_date) {
		this.presc_date = presc_date;
	}

	/**
	 * 处方编号
	 * 
	 * @return
	 */
	public String getPresc_no() {
		return presc_no;
	}

	/**
	 * 处方编号
	 * 
	 * @param presc_no
	 */
	public void setPresc_no(String presc_no) {
		this.presc_no = presc_no;
	}

	/**
	 * 发药药局编号
	 * 
	 * @return
	 */
	public String getDispensary() {
		return dispensary;
	}

	/**
	 * 发药药局编号
	 * 
	 * @param dispensary
	 */
	public void setDispensary(String dispensary) {
		this.dispensary = dispensary;
	}

	/**
	 * 就诊卡号
	 * 
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * 就诊卡号
	 * 
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * 患者姓名
	 * 
	 * @return
	 */
	public String getPatient_name() {
		return patient_name;
	}

	/**
	 * 患者姓名
	 * 
	 * @param patient_name
	 */
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	/**
	 * 发票编号
	 * 
	 * @return
	 */
	public String getInvoice_no() {
		return invoice_no;
	}

	/**
	 * 发票编号
	 * 
	 * @param invoice_no
	 */
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	/**
	 * 患者类型 ‘00’ 普通 ‘01’ 特需
	 * 
	 * @return
	 */
	public String getPatient_type() {
		return patient_type;
	}

	/**
	 * 患者类型 ‘00’ 普通 ‘01’ 特需
	 * 
	 * @param patient_type
	 */
	public void setPatient_type(String patient_type) {
		this.patient_type = patient_type;
	}

	/**
	 * 患者出生日期
	 * 
	 * @return
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * 患者出生日期
	 * 
	 * @param date_of_birth
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * 患者性别(男/女)
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 患者性别(男/女)
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 患者身份
	 * 
	 * @return
	 */
	public String getPresc_identity() {
		return presc_identity;
	}

	/**
	 * 患者身份
	 * 
	 * @param presc_identity
	 */
	public void setPresc_identity(String presc_identity) {
		this.presc_identity = presc_identity;
	}

	/**
	 * 医保类型
	 * 
	 * @return
	 */
	public String getCharge_type() {
		return charge_type;
	}

	/**
	 * 医保类型
	 * 
	 * @param charge_type
	 */
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	/**
	 * 处方属性手工处方，临时处方等文本信息
	 * 
	 * @return
	 */
	public String getPresc_attr() {
		return presc_attr;
	}

	/**
	 * 处方属性手工处方，临时处方等文本信息
	 * 
	 * @param presc_attr
	 */
	public void setPresc_attr(String presc_attr) {
		this.presc_attr = presc_attr;
	}

	/**
	 * 处方类型 费用相关处方类型文本信息（计费方式）
	 * 
	 * @return
	 */
	public String getPresc_info() {
		return presc_info;
	}

	/**
	 * 处方类型 费用相关处方类型文本信息（计费方式）
	 * 
	 * @param presc_info
	 */
	public void setPresc_info(String presc_info) {
		this.presc_info = presc_info;
	}

	/**
	 * 诊断信息
	 * 
	 * @return
	 */
	public String getRcpt_info() {
		return rcpt_info;
	}

	/**
	 * 诊断信息
	 * 
	 * @param rcpt_info
	 */
	public void setRcpt_info(String rcpt_info) {
		this.rcpt_info = rcpt_info;
	}

	/**
	 * 处方备注信息
	 * 
	 * @return
	 */
	public String getRcpt_remark() {
		return rcpt_remark;
	}

	/**
	 * 处方备注信息
	 * 
	 * @param rcpt_remark
	 */
	public void setRcpt_remark(String rcpt_remark) {
		this.rcpt_remark = rcpt_remark;
	}

	/**
	 * 剂数
	 * 
	 * @return
	 */
	public Integer getRepetition() {
		return repetition;
	}

	/**
	 * 剂数
	 * 
	 * @param repetition
	 */
	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

	/**
	 * 费用
	 * 
	 * @return
	 */
	public Double getCosts() {
		return costs;
	}

	/**
	 * 费用
	 * 
	 * @param costs
	 */
	public void setCosts(Double costs) {
		this.costs = costs;
	}

	/**
	 * 实付费用
	 * 
	 * @return
	 */
	public Double getPayments() {
		return payments;
	}

	/**
	 * 实付费用
	 * 
	 * @param payments
	 */
	public void setPayments(Double payments) {
		this.payments = payments;
	}

	/**
	 * 开单科室编号
	 * 
	 * @return
	 */
	public String getOrdered_by() {
		return ordered_by;
	}

	/**
	 * 开单科室编号
	 * 
	 * @param ordered_by
	 */
	public void setOrdered_by(String ordered_by) {
		this.ordered_by = ordered_by;
	}

	/**
	 * 开单科室名称
	 * 
	 * @return
	 */
	public String getOrdered_by_name() {
		return ordered_by_name;
	}

	/**
	 * 开单科室名称
	 * 
	 * @param ordered_by_name
	 */
	public void setOrdered_by_name(String ordered_by_name) {
		this.ordered_by_name = ordered_by_name;
	}

	/**
	 * 开方医生
	 * 
	 * @return
	 */
	public String getPrescribed_by() {
		return prescribed_by;
	}

	/**
	 * 开方医生
	 * 
	 * @param prescribed_by
	 */
	public void setPrescribed_by(String prescribed_by) {
		this.prescribed_by = prescribed_by;
	}

	/**
	 * 录方人
	 * 
	 * @return
	 */
	public String getEntered_by() {
		return entered_by;
	}

	/**
	 * 录方人
	 * 
	 * @param entered_by
	 */
	public void setEntered_by(String entered_by) {
		this.entered_by = entered_by;
	}

	/**
	 * 配药优先级（付费处到药房距离）数字从小到大表示优先级从高到低
	 * 
	 * @return
	 */
	public Integer getDispense_pri() {
		return dispense_pri;
	}

	/**
	 * 配药优先级（付费处到药房距离）数字从小到大表示优先级从高到低
	 * 
	 * @param dispense_pri
	 */
	public void setDispense_pri(Integer dispense_pri) {
		this.dispense_pri = dispense_pri;
	}
}
