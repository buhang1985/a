package iih.ci.ord.s.ems.ip.ems.commondrugs;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 医疗单驱动
 * @author wangqingzhu
 *
 */
public class EmsCommonDrugsDriver extends BaseEmsDriver {
	
	public EmsCommonDrugsDriver() {
		this.setEmsAction(new EmsCommonDrugsAction());
	}
	
}
