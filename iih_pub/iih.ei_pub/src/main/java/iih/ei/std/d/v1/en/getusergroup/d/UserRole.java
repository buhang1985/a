package iih.ei.std.d.v1.en.getusergroup.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 角色 DTO数据 
 * 
 */
public class UserRole extends BaseDTO {
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
	 * 角色编码
	 * @return String
	 */
	public String getCode_role() {
		return ((String) getAttrVal("Code_role"));
	}	
	/**
	 * 角色编码
	 * @param Code_role
	 */
	public void setCode_role(String Code_role) {
		setAttrVal("Code_role", Code_role);
	}
	/**
	 * 角色名称
	 * @return String
	 */
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}	
	/**
	 * 角色名称
	 * @param Name_role
	 */
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
	}
}