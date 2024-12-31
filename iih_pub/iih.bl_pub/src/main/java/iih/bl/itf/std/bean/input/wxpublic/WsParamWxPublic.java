package iih.bl.itf.std.bean.input.wxpublic;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.wxpublic.sub.WsParamWxPublicPatient;
/**
 * *
 * 微信公众号费用通知dto
 * @author zhangxin
 * @date 2019年11月5日
 */
@XmlRootElement(name = "msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamWxPublic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 微信公众号费用通知患者信息
	 */
	@XmlElement(name = "patient")
    private WsParamWxPublicPatient  patient;
	/**
	 * 微信公众号费用通知参数信息
	 */
	@XmlElementWrapper(name = "info")
	@XmlElement(name = "param")
	private List<String> info;
	
	public WsParamWxPublicPatient getPatient() {
		return patient;
	}
	public void setPatient(WsParamWxPublicPatient patient) {
		this.patient = patient;
	}
	public List<String> getInfo() {
		return info;
	}
	public void setInfo(List<String> info) {
		this.info = info;
	}
	
	
}
