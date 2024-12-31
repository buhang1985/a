package iih.bl.pay.blpaypat;

import xap.mw.coreitf.d.FDouble;

public class BlPatPayReceiveInfoDTO {
	public String name_item;//项目
	public String name_item_en;//英文名称
	public String amt_pay;//金额
	
	public String getName_item() {
		return name_item;
	}
	public void setName_item(String name_item) {
		this.name_item = name_item;
	}
	public String getAmt_pay() {
		return amt_pay;
	}
	public void setAmt_pay(String amt_pay) {
		this.amt_pay = amt_pay;
	}
	public String getName_item_en() {
		return name_item_en;
	}
	public void setName_item_en(String name_item_en) {
		this.name_item_en = name_item_en;
	}
	
}
