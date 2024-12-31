package iih.mbh.bl.fee.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PrepayDTO {

	// 收据号码
	@RPCField(id = 1)
	private String nums;
	// 收款方式名称
	@RPCField(id = 10)
	private String name_pay;
	// 收款人名称
	@RPCField(id = 11)
	private String name_emp;
	// 收款金额
	@RPCField(id = 2)
	private double pay_amount;
	// 收款方式id
	@RPCField(id = 3)
	private String id_pay;
	// 收款方式
	@RPCField(id = 4)
	private String sd_pay;
	// 凭证号码
	@RPCField(id = 5)
	private String vouchernums;
	// 收款日期
	@RPCField(id = 6)
	private String sd_paydate;
	// 收款部门id
	@RPCField(id = 7)
	private String id_dep;
	// 收款部门名称
	@RPCField(id = 8)
	private String name_dep;
	// 收款人id
	@RPCField(id = 9)
	private String id_emp;

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getName_pay() {
		return name_pay;
	}

	public void setName_pay(String name_pay) {
		this.name_pay = name_pay;
	}

	public String getName_emp() {
		return name_emp;
	}

	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}

	public double getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(double pay_amount) {
		this.pay_amount = pay_amount;
	}

	public String getId_pay() {
		return id_pay;
	}

	public void setId_pay(String id_pay) {
		this.id_pay = id_pay;
	}

	public String getSd_pay() {
		return sd_pay;
	}

	public void setSd_pay(String sd_pay) {
		this.sd_pay = sd_pay;
	}

	public String getVouchernums() {
		return vouchernums;
	}

	public void setVouchernums(String vouchernums) {
		this.vouchernums = vouchernums;
	}

	public String getSd_paydate() {
		return sd_paydate;
	}

	public void setSd_paydate(String sd_paydate) {
		this.sd_paydate = sd_paydate;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

}
