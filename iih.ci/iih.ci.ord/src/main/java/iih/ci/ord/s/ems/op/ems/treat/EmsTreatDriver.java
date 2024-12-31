package iih.ci.ord.s.ems.op.ems.treat;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 治疗医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsTreatDriver extends BaseEmsDriver {

	
	public EmsTreatDriver(){
		this.setEmsAction(new EmsTreatAction());
//		this.setOrderAction(new OrderTreatAction());
	}

}
