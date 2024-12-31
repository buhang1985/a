package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 获取就诊记录-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntListByDeptCodeParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 开始时间
	 */
	private String dtBegin;
	/**
	 * 结束时间
	 */
	private String dtEnd;
	/**
	 * 科室编码
	 */
	private String deptCode;
	/**
	 * 就诊编号
	 */
	private String entCode;
	/**
	 * 就诊类型
	 */
	private String entpCode;
	
	public String getDtBegin() {
		return dtBegin;
	}
	public void setDtBegin(String dtBegin) {
		this.dtBegin = dtBegin;
	}
	public String getDtEnd() {
		return dtEnd;
	}
	public void setDtEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getEntCode() {
		return entCode;
	}
	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}
	public String getEntpCode() {
		return entpCode;
	}
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}

}
