package iih.mbh.bl.fee.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class DayFeeChildDTO {

	// 名称
	@RPCField(id = 1)
	private String name;
	// 分类id
	@RPCField(id = 2)
	private String id_type;
	// 详细名称
	@RPCField(id = 3)
	private String name_detail;
	// 金额
	@RPCField(id = 4)
	private double amount;
	// 单价
	@RPCField(id = 5)
	private double price;
	// 数量
	@RPCField(id = 6)
	private int num;
	// 规格
	@RPCField(id = 7)
	private String spec;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getName_detail() {
		return name_detail;
	}

	public void setName_detail(String name_detail) {
		this.name_detail = name_detail;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

}
