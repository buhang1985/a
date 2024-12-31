package iih.ci.ord.s.ems.ip.assi.tpl.treat;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplTreatDriver extends BaseEmsDriver {
	public TplTreatDriver(){
		this.setEmsAction(new TplTreatAction());
	}
}
