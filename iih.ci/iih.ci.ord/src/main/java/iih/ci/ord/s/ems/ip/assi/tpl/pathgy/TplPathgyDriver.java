package iih.ci.ord.s.ems.ip.assi.tpl.pathgy;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplPathgyDriver extends BaseEmsDriver {
	public TplPathgyDriver(){
		this.setEmsAction(new TplPathgyAction());
	}
}
