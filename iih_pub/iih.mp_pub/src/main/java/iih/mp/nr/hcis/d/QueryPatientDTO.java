package iih.mp.nr.hcis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者基本信息查询入参 DTO数据 
 * 
 */
public class  QueryPatientDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者唯一标识id
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * 患者唯一标识id
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatientname() {
		return ((String) getAttrVal("Patientname"));
	}
	/**
	 * 患者姓名
	 * @param Patientname
	 */
	public void setPatientname(String Patientname) {
		setAttrVal("Patientname", Patientname);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getPatientsex() {
		return ((String) getAttrVal("Patientsex"));
	}
	/**
	 * 患者性别
	 * @param Patientsex
	 */
	public void setPatientsex(String Patientsex) {
		setAttrVal("Patientsex", Patientsex);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}
	/**
	 * 科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
}