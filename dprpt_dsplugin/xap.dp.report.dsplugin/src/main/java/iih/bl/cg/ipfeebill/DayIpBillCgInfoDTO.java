package iih.bl.cg.ipfeebill;

import xap.mw.coreitf.d.FDouble;

public class DayIpBillCgInfoDTO {
	
	public String code;
	public String name;
	public FDouble amt;
	
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
	public FDouble getAmt() {
		return amt;
	}
	public void setAmt(FDouble amt) {
		this.amt = amt;
	}
	
}
