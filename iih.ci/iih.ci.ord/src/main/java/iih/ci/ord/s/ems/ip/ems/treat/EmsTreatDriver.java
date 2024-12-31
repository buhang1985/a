package iih.ci.ord.s.ems.ip.ems.treat;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class EmsTreatDriver extends BaseEmsDriver {
	public EmsTreatDriver(){
		this.setEmsAction(new EmsTreatAction());
	}

}
