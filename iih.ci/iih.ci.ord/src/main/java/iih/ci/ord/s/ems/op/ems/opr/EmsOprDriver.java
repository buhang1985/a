package iih.ci.ord.s.ems.op.ems.opr;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 手术医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsOprDriver extends BaseEmsDriver{
	
	
	public EmsOprDriver(){
		this.setEmsAction(new EmsOprAction());
//		this.setOrderAction(new OrderOprAction());
	}
	
}
