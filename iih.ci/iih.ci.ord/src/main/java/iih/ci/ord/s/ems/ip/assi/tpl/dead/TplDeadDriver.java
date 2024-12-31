package iih.ci.ord.s.ems.ip.assi.tpl.dead;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplDeadDriver extends BaseEmsDriver {
	public TplDeadDriver(){
		this.setEmsAction(new TplDeadAction());
	}
}
