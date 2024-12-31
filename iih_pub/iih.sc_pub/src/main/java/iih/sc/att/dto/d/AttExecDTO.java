package iih.sc.att.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 考勤执行DTO DTO数据 
 * 
 */
public class AttExecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 考勤执行id
	 * @return String
	 */
	public String getId_taskexec() {
		return ((String) getAttrVal("Id_taskexec"));
	}
	/**
	 * 考勤执行id
	 * @param Id_taskexec
	 */
	public void setId_taskexec(String Id_taskexec) {
		setAttrVal("Id_taskexec", Id_taskexec);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 考勤编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 考勤编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 考勤名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 考勤名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 排班科室id
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 排班科室id
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 排班科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 排班科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 考勤计划id
	 * @return String
	 */
	public String getId_taskpl() {
		return ((String) getAttrVal("Id_taskpl"));
	}
	/**
	 * 考勤计划id
	 * @param Id_taskpl
	 */
	public void setId_taskpl(String Id_taskpl) {
		setAttrVal("Id_taskpl", Id_taskpl);
	}
	/**
	 * 考勤计划
	 * @return String
	 */
	public String getName_taskpl() {
		return ((String) getAttrVal("Name_taskpl"));
	}
	/**
	 * 考勤计划
	 * @param Name_taskpl
	 */
	public void setName_taskpl(String Name_taskpl) {
		setAttrVal("Name_taskpl", Name_taskpl);
	}
	/**
	 * 考勤区间id
	 * @return String
	 */
	public String getId_period() {
		return ((String) getAttrVal("Id_period"));
	}
	/**
	 * 考勤区间id
	 * @param Id_period
	 */
	public void setId_period(String Id_period) {
		setAttrVal("Id_period", Id_period);
	}
	/**
	 * 考勤区间
	 * @return String
	 */
	public String getName_period() {
		return ((String) getAttrVal("Name_period"));
	}
	/**
	 * 考勤区间
	 * @param Name_period
	 */
	public void setName_period(String Name_period) {
		setAttrVal("Name_period", Name_period);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}
	/**
	 * 开始日期
	 * @param D_b
	 */
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}
	/**
	 * 结束日期
	 * @param D_e
	 */
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getId_emp_creator() {
		return ((String) getAttrVal("Id_emp_creator"));
	}
	/**
	 * 提交人
	 * @param Id_emp_creator
	 */
	public void setId_emp_creator(String Id_emp_creator) {
		setAttrVal("Id_emp_creator", Id_emp_creator);
	}
	/**
	 * 提交日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 提交日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}
	/**
	 * 审核人
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}
	/**
	 * 审核日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getEu_task_status() {
		return ((Integer) getAttrVal("Eu_task_status"));
	}
	/**
	 * 状态
	 * @param Eu_task_status
	 */
	public void setEu_task_status(Integer Eu_task_status) {
		setAttrVal("Eu_task_status", Eu_task_status);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 是否覆盖
	 * @return FBoolean
	 */
	public FBoolean getFg_cover() {
		return ((FBoolean) getAttrVal("Fg_cover"));
	}
	/**
	 * 是否覆盖
	 * @param Fg_cover
	 */
	public void setFg_cover(FBoolean Fg_cover) {
		setAttrVal("Fg_cover", Fg_cover);
	}
	/**
	 * 排班部门编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}
	/**
	 * 排班部门编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 考勤计划Code
	 * @return String
	 */
	public String getCode_taskpl() {
		return ((String) getAttrVal("Code_taskpl"));
	}
	/**
	 * 考勤计划Code
	 * @param Code_taskpl
	 */
	public void setCode_taskpl(String Code_taskpl) {
		setAttrVal("Code_taskpl", Code_taskpl);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 人员名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 人员编号
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 人员编号
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 考勤分类枚举
	 * @return Integer
	 */
	public Integer getEu_tasktp() {
		return ((Integer) getAttrVal("Eu_tasktp"));
	}
	/**
	 * 考勤分类枚举
	 * @param Eu_tasktp
	 */
	public void setEu_tasktp(Integer Eu_tasktp) {
		setAttrVal("Eu_tasktp", Eu_tasktp);
	}
}