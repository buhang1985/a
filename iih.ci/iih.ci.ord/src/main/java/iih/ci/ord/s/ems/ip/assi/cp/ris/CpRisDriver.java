package iih.ci.ord.s.ems.ip.assi.cp.ris;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

/**
 * 
 *
 */
public class CpRisDriver extends BaseEmsDriver {
	
	public CpRisDriver() {
		super();
	 this.setEmsAction(new CpRisAction());
	}


}
