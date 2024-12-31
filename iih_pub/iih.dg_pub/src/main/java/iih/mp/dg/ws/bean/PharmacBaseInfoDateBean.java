package iih.mp.dg.ws.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 药师基本信息数据JavaBean
 * 
 * @author dj.zhang
 * @data 2018年8月12日下午7:12:22
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PharmacBaseInfoDateBean extends BaseWsParam {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "STAFFERID")
	private String stafferid;
	@XmlElement(name = "STAFFERNO")
	private String stafferno;
	@XmlElement(name = "DEPTCODE")
	private String deptcode;
	@XmlElement(name = "STAFFERNAME")
	private String staffername;
	@XmlElement(name = "JOB")
	private String job;
	@XmlElement(name = "TITLE")
	private String title;

	/**
	 * 药师编号
	 * 
	 * @return
	 */
	public String getStafferid() {
		return stafferid;
	}

	/**
	 * 药师编号
	 * 
	 * @param stafferid
	 */
	public void setStafferid(String stafferid) {
		this.stafferid = stafferid;
	}

	/**
	 * 药师工号
	 * 
	 * @return
	 */
	public String getStafferno() {
		return stafferno;
	}

	/**
	 * 药师工号
	 * 
	 * @param stafferno
	 */
	public void setStafferno(String stafferno) {
		this.stafferno = stafferno;
	}

	/**
	 * 科室编号
	 * 
	 * @return
	 */
	public String getDeptcode() {
		return deptcode;
	}

	/**
	 * 科室编号
	 * 
	 * @param deptcode
	 */
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	/**
	 * 药师姓名
	 * 
	 * @return
	 */
	public String getStaffername() {
		return staffername;
	}

	/**
	 * 药师姓名
	 * 
	 * @param staffername
	 */
	public void setStaffername(String staffername) {
		this.staffername = staffername;
	}

	/**
	 * 工作类别
	 * 
	 * @return
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 工作类别
	 * 
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * 职称
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 职称
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
