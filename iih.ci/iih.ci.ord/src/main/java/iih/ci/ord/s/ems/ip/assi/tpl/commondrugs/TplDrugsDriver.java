package iih.ci.ord.s.ems.ip.assi.tpl.commondrugs;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplDrugsDriver extends BaseEmsDriver {
	public TplDrugsDriver(){
		this.setEmsAction(new TplDrugsAction());
	}
}
