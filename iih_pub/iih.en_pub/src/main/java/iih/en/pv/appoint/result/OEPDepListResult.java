package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 门急诊出诊科室列表-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class OEPDepListResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 科室编码
	 */
	private String code_dep;
	/**
	 * 科室名称
	 */
	private String name_dep;
	
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
