package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 取医技排班列表
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class IsSelfCancableBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单id
	 */
	private String id_apt;
	/**
	 * 是否可取消预约
	 */
	private String isCancable;
	

	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getIsCancable() {
		return isCancable;
	}
	public void setIsCancable(String isCancable) {
		this.isCancable = isCancable;
	}
	
}
