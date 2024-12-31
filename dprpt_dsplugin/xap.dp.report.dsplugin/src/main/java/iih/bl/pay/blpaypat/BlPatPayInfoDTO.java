package iih.bl.pay.blpaypat;

import java.util.List;

import xap.mw.coreitf.d.FDouble;

public class BlPatPayInfoDTO {
	public String eudrict;//收费/退费
	public String name_pat;//姓名
	public String code_pat;//编码
	public String no_serial;//流水号
	public String no_ticket;//票号
	public List<BlPatPayReceiveInfoDTO> recList;//项目明细
	public FDouble amt_total;//合计
	public String name_emp_pay;//收款人
	public String dt_pay;//日期
	public String amt_balance;//余额
	public String name_paymod;//付款方式
	public String signature;//签章
	public String name_org;//组织名称，fanlq-2018-05-14
	
	public String getName_org() {
		return name_org;
	}
	public void setName_org(String name_org) {
		this.name_org = name_org;
	}
	public String getEudrict() {
		return eudrict;
	}
	public void setEudrict(String eudrict) {
		this.eudrict = eudrict;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getCode_pat() {
		return code_pat;
	}
	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}
	public String getNo_serial() {
		return no_serial;
	}
	public void setNo_serial(String no_serial) {
		this.no_serial = no_serial;
	}
	public String getNo_ticket() {
		return no_ticket;
	}
	public void setNo_ticket(String no_ticket) {
		this.no_ticket = no_ticket;
	}
	public List<BlPatPayReceiveInfoDTO> getRecList() {
		return recList;
	}
	public void setRecList(List<BlPatPayReceiveInfoDTO> recList) {
		this.recList = recList;
	}
	public FDouble getAmt_total() {
		return amt_total;
	}
	public void setAmt_total(FDouble amt_total) {
		this.amt_total = amt_total;
	}
	public String getName_emp_pay() {
		return name_emp_pay;
	}
	public void setName_emp_pay(String name_emp_pay) {
		this.name_emp_pay = name_emp_pay;
	}
	public String getDt_pay() {
		return dt_pay;
	}
	public void setDt_pay(String dt_pay) {
		this.dt_pay = dt_pay;
	}
	public String getAmt_balance() {
		return amt_balance;
	}
	public void setAmt_balance(String amt_balance) {
		this.amt_balance = amt_balance;
	}
	public String getName_paymod() {
		return name_paymod;
	}
	public void setName_paymod(String name_paymod) {
		this.name_paymod = name_paymod;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
