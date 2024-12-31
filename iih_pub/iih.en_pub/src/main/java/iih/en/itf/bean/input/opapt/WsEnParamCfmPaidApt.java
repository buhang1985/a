package iih.en.itf.bean.input.opapt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.en.itf.bean.input.WsEnParam;

/**
 * 已收费预约取号 Ws入参 
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnParamCfmPaidApt extends WsEnParam {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 */
	@XmlElement(name = "id_apt")
	private String id_apt;
	/**
	 * 操作员编码
	 */
	@XmlElement(name = "oprCode")
	private String oprCode;
	
	public String getId_apt() {
		return id_apt;
	}
	
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	
	public String getOprCode() {
		return oprCode;
	}
	
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

}
