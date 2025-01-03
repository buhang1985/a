package iih.ei.sc.s.param;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetScQryListParam extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 医技项目分类
	 */
	private String idScca;
	/**
	 * 排班日期
	 */
	private String scDate;
	/**
	 * 诊疗项目id
	 */
	private String idSrv;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 操作员
	 */
	private String oprCode;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 开始时间
	 */
	private String beginDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	/**
	 * 预约记录id
	 */
	private String idApt;
	/**
	 * 爽约类型编码
	 */
	private String eus_bbrtp;
	/**
	 * 排班开始日期
	 */
	private String dateB;
	/**
	 * 排班结束日期
	 */
	private String dateE;
	/**
	 * 申请单号
	 */
	private String applyNo;
	/**
	 * 医嘱编码
	 */
	private String codeOr;

	public String getCodeOr() {
		return codeOr;
	}
	public void setCodeOr(String codeOr) {
		this.codeOr = codeOr;
	}
	public String getIdScca() {
		return idScca;
	}
	public void setIdScca(String idScca) {
		this.idScca = idScca;
	}
	public String getScDate() {
		return scDate;
	}
	public void setScDate(String scDate) {
		this.scDate = scDate;
	}
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
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getIdApt() {
		return idApt;
	}
	public void setIdApt(String idApt) {
		this.idApt = idApt;
	}
	public String getEus_bbrtp() {
		return eus_bbrtp;
	}
	public void setEus_bbrtp(String eus_bbrtp) {
		this.eus_bbrtp = eus_bbrtp;
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
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
}
