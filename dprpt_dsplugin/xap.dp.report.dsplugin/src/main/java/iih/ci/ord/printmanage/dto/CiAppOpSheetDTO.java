package iih.ci.ord.printmanage.dto;

import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 手术预约单打印DTO
 * @author Young
 */
public class CiAppOpSheetDTO {
	/**
	 * 所属组织
	 */
	private String Name_org;
	public String getName_org() {
		return Name_org;
	}
	public void setName_org(String name_org){
		Name_org = name_org;
	}
	/**
	 * 患者姓名
	 */
	private String Name_pati;
	public String getName_pati() {
		return Name_pati;
	}
	public void setName_pati(String name_pati){
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
	 * 就诊号(住院号)
	 */
	private String Code_en;
	public String getCode_en() {
		return Code_en;
	}
	public void setCode_en(String code_en) {
		Code_en = code_en;
	}
	/**
	 * 病区
	 */
	private String Name_unit;
	public String getName_unit() {
		return Name_unit;
	}
	public void setName_unit(String name_unit) {
		Name_unit = name_unit;
	}
	/**
	 * 床位
	 */
	private String Name_bed;
	public String getName_bed() {
		return Name_bed;
	}
	public void setName_bed(String name_bed) {
		Name_bed = name_bed;
	}
	/**
	 * 术前诊断
	 */
	private String Str_name_di;
	public String getStr_name_di() {
		return Str_name_di;
	}
	public void setStr_name_di(String str_name_di) {
		Str_name_di = str_name_di;
	}
	/**
	 * 预约手术
	 */
	private String Name_srv_op;
	public String getName_srv_op() {
		return Name_srv_op;
	}
	public void setName_srv_op(String name_srv_op){
		Name_srv_op = name_srv_op;
	}
	
	/**
	 * +手术部位
	 */
	private String Name_srv_site;
	
	public String getName_srv_site() {
		return Name_srv_site;
	}
	public void setName_srv_site(String name_srv_site) {
		Name_srv_site = name_srv_site;
	}
	/**
	 * 手术器械
	 */
	private String Instruments;
	public String getInstruments() {
		return Instruments;
	}
	public void setInstruments(String instruments){
		Instruments = instruments;
	}
	/**
	 * 麻醉方法
	 */
	private String Name_anestp;
	public String getName_anestp() {
		return Name_anestp;
	}
	public void setName_anestp(String name_anestp){
		Name_anestp = name_anestp;
	}
	/**
	 * 主刀医师
	 */
	private String Name_emp_oper;
	public String getName_emp_oper() {
		return Name_emp_oper;
	}
	public void setName_emp_oper(String name_emp_oper){
		Name_emp_oper = name_emp_oper;
	}
	/**
	 * 第一助手
	 */
	private String Name_emp_aide1;
	public String getName_emp_aide1() {
		return Name_emp_aide1;
	}
	public void setName_emp_aide1(String name_emp_aide1){
		Name_emp_aide1 = name_emp_aide1;
	}
	/**
	 * 第二助手
	 */
	private String Name_emp_aide2;
	public String getName_emp_aide2() {
		return Name_emp_aide2;
	}
	public void setName_emp_aide2(String name_emp_aide2){
		Name_emp_aide2 = name_emp_aide2;
	}
	/**
	 * 麻醉人员
	 */
	private String Name_emp_anes;
	public String getName_emp_anes() {
		return Name_emp_anes;
	}
	public void setName_emp_anes(String name_emp_anes){
		Name_emp_anes = name_emp_anes;
	}
	/**
	 * 预约手术日期
	 */
	private FDateTime Dt_plan_op;
	public FDateTime getDt_plan_op() {
		return Dt_plan_op;
	}
	public void setDt_plan_op(FDateTime dt_plan_op){
		Dt_plan_op = dt_plan_op;
	}
	/**
	 * 预约医生
	 */
	private String Name_emp_or;
	public String getName_emp_or() {
		return Name_emp_or;
	}
	public void setName_emp_or(String name_emp_or){
		Name_emp_or = name_emp_or;
	}
	/**
	 * 输血量
	 */
	private FDouble Quan_bt_plan;
	public FDouble getQuan_bt_plan() {
		return Quan_bt_plan;
	}
	public void setQuan_bt_plan(FDouble quan_bt_plan){
		Quan_bt_plan = quan_bt_plan;
	}
	/**
	 * 备注
	 */
	private String Des_or;
	public String getDes_or() {
		return Des_or;
	}
	public void setDes_or(String des_or){
		Des_or = des_or;
	}
}
