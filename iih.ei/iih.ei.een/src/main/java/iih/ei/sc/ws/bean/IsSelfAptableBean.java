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
public class IsSelfAptableBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单id
	 */
	private String id_aptapply;
	/**
	 * 是否可自助预约结果
	 */
	private String isAptable;
	
	public String getId_aptapply() {
		return id_aptapply;
	}
	public void setId_aptapply(String id_aptapply) {
		this.id_aptapply = id_aptapply;
	}
	public String getIsAptable() {
		return isAptable;
	}
	public void setIsAptable(String isAptable) {
		this.isAptable = isAptable;
	}
	
}
