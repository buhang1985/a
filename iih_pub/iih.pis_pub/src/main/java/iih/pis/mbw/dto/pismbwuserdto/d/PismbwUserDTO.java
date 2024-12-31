package iih.pis.mbw.dto.pismbwuserdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwUserDTO {

	// 用户id
	@RPCField(id = 1)
	private String id_user;
	// 手机号
	@RPCField(id = 2)
	private String phone;
	// 密码
	@RPCField(id = 3)
	private String password;
	// token
	@RPCField(id = 4)
	private String token;

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
