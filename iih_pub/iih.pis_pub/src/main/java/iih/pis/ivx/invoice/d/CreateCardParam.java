package iih.pis.ivx.invoice.d;

public class CreateCardParam {

	//用来存放其他字段(必填)
	private CreateCardParam invoice_info;
	
	//发票卡券模板基础信息(必填)
	private BaseInfo base_info;
	
	//收款方（开票方）全称，显示在发票详情内。故建议一个收款方对应一个发票卡券模板(必填)
	private String payee;
	
	//发票类型(必填)
	private String type;

	public CreateCardParam getInvoice_info() {
		return invoice_info;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public String getPayee() {
		return payee;
	}

	public String getType() {
		return type;
	}

	public void setInvoice_info(CreateCardParam invoice_info) {
		this.invoice_info = invoice_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
