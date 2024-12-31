package iih.ci.ord.s.ems.ip.ems.herbs;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 草药医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsHerbsDriver extends BaseEmsDriver {
	
	public EmsHerbsDriver() {
		this.setEmsAction(new EmsHerbsAction());
	}
	
}
