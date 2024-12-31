package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保出院登记DTO DTO数据 
 * 
 */
public class OutHospitalRegDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院流水号
	 * @return String
	 */
	public String getIpserialno() {
		return ((String) getAttrVal("Ipserialno"));
	}
	/**
	 * 住院流水号
	 * @param Ipserialno
	 */
	public void setIpserialno(String Ipserialno) {
		setAttrVal("Ipserialno", Ipserialno);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getCaseinfo() {
		return ((String) getAttrVal("Caseinfo"));
	}
	/**
	 * 病历信息
	 * @param Caseinfo
	 */
	public void setCaseinfo(String Caseinfo) {
		setAttrVal("Caseinfo", Caseinfo);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBedno() {
		return ((String) getAttrVal("Bedno"));
	}
	/**
	 * 床位号
	 * @param Bedno
	 */
	public void setBedno(String Bedno) {
		setAttrVal("Bedno", Bedno);
	}
	/**
	 * 医生代码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 医生代码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getOperaname() {
		return ((String) getAttrVal("Operaname"));
	}
	/**
	 * 经办人
	 * @param Operaname
	 */
	public void setOperaname(String Operaname) {
		setAttrVal("Operaname", Operaname);
	}
	/**
	 * 出院诊断编码
	 * @return String
	 */
	public String getOuthospdicode() {
		return ((String) getAttrVal("Outhospdicode"));
	}
	/**
	 * 出院诊断编码
	 * @param Outhospdicode
	 */
	public void setOuthospdicode(String Outhospdicode) {
		setAttrVal("Outhospdicode", Outhospdicode);
	}
	/**
	 * 出院诊断名称
	 * @return String
	 */
	public String getOuthospdiname() {
		return ((String) getAttrVal("Outhospdiname"));
	}
	/**
	 * 出院诊断名称
	 * @param Outhospdiname
	 */
	public void setOuthospdiname(String Outhospdiname) {
		setAttrVal("Outhospdiname", Outhospdiname);
	}
	/**
	 * 出院时间
	 * @return String
	 */
	public String getOuthosptime() {
		return ((String) getAttrVal("Outhosptime"));
	}
	/**
	 * 出院时间
	 * @param Outhosptime
	 */
	public void setOuthosptime(String Outhosptime) {
		setAttrVal("Outhosptime", Outhosptime);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
}