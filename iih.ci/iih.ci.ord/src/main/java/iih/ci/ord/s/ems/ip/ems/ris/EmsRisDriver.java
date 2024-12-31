package iih.ci.ord.s.ems.ip.ems.ris;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 检查医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsRisDriver extends BaseEmsDriver {
	public EmsRisDriver(){
		this.setEmsAction(new EmsRisAction());
	}
}
