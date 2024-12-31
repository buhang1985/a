package iih.pis.ivx.mt.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import iih.bd.webservice.BaseWsParam;

/**
 * 获取医技排班列表para
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class SchPara extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始日期
	 */
	private String dateB = "";
	
	/**
	 * 结束日期
	 */
	private String dateE = "";
	
	/**
	 * 诊疗项目id
	 */
	private String idSrv = "";
	
	/**
	 * 渠道类型
	 */
	private String chlType = "";
	
	/**
	 * 操作员
	 */
	private String oprCode = "";

	public String getIdSrv() {
		return idSrv;
	}

	public String getDateB() {
		return dateB;
	}

	public void setDateB(String dateB) {
		this.dateB = dateB;
	}

	public String getDateE() {
		return dateE;
	}

	public void setDateE(String dateE) {
		this.dateE = dateE;
	}

	public void setIdSrv(String idSrv) {
		this.idSrv = idSrv;
	}

	public String getChlType() {
		return chlType;
	}

	public void setChlType(String chlType) {
		this.chlType = chlType;
	}

	public String getOprCode() {
		return oprCode;
	}

	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

}