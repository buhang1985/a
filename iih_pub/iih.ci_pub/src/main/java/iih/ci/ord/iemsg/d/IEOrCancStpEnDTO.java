package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE医嘱撤销和停止就诊信息DTO DTO数据 
 * 
 */
public class IEOrCancStpEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE医嘱撤销和停止就诊主键标识
	 * @return String
	 */
	public String getId_ieorcancstpen() {
		return ((String) getAttrVal("Id_ieorcancstpen"));
	}	
	/**
	 * IE医嘱撤销和停止就诊主键标识
	 * @param Id_ieorcancstpen
	 */
	public void setId_ieorcancstpen(String Id_ieorcancstpen) {
		setAttrVal("Id_ieorcancstpen", Id_ieorcancstpen);
	}
	/**
	 * IE医嘱撤销和停止集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_ieorcancstps() {
		return ((FArrayList2) getAttrVal("Id_ieorcancstps"));
	}	
	/**
	 * IE医嘱撤销和停止集合
	 * @param Id_ieorcancstps
	 */
	public void setId_ieorcancstps(FArrayList2 Id_ieorcancstps) {
		setAttrVal("Id_ieorcancstps", Id_ieorcancstps);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者ID
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getAdmiss_times() {
		return ((String) getAttrVal("Admiss_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(String Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_dept_code() {
		return ((String) getAttrVal("Exec_dept_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_dept_code
	 */
	public void setExec_dept_code(String Exec_dept_code) {
		setAttrVal("Exec_dept_code", Exec_dept_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_dept_name() {
		return ((String) getAttrVal("Exec_dept_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_dept_name
	 */
	public void setExec_dept_name(String Exec_dept_name) {
		setAttrVal("Exec_dept_name", Exec_dept_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 病人科室编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 病人科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 医疗结构编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 医疗结构编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getVisit_sort_no() {
		return ((String) getAttrVal("Visit_sort_no"));
	}	
	/**
	 * 就诊流水号
	 * @param Visit_sort_no
	 */
	public void setVisit_sort_no(String Visit_sort_no) {
		setAttrVal("Visit_sort_no", Visit_sort_no);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getVisit_type_code() {
		return ((String) getAttrVal("Visit_type_code"));
	}	
	/**
	 * 就诊类型编码
	 * @param Visit_type_code
	 */
	public void setVisit_type_code(String Visit_type_code) {
		setAttrVal("Visit_type_code", Visit_type_code);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getVisit_type_name() {
		return ((String) getAttrVal("Visit_type_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Visit_type_name
	 */
	public void setVisit_type_name(String Visit_type_name) {
		setAttrVal("Visit_type_name", Visit_type_name);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getApply_code() {
		return ((String) getAttrVal("Apply_code"));
	}	
	/**
	 * 申请科室编码
	 * @param Apply_code
	 */
	public void setApply_code(String Apply_code) {
		setAttrVal("Apply_code", Apply_code);
	}
	/**
	 * 医嘱执行分类编码
	 * @return String
	 */
	public String getSd_iemsgca() {
		return ((String) getAttrVal("Sd_iemsgca"));
	}	
	/**
	 * 医嘱执行分类编码
	 * @param Sd_iemsgca
	 */
	public void setSd_iemsgca(String Sd_iemsgca) {
		setAttrVal("Sd_iemsgca", Sd_iemsgca);
	}
}