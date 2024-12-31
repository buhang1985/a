package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约确认DTO DTO数据 
 * 
 */
public class MtaptcfmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约申请ID
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}
	/**
	 * 预约申请ID
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * displaynam5
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别显示名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别显示名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 申请单名称
	 * @return String
	 */
	public String getApt_name() {
		return ((String) getAttrVal("Apt_name"));
	}
	/**
	 * 申请单名称
	 * @param Apt_name
	 */
	public void setApt_name(String Apt_name) {
		setAttrVal("Apt_name", Apt_name);
	}
	/**
	 * 预约操作人
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}
	/**
	 * 预约操作人
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
	}
	/**
	 * 预约操作人name
	 * @return String
	 */
	public String getName_emp_appl() {
		return ((String) getAttrVal("Name_emp_appl"));
	}
	/**
	 * 预约操作人name
	 * @param Name_emp_appl
	 */
	public void setName_emp_appl(String Name_emp_appl) {
		setAttrVal("Name_emp_appl", Name_emp_appl);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_appl() {
		return ((String) getAttrVal("Id_dep_appl"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_appl
	 */
	public void setId_dep_appl(String Id_dep_appl) {
		setAttrVal("Id_dep_appl", Id_dep_appl);
	}
	/**
	 * 申请科室name
	 * @return String
	 */
	public String getName_dep_appl() {
		return ((String) getAttrVal("Name_dep_appl"));
	}
	/**
	 * 申请科室name
	 * @param Name_dep_appl
	 */
	public void setName_dep_appl(String Name_dep_appl) {
		setAttrVal("Name_dep_appl", Name_dep_appl);
	}
	/**
	 * 预约排班id
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 预约排班id
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 预约排班名称
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 预约排班名称
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 预约时间
	 * @return FDate
	 */
	public FDate getDt_b() {
		return ((FDate) getAttrVal("Dt_b"));
	}
	/**
	 * 预约时间
	 * @param Dt_b
	 */
	public void setDt_b(FDate Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 顺序号
	 * @return String
	 */
	public String getApt_queno() {
		return ((String) getAttrVal("Apt_queno"));
	}
	/**
	 * 顺序号
	 * @param Apt_queno
	 */
	public void setApt_queno(String Apt_queno) {
		setAttrVal("Apt_queno", Apt_queno);
	}
	/**
	 * 预约完成标志
	 * @return String
	 */
	public String getFg_aptcfm() {
		return ((String) getAttrVal("Fg_aptcfm"));
	}
	/**
	 * 预约完成标志
	 * @param Fg_aptcfm
	 */
	public void setFg_aptcfm(String Fg_aptcfm) {
		setAttrVal("Fg_aptcfm", Fg_aptcfm);
	}
	/**
	 * 预约操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appl_apt() {
		return ((FDateTime) getAttrVal("Dt_appl_apt"));
	}
	/**
	 * 预约操作时间
	 * @param Dt_appl_apt
	 */
	public void setDt_appl_apt(FDateTime Dt_appl_apt) {
		setAttrVal("Dt_appl_apt", Dt_appl_apt);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}
	/**
	 * 确认人
	 * @param Id_emp_cfm
	 */
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appl_mt() {
		return ((FDateTime) getAttrVal("Dt_appl_mt"));
	}
	/**
	 * 确认时间
	 * @param Dt_appl_mt
	 */
	public void setDt_appl_mt(FDateTime Dt_appl_mt) {
		setAttrVal("Dt_appl_mt", Dt_appl_mt);
	}
	/**
	 * 确认人名称
	 * @return String
	 */
	public String getName_emp_cfm() {
		return ((String) getAttrVal("Name_emp_cfm"));
	}
	/**
	 * 确认人名称
	 * @param Name_emp_cfm
	 */
	public void setName_emp_cfm(String Name_emp_cfm) {
		setAttrVal("Name_emp_cfm", Name_emp_cfm);
	}
	/**
	 * 计划排班_预约_医技辅 id
	 * @return String
	 */
	public String getId_aptmt() {
		return ((String) getAttrVal("Id_aptmt"));
	}
	/**
	 * 计划排班_预约_医技辅 id
	 * @param Id_aptmt
	 */
	public void setId_aptmt(String Id_aptmt) {
		setAttrVal("Id_aptmt", Id_aptmt);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getRes_name() {
		return ((String) getAttrVal("Res_name"));
	}
	/**
	 * 申请医生
	 * @param Res_name
	 */
	public void setRes_name(String Res_name) {
		setAttrVal("Res_name", Res_name);
	}
	/**
	 * 申请医生id
	 * @return String
	 */
	public String getId_res() {
		return ((String) getAttrVal("Id_res"));
	}
	/**
	 * 申请医生id
	 * @param Id_res
	 */
	public void setId_res(String Id_res) {
		setAttrVal("Id_res", Id_res);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dep_sc() {
		return ((String) getAttrVal("Name_dep_sc"));
	}
	/**
	 * 执行科室
	 * @param Name_dep_sc
	 */
	public void setName_dep_sc(String Name_dep_sc) {
		setAttrVal("Name_dep_sc", Name_dep_sc);
	}
	/**
	 * 申请编码
	 * @return String
	 */
	public String getCode_appl() {
		return ((String) getAttrVal("Code_appl"));
	}
	/**
	 * 申请编码
	 * @param Code_appl
	 */
	public void setCode_appl(String Code_appl) {
		setAttrVal("Code_appl", Code_appl);
	}
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_scapt() {
		return ((String) getAttrVal("Id_scapt"));
	}
	/**
	 * 预约id
	 * @param Id_scapt
	 */
	public void setId_scapt(String Id_scapt) {
		setAttrVal("Id_scapt", Id_scapt);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getNum() {
		return ((String) getAttrVal("Num"));
	}
	/**
	 * 序号
	 * @param Num
	 */
	public void setNum(String Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 诊疗项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 诊疗项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 排版服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排版服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
}