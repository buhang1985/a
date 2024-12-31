package iih.pis.mbw.dto.pismbwfocdocdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwFocdocDTO {

	// 关注医生主键
	@RPCField(id = 1)
	private String id_mbw_focdoc;
	// 用户id
	@RPCField(id = 2)
	private String id_mbw_user;
	// 医生编码
	@RPCField(id = 3)
	private String code;
	// 医生名称
	@RPCField(id = 4)
	private String name;

	public String getId_mbw_focdoc() {
		return id_mbw_focdoc;
	}

	public void setId_mbw_focdoc(String id_mbw_focdoc) {
		this.id_mbw_focdoc = id_mbw_focdoc;
	}

	public String getId_mbw_user() {
		return id_mbw_user;
	}

	public void setId_mbw_user(String id_mbw_user) {
		this.id_mbw_user = id_mbw_user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
