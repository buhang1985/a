package iih.ei.std.d.v1.ci.opr.d;

import java.util.List;

import iih.ei.std.d.v1.ci.base.EmsCommonOrdDTO;

/**
 * 手术医嘱DTO_第三方系统回传 DTO数据 
 * 
 */
public class EmsOprOrdDTO extends EmsCommonOrdDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 附加手术_第三方系统回传
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsOprAddDTO> getAddList() {
		return ((List<EmsOprAddDTO>) getAttrVal("AddList"));
	}
	/**
	 * 附加手术_第三方系统回传
	 * @param PresList
	 */
	public void setAddList(List<EmsOprAddDTO> addList) {
		setAttrVal("AddList", addList);
	}
	/**
	 * 手术人员DTO_第三方系统回传
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsOprPerDTO> getPerList() {
		return ((List<EmsOprPerDTO>) getAttrVal("PerList"));
	}
	/**
	 * 手术人员DTO_第三方系统回传
	 * @param PresList
	 */
	public void setPerList(List<EmsOprPerDTO> perList) {
		setAttrVal("PerList", perList);
	}
}