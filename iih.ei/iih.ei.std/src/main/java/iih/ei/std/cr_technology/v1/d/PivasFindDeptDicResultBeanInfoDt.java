package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 科室基本信息JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindDeptDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "DEPARTMENT_NO")
	private String department_no;
	@XmlElement(name = "DEPARTMENTNAME")
	private String departmentname;
	@XmlElement(name = "CLASS_NO")
	private String class_no;

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
	 * 部门名称(汉字)
	 * 
	 * @return
	 */
	public String getDepartmentname() {
		return departmentname;
	}

	/**
	 * 部门名称(汉字)
	 * 
	 * @param departmentname
	 */
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	/**
	 * 分类
	 * 
	 * @return
	 */
	public String getClass_no() {
		return class_no;
	}

	/**
	 * 分类
	 * 
	 * @param class_no
	 */
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}

}
