package iih.mbh.bl.fee.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class AllDayCostDTO {

	// 费用日期
	@RPCField(id = 1)
	private String dt_bl;
	// 当日费用金额
	@RPCField(id = 2)
	private String amount;

	public String getDt_bl() {
		return dt_bl;
	}

	public void setDt_bl(String dt_bl) {
		this.dt_bl = dt_bl;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
