package iih.mbh.mp.orplan.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class MBHUdidocDTO {

	// 档案主键
	@RPCField(id = 1)
	private String id_udidoc;
	// 档案编码
	@RPCField(id = 2)
	private String code;
	// 档案名称
	@RPCField(id = 3)
	private String name;

	public String getId_udidoc() {
		return id_udidoc;
	}

	public void setId_udidoc(String id_udidoc) {
		this.id_udidoc = id_udidoc;
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
