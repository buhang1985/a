package iih.mp.nr.msg.chargebill.d;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import xap.mw.core.data.BaseDTO;

/**
 * BS024记账或冲账入参 DTO数据
 * 
 */
public class Chargebill extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 患者编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "Code_pat")
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
	 * 就诊类型
	 * 
	 * @return String
	 */
	@XmlElement(name = "Code_entp")
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}

	/**
	 * 就诊类型
	 * 
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}

	/**
	 * 医嘱编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "Code_or")
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}

	/**
	 * 医嘱编码
	 * 
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}

	/**
	 * 执行科室编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "Code_dep")
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}

	/**
	 * 执行科室编码
	 * 
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}

	/**
	 * 执行人编码
	 * 
	 * @return String
	 */
	@XmlElement(name = "Code_emp")
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}

	/**
	 * 执行人编码
	 * 
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}

	/**
	 * 执行时间
	 * 
	 * @return String
	 */
	@XmlElement(name = "Dt_exe")
	public String getDt_exe() {
		return ((String) getAttrVal("Dt_exe"));
	}

	/**
	 * 执行时间
	 * 
	 * @param Dt_exe
	 */
	public void setDt_exe(String Dt_exe) {
		setAttrVal("Dt_exe", Dt_exe);
	}

	/**
	 * 计费或退费
	 * 
	 * @return String
	 */
	@XmlElement(name = "Charge_tp")
	public String getCharge_tp() {
		return ((String) getAttrVal("Charge_tp"));
	}

	/**
	 * 计费或退费
	 * 
	 * @param Charge_tp
	 */
	public void setCharge_tp(String Charge_tp) {
		setAttrVal("Charge_tp", Charge_tp);
	}

	/**
	 * 补费项目
	 * 
	 * @return FArrayList
	 */
	@SuppressWarnings("unchecked")
	@XmlElementWrapper(name = "Billsupplys")
	@XmlElement(name = "Billsupply")
	public List<Billsupply> getBillsupplys() {
		return ((List<Billsupply>) getAttrVal("Billsupplys"));
	}

	/**
	 * 补费项目
	 * 
	 * @param Billsupplys
	 */
	public void setBillsupplys(List<Billsupply> Billsupplys) {
		setAttrVal("Billsupplys", Billsupplys);
	}
}