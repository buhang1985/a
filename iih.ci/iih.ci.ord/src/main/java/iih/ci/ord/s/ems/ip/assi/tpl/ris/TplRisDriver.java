package iih.ci.ord.s.ems.ip.assi.tpl.ris;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplRisDriver extends BaseEmsDriver {
	public TplRisDriver(){
		this.setEmsAction(new TplRisAction());
	}
}
