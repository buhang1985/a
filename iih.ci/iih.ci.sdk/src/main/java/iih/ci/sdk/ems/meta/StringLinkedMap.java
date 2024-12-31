package iih.ci.sdk.ems.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 字符串链表映射关系
 * 
 * @author wangqingzhu
 *
 * @param <T>
 */
public class StringLinkedMap<T> extends HashMap<String, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> keyList = new ArrayList<String>();

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
		this.keyList.clear();
	}

	@Override
	public T put(String arg0, T arg1) {
		// TODO Auto-generated method stub
		this.keyList.add(arg0);
		return super.put(arg0, arg1);
	}

	@Override
	public T remove(Object arg0) {
		// TODO Auto-generated method stub
		if (this.keyList.contains(arg0)) {
			this.keyList.remove(arg0);
		}

		return super.remove(arg0);
	}

	@Override
	public Collection<T> values() {
		// TODO Auto-generated method stub
		List<T> rst = new ArrayList<T>();
		for (String key : keyList) {
			rst.add(this.get(key));
		}
		return rst;
	}

}
