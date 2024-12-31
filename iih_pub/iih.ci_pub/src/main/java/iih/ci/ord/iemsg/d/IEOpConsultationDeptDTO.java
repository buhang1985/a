package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院会诊子表-受邀部门信息 DTO数据 
 * 
 */
public class IEOpConsultationDeptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_con_dept() {
		return ((String) getAttrVal("Id_con_dept"));
	}
	/**
	 * 主键
	 * @param Id_con_dept
	 */
	public void setId_con_dept(String Id_con_dept) {
		setAttrVal("Id_con_dept", Id_con_dept);
	}
	/**
	 * 所属医院编码
	 * @return String
	 */
	public String getConsultationorgcode() {
		return ((String) getAttrVal("Consultationorgcode"));
	}
	/**
	 * 所属医院编码
	 * @param Consultationorgcode
	 */
	public void setConsultationorgcode(String Consultationorgcode) {
		setAttrVal("Consultationorgcode", Consultationorgcode);
	}
	/**
	 * 所属医院名称
	 * @return String
	 */
	public String getConsultationorgname() {
		return ((String) getAttrVal("Consultationorgname"));
	}
	/**
	 * 所属医院名称
	 * @param Consultationorgname
	 */
	public void setConsultationorgname(String Consultationorgname) {
		setAttrVal("Consultationorgname", Consultationorgname);
	}
	/**
	 * 参加会诊科室编码
	 * @return String
	 */
	public String getConsultationdept() {
		return ((String) getAttrVal("Consultationdept"));
	}
	/**
	 * 参加会诊科室编码
	 * @param Consultationdept
	 */
	public void setConsultationdept(String Consultationdept) {
		setAttrVal("Consultationdept", Consultationdept);
	}
	/**
	 * 参加会诊科室名称
	 * @return String
	 */
	public String getConsultationdeptname() {
		return ((String) getAttrVal("Consultationdeptname"));
	}
	/**
	 * 参加会诊科室名称
	 * @param Consultationdeptname
	 */
	public void setConsultationdeptname(String Consultationdeptname) {
		setAttrVal("Consultationdeptname", Consultationdeptname);
	}
	/**
	 * 参与医生编码
	 * @return String
	 */
	public String getConsultationperson() {
		return ((String) getAttrVal("Consultationperson"));
	}
	/**
	 * 参与医生编码
	 * @param Consultationperson
	 */
	public void setConsultationperson(String Consultationperson) {
		setAttrVal("Consultationperson", Consultationperson);
	}
	/**
	 * 参与医生名称
	 * @return String
	 */
	public String getConsultationpersonname() {
		return ((String) getAttrVal("Consultationpersonname"));
	}
	/**
	 * 参与医生名称
	 * @param Consultationpersonname
	 */
	public void setConsultationpersonname(String Consultationpersonname) {
		setAttrVal("Consultationpersonname", Consultationpersonname);
	}
	/**
	 * 主表主键
	 * @return String
	 */
	public String getId_conculation() {
		return ((String) getAttrVal("Id_conculation"));
	}
	/**
	 * 主表主键
	 * @param Id_conculation
	 */
	public void setId_conculation(String Id_conculation) {
		setAttrVal("Id_conculation", Id_conculation);
	}
}