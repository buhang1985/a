package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE检验结果查询输出DTO DTO数据 
 * 
 */
public class IELisQryOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreate_time() {
		return ((FDateTime) getAttrVal("Create_time"));
	}
	/**
	 * 创建时间
	 * @param Create_time
	 */
	public void setCreate_time(FDateTime Create_time) {
		setAttrVal("Create_time", Create_time);
	}
	/**
	 * 子数据
	 * @return FArrayList
	 */
	public FArrayList2 getItems() {
		return ((FArrayList2) getAttrVal("Items"));
	}
	/**
	 * 子数据
	 * @param Items
	 */
	public void setItems(FArrayList2 Items) {
		setAttrVal("Items", Items);
	}
}