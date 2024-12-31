package iih.ei.std.d.v1.en.getusergroup.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 职责 DTO数据 
 * 
 */
public class UserResp extends BaseDTO {
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
	 * 职责编码
	 * @return String
	 */
	public String getCode_resp() {
		return ((String) getAttrVal("Code_resp"));
	}	
	/**
	 * 职责编码
	 * @param Code_resp
	 */
	public void setCode_resp(String Code_resp) {
		setAttrVal("Code_resp", Code_resp);
	}
	/**
	 * 职责名称
	 * @return String
	 */
	public String getName_resp() {
		return ((String) getAttrVal("Name_resp"));
	}	
	/**
	 * 职责名称
	 * @param Name_resp
	 */
	public void setName_resp(String Name_resp) {
		setAttrVal("Name_resp", Name_resp);
	}
}