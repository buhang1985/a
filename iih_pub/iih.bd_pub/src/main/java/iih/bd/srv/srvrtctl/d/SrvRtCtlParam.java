package iih.bd.srv.srvrtctl.d;

import xap.mw.core.data.*;

/**
 * 服务开立权限判断入口参数 DTO数据 
 * 
 */
public class SrvRtCtlParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 服务串
	 * @return String
	 */
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}
	/**
	 * 服务串
	 * @param Id_srvs
	 */
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	/**
	 * 物品串
	 * @return String
	 */
	public String getId_mms() {
		return ((String) getAttrVal("Id_mms"));
	}
	/**
	 * 物品串
	 * @param Id_mms
	 */
	public void setId_mms(String Id_mms) {
		setAttrVal("Id_mms", Id_mms);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_doctor() {
		return ((String) getAttrVal("Id_emp_doctor"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_doctor
	 */
	public void setId_emp_doctor(String Id_emp_doctor) {
		setAttrVal("Id_emp_doctor", Id_emp_doctor);
	}
}