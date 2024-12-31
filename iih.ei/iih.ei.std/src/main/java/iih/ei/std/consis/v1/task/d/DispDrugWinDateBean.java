package iih.ei.std.consis.v1.task.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 发药窗口基本数据JavaBean
 * 
 * @author dj.zhang
 * @data 2018年8月12日下午9:45:37
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DispDrugWinDateBean extends BaseWsParam {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OPWINID_CODE")
	private String opwinid_code;
	@XmlElement(name = "DISPENSARY")
	private String dispensary;
	@XmlElement(name = "OPWINID_NAME")
	private String opwinid_name;

	/**
	 * 窗口编号
	 * 
	 * @return
	 */
	public String getOpwinid_code() {
		return opwinid_code;
	}

	/**
	 * 窗口编号
	 * 
	 * @param opwinid_code
	 */
	public void setOpwinid_code(String opwinid_code) {
		this.opwinid_code = opwinid_code;
	}

	/**
	 * 发药药局
	 * 
	 * @return
	 */
	public String getDispensary() {
		return dispensary;
	}

	/**
	 * 发药药局
	 * 
	 * @param dispensary
	 */
	public void setDispensary(String dispensary) {
		this.dispensary = dispensary;
	}

	/**
	 * 窗口标示
	 * 
	 * @return
	 */
	public String getOpwinid_name() {
		return opwinid_name;
	}

	/**
	 * 窗口标示
	 * 
	 * @param opwinid_name
	 */
	public void setOpwinid_name(String opwinid_name) {
		this.opwinid_name = opwinid_name;
	}

}
