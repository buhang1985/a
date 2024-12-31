package iih.mp.orm.operworkload.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术工作量手术情况查询 DTO数据 
 * 
 */
public class OperSituationDO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 手术情况主键
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}
	/**
	 * 手术情况主键
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 手术时间
	 * @return String
	 */
	public String getSugplandate() {
		return ((String) getAttrVal("Sugplandate"));
	}
	/**
	 * 手术时间
	 * @param Sugplandate
	 */
	public void setSugplandate(String Sugplandate) {
		setAttrVal("Sugplandate", Sugplandate);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dept_app() {
		return ((String) getAttrVal("Id_dept_app"));
	}
	/**
	 * 科室
	 * @param Id_dept_app
	 */
	public void setId_dept_app(String Id_dept_app) {
		setAttrVal("Id_dept_app", Id_dept_app);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPiname() {
		return ((String) getAttrVal("Piname"));
	}
	/**
	 * 患者姓名
	 * @param Piname
	 */
	public void setPiname(String Piname) {
		setAttrVal("Piname", Piname);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 手术名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}
	/**
	 * 角色
	 * @param Sd_role
	 */
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 人员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 手术间
	 * @return String
	 */
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}
	/**
	 * 手术间
	 * @param Id_opt
	 */
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
}