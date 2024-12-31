package iih.ci.ord.s.ems.ip.assi.tpl.icons;

import iih.ci.ord.s.ems.base.BaseEmsDriver;

public class TplIConsDriver extends BaseEmsDriver {
	public TplIConsDriver(){
		this.setEmsAction(new TplIConsAction());
	}
}
