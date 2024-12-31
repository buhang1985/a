package iih.ei.std.d.v1.en.getusergroup.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取用户组织信息 DTO数据 
 * 
 */
public class UserGroupInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 用户编码
	 * @return String
	 */
	public String getCode_user() {
		return ((String) getAttrVal("Code_user"));
	}	
	/**
	 * 用户编码
	 * @param Code_user
	 */
	public void setCode_user(String Code_user) {
		setAttrVal("Code_user", Code_user);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_user() {
		return ((String) getAttrVal("Name_user"));
	}	
	/**
	 * 用户名称
	 * @param Name_user
	 */
	public void setName_user(String Name_user) {
		setAttrVal("Name_user", Name_user);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_psndoc() {
		return ((String) getAttrVal("Code_psndoc"));
	}	
	/**
	 * 人员编码
	 * @param Code_psndoc
	 */
	public void setCode_psndoc(String Code_psndoc) {
		setAttrVal("Code_psndoc", Code_psndoc);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 人员名称
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 用户组编码
	 * @return String
	 */
	public String getCode_usergrp() {
		return ((String) getAttrVal("Code_usergrp"));
	}	
	/**
	 * 用户组编码
	 * @param Code_usergrp
	 */
	public void setCode_usergrp(String Code_usergrp) {
		setAttrVal("Code_usergrp", Code_usergrp);
	}
	/**
	 * 用户组名称
	 * @return String
	 */
	public String getName_usergrp() {
		return ((String) getAttrVal("Name_usergrp"));
	}	
	/**
	 * 用户组名称
	 * @param Name_usergrp
	 */
	public void setName_usergrp(String Name_usergrp) {
		setAttrVal("Name_usergrp", Name_usergrp);
	}
	/**
	 * 启用状态
	 * @return String
	 */
	public String getActivestate() {
		return ((String) getAttrVal("Activestate"));
	}	
	/**
	 * 启用状态
	 * @param Activestate
	 */
	public void setActivestate(String Activestate) {
		setAttrVal("Activestate", Activestate);
	}
	/**
	 * 启用状态名称
	 * @return String
	 */
	public String getName_activestate() {
		return ((String) getAttrVal("Name_activestate"));
	}	
	/**
	 * 启用状态名称
	 * @param Name_activestate
	 */
	public void setName_activestate(String Name_activestate) {
		setAttrVal("Name_activestate", Name_activestate);
	}
	/**
	 * 角色
	 * @return String
	 */
	public FArrayList getRole() {
		return ((FArrayList) getAttrVal("Role"));
	}	
	/**
	 * 角色
	 * @param Role
	 */
	public void setRole(FArrayList Role) {
		setAttrVal("Role", Role);
	}
	/**
	 * 职责
	 * @return String
	 */
	public FArrayList getResp() {
		return ((FArrayList) getAttrVal("Resp"));
	}	
	/**
	 * 职责
	 * @param Resp
	 */
	public void setResp(FArrayList Resp) {
		setAttrVal("Resp", Resp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public FArrayList getOrg() {
		return ((FArrayList) getAttrVal("Org"));
	}	
	/**
	 * 组织
	 * @param Org
	 */
	public void setOrg(FArrayList Org) {
		setAttrVal("Org", Org);
	}
}