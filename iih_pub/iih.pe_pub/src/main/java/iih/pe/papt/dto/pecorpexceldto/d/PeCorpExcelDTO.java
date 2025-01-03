package iih.pe.papt.dto.pecorpexceldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检团体名单导入 DTO数据 
 * 
 */
public class PeCorpExcelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 存在标识
	 * @return FBoolean
	 */
	public FBoolean getFg_exist() {
		return ((FBoolean) getAttrVal("Fg_exist"));
	}
	/**
	 * 存在标识
	 * @param Fg_exist
	 */
	public void setFg_exist(FBoolean Fg_exist) {
		setAttrVal("Fg_exist", Fg_exist);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSex() {
		return ((Integer) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(Integer Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getIdtp() {
		return ((String) getAttrVal("Idtp"));
	}
	/**
	 * 证件类型
	 * @param Idtp
	 */
	public void setIdtp(String Idtp) {
		setAttrVal("Idtp", Idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdate() {
		return ((FDate) getAttrVal("Birthdate"));
	}
	/**
	 * 出生日期
	 * @param Birthdate
	 */
	public void setBirthdate(FDate Birthdate) {
		setAttrVal("Birthdate", Birthdate);
	}
	/**
	 * 婚姻状况
	 * @return Integer
	 */
	public Integer getMarriage() {
		return ((Integer) getAttrVal("Marriage"));
	}
	/**
	 * 婚姻状况
	 * @param Marriage
	 */
	public void setMarriage(Integer Marriage) {
		setAttrVal("Marriage", Marriage);
	}
	/**
	 * 体检日期
	 * @return FDate
	 */
	public FDate getPedate() {
		return ((FDate) getAttrVal("Pedate"));
	}
	/**
	 * 体检日期
	 * @param Pedate
	 */
	public void setPedate(FDate Pedate) {
		setAttrVal("Pedate", Pedate);
	}
	/**
	 * 家属
	 * @return FBoolean
	 */
	public FBoolean getFg_family() {
		return ((FBoolean) getAttrVal("Fg_family"));
	}
	/**
	 * 家属
	 * @param Fg_family
	 */
	public void setFg_family(FBoolean Fg_family) {
		setAttrVal("Fg_family", Fg_family);
	}
	/**
	 * 员工号
	 * @return String
	 */
	public String getNo_employee() {
		return ((String) getAttrVal("No_employee"));
	}
	/**
	 * 员工号
	 * @param No_employee
	 */
	public void setNo_employee(String No_employee) {
		setAttrVal("No_employee", No_employee);
	}
	/**
	 * 手机号
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 手机号
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 部门
	 * @return String
	 */
	public String getDep() {
		return ((String) getAttrVal("Dep"));
	}
	/**
	 * 部门
	 * @param Dep
	 */
	public void setDep(String Dep) {
		setAttrVal("Dep", Dep);
	}
	/**
	 * 体检备注
	 * @return String
	 */
	public String getRmk_pe() {
		return ((String) getAttrVal("Rmk_pe"));
	}
	/**
	 * 体检备注
	 * @param Rmk_pe
	 */
	public void setRmk_pe(String Rmk_pe) {
		setAttrVal("Rmk_pe", Rmk_pe);
	}
	/**
	 * 体检团体ID
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}
	/**
	 * 体检团体ID
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * 团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}
	/**
	 * 团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 团体预约分组ID
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}
	/**
	 * 团体预约分组ID
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 工种
	 * @return String
	 */
	public String getProfession() {
		return ((String) getAttrVal("Profession"));
	}
	/**
	 * 工种
	 * @param Profession
	 */
	public void setProfession(String Profession) {
		setAttrVal("Profession", Profession);
	}
	/**
	 * 行业
	 * @return String
	 */
	public String getIndustry() {
		return ((String) getAttrVal("Industry"));
	}
	/**
	 * 行业
	 * @param Industry
	 */
	public void setIndustry(String Industry) {
		setAttrVal("Industry", Industry);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getCompany() {
		return ((String) getAttrVal("Company"));
	}
	/**
	 * 单位名称
	 * @param Company
	 */
	public void setCompany(String Company) {
		setAttrVal("Company", Company);
	}
	/**
	 * 岗位状态
	 * @return Integer
	 */
	public Integer getSt_job() {
		return ((Integer) getAttrVal("St_job"));
	}
	/**
	 * 岗位状态
	 * @param St_job
	 */
	public void setSt_job(Integer St_job) {
		setAttrVal("St_job", St_job);
	}
	/**
	 * 在岗时间
	 * @return String
	 */
	public String getJob_time() {
		return ((String) getAttrVal("Job_time"));
	}
	/**
	 * 在岗时间
	 * @param Job_time
	 */
	public void setJob_time(String Job_time) {
		setAttrVal("Job_time", Job_time);
	}
	/**
	 * 工龄
	 * @return String
	 */
	public String getWorkingage() {
		return ((String) getAttrVal("Workingage"));
	}
	/**
	 * 工龄
	 * @param Workingage
	 */
	public void setWorkingage(String Workingage) {
		setAttrVal("Workingage", Workingage);
	}
}