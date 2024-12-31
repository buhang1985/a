package iih.ci.sdk.ems.meta;

import java.util.ArrayList;
import java.util.Arrays;

import iih.ci.sdk.utils.ObjectUtils;

/**
 * 对象运行时类型数组
 * @author wangqingzhu
 *
 */
public class ObjectList extends ArrayList<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectList(){}
	
	public ObjectList(Object[] szObj){
		this.addAll(Arrays.asList(szObj));
	}
	
	public Object[] asArray(){
		return this.toArray(new Object[size()]);
	}

	public Object getFirstObject(){
		if (!ObjectUtils.isEmpty(this))
			return this.get(0);
		return null;
	}

}
