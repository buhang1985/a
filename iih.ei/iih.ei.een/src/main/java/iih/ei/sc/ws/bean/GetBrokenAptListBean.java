package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 获取患者爽约记录
 * @author Administrator
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetBrokenAptListBean extends BaseWsParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录id
	 */
	private String id_key;
	/**
	 * 患者编号
	 */
	private String patCode;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 号别编码
	 */
	private String scsrv_code;
	/**
	 * 号别名称
	 */
	private String scsrv_name;
	/**
	 * 患者电话
	 */
	private String mobile;
	/**
	 * 爽约日期
	 */
	private String dt_act;
	/**
	 * 爽约类型
	 */
	private String eu_bbrtp;
	
	public String getId_key() {
		return id_key;
	}
	public void setId_key(String id_key) {
		this.id_key = id_key;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getScsrv_code() {
		return scsrv_code;
	}
	public void setScsrv_code(String scsrv_code) {
		this.scsrv_code = scsrv_code;
	}
	public String getScsrv_name() {
		return scsrv_name;
	}
	public void setScsrv_name(String scsrv_name) {
		this.scsrv_name = scsrv_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDt_act() {
		return dt_act;
	}
	public void setDt_act(String dt_act) {
		this.dt_act = dt_act;
	}
	public String getEu_bbrtp() {
		return eu_bbrtp;
	}
	public void setEu_bbrtp(String eu_bbrtp) {
		this.eu_bbrtp = eu_bbrtp;
	}
	
}
