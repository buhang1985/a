package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

public class SrvVsInvoiceTypeDTO  extends BaseDTO {
	private static final long serialVersionUID = 1L;
	//服务
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	//所属发票类型名称
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	//所属发票类型代码
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	//价格比例
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
}
