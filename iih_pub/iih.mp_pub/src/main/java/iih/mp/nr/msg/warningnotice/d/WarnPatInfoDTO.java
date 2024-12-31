package iih.mp.nr.msg.warningnotice.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 警告通知服务患者信息 DTO数据 
 * 
 */
public class WarnPatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者域ID
	 * @return String
	 */
	public String getPatientdomain() {
		return ((String) getAttrVal("Patientdomain"));
	}
	/**
	 * 患者域ID
	 * @param Patientdomain
	 */
	public void setPatientdomain(String Patientdomain) {
		setAttrVal("Patientdomain", Patientdomain);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientlid() {
		return ((String) getAttrVal("Patientlid"));
	}
	/**
	 * 患者ID
	 * @param Patientlid
	 */
	public void setPatientlid(String Patientlid) {
		setAttrVal("Patientlid", Patientlid);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatientname() {
		return ((String) getAttrVal("Patientname"));
	}
	/**
	 * 患者姓名
	 * @param Patientname
	 */
	public void setPatientname(String Patientname) {
		setAttrVal("Patientname", Patientname);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getGendercode() {
		return ((String) getAttrVal("Gendercode"));
	}
	/**
	 * 患者性别
	 * @param Gendercode
	 */
	public void setGendercode(String Gendercode) {
		setAttrVal("Gendercode", Gendercode);
	}
	/**
	 * 患者年龄
	 * @return Integer
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getVisitdate() {
		return ((FDateTime) getAttrVal("Visitdate"));
	}
	/**
	 * 就诊时间
	 * @param Visitdate
	 */
	public void setVisitdate(FDateTime Visitdate) {
		setAttrVal("Visitdate", Visitdate);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getVisittimes() {
		return ((Integer) getAttrVal("Visittimes"));
	}
	/**
	 * 就诊次数
	 * @param Visittimes
	 */
	public void setVisittimes(Integer Visittimes) {
		setAttrVal("Visittimes", Visittimes);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getVisitdept() {
		return ((String) getAttrVal("Visitdept"));
	}
	/**
	 * 所属科室
	 * @param Visitdept
	 */
	public void setVisitdept(String Visitdept) {
		setAttrVal("Visitdept", Visitdept);
	}
	/**
	 * 所属科室名称
	 * @return String
	 */
	public String getVisitdeptname() {
		return ((String) getAttrVal("Visitdeptname"));
	}
	/**
	 * 所属科室名称
	 * @param Visitdeptname
	 */
	public void setVisitdeptname(String Visitdeptname) {
		setAttrVal("Visitdeptname", Visitdeptname);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHospitalcode() {
		return ((String) getAttrVal("Hospitalcode"));
	}
	/**
	 * 医疗机构代码
	 * @param Hospitalcode
	 */
	public void setHospitalcode(String Hospitalcode) {
		setAttrVal("Hospitalcode", Hospitalcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHopitalname() {
		return ((String) getAttrVal("Hopitalname"));
	}
	/**
	 * 医疗机构名称
	 * @param Hopitalname
	 */
	public void setHopitalname(String Hopitalname) {
		setAttrVal("Hopitalname", Hopitalname);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getWardsno() {
		return ((String) getAttrVal("Wardsno"));
	}
	/**
	 * 病区
	 * @param Wardsno
	 */
	public void setWardsno(String Wardsno) {
		setAttrVal("Wardsno", Wardsno);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}
	/**
	 * 床号
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelcom() {
		return ((String) getAttrVal("Telcom"));
	}
	/**
	 * 联系电话
	 * @param Telcom
	 */
	public void setTelcom(String Telcom) {
		setAttrVal("Telcom", Telcom);
	}
	/**
	 * 警告类型
	 * @return String
	 */
	public String getWarningtype() {
		return ((String) getAttrVal("Warningtype"));
	}
	/**
	 * 警告类型
	 * @param Warningtype
	 */
	public void setWarningtype(String Warningtype) {
		setAttrVal("Warningtype", Warningtype);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReportno() {
		return ((String) getAttrVal("Reportno"));
	}
	/**
	 * 报告号
	 * @param Reportno
	 */
	public void setReportno(String Reportno) {
		setAttrVal("Reportno", Reportno);
	}
	/**
	 * 报告链接
	 * @return String
	 */
	public String getReportlink() {
		return ((String) getAttrVal("Reportlink"));
	}
	/**
	 * 报告链接
	 * @param Reportlink
	 */
	public void setReportlink(String Reportlink) {
		setAttrVal("Reportlink", Reportlink);
	}
	/**
	 * 报告时间
	 * @return FDateTime
	 */
	public FDateTime getReportdate() {
		return ((FDateTime) getAttrVal("Reportdate"));
	}
	/**
	 * 报告时间
	 * @param Reportdate
	 */
	public void setReportdate(FDateTime Reportdate) {
		setAttrVal("Reportdate", Reportdate);
	}
	/**
	 * 报告确认时间
	 * @return FDateTime
	 */
	public FDateTime getReviewdate() {
		return ((FDateTime) getAttrVal("Reviewdate"));
	}
	/**
	 * 报告确认时间
	 * @param Reviewdate
	 */
	public void setReviewdate(FDateTime Reviewdate) {
		setAttrVal("Reviewdate", Reviewdate);
	}
	/**
	 * 警告项目分类
	 * @return FArrayList2
	 */
	public FArrayList2 getWarningitemcas() {
		return ((FArrayList2) getAttrVal("Warningitemcas"));
	}
	/**
	 * 警告项目分类
	 * @param Warningitemcas
	 */
	public void setWarningitemcas(FArrayList2 Warningitemcas) {
		setAttrVal("Warningitemcas", Warningitemcas);
	}
}