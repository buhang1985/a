package iih.pis.mbw.dto.pismbwmybilldto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwMybillDTO {

	// 账单金额
	@RPCField(id = 1)
	private String amt_inccaitm;
	// 我的账单明细列表
	@RPCField(id = 2)
	private List<PismbwMybillDetailDTO> billdetaillist;
	// 账单项编码
	@RPCField(id = 3)
	private String code_inccaitm;
	// 账单项名称
	@RPCField(id = 4)
	private String name_inccaitm;

	public String getAmt_inccaitm() {
		return amt_inccaitm;
	}

	public void setAmt_inccaitm(String amt_inccaitm) {
		this.amt_inccaitm = amt_inccaitm;
	}

	public List<PismbwMybillDetailDTO> getBilldetaillist() {
		return billdetaillist;
	}

	public void setBilldetaillist(List<PismbwMybillDetailDTO> billdetaillist) {
		this.billdetaillist = billdetaillist;
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

}
