package iih.ei.een.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 取门诊有效的医生排班队列bean
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetOpQueListBean extends BaseWsParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 队列id
	 */
	private String id_que = "";
	/**
	 * 队列编码
	 */
	private String code_que = "";
	/**
	 * 队列名称
	 */
	private String name_que = "";
	/**
	 * 队列描述
	 */
	private String des_que = "";
	/**
	 * 科室编码
	 */
	private String code_dep = "";
	/**
	 * 科室名称
	 */
	private String name_dep = "";
	
	public String getId_que() {
		return id_que;
	}
	public void setId_que(String id_que) {
		this.id_que = id_que;
	}
	public String getCode_que() {
		return code_que;
	}
	public void setCode_que(String code_que) {
		this.code_que = code_que;
	}
	public String getName_que() {
		return name_que;
	}
	public void setName_que(String name_que) {
		this.name_que = name_que;
	}
	public String getDes_que() {
		return des_que;
	}
	public void setDes_que(String des_que) {
		this.des_que = des_que;
	}
	public String getCode_dep() {
		return code_dep;
	}
	public void setCode_dep(String code_dep) {
		this.code_dep = code_dep;
	}
	public String getName_dep() {
		return name_dep;
	}
	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}
	
}
