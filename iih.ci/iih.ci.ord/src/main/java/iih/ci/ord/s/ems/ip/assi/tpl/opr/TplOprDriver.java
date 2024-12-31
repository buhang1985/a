package iih.ci.ord.s.ems.ip.assi.tpl.opr;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplOprDriver extends BaseEmsDriver {
	public TplOprDriver(){
		this.setEmsAction(new TplOprAction());
	}
}
