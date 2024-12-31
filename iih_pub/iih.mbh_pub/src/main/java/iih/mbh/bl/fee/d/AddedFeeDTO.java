package iih.mbh.bl.fee.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class AddedFeeDTO {

	// 记账id
	@RPCField(id = 1)
	private String id_cg;
	// 医嘱id
	@RPCField(id = 10)
	private String id_or;
	// 补录服务名称
	@RPCField(id = 11)
	private String name_srv;
	// 组织id
	@RPCField(id = 12)
	private String id_org;
	// 补录服务id
	@RPCField(id = 2)
	private String id_srv;
	// 补录服务编码
	@RPCField(id = 3)
	private String code_srv;
	// 数量
	@RPCField(id = 4)
	private double quan;
	// 标准单价
	@RPCField(id = 5)
	private double price_std;
	// 标准金额
	@RPCField(id = 6)
	private double amt_std;
	// 记账人id
	@RPCField(id = 7)
	private String id_emp_cg;
	// 记账人姓名
	@RPCField(id = 8)
	private String name_emp_cg;
	// 记账时间
	@RPCField(id = 9)
	private String dt_cg;

	public String getId_cg() {
		return id_cg;
	}

	public void setId_cg(String id_cg) {
		this.id_cg = id_cg;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getName_srv() {
		return name_srv;
	}

	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}

	public String getId_org() {
		return id_org;
	}

	public void setId_org(String id_org) {
		this.id_org = id_org;
	}

	public String getId_srv() {
		return id_srv;
	}

	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}

	public String getCode_srv() {
		return code_srv;
	}

	public void setCode_srv(String code_srv) {
		this.code_srv = code_srv;
	}

	public double getQuan() {
		return quan;
	}

	public void setQuan(double quan) {
		this.quan = quan;
	}

	public double getPrice_std() {
		return price_std;
	}

	public void setPrice_std(double price_std) {
		this.price_std = price_std;
	}

	public double getAmt_std() {
		return amt_std;
	}

	public void setAmt_std(double amt_std) {
		this.amt_std = amt_std;
	}

	public String getId_emp_cg() {
		return id_emp_cg;
	}

	public void setId_emp_cg(String id_emp_cg) {
		this.id_emp_cg = id_emp_cg;
	}

	public String getName_emp_cg() {
		return name_emp_cg;
	}

	public void setName_emp_cg(String name_emp_cg) {
		this.name_emp_cg = name_emp_cg;
	}

	public String getDt_cg() {
		return dt_cg;
	}

	public void setDt_cg(String dt_cg) {
		this.dt_cg = dt_cg;
	}

}
