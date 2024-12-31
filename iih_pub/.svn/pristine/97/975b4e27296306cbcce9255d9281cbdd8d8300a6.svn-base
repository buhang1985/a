package iih.mbh.bl.fee.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class DayFeeTypeDTO {

	// 分类id
	@RPCField(id = 1)
	private String id_type;
	// 列别名称
	@RPCField(id = 2)
	private String name_type;
	// 金额
	@RPCField(id = 3)
	private double amount;
	// 分类详情
	@RPCField(id = 4)
	private List<DayFeeChildDTO> feechilds;

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getName_type() {
		return name_type;
	}

	public void setName_type(String name_type) {
		this.name_type = name_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<DayFeeChildDTO> getFeechilds() {
		return feechilds;
	}

	public void setFeechilds(List<DayFeeChildDTO> feechilds) {
		this.feechilds = feechilds;
	}

}
