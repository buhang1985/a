package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午4:43:29
 * Description:
 */
public class DCIpIncItmInfo {

	@JsonProperty(value="Code_inccaitm")
	private String Code_inccaitm;//账单编码
	
	@JsonProperty(value="Name_inccaitm")
	private String Name_inccaitm;//账单名称
	
	@JsonProperty(value="Amt_ratio")
	private String Amt_ratio;//账单金额
	
	@JsonProperty(value="D_cg")
	private String D_cg;//记账日期

	public String getCode_inccaitm() {
		return Code_inccaitm;
	}

	public void setCode_inccaitm(String code_inccaitm) {
		Code_inccaitm = code_inccaitm;
	}

	public String getName_inccaitm() {
		return Name_inccaitm;
	}

	public void setName_inccaitm(String name_inccaitm) {
		Name_inccaitm = name_inccaitm;
	}

	public String getAmt_ratio() {
		return Amt_ratio;
	}

	public void setAmt_ratio(String amt_ratio) {
		Amt_ratio = amt_ratio;
	}

	public String getD_cg() {
		return D_cg;
	}

	public void setD_cg(String d_cg) {
		D_cg = d_cg;
	}
	
	
	
}
