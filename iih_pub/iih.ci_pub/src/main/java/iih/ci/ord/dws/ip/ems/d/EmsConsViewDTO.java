package iih.ci.ord.dws.ip.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;

import java.math.BigDecimal;

/**
 * 会诊医疗单 DTO数据 
 * 
 */
public class EmsConsViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 计划会诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划会诊时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 临床诊断ID
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 临床诊断ID
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断子项ID
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断子项ID
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getName_diitm() {
		return ((String) getAttrVal("Name_diitm"));
	}
	/**
	 * 临床诊断
	 * @param Name_diitm
	 */
	public void setName_diitm(String Name_diitm) {
		setAttrVal("Name_diitm", Name_diitm);
	}
	/**
	 * 临床诊断过滤条件
	 * @return String
	 */
	public String getFilter_diitm() {
		return ((String) getAttrVal("Filter_diitm"));
	}
	/**
	 * 临床诊断过滤条件
	 * @param Filter_diitm
	 */
	public void setFilter_diitm(String Filter_diitm) {
		setAttrVal("Filter_diitm", Filter_diitm);
	}
	/**
	 * 会诊目的
	 * @return String
	 */
	public String getDes_psp() {
		return ((String) getAttrVal("Des_psp"));
	}
	/**
	 * 会诊目的
	 * @param Des_psp
	 */
	public void setDes_psp(String Des_psp) {
		setAttrVal("Des_psp", Des_psp);
	}
	/**
	 * 病历摘要
	 * @return String
	 */
	public String getDes_emr() {
		return ((String) getAttrVal("Des_emr"));
	}
	/**
	 * 病历摘要
	 * @param Des_emr
	 */
	public void setDes_emr(String Des_emr) {
		setAttrVal("Des_emr", Des_emr);
	}
	/**
	 * 会诊地点
	 * @return String
	 */
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}
	/**
	 * 会诊地点
	 * @param Place
	 */
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
	/**
	 * 受邀方
	 * @return String
	 */
	public String getInventmsg() {
		return ((String) getAttrVal("Inventmsg"));
	}
	/**
	 * 受邀方
	 * @param Inventmsg
	 */
	public void setInventmsg(String Inventmsg) {
		setAttrVal("Inventmsg", Inventmsg);
	}
	/**
	 * 是否院内会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_inorg() {
		return ((FBoolean) getAttrVal("Fg_inorg"));
	}
	/**
	 * 是否院内会诊
	 * @param Fg_inorg
	 */
	public void setFg_inorg(FBoolean Fg_inorg) {
		setAttrVal("Fg_inorg", Fg_inorg);
	}
	/**
	 * 是否多科室会诊
	 * @return FBoolean
	 */
	public FBoolean getFg_deps() {
		return ((FBoolean) getAttrVal("Fg_deps"));
	}
	/**
	 * 是否多科室会诊
	 * @param Fg_deps
	 */
	public void setFg_deps(FBoolean Fg_deps) {
		setAttrVal("Fg_deps", Fg_deps);
	}
	/**
	 * 受邀医生是否职称限制
	 * @return FBoolean
	 */
	public FBoolean getFg_emptitlelimit() {
		return ((FBoolean) getAttrVal("Fg_emptitlelimit"));
	}
	/**
	 * 受邀医生是否职称限制
	 * @param Fg_emptitlelimit
	 */
	public void setFg_emptitlelimit(FBoolean Fg_emptitlelimit) {
		setAttrVal("Fg_emptitlelimit", Fg_emptitlelimit);
	}
	/**
	 * 受邀医生最低职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}
	/**
	 * 受邀医生最低职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 受邀医生最低职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}
	/**
	 * 受邀医生最低职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 是否需科室审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_clidep() {
		return ((FBoolean) getAttrVal("Fg_audit_clidep"));
	}
	/**
	 * 是否需科室审批
	 * @param Fg_audit_clidep
	 */
	public void setFg_audit_clidep(FBoolean Fg_audit_clidep) {
		setAttrVal("Fg_audit_clidep", Fg_audit_clidep);
	}
	/**
	 * 是否需医务部审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_admdep() {
		return ((FBoolean) getAttrVal("Fg_audit_admdep"));
	}
	/**
	 * 是否需医务部审批
	 * @param Fg_audit_admdep
	 */
	public void setFg_audit_admdep(FBoolean Fg_audit_admdep) {
		setAttrVal("Fg_audit_admdep", Fg_audit_admdep);
	}
}