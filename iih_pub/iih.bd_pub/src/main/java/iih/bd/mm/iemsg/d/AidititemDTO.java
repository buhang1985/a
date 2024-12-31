package iih.bd.mm.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class AidititemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据库名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 数据库名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 子数据
	 * @return FArrayList2
	 */
	public FArrayList2 getItem() {
		return ((FArrayList2) getAttrVal("Item"));
	}
	/**
	 * 子数据
	 * @param Item
	 */
	public void setItem(FArrayList2 Item) {
		setAttrVal("Item", Item);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMessagetype() {
		return ((String) getAttrVal("Messagetype"));
	}
	/**
	 * 消息类型
	 * @param Messagetype
	 */
	public void setMessagetype(String Messagetype) {
		setAttrVal("Messagetype", Messagetype);
	}
}