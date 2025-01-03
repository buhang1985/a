package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约集成平台DTO DTO数据 
 * 
 */
public class MtApt4IpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约号
	 * @return String
	 */
	public String getAptcode() {
		return ((String) getAttrVal("Aptcode"));
	}
	/**
	 * 预约号
	 * @param Aptcode
	 */
	public void setAptcode(String Aptcode) {
		setAttrVal("Aptcode", Aptcode);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apt() {
		return ((FDateTime) getAttrVal("Dt_apt"));
	}
	/**
	 * 预约时间
	 * @param Dt_apt
	 */
	public void setDt_apt(FDateTime Dt_apt) {
		setAttrVal("Dt_apt", Dt_apt);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dept_mp() {
		return ((String) getAttrVal("Code_dept_mp"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dept_mp
	 */
	public void setCode_dept_mp(String Code_dept_mp) {
		setAttrVal("Code_dept_mp", Code_dept_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dept_mp() {
		return ((String) getAttrVal("Name_dept_mp"));
	}
	/**
	 * 执行科室
	 * @param Name_dept_mp
	 */
	public void setName_dept_mp(String Name_dept_mp) {
		setAttrVal("Name_dept_mp", Name_dept_mp);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 申请单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 预约员编码
	 * @return String
	 */
	public String getCode_emp_apt() {
		return ((String) getAttrVal("Code_emp_apt"));
	}
	/**
	 * 预约员编码
	 * @param Code_emp_apt
	 */
	public void setCode_emp_apt(String Code_emp_apt) {
		setAttrVal("Code_emp_apt", Code_emp_apt);
	}
	/**
	 * 预约员姓名
	 * @return String
	 */
	public String getName_emp_apt() {
		return ((String) getAttrVal("Name_emp_apt"));
	}
	/**
	 * 预约员姓名
	 * @param Name_emp_apt
	 */
	public void setName_emp_apt(String Name_emp_apt) {
		setAttrVal("Name_emp_apt", Name_emp_apt);
	}
	/**
	 * 预约设备编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}
	/**
	 * 预约设备编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 预约设备
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}
	/**
	 * 预约设备
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 预约排序号
	 * @return String
	 */
	public String getNum_apt() {
		return ((String) getAttrVal("Num_apt"));
	}
	/**
	 * 预约排序号
	 * @param Num_apt
	 */
	public void setNum_apt(String Num_apt) {
		setAttrVal("Num_apt", Num_apt);
	}
	/**
	 * 患者科室编码
	 * @return String
	 */
	public String getCode_dept_pat() {
		return ((String) getAttrVal("Code_dept_pat"));
	}
	/**
	 * 患者科室编码
	 * @param Code_dept_pat
	 */
	public void setCode_dept_pat(String Code_dept_pat) {
		setAttrVal("Code_dept_pat", Code_dept_pat);
	}
	/**
	 * 患者科室名称
	 * @return String
	 */
	public String getName_dept_pat() {
		return ((String) getAttrVal("Name_dept_pat"));
	}
	/**
	 * 患者科室名称
	 * @param Name_dept_pat
	 */
	public void setName_dept_pat(String Name_dept_pat) {
		setAttrVal("Name_dept_pat", Name_dept_pat);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 医疗机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 医疗机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 患者code
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者code
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 域
	 * @return String
	 */
	public String getArea() {
		return ((String) getAttrVal("Area"));
	}
	/**
	 * 域
	 * @param Area
	 */
	public void setArea(String Area) {
		setAttrVal("Area", Area);
	}
	/**
	 * 日期分组id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 日期分组名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 日期分组名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 发送状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}
	/**
	 * 发送状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
	/**
	 * 医嘱IE项目分类
	 * @return String
	 */
	public String getSd_iemsgca() {
		return ((String) getAttrVal("Sd_iemsgca"));
	}
	/**
	 * 医嘱IE项目分类
	 * @param Sd_iemsgca
	 */
	public void setSd_iemsgca(String Sd_iemsgca) {
		setAttrVal("Sd_iemsgca", Sd_iemsgca);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getNum_healthcard() {
		return ((String) getAttrVal("Num_healthcard"));
	}
	/**
	 * 健康卡号
	 * @param Num_healthcard
	 */
	public void setNum_healthcard(String Num_healthcard) {
		setAttrVal("Num_healthcard", Num_healthcard);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊流水号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 预约开始时间
	 * @return String
	 */
	public String getDt_apt_begin() {
		return ((String) getAttrVal("Dt_apt_begin"));
	}
	/**
	 * 预约开始时间
	 * @param Dt_apt_begin
	 */
	public void setDt_apt_begin(String Dt_apt_begin) {
		setAttrVal("Dt_apt_begin", Dt_apt_begin);
	}
	/**
	 * 预约结束时间
	 * @return String
	 */
	public String getDt_apt_end() {
		return ((String) getAttrVal("Dt_apt_end"));
	}
	/**
	 * 预约结束时间
	 * @param Dt_apt_end
	 */
	public void setDt_apt_end(String Dt_apt_end) {
		setAttrVal("Dt_apt_end", Dt_apt_end);
	}
	/**
	 * 预约结束时间2
	 * @return FDateTime
	 */
	public FDateTime getDt_apt_e() {
		return ((FDateTime) getAttrVal("Dt_apt_e"));
	}
	/**
	 * 预约结束时间2
	 * @param Dt_apt_e
	 */
	public void setDt_apt_e(FDateTime Dt_apt_e) {
		setAttrVal("Dt_apt_e", Dt_apt_e);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
}