package iih.mp.dg.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 处方信息返回值JavaBean
 * 
 * @author dj.zhang
 * @data 2018年8月10日下午10:00:09
 * 
 */
@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescInforResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "RETVAL")
	private String retval;
	@XmlElement(name = "RETMSG")
	private String retmsg;
	@XmlElement(name = "RETCODE")
	private String retcode;

	/**
	 * 返回窗口号
	 * 
	 * @return
	 */
	public String getRetval() {
		return retval;
	}

	/**
	 * 返回窗口号
	 * 
	 * @param retval
	 */
	public void setRetval(String retval) {
		this.retval = retval;
	}

	/**
	 * 返回错误信息
	 * 
	 * @return
	 */
	public String getRetmsg() {
		return retmsg;
	}

	/**
	 * 返回错误信息
	 * 
	 * @param retmsg
	 */
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	/**
	 * 返回状态码
	 * 
	 * @return
	 */
	public String getRetcode() {
		return retcode;
	}

	/**
	 * 返回状态码
	 * 
	 * @param retcode
	 */
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

}
