package iih.ci.ord.s.ems.op.ems.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 病理医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsPathgyDriver extends BaseEmsDriver {

	
	public EmsPathgyDriver(){
		this.setEmsAction(new EmsPathgyAction());
//		this.setOrderAction(new OrderPathgyAction());
	}
	
}
