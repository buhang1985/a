package iih.ci.ord.s.ems.meta;

import java.util.ArrayList;

/**
 * 医疗单保存数据库返回值列表
 * @author wangqingzhu
 *
 */
public class OrderSavedRstInfoList extends ArrayList<OrderSavedRstInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public OrderSavedRstInfo[] asArray(){
		return this.toArray(new OrderSavedRstInfo[size()]);
	}

}
