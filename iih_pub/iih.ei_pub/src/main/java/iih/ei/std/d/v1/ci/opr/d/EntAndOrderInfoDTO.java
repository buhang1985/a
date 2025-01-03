package iih.ei.std.d.v1.ci.opr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊和医嘱信息DTO DTO数据 
 * 
 */
public class EntAndOrderInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所属集团
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 所属集团
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 所属组织
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_en() {
		return ((String) getAttrVal("Times_en"));
	}	
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(String Times_en) {
		setAttrVal("Times_en", Times_en);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}	
	/**
	 * 就诊编码
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
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
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}	
	/**
	 * 当前主管医生
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 当前责任护士
	 * @return String
	 */
	public String getCode_emp_nur() {
		return ((String) getAttrVal("Code_emp_nur"));
	}	
	/**
	 * 当前责任护士
	 * @param Code_emp_nur
	 */
	public void setCode_emp_nur(String Code_emp_nur) {
		setAttrVal("Code_emp_nur", Code_emp_nur);
	}
	/**
	 * 当前所在病区
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 当前所在病区
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床位号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * VIP标识
	 * @return String
	 */
	public String getFg_vip() {
		return ((String) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(String Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 高端商保标识
	 * @return String
	 */
	public String getFg_hecominsur() {
		return ((String) getAttrVal("Fg_hecominsur"));
	}	
	/**
	 * 高端商保标识
	 * @param Fg_hecominsur
	 */
	public void setFg_hecominsur(String Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	/**
	 * 婴儿标识
	 * @return String
	 */
	public String getFg_bb() {
		return ((String) getAttrVal("Fg_bb"));
	}	
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(String Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
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
	 * 手术项目编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}	
	/**
	 * 手术项目编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String Code_srv_or) {
		setAttrVal("Code_srv_or", Code_srv_or);
	}
	/**
	 * 手术项目名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}	
	/**
	 * 手术项目名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
	}
	/**
	 * 手术申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 手术申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 主刀医生
	 * @return String
	 */
	public String getCode_emp_operate() {
		return ((String) getAttrVal("Code_emp_operate"));
	}	
	/**
	 * 主刀医生
	 * @param Code_emp_operate
	 */
	public void setCode_emp_operate(String Code_emp_operate) {
		setAttrVal("Code_emp_operate", Code_emp_operate);
	}
	/**
	 * 第一助手
	 * @return String
	 */
	public String getCode_emp_helper() {
		return ((String) getAttrVal("Code_emp_helper"));
	}	
	/**
	 * 第一助手
	 * @param Code_emp_helper
	 */
	public void setCode_emp_helper(String Code_emp_helper) {
		setAttrVal("Code_emp_helper", Code_emp_helper);
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
	 * 计划手术时间
	 * @return String
	 */
	public String getDt_plan() {
		return ((String) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划手术时间
	 * @param Dt_plan
	 */
	public void setDt_plan(String Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 计划手术时长
	 * @return String
	 */
	public String getSugplantime() {
		return ((String) getAttrVal("Sugplantime"));
	}	
	/**
	 * 计划手术时长
	 * @param Sugplantime
	 */
	public void setSugplantime(String Sugplantime) {
		setAttrVal("Sugplantime", Sugplantime);
	}
	/**
	 * 麻醉方法
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	/**
	 * 麻醉方法
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 体位id
	 * @return String
	 */
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	/**
	 * 体位id
	 * @param Sd_sugbody
	 */
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	/**
	 * 手术期限编码
	 * @return String
	 */
	public String getSd_datelimittype() {
		return ((String) getAttrVal("Sd_datelimittype"));
	}	
	/**
	 * 手术期限编码
	 * @param Sd_datelimittype
	 */
	public void setSd_datelimittype(String Sd_datelimittype) {
		setAttrVal("Sd_datelimittype", Sd_datelimittype);
	}
	/**
	 * 手术部位编码
	 * @return String
	 */
	public String getSd_surgical_site() {
		return ((String) getAttrVal("Sd_surgical_site"));
	}	
	/**
	 * 手术部位编码
	 * @param Sd_surgical_site
	 */
	public void setSd_surgical_site(String Sd_surgical_site) {
		setAttrVal("Sd_surgical_site", Sd_surgical_site);
	}
	/**
	 * 特殊准备
	 * @return String
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	/**
	 * 特殊准备
	 * @param Specialdes
	 */
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 药物过敏标识
	 * @return String
	 */
	public String getFg_allergy() {
		return ((String) getAttrVal("Fg_allergy"));
	}	
	/**
	 * 药物过敏标识
	 * @param Fg_allergy
	 */
	public void setFg_allergy(String Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
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
	 * 附加手术DTO
	 * @return String
	 */
	public FArrayList getAddoprdto() {
		return ((FArrayList) getAttrVal("Addoprdto"));
	}	
	/**
	 * 附加手术DTO
	 * @param Addoprdto
	 */
	public void setAddoprdto(FArrayList Addoprdto) {
		setAttrVal("Addoprdto", Addoprdto);
	}
	/**
	 * 手术人员DTO
	 * @return String
	 */
	public FArrayList getOprperdto() {
		return ((FArrayList) getAttrVal("Oprperdto"));
	}	
	/**
	 * 手术人员DTO
	 * @param Oprperdto
	 */
	public void setOprperdto(FArrayList Oprperdto) {
		setAttrVal("Oprperdto", Oprperdto);
	}
	/**
	 * 费用明细DTO
	 * @return String
	 */
	public FArrayList getOprsrvdto() {
		return ((FArrayList) getAttrVal("Oprsrvdto"));
	}	
	/**
	 * 费用明细DTO
	 * @param Oprsrvdto
	 */
	public void setOprsrvdto(FArrayList Oprsrvdto) {
		setAttrVal("Oprsrvdto", Oprsrvdto);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	/**
	 * 切口等级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	/**
	 * 切口等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 手术等级
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	/**
	 * 手术等级
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术等级编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	/**
	 * 手术等级编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 加急标志
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
}