package iih.ci.sdk.ems.meta;

import java.util.HashMap;

/**
 * 字符串字典
 * @author wangqingzhu
 *
 */
public class StringMap extends HashMap<String,String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 将Key转化为字符串数组
	 * @return
	 */
	public String[] asKeyArray() {
		return this.keySet().toArray(new String[1]);
	}
	
	public String getStr(String key) {
		return this.get(key).toString();
	}
}
