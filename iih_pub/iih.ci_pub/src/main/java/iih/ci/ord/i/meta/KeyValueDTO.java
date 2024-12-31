package iih.ci.ord.i.meta;

import xap.mw.core.data.BaseDTO;

/**
 * 二元键值对象类型
 * @author wangqingzhu
 *
 */
public class KeyValueDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public KeyValueDTO(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}
	
	public void setKey(String key) {
		this.setAttrVal("Key", key);
	}
	
	public String getKey() {
		return (String)this.getAttrVal("Key");
	}
	
	public void setValue(String Value) {
		this.setAttrVal("Value", Value);
	}
	
	public String getValue() {
		return (String)this.getAttrVal("Value");
	}

}
