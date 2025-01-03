package iih.ci.ord.printmanage.dto;

import java.util.List;

/**
 * 会诊记录DTO
 * @author Young
 *
 */
public class OrdConsRptDO {

	/**
	 * 组织机构名称   
	 * //0122284: 住院医生站窗口会诊记录中打印出来会诊记录单格式错误 gh 现有报表为固定标题，将标题改为从数据库中获取
	 */
	private String Name_org;
	
	public String getName_org() {
		return Name_org;
	}
	public void setName_org(String name_org) {
		Name_org = name_org;
	}
	/**
	 * 受邀方信息
	 */
	private List<CiConsInviteDO> inviteDOList;
	public List<CiConsInviteDO> getInviteDOList() {
		return inviteDOList;
	}
	public void setInviteDOList(List<CiConsInviteDO> inviteDOList) {
		this.inviteDOList = inviteDOList;
	}
	/**
	 * 医嘱编码
	 */
	private String Id_or;
	
	public String getId_or() {
		return Id_or;
	}
	public void setId_or(String id_or) {
		Id_or = id_or;
	}
	/**
	 * 会诊地点
	 */
	private String Place;
	/**
	 * 联系人
	 */
	private String Cont_name;
	/**
	 * 联系人电话
	 */
	private String Cont_tel;
	/**
	 * 就诊ID
	 */
	private String Id_en;
	public String getId_en() {
		return Id_en;
	}
	public void setId_en(String id_en) {
		Id_en = id_en;
	}
	
	
	/**
	 * 患者姓名
	 */
	private String Id_pati;
	public String getId_pati() {
		return Id_pati;
	}
	public void setId_pati(String id_pati) {
		Id_pati = id_pati;
	}
	
	private String Name_pati;
	public String getName_pati() {
		return Name_pati;
	}
	public void setName_pati(String name_pati) {
		Name_pati = name_pati;
	}
	
	/**
	 * 性别
	 */
	private String  Gender;
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	/**
	 * 出生日期
	 */
	private String  Dt_birth;
	public String getDt_birth() {
		return Dt_birth;
	}
	public void setDt_birth(String dt_birth) {
		Dt_birth = dt_birth;
	}
	
	/**
	 * 年龄
	 */
	private String  Age;
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	
	/**
	 * 住院科室
	 */
	private String Dep_pati;
	public String getDep_pati() {
		return Dep_pati;
	}
	public void setDep_pati(String dep_pati) {
		Dep_pati = dep_pati;
	}
	
	/**
	 * 床号
	 */
	private String Code_bed;
	public String getCode_bed() {
		return Code_bed;
	}
	public void setCode_bed(String code_bed) {
		Code_bed = code_bed;
	}
	
	/**
	 * 住院号
	 */
	private String Code_en;
	public String getCode_en() {
		return Code_en;
	}
	public void setCode_en(String code_en) {
		Code_en = code_en;
	}
	
	/**
	 * 受邀科室
	 */
	private String Dep_invited;
	public String getDep_invited() {
		return Dep_invited;
	}
	public void setDep_invited(String dep_invited) {
		Dep_invited = dep_invited;
	}
	
	/**
	 * 签署时间
	 */
	private String Dt_sign;
	public String getDt_sign() {
		return Dt_sign;
	}
	public void setDt_sign(String dt_sign) {
		Dt_sign = dt_sign;
	}
	
	/**
	 * 病历摘要
	 */
	private String Des_emr;
	public String getDes_emr() {
		return Des_emr;
	}
	public void setDes_emr(String des_emr) {
		Des_emr = des_emr;
	}
	
	/**
	 * 会诊目的
	 */
	private String Des_psp;
	public String getDes_psp() {
		return Des_psp;
	}
	public void setDes_psp(String des_psp) {
		Des_psp = des_psp;
	}
	
	/**
	 * 申请科室
	 */
	private String Name_dep_or;
	public String getName_dep_or() {
		return Name_dep_or;
	}
	public void setName_dep_or(String name_dep_or) {
		Name_dep_or = name_dep_or;
	}
	
	/**
	 * 申请人
	 */
	private String Name_emp_or;
	public String getName_emp_or() {
		return Name_emp_or;
	}
	public void setName_emp_or(String name_emp_or) {
		Name_emp_or = name_emp_or;
	}
	
	/**
	 * 会诊时间
	 */
	private String  Dt_cons;
	public String getDt_cons() {
		return Dt_cons;
	}
	public void setDt_cons(String dt_cons) {
		Dt_cons = dt_cons;
	}
	
	/**
	 * 会诊意见
	 */
	private String  Advice;
	public String getAdvice() {
		return Advice;
	}
	public void setAdvice(String advice) {
		Advice = advice;
	}
	
	/**
	 * 报告人
	 */
	private String  Name_emp_rpt;
	public String getName_emp_rpt() {
		return Name_emp_rpt;
	}
	public void setName_emp_rpt(String name_emp_rpt) {
		Name_emp_rpt = name_emp_rpt;
	}
	
	/**
	 * 报告日期
	 */
	private String Dt_rpt;
	public String getDt_rpt() {
		return Dt_rpt;
	}
	public void setDt_rpt(String dt_rpt) {
		Dt_rpt = dt_rpt;
	}
	
	/**
	 * 诊断
	 */
	private String Di;
	public String getDi() {
		return Di;
	}
	public void setDi(String di) {
		Di = di;
	}
	
	/**
	 * 加急标识
	 */
	private String Fg_urgent;
	public String getFg_urgent() {
		return Fg_urgent;
	}
	public void setFg_urgent(String fg_urgent) {
		Fg_urgent = fg_urgent;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getCont_name() {
		return Cont_name;
	}
	public void setCont_name(String cont_name) {
		Cont_name = cont_name;
	}
	public String getCont_tel() {
		return Cont_tel;
	}
	public void setCont_tel(String cont_tel) {
		Cont_tel = cont_tel;
	}
	
}
