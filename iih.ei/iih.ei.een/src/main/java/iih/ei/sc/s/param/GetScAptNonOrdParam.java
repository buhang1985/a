package iih.ei.sc.s.param;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetScAptNonOrdParam extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 诊疗项目id
	 */
	private String idSrv;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 排班ID
	 */
	private String idSch;
	/**
	 * 申请机构名称
	 */
	private String orgNameAppl;
	/**
	 * 申请机构名称
	 */
	private String depNameAppl;
	/**
	 * 申请医生名称
	 */
	private String phyNameAppl;
	/**
	 * 已经收费标志
	 */
	private String fg_bl;
	/**
	 * 操作员
	 */
	private String oprCode;
	
	public String getIdSrv() {
		return idSrv;
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
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	
	public String getIdSch() {
		return idSch;
	}
	public void setIdSch(String idSch) {
		this.idSch = idSch;
	}
	public String getOrgNameAppl() {
		return orgNameAppl;
	}
	public void setOrgNameAppl(String orgNameAppl) {
		this.orgNameAppl = orgNameAppl;
	}
	public String getDepNameAppl() {
		return depNameAppl;
	}
	public void setDepNameAppl(String depNameAppl) {
		this.depNameAppl = depNameAppl;
	}
	public String getPhyNameAppl() {
		return phyNameAppl;
	}
	public void setPhyNameAppl(String phyNameAppl) {
		this.phyNameAppl = phyNameAppl;
	}
	public String getFg_bl() {
		return fg_bl;
	}
	public void setFg_bl(String fg_bl) {
		this.fg_bl = fg_bl;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

}
