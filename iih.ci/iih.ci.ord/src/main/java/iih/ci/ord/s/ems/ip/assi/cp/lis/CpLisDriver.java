package iih.ci.ord.s.ems.ip.assi.cp.lis;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class CpLisDriver extends BaseEmsDriver {
	
	public CpLisDriver() {
		super();
	 this.setEmsAction(new CpLisAction());
	}

}
