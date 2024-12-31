package iih.ci.sdk.ems.meta;
import java.util.HashMap;
/**
 * 
 * @author wangqingzhu
 *
 */
public class StringObjectMap extends HashMap<String,Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取Map的Key数组对象
	 * @return
	 */
	public String[] asKeyArray() {
		return this.keySet().toArray(new String[1]);
	}
	
	public <T extends Object> T get(String key) {
		if(this.containsKey(key) ) {
			return (T)this.get(key);
		}
		return null;
	}
}
