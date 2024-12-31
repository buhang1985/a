package iih.ci.sdk.ems.meta;

import java.util.ArrayList;

import iih.ci.ems.b.BaseOrderListViewDTO;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.FArrayList;

/**
 * @author wangqingzhu
 *
 * @date 2019年9月19日下午2:40:30
 *
 * @classpath iih.ci.sdk.ems.meta.OrderFeeListViewInfoList
 *
 * 住院费用数据信息列表
 * 
 */
public class IpOrderFeeListViewInfoList extends ArrayList<BaseOrderListViewDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public IpOrderFeeListViewInfoList() {}
	
	public IpOrderFeeListViewInfoList(FArrayList c) {
		if(!ObjectUtils.isEmpty(c) && c.get(0) instanceof BaseOrderListViewDTO) {
			this.addAll(c);
		}
	}
	
	public FArrayList asFArrayList() {
		FArrayList c = new FArrayList();
		c.addAll(this);
		return c;
	}
}
