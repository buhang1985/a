package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技辅预约科室/项目过滤 DTO数据 
 * 
 */
public class ScaptMtfilterDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 过滤id
	 * @return String
	 */
	public String getId_filter() {
		return ((String) getAttrVal("Id_filter"));
	}
	/**
	 * 过滤id
	 * @param Id_filter
	 */
	public void setId_filter(String Id_filter) {
		setAttrVal("Id_filter", Id_filter);
	}
	/**
	 * 部门id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 部门id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 项目数量
	 * @return Integer
	 */
	public Integer getProject_count() {
		return ((Integer) getAttrVal("Project_count"));
	}
	/**
	 * 项目数量
	 * @param Project_count
	 */
	public void setProject_count(Integer Project_count) {
		setAttrVal("Project_count", Project_count);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getProject() {
		return ((String) getAttrVal("Project"));
	}
	/**
	 * 项目名称
	 * @param Project
	 */
	public void setProject(String Project) {
		setAttrVal("Project", Project);
	}
	/**
	 * 科室数量
	 * @return Integer
	 */
	public Integer getDep_count() {
		return ((Integer) getAttrVal("Dep_count"));
	}
	/**
	 * 科室数量
	 * @param Dep_count
	 */
	public void setDep_count(Integer Dep_count) {
		setAttrVal("Dep_count", Dep_count);
	}
}