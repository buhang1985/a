package iih.mbh.mp.entlv.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class EntLvUdidocDTO {

	// 档案编号
	@RPCField(id = 1)
	private String id_udidoc;
	// 档案编码
	@RPCField(id = 2)
	private String code;
	// 档案名称
	@RPCField(id = 3)
	private String name;
	// 备选字段
	@RPCField(id = 4)
	private String ctrl1;
	// 默认值
	@RPCField(id = 5)
	private boolean defVal;

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

	public String getCtrl1() {
		return ctrl1;
	}

	public void setCtrl1(String ctrl1) {
		this.ctrl1 = ctrl1;
	}

	public boolean getDefVal() {
		return defVal;
	}

	public void setDefVal(boolean defVal) {
		this.defVal = defVal;
	}

}
