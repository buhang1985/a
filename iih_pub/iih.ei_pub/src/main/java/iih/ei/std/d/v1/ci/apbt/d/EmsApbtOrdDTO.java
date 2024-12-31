package iih.ei.std.d.v1.ci.apbt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方备血医嘱dto DTO数据 
 * 
 */
public class EmsApbtOrdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱序号
	 * @return String
	 */
	public String getSortno_or() {
		return ((String) getAttrVal("Sortno_or"));
	}	
	/**
	 * 医嘱序号
	 * @param Sortno_or
	 */
	public void setSortno_or(String Sortno_or) {
		setAttrVal("Sortno_or", Sortno_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 备血项目编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}	
	/**
	 * 备血项目编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String Code_srv_or) {
		setAttrVal("Code_srv_or", Code_srv_or);
	}
	/**
	 * 备血项目名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}	
	/**
	 * 备血项目名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
	}
	/**
	 * 备血申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 备血申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 孕几胎
	 * @return String
	 */
	public String getPregnant_num() {
		return ((String) getAttrVal("Pregnant_num"));
	}	
	/**
	 * 孕几胎
	 * @param Pregnant_num
	 */
	public void setPregnant_num(String Pregnant_num) {
		setAttrVal("Pregnant_num", Pregnant_num);
	}
	/**
	 * 生产数量
	 * @return String
	 */
	public String getParturition_cnt() {
		return ((String) getAttrVal("Parturition_cnt"));
	}	
	/**
	 * 生产数量
	 * @param Parturition_cnt
	 */
	public void setParturition_cnt(String Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	/**
	 * 输血史标识编码
	 * @return String
	 */
	public String getSd_his_bt() {
		return ((String) getAttrVal("Sd_his_bt"));
	}	
	/**
	 * 输血史标识编码
	 * @param Sd_his_bt
	 */
	public void setSd_his_bt(String Sd_his_bt) {
		setAttrVal("Sd_his_bt", Sd_his_bt);
	}
	/**
	 * 输血目的编码
	 * @return String
	 */
	public String getSd_pps_bt() {
		return ((String) getAttrVal("Sd_pps_bt"));
	}	
	/**
	 * 输血目的编码
	 * @param Sd_pps_bt
	 */
	public void setSd_pps_bt(String Sd_pps_bt) {
		setAttrVal("Sd_pps_bt", Sd_pps_bt);
	}
	/**
	 * 输血目的描述
	 * @return String
	 */
	public String getDes_pps_bt() {
		return ((String) getAttrVal("Des_pps_bt"));
	}	
	/**
	 * 输血目的描述
	 * @param Des_pps_bt
	 */
	public void setDes_pps_bt(String Des_pps_bt) {
		setAttrVal("Des_pps_bt", Des_pps_bt);
	}
	/**
	 * 临床诊断编码
	 * @return String
	 */
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	/**
	 * 临床诊断编码
	 * @param Code_diag
	 */
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	/**
	 * 临床诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 临床诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 献血史标识
	 * @return String
	 */
	public String getFg_db() {
		return ((String) getAttrVal("Fg_db"));
	}	
	/**
	 * 献血史标识
	 * @param Fg_db
	 */
	public void setFg_db(String Fg_db) {
		setAttrVal("Fg_db", Fg_db);
	}
	/**
	 * 献血证号
	 * @return String
	 */
	public String getNo_db() {
		return ((String) getAttrVal("No_db"));
	}	
	/**
	 * 献血证号
	 * @param No_db
	 */
	public void setNo_db(String No_db) {
		setAttrVal("No_db", No_db);
	}
	/**
	 * 输血需求状态
	 * @return String
	 */
	public String getSd_demandsu_bt() {
		return ((String) getAttrVal("Sd_demandsu_bt"));
	}	
	/**
	 * 输血需求状态
	 * @param Sd_demandsu_bt
	 */
	public void setSd_demandsu_bt(String Sd_demandsu_bt) {
		setAttrVal("Sd_demandsu_bt", Sd_demandsu_bt);
	}
	/**
	 * 预定输血方式
	 * @return String
	 */
	public String getSd_mode_bt() {
		return ((String) getAttrVal("Sd_mode_bt"));
	}	
	/**
	 * 预定输血方式
	 * @param Sd_mode_bt
	 */
	public void setSd_mode_bt(String Sd_mode_bt) {
		setAttrVal("Sd_mode_bt", Sd_mode_bt);
	}
	/**
	 * 计划输血日期
	 * @return String
	 */
	public String getDt_bt_pl() {
		return ((String) getAttrVal("Dt_bt_pl"));
	}	
	/**
	 * 计划输血日期
	 * @param Dt_bt_pl
	 */
	public void setDt_bt_pl(String Dt_bt_pl) {
		setAttrVal("Dt_bt_pl", Dt_bt_pl);
	}
	/**
	 * 申请血型编码
	 * @return String
	 */
	public String getSd_bloodtype_ap() {
		return ((String) getAttrVal("Sd_bloodtype_ap"));
	}	
	/**
	 * 申请血型编码
	 * @param Sd_bloodtype_ap
	 */
	public void setSd_bloodtype_ap(String Sd_bloodtype_ap) {
		setAttrVal("Sd_bloodtype_ap", Sd_bloodtype_ap);
	}
	/**
	 * 申请Rh(D)编码
	 * @return String
	 */
	public String getSd_rhd_ap() {
		return ((String) getAttrVal("Sd_rhd_ap"));
	}	
	/**
	 * 申请Rh(D)编码
	 * @param Sd_rhd_ap
	 */
	public void setSd_rhd_ap(String Sd_rhd_ap) {
		setAttrVal("Sd_rhd_ap", Sd_rhd_ap);
	}
	/**
	 * 新生儿标识
	 * @return String
	 */
	public String getFg_newborn() {
		return ((String) getAttrVal("Fg_newborn"));
	}	
	/**
	 * 新生儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(String Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 申请血量
	 * @return String
	 */
	public String getQuan_medu_bt() {
		return ((String) getAttrVal("Quan_medu_bt"));
	}	
	/**
	 * 申请血量
	 * @param Quan_medu_bt
	 */
	public void setQuan_medu_bt(String Quan_medu_bt) {
		setAttrVal("Quan_medu_bt", Quan_medu_bt);
	}
	/**
	 * 申请血量单位
	 * @return String
	 */
	public String getCode_medu_bt() {
		return ((String) getAttrVal("Code_medu_bt"));
	}	
	/**
	 * 申请血量单位
	 * @param Code_medu_bt
	 */
	public void setCode_medu_bt(String Code_medu_bt) {
		setAttrVal("Code_medu_bt", Code_medu_bt);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getCode_org_or() {
		return ((String) getAttrVal("Code_org_or"));
	}	
	/**
	 * 开立机构
	 * @param Code_org_or
	 */
	public void setCode_org_or(String Code_org_or) {
		setAttrVal("Code_org_or", Code_org_or);
	}
	/**
	 * 开立部门
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开立部门
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getCode_wg_or() {
		return ((String) getAttrVal("Code_wg_or"));
	}	
	/**
	 * 开立医疗组
	 * @param Code_wg_or
	 */
	public void setCode_wg_or(String Code_wg_or) {
		setAttrVal("Code_wg_or", Code_wg_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开立日期
	 * @return String
	 */
	public String getDt_entry_or() {
		return ((String) getAttrVal("Dt_entry_or"));
	}	
	/**
	 * 开立日期
	 * @param Dt_entry_or
	 */
	public void setDt_entry_or(String Dt_entry_or) {
		setAttrVal("Dt_entry_or", Dt_entry_or);
	}
	/**
	 * 医嘱执行机构
	 * @return String
	 */
	public String getCode_org_mp_or() {
		return ((String) getAttrVal("Code_org_mp_or"));
	}	
	/**
	 * 医嘱执行机构
	 * @param Code_org_mp_or
	 */
	public void setCode_org_mp_or(String Code_org_mp_or) {
		setAttrVal("Code_org_mp_or", Code_org_mp_or);
	}
	/**
	 * 医嘱执行科室
	 * @return String
	 */
	public String getCode_dep_mp_or() {
		return ((String) getAttrVal("Code_dep_mp_or"));
	}	
	/**
	 * 医嘱执行科室
	 * @param Code_dep_mp_or
	 */
	public void setCode_dep_mp_or(String Code_dep_mp_or) {
		setAttrVal("Code_dep_mp_or", Code_dep_mp_or);
	}
	/**
	 * 检验信息list
	 * @return String
	 */
	public FArrayList getChecklist() {
		return ((FArrayList) getAttrVal("Checklist"));
	}	
	/**
	 * 检验信息list
	 * @param Checklist
	 */
	public void setChecklist(FArrayList Checklist) {
		setAttrVal("Checklist", Checklist);
	}
	/**
	 * 费用/服务信息list
	 * @return String
	 */
	public FArrayList getSrvlist() {
		return ((FArrayList) getAttrVal("Srvlist"));
	}	
	/**
	 * 费用/服务信息list
	 * @param Srvlist
	 */
	public void setSrvlist(FArrayList Srvlist) {
		setAttrVal("Srvlist", Srvlist);
	}
	/**
	 * 血液成分信息
	 * @return String
	 */
	public FArrayList getEmsapbtblooditemdto() {
		return ((FArrayList) getAttrVal("Emsapbtblooditemdto"));
	}	
	/**
	 * 血液成分信息
	 * @param Emsapbtblooditemdto
	 */
	public void setEmsapbtblooditemdto(FArrayList Emsapbtblooditemdto) {
		setAttrVal("Emsapbtblooditemdto", Emsapbtblooditemdto);
	}
}