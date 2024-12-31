package iih.ci.ord.s.ems.op.ems.lis;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 检验医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsLisDriver extends BaseEmsDriver {

	
	public EmsLisDriver(){
		this.setEmsAction(new EmsLisAction());
//		this.setOrderAction(new OrderLisAction());
	}
	
}
