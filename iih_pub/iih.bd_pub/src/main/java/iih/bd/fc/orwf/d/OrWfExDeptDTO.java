package iih.bd.fc.orwf.d;

import xap.mw.core.data.BaseDTO;

/**
 * 医嘱流向执行科室DTO DTO数据
 * 
 */
public class OrWfExDeptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 * 
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}

	/**
	 * 序号
	 * 
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}

	/**
	 * 组织
	 * 
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}

	/**
	 * 组织
	 * 
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}

	/**
	 * 组织编码
	 * 
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}

	/**
	 * 组织编码
	 * 
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}

	/**
	 * 组织名称
	 * 
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}

	/**
	 * 组织名称
	 * 
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}

	/**
	 * 部门
	 * 
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}

	/**
	 * 部门
	 * 
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}

	/**
	 * 部门编码
	 * 
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}

	/**
	 * 部门编码
	 * 
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}

	/**
	 * 部门名称
	 * 
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}

	/**
	 * 部门名称
	 * 
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}

	/**
	 * 医嘱流向类型
	 * 
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}

	/**
	 * 医嘱流向类型
	 * 
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}

	/**
	 * 执行科室来源
	 * 
	 * @return String
	 */
	public String getMp_source() {
		return ((String) getAttrVal("Mp_source"));
	}

	/**
	 * 执行科室来源
	 * 
	 * @param Mp_source
	 */
	public void setMp_source(String Mp_source) {
		setAttrVal("Mp_source", Mp_source);
	}

	/**
	 * 流向id
	 * 
	 * @return String
	 */
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}

	/**
	 * 流向id
	 * 
	 * @param Mp_source
	 */
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}

	/**
	 * 流向
	 * 
	 * @return String
	 */
	public String getName_wf() {
		return ((String) getAttrVal("Name_wf"));
	}

	/**
	 * 流向
	 * 
	 * @param Name_wf
	 */
	public void setName_wf(String Name_wf) {
		setAttrVal("Name_wf", Name_wf);
	}

}