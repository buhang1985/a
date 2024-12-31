package iih.ci.ord.printmanage.dto;

import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 取血申请单打印DTO
 * @author Young
 */
public class CiAppBuSheetDTO {
	/**
	 * 所属集团
	 */
	private String Id_grp;
	public String getId_grp() {
		return Id_grp;
	}
	public void setId_grp(String id_grp){
		Id_grp = id_grp;
	}
	private String Name_grp;/////////////////////
	public String getName_grp() {
		return Name_grp;
	}
	public void setName_grp(String name_grp){
		Name_grp = name_grp;
	}
	/**
	 * 所属组织
	 */
	private String Id_org;
	public String getId_org() {
		return Id_org;
	}
	public void setId_org(String id_org){
		Id_org = id_org;
	}
	private String Name_org;//////////////////////
	public String getName_org() {
		return Name_org;
	}
	public void setName_org(String name_org){
		Name_org = name_org;
	}
	/**
	 * 患者姓名
	 */
	private String Id_pati;
	public String getId_pati() {
		return Id_pati;
	}
	public void setId_pati(String id_pati){
		Id_pati = id_pati;
	}
	private String Name_pati;///////////////////
	public String getName_pati() {
		return Name_pati;
	}
	public void setName_pati(String name_pati){
		Name_pati = name_pati;
	}
	/**
	 * 性别
	 */
	private String Gender;////////////////////////
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender){
		Gender = gender;
	}
	/**
	 * 就诊号
	 */
	private String Code_en;////////////////////////
	public String getCode_en() {
		return Code_en;
	}
	public void setCode_en(String code_en){
		Code_en = code_en;
	}
	/**
	 * 医嘱ID
	 */
	private String Id_or;
	public String getId_or() {
		return Id_or;
	}
	public void setId_or(String id_or){
		Id_or = id_or;
	}
	/**
	 * 医嘱服务ID
	 */
	private String Id_orsrv;
	public String getId_orsrv() {
		return Id_orsrv;
	}
	public void setId_orsrv(String id_orsrv){
		Id_orsrv = id_orsrv;
	}
	/**
	 * 服务ID
	 */
	private String Id_srv;
	public String getId_srv() {
		return Id_srv;
	}
	public void setId_srv(String id_srv){
		Id_srv = id_srv;
	}
	/**
	 * 取血申请单ID
	 */
	private String Id_apbu;
	public String getId_apbu() {
		return Id_apbu;
	}
	public void setId_apbu(String id_apbu){
		Id_apbu = id_apbu;
	}
	/**
	 * 备血申请单ID
	 */
	private String Id_apbt;
	public String getId_apbt() {
		return Id_apbt;
	}
	public void setId_apbt(String id_apbt){
		Id_apbt = id_apbt;
	}
	/**
	 * 取血申请单号
	 */
	private String Code_app_bu;////////////////////////
	public String getCode_app_bu() {
		return Code_app_bu;
	}
	public void setCode_app_bu(String code_app_bu){
		Code_app_bu = code_app_bu;
	}
	/**
	 * 备血申请单号
	 */
	private String Code_app_bt;///////////////////////
	public String getCode_app_bt() {
		return Code_app_bt;
	}
	public void setCode_app_bt(String code_app_bt){
		Code_app_bt = code_app_bt;
	}
	/**
	 * 申请血液种类
	 */
	private String Id_blootp;
	public String getId_blootp() {
		return Id_blootp;
	}
	public void setId_blootp(String id_blootp){
		Id_blootp = id_blootp;
	}
	private String Name_blootp;///////////////////////////
	public String getName_blootp() {
		return Name_blootp;
	}
	public void setName_blootp(String name_blootp){
		Name_blootp = name_blootp;
	}
	/**
	 * 申请血型
	 */
	private String Id_app_bloodtype;
	public String getId_app_bloodtype() {
		return Id_app_bloodtype;
	}
	public void setId_app_bloodtype(String id_app_bloodtype){
		Id_app_bloodtype = id_app_bloodtype;
	}
	private String Name_app_bloodtype;
	public String getName_app_bloodtype() {
		return Name_app_bloodtype;
	}
	public void setName_app_bloodtype(String name_app_bloodtype){
		Name_app_bloodtype = name_app_bloodtype;
	}
	/**
	 * 申请Rh(D)
	 */
	private String Id_app_rhd;
	public String getId_app_rhd() {
		return Id_app_rhd;
	}
	public void setId_app_rhd(String id_app_rhd){
		Id_app_rhd = id_app_rhd;
	}
	private String Name_app_rhd;
	public String getName_app_rhd() {
		return Name_app_rhd;
	}
	public void setName_app_rhd(String name_app_rhd){
		Name_app_rhd = name_app_rhd;
	}
	/**
	 * 本次取血量
	 */
	private FDouble Quan_medu_bu;////////////////////////
	public FDouble getQuan_medu_bu() {
		return Quan_medu_bu;
	}
	public void setQuan_medu_bu(FDouble quan_medu_bu){
		Quan_medu_bu = quan_medu_bu;
	}
	/**
	 * 血量单位
	 */
	private String Id_medu_unit;
	public String getId_medu_unit() {
		return Id_medu_unit;
	}
	public void setId_medu_unit(String id_medu_unit){
		Id_medu_unit = id_medu_unit;
	}
	private String Name_medu_unit;////////////////////////
	public String getName_medu_unit() {
		return Name_medu_unit;
	}
	public void setName_medu_unit(String name_medu_unit){
		Name_medu_unit = name_medu_unit;
	}
	/**
	 * 计划取血时间
	 */
	private FDateTime Dt_pl_bu;////////////////////////
	public FDateTime getDt_pl_bu() {
		return Dt_pl_bu;
	}
	public void setDt_pl_bu(FDateTime dt_pl_bu){
		Dt_pl_bu = dt_pl_bu;
	}
	/**
	 * 申请医生
	 */
	private String Id_emp_bu;
	public String getId_emp_bu() {
		return Id_emp_bu;
	}
	public void setId_emp_bu(String id_emp_bu){
		Id_emp_bu = id_emp_bu;
	}
	private String Name_emp_bu;////////////////////////
	public String getName_emp_bu() {
		return Name_emp_bu;
	}
	public void setName_emp_bu(String name_emp_bu){
		Name_emp_bu = name_emp_bu;
	}
	/**
	 * 联系电话
	 */
	private String Applydoctortel;////////////////////////
	public String getApplydoctortel() {
		return Applydoctortel;
	}
	public void setApplydoctortel(String applydoctortel){
		Applydoctortel = applydoctortel;
	}
}
