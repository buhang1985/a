package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 取分诊台可分诊挂号记录-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntLisByQuebencodeParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 患者ID
	 */
	private String patCode;
	/**
	 * 分诊台编码
	 */
	private String queBenCode;
	/**
	 * 操作员
	 */
	private String oprCode;
	
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getQueBenCode() {
		return queBenCode;
	}
	public void setQueBenCode(String queBenCode) {
		this.queBenCode = queBenCode;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

}
