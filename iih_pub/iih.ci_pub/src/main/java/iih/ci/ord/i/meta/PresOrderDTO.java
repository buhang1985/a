package iih.ci.ord.i.meta;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * @author wangqingzhu
 *
 */
public class PresOrderDTO extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 扩展信息
	 * 
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}

	/**
	 * 扩展信息
	 * 
	 * @param Extension
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}

	/**
	 * 扩展信息
	 * 
	 * @return String
	 */
	public FArrayList getItemList() {
		return ((FArrayList) getAttrVal("ItemList"));
	}

	/**
	 * 扩展信息
	 * 
	 * @param Extension
	 */
	public void setItemList(FArrayList ItemList) {
		setAttrVal("ItemList", ItemList);
	}

	/**
	 * 扩展信息
	 * 
	 * @return String
	 */
	public FBoolean getFg_poisonhemp() {
		return ((FBoolean) getAttrVal("Fg_poisonhemp"));
	}

	/**
	 * 扩展信息
	 * 
	 * @param Extension
	 */
	public void setFg_poisonhemp(FBoolean Fg_poisonhemp) {
		setAttrVal("Fg_poisonhemp", Fg_poisonhemp);
	}

	/**
	 * 扩展信息
	 * 
	 * @return String
	 */
	public String getColor_poisonhemp() {
		return ((String) getAttrVal("Color_poisonhemp"));
	}

	/**
	 * 扩展信息
	 * 
	 * @param Extension
	 */
	public void setColor_poisonhemp(String Color_poisonhemp) {
		setAttrVal("Color_poisonhemp", Color_poisonhemp);
	}
}
