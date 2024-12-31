package iih.en.itf.bean.input.opapt;

import iih.en.itf.bean.input.WsEnParam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 挂号划价(医保流程调用)Ws入参 
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnParamRegPricing extends WsEnParam {

	private static final long serialVersionUID = 1L;
	/**
	 * 患者编码
	 */
	@XmlElement(name = "patCode")
	private String patCode;
	/**
	 * 排班服务编码
	 */
	@XmlElement(name = "code_scsrv")
	private String code_scsrv;
	/**
	 * 医保产品编码
	 */
	@XmlElement(name = "code_hp")
	private String code_hp;
	/**
	 * 操作科室
	 */
	@XmlElement(name = "code_dep_oper")
	private String code_dep_oper;
	/**
	 * 操作员编码
	 */
	@XmlElement(name = "code_emp_oper")
	private String code_emp_oper;
	/**
	 * 
	 */
	@XmlElement(name = "hpcardinfo")
	private String hpcardinfo;
	
	public String getPatCode() {
		return patCode;
	}
	
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	
	public String getCode_scsrv() {
		return code_scsrv;
	}
	
	public void setCode_scsrv(String code_scsrv) {
		this.code_scsrv = code_scsrv;
	}
	
	public String getCode_hp() {
		return code_hp;
	}
	
	public void setCode_hp(String code_hp) {
		this.code_hp = code_hp;
	}
	
	public String getCode_dep_oper() {
		return code_dep_oper;
	}
	
	public void setCode_dep_oper(String code_dep_oper) {
		this.code_dep_oper = code_dep_oper;
	}
	
	public String getCode_emp_oper() {
		return code_emp_oper;
	}
	
	public void setCode_emp_oper(String code_emp_oper) {
		this.code_emp_oper = code_emp_oper;
	}
	
	public String getHpcardinfo() {
		return hpcardinfo;
	}
	
	public void setHpcardinfo(String hpcardinfo) {
		this.hpcardinfo = hpcardinfo;
	}
}
