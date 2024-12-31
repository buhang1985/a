package iih.pis.mbw.dto.pismbwmybilldto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwMybillDetailDTO {

	// 项目编码
	@RPCField(id = 1)
	private String code_srv;
	// 项目名称
	@RPCField(id = 2)
	private String name_srv;
	// 项目单位
	@RPCField(id = 3)
	private String unit;
	// 规格
	@RPCField(id = 4)
	private String spec;
	// 项目单价
	@RPCField(id = 5)
	private String price;
	// 项目数量
	@RPCField(id = 6)
	private String quan;
	// 账单项目编码
	@RPCField(id = 7)
	private String code_inccaitm;
	// 账单项目名称
	@RPCField(id = 8)
	private String name_inccaitm;
	// 小计金额
	@RPCField(id = 9)
	private String amt;

	public String getCode_srv() {
		return code_srv;
	}

	public void setCode_srv(String code_srv) {
		this.code_srv = code_srv;
	}

	public String getName_srv() {
		return name_srv;
	}

	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getCode_inccaitm() {
		return code_inccaitm;
	}

	public void setCode_inccaitm(String code_inccaitm) {
		this.code_inccaitm = code_inccaitm;
	}

	public String getName_inccaitm() {
		return name_inccaitm;
	}

	public void setName_inccaitm(String name_inccaitm) {
		this.name_inccaitm = name_inccaitm;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

}
