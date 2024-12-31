package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 医生字典JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindDoctorDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "DOCTOR_NO")
	private String doctor_no;
	@XmlElement(name = "DOCTOR_NAME")
	private String doctor_name;
	@XmlElement(name = "DEPARTMENT_NO")
	private String department_no;
	@XmlElement(name = "DEPARTMENTNAME")
	private String departmentname;
	@XmlElement(name = "BEIZHU")
	private String beizhu;

	/**
	 * 医生编号
	 * 
	 * @return
	 */
	public String getDoctor_no() {
		return doctor_no;
	}

	/**
	 * @param doctor_no
	 */
	public void setDoctor_no(String doctor_no) {
		this.doctor_no = doctor_no;
	}

	/**
	 * 医生名称
	 * 
	 * @return
	 */
	public String getDoctor_name() {
		return doctor_name;
	}

	/**
	 * 医生名称
	 * 
	 * @param doctor_name
	 */
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	/**
	 * 部门编号
	 * 
	 * @return
	 */
	public String getDepartment_no() {
		return department_no;
	}

	/**
	 * 部门编号
	 * 
	 * @param department_no
	 */
	public void setDepartment_no(String department_no) {
		this.department_no = department_no;
	}

	/**
	 * 部门名称
	 * 
	 * @return
	 */
	public String getDepartmentname() {
		return departmentname;
	}

	/**
	 * 部门名称
	 * 
	 * @param departmentname
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	/**
	 * 备注
	 * 
	 * @return
	 */
	public String getBeizhu() {
		return beizhu;
	}

	/**
	 * 备注
	 * 
	 * @param beizhu
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}
