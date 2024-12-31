package iih.pis.mbw.dto.pismbwoepdepdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwOepDepDTO {

	// 科室名称
	@RPCField(id = 1)
	private String name_dep;
	// 科室编码
	@RPCField(id = 2)
	private String code_dep;

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getCode_dep() {
		return code_dep;
	}

	public void setCode_dep(String code_dep) {
		this.code_dep = code_dep;
	}

}
