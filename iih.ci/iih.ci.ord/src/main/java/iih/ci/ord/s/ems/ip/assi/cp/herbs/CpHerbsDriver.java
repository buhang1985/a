package iih.ci.ord.s.ems.ip.assi.cp.herbs;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class CpHerbsDriver extends BaseEmsDriver {

	public CpHerbsDriver() {
		super();
	 this.setEmsAction(new CpHerbsAction());
	}
}
