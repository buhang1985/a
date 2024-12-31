package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 登录日志 DTO数据 
 * 
 */
public class EnOperateLogDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会话号
	 * @return String
	 */
	public String getSission() {
		return ((String) getAttrVal("Sission"));
	}
	/**
	 * 会话号
	 * @param Sission
	 */
	public void setSission(String Sission) {
		setAttrVal("Sission", Sission);
	}
	/**
	 * 用户
	 * @return String
	 */
	public String getName_user() {
		return ((String) getAttrVal("Name_user"));
	}
	/**
	 * 用户
	 * @param Name_user
	 */
	public void setName_user(String Name_user) {
		setAttrVal("Name_user", Name_user);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 人员
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 用户类型
	 * @return String
	 */
	public String getUsertype() {
		return ((String) getAttrVal("Usertype"));
	}
	/**
	 * 用户类型
	 * @param Usertype
	 */
	public void setUsertype(String Usertype) {
		setAttrVal("Usertype", Usertype);
	}
	/**
	 * 客户端ip
	 * @return String
	 */
	public String getIp() {
		return ((String) getAttrVal("Ip"));
	}
	/**
	 * 客户端ip
	 * @param Ip
	 */
	public void setIp(String Ip) {
		setAttrVal("Ip", Ip);
	}
	/**
	 * 客户端名称
	 * @return String
	 */
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}
	/**
	 * 客户端名称
	 * @param Name_pc
	 */
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
	}
	/**
	 * 客户端版本
	 * @return String
	 */
	public String getName_version() {
		return ((String) getAttrVal("Name_version"));
	}
	/**
	 * 客户端版本
	 * @param Name_version
	 */
	public void setName_version(String Name_version) {
		setAttrVal("Name_version", Name_version);
	}
	/**
	 * 操作类型
	 * @return Integer
	 */
	public Integer getOperatetype() {
		return ((Integer) getAttrVal("Operatetype"));
	}
	/**
	 * 操作类型
	 * @param Operatetype
	 */
	public void setOperatetype(Integer Operatetype) {
		setAttrVal("Operatetype", Operatetype);
	}
	/**
	 * 进入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b_oper() {
		return ((FDateTime) getAttrVal("Dt_b_oper"));
	}
	/**
	 * 进入时间
	 * @param Dt_b_oper
	 */
	public void setDt_b_oper(FDateTime Dt_b_oper) {
		setAttrVal("Dt_b_oper", Dt_b_oper);
	}
	/**
	 * 离开时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e_oper() {
		return ((FDateTime) getAttrVal("Dt_e_oper"));
	}
	/**
	 * 离开时间
	 * @param Dt_e_oper
	 */
	public void setDt_e_oper(FDateTime Dt_e_oper) {
		setAttrVal("Dt_e_oper", Dt_e_oper);
	}
	/**
	 * 打开功能
	 * @return String
	 */
	public String getName_fun() {
		return ((String) getAttrVal("Name_fun"));
	}
	/**
	 * 打开功能
	 * @param Name_fun
	 */
	public void setName_fun(String Name_fun) {
		setAttrVal("Name_fun", Name_fun);
	}
	/**
	 * 登录部门
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 登录部门
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 登录组织
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 登录组织
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 登录集团
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}
	/**
	 * 登录集团
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 登录结果
	 * @return FBoolean
	 */
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}
	/**
	 * 登录结果
	 * @param Fg_success
	 */
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
	}
	/**
	 * 详情
	 * @return String
	 */
	public String getDetails() {
		return ((String) getAttrVal("Details"));
	}
	/**
	 * 详情
	 * @param Details
	 */
	public void setDetails(String Details) {
		setAttrVal("Details", Details);
	}
	/**
	 * 用户id
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}
	/**
	 * 用户id
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}
	/**
	 * 人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 计算机id
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}
	/**
	 * 计算机id
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 功能节点id
	 * @return String
	 */
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}
	/**
	 * 功能节点id
	 * @param Id_fun
	 */
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
}