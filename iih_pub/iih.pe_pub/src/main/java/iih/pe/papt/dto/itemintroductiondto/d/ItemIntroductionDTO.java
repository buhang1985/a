package iih.pe.papt.dto.itemintroductiondto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class ItemIntroductionDTO extends BaseDTO {

	// 项目分类
	@RPCField(id = 1)
	private String category;
	// 项目名称
	@RPCField(id = 2)
	private String item;
	// 检查意义
	@RPCField(id = 3)
	private String purpose;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}
