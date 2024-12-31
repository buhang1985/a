package iih.mp.nr.api.crisisval.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import xap.mw.core.data.BaseDTO;

/**
 * @Description:检验报告项目
 * @Author:dukx
 * @Version:2019年7月12日下午3:25:29
 *
 */
public class LisMsgInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * Lis上报ID
	 * 
	 * @return String
	 */
	@XmlElement(name = "ID_ALERT")
	public String getId_alert() {
		return ((String) getAttrVal("Id_alert"));
	}

	/**
	 * Lis上报ID
	 * 
	 * @param Id_alert
	 */
	public void setId_alert(String Id_alert) {
		setAttrVal("Id_alert", Id_alert);
	}

	/**
	 * Lis上报时间
	 * 
	 * @return String
	 */
	@XmlElement(name = "DT_ALERT")
	public String getDt_alert() {
		return ((String) getAttrVal("Dt_alert"));
	}

	/**
	 * Lis上报时间
	 * 
	 * @param Dt_alert
	 */
	public void setDt_alert(String Dt_alert) {
		setAttrVal("Dt_alert", Dt_alert);
	}

	/**
	 * 上报人编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "CODE_EMP_ALERT")
	public String getCode_emp_alert() {
		return ((String) getAttrVal("Code_emp_alert"));
	}

	/**
	 * 上报人编码
	 * 
	 * @param Code_emp_alert
	 */
	public void setCode_emp_alert(String Code_emp_alert) {
		setAttrVal("Code_emp_alert", Code_emp_alert);
	}

	/**
	 * 申请单号
	 * 
	 * @return String
	 */
	@XmlElement(name = "NO_APPLYFORM")
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}

	/**
	 * 申请单号
	 * 
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}

	/**
	 * 住院号
	 * 
	 * @return String
	 */
	@XmlElement(name = "CODE_AMR_IP")
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}

	/**
	 * 住院号
	 * 
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}

	/**
	 * 患者编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "CODE_PAT")
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}

	/**
	 * 患者编码
	 * 
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}

	/**
	 * 标本类型
	 * 
	 * @return String
	 */
	@XmlElement(name = "NAME_LABSAMPTP")
	public String getName_labsamptp() {
		return ((String) getAttrVal("Name_labsamptp"));
	}

	/**
	 * 标本类型
	 * 
	 * @param Name_labsamptp
	 */
	public void setName_labsamptp(String Name_labsamptp) {
		setAttrVal("Name_labsamptp", Name_labsamptp);
	}

	/**
	 * 标本接收时间
	 * 
	 * @return String
	 */
	@XmlElement(name = "DT_RECIEVE")
	public String getDt_recieve() {
		return ((String) getAttrVal("Dt_recieve"));
	}

	/**
	 * 标本接收时间
	 * 
	 * @param Dt_recieve
	 */
	public void setDt_recieve(String Dt_recieve) {
		setAttrVal("Dt_recieve", Dt_recieve);
	}

	/**
	 * 严重级别编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "CODE_SIRSLEVEL")
	public String getCode_sirslevel() {
		return ((String) getAttrVal("Code_sirslevel"));
	}

	/**
	 * 严重级别编码
	 * 
	 * @param Code_sirslevel
	 */
	public void setCode_sirslevel(String Code_sirslevel) {
		setAttrVal("Code_sirslevel", Code_sirslevel);
	}

	/**
	 * 严重级别名称
	 * 
	 * @return String
	 */
	@XmlElement(name = "NAME_SIRSLEVEL")
	public String getName_sirslevel() {
		return ((String) getAttrVal("Name_sirslevel"));
	}

	/**
	 * 严重级别名称
	 * 
	 * @param Name_sirslevel
	 */
	public void setName_sirslevel(String Name_sirslevel) {
		setAttrVal("Name_sirslevel", Name_sirslevel);
	}

	/**
	 * 检验项目明细
	 * 
	 * @return FArrayList
	 */
	@XmlElementWrapper(name = "DETAILS")
	@XmlElement(name = "LisDetail")
	public List<LisDetail> getDetails() {
		return ((List<LisDetail>) getAttrVal("Details"));
	}

	/**
	 * 检验项目明细
	 * 
	 * @param Details
	 */
	public void setDetails(List<LisDetail> Details) {
		setAttrVal("Details", Details);
	}

}
